package com.example.delllatitudee6520.eventbus;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.delllatitudee6520.myapplication.SimpleFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OpenFragmentListener{
    @BindView(R.id.tv_simple) TextView tv_simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupUI();

        openSimpleFragment();
    }

    private void openSimpleFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, new SimpleFragment())
                .addToBackStack("SimpleFragment")
                .commit();
    }

    private void changeFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment)
                .addToBackStack("SimpleFragment")
                .commit();
    }

    private void setupUI() {
        tv_simple.setText("Welcom to Android 5");
    }

    @Override
    public void openFragment(Fragment fragment) {
        changeFragment(fragment);
    }
}
