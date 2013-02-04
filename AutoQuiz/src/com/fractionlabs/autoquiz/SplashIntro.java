package com.fractionlabs.autoquiz;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SplashIntro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashintro);

		Thread splashthread = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openMenu = new Intent(
							"com.fractionlabs.autoquiz.MENU");
					startActivity(openMenu);
				}
			}
		};
		splashthread.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
