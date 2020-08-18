package com.example.braintraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    public void save(View view) {
    }

    public void get(View view){

    }

    private void init(){
        preferences = getSharedPreferences("MainPreferences", MODE_PRIVATE);

    }
}