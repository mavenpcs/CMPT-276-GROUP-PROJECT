package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends Activity {
	Button search;
	EditText studentid;
	EditText computingid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);

		clicksearch();


	}
	//click to search the student information
	public void clicksearch(){
		search=(Button)findViewById(R.id.search);
		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (check()){
					Toast.makeText(SearchActivity.this, "Please enter student id or computing id!", Toast.LENGTH_SHORT).show();
				}
				else {
					storeids();
					Intent i = new Intent(SearchActivity.this, InfoActivity.class);
					startActivity(i);
				}
			}
		});
	}
	// check if the computing id and studentid is blank
	private boolean check(){
		studentid=(EditText)findViewById(R.id.enterid1);
		computingid=(EditText)findViewById(R.id.enterid2);
		return studentid.getText().toString().isEmpty()&& computingid.getText().toString().isEmpty();

	}
	// the student id and computing id will be stored in dataholder
	private void storeids(){
		studentid=(EditText)findViewById(R.id.enterid1);
		computingid=(EditText)findViewById(R.id.enterid2);
		DataHolder.getInstance().setstudentid(studentid.getText().toString());
		DataHolder.getInstance().setcomputingid(computingid.getText().toString());
		//Toast.makeText(SearchActivity.this,DataHolder.getInstance().getcomputingid()+" "+DataHolder.getInstance().getstudnetid(),Toast.LENGTH_SHORT).show();

	}
}
