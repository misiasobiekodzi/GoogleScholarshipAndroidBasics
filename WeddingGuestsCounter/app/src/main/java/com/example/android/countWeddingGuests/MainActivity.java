package com.example.android.countWeddingGuests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreBride = 0;
    int scoreGroom = 0;
    int scoreTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForBride(int score) {
        TextView scoreView = (TextView) findViewById(R.id.bride_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForGroom(int score) {
        TextView scoreView = (TextView) findViewById(R.id.groom_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayTotalNumberOfGuests(int score){
        TextView scoreView = (TextView)findViewById(R.id.total_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addOneForBride(View v){
        scoreBride = scoreBride + 1;
        displayForBride(scoreBride);
        scoreTotal = scoreBride + scoreGroom;
        displayTotalNumberOfGuests(scoreTotal);
    };
    public void addTwoForBride(View v){
        scoreBride = scoreBride + 2;
        displayForBride(scoreBride);
        scoreTotal = scoreBride + scoreGroom;
        displayTotalNumberOfGuests(scoreTotal);
    };


    public void addTwoForGroom(View v){
        scoreGroom = scoreGroom + 2;
        displayForGroom(scoreGroom);
        scoreTotal = scoreBride + scoreGroom;
        displayTotalNumberOfGuests(scoreTotal);
    };
    public void addOneForGroom(View v){
        scoreGroom = scoreGroom + 1;
        displayForGroom(scoreGroom);
        scoreTotal = scoreBride + scoreGroom;
        displayTotalNumberOfGuests(scoreTotal);
    };

    public void reset(View v){
        scoreBride = 0;
        scoreGroom = 0;
        scoreTotal = 0;
        displayForBride(scoreBride);
        displayForGroom(scoreGroom);
        displayTotalNumberOfGuests(scoreTotal);
    };

    }
