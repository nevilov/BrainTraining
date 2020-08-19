package com.example.braintraining;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private final String Key = "Save_key";
    private int rndChoise;
    private int score=0;

    private TextView tvQuest;
    private TextView tvScore;

    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }





    private void init(){
        preferences = getSharedPreferences("MainPreferences", MODE_PRIVATE);
        tvQuest = findViewById(R.id.tv_quest);
        tvScore = findViewById(R.id.tv_score);

        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("BrainTraining");

        tvScore.setText(String.valueOf(score));
    }

    private void numbersGenerate(){
        rndChoise = (int) (Math.random() * (1 - 0));
        String QuestText;

        int num1 = (int) (Math.random() * (20 - 0));
        int num2 = (int) (Math.random() * (20 - 0));
        int numT = num1 + num2;

        int numF = (int) (Math.random() * (40 - 0));


        if(rndChoise==1){QuestText = num1 + " + " + num2 + " = " + numT;}
        else{QuestText = num1 + " + " + num2 + " = " + numF;}

        tvQuest.setText(QuestText);

    }

    public void clickOnFalse_btn(View view) {
        if(rndChoise == 0){
            score++;
        }
        numbersGenerate();
    }

    public void clickOnTrue_btn(View view) {
        if(rndChoise == 1){
            score++;
        }
        numbersGenerate();
    }
}