package com.G11.sprint1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class STUDENTINFO {


	private static final String TAG = "STUDENTINFO";
	public static final String KEY_ROWID = "_id";
	public static final int COL_ROWID = 0;

	public static final String KEY_FIRSTNAME = "firstname";
	public static final String KEY_LASTNAME = "lastname";
	public static final String KEY_MAJOR = "major";
	public static final String KEY_COURSE1 = "course1";
	public static final String KEY_COURSE2 = "course2";
	public static final String KEY_COURSE3 = "course3";
	public static final String KEY_COURSE4 = "course4";
	public static final String KEY_COURSE5 = "course5";
	public static final String KEY_COURSE6 = "course6";
	public static final String KEY_COURSE7 = "course7";
	public static final String KEY_COURSE8 = "course8";
	public static final String KEY_COURSE9 = "course9";
	public static final String KEY_COURSE10 = "course10";
	public static final String KEY_GRADE1 = "grade1";
	public static final String KEY_GRADE2 = "grade2";
	public static final String KEY_GRADE3 = "grade3";
	public static final String KEY_GRADE4 = "grade4";
	public static final String KEY_GRADE5 = "grade5";
	public static final String KEY_GRADE6 = "grade6";
	public static final String KEY_GRADE7 = "grade7";
	public static final String KEY_GRADE8 = "grade8";
	public static final String KEY_GRADE9 = "grade9";
	public static final String KEY_GRADE10 = "grade10";
	public static final String KEY_COURSETAKING1 = "coursetaking1";
	public static final String KEY_COURSETAKING2 = "coursetaking2";
	public static final String KEY_COURSETAKING3 = "coursetaking3";
	public static final String KEY_COURSETAKING4 = "coursetaking4";
	public static final String KEY_STUDENTID = "studentid";
	public static final String KEY_COMPUTINGID = "computingid";





	public static final int COL_FIRSTNAME = 1;
	public static final int COL_LASTNAME = 2;
	public static final int COL_MAJOR = 3;
	public static final int COL_COURSE1=4;
	public static final int COL_COURSE2=5 ;
	public static final int COL_COURSE3=6 ;
	public static final int COL_COURSE4=7 ;
	public static final int COL_COURSE5=8 ;
	public static final int COL_COURSE6=9 ;
	public static final int COL_COURSE7=10 ;
	public static final int COL_COURSE8=11 ;
	public static final int COL_COURSE9=12 ;
	public static final int COL_COURSE10=13 ;
	public static final int COL_GRADE1=14 ;
	public static final int COL_GRADE2=15 ;
	public static final int COL_GRADE3=16 ;
	public static final int COL_GRADE4=17 ;
	public static final int COL_GRADE5=18 ;
	public static final int COL_GRADE6=19 ;
	public static final int COL_GRADE7=20 ;
	public static final int COL_GRADE8=21 ;
	public static final int COL_GRADE9=22 ;
	public static final int COL_GRADE10=23 ;
	public static final int COL_COURSETAKING1 = 24;
	public static final int COL_COURSETAKING2 = 25;
	public static final int COL_COURSETAKING3 = 26;
	public static final int COL_COURSETAKING4 = 27;
	public static final int COL_STUDENTID=28;
	public static final int COL_COMPUTINGID=29;




	public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_FIRSTNAME, KEY_LASTNAME, KEY_MAJOR, KEY_COURSE1
			, KEY_COURSE2, KEY_COURSE3, KEY_COURSE4, KEY_COURSE5, KEY_COURSE6, KEY_COURSE7, KEY_COURSE8, KEY_COURSE9, KEY_COURSE10
			, KEY_GRADE1, KEY_GRADE2, KEY_GRADE3, KEY_GRADE4, KEY_GRADE5, KEY_GRADE6, KEY_GRADE7, KEY_GRADE8, KEY_GRADE9, KEY_GRADE10
			,KEY_COURSETAKING1,KEY_COURSETAKING2,KEY_COURSETAKING3,KEY_COURSETAKING4,KEY_STUDENTID,KEY_COMPUTINGID};


	public static final String DATABASE_NAME = "Studentinfo DB";
	public static final String DATABASE_TABLE = "mainTable";

	public static final int DATABASE_VERSION = 2;

	private static final String DATABASE_CREATE_SQL =
			"create table " + DATABASE_TABLE
					+ " (" + KEY_ROWID + " integer primary key autoincrement, "
					+ KEY_FIRSTNAME + " string not null, "
					+ KEY_LASTNAME + " string not null, "
					+ KEY_MAJOR + " string not null, "
					+ KEY_COURSE1+" string not null, "
					+ KEY_COURSE2+" string not null, "
					+ KEY_COURSE3+" string not null, "
					+ KEY_COURSE4+" string not null, "
					+ KEY_COURSE5+" string not null, "
					+ KEY_COURSE6+" string not null, "
					+ KEY_COURSE7+" string not null, "
					+ KEY_COURSE8+" string not null, "
					+ KEY_COURSE9+" string not null, "
					+ KEY_COURSE10+" string not null, "
					+ KEY_GRADE1 + " string not null, "
					+ KEY_GRADE2 + " string not null, "
					+ KEY_GRADE3 + " string not null, "
					+ KEY_GRADE4 + " string not null, "
					+ KEY_GRADE5 + " string not null, "
					+ KEY_GRADE6 + " string not null, "
					+ KEY_GRADE7 + " string not null, "
					+ KEY_GRADE8 + " string not null, "
					+ KEY_GRADE9 + " string not null, "
					+ KEY_GRADE10 + " string not null, "
					+ KEY_COURSETAKING1 + " string not null, "
					+ KEY_COURSETAKING2 + " string not null, "
					+ KEY_COURSETAKING3 + " string not null, "
					+ KEY_COURSETAKING4 + " string not null, "
					+ KEY_STUDENTID + " string not null, "
					+ KEY_COMPUTINGID + " string not null"
					+ ");";


	private final Context context;

	private DatabaseHelper myDBHelper;
	private SQLiteDatabase db;

	public STUDENTINFO(Context ctx) {
		this.context = ctx;
		myDBHelper = new DatabaseHelper(context);
	}

	public STUDENTINFO open() {
		db = myDBHelper.getWritableDatabase();
		return this;
	}


	public void close() {
		myDBHelper.close();
	}

	public long insertRow(String firstname, String lastname, String major, String course1, String course2
			, String course3, String course4, String course5, String course6, String course7, String course8
			, String course9, String course10,String grade1,String grade2,String grade3,String grade4,String grade5
			,String grade6,String grade7,String grade8,String grade9,String grade10,String ctaking1,String ctaking2
			,String ctaking3,String ctaking4,String studentid,String computingid) {

		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_FIRSTNAME, firstname);
		initialValues.put(KEY_LASTNAME, lastname);
		initialValues.put(KEY_MAJOR, major);
		initialValues.put(KEY_COURSE1, course1);
		initialValues.put(KEY_COURSE2, course2);
		initialValues.put(KEY_COURSE3, course3);
		initialValues.put(KEY_COURSE4, course4);
		initialValues.put(KEY_COURSE5, course5);
		initialValues.put(KEY_COURSE6, course6);
		initialValues.put(KEY_COURSE7, course7);
		initialValues.put(KEY_COURSE8, course8);
		initialValues.put(KEY_COURSE9, course9);
		initialValues.put(KEY_COURSE10, course10);
		initialValues.put(KEY_GRADE1, grade1);
		initialValues.put(KEY_GRADE2, grade2);
		initialValues.put(KEY_GRADE3, grade3);
		initialValues.put(KEY_GRADE4, grade4);
		initialValues.put(KEY_GRADE5, grade5);
		initialValues.put(KEY_GRADE6, grade6);
		initialValues.put(KEY_GRADE7, grade7);
		initialValues.put(KEY_GRADE8, grade8);
		initialValues.put(KEY_GRADE9, grade9);
		initialValues.put(KEY_GRADE10, grade10);
		initialValues.put(KEY_COURSETAKING1, ctaking1);
		initialValues.put(KEY_COURSETAKING2, ctaking2);
		initialValues.put(KEY_COURSETAKING3, ctaking3);
		initialValues.put(KEY_COURSETAKING4, ctaking4);
		initialValues.put(KEY_STUDENTID, studentid);
		initialValues.put(KEY_COMPUTINGID, computingid);


		return db.insert(DATABASE_TABLE, null, initialValues);
	}


	public Cursor getAllRows() {
		String where = null;
		Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS,
				where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}


	public Cursor getRow(long rowId) {
		String where = KEY_ROWID + "=" + rowId;
		Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS,
				where, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
		}
		return c;
	}


	public boolean updateRow(long rowId, String firstname, String lastname, String major, String course1
			, String course2, String course3, String course4, String course5, String course6, String course7
			, String course8, String course9, String course10, String grade1, String grade2, String grade3
			, String grade4, String grade5, String grade6, String grade7, String grade8, String grade9
			, String grade10, String ctaking1, String ctaking2, String ctaking3, String ctaking4,String studentid
			,String computingid) {
		String where = KEY_ROWID + "=" + rowId;
		ContentValues newValues = new ContentValues();
		newValues.put(KEY_FIRSTNAME, firstname);
		newValues.put(KEY_LASTNAME, lastname);
		newValues.put(KEY_MAJOR, major);
		newValues.put(KEY_COURSE1, course1);
		newValues.put(KEY_COURSE2, course2);
		newValues.put(KEY_COURSE3, course3);
		newValues.put(KEY_COURSE4, course4);
		newValues.put(KEY_COURSE5, course5);
		newValues.put(KEY_COURSE6, course6);
		newValues.put(KEY_COURSE7, course7);
		newValues.put(KEY_COURSE8, course8);
		newValues.put(KEY_COURSE9, course9);
		newValues.put(KEY_COURSE10, course10);
		newValues.put(KEY_GRADE1, grade1);
		newValues.put(KEY_GRADE2, grade2);
		newValues.put(KEY_GRADE3, grade3);
		newValues.put(KEY_GRADE4, grade4);
		newValues.put(KEY_GRADE5, grade5);
		newValues.put(KEY_GRADE6, grade6);
		newValues.put(KEY_GRADE7, grade7);
		newValues.put(KEY_GRADE8, grade8);
		newValues.put(KEY_GRADE9, grade9);
		newValues.put(KEY_GRADE10, grade10);
		newValues.put(KEY_COURSETAKING1, ctaking1);
		newValues.put(KEY_COURSETAKING2, ctaking2);
		newValues.put(KEY_COURSETAKING3, ctaking3);
		newValues.put(KEY_COURSETAKING4, ctaking4);
		newValues.put(KEY_STUDENTID, studentid);
		newValues.put(KEY_COMPUTINGID, computingid);
		return db.update(DATABASE_TABLE, newValues, where, null) != 0;
	}


	private static class DatabaseHelper extends SQLiteOpenHelper
	{
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase _db) {
			_db.execSQL(DATABASE_CREATE_SQL);
		}

		@Override
		public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading application's database from version " + oldVersion
					+ " to " + newVersion + ", which will destroy all old data!");

			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);


			onCreate(_db);
		}
	}
}
