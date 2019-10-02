package v.williams.qhtask1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    int framesPerSecond = 60;
    long animationDuration = 10000; // 10 seconds

    Matrix matrix = new Matrix(); // transformation matrix

    Path path = new Path();       // your path
    Paint paint = new Paint();    // your paint

    long startTime;

    public MyView(Context context) {
        super(context);
        inIt();

    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inIt();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inIt();
    }

    private void inIt(){

        drawPath();
    }

    private void drawPath(){

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


    @Override
    protected void onDraw(Canvas canvas) {

        long elapsedTime = System.currentTimeMillis() - startTime;

        matrix.postRotate(30 * elapsedTime/1000);        // rotate 30° every second
        matrix.postTranslate(100 * elapsedTime/1000, 0); // move 100 pixels to the right
        // other transformations...

        canvas.concat(matrix);        // call this before drawing on the canvas!!

        canvas.drawPath(path, paint); // draw on canvas

        if(elapsedTime < animationDuration)
            this.postInvalidateDelayed( 1000 / framesPerSecond);
    }

    public void startPathAnimation(){

        // start the animation:
        this.startTime = System.currentTimeMillis();
        this.postInvalidate();
    }

}
