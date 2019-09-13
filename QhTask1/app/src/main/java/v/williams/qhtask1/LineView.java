package v.williams.qhtask1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class LineView extends View {

    PointF pointA;
    PointF pointB;
    PointF pointC;
    PointF pointD;
    PointF pointE;

    public float x1,x2,x3,x4,x5,y1,y3,y4,y5;

    private Paint paint = new Paint();

    public LineView(Context context) {
        super(context);
        inIt();
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inIt();
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inIt();
    }

    private void inIt(){

        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);

        x1 = 0;
        y1 = (float) getHeight() /2;
        pointA = new PointF (x1,y1);

        x2 = ((float) getWidth() /2) - 10;
        pointB = new PointF(x2,y1);

        x3 = (float) getWidth() / 2;
        y3 = ((float) getHeight() /2) + 20;
        pointC = new PointF(x3,y3);

        x4 = x3 + 10;
        y4 = y1;
        pointD = new PointF(x4,y4);

        x5 = (float) getWidth();
        y5 = (float) getHeight() / 2;
        pointE = new PointF(x5,y5);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("" + pointA + pointB + pointC + pointD + pointE);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        inIt();

        String x = String.valueOf(getWidth());
        String y = String.valueOf(getHeight());
        System.out.println("----------------------------------------");
        System.out.println(x + " , " + y);
        System.out.println("----------------------------------------");

        canvas.drawLine(pointA.x,pointA.y,
                        pointB.x,pointB.y,
                        paint);
        canvas.drawLine(pointB.x,pointB.y,
                        pointC.x,pointC.y,
                        paint);
        canvas.drawLine(pointC.x,pointC.y,
                        pointD.x,pointD.y,
                        paint);
        canvas.drawLine(pointD.x, pointD.y,
                        pointE.x,pointE.y,
                        paint);

//        canvas.drawPath(path,paint);

    }

}
