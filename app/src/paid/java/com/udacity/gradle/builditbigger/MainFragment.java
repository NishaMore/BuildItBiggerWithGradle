package com.udacity.gradle.builditbigger;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private ProgressBar mProgressBar;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button) root.findViewById(R.id.tellJokeBtn);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                new FetchJoke(getContext()).execute();
            }
        });

        return root;

    }
    @Override
    public void onPause() {
        mProgressBar.setVisibility(View.GONE);
        super.onPause();
    }

}
