package v.williams.qhtask1;

import android.animation.Animator;
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

public class BarGraphView extends View implements ValueAnimator.AnimatorUpdateListener {

    private Paint mBarPaint = new Paint();
    private Paint mGridPaint = new Paint();
    private Paint mGuideLinePaint = new Paint();

    private ValueAnimator mAnimator;
    private float mAnimatingFraction;


    private float mPaddingTop = 100;
    private float mPaddingLeft = 15;
    private float mPaddingBottom = 15;
    private float mColumnSpacing = 20;
    float top;
    private float spacing;

    private float[] data = {9,78,30,100,50,45,80,95};
    float[] dataInPercentage = new float[data.length];



    public BarGraphView(Context context) {
        super(context);
        inIt();
    }

    public BarGraphView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inIt();
    }

    public BarGraphView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inIt();
    }

    private void inIt(){
        spacing = 25;

        for (int i = 0; i < data.length; i++){

            dataInPercentage[i] = data[i] / 100;
        }

        mAnimator = new ValueAnimator();
        mAnimator.setDuration(50000);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addUpdateListener(this);

        mAnimator.setFloatValues(0f, 1f);
        mAnimator.start();

        mBarPaint.setStyle(Paint.Style.FILL);
        int barColor = Color.MAGENTA;
        mBarPaint.setColor(barColor);


        int gridThicknessInPx = 5;
        mGridPaint.setStrokeWidth(gridThicknessInPx);
        mGridPaint.setStyle(Paint.Style.STROKE);
        mGridPaint.setColor(Color.DKGRAY);


        int guidelineThicknessInPx = 5;
        mGuideLinePaint.setStrokeWidth(guidelineThicknessInPx);
        mGuideLinePaint.setStyle(Paint.Style.STROKE);
        mGuideLinePaint.setColor(Color.RED);

    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {

        mAnimatingFraction = animation.getAnimatedFraction();

        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        inIt();

        final int width = getWidth();
        final int height = getHeight();
        final float gridLeft = mPaddingLeft;
        final float gridBottom = height - mPaddingBottom;
        final float gridTop = mPaddingTop;
        final float gridRight = width - mPaddingLeft;
        final float gridHeight = gridBottom - gridTop;

        canvas.drawLine(gridLeft, gridBottom, gridLeft, gridTop, mGridPaint);
        canvas.drawLine(gridLeft, gridBottom, gridRight, gridBottom, mGridPaint);

        float guidLineSpacing = (gridBottom - gridTop) / 10f;

        float y;
        for (int i = 0; i < 10; i++){
            y = gridTop + i * guidLineSpacing;
            canvas.drawLine(gridLeft, y, gridRight, y, mGuideLinePaint);
        }

        float totalColumnSpacing = spacing * (data.length);
        float columnWidth = (gridRight - gridLeft - totalColumnSpacing) / data.length;
        float columnLeft = gridLeft + spacing;
        float columnRight = columnLeft + columnWidth;

        for (float percentage : dataInPercentage){


            top = mPaddingTop + gridHeight * (1f - (percentage * mAnimatingFraction));
            canvas.drawRect(columnLeft, top, columnRight, gridBottom, mBarPaint);

            columnLeft = columnRight + mColumnSpacing;
            columnRight = columnLeft + columnWidth;

        }

    }

}
