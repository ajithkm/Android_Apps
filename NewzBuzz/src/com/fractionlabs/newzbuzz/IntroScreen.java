package com.fractionlabs.newzbuzz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntroScreen extends Activity implements OnClickListener {

	Button football, finance, sports, hollywood;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.introscreen);
		initialize_ui();
	}

	private void initialize_ui() {
		football = (Button) findViewById(R.id.bFootball);
		finance = (Button) findViewById(R.id.bFinance);
		sports = (Button) findViewById(R.id.bSports);
		hollywood = (Button) findViewById(R.id.bHollywood);
		football.setOnClickListener(this);
		finance.setOnClickListener(this);
		sports.setOnClickListener(this);
		hollywood.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent selection;
		switch (v.getId()) {
		case R.id.bFootball:
			selection = new Intent("com.fractionlabs.newzbuzz.FOOTBALL");
			startActivity(selection);

			break;
		case R.id.bFinance:
			selection = new Intent("com.fractionlabs.newzbuzz.FINANCE");
			startActivity(selection);

			break;
		case R.id.bSports:

			break;
		case R.id.bHollywood:

			break;

		}

	}

}
