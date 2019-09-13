package v.williams.qhtask1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PointF;
import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {



    public EditText usdAmount;
    public EditText localAmount;

    private LineView mlineView;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mlineView = findViewById(R.id.lineView);
//        mlineView.setPointA(pointA);
//        mlineView.setPointB(pointB);
//        mlineView.setPointC(pointC);
//        mlineView.setPointD(pointD);
//        mlineView.setPointE(pointE);
//        mlineView.draw();





        usdAmount = findViewById(R.id.usdAmount);
        localAmount = findViewById(R.id.localAmount);

        usdAmount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus){
                    localAmount.removeTextChangedListener ( convertToUsd );
                    usdAmount.addTextChangedListener(convertToLocal);
                }
                else{
                    usdAmount.removeTextChangedListener(convertToLocal);
                    localAmount.addTextChangedListener(convertToUsd);
                }
            }
        });

        localAmount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus){
                    usdAmount.removeTextChangedListener(convertToLocal);
                    localAmount.addTextChangedListener(convertToUsd);
                }
                else{
                    localAmount.removeTextChangedListener(convertToUsd);
                    usdAmount.addTextChangedListener(convertToLocal);
                }
            }
        });
    }

    private TextWatcher convertToLocal = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if( editable != null && !TextUtils.isEmpty(editable.toString())){

                double usdAmountText = Double.valueOf(editable.toString());
                double localAmt = usdAmountText * 3.95;

                localAmount.setText( String.format (Locale.getDefault (), "%.2f", localAmt ) );
            }
            else {
                localAmount.setText ( "" );
            }
        }
    };

    private TextWatcher convertToUsd = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            if( editable != null && !TextUtils.isEmpty(editable.toString())){
                double localAmountText = Double.valueOf(editable.toString());
                double localAmt = localAmountText / 3.95;

                usdAmount.clearFocus ();
                usdAmount.setText(String.format(Locale.getDefault(),"%.2f", localAmt));
            }
            else {
                usdAmount.setText ( "" );
            }
        }
    };
}
