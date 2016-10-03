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

public class DrawCircleBlue extends TextView {
    public DrawCircleBlue(Context context) {
        super(context);
    }

    public DrawCircleBlue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawCircleBlue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x1 = 500;
        int y1 = 500;
        int x2 = 450;
        int y2 = 500;
        int radius;
        radius = 100;
        Paint paint = new Paint();
        Paint paint1 = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        // Use Color.parseColor to define HTML colors
        paint.setColor(Color.parseColor("#0d5aff"));
        paint1.setColor(Color.parseColor("#FF0000"));
        canvas.drawCircle(x1, y1, radius, paint);
        canvas.drawCircle(x2, y2, radius, paint1);
    }
}
