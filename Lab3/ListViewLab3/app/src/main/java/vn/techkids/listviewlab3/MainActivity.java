package vn.techkids.listviewlab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lv_Favorites)
    ListView lv_Favorites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupUI();
    }

    private void setupUI() {
        lv_Favorites.setAdapter(new FavoritesAdapter(
                this,
                R.layout.list_item_favorites,
                Arrays.asList(FavoritesItem.ARRAY)
        ));

    }
}
