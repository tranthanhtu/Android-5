package com.example.delllatitudee6520.homework6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.imgTop) ImageView imgTop;
    @BindView(R.id.imgCentre1) ImageView imgCentre1;
    @BindView(R.id.imgCentre2) ImageView imgCentre2;
    @BindView(R.id.imgLargeLeft) ImageView imgLargeLeft;
    @BindView(R.id.imgLargeRight) ImageView imgLargeRight;
    @BindView(R.id.imgSmallBottom1) ImageView imgSmaillBottom1;
    @BindView(R.id.imgSmallBottom2) ImageView imgSmaillBottom2;
    @BindView(R.id.imgSmallBottom3) ImageView imgSmaillBottom3;
    @BindView(R.id.imgSmallBottom4) ImageView imgSmaillBottom4;
    @BindView(R.id.imgSmallBottom5) ImageView imgSmaillBottom5;
    @BindView(R.id.imgRecently1) ImageView imgRecently1;
    @BindView(R.id.imgRecently2) ImageView imgRecently2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
        imgTop.setImageResource(R.drawable.ovalavatar);
        imgCentre1.setImageResource(R.drawable.bitmap3);
        imgCentre2.setImageResource(R.drawable.bitmap2);
        imgLargeLeft.setImageResource(R.drawable.bitmap4);
        imgLargeRight.setImageResource(R.drawable.bitmap7);
        imgSmaillBottom1.setImageResource(R.drawable.bitmap1);
        imgSmaillBottom2.setImageResource(R.drawable.bitmap1);
        imgSmaillBottom3.setImageResource(R.drawable.bitmap8);
        imgSmaillBottom4.setImageResource(R.drawable.bitmap6);
        imgSmaillBottom5.setImageResource(R.drawable.playicongroup);
        imgRecently1.setImageResource(R.drawable.bitmap11);
        imgRecently2.setImageResource(R.drawable.bitmap12);

    }
}
