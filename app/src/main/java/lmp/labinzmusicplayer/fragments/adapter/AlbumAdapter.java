package lmp.labinzmusicplayer.fragments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import lmp.labinzmusicplayer.R;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Album> mAlbums;


    public AlbumAdapter(Context context, List<Album> albums){
        mContext = context;
        mAlbums = albums;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Album albumCurrent = mAlbums.get(position);
        Glide.with(mContext).load(albumCurrent.getAlbum_url()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return (mAlbums == null) ? mAlbums.size() : 6;
    }



    public class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public ImageViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.row_logo_album);
        }
    }
}
