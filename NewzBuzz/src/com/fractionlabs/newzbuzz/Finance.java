package com.fractionlabs.newzbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Finance extends Activity implements OnClickListener {
	TabHost th;
	ImageView forbes, cnn, bloomberg, wsj;
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
		forbes = (ImageView) findViewById(R.id.ivForbes);
		cnn = (ImageView) findViewById(R.id.ivCnnMoney);
		bloomberg = (ImageView) findViewById(R.id.ivBloomberg);
		wsj = (ImageView) findViewById(R.id.ivWSJ);
		forbes.setOnClickListener(this);
		cnn.setOnClickListener(this);
		bloomberg.setOnClickListener(this);
		wsj.setOnClickListener(this);
		finance = (WebView) findViewById(R.id.wvFinance);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.ivForbes:
			try {
				finance.loadUrl("http://www.forbes.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ivCnnMoney:
			try {
				finance.loadUrl("http://money.cnn.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ivBloomberg:
			try {
				finance.loadUrl("http://www.bloomberg.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;
		case R.id.ivWSJ:
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
