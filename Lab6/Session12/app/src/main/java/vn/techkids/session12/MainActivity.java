package vn.techkids.session12;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import vn.techkids.session12.fragments.FakeFragment;
import vn.techkids.session12.fragments.FlickrFragment;
import vn.techkids.session12.jsonmodels.FlickerItem;
import vn.techkids.session12.jsonmodels.FlickrFeed;

public class MainActivity extends AppCompatActivity {
    ListView lvhome;
    private static final String TAG = MainActivity.class.toString() ;
    ArrayList<String> fragment = new ArrayList<String>(){
    };
    ArrayList<String> nul = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        changeFragment(new FlickrFragment(), false);
        fragment.add("FakeFragment");
        fragment.add("FlickrFragment");
        lvhome = (ListView) findViewById(R.id.lv_home);
        setAdapter(true);
        onListener();
    }


    private void onListener() {
        lvhome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setAdapter(false);
                if (position == 0){
                    changeFragment(new FakeFragment(), true);
                    setAdapter(false);
                }
                else if (position == 1){
                    changeFragment(new FlickrFragment(), true);
                    setAdapter(false);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setAdapter(true);
    }

    private void setAdapter(boolean visible) {
        if (visible){
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,fragment);
            lvhome.setAdapter(adapter);
        }else {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,nul);
            lvhome.setAdapter(adapter);
        }


    }

    public void changeFragment(Fragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);
        if (addToBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
        setAdapter(false);
    }
}
