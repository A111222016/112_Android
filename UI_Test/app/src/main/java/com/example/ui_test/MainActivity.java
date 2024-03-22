package com.example.ui_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }


    public void sendString(View view){
        EditText edtinput = (EditText) findViewById(R.id.edtinput);
        String String2send = edtinput.getText().toString();

        Intent intent = new Intent(this, DisplaystringActivity.class);
        intent.putExtra("userinput",String2send);
        startActivity(intent);
    }
}