package com.example.moumoutsay.jsphdev_a3_b.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.moumoutsay.jsphdev_a3_b.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContentFragment extends Fragment implements View.OnClickListener {

    public ContentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content, container, false);

        Button buttonSong = (Button) rootView.findViewById(R.id.buttonSong);
        Button buttonVideo = (Button) rootView.findViewById(R.id.buttonVideo);
        Button buttonWallPaper = (Button) rootView.findViewById(R.id.buttonWallPaper);
        Button buttonGetOnMailList = (Button) rootView.findViewById(R.id.buttonGotOnMail);

        buttonSong.setOnClickListener(this);
        buttonVideo.setOnClickListener(this);
        buttonWallPaper.setOnClickListener(this);
        buttonGetOnMailList.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonGotOnMail:
                // TODO
                break;
            case R.id.buttonSong:
                startActivity(new Intent(getActivity(),SongActivity.class));
                break;
            case R.id.buttonVideo:
                startActivity(new Intent(getActivity(),VideoActivity.class));
                break;
            case R.id.buttonWallPaper:
                startActivity(new Intent(getActivity(),WallPaperActivity.class));
                break;
        }
    }
}
