package com.huang.hello.exercise_record;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Page2_CrunchesActivity extends AppCompatActivity {

    private TextView tv_time;
    private Button btn_starttime;
    private CountDownTimer countdowntimer;
    private long timeleftinmilliseconds=600000;
    private boolean timerrunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2__crunches);
        tv_time=findViewById(R.id.tv_time);
        btn_starttime=findViewById(R.id.btn_starttime);

        btn_starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startstop();
            }
        });
    }
    public void startstop(){
        if (timerrunning) {
            stopTimer();
        }
        else{
            startTimer();
        }
    }
    public void startTimer(){

        countdowntimer=new CountDownTimer(timeleftinmilliseconds,1000) {
            @Override
            public void onTick(long l) {
                timeleftinmilliseconds=l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.ling);
                mediaPlayer.start();

            }
        }.start();
        btn_starttime.setText("Pause");
        timerrunning=true;
    }
    public void stopTimer(){
        countdowntimer.cancel();
        btn_starttime.setText("Start");

        timerrunning=false;
    }
    public void updateTimer(){
        int minutes=(int)timeleftinmilliseconds/60000;
        int seconds=(int)timeleftinmilliseconds%60000/1000;

        String timeleftText;
        timeleftText= "" +minutes;
        timeleftText+=":";
        if(seconds<10) timeleftText+="0";
        timeleftText+=seconds;

        tv_time.setText(timeleftText);
    }
}
