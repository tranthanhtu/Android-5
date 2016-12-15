package vn.tranthanhtu.testretrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dell latitude E6520 on 12/9/2016.
 */

public interface MediaService {
    @GET("/data/media-types.json")
    Call<List<SubGenres>> listGenres();

    class SubGenres {
        @SerializedName("subgenres")
        private ArrayList<Genres> list = new ArrayList<>();
        @SerializedName("id")
        private String key;

        public String getKey() {
            return key;
        }

        public ArrayList<Genres> getList() {
            return list;
        }
    }

    class Genres {
        @SerializedName("id")
        private String id;
        @SerializedName("translation_key")
        private String translation_key;

        public String getId() {
            return id;
        }

        public String getTranslation_key() {
            return translation_key;
        }
    }
}
