package com.example.delllatitudee6520.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.imvTop1) ImageView imgTop1;
    @BindView(R.id.imvTop2) ImageView imgTop2;
    @BindView(R.id.imvTop3) ImageView imgTop3;
    @BindView(R.id.imvTop4) ImageView imgTop4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupUI();
    }

    private void setupUI() {
        imgTop1.setImageResource(R.drawable.homeshape);
        imgTop2.setImageResource(R.drawable.homeshape);
        imgTop3.setImageResource(R.drawable.alarmshape);
        imgTop4.setImageResource(R.drawable.personshape);
    }
}
