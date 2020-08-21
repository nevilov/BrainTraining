package com.example.braintraining;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private final String Key = "Save_key";
    private int rndChoice;
    private TextView tvQuest;

    private ActionBar actionBar;

    private long startTime = 0;
    private long currentTime =0;
    private float ResTime = 0.0f;

    private boolean isTrue;
    private TextView RightAns, WrongAns;
    private int RightCount, WrongCount;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        numbersGenerate();
    }





    private void init(){
        RightCount =0; WrongCount=0;
        startTime = System.currentTimeMillis();

        RightAns = findViewById(R.id.right_ans);
        WrongAns = findViewById(R.id.wrong_ans);

        preferences = getSharedPreferences("MainPreferences", MODE_PRIVATE);
        tvQuest = findViewById(R.id.tv_quest);

        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("BrainTraining");

    }

    private void numbersGenerate(){
        rndChoice = (int) (Math.random() * (2 - 1));
        String QuestText;

        int num1 = (int) (Math.random() * (20));
        int num2 = (int) (Math.random() * (20));
        int numT = num1 + num2;

        int numF = (int) (Math.random() * (40));

        if(rndChoice==1){QuestText = num1 + " + " + num2 + " = " + numT; isTrue=true;}
        else{QuestText = num1 + " + " + num2 + " = " + numF; isTrue = false;}

        tvQuest.setText(String.valueOf(QuestText));

    }


    public void clickOnTrue_btn(View view) {
        timer();
        Counter();
        numbersGenerate();
    }

    public void clickOnFalse_btn(View view) {
        timer();
        Counter();
        numbersGenerate();
    }

    private void timer(){
        currentTime = System.currentTimeMillis();
        ResTime  = (float)((currentTime-startTime)/1000);

        actionBar.setTitle("Time:" + ResTime);
    }
    private void Counter(){
        if(isTrue){
            RightCount++;
            RightAns.setText("Верно: "+ RightCount);
        }
        else{
            WrongCount++;
            WrongAns.setText("Неверно "+ WrongCount);
        }
    }
}