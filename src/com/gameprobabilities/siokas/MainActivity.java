package com.gameprobabilities.siokas;


import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;


public class MainActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {
	static Boolean Joker = false;
	static Boolean Kino = false;
	static Boolean Lotto = false;
	static Boolean Roulette = false;
	static Boolean JokerSel = false;
	static Boolean KinoSel = false;
	static Boolean LottoSel = false;
	static Boolean RoulettSele = false;

	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Joker = false;
		Kino = false;
		Lotto = false;
		Roulette = false;

		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(new ArrayAdapter<String>(
				getActionBarThemedContextCompat(),
				android.R.layout.simple_list_item_1, android.R.id.text1,
				new String[] { getString(R.string.title_section1),
						getString(R.string.title_section2),
						getString(R.string.title_section3),
						getString(R.string.title_section4), }), this);
	}

	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	private Context getActionBarThemedContextCompat() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			return getActionBar().getThemedContext();
		} else {
			return this;
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.clear();
		if (Joker)
			getMenuInflater().inflate(R.menu.menu_joker, menu);
		else if (Kino)
			getMenuInflater().inflate(R.menu.menu_kino, menu);
		else if (Lotto)
			getMenuInflater().inflate(R.menu.menu_lotto, menu);
		else if (Roulette)
			getMenuInflater().inflate(R.menu.menu_roul, menu);;
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear();
		if (Joker)
			getMenuInflater().inflate(R.menu.menu_joker, menu);
		else if (Kino)
			getMenuInflater().inflate(R.menu.menu_kino, menu);
		else if (Lotto)
			getMenuInflater().inflate(R.menu.menu_lotto, menu);
		else if (Roulette)
			getMenuInflater().inflate(R.menu.menu_roul, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.joker_res:
			startActivity(new Intent("com.gameprobabilities.siokas.JOKER_RES"));
			break;
		case R.id.joker_info:
			startActivity(new Intent("com.gameprobabilities.siokas.JOKER_HELP"));
			break;
		case R.id.joker_draw:
			Generate g = new Generate();
			final AlertDialog.Builder in = new AlertDialog.Builder(MainActivity.this);
			in.setTitle(getString(R.string.LuckyDraw));
			in.setMessage((g.pick_num(45,5))+"\n"+(g.pick_num(20,1)));
			in.setNeutralButton(getString(R.string.Thanx), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
				}
			});
			in.show();
			break;
		case R.id.lotto_res:
			startActivity(new Intent("com.gameprobabilities.siokas.LOTTO_RES"));
			break;
		case R.id.lotto_info:
			startActivity(new Intent("com.gameprobabilities.siokas.LOTTO_HELP"));
			break;
		case R.id.lotto_draw:
			Generate g1 = new Generate();
			final AlertDialog.Builder in1 = new AlertDialog.Builder(MainActivity.this);
			in1.setTitle(getString(R.string.LuckyDraw));
			in1.setMessage((g1.pick_num(49,6)));
			in1.setNeutralButton(getString(R.string.Thanx), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
				}
			});
			in1.show();
			break;
		case R.id.kino_res:
			startActivity(new Intent("com.gameprobabilities.siokas.KINO_RES"));
			break;
		case R.id.kino_info:
			startActivity(new Intent("com.gameprobabilities.siokas.KINO_HELP"));
			break;
		case R.id.kino_draw:
				String[] s = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
						"10", "11", "12" };
				final ArrayAdapter<String> adp = new ArrayAdapter<String>(
						MainActivity.this,
						android.R.layout.simple_spinner_item, s);

				final Spinner sp = new Spinner(MainActivity.this);
				sp.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				sp.setAdapter(adp);

				final AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setTitle(getString(R.string.KinoNums));
				builder.setView(sp);
				builder.setMessage(getString(R.string.Choose));
				builder.setNeutralButton(getString(R.string.DoIt),
						new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								showme((sp.getSelectedItem().toString()));
							}

							private void showme(String s) {
								int x = Integer.parseInt(s);
								Generate g = new Generate();
								final AlertDialog.Builder in = new AlertDialog.Builder(
										MainActivity.this);
								in.setTitle(getString(R.string.LuckyDraw));
								in.setMessage((g.pick_num(80, x)));
								in.setNeutralButton(getString(R.string.Thanx),
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog,
													int whichButton) {
											}
										});
								in.show();

							}

						});
				builder.create().show();

			break;
		case R.id.roul_info:
			startActivity(new Intent("com.gameprobabilities.siokas.ROULETTE_HELP"));
		break;
		case R.id.roul_draw:
				String[] s1 = { "1", "2", "3 ", "4", "5", "6", "7", "8", "9",
						"10", "11", "12", "13", "12", "15", "16", "17", "18",
						"19", "20", "21", "22", "23", "24", "25", "26", "27",
						"28", "29", "30", "31", "32", "33", "34", "35", "36", };
				final ArrayAdapter<String> adp1 = new ArrayAdapter<String>(
						MainActivity.this,
						android.R.layout.simple_spinner_item, s1);

				final Spinner sp1 = new Spinner(MainActivity.this);
				sp1.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				sp1.setAdapter(adp1);

				final AlertDialog.Builder builder1 = new AlertDialog.Builder(
						MainActivity.this);
				builder1.setTitle(getString(R.string.RuleNums));
				builder1.setView(sp1);
				builder1.setMessage(getString(R.string.Choose));
				builder1.setNeutralButton(getString(R.string.DoIt),
						new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								showme((sp1.getSelectedItem().toString()));
							}
							private void showme(String s) {
								int x = Integer.parseInt(s);
								Generate g = new Generate();
								final AlertDialog.Builder in = new AlertDialog.Builder(
										MainActivity.this);
								in.setTitle(getString(R.string.LuckyDraw));
								in.setMessage((g.pick_num(37, x)));
								in.setNeutralButton(getString(R.string.Thanx),
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog,
													int whichButton) {
											}
										});
								in.show();
							}
						});
				builder1.create().show();
			break;
		}
		
		return true;

	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		Fragment fragment = new DummySectionFragment();
		Bundle args = new Bundle();
		args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
		fragment.setArguments(args);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();
		return true;
	}

	public static class DummySectionFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View v = null;
			if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
				Joker = true;
				Kino = false;
				Lotto = false;
				Roulette = false;
				v = inflater.inflate(R.layout.joker, null);
				OpenJoker oj = new OpenJoker(v);
				oj.onCreate();
			}
			if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
				Joker = false;
				Kino = true;
				Lotto = false;
				Roulette = false;
				v = inflater.inflate(R.layout.kino, null);
				OpenKino ok = new OpenKino(v);
				ok.onCreate();
			}
			if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
				Joker = false;
				Kino = false;
				Lotto = true;
				Roulette = false;
				v = inflater.inflate(R.layout.lotto, null);
				OpenLotto ol = new OpenLotto(v);
				ol.onCreate();
			}
			if (getArguments().getInt(ARG_SECTION_NUMBER) == 4) {
				Joker = false;
				Kino = false;
				Lotto = false;
				Roulette = true;
				v = inflater.inflate(R.layout.roulette, null);
				OpenRoulette or = new OpenRoulette(v);
				or.onCreate();
			}
			return v;
		}
	}

}
