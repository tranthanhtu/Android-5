package com.example.tu.homeworkss15_daily_quote;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hau.homeworkss15_daily_quote.R;
import com.example.tu.homeworkss15_daily_quote.fragments.LoginFragment;
import com.example.tu.homeworkss15_daily_quote.fragments.QuoteFragment;
import com.example.tu.homeworkss15_daily_quote.managers.DbContextRealm;
import com.example.tu.homeworkss15_daily_quote.managers.NetworkManger;
import com.example.tu.homeworkss15_daily_quote.managers.Preferrences;
import com.example.tu.homeworkss15_daily_quote.models.FragmentEvent;
import com.example.tu.homeworkss15_daily_quote.services.UnplashDownloadService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
        if (Preferrences.getInstance().getUsername() == null) {
            changeFragment(new LoginFragment(), false);
        } else {
            changeFragment(new QuoteFragment(), false);
        }
        if (NetworkManger.getInstance().isConnectedToInternet()) {
            Intent intent = new Intent(this, UnplashDownloadService.class);
            startService(intent);
            Log.d(TAG, "startService");
        } else {
            Log.d(TAG, String.format("SizeImage = %s", DbContextRealm.getInstance().getSizeImage()));
        }
    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent) {
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
    }

    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
