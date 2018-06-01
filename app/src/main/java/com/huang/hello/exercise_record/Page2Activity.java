package com.huang.hello.exercise_record;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class Page2Activity extends AppCompatActivity {
    private EditText usernameinput;
    private TextView textViewShow;
    private Button btn_save;
    private Button btn_apply;

    private TextView tv_time;
    private Button btn_Crunches;
    private CountDownTimer countdowntimer;
    private long timeleftinmilliseconds=600000;
    private boolean timerrunning;


    public static final String SHARED_PREFS="sharedPrefs";
    public static final String TEXT="text";

    private String text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        tv_time=findViewById(R.id.tv_time);
        btn_Crunches=findViewById(R.id.btn_starttime);

        btn_Crunches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Page2Activity.this,Page2_CrunchesActivity.class);
                startActivity(intent);
            }
        });



        usernameinput=findViewById(R.id.et_username);
        textViewShow=(TextView)findViewById(R.id.tv_show);
        btn_save=findViewById(R.id.btn_save);
        btn_apply=findViewById(R.id.btn_apply);

        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewShow.setText(usernameinput.getText().toString());
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
            }
        });

        loadData();
        updateViews();

    }
    public void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString(TEXT,textViewShow.getText().toString());

        editor.apply();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }
    public void loadData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text=sharedPreferences.getString(TEXT,"");
    }
    public void updateViews(){
        textViewShow.setText(text);
    }

}
