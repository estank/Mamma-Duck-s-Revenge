package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    TextView tvScore,tvPersonalBest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);

        int points = getIntent().getExtras().getInt("points:");
        SharedPreferences pref = getSharedPreferences("MyPref", 0);
        int pointsSP = pref.getInt("pointsSP", 0);
        SharedPreferences.Editor editor = pref.edit();
        if(points > pointsSP) {
            pointsSP = points;
            editor.putInt("pointSP", pointsSP);
            editor.commit();
        }
        tvScore = findViewById(R.id.tvPoints);
        tvPersonalBest = findViewById(R.id.tvPersonalBest);
        tvScore.setText("" + points);
        tvPersonalBest.setText("" + pointsSP);
    }

    public void restart(View view) {
        Intent intent = new Intent(GameOver.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view) {
        finish();
    }


}
