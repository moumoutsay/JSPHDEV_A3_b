package com.example.moumoutsay.jsphdev_a3_b.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moumoutsay.jsphdev_a3_b.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContentFragment extends Fragment {

    public ContentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_content, container, false);
        return rootView;
    }
}
