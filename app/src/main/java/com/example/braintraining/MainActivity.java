package com.example.braintraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;
    private final String Key = "Save_key";
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    public void save(View view) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(Key, editText.getText().toString()); // put storage
        edit.apply(); // save storage
    }

    public void get(View view){
        editText.setText(preferences.getString(Key,"Empty")); // get storage

    }

    private void init(){
        preferences = getSharedPreferences("MainPreferences", MODE_PRIVATE);
        editText = findViewById(R.id.editText);
        editText.setText(preferences.getString(Key,"Empty"));
    }
}