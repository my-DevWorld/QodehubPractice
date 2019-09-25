package v.williams.qhtask1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Lines extends AppCompatActivity {

    DiffLinesViews diffLinesViews;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lines);

        diffLinesViews = findViewById(R.id.linesview);
        diffLinesViews.startAnimation();
    }
}
