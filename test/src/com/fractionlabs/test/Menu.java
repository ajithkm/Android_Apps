package com.fractionlabs.test;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.System;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "TextPlay", "Splash" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try {
			Class ourClass = Class.forName("com.fractionlabs.test.Splash");
			Intent showSplash = new Intent(Menu.this, ourClass);
			startActivity(showSplash);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
