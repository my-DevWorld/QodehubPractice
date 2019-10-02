package v.williams.qhtask1.Circles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CircleView extends View{

    private Paint cPaint;
    private Paint cPaint1;
    private float pointx, pointy, radius;
    private float pointX1, pointY1;
    private float radius1 = 200;

    public CircleView(Context context) {
        super(context);
        paintSetUp();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paintSetUp();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paintSetUp();
    }

    private void paintSetUp(){

        cPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cPaint.setStrokeWidth(15);
        cPaint.setColor(Color.BLACK);
        cPaint.setStyle(Paint.Style.STROKE);

        cPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        cPaint1.setStyle(Paint.Style.FILL_AND_STROKE);
        cPaint1.setColor(Color.RED);
        cPaint1.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        pointx = (float) getWidth() / 4;
        pointy = (float) getHeight() / 7;
        radius = 300;

        if (pointX1 == 0f || pointY1 == 0f) {
            pointX1 = getWidth() / 2 + radius;
            pointY1 = getHeight() / 7;
        }

        canvas.drawCircle(pointx, pointy, radius, cPaint);

        canvas.drawCircle(pointX1, pointY1, radius1, cPaint1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN: {

                return true;
            }

            case MotionEvent.ACTION_MOVE:{

                float x = event.getX();
                float y = event.getY();

                double dx = Math.pow(x - pointX1, 2);
                double dy = Math.pow(y - pointY1, 2);

                if (dx + dy < Math.pow(radius1, 2)){

                    pointX1 = x;
                    pointY1 = y;

                    postInvalidate();

                    return true;
                }

                return value;
            }
        }

        return value;
    }
}
