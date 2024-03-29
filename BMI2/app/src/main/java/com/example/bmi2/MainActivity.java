package com.example.bmi2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private TextView txvshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);
        TextView txvshow = (TextView) findViewById(R.id.txvshow);
        txvshow.setTextSize(36);
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(edtHeight.getText().toString());
                double weight = Double.parseDouble(edtWeight.getText().toString());
                double bmi = weight / Math.pow(height/100.0,2);
                if(bmi>=24)
                    txvshow.setTextColor(Color.RED);
                else if(bmi<18.5)
                    txvshow.setTextColor(Color.BLUE);
                else
                    txvshow.setTextColor(Color.GREEN);

                txvshow.setText(String.format("%.2f",bmi));
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHeight.setText("0");
                edtWeight.setText("0");
                txvshow.setText("");
            }
        });
    }
}