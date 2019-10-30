package lmp.labinzmusicplayer.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import lmp.labinzmusicplayer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private ImageView bandLogo;
    private ImageView setting;

    public SongListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_song_list, container, false);
        bandLogo = view.findViewById(R.id.fragmentSongList_logo_a);
        bandLogo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(mListener != null) {
                    mListener.onSongListFragmentClicked(view);
                }
            }
        });
        setting = view.findViewById(R.id.fragmentSongList_setting);
        setting.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(mListener != null) {
                    mListener.onSettingFragmentClicked(view);
                }
            }
        });
        return view;
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
        void onSongListFragmentClicked(View view);
        void onSettingFragmentClicked(View view);
    }
}
