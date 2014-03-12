package com.gameprobabilities.siokas;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Lotto extends Activity {

	RadioButton simple, complex;
	Button calc;
	TextView res, money;
	ImageView help;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_lotto, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.lotto_res:
			startActivity(new Intent("com.gameprobabilities.siokas.LOTTO_RES"));
			break;
		case R.id.lotto_draw:
			draw();
			break;
		case R.id.lotto_info:
			startActivity(new Intent("com.gameprobabilities.siokas.LOTTO_HELP"));
			break;
		case android.R.id.home:
			finish();
			return true;

		}
		return true;
	}
	
	private void draw() {
		Generate g = new Generate();
		final AlertDialog.Builder in = new AlertDialog.Builder(Lotto.this);
		in.setTitle(getString(R.string.LuckyDraw));
		in.setMessage((g.pick_num(49,6)));
		in.setNeutralButton(getString(R.string.Thanx), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});
		in.show();

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lotto);
		
		if (android.os.Build.VERSION.SDK_INT >= 11)
		{
			ActionBar actionBar = getActionBar();
		    actionBar.setDisplayHomeAsUpEnabled(true);
		}

		simple = (RadioButton) findViewById(R.id.lotto_simpleRadio);
		complex = (RadioButton) findViewById(R.id.lotto_complexRadio);
		calc = (Button) findViewById(R.id.lotto_Calculate);
		res = (TextView) findViewById(R.id.lotto_Result);
		money = (TextView) findViewById(R.id.lotto_Money);
		help = (ImageView) findViewById(R.id.imageViewLotto);

		final Spinner spinner = (Spinner) findViewById(R.id.spLotto1);

		List<String> list = new ArrayList<String>();
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
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);

		simple.setChecked(true);
		complex.setChecked(false);

		spinner.setEnabled(false);

		help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(
						"com.gameprobabilities.siokas.LOTTO_HELP"));
			}
		});
		simple.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simple.setChecked(true);
				complex.setChecked(false);

				spinner.setEnabled(false);

			}
		});

		complex.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				simple.setChecked(false);
				complex.setChecked(true);

				spinner.setEnabled(true);

			}
		});

		calc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (simple.isChecked()) {

					double n = Factorial.combin(6, 6);
					double pos = 1.0 / (Factorial.combin(49, 6));

					NumberFormat f = NumberFormat.getPercentInstance();
					f.setMinimumFractionDigits(2);
					f.setMaximumFractionDigits(10);
					
					double o3 = (Factorial.combin(6, 3) *  Factorial.combin(43, 3)) / Factorial.combin(49, 6);
					double o4 = (Factorial.combin(6, 4) *  Factorial.combin(43, 2)) / Factorial.combin(49, 6);
					double o5 = (Factorial.combin(6, 5) *  Factorial.combin(43, 1)) / Factorial.combin(49, 6);
					double o6 = (Factorial.combin(6, 6) *  Factorial.combin(43, 0)) / Factorial.combin(49, 6);
					double o7 = 6 / Factorial.combin(49, 6);
					String www = "";
					www = www.concat("   3: \t" + f.format(o3) + "\n");
					www = www.concat("   4: \t" + f.format(o4) + "\n");
					www = www.concat("   5: \t" + f.format(o5) + "\n");
					www = www.concat("5+1: \t" + f.format(o7) + "\n");
					www = www.concat("   6: \t" + f.format(o6) + "\n");

					AlertDialog alert = new AlertDialog.Builder(v.getContext())
							.create();
					alert.setTitle("Επιτυχίες Λόττο");
					alert.setCanceledOnTouchOutside(true);
					alert.setCancelable(true);
					alert.setMessage(www);
					alert.show();
					
					res.setText(getString(R.string.Probability) + ": " + f.format(pos));
					money.setText(getString(R.string.YouWillPay) + ": " + n / 2 + " euro");
				}
				if (complex.isChecked()) {

					int x = Integer.parseInt(spinner.getSelectedItem()
							.toString());
					NumberFormat f = NumberFormat.getPercentInstance();
					f.setMinimumFractionDigits(2);
					f.setMaximumFractionDigits(10);
					double n = Factorial.combin(x, 6);
	
					double o3 = (Factorial.combin(x, 3) *  Factorial.combin(49-x, 3)) / Factorial.combin(49, 6);
					double o4 = (Factorial.combin(x, 4) *  Factorial.combin(49-x, 2)) / Factorial.combin(49, 6);
					double o5 = (Factorial.combin(x, 5) *  Factorial.combin(49-x, 1)) / Factorial.combin(49, 6);
					double o6 = (Factorial.combin(x, 6) *  Factorial.combin(49-x, 0)) / Factorial.combin(49, 6);

					double o7 = 6 / Factorial.combin(49, 6);					
					String www = "";
					www = www.concat("   3: \t" + f.format(o3) + "\n");
					www = www.concat("   4: \t" + f.format(o4) + "\n");
					www = www.concat("   5: \t" + f.format(o5) + "\n");
					www = www.concat("5+1: \t" + f.format(o7) + "\n");
					www = www.concat("   6: \t" + f.format(o6) + "\n");
					

					AlertDialog alert = new AlertDialog.Builder(v.getContext())
							.create();
					alert.setTitle("Επιτυχίες Λόττο");
					alert.setCanceledOnTouchOutside(true);
					alert.setCancelable(true);
					alert.setMessage(www);
					alert.show();
					
					

					res.setText(getString(R.string.Probability) + ": " + f.format(o6));
					money.setText(getString(R.string.YouWillPay) + ": "+ n / 2 + " euro");

				}
			}

		});

	}

}
