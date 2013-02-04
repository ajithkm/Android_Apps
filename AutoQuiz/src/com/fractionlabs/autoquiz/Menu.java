package com.fractionlabs.autoquiz;

import android.R.color;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;

public class Menu extends Activity implements OnClickListener {
	ProgressBar classicpb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// ImageButton classic,connect;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		// classic=(ImageButton) findViewById(R.id.ibClassic);
		// connect=(ImageButton) findViewById(R.id.ibConnect);
		classicpb =(ProgressBar) findViewById(R.id.progressBar1);
			}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
