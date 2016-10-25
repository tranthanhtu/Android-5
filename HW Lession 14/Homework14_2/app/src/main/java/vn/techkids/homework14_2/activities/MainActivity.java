package vn.techkids.homework14_2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.techkids.homework14_2.R;
import vn.techkids.homework14_2.adapters.Adapter;
import vn.techkids.homework14_2.models.CountryModels;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_country)
    RecyclerView rvCountry;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addToList();
        setupUI();
    }

    private void addToList() {
        CountryModels.list.add(new CountryModels("American", R.drawable.american));
        CountryModels.list.add(new CountryModels("Chinese", R.drawable.chinese));
        CountryModels.list.add(new CountryModels("Czech", R.drawable.czech));
        CountryModels.list.add(new CountryModels("Italian", R.drawable.italian));
        CountryModels.list.add(new CountryModels("Japanese", R.drawable.japanese));
        CountryModels.list.add(new CountryModels("Thai", R.drawable.thai));
    }

    private void setupUI() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2 , StaggeredGridLayoutManager.VERTICAL);
        rvCountry.setLayoutManager(layoutManager);

        adapter = new Adapter();
        rvCountry.setAdapter(adapter);
    }
}
