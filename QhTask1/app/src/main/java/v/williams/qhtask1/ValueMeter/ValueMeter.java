package v.williams.qhtask1.ValueMeter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import v.williams.qhtask1.R;
import v.williams.qhtask1.ValueMeter.Data.AvailableAmount;

public class ValueMeter extends AppCompatActivity implements View.OnClickListener {

    private VMView vmView;
    private EditText amount;
    private Button showMeter;
    private float value;

    private AvailableAmount availableAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.valuemeter);

        amount = findViewById(R.id.userAmount);
        vmView = findViewById(R.id.meter);
        showMeter = findViewById(R.id.showMeter);
        showMeter.setOnClickListener(this);
    }

    private void getData(){

        if (amount != null && !TextUtils.isEmpty(amount.getText())){

            value = Float.parseFloat(amount.getText().toString().trim());
            availableAmount = new AvailableAmount(value);
            availableAmount.setAmount(value);
            vmView.setAvailableAmount(availableAmount);
        }

        else {
            amount.setText("");
            Toast.makeText(this, "Enter a number from 0.1 to 25000", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        getData();
        vmView.startAnimation();
    }
}
