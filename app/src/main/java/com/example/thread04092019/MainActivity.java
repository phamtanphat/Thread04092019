package com.example.thread04092019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 1 : Khoi tao ra thread
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
//            }
//        }).start();
        // 2: Tao ra object ket thua runble
//        Luong1 luong1 = new Luong1();
//        luong1.run();

        final Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                handleThread(" A ");
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                handleThread(" B ");

            }
        });
        // 1 : random A
        // 2 : random b
        // 3 : random c

        a.start();
        b.start();

    }
    // deadlock : 2 thang cung 1 cong viec ma khong dong bo thi se dan deadlock
    private void handleThread(String key){
        for (int i = 0 ; i < 1000 ; i++){
            Log.d("BBB",key + i);
        }
    }
}
