package v.williams.qhtask1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BarGraph extends AppCompatActivity {

    BarGraphView graphView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qh_layout);

        graphView = findViewById(R.id.bars);
        graphView.playGraph();

    }

}
