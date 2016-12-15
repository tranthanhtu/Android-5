package com.example.hau.music_ranking;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.example.hau.music_ranking.fragments.FragmentEvent;
import com.example.hau.music_ranking.fragments.HomeFragment;
import com.example.hau.music_ranking.fragments.TopSongClass;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.sb_play)
    SeekBar sbPlay;
    @BindView(R.id.v_play)
    View viewPlay;
    @BindView(R.id.rl_play)
    RelativeLayout rlPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        changeFragment(new HomeFragment(), true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    private void changeFragment(Fragment fragment, boolean addToBackStack) {
        Log.d(TAG, "change");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(FragmentEvent fragmentEvent) {
        Log.d(TAG, "onEvent");
        Log.d(TAG, fragmentEvent.getFragment().toString());
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(TopSongClass topSongClass){
        rlPlay.setVisibility(View.VISIBLE);
    }
}
