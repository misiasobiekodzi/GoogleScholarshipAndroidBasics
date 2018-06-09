package com.example.android.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    String solution_for_question1;
    String solution_for_question2_and3 = "xoxo";
    String solution_for_question4 = "zozo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getSolution_for_question1(String question1){

        RadioButton rb_yes = (RadioButton) findViewById(R.id.rb_yes);
        RadioButton rb_maybe = (RadioButton) findViewById(R.id.rb_maybe);
        RadioButton rb_no = (RadioButton) findViewById(R.id.rb_no);

        if(rb_yes.isChecked()){
            solution_for_question1 = "It's really cool that you can drive! It is a nice road in front of you!";
        }
        else if(rb_maybe.isChecked()){
            solution_for_question1 = "We can share the driving :)";
        }
        else if (rb_no.isChecked()){
            solution_for_question1 = "We should use public transportation instead of renting a car. It will be cheaper!";
        }
        else
            solution_for_question1 = "You did not answered the question about driving the car :(";
    };

    public void getSolution_for_question2_and3(String question2_and_question3){

        int how_many_activities = 0;

        //define&link needed stuff (radio buttons and checkboxes)
        RadioButton rb_active = (RadioButton) findViewById(R.id.rb_active);
        RadioButton rb_chillout = (RadioButton) findViewById(R.id.rb_chillout);
        RadioButton rb_both = (RadioButton) findViewById(R.id.rb_both);

        CheckBox cb_sunbathing = (CheckBox) findViewById(R.id.cb_sunbathing);
        CheckBox cb_sup = (CheckBox) findViewById(R.id.cb_sup);
        CheckBox cb_hiking = (CheckBox) findViewById(R.id.cb_hiking);
        CheckBox cb_wine_tasting = (CheckBox) findViewById(R.id.cb_wine_tasting);
        CheckBox cb_sightseeing = (CheckBox) findViewById(R.id.cb_sightseeing);
        CheckBox cb_surfing = (CheckBox) findViewById(R.id.cb_sufring);
        CheckBox cb_hanging_around = (CheckBox) findViewById(R.id.cb_hanging_around);
        CheckBox cb_sleep = (CheckBox) findViewById(R.id.cb_wine_tasting);

        //calculate checked activities
        if (cb_sup.isChecked()) {
            how_many_activities++;
        }
        if (cb_hiking.isChecked()){
            how_many_activities++;
        }
        if (cb_sightseeing.isChecked()){
            how_many_activities++;
        }
        if (cb_surfing.isChecked()){
            how_many_activities++;
        }
        if (cb_sunbathing.isChecked()){
            how_many_activities++;
        }
        if (cb_wine_tasting.isChecked()){
            how_many_activities++;
        }
        if (cb_hanging_around.isChecked()){
            how_many_activities++;
        }
        if (cb_sleep.isChecked()){
            how_many_activities++;
        }

        //active holidays solution
        if (rb_active.isChecked() && how_many_activities >= 4){
            solution_for_question2_and3 = "Cool! Active holiday in front of us!";
        }
        else if (rb_active.isChecked() && how_many_activities < 4){
            solution_for_question2_and3 = "Do you have other ideas for our free time?";
        }
        //chillout holidays solution
        if (rb_chillout.isChecked() && how_many_activities >= 3){
            solution_for_question2_and3 = "Finally we can relax :) ";
        }
        else if (rb_chillout.isChecked() && how_many_activities < 3){
            solution_for_question2_and3 = "You did not picked many activities. It is a pity since the are many things to do.";
        }
        //mixed holidays solution
        if (rb_both.isChecked() && how_many_activities >=4 ){
            solution_for_question2_and3 = "I have the same expectations :)";
        }
        else if (rb_both.isChecked() && how_many_activities <4)
            solution_for_question2_and3 = "Please share your ideas about our free time. ";
        //if any of radio button has been checked
        if (!rb_active.isChecked() && !rb_both.isChecked() && !rb_chillout.isChecked())
            solution_for_question2_and3 = "Answer question 2!";
    };

    public void getSolution_for_question4(String question4){

        EditText entered_number = (EditText) findViewById(R.id.enter_number);

        //check if edit text is empty
        if (entered_number.getText().toString().matches("")){
            solution_for_question4 = "Please specify amount of days in Funchal";
        }
        //if it is not empty proceed with quiz
        else {
            int days_in_Funchal = Integer.parseInt(entered_number.getText().toString());

            if (days_in_Funchal > 4 && days_in_Funchal < 8) {
                solution_for_question4 = "We don't spend such a long time in Funchal";
            }
            if (days_in_Funchal > 7) {
                solution_for_question4 = "Unfortunately we are going there only for one week :) ";
            } else
                solution_for_question4 = "Perfect amount of time in Funchal!";
        }
    };


    public void submitAnswers(View v){

        getSolution_for_question1(solution_for_question1);
        getSolution_for_question2_and3(solution_for_question2_and3);
        getSolution_for_question4(solution_for_question4);

        String result = solution_for_question1 + " "+ solution_for_question2_and3 + " " + solution_for_question4;

        Toast toast_with_result = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG);
      toast_with_result.show();

    };


}
