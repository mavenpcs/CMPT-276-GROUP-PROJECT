package com.G11.sprint1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AdvisorEditInfo extends Activity {
    EditText first;
    EditText last;
    EditText major;
    EditText course1;
    EditText course2;
    EditText course3;
    EditText course4;
    EditText course5;
    EditText course6;
    EditText course7;
    EditText course8;
    EditText course9;
    EditText course10;
    EditText grade1;
    EditText grade2;
    EditText grade3;
    EditText grade4;
    EditText grade5;
    EditText grade6;
    EditText grade7;
    EditText grade8;
    EditText grade9;
    EditText grade10;
    EditText taking1;
    EditText taking2;
    EditText taking3;
    EditText taking4;
    EditText studentid;
    EditText computingid;
    Button add;
    STUDENTINFO DB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_advisoreditinfo);
        super.onCreate(savedInstanceState);
        openDB();
        clickadd();



    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        DB.close();
    }
    //the click function make the ADD button clickable, and store the input to the STUDENTINFO database]
    private void openDB(){
        DB = new STUDENTINFO(this);
        DB.open();
    }
    public void clickadd(){
        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                storedata();
                AlertDialog.Builder A = new AlertDialog.Builder(AdvisorEditInfo.this);
                A.setMessage("Data pushed.");
                A.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Intent i=new Intent(AdvisorEditInfo.this,AdvisorLogged.class);
                        startActivity(i);
                    }
                });
                AlertDialog alert = A.create();
                alert.setTitle("Successfully!");
                alert.show();
            }
        });
    }
    //the storedata function stores each input in the database
    private void storedata(){

        first=(EditText)findViewById(R.id.firstname);
        last=(EditText)findViewById(R.id.lastname);
        major=(EditText)findViewById(R.id.majora);
        course1=(EditText)findViewById(R.id.course1);
        course2=(EditText)findViewById(R.id.course2);
        course3=(EditText)findViewById(R.id.course3);
        course4=(EditText)findViewById(R.id.course4);
        course5=(EditText)findViewById(R.id.course5);
        course6=(EditText)findViewById(R.id.course6);
        course7=(EditText)findViewById(R.id.course7);
        course8=(EditText)findViewById(R.id.course8);
        course9=(EditText)findViewById(R.id.course9);
        course10=(EditText)findViewById(R.id.course10);
        grade1=(EditText)findViewById(R.id.grade1);
        grade2=(EditText)findViewById(R.id.grade2);
        grade3=(EditText)findViewById(R.id.grade3);
        grade4=(EditText)findViewById(R.id.grade4);
        grade5=(EditText)findViewById(R.id.grade5);
        grade6=(EditText)findViewById(R.id.grade6);
        grade7=(EditText)findViewById(R.id.grade7);
        grade8=(EditText)findViewById(R.id.grade8);
        grade9=(EditText)findViewById(R.id.grade9);
        grade10=(EditText)findViewById(R.id.grade10);
        studentid=(EditText)findViewById(R.id.studentid1);
        computingid=(EditText)findViewById(R.id.computingid1);
        taking1=(EditText)findViewById(R.id.taking1);
        taking2=(EditText)findViewById(R.id.taking2);
        taking3=(EditText)findViewById(R.id.taking3);
        taking4=(EditText)findViewById(R.id.taking4);
        DB.insertRow(first.getText().toString(),last.getText().toString(),major.getText().toString(),course1.getText().toString(),course2.getText().toString(),
                course3.getText().toString(),course4.getText().toString(),course5.getText().toString(),course6.getText().toString(),course7.getText().toString(),
                course8.getText().toString(),course9.getText().toString(),course10.getText().toString(),grade1.getText().toString(),grade2.getText().toString(),
                grade3.getText().toString(),grade4.getText().toString(),grade5.getText().toString(),grade6.getText().toString(),grade7.getText().toString(),
                grade8.getText().toString(),grade9.getText().toString(),grade10.getText().toString(),taking1.getText().toString(),taking2.getText().toString(),
                taking3.getText().toString(),taking4.getText().toString(),studentid.getText().toString(),computingid.getText().toString());


    }
}