package com.example.moumoutsay.jsphdev_a3_b.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moumoutsay.jsphdev_a3_b.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContactInfoFragment extends Fragment implements View.OnClickListener {

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


        ImageView img = (ImageView)rootView.findViewById(R.id.fb_logo);
        img.setClickable(true);
        img.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_logo:
                goToFB();
                break;
        }
    }

    public void goToFB() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.facebook.com/patrickstar"));
        startActivity(intent);
    }

}
