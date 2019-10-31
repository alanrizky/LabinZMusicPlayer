package lmp.labinzmusicplayer.fragments.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lmp.labinzmusicplayer.R;
import lmp.labinzmusicplayer.SongInfo;
import lmp.labinzmusicplayer.fragments.ArtistSongFragment;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.Adapter> {
    List<SongInfo> songList;
    View songView;

    public SongAdapter(List<SongInfo> songList) {
        this.songList = songList;
    }

    @NonNull
    @Override
    public SongAdapter.Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        songView = layoutInflater.inflate(R.layout.song_item, parent, false);
        Adapter viewHolder = new Adapter(songView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter holder, int position) {
        SongInfo song = songList.get(position);
        holder.bandName.setText(song.getBandName());
        holder.songName.setText(song.getSongName());
    }

    @Override
    public int getItemCount() {
        return (songList != null) ? songList.size() : 0;
    }

    public class Adapter extends RecyclerView.ViewHolder {
        public TextView songName;
        public TextView bandName;
        public Adapter(@NonNull View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.songName);
            bandName = itemView.findViewById(R.id.bandName);
        }
    }
    public interface OnSongClick {
        void OnItemClickListener(int position);
    }
}
