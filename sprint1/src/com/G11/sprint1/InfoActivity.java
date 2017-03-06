package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class InfoActivity extends Activity {
	Button goGrade;
	Button goMajor;
	Button goCourse;
	Button goSchedule;
	Button goChat;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		toGrade();
		toCourse();
		toMajor();
		toSchedule();
		toChat();
	}
	public void toGrade(){
		goGrade = (Button)findViewById(R.id.showgrade);
		goGrade.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i1=new Intent(InfoActivity.this,Grade.class);
				startActivity(i1);
			}
		});
	}
	public void toCourse(){
		goCourse = (Button)findViewById(R.id.showcourse);
		goCourse.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i2=new Intent(InfoActivity.this,Course.class);
				startActivity(i2);
			}
		});
	}
	public void toMajor(){
		goMajor = (Button)findViewById(R.id.showmajor);
		goMajor.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i3=new Intent(InfoActivity.this,Major.class);
				startActivity(i3);
			}
		});
	}
	public void toSchedule(){
		goSchedule = (Button)findViewById(R.id.showschedule);
		goSchedule.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i4=new Intent(InfoActivity.this,Schedule.class);
				startActivity(i4);
			}
		});
	}
	public void toChat(){
		goChat = (Button)findViewById(R.id.showchat);
		goChat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i5=new Intent(InfoActivity.this,Chat.class);
				startActivity(i5);
			}
		});
	}

}
