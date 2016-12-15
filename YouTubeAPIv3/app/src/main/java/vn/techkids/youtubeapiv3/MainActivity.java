package vn.techkids.youtubeapiv3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    String API_KEY = "AIzaSyBzTv7ceUHJEHRjXDB2HjUpWxMjgBFNFbM";
    private static final String TAG =  MainActivity.class.toString();

//    EditText edtID;
    Button btnPlay;
    YouTubePlayerView youTubePlayerView;
    ListView lvPlaylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getReferences();
        setupUI();
        addListener();


    }

    private void setupUI() {
        Adapter adapter = new Adapter(
                this,
                R.layout.list_video,
                Connection.getInstance().getArrayList()
        );
        lvPlaylist.setAdapter(adapter);
    }

    private void getReferences() {
//        edtID = (EditText) findViewById(R.id.editTextIdVideo);
        btnPlay = (Button) findViewById(R.id.buttonPlay);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube);
        lvPlaylist = (ListView) findViewById(R.id.lv_playlist);
    }

    private void addListener() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(API_KEY, MainActivity.this);
            }
        });



    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo("pdSZzBqILY4");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(MainActivity.this, -1);
        }else {
            Toast.makeText(this, "Video error", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == -1){
            youTubePlayerView.initialize(API_KEY, this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
