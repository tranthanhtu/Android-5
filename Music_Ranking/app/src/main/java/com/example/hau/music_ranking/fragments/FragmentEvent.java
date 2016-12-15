package com.example.hau.music_ranking.fragments;

import android.support.v4.app.Fragment;

import com.example.hau.music_ranking.models.Genres;

/**
 * Created by Hau on 29/11/2016.
 */
public class FragmentEvent {
    private Fragment fragment;
    private boolean addToBackStack;
    private Genres genres;

    public FragmentEvent(Fragment fragment, boolean addToBackStack, Genres genres) {
        this.fragment = fragment;
        this.addToBackStack = addToBackStack;
        this.genres = genres;
    }

    public Genres getGenres() {
        return genres;
    }

    public FragmentEvent(Fragment fragment, boolean addToBackStack) {
        this.fragment = fragment;
        this.addToBackStack = addToBackStack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public boolean isAddToBackStack() {
        return addToBackStack;
    }
}
