package v.williams.qhtask1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BarGraphView extends View {

    private Paint mBarPaint = new Paint();
    private Paint mGridPaint = new Paint();
    private Paint mGuideLinePaint = new Paint();
//    private Paint paint = new Paint();

    private float mPaddingTop = 50;
    private float mPaddingLeft = 15;
    private float mPaddingBottom = 15;


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

        mBarPaint.setStyle(Paint.Style.FILL);
        int barColor = Color.CYAN;
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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        final int width = getWidth();
        final int height = getHeight();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(width + " " + height);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        final float gridLeft = mPaddingLeft;
        final float gridBottom = height - mPaddingBottom;
        final float gridTop = mPaddingTop;
        final float gridRight = width - mPaddingLeft;

        canvas.drawLine(gridLeft, gridBottom, gridLeft, gridTop, mGridPaint);
        canvas.drawLine(gridLeft, gridBottom, gridRight, gridBottom, mGridPaint);

        float guidLineSpacing = (gridBottom - gridTop) / 10f;
        float y;
        for (int i = 0; i < 10; i++){

            y = gridTop + i * guidLineSpacing;
            canvas.drawLine(gridLeft, y, gridRight, y, mGuideLinePaint);

            System.out.println("///////////////////////////////////////////////////////////");
            System.out.println(y);
            System.out.println("///////////////////////////////////////////////////////////");

        }

    }
}
