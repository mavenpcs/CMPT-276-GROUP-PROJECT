package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class StudentLogged extends Activity {
	Button appointment;
	Button chat;
	Button course;
	Button grade;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_logged);
		goapp();
		gochat();
		gocourse();
		gograde();
	}
	public void goapp(){
		appointment=(Button)findViewById(R.id.clickbookappointment);
		appointment.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(StudentLogged.this,Appointment.class);
				startActivity(i);
			}
		});
	}
	public void gochat(){
		chat=(Button)findViewById(R.id.clickchat);
		chat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(StudentLogged.this,Chat.class);
				startActivity(i);
			}
		});
	}
	public void gograde(){
		course=(Button)findViewById(R.id.clickcourse);
		course.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(StudentLogged.this,Course.class);
				startActivity(i);
			}
		});
	}
	public void gocourse(){
		grade=(Button)findViewById(R.id.clickgrade);
		grade.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(StudentLogged.this,Grade.class);
				startActivity(i);
			}
		});
	}

}
