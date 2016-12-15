package com.example.hau.music_ranking.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.hau.music_ranking.fragments.GenresFragment;
import com.example.hau.music_ranking.fragments.OfflineFragment;
import com.example.hau.music_ranking.fragments.PlaylistFragment;

/**
 * Created by Hau on 26/11/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter{
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                GenresFragment genresFragment = new GenresFragment();
                return genresFragment;
            case 1:
                PlaylistFragment playlistFragment = new PlaylistFragment();
                return playlistFragment;
            case 2:
                OfflineFragment offlineFragment = new OfflineFragment();
                return offlineFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
