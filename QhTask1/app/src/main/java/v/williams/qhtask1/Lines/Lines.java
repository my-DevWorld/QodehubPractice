package v.williams.qhtask1.Lines;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import v.williams.qhtask1.MyView;
import v.williams.qhtask1.R;

public class Lines extends AppCompatActivity {

    DiffLinesViews diffLinesViews;
    MyView myView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lines);

        diffLinesViews = findViewById(R.id.linesview);
        diffLinesViews.startAnimation();

//        myView = findViewById(R.id.zigzag);
//        myView.startPathAnimation();
    }
}
