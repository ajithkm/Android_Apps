package com.fractionlabs.newzbuzz;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class Finance extends Activity implements OnClickListener {
	TabHost th;
	ImageButton forbes, cnn, bloomberg, wsj;
	WebView finance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finance);
		initialize_ui();
		initialize_tabs();
		initialize_webview();

	}

	private void initialize_webview() {
		finance.setWebViewClient(new OurClient());
		finance.getSettings().setJavaScriptEnabled(true);
		finance.getSettings().setLoadsImagesAutomatically(true);
		finance.getSettings().setLoadWithOverviewMode(true);
		finance.getSettings().setUseWideViewPort(true);
		finance.getSettings().setBuiltInZoomControls(true);
		final Activity activity = this;

		final ProgressDialog progressDialog = new ProgressDialog(activity);
		// progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

		progressDialog.setCancelable(false);

		finance.setWebChromeClient(new WebChromeClient() {
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
		th = (TabHost) findViewById(R.id.thFinance);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tabFinancelHome);
		specs.setIndicator("Home");

		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tabFinanceView);
		specs.setIndicator("View");
		th.addTab(specs);

	}

	private void initialize_ui() {
		forbes = (ImageButton) findViewById(R.id.ibForbes);
		cnn = (ImageButton) findViewById(R.id.ibCnnMoney);
		bloomberg = (ImageButton) findViewById(R.id.ibBloomberg);
		wsj = (ImageButton) findViewById(R.id.ibWSJ);
		forbes.setOnClickListener(this);
		cnn.setOnClickListener(this);
		bloomberg.setOnClickListener(this);
		wsj.setOnClickListener(this);
		finance = (WebView) findViewById(R.id.wvFinance);

	}

	@Override
	public void onClick(View arg0) {
		finance.clearView();
		switch (arg0.getId()) {
		case R.id.ibForbes:
			th.setCurrentTab(1);

			try {

				finance.loadUrl("http://www.forbes.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;

		case R.id.ibCnnMoney:
			try {
				finance.loadUrl("http://money.cnn.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ibBloomberg:
			try {
				finance.loadUrl("http://www.bloomberg.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;
		case R.id.ibWSJ:
			try {
				finance.loadUrl("http://online.wsj.com/home-page");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		}

	}
}
