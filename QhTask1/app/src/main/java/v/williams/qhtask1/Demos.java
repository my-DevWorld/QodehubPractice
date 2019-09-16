package v.williams.qhtask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Demos extends AppCompatActivity implements View.OnClickListener {

    Button bargraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demos);

        bargraph = findViewById(R.id.bargraph);
        bargraph.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v instanceof Button){

           String actonText =  ((Button) v).getText().toString().trim();

           switch (actonText){
               case "Bar Graphs":
                   Intent intent = new Intent(this, BarGraph.class);
                   startActivity(intent);
                   break;

           }
        }
    }
}
