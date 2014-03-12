package com.gameprobabilities.siokas;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Thread timer = new Thread() {

			public void run() {
				try {
					sleep(2500);
					if (android.os.Build.VERSION.SDK_INT >= 11)
					{
						startActivity(new Intent(
								"com.gameprobabilities.siokas.MAIN_ACTIVITY"));
					}
					else{
						startActivity(new Intent("com.gameprobabilities.siokas.MENU"));
					}

					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					finish();
				}
			}

		};

		timer.start();

	}

}
