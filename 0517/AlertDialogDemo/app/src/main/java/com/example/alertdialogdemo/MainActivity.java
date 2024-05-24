package com.example.alertdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private  String[] items = {"Samsung","OPPO","Apple","ASUS"};

    private boolean [] itemsChecked = {false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("關於本書")
                        .setMessage("Android程式設計與應用\n作者:陳會安\n教師:恰克虎")
                        .setCancelable(true)
                        .setPositiveButton("確定",null)
                        .show();
            }
        });

        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("確認")
                        .setMessage("確認結束本程式")
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"按下取消紐",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }

        });
        Button btncolor =(Button) findViewById(R.id.btncolor);
        btncolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("選擇一個顏色")
                        .setItems(new String[]{"紅色", "黃色", "綠色"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Button btncolor =(Button) findViewById(R.id.btncolor);
                                switch (which){
                                    case 0:
                                        btncolor.setBackgroundColor(Color.RED);
                                        break;
                                    case 1:
                                        btncolor.setBackgroundColor(Color.YELLOW);
                                        break;
                                    case 2:
                                        btncolor.setBackgroundColor(Color.GREEN);
                                        break;
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"按下取消紐",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("請勾選選項")
                        .setPositiveButton("確定",MainActivity.this)
                        .setNegativeButton("取消",MainActivity.this)
                        .setMultiChoiceItems(items,itemsChecked,null)
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
//        switch (which){
//            case DialogInterface.BUTTON_POSITIVE:
//                finish();
//                break;
//           case DialogInterface.BUTTON_NEGATIVE:
//                Toast.makeText(this,"按下取消紐",Toast.LENGTH_SHORT).show();
//                break;
//        }

//        Button btncolor =(Button) findViewById(R.id.btncolor);
//        switch (which){
//            case 0:
//                btncolor.setBackgroundColor(Color.RED);
//                break;
//            case 1:
//                btncolor.setBackgroundColor(Color.YELLOW);
//                break;
//            case 2:
//                btncolor.setBackgroundColor(Color.GREEN);
//                break;
//        }
        String msg ="";
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                for (int index = 0;index < items.length;index++){
                    if(itemsChecked[index])
                        msg += items[index] + "\n";
                }
                TextView txvShow = (TextView) findViewById(R.id.txvShow);
                txvShow.setText(msg);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this,"按下取消紐",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void onClick(DialogInterface dialog,int which,boolean isChecked){
        Toast.makeText(MainActivity.this,
                items[which]+(isChecked?"勾選":"沒有勾選"),
                Toast.LENGTH_SHORT).show();
    }
}