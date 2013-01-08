package com.fractionlabs.newzbuzz;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Football extends Activity implements OnClickListener {
	TabHost th;
	ImageView epl, laLiga, serieA, bundesLiga;
	WebView football;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.football);
		initialize_ui();
		initialize_tabs();
		initialize_webview();

	}

	private void initialize_webview() {
		football.setWebViewClient(new OurClient());
		football.getSettings().setJavaScriptEnabled(true);
		football.getSettings().setLoadsImagesAutomatically(true);
		football.getSettings().setLoadWithOverviewMode(true);
		football.getSettings().setUseWideViewPort(true);
		football.getSettings().setBuiltInZoomControls(true);
		final Activity activity = this;

		final ProgressDialog progressDialog = new ProgressDialog(activity);
		// progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

		progressDialog.setCancelable(false);

		football.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				progressDialog.show();

				progressDialog.setProgress(0);
				activity.setProgress(progress * 1000);

				progressDialog.incrementProgressBy(progress);

				if (progress >= 60 && progressDialog.isShowing())
					progressDialog.dismiss();
			}
		});

	}

	private void initialize_tabs() {
		th = (TabHost) findViewById(R.id.thFootball);
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
		epl = (ImageView) findViewById(R.id.ivEPL);
		laLiga = (ImageView) findViewById(R.id.ivLaliga);
		serieA = (ImageView) findViewById(R.id.ivSerieA);
		bundesLiga = (ImageView) findViewById(R.id.ivBundesliga);
		epl.setOnClickListener(this);
		laLiga.setOnClickListener(this);
		serieA.setOnClickListener(this);
		bundesLiga.setOnClickListener(this);
		football = (WebView) findViewById(R.id.wvFootball);

	}

	@Override
	public void onClick(View arg0) {
		football.clearView();
		switch (arg0.getId()) {
		case R.id.ivEPL:
			try {
				football.loadUrl("http://www.premierleague.com/en-gb.html");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ivLaliga:
			try {
				football.loadUrl("http://www.soccer-spain.com/index.php");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ivBundesliga:
			try {
				football.loadUrl("http://www.bundesliga.com/en/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;
		case R.id.ivSerieA:
			try {
				football.loadUrl("http://www.football-italia.net/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		}

	}
}
