package com.example.user.week7daily1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    private int timer;
    private TextView tvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        timer = 20;
        tvTimer = findViewById(R.id.tvTimer);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //while (timer > 0) {
                try {
                    Thread.sleep(1000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (timer != 0) {
                                tvTimer.setText(String.valueOf(timer));
                                timer--;
                            }
                            else
                                finish();
                        }
                    });
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

        thread.start();
    }
}
