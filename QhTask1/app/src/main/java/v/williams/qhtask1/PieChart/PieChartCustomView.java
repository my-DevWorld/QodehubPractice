package v.williams.qhtask1.PieChart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PieChartCustomView extends View {

    private RectF oval;
    private RectF rectF;
    private Paint mPaint;
    private Paint mPaint2;
    private Paint mPaint3;
    private Paint mPaint4;

    public PieChartCustomView(Context context) {
        super(context);
        inIt();
    }

    public PieChartCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inIt();
    }

    public PieChartCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inIt();
    }

    private void inIt(){

//        float y = canvas.getHeight();
//
//        oval = new RectF(getLeft(), y - 100, getRight(), y);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.parseColor("#81D4FA"));


        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint2.setStrokeWidth(5);
        mPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint2.setColor(Color.parseColor("#FFD54F"));

        mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint3.setStrokeWidth(5);
        mPaint3.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint3.setColor(Color.parseColor("#BA68C8"));

        mPaint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint4.setStrokeWidth(5);
        mPaint4.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint4.setColor(Color.parseColor("#BCAAA4"));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        float x = canvas.getWidth();
//        float y = canvas.getHeight() / 2;
//
//        oval = new RectF(0f, 0f, x, y);


        float x = (getWidth() / 2);
        float y = (getHeight() / 2);

        rectF = new RectF(x - 500, y - 500, x + 500f, y + 500f);


        canvas.drawRect(rectF, mPaint);



        canvas.drawArc(rectF, 0f, 90f, true, mPaint);
        canvas.drawArc(rectF, 90f, 90f, true, mPaint2);
        canvas.drawArc(rectF, 180f, 90f, true, mPaint3);
        canvas.drawArc(rectF, 270f, 90f, true, mPaint4);
    }
}
