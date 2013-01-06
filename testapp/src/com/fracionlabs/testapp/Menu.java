package com.fracionlabs.testapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "MainActivity", "TextPlay", "Email", "Camera", "Data",
			"Gfx" , "GfxSurface", "Sound", "Slider","Tabs","Browser","Flipper","Sharedprefs","Externaldata","SQLiteExample"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// fULLsCREEN
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String temp = classes[position];
		try {
			Class ourClass = Class.forName("com.fracionlabs.testapp." + temp);
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		// super.onCreateOptionsMenu(menu);
		MenuInflater blowup = getMenuInflater();
		blowup.inflate(R.menu.coolmenu, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.itaboutUs:
			Intent i = new Intent("com.fractionlabs.testapp.ABOUT");
			startActivity(i);

			break;

		case R.id.itpref:
			Intent p = new Intent("com.fractionlabs.testapp.PREFS");
			startActivity(p);

			break;
		case R.id.itexit:
			finish();
			break;

		}
		return true;
	}
}
