package com.gameprobabilities.siokas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class GameProbabilitiesMain extends Activity {
    /** Called when the activity is first created. */
	
	ImageButton joker,kino,lotto,roulette;
	
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true; 
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		System.runFinalizersOnExit(true);
		System.exit(0);
		return true;
	}

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        joker = (ImageButton) findViewById(R.id.joker_btn);
        kino = (ImageButton) findViewById(R.id.kino_btn);
        lotto = (ImageButton) findViewById(R.id.lotto_btn);
        roulette = (ImageButton) findViewById(R.id.roulette_btn);
        
        joker.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent("com.gameprobabilities.siokas.JOKER"));
				
			}
		});
        
        kino.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent("com.gameprobabilities.siokas.KINO"));
				
			}
		});
        
        lotto.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent("com.gameprobabilities.siokas.LOTTO"));
				
			}
		});

        roulette.setOnClickListener(new View.OnClickListener() {
	
        	@Override
        	public void onClick(View v) {
		
        		startActivity(new Intent("com.gameprobabilities.siokas.ROULETTE"));
		
        	}
        });
        
        
    }
}