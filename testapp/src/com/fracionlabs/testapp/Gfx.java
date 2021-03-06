package com.fracionlabs.testapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class Gfx extends Activity {

	MyBringBack ourView;
	WakeLock wl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		// wakelock
		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "tag");

		super.onCreate(savedInstanceState);
		wl.acquire();
		ourView = new MyBringBack(this);
		setContentView(ourView);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wl.release();
	}
}
