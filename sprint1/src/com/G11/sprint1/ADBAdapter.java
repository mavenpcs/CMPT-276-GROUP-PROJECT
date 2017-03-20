package com.G11.sprint1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ADBAdapter {

    private static final String TAG= "ADBAdapter";

    public static final String key_rowid= "_id";
    public static final String key_first= "first";
    public static final String key_last= "last";
    public static final String key_cid= "cid";
    public static final String key_pw= "pw";

    public static final String[] all_keys= new String[] {key_rowid, key_first, key_last,
             key_cid, key_pw};

    public static final int col_rowid= 0;
    public static final int col_first= 1;
    public static final int col_last= 2;
    public static final int col_cid= 3;
    public static final int col_pw= 4;

    public static final String database_name= "AdminLoginDatabase";
    public static final String database_table= "AdminInfoTable";
    public static final int database_version= 1;

    private static final String database_create_sql=
            "create table " + database_table
                    + " (" + key_rowid + " integer primary key autoincrement, "
                    + key_first + " text not null, "
                    + key_last + " text not null, "
                    + key_cid + " text not null, "
                    + key_pw + " text not null"
                    + ");";
    private final Context context;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;

    public ADBAdapter (Context ctx) {
        this.context= ctx;
        myDBHelper= new DatabaseHelper (context);

    }
    public ADBAdapter open () {
        db= myDBHelper.getWritableDatabase ();
        return this;
    }

    public void close () {
        myDBHelper.close ();
    }

    public long insertRow (String first, String last, String cid, String pw) {
        ContentValues initialValues= new ContentValues ();
        initialValues.put(key_first, first);
        initialValues.put(key_last, last);
        initialValues.put(key_cid, cid);
        initialValues.put(key_pw, pw);

        return db.insert(database_table, null, initialValues);
    }

    public boolean deleteRow (long rowId) {
        String where= key_rowid + "=" +rowId;
        return db.delete (database_table, where, null) != 0;
    }

    public void deleteAll () {
        Cursor c= getAllRows ();
        long rowId= c.getColumnIndexOrThrow (key_rowid);
        if (c.moveToFirst ()) {
            do {
                deleteRow(c.getLong((int) rowId));
            } while (c.moveToNext ());
        }
    }
    public Cursor getAllRows() {
        String where= null;
        Cursor c= db.query(true, database_table, all_keys, where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst ();
        }
        return c;
    }
    public Cursor getRow (long rowId) {
        String where= key_rowid + "=" + rowId;
        Cursor c= db.query(true,  database_table, all_keys, where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst ();
        }
        return c;
    }

    public boolean updateRow (long rowId, String first, String last, String cid, String pw) {
        String where= key_rowid + "=" + rowId;
        ContentValues newValues= new ContentValues ();
        newValues.put(key_first, first);
        newValues.put(key_last, last);
        newValues.put(key_cid, cid);
        newValues.put(key_pw, pw);
        return db.update(database_table, newValues, where, null) != 0;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper (Context context) {
            super(context, database_name, null, database_version);
        }

        @Override
        public void onCreate (SQLiteDatabase _db) {
            _db.execSQL(database_create_sql);
        }

        @Override
        public void onUpgrade (SQLiteDatabase _db, int oldVersion, int newVersion) {
            Log.w (TAG, "Upgrading application's database from version " + oldVersion + " to "
                    + newVersion + ", which will destory all old data!");
            _db.execSQL("DROP TABLE IF EXISTS " + database_table);
            onCreate(_db);
        }


    }

}

