package com.fracionlabs.testapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		ourSong = MediaPlayer.create(Splash.this, R.raw.solitude);
		SharedPreferences getprefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean music = getprefs.getBoolean("checkbox", true);
		if (music)
			ourSong.start();

		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent openStaringPoint = new Intent(
							"com.fractionlabs.testapp.MENU");
					startActivity(openStaringPoint);
				}

			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
