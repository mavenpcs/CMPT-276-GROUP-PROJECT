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

public class S_Signup extends Activity {
    SDBAdapter userDb;
    private EditText last, first, sid, cid, pw, cpw;
    int sidi;
    String lasts, firsts, cids, pws, cpws;
    Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_signup);
        openDB ();
        first= (EditText) findViewById(R.id.editFirst);
        last= (EditText) findViewById(R.id.editLast);
        sid= (EditText) findViewById(R.id.editSID);
        cid= (EditText) findViewById(R.id.editCID);
        pw= (EditText) findViewById(R.id.editPw);
        cpw= (EditText) findViewById(R.id.editCpw);

        regButton = (Button) findViewById(R.id.btnReg);
        regButton.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                if (validate()) {
                    firsts= first.getText().toString().trim();
                    lasts= last.getText().toString().trim();
                    sidi= Integer.valueOf(sid.getText().toString());
                    cids= cid.getText().toString().trim();
                    pws= pw.getText().toString().trim();
                    Log.i("S_Signup", "User has clicked Sign Up");
                    Toast.makeText(S_Signup.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                    long newId= userDb.insertRow(firsts, lasts, sidi, cids, pws);
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
        userDb = new SDBAdapter(this);
        userDb.open();
    }

    private void closeDB() {

        userDb.close();
    }

    private boolean validate() {
        Integer fname= first.getText().toString().trim().length(); // length of first name
        Integer lname= last.getText().toString().trim().length(); // length of last name
        Integer snum= sid.getText().toString().trim().length(); // length of student id
        Integer clength= cid.getText().toString().trim().length(); // length of computing id
        Integer pass= pw.getText().toString().trim().length(); // length of password
        String fnameS= first.getText().toString(); // convert first name into string
        String lnameS= last.getText().toString(); // convert last name into string
        String pwS= pw.getText().toString(); // convert password into string (to check for space)
        Integer f_space= fnameS.indexOf(" "); // check for space in first name
        Integer l_space= lnameS.indexOf(" "); // check for space in last name
        Integer p_space= pwS.indexOf(" "); // check for space in password
        cids= cid.getText().toString().trim(); // convert computing id into string
        Boolean duplicate= validateDup(cids); // return true if there is a duplicate computing id in DB
        pws= pw.getText().toString().trim(); // convert password into string
        cpws= cpw.getText().toString().trim(); // convert confirm password into string

        Log.i("StudentSignUp", "User has clicked Sign Up");
        if (fname <=0) { // did not enter first name
            Toast.makeText(S_Signup.this, "Please enter your first name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (lname <=0) { // did not enter last name
            Toast.makeText(S_Signup.this, "Please enter your last name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (snum <=0) { // did not enter student id
            Toast.makeText(S_Signup.this, "Please enter your Student ID!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (clength <=0) { // did not enter computing id
            Toast.makeText(S_Signup.this, "Please enter your Computing ID!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (pass !=6) { // password is not 6 characters long
            Toast.makeText(S_Signup.this, "Your password needs to be 6 characters long!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (f_space != -1)	{ // first name contains space
            Toast.makeText(S_Signup.this, "Your first name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (l_space != -1)	{ // last name  contains space
            Toast.makeText(S_Signup.this, "Your last name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (p_space != -1)	{ // password contains space
            Toast.makeText(S_Signup.this, "Your password contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!pws.equals(cpws)) { // password and confirm password do not match
            Toast.makeText(S_Signup.this, "Your password does not match!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (duplicate)	{ // there is a duplicate computing id in user DB
            Toast.makeText(S_Signup.this, "Your Computing ID already exists!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean validateDup (String cid) { // checks for duplicate computing id in user DB
        Cursor cursor = userDb.getAllRows();
        Boolean check= false;
        if (cursor.moveToFirst()) { // traverses through user DB
            do {
                String c= cursor.getString(SDBAdapter.col_cid);
                if (c.equals(cid)) { // return true if there exists a same computing id in user DB
                    check= true;
                    return check;
                }
            } while(cursor.moveToNext());
        }
        return check; // return false if there is no computing id in user DB that is equivalent to user input.
    }
}
