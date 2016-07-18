package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;



public class MainFragment extends Fragment {


    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private ProgressBar mProgressBar;
    private String joke;
    private static final String JOKE_EXTRA = "joke_extra";

    public MainFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.GONE);
        mAdView = (AdView) root.findViewById(R.id.adView);
        showBannerAd();

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        requestNewInterstitial();
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                mProgressBar.setVisibility(View.VISIBLE);
                new FetchJoke(getContext()).execute();

            }
        });
        Button button = (Button) root.findViewById(R.id.tellJokeBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstialAds();
            }
        });

        return root;
    }

    private void showInterstialAds() {


        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            //requestNewInterstitial();
            mProgressBar.setVisibility(View.VISIBLE);
            new FetchJoke(getContext()).execute();
        }


    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    private void showBannerAd() {

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public void onPause() {

        super.onPause();
        mProgressBar.setVisibility(View.GONE);
    }
}