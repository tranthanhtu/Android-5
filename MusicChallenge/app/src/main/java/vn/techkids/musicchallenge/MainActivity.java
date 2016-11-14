package vn.techkids.musicchallenge;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.extractor.ExtractorSampleSource;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DefaultAllocator;
import com.google.android.exoplayer.upstream.DefaultUriDataSource;
import com.google.android.exoplayer.util.Util;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import vn.techkids.musicchallenge.adapters.SongAdapter;
import vn.techkids.musicchallenge.managers.FileDownload;
import vn.techkids.musicchallenge.managers.NetworkManager;
import vn.techkids.musicchallenge.managers.RealmHelper;
import vn.techkids.musicchallenge.models.Song;
import vn.techkids.musicchallenge.sevices.MusicService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    ListView lvSong;
    SongAdapter adapter;
    private static final int BUFFER_SEGMENT_SIZE = 64 * 1024;
    private static final int BUFFER_SEGMENT_COUNT = 256;
    private MediaCodecAudioTrackRenderer audioRenderer;
    private ExoPlayer player;
    ImageView ivPre;
    ImageView ivPlay;
    ImageView ivNext;
    boolean isPlaying;
    int position;
    List<Song> listSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkManager.init(this);
        RealmHelper.init(this);

        lvSong = (ListView) findViewById(R.id.lv_song);
        if (NetworkManager.getInstance().isConnectedToInternet()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://music-challlenge.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            MusicService musicService = retrofit.create(MusicService.class);
            musicService.listsong().enqueue(new Callback<List<Song>>() {
                @Override
                public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                    listSong = (ArrayList<Song>) response.body();
                    Log.d(TAG, "onResponse");
                    updateUI();
                }

                @Override
                public void onFailure(Call<List<Song>> call, Throwable t) {
                    Log.d(TAG, "onFailure");

                }
            });
        } else {
            listSong = RealmHelper.getInstance().getListSong();
            adapter = new SongAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listSong);
            lvSong.setAdapter(adapter);
            Log.d(TAG, String.format("size: %s", listSong.size()));
        }

        FileDownload fileDownload = new FileDownload();
        fileDownload.execute(listSong.get(0).getLinkStream());

        ivNext = (ImageView) findViewById(R.id.iv_next);
        ivPlay = (ImageView) findViewById(R.id.iv_play);
        ivPre = (ImageView) findViewById(R.id.iv_pre);
        addListener();
//        adapter = new SongAdapter(this, android.R.layout.simple_list_item_1, listSong);
//        lvSong.setAdapter(adapter);
//        play("http://api.mp3.zing.vn/api/mobile/source/song/LGJGTLGNVEDLVAGTLDJTDGLG");
        player = ExoPlayer.Factory.newInstance(1);
        lvSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                player.seekTo(0);
                MainActivity.this.position = position;
                ivPlay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                player.stop();
                play(listSong.get(position).getLinkStream());
                //player.release();
                isPlaying = true;
            }
        });

    }

    private void updateUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter = new SongAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listSong);
                lvSong.setAdapter(adapter);
                RealmHelper.getInstance().addList(listSong);
            }
        });
    }

    private void addListener() {
        ivPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = (position == 0) ? listSong.size() - 1 : position - 1;
                player.seekTo(0);

                ivPlay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                player.stop();
                play(listSong.get(position).getLinkStream());
                //player.release();
                isPlaying = true;
            }
        });
        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    isPlaying = false;
                    ivPlay.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
                    player.setPlayWhenReady(false);
                } else {
                    ivPlay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);

                    player.setPlayWhenReady(true);
                    isPlaying = true;

                }

            }
        });
        ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = (position == listSong.size() - 1) ? 0 : position + 1;
                player.seekTo(0);

                ivPlay.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
                player.stop();
                play(listSong.get(position).getLinkStream());
                //player.release();
                isPlaying = true;
            }
        });
    }

    void play(String url) {
        // 1. Instantiate the player.

// String with the url of the radio you want to play
        Uri radioUri = Uri.parse(url);
// Settings for exoPlayer
        Allocator allocator = new DefaultAllocator(BUFFER_SEGMENT_SIZE);
        String userAgent = Util.getUserAgent(this, "ExoPlayerDemo");
        DataSource dataSource = new DefaultUriDataSource(this, null, userAgent);
        ExtractorSampleSource sampleSource = new ExtractorSampleSource(
                radioUri, dataSource, allocator, BUFFER_SEGMENT_SIZE * BUFFER_SEGMENT_COUNT);
        audioRenderer = new MediaCodecAudioTrackRenderer(sampleSource);
// Prepare ExoPlayer
        player.prepare(audioRenderer);
        player.setPlayWhenReady(true);
        Log.d(TAG, "play" + player.getPlayWhenReady());
    }
}
