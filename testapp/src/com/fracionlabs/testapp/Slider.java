package com.fracionlabs.testapp;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener,
		OnCheckedChangeListener, OnDrawerOpenListener {

	SlidingDrawer sd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		Button h1 = (Button) findViewById(R.id.button1);
		Button h2 = (Button) findViewById(R.id.button2);
		Button h3 = (Button) findViewById(R.id.button3);
		Button h4 = (Button) findViewById(R.id.button4);
		CheckBox cb = (CheckBox) findViewById(R.id.cbslidable);
		sd = (SlidingDrawer) findViewById(R.id.sdDr);
		sd.setOnDrawerOpenListener(this);

		cb.setOnCheckedChangeListener(this);
		h1.setOnClickListener(this);
		h2.setOnClickListener(this);
		h3.setOnClickListener(this);
		h4.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			sd.open();

			break;
		case R.id.button2:

			break;
		case R.id.button3:
			sd.toggle();
			break;
		case R.id.button4:
			sd.close();
			break;
		}

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if (buttonView.isChecked()) {
			sd.lock();

		} else {
			sd.unlock();
		}
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		MediaPlayer mp = MediaPlayer.create(this, R.raw.evil);
		mp.start();

	}
}
