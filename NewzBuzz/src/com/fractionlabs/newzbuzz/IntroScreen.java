package com.fractionlabs.newzbuzz;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class IntroScreen extends Activity implements OnClickListener {

	ImageButton football, finance, sports, movies;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.introscreen);
		initialize_ui();
	}

	private void initialize_ui() {
		football = (ImageButton) findViewById(R.id.ibFootball);
		finance = (ImageButton) findViewById(R.id.ibFinance);
		sports = (ImageButton) findViewById(R.id.ibSports);
		movies = (ImageButton) findViewById(R.id.ibMovies);
		football.setOnClickListener(this);
		finance.setOnClickListener(this);
		sports.setOnClickListener(this);
		movies.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent selection;
		switch (v.getId()) {
		case R.id.ibFootball:
			selection = new Intent("com.fractionlabs.newzbuzz.FOOTBALL");
			startActivity(selection);

			break;
		case R.id.ibFinance:
			selection = new Intent("com.fractionlabs.newzbuzz.FINANCE");
			startActivity(selection);

			break;
		case R.id.ibSports:
			selection = new Intent("com.fractionlabs.newzbuzz.SPORTS");
			startActivity(selection);

			break;
		case R.id.ibMovies:
			selection = new Intent("com.fractionlabs.newzbuzz.MOVIES");
			startActivity(selection);

			break;

		}

	}

}
