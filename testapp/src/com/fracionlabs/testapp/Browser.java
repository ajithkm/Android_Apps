package com.fracionlabs.testapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends Activity implements OnClickListener {
	WebView brow;
	EditText url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);

		brow = (WebView) findViewById(R.id.wbBrowser);
		brow.setWebViewClient(new ourclient());
		brow.getSettings().setJavaScriptEnabled(true);
		brow.getSettings().setLoadWithOverviewMode(true);
		brow.getSettings().setUseWideViewPort(true);
		try {
			brow.loadUrl("http://www.google.com");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Button go = (Button) findViewById(R.id.bGo);
		Button back = (Button) findViewById(R.id.bBack);
		Button forward = (Button) findViewById(R.id.bForward);
		Button history = (Button) findViewById(R.id.bHistory);

		Button refresh = (Button) findViewById(R.id.bRefresh);
		url = (EditText) findViewById(R.id.etURl);
		
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		forward.setOnClickListener(this);
		history.setOnClickListener(this);
		refresh.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bGo:
			String addr = url.getText().toString();
			brow.loadUrl(addr);
			//Hiding keyboard
			InputMethodManager ipm=(InputMethodManager)	getSystemService(Context.INPUT_METHOD_SERVICE);
			ipm.hideSoftInputFromWindow(url.getWindowToken(), 0);

			break;

		case R.id.bBack:
			if (brow.canGoBack())
				brow.goBack();
			break;
		case R.id.bForward:
			if (brow.canGoForward())
				brow.goForward();

			break;

		case R.id.bRefresh:
			brow.reload();

			break;
		case R.id.bHistory:
			brow.clearHistory();
			break;

		}

	}

}
