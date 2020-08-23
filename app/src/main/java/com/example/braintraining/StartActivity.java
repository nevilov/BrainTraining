package com.example.braintraining;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;

public class StartActivity extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        font();


    }

    public void onClickStart(View view){
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void font(){
        Typeface face = Typeface.createFromAsset(this.getAssets(),"fonts/main.ttf");

        TextView tvStart = findViewById(R.id.tvStart);
        tvStart.setTypeface(face);

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setTypeface(face);
    }

}
