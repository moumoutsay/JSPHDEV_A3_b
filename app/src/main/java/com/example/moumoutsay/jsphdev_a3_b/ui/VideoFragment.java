package com.example.moumoutsay.jsphdev_a3_b.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import com.example.moumoutsay.jsphdev_a3_b.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class VideoFragment extends Fragment implements View.OnClickListener {

    private VideoView v1;
    private VideoView v2;
    public VideoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);
        Button button1 = (Button) rootView.findViewById(R.id.button1);
        Button button2 = (Button) rootView.findViewById(R.id.button2);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        v1 = (VideoView) rootView.findViewById(R.id.videoView1);
        v2 = (VideoView) rootView.findViewById(R.id.videoView2);
        v1.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.v1));
        v2.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.v2));

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                playVideo(1);
                break;
            case R.id.button2:
                playVideo(2);
                break;
        }
    }

    private void playVideo(int i) {
        if ( i < 0 || i > 2) { return; }
        if (i == 1) {
            v1.start();
        }
        if (i == 2) {
            v2.start();
        }

    }


}
