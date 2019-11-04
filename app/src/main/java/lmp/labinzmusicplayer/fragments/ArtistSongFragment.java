package lmp.labinzmusicplayer.fragments;


import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import lmp.labinzmusicplayer.R;
//import lmp.labinzmusicplayer.SongInfo;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistSongFragment extends Fragment {

    private RecyclerView rvSong;
    private OnFragmentInteractionListener mListener;
    private PlayerActivityFragment playerActivity;
    private TextView filename;
//    private ArrayList<SongInfo> song = new ArrayList<>();


    public ArtistSongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artist_song, container, false);
        filename = view.findViewById(R.id.fragmentArtistSong_musicFileName);
        playerActivity = new PlayerActivityFragment();
        filename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/labinz-music-player.appspot.com/o/04%20-%20Second%20Heartbeat.mp3?alt=media&token=b10e1002-0de0-4e74-acc6-794775eea441");
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(mListener != null) {
                    mListener.onFileNameFragmentClicked(view);
                }
            }
        });
        return view;
    }

    public void playSong(View v) {

    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener {
        public void onFileNameFragmentClicked(View view);
    }

    public interface OnItemClickListener {
//        void onItem(SongInfo item);
    }
}
