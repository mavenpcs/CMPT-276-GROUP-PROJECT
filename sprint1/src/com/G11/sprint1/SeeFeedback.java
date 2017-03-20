package com.G11.sprint1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import static com.G11.sprint1.Feedback.prof_rating;

/**
 * Displays the feedback sent by students in the feedback activity
 * As stated in Feedback.java, original plan was to use shared preferences
 * the code for shared preferences is commented out
 * Created by Ryan on 2017-03-17.
 */


public class SeeFeedback extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_feedback);

        //Sets the feedback textbox to the string the user submitted int feedback.java
        TextView textbox = (TextView)findViewById(R.id.textView_see_feedback);
        textbox.setText(DataHolder.getInstance().getString());

        //Sets the 2 Rating bars to the ratings that the student gave
        RatingBar profBar = (RatingBar)findViewById(R.id.ratingBar_prof_feedback);
        profBar.setRating(DataHolder.getInstance().getrating1());
        RatingBar advisorBar = (RatingBar)findViewById(R.id.ratingBar_advisor_feedback);
        advisorBar.setRating(DataHolder.getInstance().getrating2());

        /*
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        Integer test = prefs.getInt(prof_rating,0);
        */
    }
}