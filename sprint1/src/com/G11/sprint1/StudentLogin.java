package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentLogin extends Activity {
	SDBAdapter userDb;
	//Boolean validated;
	private EditText cid, pw;
	String cids, pws;
	Button log;
	Button signUp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
					Intent i= new Intent(StudentLogin.this, StudentLogged.class);
					startActivity(i);
				}
				else {
					Toast.makeText(StudentLogin.this, "Login Failed! Check Your Info!", Toast.LENGTH_SHORT).show();
				}
			}
		});
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


	public boolean validateInfo (String cid, String pw) {
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
}

