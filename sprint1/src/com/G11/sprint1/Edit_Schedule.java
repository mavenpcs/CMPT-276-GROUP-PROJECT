package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Edit_Schedule extends Activity {
    BOOKINGDB base2;
    Button btnSubmit;
    EditText first, last;
    Spinner sday, stime;
    Boolean entry, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_schedule);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*0.8),(int)(height*0.5));

        first= (EditText) findViewById(R.id.editSFName);
        last= (EditText) findViewById(R.id.editSLName);
        sday= (Spinner) findViewById(R.id.spinDay2);
        stime= (Spinner) findViewById(R.id.spinTime2);
        ArrayAdapter adapter1= ArrayAdapter.createFromResource(Edit_Schedule.this, R.array.days, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sday.setAdapter(adapter1);
        ArrayAdapter adapter2= ArrayAdapter.createFromResource(Edit_Schedule.this, R.array.time, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stime.setAdapter(adapter2);
        openDB();
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                entry = validateEntry();
                date = validateDate();
                if (entry && date) {
                    Intent i = new Intent();
                    i.putExtra("fname", first.getText().toString());
                    i.putExtra("lname", last.getText().toString());
                    i.putExtra("day", sday.getSelectedItem().toString());
                    i.putExtra("time", stime.getSelectedItem().toString());
                    setResult(RESULT_OK, i);
                    finish();
                }
                else if (!entry && !date || !entry && date) {
                    return;
                }
                else {
                    Toast.makeText(Edit_Schedule.this, "This time has been booked. Please book another time period!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }

    private void closeDB() {

        base2.close();
    }

    private void openDB() {
        base2= new BOOKINGDB(this);
        base2.open();
    }

    private boolean validateDate () { // check if the time slot is occupied by another student.
        boolean check= true;
        Cursor cursor= base2.getAllRows();
        String bookingday= sday.getSelectedItem().toString();
        String bookingtime= stime.getSelectedItem().toString();

        if (cursor.moveToFirst()) { // check = false if selected time slot is occupied.
            do {
                if (bookingday.equals(cursor.getString(BOOKINGDB.COL_DAY)) && bookingtime.equals(cursor.getString(BOOKINGDB.COL_TIME))){
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

        Integer f_space= first.getText().toString().indexOf(" "); // check for space in first name
        Integer l_space= last.getText().toString().indexOf(" "); // check for space in last name

        if (fname <=0) { // did not enter first name
            Toast.makeText(Edit_Schedule.this, "Please enter the first name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (lname <=0) { // did not enter last name
            Toast.makeText(Edit_Schedule.this, "Please enter the last name!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (f_space != -1)	{ // first name contains space
            Toast.makeText(Edit_Schedule.this, "The first name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (l_space != -1) { // last name  contains space
            Toast.makeText(Edit_Schedule.this, "The last name contains space!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
