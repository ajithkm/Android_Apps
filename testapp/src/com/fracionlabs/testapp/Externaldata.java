package com.fracionlabs.testapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Externaldata extends Activity implements OnItemSelectedListener,
		OnClickListener {

	private TextView canWrite, canRead;
	private String state;
	boolean canR, canW;
	Spinner spin;
	String[] paths = { "Music", "Pictures", "Download" };
	File path = null;
	File filename = null;
	Button save, confirm;
	EditText saveFile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		canWrite = (TextView) findViewById(R.id.tvCanWrite);
		canRead = (TextView) findViewById(R.id.tvCanRead);
		confirm = (Button) findViewById(R.id.bconfirm);
		save = (Button) findViewById(R.id.bsavefile);
		saveFile =(EditText) findViewById(R.id.etSaveAs);
		confirm.setOnClickListener(this);
		save.setOnClickListener(this);
		checkstate();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				Externaldata.this, android.R.layout.simple_spinner_item, paths);

		spin = (Spinner) findViewById(R.id.spinner1);
		spin.setAdapter(adapter);
		spin.setOnItemSelectedListener(this);
	}

	private void checkstate() {
		// TODO Auto-generated method stub

		state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			// read and write
			canWrite.setText("true");
			canRead.setText("true ");
			canW = canR = true;

		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			canWrite.setText("false");
			canRead.setText("true ");
			canW = false;
			canR = true;

		} else {
			canWrite.setText("false");
			canRead.setText("false");
			canW = canR = false;
		}

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		int position = spin.getSelectedItemPosition();
		switch (position) {
		case 0:
			path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);

			break;

		case 1:
			path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;

		case 2:
			path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bsavefile:
			String f = saveFile.getText().toString();
			filename = new File(path, f+".png");
			checkstate();
			if (canW == canR == true) {
				path.mkdirs();

				try {
					InputStream is = getResources().openRawResource(
							R.drawable.myic);

					OutputStream os = new FileOutputStream(filename);
					byte[] data = new byte[is.available()];
					is.read(data);
					os.write(data);
					is.close();
					os.close();
					Toast t = Toast.makeText(Externaldata.this, "File Saved	", Toast.LENGTH_LONG);
					t.show();
					//Update Media Scanner
					MediaScannerConnection.scanFile(Externaldata.this, new String[]{filename.toString()}, null, new MediaScannerConnection.OnScanCompletedListener() {
						
						@Override
						public void onScanCompleted(String path, Uri uri) {
							// TODO Auto-generated method stub
							Toast t = Toast.makeText(Externaldata.this, "Scan Complete	", Toast.LENGTH_SHORT);
							t.show();
						}
					});
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			break;

		case R.id.bconfirm:
			save.setVisibility(View.VISIBLE);
			break;
		}

	}

}
