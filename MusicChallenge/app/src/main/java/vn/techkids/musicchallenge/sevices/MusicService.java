package vn.techkids.musicchallenge.sevices;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.techkids.musicchallenge.models.Song;

/**
 * Created by Dell latitude E6520 on 11/13/2016.
 */

public interface MusicService {
    @GET("api/songs/")
    Call<List<Song>> listsong();


}
