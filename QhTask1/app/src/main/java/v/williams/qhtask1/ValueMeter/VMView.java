package v.williams.qhtask1.ValueMeter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Toast;

import androidx.annotation.Nullable;

import v.williams.qhtask1.ValueMeter.Data.AvailableAmount;


public class VMView extends View implements ValueAnimator.AnimatorUpdateListener {

    private AvailableAmount availableAmount;

    private Paint paint;
    private Paint meterLevelPaint;
    private RectF oval;

    private ValueAnimator valueAnimator;
    private float animatingFraction;

    private float value;
    private float minValue;
    private float maxValue = 25000f;
    private float maxSweepValue = 270f;
    private float sweepAngle;

    private Context context;

    public VMView(Context context) {
        super(context);
        this.context = context;
        inIt();
    }

    public VMView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        inIt();
    }

    public VMView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

        inIt();
    }

    private void inIt(){
        animateValue();
        setAvailableAmount(availableAmount);


        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(70);
        paint.setColor(Color.parseColor("#E0E0E0"));

        meterLevelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        meterLevelPaint.setStyle(Paint.Style.STROKE);
        meterLevelPaint.setStrokeWidth(70);
        meterLevelPaint.setColor(Color.parseColor("#42A5F5"));
    }

    private void animateValue(){

        valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(600);
        valueAnimator.setStartDelay(700);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.addUpdateListener(this);
        valueAnimator.setFloatValues(0f, 1f);
    }

    public void setAvailableAmount(AvailableAmount availableAmount) {
        this.availableAmount = availableAmount;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float x = (getWidth() / 2);
        float y = (getHeight() / 2);

        oval = new RectF(x - 600f, y - 600f, x + 600f, y + 600f);

//        canvas.drawRect(oval, paint);

        canvas.drawArc(oval, 135f, 270f, false, paint);
        canvas.drawArc(oval, 135f, sweepAngle * animatingFraction, false, meterLevelPaint);

    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {

        animatingFraction = animation.getAnimatedFraction();

        invalidate();

    }

    public void startAnimation(){

        value = availableAmount.getAmount();

        if (!TextUtils.isEmpty(String.valueOf(value)) && value <= 25000){

            sweepAngle = (value / maxValue) * maxSweepValue;

            valueAnimator.start();
        }

        else {

            Toast.makeText(context, "Enter a value between 0.10 to 25000.00", Toast.LENGTH_SHORT).show();
        }

    }

}
