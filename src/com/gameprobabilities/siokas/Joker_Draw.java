package com.gameprobabilities.siokas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Joker_Draw extends Activity{

	
	TextView draw,draw1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.joker_draw);
		
		draw = (TextView) findViewById(R.id.Draw_Rand);
		draw1 = (TextView) findViewById(R.id.Draw_Rand1);
		
		
		
		Generate g = new Generate();
		draw.setText((g.pick_num(45,5)));
		draw1.setText((g.pick_num(20,1)));

		
	}

	
}
