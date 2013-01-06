package com.fractionlabs.test;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Splash extends Activity {
	MediaPlayer evil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		evil = MediaPlayer.create(Splash.this, R.raw.evillaugh);
		evil.start();
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();

				} finally {
					Intent showMenu = new Intent("com.fractionlabs.test.MENU");
					startActivity(showMenu);
				}

			};
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		evil.release();
		finish();
	}
}
