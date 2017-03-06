package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentLogin extends Activity {

	Button log;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_login);
		clickLog();
	}
	public void clickLog(){
		log=(Button)findViewById(R.id.sLogin);
		log.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(StudentLogin.this,StudentLogged.class);
				startActivity(i);
			}
		});
	}
}

