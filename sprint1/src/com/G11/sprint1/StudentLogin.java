package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.G11.sprint1.StudentLogged.loggedIn;

public class StudentLogin extends Activity {
    Boolean l= DataHolder.getInstance().get_s_status(); // receiving user login status (T/F)
	SDBAdapter userDb;
	private EditText cid, pw;
	String cids, pws;
	Button log;
	Button signUp;
	EditText computingid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        if (l) { // If user login status is true, then skip the login activity
            Intent i= new Intent(StudentLogin.this, StudentLogged.class);
            startActivityForResult(i, 0);
            }
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_login);
		openDB ();
		cid= (EditText) findViewById(R.id.editCIDL);
		pw= (EditText) findViewById(R.id.editPwL);
		clickLog();
		setupSignUpButton();
	}



	public void clickLog(){
		log=(Button)findViewById(R.id.sLogin);
		log.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cids= cid.getText().toString().trim();
				pws= pw.getText().toString().trim();

				if (validateInfo (cids, pws)) {
                    DataHolder.getInstance().set_s_status(true); // setting the user login status as true
					computingid=(EditText)findViewById(R.id.editCIDL);
					DataHolder.getInstance().setcomputingid(computingid.getText().toString());
					DataHolder.getInstance().setstudentid("");
					storestudentname(cids,pws);
					Intent i= new Intent(StudentLogin.this, StudentLogged.class);
					startActivityForResult(i,0);
				}
				else {
					Toast.makeText(StudentLogin.this, "Login Failed! Check Your Info!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	private void storestudentname(String id,String pw) {
		openDB();
		Cursor c = userDb.getAllRows();
		if (c.moveToFirst()) {
			do {
				String u = c.getString(SDBAdapter.col_cid);
				String p = c.getString(SDBAdapter.col_pw);
				if (u.equals(id) && p.equals(pw)) {
					DataHolder.getInstance().setfirstname(c.getString(SDBAdapter.col_first));
					DataHolder.getInstance().setlastname(c.getString(SDBAdapter.col_last));
				}

			} while (c.moveToNext());

		}
	}
	public void setupSignUpButton() {
		signUp= (Button) findViewById(R.id.sSignUp);
		signUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(StudentLogin.this, S_Signup.class);
				startActivity(i);
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


	public boolean validateInfo (String cid, String pw) {// validating user login
		Cursor cursor = userDb.getAllRows();
		Boolean check= false;
		if (cursor.moveToFirst()) {
			do {
				String c= cursor.getString(SDBAdapter.col_cid);
				String p= cursor.getString(SDBAdapter.col_pw);
				if (c.equals(cid)) {
					if (p.equals(pw)) {
						check= true;
						return check;
					}
				}
			} while(cursor.moveToNext());
		}
		return check;
	}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == loggedIn)// if user login status is true, then finish the activity
        {
            finish();
        }
    }
}

