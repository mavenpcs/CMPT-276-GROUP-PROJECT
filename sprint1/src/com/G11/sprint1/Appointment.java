package com.G11.sprint1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Appointment extends Activity implements AdapterView.OnItemSelectedListener{
	Spinner sday;
	Spinner stime;
	Button book;
	BOOKINGDB base;
	Cursor bc;
	String bookingday;
	String bookingtime;
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
		stime.setOnItemSelectedListener(this);
	}



	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
		bookingday=sday.getSelectedItem().toString();
		bookingtime=stime.getSelectedItem().toString();
		Toast.makeText(this,"You selected "+bookingday+" at "+bookingtime,Toast.LENGTH_SHORT).show();
		openDB();
		bc=base.getAllRows();
		bc.moveToFirst();
		clickbook(bc);


	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		closeDB();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
	private void openDB(){
		base=new BOOKINGDB(this);
		base.open();

	}
	private void closeDB(){
		base.close();
	}
	public void clickbook(Cursor c){

		book=(Button)findViewById(R.id.bookappointment);
		book.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				bookingday=sday.getSelectedItem().toString();
				bookingtime=stime.getSelectedItem().toString();
				if(c.moveToFirst()) {
					do {
						if (bookingday.equals(c.getString(BOOKINGDB.COL_DAY)) && bookingtime.equals(c.getString(BOOKINGDB.COL_TIME))) {
							AlertDialog.Builder warning = new AlertDialog.Builder(Appointment.this);
							warning.setMessage("This time has been booked! Please book another time period.");
							warning.setPositiveButton("OK", new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									dialog.cancel();
								}
							});
							AlertDialog alert = warning.create();
							alert.setTitle("Warning!");
							alert.show();
						} else {
							base.insertRow("","",bookingday,bookingtime);
							AlertDialog.Builder warning = new AlertDialog.Builder(Appointment.this);
							warning.setMessage("Booked!");
							warning.setPositiveButton("OK", new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									// TODO Auto-generated method stub
									Intent i = new Intent(Appointment.this, StudentLogged.class);
									startActivity(i);
								}
							});
							AlertDialog alert = warning.create();
							alert.setTitle("Success!");
							alert.show();
						}

					} while (c.moveToNext());
				}
				if(!c.moveToFirst()){
					base.insertRow("","",bookingday,bookingtime);
					AlertDialog.Builder warning1=new AlertDialog.Builder(Appointment.this);
					warning1.setMessage("Booked!");
					warning1.setPositiveButton("OK", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Intent i=new Intent(Appointment.this,StudentLogged.class);
							startActivity(i);
						}
					});
					AlertDialog alert=warning1.create();
					alert.setTitle("Success!");
					alert.show();
				}

			}
		});


	}
}
