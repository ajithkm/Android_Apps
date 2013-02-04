package com.fracionlabs.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HttpExample extends Activity {
	TextView httpstuff;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		httpstuff = (TextView) findViewById(R.id.tvHttp);
		GetMethodEx test = new GetMethodEx();
		String returned;
		try {
			returned = test.getInternetData();
			httpstuff.setText(returned);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
