package vn.techkids.lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentSuccessful extends AppCompatActivity {
    @BindView(R.id.imageView)
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_successful);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentSuccessful.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
