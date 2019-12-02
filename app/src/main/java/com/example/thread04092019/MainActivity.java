package com.example.thread04092019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        Thread a = new Thread(new Runnable() {
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

        a.start();
        b.start();
    }
    private synchronized void handleThread(String key){
        for (int i = 0 ; i < 100 ; i++){
            Log.d("BBB",key + i);
        }
    }
}
