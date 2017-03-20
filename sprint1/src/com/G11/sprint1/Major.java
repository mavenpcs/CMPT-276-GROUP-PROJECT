package com.G11.sprint1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;

public class Major extends Activity {
	TextView major;
	String computingid;
	String studentid;
	String mj;
	STUDENTINFO base;
	Cursor cursor;
	String lastname;
	String firstname;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_major);
		major = (TextView)findViewById(R.id.showmajor);
		studentid=DataHolder.getInstance().getstudnetid();
		computingid=DataHolder.getInstance().getcomputingid();
		major.setText(getstudentmajor(computingid,studentid));

	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		base.close();
	}

	private void openDB(){
		base=new STUDENTINFO(this);
		base.open();
	}
//get student's major from the database by searching studnet's id
	private String getstudentmajor(String cmptid, String stdid) {
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_MAJOR);
				}
			} while (cursor.moveToNext());
		}
		return "student info not found!";
	}

}

