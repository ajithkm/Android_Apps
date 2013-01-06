package com.fracionlabs.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.TabSpec;

public class Tabs extends Activity implements OnClickListener {

	TabHost th;
	TextView res;
	long start = 0, stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		th = (TabHost) findViewById(R.id.tabhost);
		Button newTab = (Button) findViewById(R.id.bAddTab);
		Button start = (Button) findViewById(R.id.bStart);
		Button stop = (Button) findViewById(R.id.bStop);
		res = (TextView) findViewById(R.id.tvShowResults);
		start.setOnClickListener(this);
		stop.setOnClickListener(this);
		newTab.setOnClickListener(this);

		th.setup();
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("Stop Watch");
		th.addTab(specs);
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Tab 2");
		th.addTab(specs);
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Add a Tab");
		th.addTab(specs);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bAddTab:
			TabSpec ourspec = th.newTabSpec("tag3");
			ourspec.setContent(new TabHost.TabContentFactory() {

				@Override
				public View createTabContent(String arg0) {
					// TODO Auto-generated method stub

					TextView text = new TextView(Tabs.this);
					text.setText("New Tab created");
					return (text);
				}
			});
			ourspec.setIndicator("New");
			th.addTab(ourspec);
			break;

		case R.id.bStart:
			start = System.currentTimeMillis();
			break;

		case R.id.bStop:
			stop = System.currentTimeMillis();
			if (start != 0) {
				long result = stop - start;
				int millis = (int) result;
				int second = (int) result / 1000;
				int min = (int) second / 60;
				millis = millis % 100;
				second = second % 60;
				res.setText(String.format("%d:%02d:%02d", min, second, millis));
			}

			break;

		}

	}
}
