package vn.tranthanhtu.testretrofit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getDataFromAPI();
        getSongInfoFromAPI();

    }

    private void getSongInfoFromAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.mp3.zing.vn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        ZingService service = retrofit.create(ZingService.class);
        
        service.callDocs().enqueue(new Callback<ZingService.Docs>() {
            @Override
            public void onResponse(Call<ZingService.Docs> call, Response<ZingService.Docs> response) {
                Log.d(TAG, "onResponse: ");
                ZingService.Docs docs = response.body();
                Log.d(TAG, "" + docs.getSongInfoList());
                for (ZingService.SongInfo songInfo : docs.getSongInfoList()){
                    Log.d(TAG, songInfo.getQuality().getLost());

                }
            }

            @Override
            public void onFailure(Call<ZingService.Docs> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void getDataFromAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rss.itunes.apple.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        MediaService service = retrofit.create(MediaService.class);
        
        service.listGenres().enqueue(new Callback<List<MediaService.SubGenres>>() {
            @Override
            public void onResponse(Call<List<MediaService.SubGenres>> call, Response<List<MediaService.SubGenres>> response) {
                Log.d(TAG, "onResponse: ");
                List<MediaService.SubGenres> subGenres = response.body();
                for (MediaService.SubGenres subgenres : subGenres){
                    Log.d(TAG, subgenres.getKey());
                }
            }

            @Override
            public void onFailure(Call<List<MediaService.SubGenres>> call, Throwable t) {
                Log.d(TAG, "onFailure: ");

            }
        });
    }


}

