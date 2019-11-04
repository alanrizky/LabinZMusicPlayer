package lmp.labinzmusicplayer.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lmp.labinzmusicplayer.R;
import lmp.labinzmusicplayer.fragments.adapter.Album;
import lmp.labinzmusicplayer.fragments.adapter.AlbumAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongListFragment extends Fragment {

    private View albumView;
    private RecyclerView recyclerView;
    private DatabaseReference mRef;
    private List<Album> albumList;
    AlbumAdapter albumAdapter;
    public SongListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        albumView = inflater.inflate(R.layout.fragment_song_list, container, false);
        recyclerView = albumView.findViewById(R.id.fragmentSongList_recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        mRef = FirebaseDatabase.getInstance().getReference("album");

        return albumView;
    }


    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<Album>()
                .setQuery(mRef, Album.class)
                .build();

        albumList = new ArrayList<>();

        FirebaseRecyclerAdapter<Album, AlbumHolder> adapter
                = new FirebaseRecyclerAdapter<Album, AlbumHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final AlbumHolder holder, final int position, @NonNull Album model) {

                mRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                            Album albumUrlnya = postSnapshot.getValue(Album.class);
                            albumList.add(albumUrlnya);
//                            String albumUrl = albumUrlnya.getAlbum_url();

//                            Glide.with(getContext()).load(albumUrl).into(holder.imageView);
                        }
                        albumAdapter = new AlbumAdapter(getActivity(), albumList);
                        recyclerView.setAdapter(albumAdapter);

//                        if(dataSnapshot.hasChild("album_url")) {
//                            String albumUrl = dataSnapshot.child("album_url").getValue().toString();
////                            Picasso.get().load(albumUrl).placeholder(R.drawable.loading).into(holder.imageView);
//                            Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/labinz-music-player.appspot.com/o/logo_a.png?alt=media&token=7b684a98-3fb3-47c6-b8d1-9fecbbb2107b").into(holder.imageView);
//                        }
//                        else {
//                            Toast.makeText(getContext(), "Salah", Toast.LENGTH_SHORT).show();
//                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @NonNull
            @Override
            public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
                AlbumHolder viewHolder = new AlbumHolder(view);
                return viewHolder;
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    public static class AlbumHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public AlbumHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.row_logo_album);
        }
    }
}
