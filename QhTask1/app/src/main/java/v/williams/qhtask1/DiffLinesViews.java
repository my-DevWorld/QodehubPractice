package v.williams.qhtask1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DiffLinesViews extends View {

    private Paint vLinePaint;
    private Paint vLinePaint2;
    private Paint vLinePaint3;
    private Paint vLinePaint4;

    private Paint hLinePaint;
    private Paint hLinePaint2;
    private Paint hLinePaint3;
    private Paint hLinePaint4;

    private Paint dLinePaint;
    private Paint dLinePaint2;
    private Paint dLinePaint3;
    private Paint dLinePaint4;

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


/////////////////////////////////////////////////////////////////
///////////   Horizontal Lines    //////////////////////////////

        vLinePaint = new Paint();
        int vLineThickness = 10;
        vLinePaint.setStyle(Paint.Style.STROKE);
        vLinePaint.setStrokeWidth(vLineThickness);
        vLinePaint.setColor(Color.RED);

        vLinePaint2 = new Paint();
        int vLineThickness2 = 20;
        vLinePaint2.setStrokeWidth(vLineThickness2);
        vLinePaint2.setStyle(Paint.Style.STROKE);
        vLinePaint2.setColor(Color.YELLOW);

        vLinePaint3 = new Paint();
        int vLineThickness3 = 30;
        vLinePaint3.setStyle(Paint.Style.STROKE);
        vLinePaint3.setStrokeWidth(vLineThickness3);
        vLinePaint3.setColor(Color.BLACK);

        vLinePaint4 = new Paint();
        int vLineThickness4 = 40;
        vLinePaint4.setStyle(Paint.Style.STROKE);
        vLinePaint4.setStrokeWidth(vLineThickness4);
        vLinePaint4.setColor(Color.GREEN);

///////////////////////////////////////////////////////////////
///////////   Vertical Lines    //////////////////////////////

        hLinePaint = new Paint();
        int hLinePaintThickness = 10;
        hLinePaint.setStyle(Paint.Style.STROKE);
        hLinePaint.setStrokeWidth(hLinePaintThickness);
        hLinePaint.setColor(Color.RED);

        hLinePaint2 = new Paint();
        int hLinePaintThickness2 = 20;
        hLinePaint2.setStrokeWidth(hLinePaintThickness2);
        hLinePaint2.setStyle(Paint.Style.STROKE);
        hLinePaint2.setColor(Color.YELLOW);

        hLinePaint3 = new Paint();
        int hLinePaintThickness3 = 30;
        hLinePaint3.setStyle(Paint.Style.STROKE);
        hLinePaint3.setStrokeWidth(hLinePaintThickness3);
        hLinePaint3.setColor(Color.BLACK);

        hLinePaint4 = new Paint();
        int hLinePaintThickness4 = 40;
        hLinePaint4.setStyle(Paint.Style.STROKE);
        hLinePaint4.setStrokeWidth(hLinePaintThickness4);
        hLinePaint4.setColor(Color.GREEN);

///////////////////////////////////////////////////////////////
///////////   Diagonal Lines    //////////////////////////////

        dLinePaint = new Paint();
        int dLinePaintThickness = 10;
        dLinePaint.setStyle(Paint.Style.STROKE);
        dLinePaint.setStrokeWidth(dLinePaintThickness);
        dLinePaint.setColor(Color.RED);

        dLinePaint2 = new Paint();
        int dLinePaintThickness2 = 20;
        dLinePaint2.setStyle(Paint.Style.STROKE);
        dLinePaint2.setStrokeWidth(dLinePaintThickness2);
        dLinePaint2.setColor(Color.YELLOW);

        dLinePaint3 = new Paint();
        int dLinePaintThickness3 = 30;
        dLinePaint3.setStyle(Paint.Style.STROKE);
        dLinePaint3.setStrokeWidth(dLinePaintThickness3);
        dLinePaint3.setColor(Color.BLACK);

        dLinePaint4 = new Paint();
        int dLinePaintThickness4 = 30;
        dLinePaint4.setStyle(Paint.Style.STROKE);
        dLinePaint4.setStrokeWidth(dLinePaintThickness4);
        dLinePaint4.setColor(Color.GREEN);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

///////////////////////////////////////////////////////////////
///////////   Horizontal Lines    //////////////////////////////

        canvas.drawLine(100, 100, 1300, 100, vLinePaint);
        canvas.drawLine(100, 155, 1300, 155, vLinePaint2);
        canvas.drawLine(100, 200, 1300, 200, vLinePaint3);
        canvas.drawLine(100, 255, 1300, 255, vLinePaint4);

///////////////////////////////////////////////////////////////
///////////   Vertical Lines    //////////////////////////////

        canvas.drawLine(100, 300, 100, 1300, hLinePaint);
        canvas.drawLine(155, 300, 155, 1300, hLinePaint2);
        canvas.drawLine(200, 300, 200, 1300, hLinePaint3);
        canvas.drawLine(255, 300, 255, 1300, hLinePaint4);

///////////////////////////////////////////////////////////////
///////////   Diagonal Lines    //////////////////////////////

        canvas.drawLine(300, 300, 700, 1300, dLinePaint);
        canvas.drawLine(340, 300, 700, 1200, dLinePaint2);
        canvas.drawLine(380, 300, 700, 1100, dLinePaint3);
        canvas.drawLine(420, 300, 700, 1000, dLinePaint4);

        canvas.drawLine(1050, 300, 700, 1300, dLinePaint);
        canvas.drawLine(1000, 300, 700, 1200, dLinePaint2);
        canvas.drawLine(950, 300, 700, 1100, dLinePaint3);
        canvas.drawLine(900, 300, 690, 1000, dLinePaint4);

        canvas.drawLine(100, 2000, 250, 1800, dLinePaint);
        canvas.drawLine(250, 1800, 400, 2000, dLinePaint);
        canvas.drawLine(400, 2000, 550, 1800, dLinePaint);
        canvas.drawLine(550, 1800, 700, 2000, dLinePaint);
        canvas.drawLine(700, 2000, 850, 1800, dLinePaint);
        canvas.drawLine(850, 1800, 1000, 2000, dLinePaint);
        canvas.drawLine(1000, 2000, 1150, 1800, dLinePaint);
        canvas.drawLine(1150, 1800, 1300, 2000, dLinePaint);


        canvas.drawLine(100, 2100, 550, 2100, dLinePaint);
        canvas.drawLine(550, 2100, 700, 2250, dLinePaint);
        canvas.drawLine(700, 2250, 850, 2100, dLinePaint);
        canvas.drawLine(850, 2100, 1400, 2100, dLinePaint);






    }
}
