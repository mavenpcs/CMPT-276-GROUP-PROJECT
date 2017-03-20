package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
//test
//123
//kjh;kjh
//kjh
//test2
public class MainActivity extends Activity {
	Button alog, slog, set;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		clickaLog();
		clicksLog();
		//clickSet();
	}

	/*public void clickSet() {
		set=(Button)findViewById(R.id.btnSet);
		set.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i= new Intent(MainActivity.this, Settings.class);
				startActivity(i);
			}
		});
	}*/

	public void clickaLog(){
		alog=(Button)findViewById(R.id.advisorlogin);
		alog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(MainActivity.this,AdvisorLogin.class);
				startActivity(i);
			}
		});
	}
	public void clicksLog(){
		slog=(Button)findViewById(R.id.studentlogin);
		slog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(MainActivity.this,StudentLogin.class);
				startActivity(i);
			}
		});
	}
}
