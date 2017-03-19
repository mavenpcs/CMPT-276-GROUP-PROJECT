package com.G11.sprint1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class BOOKINGDB {


	private static final String TAG = "BOOKINGDB";
	public static final String KEY_ROWID = "_id";
	public static final int COL_ROWID = 0;

	public static final String KEY_FIRSTNAME = "firstname";
	public static final String KEY_LASTNAME = "lastname";
	public static final String KEY_DAY = "day";
	public static final String KEY_TIME = "time";
	
	
	
	public static final int COL_FIRSTNAME = 1;
	public static final int COL_LASTNAME = 2;
	public static final int COL_DAY = 3;
	public static final int COL_TIME = 4;

	
	public static final String[] ALL_KEYS = new String[] {KEY_ROWID, KEY_FIRSTNAME, KEY_LASTNAME, KEY_DAY, KEY_TIME};
	
	
	public static final String DATABASE_NAME = "MyDb";
	public static final String DATABASE_TABLE = "mainTable";

	public static final int DATABASE_VERSION = 2;	
	
	private static final String DATABASE_CREATE_SQL = 
			"create table " + DATABASE_TABLE 
			+ " (" + KEY_ROWID + " integer primary key autoincrement, "
			+ KEY_FIRSTNAME + " text not null, "
			+ KEY_LASTNAME + " text not null, "
			+ KEY_DAY + " string not null, "
			+ KEY_TIME + " string not null"
			+ ");";
	
	
	private final Context context;
	
	private DatabaseHelper myDBHelper;
	private SQLiteDatabase db;

	public BOOKINGDB(Context ctx) {
		this.context = ctx;
		myDBHelper = new DatabaseHelper(context);
	}
	
	public BOOKINGDB open() {
		db = myDBHelper.getWritableDatabase();
		return this;
	}
	

	public void close() {
		myDBHelper.close();
	}
	
	public long insertRow(String firstname, String lastname, String day, String time) {

		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_FIRSTNAME, firstname);
		initialValues.put(KEY_LASTNAME, lastname);
		initialValues.put(KEY_DAY, day);
		initialValues.put(KEY_TIME, time);
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
	

	public boolean updateRow(long rowId, String firstname, String lastname, String day, String time) {
		String where = KEY_ROWID + "=" + rowId;
		ContentValues newValues = new ContentValues();
		newValues.put(KEY_FIRSTNAME, firstname);
		newValues.put(KEY_LASTNAME, lastname);
		newValues.put(KEY_DAY, day);
		newValues.put(KEY_TIME, time);
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
