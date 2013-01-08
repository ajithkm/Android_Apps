package com.fracionlabs.testapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener {

	Button sqlUpdate, sqlView, sqlModify, sqlGetInfo, sqlDelete;
	EditText sqlname, sqlHotness, sqlRow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliliteexample);
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlView = (Button) findViewById(R.id.bSQLView);
		sqlname = (EditText) findViewById(R.id.etSQLName);
		sqlHotness = (EditText) findViewById(R.id.etSQLHotness);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);

		sqlRow = (EditText) findViewById(R.id.etSQLrowInfo);
		sqlModify = (Button) findViewById(R.id.bSQLmodify);
		sqlGetInfo = (Button) findViewById(R.id.bgetInfo);
		sqlDelete = (Button) findViewById(R.id.bSQLdelete);
		sqlDelete.setOnClickListener(this);
		sqlModify.setOnClickListener(this);
		sqlGetInfo.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSQLUpdate:
			boolean diditWork = true;

			try {
				String name = sqlname.getText().toString();
				String hotness = sqlHotness.getText().toString();

				HotOrNot entry = new HotOrNot(SQLiteExample.this);
				entry.open();
				entry.createEntry(name, hotness);
				entry.close();
			} catch (Exception e) {
				e.printStackTrace();
				diditWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Heck ya..");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();

			} finally {
				if (diditWork) {
					Dialog d = new Dialog(this);
					d.setTitle("Heck ya..");
					TextView tv = new TextView(this);
					tv.setText("Success");
					d.setContentView(tv);
					d.show();
				}
			}

			break;

		case R.id.bSQLView:
			Intent i = new Intent("com.fractionlabs.testapp.SQLVIEW");
			startActivity(i);

			break;

		case R.id.bgetInfo:
			String s = sqlRow.getText().toString();
			;
			long l = Long.parseLong(s);   
			HotOrNot hon = new HotOrNot(this);
			hon.open();
			String returnedName = hon.getName(l);
			String returnedHotness = hon.gethotness(l);
			hon.close();

			sqlname.setText(returnedName);
			sqlHotness.setText(returnedHotness);

			break;

		case R.id.bSQLmodify:

			break;

		case R.id.bSQLdelete:
			break;

		}

	}

}
