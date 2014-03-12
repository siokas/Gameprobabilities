package com.gameprobabilities.siokas;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class OpenLotto {
	View v;
	RadioButton simple, complex;
	Button calc;
	TextView res, money;
	ImageView help;

	public OpenLotto(View v) {
		this.v=v;
	}

	public void onCreate() {
		simple = (RadioButton) v.findViewById(R.id.lotto_simpleRadio);
		complex = (RadioButton) v.findViewById(R.id.lotto_complexRadio);
		calc = (Button) v.findViewById(R.id.lotto_Calculate);
		res = (TextView) v.findViewById(R.id.lotto_Result);
		money = (TextView) v.findViewById(R.id.lotto_Money);
		help = (ImageView) v.findViewById(R.id.imageViewLotto);

		final Spinner spinner = (Spinner) v.findViewById(R.id.spLotto1);

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
		list.add("46");
		list.add("47");
		list.add("48");
		list.add("49");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(v.getContext(),
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
				Intent intent = new Intent(v.getContext(), Lotto_Help.class);
	            ((Activity)v.getContext()).startActivity(intent);;
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
			public void onClick(View vy) {
				if (simple.isChecked()) {

					double n = Factorial.combin(6, 6);
					double pos = 1.0 / (Factorial.combin(49, 6));

					NumberFormat f = NumberFormat.getPercentInstance();
					f.setMinimumFractionDigits(2);
					f.setMaximumFractionDigits(10);

					res.setText("Πιθανότητα: " + f.format(pos));
					money.setText("Θα πληρώσεις: " + n / 2 + " euro");
				}
				if (complex.isChecked()) {

					int x = Integer.parseInt(spinner.getSelectedItem()
							.toString());

					double n = Factorial.combin(x, 6);

					double pos = (1.0 / (Factorial.combin(49, 6))) * n;

					NumberFormat f = NumberFormat.getPercentInstance();
					f.setMinimumFractionDigits(2);
					f.setMaximumFractionDigits(10);

					res.setText("Πιθανότητα: " + f.format(pos));
					money.setText( "Θα πληρώσεις: "+ n / 2 + " euro");

				}
			}

		});
		
	}

}
