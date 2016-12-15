package com.example.hau.music_ranking.networks;

import com.example.hau.music_ranking.json_models.MediaJSON;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hau on 26/11/2016.
 */
public interface MediaService {
    @GET("/data/media-types.json")
    Call<List<MediaJSON>> listMedias();
}
