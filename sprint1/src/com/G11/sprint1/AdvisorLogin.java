package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.G11.sprint1.AdvisorLogged.loggedIn;

public class AdvisorLogin extends Activity {
	Boolean l= DataHolder.getInstance().get_a_status();
	ADBAdapter userDb;
	private EditText cid, pw;
	String cids, pws;
	Button log;
	Button signUp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (l) {
			Intent i= new Intent(AdvisorLogin.this, AdvisorLogged.class);
			startActivityForResult(i, 0);
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advisor_login);
		openDB ();
		cid= (EditText) findViewById(R.id.editACIDL);
		pw= (EditText) findViewById(R.id.editAPwL);

		clickLog();
		setupSignUpButton();
	}



	public void clickLog(){
		log=(Button)findViewById(R.id.aLogin);
		log.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cids= cid.getText().toString().trim();
				pws= pw.getText().toString().trim();

				if (validateInfo (cids, pws)) {
					DataHolder.getInstance().set_a_status(true);
					Intent i= new Intent(AdvisorLogin.this, AdvisorLogged.class);
					startActivityForResult(i, 0);


				}
				else {
					Toast.makeText(AdvisorLogin.this, "Login Failed! Check Your Info!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	public void setupSignUpButton() {
		signUp= (Button) findViewById(R.id.aSignUp);
		signUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(AdvisorLogin.this, A_Signup.class);
				startActivity(i);
				storeadvisorname( cids, pws);
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

	private void storeadvisorname(String id,String pw) {
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
	public boolean validateInfo (String cid, String pw) {
		Cursor cursor = userDb.getAllRows();
		Boolean check= false;
		if (cursor.moveToFirst()) {
			do {
				String c= cursor.getString(ADBAdapter.col_cid);
				String p= cursor.getString(ADBAdapter.col_pw);
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
		if (resultCode == loggedIn)
		{
			finish();
		}
	}
}

