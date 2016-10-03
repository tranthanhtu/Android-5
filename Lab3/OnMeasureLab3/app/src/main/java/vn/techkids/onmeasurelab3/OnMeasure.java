package vn.techkids.onmeasurelab3;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Dell latitude E6520 on 10/3/2016.
 */

public class OnMeasure extends RelativeLayout {
    public OnMeasure(Context context) {
        super(context);
        initContext(context);
    }

    public OnMeasure(Context context, AttributeSet attrs) {
        super(context, attrs);
        initContext(context);
    }

    public OnMeasure(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initContext(context);
    }

    public void initContext(Context context){
        inflate(context, R.layout.measure_layout, this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int newwidthSize = widthSize / 2;

        int widthType = MeasureSpec.EXACTLY;

        int newwitchMesureSpec = MeasureSpec.makeMeasureSpec(newwidthSize, widthType);

        super.onMeasure(newwitchMesureSpec, heightMeasureSpec);
    }
}
