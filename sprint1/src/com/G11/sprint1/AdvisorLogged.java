package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AdvisorLogged extends Activity {
	Button chat;
	Button search;
	Button schedule;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_advisor_logged);
		gosearch();
		gochat();
		goschedule();
	}
	public void gosearch(){
		search=(Button)findViewById(R.id.asearch);
		search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(AdvisorLogged.this,SearchActivity.class);
				startActivity(i);
			}
		});
	}
	public void gochat(){
		chat=(Button)findViewById(R.id.achat);
		chat.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(AdvisorLogged.this,Chat.class);
				startActivity(i);
			}
		});
	}
	public void goschedule(){
		schedule=(Button)findViewById(R.id.aschedule);
		schedule.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(AdvisorLogged.this,Schedule.class);
				startActivity(i);
			}
		});
	}

}
