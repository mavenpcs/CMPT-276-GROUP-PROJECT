package com.G11.sprint1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;
import android.content.SharedPreferences;

public class Chat extends Activity {
	int counter = 0;
	int place;
	public Button but;
	public void init() {
		but = (Button) findViewById(R.id.button);
		but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Date currentTime = new Date();



				counter++;
				EditText input = (EditText) findViewById(R.id.editText);
				String str = input.getText().toString() +" "+ currentTime.toString();


				final TextView firTxt = (TextView) findViewById(R.id.textView);
				final TextView secTxt = (TextView) findViewById(R.id.textView2);
				final TextView thiTxt = (TextView) findViewById(R.id.textView3);
				final TextView forTxt = (TextView) findViewById(R.id.textView4);
				final TextView fifTxt = (TextView) findViewById(R.id.textView5);
				final TextView sixTxt = (TextView) findViewById(R.id.textView6);
				final TextView sevTxt = (TextView) findViewById(R.id.textView7);
				final TextView eigTxt = (TextView) findViewById(R.id.textView8);
				final TextView ninTxt = (TextView) findViewById(R.id.textView9);
				final TextView tenTxt = (TextView) findViewById(R.id.textView10);
				final TextView eleTxt = (TextView) findViewById(R.id.textView11);
				final TextView tweTxt = (TextView) findViewById(R.id.textView12);
				final TextView thitTxt = (TextView) findViewById(R.id.textView13);
				final TextView fortTxt = (TextView) findViewById(R.id.textView14);
				final TextView fiftTxt = (TextView) findViewById(R.id.textView15);
				final TextView sixtTxt = (TextView) findViewById(R.id.textView16);
				final TextView sevtTxt = (TextView) findViewById(R.id.textView17);
				final TextView eigtTxt = (TextView) findViewById(R.id.textView18);
				final TextView nintTxt = (TextView) findViewById(R.id.textView19);
				final TextView twentyTxt = (TextView) findViewById(R.id.textView20);
				final TextView twentyoTxt = (TextView) findViewById(R.id.textView21);
				final TextView twentytTxt = (TextView) findViewById(R.id.textView22);


				if(counter / 23 == 0 && counter < 23){
					if(counter == 1){
						firTxt.setText(str);

						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView",str);
						editor.commit();

						String extractedText = pref.getString("TextView","");
						firTxt.setText(extractedText);

						//firTxt.setText(str);

					}
					else if(counter == 2){
						secTxt.setText(str);
					}
					else if(counter == 3){
						thiTxt.setText(str);
					}
					else if(counter == 4){
						forTxt.setText(str);
					}
					else if(counter == 5){
						fifTxt.setText(str);
					}
					else if(counter == 6){
						sixTxt.setText(str);
					}
					else if(counter == 7){
						sevTxt.setText(str);
					}
					else if(counter == 8){
						eigTxt.setText(str);
					}
					else if(counter == 9){
						ninTxt.setText(str);
					}
					else if(counter == 10){
						tenTxt.setText(str);
					}
					else if(counter == 11){
						eleTxt.setText(str);
					}
					else if(counter == 12){
						tweTxt.setText(str);
					}
					else if(counter == 13){
						thitTxt.setText(str);
					}
					else if(counter == 14){
						fortTxt.setText(str);
					}
					else if(counter == 15){
						fiftTxt.setText(str);
					}
					else if(counter == 16){
						sixtTxt.setText(str);
					}
					else if(counter == 17){
						sevtTxt.setText(str);
					}
					else if(counter == 18){
						eigtTxt.setText(str);
					}
					else if(counter == 19){
						nintTxt.setText(str);
					}
					else if(counter == 20){
						twentyTxt.setText(str);
					}
					else if(counter == 21){
						twentyoTxt.setText(str);
					}
					else if(counter == 22){
						twentytTxt.setText(str);
					}
					input.setText("");
				}
				else{
					String a = secTxt.getText().toString();
					firTxt.setText(a);
					String b = thiTxt.getText().toString();
					secTxt.setText(b);
					String c = forTxt.getText().toString();
					thiTxt.setText(c);
					String d = fifTxt.getText().toString();
					forTxt.setText(d);
					String e = sixTxt.getText().toString();
					fifTxt.setText(e);
					String f = sevTxt.getText().toString();
					sixTxt.setText(f);

					String g = eigTxt.getText().toString();
					sevTxt.setText(g);
					String h = ninTxt.getText().toString();
					eigTxt.setText(h);
					String i = tenTxt.getText().toString();
					ninTxt.setText(i);
					String j = eleTxt.getText().toString();
					tenTxt.setText(j);
					String k = tweTxt.getText().toString();
					eleTxt.setText(k);
					String l = thitTxt.getText().toString();
					tweTxt.setText(l);

					String m = fortTxt.getText().toString();
					thitTxt.setText(m);
					String n = fiftTxt.getText().toString();
					fortTxt.setText(n);
					String o = sixtTxt.getText().toString();
					fiftTxt.setText(o);
					String p = sevtTxt.getText().toString();
					sixtTxt.setText(p);
					String q = eigtTxt.getText().toString();
					sevtTxt.setText(q);
					String r = nintTxt.getText().toString();
					eigtTxt.setText(r);
					String s = twentyTxt.getText().toString();
					nintTxt.setText(s);
					String t = twentyoTxt.getText().toString();
					twentyTxt.setText(t);
					String u = twentytTxt.getText().toString();
					twentyoTxt.setText(u);


					twentytTxt.setText(str);
					input.setText("");
				}



			}
		});
	}

	private String getSP(){
		SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
		String extractedText = pref.getString("TextView","");
		Log.d(getClass().getName(), "estracted: " + extractedText);
		return extractedText;


	}
	private void storeSP(){
		String txt = new Date().toString();

		SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString("TextView","txt");
		editor.commit();

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chat, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
