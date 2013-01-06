package com.fractionlabs.newzbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Football extends Activity implements OnClickListener {
	TabHost th;
	Button epl, laLiga, serieA, bundesLiga;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.football);
		initialize_ui();
		initialize_tabs();
	}

	private void initialize_tabs() {
		th = (TabHost) findViewById(R.id.thFootbal);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tabFootballHome);
		specs.setIndicator("Home");
		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tabFootballView);
		specs.setIndicator("View");
		th.addTab(specs);

	}

	private void initialize_ui() {
		epl = (Button) findViewById(R.id.bEPL);
		laLiga = (Button) findViewById(R.id.bLaLiga);
		serieA = (Button) findViewById(R.id.bSerieA);
		bundesLiga = (Button) findViewById(R.id.bBundesLiga);
		epl.setOnClickListener(this);
		laLiga.setOnClickListener(this);
		serieA.setOnClickListener(this);
		bundesLiga.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.bEPL:
			break;

		case R.id.bLaLiga:
			break;

		case R.id.bBundesLiga:
			break;
		case R.id.bSerieA:
			break;

		}

	}
}
