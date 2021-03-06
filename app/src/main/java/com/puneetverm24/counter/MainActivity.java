package com.puneetverm24.counter;

import android.os.CountDownTimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    TextView textViewTime;
    private CounterClass timer;
    private long millis;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnStop = (Button)findViewById(R.id.btnStop);
        textViewTime = (TextView)findViewById(R.id.textViewTime);

        textViewTime.setText("00:01:00");   //initial text

        timer = new CounterClass(60000, 1000); // constructor initialization (1 min countertime,update rate per seconds)
    }



public void hello(View v)

{
    if(v==btnStart) {
      timer.start();  //to start counter
    }

    if(v==btnStop) {
        timer.cancel(); // to stop counter
    }

    }



    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onFinish() {

            textViewTime.setText("Completed.");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d",TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

            textViewTime.setText(hms);

        }
    }
}