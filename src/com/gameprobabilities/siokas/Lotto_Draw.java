package com.gameprobabilities.siokas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Lotto_Draw extends Activity{

	
	TextView draw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lotto_draw);
		
		draw = (TextView) findViewById(R.id.Draw_Rand_Lotto);
		
		Generate g = new Generate();
		draw.setText((g.pick_num(49,6)));
		
		
	}

	
}
