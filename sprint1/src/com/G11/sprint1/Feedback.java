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
/* ------------------------------------------------------
original plan was to use shared preferences
Uses a singleton file to transfer data from one activity to another
code for shared preferences is commented out
-Ryan
---------------------------------------------------------
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

        //save the ratings in variables
        rating1 = (RatingBar)findViewById(R.id.ratingBar_advisor);
        rating2 = (RatingBar)findViewById(R.id.ratingBar_prof);
    }


    public void sendfeedback (View view) {

        //This function takes the feedback from the user
        //then stores it in a singleton file, called DataHolder
        //this DataHolder is how I transfer information from this activity to another activity


        feedbackbox = (EditText)findViewById(R.id.editText_feedback);
        String  data = feedbackbox.getText().toString();        //convert the data in the feedback box to a string
        //Toast.makeText(Feedback.this, DataHolder.getInstance().getString(), Toast.LENGTH_LONG).show();        Testing purposes
        int numofFB = DataHolder.getInstance().getNumFB();
        numofFB++;


        float a = rating1.getRating();
        float p = rating2.getRating();
        //Log.d(getClass().getName(), "advisor: " + a);   //testing purposes
        //Log.d(getClass().getName(), "prof: " + p);      //testing purposes
        if (numofFB == 1) {
            DataHolder.getInstance().setnumFB(numofFB);
            DataHolder.getInstance().setrating1(p);         //Set the DataHolder's rating variables to the variables we obtained from the user
            DataHolder.getInstance().setrating2(a);
            DataHolder.getInstance().setString(data);   //In the DataHolder class, set its data to the string we obtained from the use
        }
        else if (numofFB == 2){
            DataHolder.getInstance().setnumFB(numofFB);
            DataHolder.getInstance().setrating1_2(p);
            DataHolder.getInstance().setrating2_2(a);
            DataHolder.getInstance().setString2(data);   //In the DataHolder class, set its data to the string we obtained from the use
        }
        else if (numofFB ==3){
            DataHolder.getInstance().setnumFB(numofFB);
            DataHolder.getInstance().setrating1_3(p);
            DataHolder.getInstance().setrating2_3(a);
            DataHolder.getInstance().setString3(data);   //In the DataHolder class, set its data to the string we obtained from the use
        }
        else {
            DataHolder.getInstance().setnumFB(3);
            DataHolder.getInstance().setrating1(p);
            DataHolder.getInstance().setrating2(a);
            DataHolder.getInstance().setString(data);   //In the DataHolder class, set its data to the string we obtained from the use
        }
            Toast.makeText(Feedback.this, "Feedback Sent!", Toast.LENGTH_SHORT).show();
            finish();



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