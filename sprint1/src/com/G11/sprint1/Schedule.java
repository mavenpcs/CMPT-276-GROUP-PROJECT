package com.G11.sprint1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Schedule extends Activity {
	BOOKINGDB base;
	Spinner sday;
	Spinner stime;
    EditText first, last;
	ListView myList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule);
		myList = (ListView) findViewById(R.id.listViewFromDB);
        first= (EditText) findViewById(R.id.editSFName);
        last= (EditText) findViewById(R.id.editSLName);
		sday=(Spinner)findViewById(R.id.spinDay);
		stime=(Spinner)findViewById(R.id.spinTime);
		ArrayAdapter adapter1= ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
		sday.setAdapter(adapter1);
		ArrayAdapter adapter2= ArrayAdapter.createFromResource(this, R.array.time, android.R.layout.simple_spinner_item);
		stime.setAdapter(adapter2);
		//stime.setOnItemSelectedListener(this);

		openDB ();
        populate();
        listviewItemClick();

	}



    @Override
	protected void onDestroy() {
		super.onDestroy();
		closeDB();
	}

	private void closeDB() {

		base.close();
	}

	private void openDB() {
		base= new BOOKINGDB(this);
		base.open();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.schedule, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
    private void populate() {
    Cursor cursor= base.getAllRows();

    startManagingCursor(cursor);

    String [] fromFieldNames= new String []
            {BOOKINGDB.KEY_FIRSTNAME, BOOKINGDB.KEY_LASTNAME, BOOKINGDB.KEY_DAY,
			BOOKINGDB.KEY_TIME};
    int [] toViewIDs= new int []
            {R.id.txtFirst, R.id.txtLast, R.id.txtDay, R.id.txtTime};

    SimpleCursorAdapter myCursorAdapter =
            new SimpleCursorAdapter(
                    this,		// Context
                    R.layout.schedule_layout,	// Row layout template
                    cursor,					// cursor (set of DB records to map)
                    fromFieldNames,			// DB Column names
                    toViewIDs				// View IDs to put information in
            );
        myList.setAdapter(myCursorAdapter);
    }

    private boolean validateDate () { // check if the time slot is occupied by another student.
        boolean check= true;
        Cursor cursor= base.getAllRows();
        String day= sday.getSelectedItem().toString();
        String time= stime.getSelectedItem().toString();
        if (cursor.moveToFirst()) { // check = false if selected time slot is occupied.
            do {
                if (day.equals(cursor.getString(BOOKINGDB.COL_DAY)) && time.equals(cursor.getString(BOOKINGDB.COL_TIME))){
                    check=false;
                    return check;
                }

            } while (cursor.moveToNext());
        }
        return check;
    }

    private boolean validateEntry() {
        Integer fname= first.getText().toString().trim().length(); // length of first name
        Integer lname= last.getText().toString().trim().length(); // length of last name
        String fnameS= first.getText().toString(); // convert first name into string
        String lnameS= last.getText().toString(); // convert last name into string
        Integer f_space= fnameS.indexOf(" "); // check for space in first name
        Integer l_space= lnameS.indexOf(" "); // check for space in last name

        if (fname <=0) { // did not enter first name
            Toast.makeText(Schedule.this, "Please enter the first name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (lname <=0) { // did not enter last name
            Toast.makeText(Schedule.this, "Please enter the last name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (f_space != -1)	{ // first name contains space
            Toast.makeText(Schedule.this, "The first name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (l_space != -1) { // last name  contains space
            Toast.makeText(Schedule.this, "The last name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void updateSchedule(long id) { // update appointment database based on user input.
        Cursor cursor= base.getRow(id);
        boolean noDupe= validateDate();
        boolean entry= validateEntry();
        if (noDupe && entry) { // if user-selected time slot is vacant, then finish editing the schedule.
            if (cursor.moveToFirst()) {
                String fname = first.getText().toString();
                String lname = last.getText().toString();
                String day = sday.getSelectedItem().toString();
                String time = stime.getSelectedItem().toString();
                base.updateRow(id, fname, lname, day, time);
                Toast.makeText(this,"Edit Successful!",Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }
        else if (!noDupe && !entry || noDupe && !entry) { // user-selected time slot is occupied and invalid entry.
            return;                                       // or user-selected time slot is vacant and invalid entry.
        }
        else
        {
            Toast.makeText(this,"This time slot is occupied. Please select another time slot!",Toast.LENGTH_SHORT).show();
        }
    }

	private void listviewItemClick() { // when user clicks a schedule in the listview.
        myList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                updateSchedule(id);
                populate();
                return false;
            }
        });

        /*myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateSchedule(id); // update the appointments database
                populate(); // display the modified schedule in the listview.
            }
        });*/
    }
}