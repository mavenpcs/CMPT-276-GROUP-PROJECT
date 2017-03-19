package com.G11.sprint1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Grade extends Activity {
	TextView showgrade;
	Cursor cursor;
	String course1;
	String course2;
	String course3;
	String course4;
	String course5;
	String course6;
	String course7;
	String course8;
	String course9;
	String course10;
	String grade1;
	String grade2;
	String grade3;
	String grade4;
	String grade5;
	String grade6;
	String grade7;
	String grade8;
	String grade9;
	String grade10;
	String studentid;
	String computingid;
	STUDENTINFO base;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grade);
		studentid=DataHolder.getInstance().getstudnetid();
		computingid=DataHolder.getInstance().getcomputingid();
		String course1=getcourse1(computingid,studentid);
		String course2=getcourse2(computingid,studentid);
		String course3=getcourse3(computingid,studentid);
		String course4=getcourse4(computingid,studentid);
		String course5=getcourse5(computingid,studentid);
		String course6=getcourse6(computingid,studentid);
		String course7=getcourse7(computingid,studentid);
		String course8=getcourse8(computingid,studentid);
		String course9=getcourse9(computingid,studentid);
		String course10=getcourse10(computingid,studentid);
		String grade1=getgrade1(computingid,studentid);
		String grade2=getgrade2(computingid,studentid);
		String grade3=getgrade3(computingid,studentid);
		String grade4=getgrade4(computingid,studentid);
		String grade5=getgrade5(computingid,studentid);
		String grade6=getgrade6(computingid,studentid);
		String grade7=getgrade7(computingid,studentid);
		String grade8=getgrade8(computingid,studentid);
		String grade9=getgrade9(computingid,studentid);
		String grade10=getgrade10(computingid,studentid);
		showgrade=(TextView)findViewById(R.id.showgrade);
		showgrade.setText(course1+" "+grade1+"\n"+
				course2+" "+grade2+"\n"+
				course3+" "+grade3+"\n"+
				course4+" "+grade4+"\n"+
				course5+" "+grade5+"\n"+
				course6+" "+grade6+"\n"+
				course7+" "+grade7+"\n"+
				course8+" "+grade8+"\n"+
				course9+" "+grade9+"\n"+
				course10+" "+grade10+"\n");
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
					return cursor.getString(STUDENTINFO.COL_COURSE1);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}	private String getcourse2(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSE2);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}	private String getcourse3(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSE3);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}	private String getcourse4(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSE4);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}	private String getcourse5(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSE5);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}	private String getcourse6(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSE6);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}	private String getcourse7(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSE7);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}	private String getcourse8(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSE8);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}	private String getcourse9(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSE9);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getcourse10(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_COURSE10);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getgrade1(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE1);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getgrade2(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE2);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getgrade3(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE3);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getgrade4(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE4);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getgrade5(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE5);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getgrade6(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE6);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getgrade7(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE7);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getgrade8(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE8);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}
	private String getgrade9(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE9);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}	private String getgrade10(String cmptid, String stdid){
		openDB();
		cursor = base.getAllRows();
		cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			do {
				if (cursor.getString(STUDENTINFO.COL_COMPUTINGID).equals(cmptid) || cursor.getString(STUDENTINFO.COL_STUDENTID).equals(stdid)) {
					return cursor.getString(STUDENTINFO.COL_GRADE10);
				}
			} while (cursor.moveToNext());
		}
		return "";
	}



}
