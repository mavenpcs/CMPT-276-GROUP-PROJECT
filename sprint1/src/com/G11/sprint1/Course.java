package com.G11.sprint1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Course extends Activity {
	TextView coursesbox;
	STUDENTINFO base;
	Cursor cursor;
	String course1;
	String course2;
	String course3;
	String course4;
	String studentid;
	String computingid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course);
		coursesbox=(TextView)findViewById(R.id.showcourses);
		studentid=DataHolder.getInstance().getstudnetid();
		computingid=DataHolder.getInstance().getcomputingid();
		course1=getcourse1(computingid,studentid);
		course2=getcourse2(computingid,studentid);
		course3=getcourse3(computingid,studentid);
		course4=getcourse4(computingid,studentid);
		coursesbox.setText(course1+'\n'+course2+'\n'+course3+'\n'+course4);
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

	private String getcourse1(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSETAKING1);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getcourse2(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSETAKING2);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}

	private String getcourse3(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSETAKING3);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}

	private String getcourse4(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSETAKING4);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}


}
