package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button log;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		clickLog();
	}
	public void clickLog(){
		log=(Button)findViewById(R.id.Login);
		log.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(MainActivity.this,SearchActivity.class);
				startActivity(i);
			}
		});
	}
}
