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

public class Kino_Draw extends Activity{

	
	TextView draw;
	Button gen;
	EditText nums;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kino_draw);
		
		draw = (TextView) findViewById(R.id.Draw_Rand_Kino);
		gen = (Button) findViewById(R.id.GenerateKino);
		
		final Spinner spinner = (Spinner) findViewById(R.id.spKD1);

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
		
		
		

			gen.setOnClickListener(new View.OnClickListener() {
	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				
						Generate g = new Generate();
						draw.setText((g.pick_num(80,(Integer.parseInt(spinner.getSelectedItem().toString())))));
					
				}
			});
			
		
		
	}

	
}
