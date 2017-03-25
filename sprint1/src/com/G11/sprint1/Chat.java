package com.G11.sprint1;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;
import android.content.SharedPreferences;
import android.widget.ImageButton;


public class Chat extends Activity {

	int counter;		//counter

	public ImageButton but;//button for Enter


	public void init() {							//after clicking the button
		but = (ImageButton) findViewById(R.id.imageButton);
		but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Date currentTime = new Date();
				CharSequence cs = DateFormat.format("MM-dd HH:mm:ss,",currentTime.getTime());



				counter++;

				EditText input = (EditText) findViewById(R.id.editText);
				String str = DataHolder.getInstance().getfirstname()+": "+input.getText().toString() +"　"+ cs.toString();


				final TextView firTxt = (TextView) findViewById(R.id.textView);   // set a name to each textView
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
				final TextView twentytTxt = (TextView) findViewById(R.id.textView22);//till here


				if(counter < 23){		//if counter less then 23 which is the number of textViews
					if(counter == 1){


						firTxt.setText(str);

						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);//store the textView value by Share Pref
						SharedPreferences.Editor editor = pref.edit();						//
						editor.putString("TextView",str);									//
						editor.apply();													//till here

						String extractedText = pref.getString("TextView","");//get Share Pref// get the Share Pref value
						firTxt.setText(extractedText);						//till here
																			//do this 22 times as the number of textView


					}
					else if(counter == 2){
						secTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView2",str);
						editor.apply();


						String extractedText = pref.getString("TextView2","");
						secTxt.setText(extractedText);

					}
					else if(counter == 3){
						thiTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView3",str);
					//	editor.putInt("counter",counter);
						editor.apply();


						String extractedText = pref.getString("TextView3","");
						thiTxt.setText(extractedText);

					}
					else if(counter == 4){
						forTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView4",str);
						editor.apply();


						String extractedText = pref.getString("TextView4","");
						forTxt.setText(extractedText);

					}
					else if(counter == 5){
						fifTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView5",str);
						editor.apply();


						String extractedText = pref.getString("TextView5","");
						fifTxt.setText(extractedText);

					}
					else if(counter == 6){
						sixTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView6",str);
						editor.apply();


						String extractedText = pref.getString("TextView6","");
						sixTxt.setText(extractedText);

					}
					else if(counter == 7){
						sevTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView7",str);
						editor.apply();


						String extractedText = pref.getString("TextView7","");
						sevTxt.setText(extractedText);

					}
					else if(counter == 8){
						eigTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView8",str);
						editor.apply();


						String extractedText = pref.getString("TextView8","");
						eigTxt.setText(extractedText);

					}
					else if(counter == 9){
						ninTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView9",str);
						editor.apply();


						String extractedText = pref.getString("TextView9","");
						ninTxt.setText(extractedText);

					}
					else if(counter == 10){
						tenTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView10",str);
						editor.apply();


						String extractedText = pref.getString("TextView10","");
						tenTxt.setText(extractedText);

					}
					else if(counter == 11){
						eleTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView11",str);
						editor.apply();


						String extractedText = pref.getString("TextView11","");
						eleTxt.setText(extractedText);

					}
					else if(counter == 12){
						tweTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView12",str);
						editor.apply();


						String extractedText = pref.getString("TextView12","");
						tweTxt.setText(extractedText);

					}
					else if(counter == 13){
						thitTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView13",str);
						editor.apply();


						String extractedText = pref.getString("TextView13","");
						thitTxt.setText(extractedText);

					}
					else if(counter == 14){
						fortTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView14",str);
						editor.apply();


						String extractedText = pref.getString("TextView14","");
						fortTxt.setText(extractedText);

					}
					else if(counter == 15){
						fiftTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView15",str);
						editor.apply();


						String extractedText = pref.getString("TextView15","");
						fiftTxt.setText(extractedText);

					}
					else if(counter == 16){
						sixtTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView16",str);
						editor.apply();


						String extractedText = pref.getString("TextView16","");
						sixtTxt.setText(extractedText);

					}
					else if(counter == 17){
						sevtTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView17",str);
						editor.apply();


						String extractedText = pref.getString("TextView17","");
						sevtTxt.setText(extractedText);

					}
					else if(counter == 18){
						eigtTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView18",str);
						editor.apply();


						String extractedText = pref.getString("TextView18","");
						eigtTxt.setText(extractedText);

					}
					else if(counter == 19){
						nintTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView19",str);
						editor.putInt("counter",counter);
						editor.apply();


						String extractedText = pref.getString("TextView19","");
						nintTxt.setText(extractedText);

					}
					else if(counter == 20){
						twentyTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView20",str);
						editor.apply();


						String extractedText = pref.getString("TextView20","");
						twentyTxt.setText(extractedText);

					}
					else if(counter == 21){
						twentyoTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView21",str);
						editor.apply();


						String extractedText = pref.getString("TextView21","");
						twentyoTxt.setText(extractedText);

					}
					else if(counter == 22){
						twentytTxt.setText(str);
						SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("TextView22",str);
						editor.apply();


						String extractedText = pref.getString("TextView22","");
						twentytTxt.setText(extractedText);

					}
					input.setText("");
				}
				else{
					String a = secTxt.getText().toString();		//if all textViews are full shift each of the one by one
					firTxt.setText(a);

					SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);
					SharedPreferences.Editor editor = pref.edit();
					editor.putString("TextView",a);
					editor.apply();


					String extractedText = pref.getString("TextView","");
					firTxt.setText(extractedText);


					String b = thiTxt.getText().toString();
					secTxt.setText(b);

					editor.putString("TextView2",b);
					editor.commit();

					String extractedText2 = pref.getString("TextView2","");
					secTxt.setText(extractedText2);

					String c = forTxt.getText().toString();
					thiTxt.setText(c);
					editor.putString("TextView3",c);
					editor.commit();

					String extractedText3 = pref.getString("TextView3","");
					thiTxt.setText(extractedText3);

					String d = fifTxt.getText().toString();
					forTxt.setText(d);
					editor.putString("TextView4",d);
					editor.commit();

					String extractedText4 = pref.getString("TextView4","");
					forTxt.setText(extractedText4);

					String e = sixTxt.getText().toString();
					fifTxt.setText(e);
					editor.putString("TextView5",e);
					editor.commit();

					String extractedText5 = pref.getString("TextView5","");
					fifTxt.setText(extractedText5);

					String f = sevTxt.getText().toString();
					sixTxt.setText(f);
					editor.putString("TextView6",f);
					editor.commit();

					String extractedText6 = pref.getString("TextView6","");
					sixTxt.setText(extractedText6);

					String g = eigTxt.getText().toString();
					sevTxt.setText(g);
					editor.putString("TextView7",g);
					editor.commit();

					String extractedText7 = pref.getString("TextView7","");
					sevTxt.setText(extractedText7);

					String h = ninTxt.getText().toString();
					eigTxt.setText(h);
					editor.putString("TextView8",h);
					editor.commit();

					String extractedText8 = pref.getString("TextView8","");
					eigTxt.setText(extractedText8);

					String i = tenTxt.getText().toString();
					ninTxt.setText(i);
					editor.putString("TextView9",i);
					editor.commit();

					String extractedText9 = pref.getString("TextView9","");
					ninTxt.setText(extractedText9);

					String j = eleTxt.getText().toString();
					tenTxt.setText(j);
					editor.putString("TextView10",j);
					editor.commit();

					String extractedText10 = pref.getString("TextView10","");
					tenTxt.setText(extractedText10);

					String k = tweTxt.getText().toString();
					eleTxt.setText(k);
					editor.putString("TextView11",k);
					editor.commit();

					String extractedText11 = pref.getString("TextView11","");
					eleTxt.setText(extractedText11);

					String l = thitTxt.getText().toString();
					tweTxt.setText(l);
					editor.putString("TextView12",l);
					editor.commit();

					String extractedText12 = pref.getString("TextView12","");
					tweTxt.setText(extractedText12);

					String m = fortTxt.getText().toString();
					thitTxt.setText(m);
					editor.putString("TextView13",m);
					editor.commit();

					String extractedText13 = pref.getString("TextView13","");
					thitTxt.setText(extractedText13);
					String n = fiftTxt.getText().toString();
					fortTxt.setText(n);
					editor.putString("TextView14",n);
					editor.commit();

					String extractedText14 = pref.getString("TextView14","");
					fortTxt.setText(extractedText14);

					String o = sixtTxt.getText().toString();
					fiftTxt.setText(o);
					editor.putString("TextView15",o);
					editor.commit();

					String extractedText15 = pref.getString("TextView15","");
					fiftTxt.setText(extractedText15);

					String p = sevtTxt.getText().toString();
					sixtTxt.setText(p);
					editor.putString("TextView16",p);
					editor.commit();

					String extractedText16 = pref.getString("TextView16","");
					sixtTxt.setText(extractedText16);

					String q = eigtTxt.getText().toString();
					sevtTxt.setText(q);
					editor.putString("TextView17",q);
					editor.commit();

					String extractedText17 = pref.getString("TextView17","");
					sevtTxt.setText(extractedText17);

					String r = nintTxt.getText().toString();
					eigtTxt.setText(r);
					editor.putString("TextView18",r);
					editor.commit();

					String extractedText18 = pref.getString("TextView18","");
					eigtTxt.setText(extractedText18);

					String s = twentyTxt.getText().toString();
					nintTxt.setText(s);
					editor.putString("TextView19",s);
					editor.commit();

					String extractedText19 = pref.getString("TextView19","");
					nintTxt.setText(extractedText19);

					String t = twentyoTxt.getText().toString();
					twentyTxt.setText(t);
					editor.putString("TextView20",t);
					editor.commit();

					String extractedText20 = pref.getString("TextView20","");
					twentyTxt.setText(extractedText20);

					String u = twentytTxt.getText().toString();
					twentyoTxt.setText(u);						//till here
					editor.putString("TextView21",u);
					editor.commit();

					String extractedText21 = pref.getString("TextView21","");
					twentyoTxt.setText(extractedText21);


					twentytTxt.setText(str);//update the last textView to user input
					editor.putString("TextView22",str);
					editor.commit();

					String extractedText22 = pref.getString("TextView22","");
					twentytTxt.setText(extractedText22);
					input.setText("");							// and clean EditText
				}




			}
		});
	}

	private int getCounter(){											// function to get the counter, how much of them r filled
		final TextView firTxt = (TextView) findViewById(R.id.textView);
		String firstTxt = firTxt.getText().toString();
		final TextView secTxt = (TextView) findViewById(R.id.textView2);
		String secondTxt = secTxt.getText().toString();
		final TextView thiTxt = (TextView) findViewById(R.id.textView3);
		String thirdTxt = thiTxt.getText().toString();
		final TextView forTxt = (TextView) findViewById(R.id.textView4);
		String forthTxt = forTxt.getText().toString();

		final TextView fifTxt = (TextView) findViewById(R.id.textView5);
		String fifthTxt = fifTxt.getText().toString();
		final TextView sixTxt = (TextView) findViewById(R.id.textView6);
		String truesixTxt = sixTxt.getText().toString();
		final TextView sevTxt = (TextView) findViewById(R.id.textView7);
		String sevenTxt = sevTxt.getText().toString();
		final TextView eigTxt = (TextView) findViewById(R.id.textView8);
		String eightTxt = eigTxt.getText().toString();
		final TextView ninTxt = (TextView) findViewById(R.id.textView9);
		String nineTxt = ninTxt.getText().toString();
		final TextView tenTxt = (TextView) findViewById(R.id.textView10);
		String tenTrueTxt = tenTxt.getText().toString();
		final TextView eleTxt = (TextView) findViewById(R.id.textView11);
		String elevenTxt = eleTxt.getText().toString();
		final TextView tweTxt = (TextView) findViewById(R.id.textView12);
		String twelveTrueTxt = tweTxt.getText().toString();
		final TextView thitTxt = (TextView) findViewById(R.id.textView13);
		String thirteenTrueTxt = thitTxt.getText().toString();
		final TextView fortTxt = (TextView) findViewById(R.id.textView14);
		String forteenTrueTxt = fortTxt.getText().toString();
		final TextView fiftTxt = (TextView) findViewById(R.id.textView15);
		String fifteenTxt = fiftTxt.getText().toString();
		final TextView sixtTxt = (TextView) findViewById(R.id.textView16);
		String sixteenTxt = sixtTxt.getText().toString();
		final TextView sevtTxt = (TextView) findViewById(R.id.textView17);
		String seventeenTxt = sevtTxt.getText().toString();
		final TextView eigtTxt = (TextView) findViewById(R.id.textView18);
		String eighteenTxt = eigtTxt.getText().toString();
		final TextView nintTxt = (TextView) findViewById(R.id.textView19);
		String ninteenTxt = nintTxt.getText().toString();
		final TextView twentyTxt = (TextView) findViewById(R.id.textView20);
		String twentyTrueTxt = twentyTxt.getText().toString();
		final TextView twentyoTxt = (TextView) findViewById(R.id.textView21);
		String twentyoneTrueTxt = twentyoTxt.getText().toString();
		final TextView twentytTxt = (TextView) findViewById(R.id.textView22);
		String twentytwoTxt = twentytTxt.getText().toString();

		if (firstTxt==""){							//if txtView is empty
			return 0;								//set the counter to 0
		}

		else if (secondTxt.isEmpty()){				//if the second txtView is empty
			return 1;								//set the counter to 1 and so on
		}
		else if(thirdTxt.isEmpty()){
			return 2;
		}
		else if(forthTxt.isEmpty()){
			return 3;
		}
		else if(fifthTxt.isEmpty()){
			return 4;
		}
		else if(truesixTxt.isEmpty()){
			return 5;
		}
		else if(sevenTxt.isEmpty()){
			return 6;
		}
		else if(eightTxt.isEmpty()){
			return 7;
		}
		else if(nineTxt.isEmpty()){
			return 8;
		}
		else if(tenTrueTxt.isEmpty()){
			return 9;
		}
		else if(elevenTxt.isEmpty()){
			return 10;
		}
		else if(twelveTrueTxt.isEmpty()){
			return 11;
		}
		else if(thirteenTrueTxt.isEmpty()){
			return 12;
		}
		else if(forteenTrueTxt.isEmpty()){
			return 13;
		}
		else if(fifteenTxt.isEmpty()){
			return 14;
		}
		else if(sixteenTxt.isEmpty()){
			return 15;
		}
		else if(seventeenTxt.isEmpty()){
			return 16;
		}
		else if(eighteenTxt.isEmpty()){
			return 17;
		}
		else if(ninteenTxt.isEmpty()){
			return 18;
		}
		else if(twentyTrueTxt.isEmpty()){
			return 19;
		}
		else if(twentyoneTrueTxt.isEmpty()){
			return 20;
		}
		else if(twentytwoTxt.isEmpty()){
			return 21;}
		else{
			return 22;
		}

	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);

		final TextView firTxt = (TextView) findViewById(R.id.textView); //from here when the app is closed or when the
		final TextView secTxt = (TextView) findViewById(R.id.textView2);//user go to a different activity and come back
		final TextView thiTxt = (TextView) findViewById(R.id.textView3);// to this activity set the TextView as same as before
		final TextView forTxt = (TextView) findViewById(R.id.textView4);
		final TextView fifTxt = (TextView) findViewById(R.id.textView5);// set textView's name
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

		SharedPreferences pref = getSharedPreferences("da App",MODE_PRIVATE);

		String extractedText = pref.getString("TextView","");  //get the value that's saved in Shared preference
		firTxt.setText(extractedText);

		String extractedText2 = pref.getString("TextView2","");
		secTxt.setText(extractedText2);

		String extractedText3 = pref.getString("TextView3","");
		thiTxt.setText(extractedText3);

		String extractedText4 = pref.getString("TextView4","");
		forTxt.setText(extractedText4);

		String extractedText5 = pref.getString("TextView5","");
		fifTxt.setText(extractedText5);

		String extractedText6 = pref.getString("TextView6","");
		sixTxt.setText(extractedText6);

		String extractedText7 = pref.getString("TextView7","");
		sevTxt.setText(extractedText7);

		String extractedText8 = pref.getString("TextView8","");
		eigTxt.setText(extractedText8);

		String extractedText9 = pref.getString("TextView9","");
		ninTxt.setText(extractedText9);

		String extractedText10 = pref.getString("TextView10","");
		tenTxt.setText(extractedText10);

		String extractedText11 = pref.getString("TextView11","");
		eleTxt.setText(extractedText11);

		String extractedText12 = pref.getString("TextView12","");
		tweTxt.setText(extractedText12);

		String extractedText13 = pref.getString("TextView13","");
		thitTxt.setText(extractedText13);

		String extractedText14 = pref.getString("TextView14","");
		fortTxt.setText(extractedText14);

		String extractedText15 = pref.getString("TextView15","");
		fiftTxt.setText(extractedText15);

		String extractedText16 = pref.getString("TextView16","");
		sixtTxt.setText(extractedText16);

		String extractedText17 = pref.getString("TextView17","");
		sevtTxt.setText(extractedText17);

		String extractedText18 = pref.getString("TextView18","");
		eigtTxt.setText(extractedText18);

		String extractedText19 = pref.getString("TextView19","");
		nintTxt.setText(extractedText19);

		String extractedText20 = pref.getString("TextView20","");
		twentyTxt.setText(extractedText20);

		String extractedText21 = pref.getString("TextView21","");
		twentyoTxt.setText(extractedText21);

		String extractedText22 = pref.getString("TextView22","");
		twentytTxt.setText(extractedText22);

		counter = getCounter();//save the counter value

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
