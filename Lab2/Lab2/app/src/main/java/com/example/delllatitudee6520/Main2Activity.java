package com.example.delllatitudee6520;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.delllatitudee6520.lab2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.addtocart)
    Button btn_addtocart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.addtocart)
    public void showDialog(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(fragmentManager, "fragment_dialog.xml");
    }


}
