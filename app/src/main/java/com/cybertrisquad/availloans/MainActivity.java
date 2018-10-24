package com.cybertrisquad.availloans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Thread timer = new Thread() {
                public void run(){
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        startActivity(new Intent(MainActivity.this, Options.class));
                        finish();
                    }
                }

            };timer.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

