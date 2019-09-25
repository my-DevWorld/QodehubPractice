package v.williams.qhtask1;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;

import androidx.annotation.Nullable;

public class CircleView extends View implements ValueAnimator.AnimatorUpdateListener {

    private Paint cPaint;
    private Paint cPaint1;
    private float pointx, pointy, radius;
    private float pointx1, pointy1, radius1;

    private ValueAnimator animation;
    private float animatingFraction;

    private Animation animation1;

    public CircleView(Context context) {
        super(context);
        inIt();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inIt();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inIt();
    }

    private void inIt(){

        animation = new ValueAnimator();
        animation.setDuration(5000);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.addUpdateListener(this);
        animation.setFloatValues(0f, 1f);
        animation.start();

        cPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        cPaint.setStrokeWidth(15);
        cPaint.setColor(Color.BLACK);
        cPaint.setStyle(Paint.Style.STROKE);

        cPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        cPaint1.setStyle(Paint.Style.FILL_AND_STROKE);
        cPaint1.setColor(Color.RED);
        cPaint1.setStrokeWidth(20);



        pointx = getWidth() / 4;
        pointy = getHeight() / 7;
        radius = 300;

        pointx1 = (2 * pointx) + 300;
        pointy1= getHeight() / 7;
        radius1 = 300;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        inIt();

        canvas.drawCircle(pointx, pointy, radius, cPaint);

        canvas.drawCircle(pointx1, pointy1, radius1, cPaint1);
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        animatingFraction = animation.getAnimatedFraction();

    }
}
