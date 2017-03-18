package com.G11.sprint1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity {
    SDBAdapter userDb;
    private EditText last, first, sid, cid, pw, cpw;
    int sidi;
    String lasts, firsts, cids, pws, cpws;
    Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
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
                    Log.i("Signup", "User has clicked Sign Up");
                    Toast.makeText(Signup.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                    long newId= userDb.insertRow(firsts, lasts, sidi, cids, pws);
                    Intent i= new Intent(Signup.this, StudentLogin.class);
                    startActivity(i);
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
        Integer fname= first.getText().toString().trim().length();
        Integer lname= last.getText().toString().trim().length();
        Integer snum= sid.getText().toString().trim().length();
        Integer clength= cid.getText().toString().trim().length();
        Integer pass= pw.getText().toString().trim().length();
        String fnameS= first.getText().toString();
        String lnameS= last.getText().toString();
        String pwS= pw.getText().toString();
        Integer f_space= fnameS.indexOf(" ");
        Integer l_space= lnameS.indexOf(" ");
        Integer p_space= pwS.indexOf(" ");
        cids= cid.getText().toString().trim();
        Boolean duplicate= validateDup(cids);
        pws= pw.getText().toString().trim();
        cpws= cpw.getText().toString().trim();

        Log.i("StudentLogin", "User has clicked Sign In");
        if (fname <=0) {
            Toast.makeText(Signup.this, "Please enter your first name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (lname <=0) {
            Toast.makeText(Signup.this, "Please enter your last name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (snum <=0) {
            Toast.makeText(Signup.this, "Please enter your Student ID!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (clength <=0) {
            Toast.makeText(Signup.this, "Please enter your Computing ID!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (pass !=6) {
            Toast.makeText(Signup.this, "Your password needs to be 6 characters long!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (f_space != -1)	{
            Toast.makeText(Signup.this, "Your first name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (l_space != -1)	{
            Toast.makeText(Signup.this, "Your last name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (p_space != -1)	{
            Toast.makeText(Signup.this, "Your password contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!pws.equals(cpws)) {
            Toast.makeText(Signup.this, "Your password does not match!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (duplicate)	{
            Toast.makeText(Signup.this, "Your Computing ID already exists!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public boolean validateDup (String cid) {
        Cursor cursor = userDb.getAllRows();
        Boolean check= false;
        if (cursor.moveToFirst()) {
            do {
                String c= cursor.getString(SDBAdapter.col_cid);
                if (c.equals(cid)) {
                    check= true;
                    return check;
                }
            } while(cursor.moveToNext());
        }
        return check;
    }
}
