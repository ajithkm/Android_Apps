package com.fractionlabs.newzbuzz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Movies extends Activity implements OnClickListener {
	TabHost th;
	ImageView imdb, rottentomatoes, tmz, bwdhungama;
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
		imdb = (ImageView) findViewById(R.id.ivImdb);
		rottentomatoes = (ImageView) findViewById(R.id.ivRottentomates);
		tmz = (ImageView) findViewById(R.id.ivTmz);
		bwdhungama = (ImageView) findViewById(R.id.ivBollywoodHungama);
		imdb.setOnClickListener(this);
		rottentomatoes.setOnClickListener(this);
		tmz.setOnClickListener(this);
		bwdhungama.setOnClickListener(this);
		movies = (WebView) findViewById(R.id.wvMovies);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.ivImdb:
			try {
				movies.loadUrl("http://www.imdb.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ivRottentomates:
			try {
				movies.loadUrl("http://www.rottentomatoes.com");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;

		case R.id.ivTmz:
			try {
				movies.loadUrl("http://www.tmz.com/");
			} catch (Exception e) {
				e.printStackTrace();
			}
			th.setCurrentTab(1);
			break;
		case R.id.ivBollywoodHungama:
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
