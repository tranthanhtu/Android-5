package vn.techkids.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewItem_Details extends AppCompatActivity {
    @BindView(R.id.btn_backtomain)
    Button btn_backtomain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item__details);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        btn_backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewItem_Details.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
