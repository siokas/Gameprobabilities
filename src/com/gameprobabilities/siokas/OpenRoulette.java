package com.gameprobabilities.siokas;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OpenRoulette {
	View v;
	RadioButton simple, am, cols;
	Button calc;
	TextView res, moneywin, moneylose;
	EditText moneybet;
	ImageView help;

	public OpenRoulette(View v) {
		this.v = v;
	}

	public void onCreate() {
		simple = (RadioButton) v.findViewById(R.id.roulette_simpleRadio);
		am = (RadioButton) v.findViewById(R.id.am);
		cols = (RadioButton) v.findViewById(R.id.columns);
		calc = (Button) v.findViewById(R.id.roulette_Calculate);
		res = (TextView) v.findViewById(R.id.roulette_Result);
		moneywin = (TextView) v.findViewById(R.id.roulette_MoneyWin);
		moneylose = (TextView) v.findViewById(R.id.roulette_MoneyLose);
		moneybet = (EditText) v.findViewById(R.id.money_bet);
		help = (ImageView) v.findViewById(R.id.imageViewRoulette);

		final Spinner spinner = (Spinner) v.findViewById(R.id.spRoulette1);

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

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
				v.getContext(), android.R.layout.simple_spinner_item, list);
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
				Intent intent = new Intent(v.getContext(), Roulette_Help.class);
	            ((Activity)v.getContext()).startActivity(intent);
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
						Toast.makeText(v.getContext(),
								"Λάθος! Πληκτρολόγησε ξανά το Ποσό Πονταρίσματος", Toast.LENGTH_LONG)
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

						res.setText("Πιθανότητα: " + f.format(result));
						moneylose.setText("Θα πληρώσεις: " + (ibet * imoneybet)
								+ " euro");
						moneywin.setText("Θα κερδίσεις: " + (36 * imoneybet)
								+ " euro");
					}
				}
				if (am.isChecked()) {

					String check2 = moneybet.getText().toString();

					if (check2.matches("")) {
						Toast.makeText(v.getContext(),"Λάθος! Πληκτρολόγησε ξανά το Ποσό Πονταρίσματος", Toast.LENGTH_LONG)
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

						res.setText("Πιθανότητα: " + f.format(result));
						moneylose.setText("Θα πληρώσεις: " + (imoneybet)
								+ " euro");
						moneywin.setText("Θα κερδίσεις: " + (2 * imoneybet)
								+ " euro");

					}
				}

				if (cols.isChecked()) {

					String check2 = moneybet.getText().toString();

					if (check2.matches("")) {
						Toast.makeText(v.getContext(),
								"Λάθος! Πληκτρολόγησε ξανά το Ποσό Πονταρίσματος", Toast.LENGTH_LONG)
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

						res.setText("Πιθανότητα: " + f.format(result));
						moneylose.setText("Θα πληρώσεις: " + (imoneybet)
								+ " euro");
						moneywin.setText("Θα κερδίσεις: " + (3 * imoneybet)
								+ " euro");

					}
				}
			}

		});

	}

}
