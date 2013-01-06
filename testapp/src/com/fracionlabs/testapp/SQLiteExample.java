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

public class SQLiteExample extends Activity implements OnClickListener{
	
	Button sqlUpdate,sqlView;
	EditText sqlname,sqlHotness;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqliliteexample);
		sqlUpdate =(Button) findViewById(R.id.bSQLUpdate);
		sqlView =(Button) findViewById(R.id.bSQLView);
		sqlname =(EditText) findViewById(R.id.etSQLName);
		sqlHotness =(EditText) findViewById(R.id.etSQLHotness);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);
		
				
				
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSQLUpdate:
			boolean diditWork = true;

			try{
			String name = sqlname.getText().toString();
			String hotness=sqlHotness.getText().toString();
			
			HotOrNot entry = new HotOrNot(SQLiteExample.this);
			entry.open();
			entry.createEntry(name,hotness);
			entry.close();
			}catch(Exception e){
				e.printStackTrace();
				diditWork = false;
				Dialog d = new Dialog(this);
				d.setTitle("Heck ya..");
				TextView tv = new TextView(this);
				tv.setText("failed");
				d.setContentView(tv);
				d.show();
				
			}finally{
				if(diditWork){
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
			
		}
		
	}

}
