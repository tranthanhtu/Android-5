package vn.techkids.realm.networks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import vn.techkids.realm.jsonmodels.Repo;

/**
 * Created by Dell latitude E6520 on 11/2/2016.
 */

public interface GithubSevice {
    @GET("/users/{username}/repos")
    Call<List<Repo>> listRepo(@Path("username") String username);
}
