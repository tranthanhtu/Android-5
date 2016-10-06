package vn.techkids.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.lv_lab4)
    ListView lv_lab4;

    ArrayList<String> list = new ArrayList<String>(

    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        list.add("News items - Details");
        list.add("New payment - Input");
        list.add("Payment Successful");
        list.add("Settings 1");
        list.add("Settings 2");

        addListener();
    }

    private void addListener() {
        lv_lab4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 3){
                    Intent intent = new Intent(MainActivity.this, Setting9_1.class);
                    startActivity(intent);
                }
                if (position == 4){
                    Intent intent = new Intent(MainActivity.this, Setting9_2.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(MainActivity.this, PaymentSuccessful.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(MainActivity.this, NewPayment_Input.class);
                    startActivity(intent);
                }
                if (position == 0){
                    Intent intent = new Intent(MainActivity.this, NewItem_Details.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void setupUI() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        lv_lab4.setAdapter(adapter);
    }


}
