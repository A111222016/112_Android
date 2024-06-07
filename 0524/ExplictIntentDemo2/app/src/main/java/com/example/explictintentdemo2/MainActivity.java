package com.example.explictintentdemo2;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.lblOutput);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtOpd1, txtOpd2;
                txtOpd1 = (EditText) findViewById(R.id.txtOpd1);
                txtOpd2 = (EditText) findViewById(R.id.txtOpd2);
                Intent intent = new Intent(MainActivity.this, OpActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("OPERANDO1",txtOpd1.getText().toString());
                bundle.putString("OPERANDO2",txtOpd2.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
        class ResultContract extends ActivityResultContract<Boolean,String>{

            @NonNull
            @Override
            public Intent createIntent(@NonNull Context context, Boolean aBoolean) {
                Intent intent = new Intent(MainActivity.this, OpActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("OPERANDO1",((EditText)findViewById(R.id.txtOpd1)).getText().toString());
                bundle.putString("OPERANDO2",((EditText)findViewById(R.id.txtOpd2)).getText().toString());
                intent.putExtras(bundle);
                return null;
            }

            @Override
            public String parseResult(int i, @Nullable Intent intent) {
                Bundle bundle = intent.getExtras();
                Double result = bundle.getDouble("RESULT");
                return null;
            }
        }
    }
}