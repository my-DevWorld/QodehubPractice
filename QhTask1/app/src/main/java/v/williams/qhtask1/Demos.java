package v.williams.qhtask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import v.williams.qhtask1.BarGraph.BarGraph;
import v.williams.qhtask1.Circles.Circles;
import v.williams.qhtask1.Lines.Lines;
import v.williams.qhtask1.PieChart.PieChart;
import v.williams.qhtask1.ValueMeter.ValueMeter;

public class Demos extends AppCompatActivity implements View.OnClickListener {

    Button bargraph;
    Button lines;
    Button pieChart;
    Button valueMeter;
    Button circles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demos);

        setUp();

    }

    private void setUp(){

        bargraph = findViewById(R.id.bargraph);
        bargraph.setOnClickListener(this);

        lines = findViewById(R.id.lines);
        lines.setOnClickListener(this);

        pieChart = findViewById(R.id.piechart);
        pieChart.setOnClickListener(this);

        circles = findViewById(R.id.circle);
        circles.setOnClickListener(this);

        valueMeter = findViewById(R.id.valuemeter);
        valueMeter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v instanceof Button){

           String actonText =  ((Button) v).getText().toString().trim();

           switch (actonText){
               case "Bar Graphs":
                   Intent barGraphs = new Intent(this, BarGraph.class);
                   startActivity(barGraphs);
                   break;

               case "Lines":
                   Intent lines = new Intent(this, Lines.class);
                   startActivity(lines);
                   break;

               case "Pie Chart":
                   Intent piechart = new Intent(this, PieChart.class);
                   startActivity(piechart);
                   break;

               case "Circle":
                   Intent circle = new Intent(this, Circles.class);
                   startActivity(circle);
                   break;

               case "Value Meter":
                   Intent valueMeter = new Intent(this, ValueMeter.class);
                   startActivity(valueMeter);
                   break;

           }
        }
    }
}
