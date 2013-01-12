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
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class Movies extends Activity implements OnClickListener {
	TabHost th;
	ImageButton imdb, rottentomatoes, tmz, bwdhungama;
	WebView movies;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movies);
		initialize_ui();
		initialize_tabs();
		initialize_webview();

	}

	private void initialize_webview() {
		movies.setWebViewClient(new OurClient());
		movies.getSettings().setJavaScriptEnabled(true);
		movies.getSettings().setLoadsImagesAutomatically(true);
		movies.getSettings().setLoadWithOverviewMode(true);
		movies.getSettings().setUseWideViewPort(true);
		movies.getSettings().setBuiltInZoomControls(true);
		final Activity activity = this;

		final ProgressDialog progressDialog = new ProgressDialog(activity);
		// progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

		progressDialog.setCancelable(false);

		movies.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				progressDialog.show();

				progressDialog.setProgress(0);
				activity.setProgress(progress * 1000);

				progressDialog.incrementProgressBy(progress);

				if (progress >= 75 && progressDialog.isShowing())
					progressDialog.dismiss();
			}
		});
		movies.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				movies.loadUrl("file:///android_asset/error.html");
				Toast.makeText(activity, "Oh no! " + description,
						Toast.LENGTH_SHORT).show();

			}
		});

	}

	private void initialize_tabs() {
		th = (TabHost) findViewById(R.id.thMovies);
		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tabMoviesHome);
		specs.setIndicator("Home");

		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tabMoviesView);
		specs.setIndicator("View");
		th.addTab(specs);

	}

	private void initialize_ui() {
		imdb = (ImageButton) findViewById(R.id.ibImdb);
		rottentomatoes = (ImageButton) findViewById(R.id.ibRottenTomatoes);
		tmz = (ImageButton) findViewById(R.id.ibTmz);
		bwdhungama = (ImageButton) findViewById(R.id.ibBollywoodHungama);
		imdb.setOnClickListener(this);
		rottentomatoes.setOnClickListener(this);
		tmz.setOnClickListener(this);
		bwdhungama.setOnClickListener(this);
		movies = (WebView) findViewById(R.id.wvMovies);

	}

	@Override
	public void onClick(View arg0) {
		movies.clearView();
		switch (arg0.getId()) {
		case R.id.ibImdb:
			try {
				movies.loadUrl("http://www.imdb.com/");
				
			} catch (Exception e) {
				e.printStackTrace();
				Toast t = new Toast(this);
				t.setText("cannot load url");
				t.setDuration(Toast.LENGTH_LONG);
				t.show();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ibRottenTomatoes:
			try {
				movies.loadUrl("http://www.rottentomatoes.com");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ibTmz:
			try {
				movies.loadUrl("http://www.tmz.com/");
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;
		case R.id.ibBollywoodHungama:
			try {
				movies.loadUrl("http://www.bollywoodhungama.com/more/news");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		}

	}
}
