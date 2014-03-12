package com.gameprobabilities.siokas;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ActionBar.LayoutParams;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Roulette extends Activity {

	RadioButton simple, am, cols;
	Button calc;
	TextView res, moneywin, moneylose;
	EditText moneybet;
	ImageView help;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_roul, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.roul_draw:
					draw();
			break;
		case R.id.roul_info:
			startActivity(new Intent(
					"com.gameprobabilities.siokas.ROULETTE_HELP"));
			break;

		}
		return true;
	}


	private void draw() {
		String[] s = { "1", "2", "3 ", "4", "5", "6",
		        "7", "8", "9", "10","11","12","13", "12", "15", "16", "17", "18",
		        "19", "20", "21", "22","23","24","25", "26", "27", "28", "29", "30",
		        "31", "32", "33", "34","35","36", };
		  final ArrayAdapter<String> adp = new ArrayAdapter<String>(Roulette.this,
		            android.R.layout.simple_spinner_item, s);

		    final Spinner sp = new Spinner(Roulette.this);
		    sp.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		    sp.setAdapter(adp);

		    final AlertDialog.Builder builder = new AlertDialog.Builder(Roulette.this);
		    builder.setTitle(getString(R.string.KinoNums));
		    builder.setView(sp);
		    builder.setMessage(getString(R.string.Choose));
		    builder.setNeutralButton(getString(R.string.DoIt), new OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					showme((sp.getSelectedItem().toString()));
				}

			});
		    builder.create().show();
			
			
		
	}
	private void showme(String s) {
		int x = Integer.parseInt(s);
		Generate g = new Generate();
		final AlertDialog.Builder in = new AlertDialog.Builder(Roulette.this);
		in.setTitle(getString(R.string.LuckyDraw));
		in.setMessage((g.pick_num(37,x)));
		in.setNeutralButton(getString(R.string.Thanx), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});
		in.show();
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.roulette);
		
		if (android.os.Build.VERSION.SDK_INT >= 11)
		{
			ActionBar actionBar = getActionBar();
		    actionBar.setDisplayHomeAsUpEnabled(true);
		}

		simple = (RadioButton) findViewById(R.id.roulette_simpleRadio);
		am = (RadioButton) findViewById(R.id.am);
		cols = (RadioButton) findViewById(R.id.columns);
		calc = (Button) findViewById(R.id.roulette_Calculate);
		res = (TextView) findViewById(R.id.roulette_Result);
		moneywin = (TextView) findViewById(R.id.roulette_MoneyWin);
		moneylose = (TextView) findViewById(R.id.roulette_MoneyLose);
		moneybet = (EditText) findViewById(R.id.money_bet);
		help = (ImageView) findViewById(R.id.imageViewRoulette);

		final Spinner spinner = (Spinner) findViewById(R.id.spRoulette1);

		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
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

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);

		simple.setChecked(true);
		am.setChecked(false);
		cols.setChecked(false);

		help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(
						"com.gameprobabilities.siokas.ROULETTE_HELP"));
			}
		});

		simple.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simple.setChecked(true);
				am.setChecked(false);
				cols.setChecked(false);

			}
		});

		am.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simple.setChecked(false);
				am.setChecked(true);
				cols.setChecked(false);

			}
		});

		cols.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simple.setChecked(false);
				am.setChecked(false);
				cols.setChecked(true);

			}
		});

		calc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (simple.isChecked()) {

					String check2 = moneybet.getText().toString();

					if (check2.matches("")) {
						Toast.makeText(Roulette.this,
								getString(R.string.Error), Toast.LENGTH_LONG)
								.show();
						return;
					} else {

						int ibet = Integer.parseInt(spinner.getSelectedItem()
								.toString());
						double imoneybet = Double.parseDouble(moneybet
								.getText().toString());

						double result = ibet / 36.0;

						NumberFormat f = NumberFormat.getPercentInstance();
						f.setMinimumFractionDigits(2);
						f.setMaximumFractionDigits(10);

						res.setText(getString(R.string.Probability) + ": "
								+ f.format(result));
						moneylose.setText(getString(R.string.YouWillPay) + ": "
								+ (ibet * imoneybet) + " euro");
						moneywin.setText(getString(R.string.YouWillWin) + ": "
								+ (36 * imoneybet) + " euro");
					}
				}
				if (am.isChecked()) {

					String check2 = moneybet.getText().toString();

					if (check2.matches("")) {
						Toast.makeText(Roulette.this,
								getString(R.string.Error), Toast.LENGTH_LONG)
								.show();
						return;
					}

					else {

						int imoneybet = Integer.parseInt(moneybet.getText()
								.toString());

						double result = 18 / 37.0;

						NumberFormat f = NumberFormat.getPercentInstance();
						f.setMinimumFractionDigits(2);
						f.setMaximumFractionDigits(10);

						res.setText(getString(R.string.Probability) + ": "
								+ f.format(result));
						moneylose.setText(getString(R.string.YouWillPay) + ": "
								+ (imoneybet) + " euro");
						moneywin.setText(getString(R.string.YouWillWin) + ": "
								+ (2 * imoneybet) + " euro");

					}
				}

				if (cols.isChecked()) {

					String check2 = moneybet.getText().toString();

					if (check2.matches("")) {
						Toast.makeText(Roulette.this,
								getString(R.string.Error), Toast.LENGTH_LONG)
								.show();
						return;
					}

					else {

						int imoneybet = Integer.parseInt(moneybet.getText()
								.toString());

						double result = 12 / 37.0;

						NumberFormat f = NumberFormat.getPercentInstance();
						f.setMinimumFractionDigits(2);
						f.setMaximumFractionDigits(10);

						res.setText(getString(R.string.Probability) + ": "
								+ f.format(result));
						moneylose.setText(getString(R.string.YouWillPay) + ": "
								+ (imoneybet) + " euro");
						moneywin.setText(getString(R.string.YouWillWin) + ": "
								+ (3 * imoneybet) + " euro");

					}
				}
			}

		});
	}
}
