package com.huang.hello.exercise_record;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Page2Activity extends AppCompatActivity {
    private EditText usernameinput;
    private TextView textViewShow;
    private Button btn_save;
    private Button btn_apply;

    public static final String SHARED_PREFS="sharedPrefs";
    public static final String TEXT="text";

    private String text;

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        spinner=findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.Sports_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"已選擇",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
