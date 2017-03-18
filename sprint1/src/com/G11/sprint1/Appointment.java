package com.G11.sprint1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Appointment extends Activity implements AdapterView.OnItemSelectedListener{
	Spinner sday;
	Spinner stime;
	Button book;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appointment);
		sday=(Spinner)findViewById(R.id.dayspinner);
		stime=(Spinner)findViewById(R.id.timespinner);
		ArrayAdapter adapter1= ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
		sday.setAdapter(adapter1);
		ArrayAdapter adapter2= ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_item);
		stime.setAdapter(adapter2);
	}


	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		clickbook();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
	public void clickbook(){

	}
}
