package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Schedule extends Activity {
	BOOKINGDB base;
    ListView myList;
    long idd;
    String first, last, sday, stime;
    Boolean entry, date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule);
        myList = (ListView) findViewById(R.id.listViewFromDB);

        setupClearButton();
		registerForContextMenu(myList);
        listviewItemClick();
		openDB ();
        populate();


	}

    private void setupClearButton() {
        Button btnClear= (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c= base.getAllRows();
                if (c.getColumnCount() > 0) {
                    base.deleteAll();
                    populate();
                    Toast.makeText(Schedule.this, "All schedule cleared!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Schedule.this, "Schedule is empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        if (v.getId()==R.id.listViewFromDB) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle("Edit Schedule");
            String[] menuItems = getResources().getStringArray(R.array.menu);
            for (int i = 0; i<menuItems.length; i++) {
                menu.add(Menu.NONE, i, i, menuItems[i]);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        String[] menuItems = getResources().getStringArray(R.array.menu);

        switch(menuItemIndex) {
            case 0:
                startActivityForResult(new Intent(getApplicationContext(), Edit_Schedule.class), 1);
                break;
            case 1:
                deleteSchedule(idd);
                populate();
                break;

        }

        return true;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            first= data.getStringExtra("fname");
            last= data.getStringExtra("lname");
            sday= data.getStringExtra("day");
            stime= data.getStringExtra("time");
            entry= true;
            date= true;
            updateSchedule(idd);
            populate();
        }
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



    private void updateSchedule(long id) { // update appointment database based on user input.
        Cursor cursor= base.getRow(id);

        if (entry && date) { // if user-selected time slot is vacant, then finish editing the schedule.
            if (cursor.moveToFirst()) {

                base.updateRow(id, first, last, sday, stime);
                Toast.makeText(Schedule.this,"Edit Successful!",Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        }
        else if (!entry && !date || entry && !date) { // user-selected time slot is occupied and invalid entry.
            return;                                       // or user-selected time slot is vacant and invalid entry.
        }
        else
        {
            Toast.makeText(Schedule.this,"This time has been booked. Please book another time period!",Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteSchedule (long id) {
        Cursor cursor= base.getRow(id);
        base.deleteRow(id);
        Toast.makeText(Schedule.this,"Schedule Successfully Deleted!",Toast.LENGTH_SHORT).show();
    }

    private void listviewItemClick() { // when user clicks a schedule in the listview.
        myList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                idd= id;
                return false;
            }
        });

    }
}