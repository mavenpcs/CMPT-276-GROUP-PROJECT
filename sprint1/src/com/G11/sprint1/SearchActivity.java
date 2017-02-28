package com.G11.sprint1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends Activity {
	Button search;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		clicksearch();
	}
	public void clicksearch(){
		search=(Button)findViewById(R.id.search);
		search.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(SearchActivity.this,InfoActivity.class);
				startActivity(i);
			}
		});
	}

}
