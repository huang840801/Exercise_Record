package com.huang.hello.exercise_record;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv_starttime_1;
    private TextView tv_starttime_2;
    private TextView tv_starttime_3;
    private TextView tv_resttime_1;
    private TextView tv_resttime_2;


    private Button btn_starttime_1;
    private Button btn_starttime_2;
    private Button btn_starttime3;
    private Button btn_resttime1;
    private Button btn_resttime_2;

    private CountDownTimer countdowntimer;
    private long timeleftinmilliseconds=60000;
    private boolean timerrunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv_starttime_1=findViewById(R.id.tv_starttime_1);
        btn_starttime_1=findViewById(R.id.btn_starttime_1);

        btn_starttime_1.setOnClickListener(new View.OnClickListener() {
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
        btn_starttime_1.setText("暫停");
        timerrunning=true;
    }
    public void stopTimer(){
        countdowntimer.cancel();
        btn_starttime_1.setText("開始");

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

        tv_starttime_1.setText(timeleftText);
    }
}
