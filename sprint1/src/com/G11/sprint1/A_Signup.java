package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class A_Signup extends Activity {
    ADBAdapter userDb;
    private EditText last, first, aCode, cid, pw, cpw;
    String lasts, firsts, aCodes, cids, pws, cpws;
    Button regButton;
    private String accessCode= "ADV276"; // hard-coded access code for advisor sign up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_signup);
        openDB ();
        first= (EditText) findViewById(R.id.editAFirst);
        last= (EditText) findViewById(R.id.editALast);
        aCode= (EditText) findViewById(R.id.editACode);
        cid= (EditText) findViewById(R.id.editACID);
        pw= (EditText) findViewById(R.id.editAPw);
        cpw= (EditText) findViewById(R.id.editACpw);

        regButton = (Button) findViewById(R.id.btnAReg);
        regButton.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                if (validate()) {
                    firsts= first.getText().toString().trim();
                    lasts= last.getText().toString().trim();
                    cids= cid.getText().toString().trim();
                    pws= pw.getText().toString().trim();
                    Log.i("A_Signup", "User has clicked Sign Up");
                    Toast.makeText(A_Signup.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                    long newId= userDb.insertRow(firsts, lasts, cids, pws);
                    finish();
                    }
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }

    private void openDB() {
        userDb = new ADBAdapter(this);
        userDb.open();
    }

    private void closeDB() {

        userDb.close();
    }

    private boolean validate() {
        Integer fname= first.getText().toString().trim().length(); // length of first name
        Integer lname= last.getText().toString().trim().length(); // length of last name
        aCodes= aCode.getText().toString().trim(); // convert access code into string
        Integer codelength= aCode.getText().toString().trim().length(); // length of access code
        Integer clength= cid.getText().toString().trim().length(); // length of computing id
        Integer pass= pw.getText().toString().trim().length(); // length of password
        String fnameS= first.getText().toString(); // convert first name into string
        String lnameS= last.getText().toString(); // convert last name into string
        String pwS= pw.getText().toString(); // convert password into string (to check for space)
        cids= cid.getText().toString().trim(); // convert computing id into string
        Integer f_space= fnameS.indexOf(" "); // find space in first name
        Integer l_space= lnameS.indexOf(" "); // find space in lsat name
        Integer p_space= pwS.indexOf(" "); // find space in password
        Boolean duplicate= validateDup(cids); // look for duplicate computing id in DB
        pws= pw.getText().toString().trim(); // convert password into string
        cpws= cpw.getText().toString().trim(); // convert confirmed password into string

        Log.i("AdvisorSignUp", "User has clicked Sign Up");
        if (fname <=0) { // did not enter first name
            Toast.makeText(A_Signup.this, "Please enter your first name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (lname <=0) { // did not enter last name
            Toast.makeText(A_Signup.this, "Please enter your last name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!aCodes.equals(accessCode)) { // access code is incorrect
            Toast.makeText(A_Signup.this, "Incorrect access code!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (codelength <=0 ) { // did not enter access code
            Toast.makeText(A_Signup.this, "Please enter your access code!", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if (clength <=0) { // did not enter computing id
            Toast.makeText(A_Signup.this, "Please enter your Computing ID!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (pass !=6) { // password is not 6 characters long
            Toast.makeText(A_Signup.this, "Your password needs to be 6 characters long!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (f_space != -1)	{ // first name contains space
            Toast.makeText(A_Signup.this, "Your first name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (l_space != -1)	{ // last name contains space
            Toast.makeText(A_Signup.this, "Your last name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (p_space != -1)	{ // password contains space
            Toast.makeText(A_Signup.this, "Your password contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!pws.equals(cpws)) { // password and confirm password don't match
            Toast.makeText(A_Signup.this, "Your password does not match!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (duplicate)	{ // duplicate computing id in database
            Toast.makeText(A_Signup.this, "Your Computing ID already exists!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean validateDup (String cid) { // look for duplicate computing id in user DB
        Cursor cursor = userDb.getAllRows();
        Boolean check= false;
        if (cursor.moveToFirst()) { // traverses through user DB
            do {
                String c= cursor.getString(ADBAdapter.col_cid);
                if (c.equals(cid)) { // return true if there exists a same computing id in user DB
                    check= true;
                    return check;
                }
            } while(cursor.moveToNext());
        }
        return check; // return false if there is no computing id in user DB that is equivalent to user input.
    }
}
