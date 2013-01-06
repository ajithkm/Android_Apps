package com.fractionlabs.newzbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Sports extends Activity implements OnClickListener {
	TabHost th;
	ImageView espn, nbc, si, cbs;
	WebView sports;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sports);
		initialize_ui();
		initialize_tabs();
		initialize_webview();

	}

	private void initialize_webview() {
		sports.setWebViewClient(new OurClient());
		sports.getSettings().setJavaScriptEnabled(true);
		sports.getSettings().setLoadsImagesAutomatically(true);
		sports.getSettings().setLoadWithOverviewMode(true);
		sports.getSettings().setUseWideViewPort(true);

	}

	private void initialize_tabs() {
		th = (TabHost) findViewById(R.id.thSports);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tabSportsHome);
		specs.setIndicator("Home");

		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tabSportsView);
		specs.setIndicator("View");
		th.addTab(specs);

	}

	private void initialize_ui() {
		espn = (ImageView) findViewById(R.id.ivESPN);
		nbc = (ImageView) findViewById(R.id.ivNbcSports);
		si = (ImageView) findViewById(R.id.ivSportsIllustrated);
		cbs = (ImageView) findViewById(R.id.ivCbsSports);
		espn.setOnClickListener(this);
		nbc.setOnClickListener(this);
		si.setOnClickListener(this);
		cbs.setOnClickListener(this);
		sports = (WebView) findViewById(R.id.wvSports);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.ivESPN:
			try {
				sports.loadUrl("http://espn.go.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ivNbcSports:
			try {
				sports.loadUrl("http://nbcsports.msnbc.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ivSportsIllustrated:
			try {
				sports.loadUrl("http://sportsillustrated.cnn.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;
		case R.id.ivCbsSports:
			try {
				sports.loadUrl("http://www.cbssports.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		}

	}
}
