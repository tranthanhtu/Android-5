package com.merrychrismartvoyeu2016.merrychristmas;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity {
    ImageView imvbackground;
    MediaPlayer song;
    ImageView imvWife;
    TextView tvtitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initImageLoader();
        getReferences();

//        ImageLoader.getInstance().displayImage("https://source.unsplash.com/user/erondu/600x800", imvbackground);


        setupUI();

        addListeners();

        animation();


    }

    private void setupUI() {



        imvbackground.setImageResource(R.drawable.background);
        song = MediaPlayer.create(getApplicationContext(), R.raw.beautifulinwhite);
        song.start();

        Animation f = AnimationUtils.loadAnimation(this, R.anim.fade);
        f.reset();
        imvWife.clearAnimation();
        imvWife.startAnimation(f);
    }

    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }

    private void getReferences() {
        imvbackground = (ImageView) findViewById(R.id.imv_background);
        imvWife = (ImageView) findViewById(R.id.imvWife);
        tvtitle = (TextView) findViewById(R.id.tv_title);
    }

    private void addListeners() {
        imvWife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                Intent intentMusic = new Intent(getApplicationContext(), Music.class);
                startActivity(intentMusic);
            }
        });
    }

    public void animation(){
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        zoom.reset();
        tvtitle.clearAnimation();
        tvtitle.startAnimation(zoom);

    }

    @Override
    protected void onRestart() {
        song.stop();
        super.onRestart();
    }

    @Override
    public void onBackPressed() {
        song.stop();
        super.onBackPressed();
    }
}
