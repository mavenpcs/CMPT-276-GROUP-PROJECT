package com.G11.sprint1;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.R.string;

/**
 * Created by Ryan on 3/17/2017.
 */

public class Feedback extends Activity {
    EditText feedbackbox;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
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

    }
}