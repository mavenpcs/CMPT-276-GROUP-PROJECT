package com.G11.sprint1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Schedule extends Activity {
	SDBAdapter testDb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule);

		openDB ();
        populate();

	}



    @Override
	protected void onDestroy() {
		super.onDestroy();
		closeDB();
	}

	private void closeDB() {
		testDb.close();
	}

	private void openDB() {
		testDb= new SDBAdapter(this);
		testDb.open();
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
    Cursor cursor= testDb.getAllRows();

    startManagingCursor(cursor);

    String [] fromFieldNames= new String []
            {SDBAdapter.key_first, SDBAdapter.key_last, SDBAdapter.key_cid};
    int [] toViewIDs= new int []
            {R.id.txtFirst, R.id.txtLast, R.id.txtCid};

    SimpleCursorAdapter myCursorAdapter =
            new SimpleCursorAdapter(
                    this,		// Context
                    R.layout.schedule_layout,	// Row layout template
                    cursor,					// cursor (set of DB records to map)
                    fromFieldNames,			// DB Column names
                    toViewIDs				// View IDs to put information in
            );
        ListView myList = (ListView) findViewById(R.id.listViewFromDB);
        myList.setAdapter(myCursorAdapter);
    }
}
