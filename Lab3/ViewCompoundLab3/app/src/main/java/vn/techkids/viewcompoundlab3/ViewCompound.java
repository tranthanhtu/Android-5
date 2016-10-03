package vn.techkids.viewcompoundlab3;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.AttributedCharacterIterator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dell latitude E6520 on 10/3/2016.
 */

public class ViewCompound extends LinearLayout {
    @BindView(R.id.tv_value)
    TextView tv_value;
    @BindView(R.id.iv_add)
    ImageView iv_add;
    @BindView(R.id.iv_remove)
    ImageView iv_remove;
    @BindView(R.id.tv_changenumber)
    TextView tv_changenumber;
    int number_default = 50;

    public ViewCompound(Context context) {
        super(context);
        initContext(context, null);
    }

    public ViewCompound(Context context, AttributeSet attrs) {
        super(context, attrs);
        initContext(context, attrs);
    }

    public ViewCompound(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initContext(context, attrs);
    }

    public void initContext(Context context, AttributeSet attrs){
        View view = inflate(context, R.layout.viewcompound, this);
        ButterKnife.bind(this, view);
        updateUI();

//        if (attrs != null){
//            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ViewCompound);
//
//            String value = typedArray.getString(R.styleable.ViewCompound_value);
//            int number = typedArray.getInt(R.styleable.ViewCompound_number, -1);
//
//            typedArray.recycle();
//
//            tv_changenumber.setText(number + "");
//            tv_value.setText(value);
//
//        }

        iv_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number_default = number_default + 1;
                updateUI();
            }
        });

        iv_remove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                number_default = number_default - 1;
                updateUI();
            }
        });

    }

    private void updateUI() {
        tv_changenumber.setText(number_default + "");

    }

}
