package com.gameprobabilities.siokas;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Kino extends Activity {

	protected static final Message BUTTON_NEUTRAL = null;
	Button calc;
	TextView res, money, pith;
	EditText num, mult, klir;
	ImageView help;
	Spinner spinner;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_kino, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.kino_res:
			startActivity(new Intent("com.gameprobabilities.siokas.KINO_RES"));
			break;
		case R.id.kino_draw:
			draw();
			break;
		case R.id.kino_info:
			startActivity(new Intent("com.gameprobabilities.siokas.KINO_HELP"));
			break;
		case android.R.id.home:
			finish();
			return true;

		}
		return true;
	}

	private void draw() {
		String[] s = { "1", "2", "3", "4", "5", "6",
		        "7", "8", "9", "10","11","12" };
		  final ArrayAdapter<String> adp = new ArrayAdapter<String>(Kino.this,
		            android.R.layout.simple_spinner_item, s);

		    final Spinner sp = new Spinner(Kino.this);
		    sp.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		    sp.setAdapter(adp);

		    final AlertDialog.Builder builder = new AlertDialog.Builder(Kino.this);
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
		final AlertDialog.Builder in = new AlertDialog.Builder(Kino.this);
		in.setTitle(getString(R.string.LuckyDraw));
		in.setMessage((g.pick_num(80,x)));
		in.setNeutralButton(getString(R.string.Thanx), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
			}
		});
		in.show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kino);
		
		if (android.os.Build.VERSION.SDK_INT >= 11)
		{
			ActionBar actionBar = getActionBar();
		    actionBar.setDisplayHomeAsUpEnabled(true);
		}

		calc = (Button) findViewById(R.id.kino_Calculate);
		res = (TextView) findViewById(R.id.kino_Result);
		money = (TextView) findViewById(R.id.kino_Money);
		pith = (TextView) findViewById(R.id.textViewPith);
		help = (ImageView) findViewById(R.id.imageViewKino);

		final Spinner spinner = (Spinner) findViewById(R.id.spKino1);
		final Spinner spinner2 = (Spinner) findViewById(R.id.spKino2);
		final Spinner spinner3 = (Spinner) findViewById(R.id.spKino3);

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
		list1.add("10");
		list1.add("20");
		list1.add("50");
		list1.add("100");
		list1.add("200");
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list1);
		dataAdapter1
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter1);

		List<String> list2 = new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add("4");
		list2.add("5");
		list2.add("6");
		list2.add("8");
		list2.add("10");
		list2.add("12");
		list2.add("20");
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list2);
		dataAdapter2
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(dataAdapter2);

		help.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(
						"com.gameprobabilities.siokas.KINO_HELP"));
			}
		});

		calc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				int y = Integer.parseInt(spinner.getSelectedItem().toString());
				int multi = Integer.parseInt(spinner2.getSelectedItem()
						.toString());
				int cont = Integer.parseInt(spinner3.getSelectedItem()
						.toString());

				double pos = ((Factorial.combin(80 - y, 20 - y) / (Factorial
						.combin(80, 20))));

				NumberFormat f = NumberFormat.getPercentInstance();
				f.setMinimumFractionDigits(2);
				f.setMaximumFractionDigits(15);

				double[] xxx = new double[y];
				String www = "";
				for (int i = 0; i < xxx.length; i++) {
					xxx[i] = ((((Factorial.combin(y, i)) * (Factorial.combin(
							80 - y, 20 - i))) / (Factorial.combin(80, 20))));
					www = www.concat(i + ".     ");
					www = www.concat(f.format(xxx[i]));
					www = www.concat("\n");
				}
				
				
				www = www.concat(y + ".     ");
				www = www.concat(f.format(pos));
				
				
				AlertDialog alert = new AlertDialog.Builder(Kino.this).create();
				alert.setTitle(getString(R.string.KinoSuper));
				alert.setCanceledOnTouchOutside(true);
				alert.setCancelable(true);
				alert.setMessage(www);
				alert.setButton(getString(R.string.BackTo), BUTTON_NEUTRAL);
				alert.show();

				res.setText(f.format(pos));
				pith.setText(getString(R.string.Probability) + ": ");
				money.setText(getString(R.string.YouWillPay) + ": " + (cont * (multi * 0.5))
						+ " euro");

			}

		});
	}

}