package com.example.hau.music_ranking.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.hau.music_ranking.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.toString();
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_pager)
    ViewPager vpPager;
    PagerAdapter pagerAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        setupUI();
        addListeners();
    }

    private void setupUI() {
        Log.d(TAG, getFragmentManager().getBackStackEntryCount() + "");
        tabLayout.addTab(tabLayout.newTab().setText("GENRES"));
        tabLayout.addTab(tabLayout.newTab().setText("PLAYLIST"));
        tabLayout.addTab(tabLayout.newTab().setText("OFFLINE"));
        tabLayout.setTabTextColors(Color.BLACK, Color.WHITE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        pagerAdapter = new com.example.hau.music_ranking.adapters.PagerAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        vpPager.setAdapter(pagerAdapter);
    }


    private void addListeners() {
        vpPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
