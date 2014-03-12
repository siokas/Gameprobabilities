package com.gameprobabilities.siokas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Roulette_Draw extends Activity{

	
	TextView draw;
	Button gen;
	EditText nums;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.roulette_draw);
		
		draw = (TextView) findViewById(R.id.Draw_Rand_Roulette);
		gen = (Button) findViewById(R.id.GenerateRoulette);
		
		final Spinner spinner = (Spinner) findViewById(R.id.spRD1);

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
		

			gen.setOnClickListener(new View.OnClickListener() {
	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					
						Generate g = new Generate();
						draw.setText((g.pick_numRoulette(37,(Integer.parseInt(spinner.getSelectedItem().toString())))));
					}
				
			});
			
		
		
	}

	
}
