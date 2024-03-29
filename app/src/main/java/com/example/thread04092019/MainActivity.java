package com.example.thread04092019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int inta = 0;
    int intb = 0;
    int intc = 0;
    Laco laco = new Laco(0);
    Thread a, b, c;

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

        a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (laco){
                    for (int i = 0; i < 1000; ) {
                        if (laco.count == 0) {
                            inta = i;
                            Log.d("BBB", " Gia tri cua A : " + inta + " - vi tri " + i);
                            i++;
                            laco.count = 1;
                            laco.notifyAll();
                        } else {
                            try {
                                laco.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (laco){
                    for (int i = 0; i < 1000;) {
                        if (laco.count == 1) {
                            intb = i;
                            laco.count = 2;
                            Log.d("BBB", " Gia tri cua B : " + intb + " - vi tri " + i);
                            i++;
                            laco.notifyAll();
                        } else {
                            try {
                                laco.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        });
        c = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (laco){
                    for (int i = 0; i < 1000; ) {
                        if (laco.count == 2) {
                            intc = inta + intb;
                            laco.count = 0;
                            Log.d("BBB", " Gia tri cua C : " + intc + " - vi tri " + i);
                            i++;
                            laco.notifyAll();
                        } else {
                            try {
                                laco.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        a.start();
        b.start();
        c.start();

    }

}
