package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Button1_Click(View view){
        int count;
        TextView output = (TextView) findViewById(R.id.textView);
        count = Integer.parseInt(output.getText().toString());
        count++;
        output.setText(Integer.toString(count));
    }

    public void Button2_Click(View view){
        TextView output = (TextView) findViewById(R.id.textView);
        output.setText(R.string.ini_value);
    }
    public void Button3_Click(View view){
        int a;
        TextView output = (TextView) findViewById(R.id.textView);
        a = Integer.parseInt(output.getText().toString());
        a--;
        output.setText(Integer.toString(a));
    }

}