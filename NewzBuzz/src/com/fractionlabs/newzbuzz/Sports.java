package com.fractionlabs.newzbuzz;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class Sports extends Activity implements OnClickListener {
	TabHost th;
	ImageButton espn, nbc, si, cbs;
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
		sports.getSettings().setBuiltInZoomControls(true);
		final Activity activity = this;

		final ProgressDialog progressDialog = new ProgressDialog(activity);
		// progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

		progressDialog.setCancelable(false);

		sports.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				progressDialog.show();

				progressDialog.setProgress(0);
				activity.setProgress(progress * 1000);

				progressDialog.incrementProgressBy(progress);

				if (progress >= 75 && progressDialog.isShowing())
					progressDialog.dismiss();
			}
		});

	sports.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				sports.loadUrl("file:///android_asset/error.html");
				Toast.makeText(activity, "Oh no! " + description,
						Toast.LENGTH_SHORT).show();

			}
		});
		

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
		espn = (ImageButton) findViewById(R.id.ibEspn);
		nbc = (ImageButton) findViewById(R.id.ibNbcSports);
		si = (ImageButton) findViewById(R.id.ibSportsIllustrated);
		cbs = (ImageButton) findViewById(R.id.ibCbsSports);
		espn.setOnClickListener(this);
		nbc.setOnClickListener(this);
		si.setOnClickListener(this);
		cbs.setOnClickListener(this);
		sports = (WebView) findViewById(R.id.wvSports);

	}

	@Override
	public void onClick(View arg0) {
		sports.clearView();
		switch (arg0.getId()) {
		case R.id.ibEspn:
			try {
				sports.loadUrl("http://espn.go.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ibNbcSports:
			try {
				sports.loadUrl("http://nbcsports.msnbc.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ibSportsIllustrated:
			try {
				sports.loadUrl("http://sportsillustrated.cnn.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;
		case R.id.ibCbsSports:
			try {
				sports.loadUrl("http://cbssports.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		}

	}
}
