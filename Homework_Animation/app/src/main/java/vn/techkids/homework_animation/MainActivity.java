package vn.techkids.homework_animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final long ANIMATION_DURATION = 1000;
    private View view;
    private Button btn_changeAc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.view);
        btn_changeAc = (Button) findViewById(R.id.btn_changeactivity);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateAndFillParentWidth();
            }
        });

        btn_changeAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    void translateAndFillParentWidth() {

        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, 0,
                0, -view.getTop()
        );
        translateAnimation.setDuration(ANIMATION_DURATION);
        translateAnimation.setFillAfter(true);


        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_view);


        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setFillAfter(true);
        animationSet.setDuration(ANIMATION_DURATION);


        view.startAnimation(animationSet);
    }
}