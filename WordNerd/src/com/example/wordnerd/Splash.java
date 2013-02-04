package com.example.wordnerd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Thread thread = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch(InterruptedException e) {
					
				} finally {
					Intent openMain = new Intent("android.intent.action.MAINSCREEN");
					startActivity(openMain);
				}
			}
		};
		thread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash, menu);
		return true;
	}

}
