package com.fractionlabs.maps;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.os.Bundle;

public class Main extends MapActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		MapView map;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		map=(MapView) findViewById(R.id.mvMain);
		map.setBuiltInZoomControls(true);
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
