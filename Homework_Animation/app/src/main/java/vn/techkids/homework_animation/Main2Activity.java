package vn.techkids.homework_animation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.techkids.homework_animation.fragments.FirstFragment;
import vn.techkids.homework_animation.fragments.SecondFragment;

public class Main2Activity extends AppCompatActivity {
    Button btn_changeFragment;
    Boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        changeFragment(new FirstFragment());
        check = false;
        btn_changeFragment = (Button) findViewById(R.id.btn_changefragment);
        btn_changeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check == true){
                    changeFragment(new FirstFragment());
                }else {
                    changeFragment(new SecondFragment());
                    check = true;
                }
            }
        });

    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.anim_enter, R.anim.anim_exit)
                .replace(R.id.fl_container, fragment)
                .commit();
    }


}
