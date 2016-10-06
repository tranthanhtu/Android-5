package vn.techkids.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewPayment_Input extends AppCompatActivity {
    @BindView(R.id.btn_back)
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_payment__input);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPayment_Input.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
