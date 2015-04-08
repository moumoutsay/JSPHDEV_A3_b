package com.example.moumoutsay.jsphdev_a3_b.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moumoutsay.jsphdev_a3_b.R;

import java.util.regex.Pattern;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContactInfoFragment extends Fragment implements View.OnClickListener {
    final static String LOG_TAG =  ContactInfoFragment.class.getSimpleName();

    public ContactInfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact_info, container, false);

        // set hyper link for home page
        TextView textView =(TextView)rootView.findViewById(R.id.textHomePage);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://spongebob.wikia.com/wiki/Patrick_Star'> Home Page </a>";
        textView.setText(Html.fromHtml(text));

        // set click listener to facebook icon
        ImageView img_fb = (ImageView)rootView.findViewById(R.id.fb_logo);
        img_fb.setClickable(true);
        img_fb.setOnClickListener(this);

        // set for mail setting
        Pattern p = Pattern.compile("moumoutsay@gmail.com");
        String Scheme = "mailto:";
        Linkify.addLinks((TextView) rootView.findViewById(R.id.textMail), p, Scheme);

        // set click listener to like dislike
        ImageView img_like = (ImageView)rootView.findViewById(R.id.img_like);
        img_like.setClickable(true);
        img_like.setOnClickListener(this);
        ImageView img_dislike = (ImageView)rootView.findViewById(R.id.img_dislike);
        img_dislike.setClickable(true);
        img_dislike.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_logo:
                goToFB();
                break;
            case R.id.img_dislike:
                incrDisLike();
                break;
            case R.id.img_like:
                incrLike();
                break;
        }
    }

    private void goToFB() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.facebook.com/patrickstar"));
        startActivity(intent);
    }

    private void incrDisLike() {
        try {
            TextView tv = (TextView) getActivity().findViewById(R.id.text_dislike_cnt);
            int cnt = Integer.parseInt(tv.getText().toString());
            ++cnt;
            tv.setText(Integer.toString(cnt));
        } catch ( Exception e) {
            Log.e(LOG_TAG, "Error in incrDisLike()" + e.toString());
        }
    }
    private void incrLike() {
        try {
            TextView tv = (TextView) getActivity().findViewById(R.id.text_like_cnt);
            int cnt = Integer.parseInt(tv.getText().toString());
            ++cnt;
            tv.setText(Integer.toString(cnt));
        } catch ( Exception e) {
            Log.e(LOG_TAG, "Error in incrLike()" + e.toString());
        }
    }
}
