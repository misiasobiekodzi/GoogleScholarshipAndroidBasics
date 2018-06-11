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
    String solution_for_question2_and3;
    String solution_for_question4;
    int score = 0;

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
            solution_for_question1 = getString(R.string.can_drive);
            score += 2;
        }
        else if(rb_maybe.isChecked()){
            solution_for_question1 = getString(R.string.share_driving);
            score += 1;
        }
        else if (rb_no.isChecked()){
            solution_for_question1 = getString(R.string.no_car_driving);
        }
        else
            solution_for_question1 = getString(R.string.no_answered_car_question);
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
        CheckBox cb_sleep = (CheckBox) findViewById(R.id.cb_sleep);

        //calculate checked activities
        if (cb_sup.isChecked()) {
            how_many_activities++;
            score += 1;
        }
        if (cb_hiking.isChecked()){
            how_many_activities++;
            score += 1;
        }
        if (cb_sightseeing.isChecked()){
            how_many_activities++;
            score += 1;
        }
        if (cb_surfing.isChecked()){
            how_many_activities++;
            score += 1;
        }
        if (cb_sunbathing.isChecked()){
            how_many_activities++;
            score += 1;
        }
        if (cb_wine_tasting.isChecked()){
            how_many_activities++;
            score += 1;
        }
        if (cb_hanging_around.isChecked()){
            how_many_activities++;
            score += 1;
        }
        if (cb_sleep.isChecked()){
            how_many_activities++;
            score += 1;
        }

        //active holidays solution
        if (rb_active.isChecked() && how_many_activities >= 4){
            solution_for_question2_and3 = getString(R.string.active_holiday_many_activities);
        }
        else if (rb_active.isChecked() && how_many_activities < 4){
            solution_for_question2_and3 = getString(R.string.active_holiday_few_activities);
        }
        //chillout holidays solution
        if (rb_chillout.isChecked() && how_many_activities >= 3){
            solution_for_question2_and3 = getString(R.string.relax_holiday);
        }
        else if (rb_chillout.isChecked() && how_many_activities < 3){
            solution_for_question2_and3 = getString(R.string.relax_holiday_few_activities);
        }
        //mixed holidays solution
        if (rb_both.isChecked() && how_many_activities >=4 ){
            solution_for_question2_and3 = getString(R.string.both_same_expectations);
        }
        else if (rb_both.isChecked() && how_many_activities <4)
            solution_for_question2_and3 = getString(R.string.both_few_activities);
        
        //if any of radio button has been checked
        if (!rb_active.isChecked() && !rb_both.isChecked() && !rb_chillout.isChecked())
            solution_for_question2_and3 = getString(R.string.active_question_not_answered);
    };

    public void getSolution_for_question4(String question4){

        EditText entered_number = (EditText) findViewById(R.id.enter_number);

        //check if edit text is empty
        if (entered_number.getText().toString().matches("")){
            solution_for_question4 = getString(R.string.question_Funchal_not_answered);
        }
        //if it is not empty proceed with quiz
        else {
            int days_in_Funchal = Integer.parseInt(entered_number.getText().toString());

            if (days_in_Funchal > 3 && days_in_Funchal < 8) {
                solution_for_question4 = getString(R.string.too_long_in_Funchal);
            }
            else if (days_in_Funchal > 7) {
                solution_for_question4 = getString(R.string.more_than_week);
            }
            else
                solution_for_question4 = getString(R.string.perfect_amount_in_Funchal);
                score += 1;
        }
    };


    public void submitAnswers(View v){

        getSolution_for_question1(solution_for_question1);
        getSolution_for_question2_and3(solution_for_question2_and3);
        getSolution_for_question4(solution_for_question4);

        String total_score = Integer.toString(score);

        String result = "You got " + total_score + " points! " + solution_for_question1 + " "+ solution_for_question2_and3 + " " + solution_for_question4;

        Toast toast_with_result = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG);
      toast_with_result.show();

        score = 0;
    };


}
