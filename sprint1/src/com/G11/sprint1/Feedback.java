package com.G11.sprint1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import android.R.string;

/**
 * Created by Ryan on 3/17/2017.
 */

public class Feedback extends Activity {
    EditText feedbackbox;
    /*
    public static final String MyPREFERERNCES = "MyPrefs";
    public static final String feedback = "feedback";
    public static final String prof_rating = "prof_rating";
    public static final String advisor_rating = "advisor_rating";
    */
    RatingBar rating1,rating2;
    public static final String prof_rating = "prof_rating";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        rating1 = (RatingBar)findViewById(R.id.ratingBar_advisor);
        rating2 = (RatingBar)findViewById(R.id.ratingBar_prof);
    }
    /*
    public void take_feedback() {
        feedback = (Button)findViewById(R.id.button_sendfeedback);
        feedback.setOnClickListener(new View.OnClickListener() {

            @Override
            Toast.makeText(getApplicationContext(), "Feedback Received!",Toast.LENGTH_SHORT).show();

        }
    }
    */
    public void pressloginbutton (View view) {
        feedbackbox = (EditText)findViewById(R.id.editText_feedback);
        String  data = feedbackbox.getText().toString();
        Toast.makeText(Feedback.this, DataHolder.getInstance().getString(), Toast.LENGTH_LONG).show();
        DataHolder.getInstance().setString(data);

        float a = rating1.getRating();
        float p = rating2.getRating();
        Log.d(getClass().getName(), "advisor: " + a);
        Log.d(getClass().getName(), "prof: " + p);

        DataHolder.getInstance().setrating1(p);
        DataHolder.getInstance().setrating2(a);
        /*
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(prof_rating, p);
        editor.putInt(advisor_rating, a);
        editor.commit();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(prof_rating, a);
        editor.apply();
        */

    }
}