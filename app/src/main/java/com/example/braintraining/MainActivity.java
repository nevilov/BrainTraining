package com.example.braintraining;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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
    private long ResTime = 0;

    private TextView RightAns, WrongAns;
    private int RightCount, WrongCount;
    private byte flag = 100;

    private byte maxAns = 2;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        numbersGenerate();

}





    private void init(){
        RightCount = 0; WrongCount=0;
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

        rndChoice = (int) (Math.random() * (6));
        String QuestText;

        int num1 = (int) (Math.random() * (20));
        int num2 = (int) (Math.random() * (20));
        int numT = num1 + num2;

        int numF = (int) (Math.random() * (40));

        if(rndChoice==1 || rndChoice == 3 || rndChoice == 5 ){QuestText = num1 + " + " + num2 + " = " + numT; flag = 1; }
        else{QuestText = num1 + " + " + num2 + " = " + numF; flag =0; }

        tvQuest.setText(QuestText);


    }


    public void clickOnTrue_btn(View view) {
        if(flag == 1){
            RightCount++;
            RightAns.setText("Верно: "+ RightCount);
        }
        else{
            WrongCount++;
            WrongAns.setText("Неверно "+ WrongCount);
        }
        intent();

        timer();
        numbersGenerate();
    }

    public void clickOnFalse_btn(View view) {
        if(flag == 1){
            WrongCount++;
            WrongAns.setText("Неверно: "+ WrongCount);
        }
        else{
            RightCount++;
            RightAns.setText("Верно: "+ RightCount);
        }

        timer();
        intent();
        numbersGenerate();
    }

    private void timer(){
        currentTime = System.currentTimeMillis();
        ResTime  = (long) ((currentTime-startTime)/1000);


        actionBar.setTitle("Время: " + ResTime + " секунд");
    }

    private void intent(){
        if(RightCount>=maxAns){
            String generalResult = "Время: "+ ResTime+" сек"+ " | " + "Верно: " + RightCount + " | " + "Неверно: " + WrongCount;
            Intent intent = new Intent(MainActivity.this, FinishActivity.class);
            intent.putExtra("result", generalResult);
            intent.putExtra("time", ResTime);
            startActivity(intent);
        }
    }




}