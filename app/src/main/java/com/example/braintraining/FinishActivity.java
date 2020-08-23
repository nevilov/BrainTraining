package com.example.braintraining;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class FinishActivity extends Activity {
    private TextView result, bestResult;
    private String GeneralResult;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);


        init();
        recieveIntent();
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
        }
        result.setText(GeneralResult);
    }
}
