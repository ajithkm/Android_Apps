package com.fracionlabs.testapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sharedprefs extends Activity implements OnClickListener {

	EditText sharedData;
	TextView dataResults;
	SharedPreferences someData;
	public static String filename = "MySharedString";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupvariables();
		someData = getSharedPreferences(filename, 0);

	}

	private void setupvariables() {
		// TODO Auto-generated method stub
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedData);
		dataResults = (TextView) findViewById(R.id.tvDataResult);
		save.setOnClickListener(this);
		load.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSave:
			String data =sharedData.getText().toString();
			SharedPreferences.Editor editor = someData.edit();
			editor.putString("sharedstring", data);
			editor.commit();

			break;

		case R.id.bLoad:
			someData = getSharedPreferences(filename, 0);
			String dataReturned = someData.getString("sharedstring", "Invalid filename");
			dataResults.setText(dataReturned);
			break;

		}

	}

}
