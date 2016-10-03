package vn.techkids.drawcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Dell latitude E6520 on 10/3/2016.
 */

public class DrawCircleRed extends TextView {
    public DrawCircleRed(Context context) {
        super(context);
    }

    public DrawCircleRed(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircleRed(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = 500;
        int y = 450;
        int radius;
        radius = 100;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#FF0000"));
        canvas.drawCircle(x , y , radius, paint);
    }
}
