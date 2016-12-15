package vn.tranthanhtu.testretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dell latitude E6520 on 12/9/2016.
 */

public interface ZingService {
    @GET("/api/mobile/search/song?requestdata={\"q\":\"hello adele\", \"sort\":\"hot\", \"start\":\"0\", \"length\":\"10\"}\n")
    Call<Docs> callDocs();

    class Docs {
        @SerializedName("docs")
        private List<SongInfo> songInfoList;

        public List<SongInfo> getSongInfoList() {
            return songInfoList;
        }
    }

    class SongInfo {
        @SerializedName("genre")
        private String genre;
        @SerializedName("link_download")
        private Quality quality;

        public Quality getQuality() {
            return quality;
        }

        public String getGenre() {
            return genre;
        }
    }

    class Quality {
        @SerializedName("128")
        private String lost;

        public String getLost() {
            return lost;
        }
    }
}
