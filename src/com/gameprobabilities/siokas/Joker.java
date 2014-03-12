package com.gameprobabilities.siokas;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Joker extends Activity {

	protected static final Message BUTTON_NEUTRAL = null;
	RadioButton simple, complex;
	Button calc;
	TextView res, money;
	ImageView help;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_joker, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.joker_res:
			startActivity(new Intent("com.gameprobabilities.siokas.JOKER_RES"));
			break;
		case R.id.joker_draw:
			draw();
			break;
		case R.id.joker_info:
			startActivity(new Intent("com.gameprobabilities.siokas.JOKER_HELP"));
			break;
		case android.R.id.home:
			finish();
			return true;

		}
		return true;
	}

	private void draw() {
		Generate g = new Generate();
		final AlertDialog.Builder in = new AlertDialog.Builder(Joker.this);
		in.setTitle(getString(R.string.LuckyDraw));
		in.setMessage((g.pick_num(45,5))+"\n"+(g.pick_num(20,1)));
		in.setNeutralButton(getString(R.string.Thanx), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});
		in.show();

	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joker);
		
		if (android.os.Build.VERSION.SDK_INT >= 11)
		{
			ActionBar actionBar = getActionBar();
		    actionBar.setDisplayHomeAsUpEnabled(true);
		}


		simple = (RadioButton) findViewById(R.id.joker_simpleRadio);
		complex = (RadioButton) findViewById(R.id.joker_complexRadio);
		calc = (Button) findViewById(R.id.joker_Calculate);
		res = (TextView) findViewById(R.id.joker_Result);
		money = (TextView) findViewById(R.id.joker_Money);
		help = (ImageView) findViewById(R.id.imageViewJoker);

		final Spinner spinner = (Spinner) findViewById(R.id.spJoker1);
		final Spinner spinner2 = (Spinner) findViewById(R.id.spJoker2);

		List<String> list = new ArrayList<String>();
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		list.add("10");
		list.add("11");
		list.add("12");
		list.add("13");
		list.add("14");
		list.add("15");
		list.add("16");
		list.add("17");
		list.add("18");
		list.add("19");
		list.add("20");
		list.add("21");
		list.add("22");
		list.add("23");
		list.add("24");
		list.add("25");
		list.add("26");
		list.add("27");
		list.add("28");
		list.add("29");
		list.add("30");
		list.add("31");
		list.add("32");
		list.add("33");
		list.add("34");
		list.add("35");
		list.add("36");
		list.add("37");
		list.add("38");
		list.add("39");
		list.add("40");
		list.add("41");
		list.add("42");
		list.add("43");
		list.add("44");
		list.add("45");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);

		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		list1.add("4");
		list1.add("5");
		list1.add("6");
		list1.add("7");
		list1.add("8");
		list1.add("9");
		list1.add("10");
		list1.add("11");
		list1.add("12");
		list1.add("13");
		list1.add("12");
		list1.add("15");
		list1.add("16");
		list1.add("17");
		list1.add("18");
		list1.add("19");
		list1.add("20");

		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list1);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter1);

		simple.setChecked(true);
		complex.setChecked(false);
		spinner.setEnabled(false);
		spinner2.setEnabled(false);

		help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(
						"com.gameprobabilities.siokas.JOKER_HELP"));
			}
		});

		simple.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simple.setChecked(true);
				complex.setChecked(false);

				spinner.setEnabled(false);
				spinner2.setEnabled(false);

			}
		});

		complex.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simple.setChecked(false);
				complex.setChecked(true);

				spinner.setEnabled(true);
				spinner2.setEnabled(true);

			}
		});

		calc.setOnClickListener(new View.OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				if (simple.isChecked()) {
					double n = Factorial.combin(5, 5) * Factorial.combin(1, 1);
					double pos = 1.0 / (Factorial.combin(45, 5) * Factorial
							.combin(20, 1));
					NumberFormat f = NumberFormat.getPercentInstance();
					f.setMinimumFractionDigits(2);
					f.setMaximumFractionDigits(10);
					double n1 = Factorial.combin(5, 1) * Factorial.combin(1, 1);

					double n2 = Factorial.combin(5, 2) * Factorial.combin(1, 1);

					double n3 = Factorial.combin(5, 3) * Factorial.combin(1, 1);

					double n4 = Factorial.combin(5, 4) * Factorial.combin(1, 1);
					
					double n5 = Factorial.combin(5, 5) * Factorial.combin(1, 1);


					String www = "";
					double oneplus = 1.0 / (Factorial.combin(45, 1) * Factorial
							.combin(20, 1));
					double twoplus = 1.0 / (Factorial.combin(45, 2) * Factorial
							.combin(20, 1));
					double three = 1.0 / (Factorial.combin(45, 3));
					double threeplus = 1.0 / (Factorial.combin(45, 3) * Factorial
							.combin(20, 1));
					double four = 1.0 / (Factorial.combin(45, 4));
					double fourplus = 1.0 / (Factorial.combin(45, 4) * Factorial
							.combin(20, 1));
					double five = 1.0 / (Factorial.combin(45, 5));
					double fiveplus = 1.0 / (Factorial.combin(45, 5) * Factorial
							.combin(20, 1));
					
						www = www.concat("1+1: \t\t\t" + f.format(oneplus * n1) + "\n");
					
						www = www.concat("2+1: \t\t\t" + f.format(twoplus * n2) + "\n");

						www = www.concat("  3:  \t\t\t " + f.format(three *Factorial.combin(5, 3)) + "\n");
					
						www = www.concat("3+1: \t\t\t" + f.format(threeplus * n3) + "\n");
		
						www = www.concat("  4:  \t\t\t " + f.format(four * Factorial.combin(5, 4)) + "\n");

						www = www.concat("4+1: \t\t\t" + f.format(fourplus * n4) + "\n");
		
						www = www.concat("  5:  \t\t\t " + f.format(five *Factorial.combin(5, 5)) + "\n");
						
						www = www.concat("5+1: \t\t\t" + f.format(fiveplus * n5) + "\n");
						
						


					AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
					alert.setTitle("Επιτυχίες Τζόκερ");
					//alert.setCanceledOnTouchOutside(true);
					//alert.setCancelable(true);
					alert.setNeutralButton("Εντάξει", new DialogInterface.OnClickListener() {
		                  public void onClick(DialogInterface dialog, int which) {
		                      return;
		                  } }); 
					alert.setMessage(www);
					alert.show();

					res.setText(getString(R.string.Probability) + ": "
							+ f.format(pos));
					money.setText(getString(R.string.YouWillPay) + ": " + n / 2
							+ " euro");
				}
				if (complex.isChecked()) {

					int x = Integer.parseInt(spinner.getSelectedItem()
							.toString());
					int y = Integer.parseInt(spinner2.getSelectedItem()
							.toString());

					if ((x >= 5 && x <= 45) && (y >= 1 && y <= 20)) {

						double n = Factorial.combin(x, 5)
								* Factorial.combin(y, 1);

						double pos = (1.0 / (Factorial.combin(45, 5) * Factorial
								.combin(20, 1))) * n;

						NumberFormat f = NumberFormat.getPercentInstance();
						f.setMinimumFractionDigits(2);
						f.setMaximumFractionDigits(10);
						double n1 = Factorial.combin(x, 1) * Factorial.combin(y, 1);

						double n2 = Factorial.combin(x, 2) * Factorial.combin(y, 1);

						double n3 = Factorial.combin(x, 3) * Factorial.combin(y, 1);

						double n4 = Factorial.combin(x, 4) * Factorial.combin(y, 1);
						
						double n5 = Factorial.combin(x, 5) * Factorial.combin(y, 1);


						String www = "";
						double oneplus = 1.0 / (Factorial.combin(45, 1) * Factorial
								.combin(20, 1));
						double twoplus = 1.0 / (Factorial.combin(45, 2) * Factorial
								.combin(20, 1));
						double three = 1.0 / (Factorial.combin(45, 3));
						double threeplus = 1.0 / (Factorial.combin(45, 3) * Factorial
								.combin(20, 1));
						double four = 1.0 / (Factorial.combin(45, 4));
						double fourplus = 1.0 / (Factorial.combin(45, 4) * Factorial
								.combin(20, 1));
						double five = 1.0 / (Factorial.combin(45, 5));
						double fiveplus = 1.0 / (Factorial.combin(45, 5) * Factorial
								.combin(20, 1));
						
							www = www.concat("1+1: \t" + f.format(oneplus * n1) + "\n");
						
							www = www.concat("2+1: \t" + f.format(twoplus * n2) + "\n");

							www = www.concat("  3:  \t " + f.format(three *Factorial.combin(x, 3)) + "\n");
						
							www = www.concat("3+1: \t" + f.format(threeplus * n3) + "\n");
			
							www = www.concat("  4:  \t " + f.format(four * Factorial.combin(x, 4)) + "\n");

							www = www.concat("4+1: \t" + f.format(fourplus * n4) + "\n");
			
							www = www.concat("  5:  \t " + f.format(five *Factorial.combin(x, 5)) + "\n");
							
							www = www.concat("5+1: \t" + f.format(fiveplus * n5) + "\n");

						AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
						alert.setTitle("Επιτυχίες Τζόκερ");
						alert.setCancelable(true);
						alert.setMessage(www);
						alert.setNeutralButton("Εντάξει", new DialogInterface.OnClickListener() {
			                  public void onClick(DialogInterface dialog, int which) {
			                      return;
			                  } }); 
						alert.show();

						res.setText(getString(R.string.Probability)
								+ f.format(pos));
						money.setText(getString(R.string.YouWillPay) + n / 2
								+ " euro");

					}
				}

			}
		});

	}

}
