package com.example.android.countWeddingGuests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreBride = 0;
    int scoreGroom = 0;
    int scoreTotal = 0;

    int singleGuestsFromBride = 0;
    int coupleGuestsFromBride = 0;

    int singleGuestsFromGroom = 0;
    int coupleGuestsFromGroom = 0;

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
        //fancy feature to distinguish guests
        singleGuestsFromBride = singleGuestsFromBride + 1;
        brideToast(singleGuestsFromBride, coupleGuestsFromBride);

    }

    public void addTwoForBride(View v){
        scoreBride = scoreBride + 2;
        displayForBride(scoreBride);
        scoreTotal = scoreBride + scoreGroom;
        displayTotalNumberOfGuests(scoreTotal);
        //fancy feature to distinguish guests
        coupleGuestsFromBride = coupleGuestsFromBride + 1;
        brideToast(singleGuestsFromBride, coupleGuestsFromBride);
    }

    public void addOneForGroom(View v){
        scoreGroom = scoreGroom + 1;
        displayForGroom(scoreGroom);
        scoreTotal = scoreBride + scoreGroom;
        displayTotalNumberOfGuests(scoreTotal);
        //fancy feature to distinguish guests
        singleGuestsFromGroom = singleGuestsFromGroom + 1;
        groomToast(singleGuestsFromGroom, coupleGuestsFromGroom);
    }

    public void addTwoForGroom(View v){
        scoreGroom = scoreGroom + 2;
        displayForGroom(scoreGroom);
        scoreTotal = scoreBride + scoreGroom;
        displayTotalNumberOfGuests(scoreTotal);
        //fancy feature to distinguish guests
        coupleGuestsFromGroom = coupleGuestsFromGroom + 1;
        groomToast(singleGuestsFromGroom, coupleGuestsFromGroom);
    }


    public void reset(View v){
        scoreBride = 0;
        scoreGroom = 0;
        scoreTotal = 0;
        displayForBride(scoreBride);
        displayForGroom(scoreGroom);
        displayTotalNumberOfGuests(scoreTotal);
        //fancy feature to distinguish guests
        singleGuestsFromBride = 0;
        singleGuestsFromGroom = 0;
        coupleGuestsFromBride = 0;
        coupleGuestsFromGroom = 0;
        brideToast(singleGuestsFromBride, coupleGuestsFromBride);
        groomToast(singleGuestsFromGroom, coupleGuestsFromGroom);
    }

    public void brideToast(int singles, int couples){
        String brideToastMessage = "Bride Guests: \nSingle guests: " + singles + "\nCouples: " + couples;
        Toast brideToast = Toast.makeText(MainActivity.this, brideToastMessage, Toast.LENGTH_SHORT);
        brideToast.setGravity(Gravity.LEFT, 0, 0);
        brideToast.show();
    }

    public void groomToast(int singles, int couples){
        String groomToastMessage = "Groom Guests: \nSingle guests: " + singles + "\nCouples: " + couples;
        Toast groomToast = Toast.makeText(MainActivity.this, groomToastMessage, Toast.LENGTH_SHORT);
        groomToast.setGravity(Gravity.RIGHT, 0, 0);
        groomToast.show();
    }

    }
