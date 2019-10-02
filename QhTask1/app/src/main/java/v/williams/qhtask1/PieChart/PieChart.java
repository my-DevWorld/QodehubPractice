package v.williams.qhtask1.PieChart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import v.williams.qhtask1.R;

public class PieChart extends AppCompatActivity {

    private PieChartCustomView pieChartCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piechart);

        pieChartCustomView = findViewById(R.id.pie_chart);
    }
}
