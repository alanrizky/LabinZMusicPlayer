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
public class PlayerActivityFragment extends Fragment {

    private  OnFragmentInteractionListener mListener;

    private ImageView back;

    public PlayerActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_player_activity, container, false);
        back = view.findViewById(R.id.fragmentPlayerActivity_backButton);
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(mListener != null) {
                    mListener.onBackClicked(view);
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
        void onBackClicked(View view);
    }
}
