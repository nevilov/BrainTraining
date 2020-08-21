package com.example.braintraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClickStart(View view){
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
