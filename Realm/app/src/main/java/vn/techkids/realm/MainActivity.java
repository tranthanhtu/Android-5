package vn.techkids.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import vn.techkids.realm.jsonmodels.Repo;
import vn.techkids.realm.managers.DBContext;
import vn.techkids.realm.models.Dog;
import vn.techkids.realm.models.Person;
import vn.techkids.realm.networks.GithubSevice;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();

    private DBContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DBContext.init(this);
//        dbContext = DBContext.getInstance();
//
//        dbContext.add(Person.create("Huy DO", 27));
//
//        Person p = dbContext.findPersonByName("Huy");
//
//        Dog dog = Dog.create("Alaska", "Joel");
//        dbContext.add(dog);
//
//        p.getDogs().add(dog);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubSevice githubSevice = retrofit.create(GithubSevice.class);

        githubSevice
                .listRepo("tranthanhtu")
                .enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        Log.d(TAG, "onResponse");
                        List<Repo> repoList = response.body();
                        for (Repo repo : repoList){
                            Log.d(TAG, repo.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {
                        Log.d(TAG, "onFailure");
                    }
                });



    }

}
