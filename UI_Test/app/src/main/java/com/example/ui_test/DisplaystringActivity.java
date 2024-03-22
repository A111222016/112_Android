package com.example.ui_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplaystringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_string);


        TextView txvshow = (TextView) findViewById(R.id.txvshow);
        Intent intent = getIntent();
        String reveivedString = intent.getStringExtra("userinput");


        txvshow.setText("輸入:"+intent.getStringExtra("userinput"));
    }
}