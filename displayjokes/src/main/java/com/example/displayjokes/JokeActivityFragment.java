package com.example.displayjokes;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {
    private static final String JOKE_EXTRA = "joke_extra";

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_joke, container, false);
        View root = inflater.inflate(R.layout.fragment_joke, container, false);


        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JOKE_EXTRA);

        TextView textView = (TextView) root.findViewById(R.id.jokeTv);
        textView.setText(joke);

        return root;
    }
}
