package com.example.braintraining;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FinishActivity extends Activity {
    private TextView result, bestResult;
    private String GeneralResult;
    private SharedPreferences preferences;

    private long ResTime;
    private long RecordTime;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);


        init();
        recieveIntent();
        preferences();
    }

    private void init(){
        result = findViewById(R.id.tv_result);
        bestResult = findViewById(R.id.tv_record);

    }

    public void onCLickFinish(View view) {
        Intent intent = new Intent(FinishActivity.this, StartActivity.class);
        startActivity(intent);
    }

    private void recieveIntent(){
        Intent intent = getIntent();
        if(intent!=null){
            GeneralResult = intent.getStringExtra("result");
            ResTime = intent.getLongExtra("time", 0);
        }



    }


    private void preferences(){
        preferences = getSharedPreferences("MainPreferences", Context.MODE_PRIVATE);
        boolean hasFirst = preferences.getBoolean("visited",false);
        SharedPreferences.Editor editor = preferences.edit();

        if(!hasFirst){
            editor.putString("key", GeneralResult);
            editor.putLong("record", ResTime);
            editor.apply();

            if(preferences.contains("key")) {
                bestResult.setText(preferences.getString("key", ""));
            }
            editor.putBoolean("visited", true);
            editor.apply();
        }
        else{
            if (ResTime>=preferences.getLong("record", 0)){
                editor.remove("record");
                editor.remove("key");
                editor.apply();
                editor.putString("key", GeneralResult);
                editor.putLong("record", ResTime);
                editor.apply();
                if(preferences.contains("key")) {
                    bestResult.setText(preferences.getString("key", ""));
                }
            }
            else{
                if(preferences.contains("key")) {
                    bestResult.setText(preferences.getString("key", ""));
                }
            }

        }

        result.setText(GeneralResult);

    }
}
