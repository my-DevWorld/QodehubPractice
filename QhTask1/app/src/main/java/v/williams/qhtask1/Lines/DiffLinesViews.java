package v.williams.qhtask1.Lines;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;

import androidx.annotation.Nullable;

public class DiffLinesViews extends View implements ValueAnimator.AnimatorUpdateListener {

    private Paint LinePaint;
    private Paint LinePaint2;
    private Paint LinePaint3;
    private Paint LinePaint4;

    private Path path;

    private ValueAnimator valueAnimator;
    private float animatingFraction;

    private ObjectAnimator objectAnimator;

    public DiffLinesViews(Context context) {
        super(context);
        inIt();
    }

    public DiffLinesViews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inIt();
    }

    public DiffLinesViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inIt();
    }

    private void inIt(){

        inItAnimation();
        inItPaintObjects();
        drawPath();
//        objectAnimator(this);
    }

    private void inItAnimation(){
        valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(500);
        valueAnimator.setStartDelay(800);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.addUpdateListener(this);
        valueAnimator.setFloatValues(0f, 1f);
    }

    private void inItPaintObjects(){

        LinePaint = new Paint();
        int vLineThickness = 10;
        LinePaint.setStyle(Paint.Style.STROKE);
        LinePaint.setStrokeWidth(vLineThickness);
        LinePaint.setColor(Color.RED);

        LinePaint2 = new Paint();
        int vLineThickness2 = 20;
        LinePaint2.setStrokeWidth(vLineThickness2);
        LinePaint2.setStyle(Paint.Style.STROKE);
        LinePaint2.setColor(Color.YELLOW);

        LinePaint3 = new Paint();
        int vLineThickness3 = 30;
        LinePaint3.setStyle(Paint.Style.STROKE);
        LinePaint3.setStrokeWidth(vLineThickness3);
        LinePaint3.setColor(Color.BLACK);

        LinePaint4 = new Paint();
        int vLineThickness4 = 40;
        LinePaint4.setStyle(Paint.Style.STROKE);
        LinePaint4.setStrokeWidth(vLineThickness4);
        LinePaint4.setColor(Color.GREEN);
    }

    private void drawPath(){

        path = new Path();
        path.moveTo(100, 2000);
        path.lineTo(250, 1800);
        path.lineTo(250, 1800);
        path.lineTo(400, 2000);
        path.lineTo(400, 2000);
        path.lineTo(550, 1800);
        path.lineTo(550, 1800);
        path.lineTo(700, 2000);
        path.lineTo(700, 2000);
        path.lineTo(850, 1800);
        path.lineTo(850, 1800);
        path.lineTo(1000, 2000);
        path.lineTo(1000, 2000);
        path.lineTo(1150, 1800);
        path.lineTo(1150, 1800);
        path.lineTo(1300, 2000);


    }

//    private void objectAnimator(View view){
//
//        objectAnimator =
//                ObjectAnimator.ofFloat(view, View.X, View.Y, path);
//        setAnimValues(objectAnimator,1200,ValueAnimator.REVERSE);
//        objectAnimator.start();
//    }

//    private void setAnimValues(ObjectAnimator objectAnimator, int duration, int repeatMode) {
//
//        objectAnimator.setDuration(duration);
//        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        objectAnimator.setRepeatMode(repeatMode);
//        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

///////////////////////////////////////////////////////////////
///////////   Horizontal Lines    //////////////////////////////

        canvas.drawLine(100, 100,
                        (1300 * animatingFraction) + 100, 100,
                LinePaint);

        canvas.drawLine(100, 155,
                        (1300 * animatingFraction) + 100, 155,
                LinePaint2);

        canvas.drawLine(100, 200,
                        (1300 * animatingFraction) + 100, 200,
                LinePaint3);

        canvas.drawLine(100, 255,
                        (1300 * animatingFraction) + 100, 255,
                LinePaint4);

///////////////////////////////////////////////////////////////
///////////   Vertical Lines    //////////////////////////////

        canvas.drawLine(100, 300, 100,
                        (1300 * animatingFraction) + 300,
                                LinePaint);

        canvas.drawLine(155, 300, 155,
                        (1300 * animatingFraction) + 300,
                        LinePaint2);

        canvas.drawLine(200, 300,
                        200, (1300 * animatingFraction) + 300,
                        LinePaint3);

        canvas.drawLine(255, 300,
                        255, (1300 * animatingFraction) + 300,
                        LinePaint4);

///////////////////////////////////////////////////////////////
///////////   Diagonal Lines    //////////////////////////////

        canvas.drawLine(300, 300, 700, 1300, LinePaint);
        canvas.drawLine(340, 300, 700, 1200, LinePaint2);
        canvas.drawLine(380, 300, 700, 1100, LinePaint3);
        canvas.drawLine(420, 300, 700, 1000, LinePaint4);

        canvas.drawLine(1050, 300, 700, 1300, LinePaint);
        canvas.drawLine(1000, 300, 700, 1200, LinePaint2);
        canvas.drawLine(950, 300, 700, 1100, LinePaint3);
        canvas.drawLine(900, 300, 690, 1000, LinePaint4);

///////////////////////////////////////////////////////////////
///////////   Zigzag Lines    //////////////////////////////

        canvas.drawPath(path, LinePaint);

//        canvas.drawLine(100, 2000, 250, 1800, LinePaint);
//        canvas.drawLine(250, 1800, 400, 2000, LinePaint);
//        canvas.drawLine(400, 2000, 550, 1800, LinePaint);
//        canvas.drawLine(550, 1800, 700, 2000, LinePaint);
//        canvas.drawLine(700, 2000, 850, 1800, LinePaint);
//        canvas.drawLine(850, 1800, 1000, 2000, LinePaint);
//        canvas.drawLine(1000, 2000, 1150, 1800, LinePaint);
//        canvas.drawLine(1150, 1800, 1300, 2000, LinePaint);



        canvas.drawLine(100, 2100, 550, 2100, LinePaint);
        canvas.drawLine(550, 2100, 700, 2250, LinePaint);
        canvas.drawLine(700, 2250, 850, 2100, LinePaint);
        canvas.drawLine(850, 2100, 1400, 2100, LinePaint);

    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {

        animatingFraction = animation.getAnimatedFraction();

        invalidate();
    }

    public void startAnimation(){

        valueAnimator.start();

//        objectAnimator.start();
    }
}
