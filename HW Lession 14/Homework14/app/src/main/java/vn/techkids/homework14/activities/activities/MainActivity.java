package vn.techkids.homework14.activities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.techkids.homework14.R;
import vn.techkids.homework14.activities.adapters.Adapter;
import vn.techkids.homework14.activities.models.Menu;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;

    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addToList();

        setupUI();
    }

    private void setupUI() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rvMenu.setLayoutManager(layoutManager);

        adapter = new Adapter();
        rvMenu.setAdapter(adapter);
    }

    private void addToList() {
        Menu.list.add(new Menu(
                "BREAKFAST",
                R.drawable.breakfirst
        ));
        Menu.list.add(new Menu(
                "COFFEE",
                R.drawable.coffee
        ));
        Menu.list.add(new Menu(
                "APPETIZERS",
                R.drawable.appertizer
        ));
        Menu.list.add(new Menu(
                "DRINKS",
                R.drawable.drinks
        ));
        Menu.list.add(new Menu(
                "LUNCH",
                R.drawable.lunch
        ));

    }
}
