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
        Luong1 luong1 = new Luong1();
        luong1.run();

    }
}
