package com.ajith.km.advancedbrightnesscontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {
  /** Called when the activity is first created. */

float BackLightValue = 0.5f;//dummy default value

  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
    
      SeekBar BackLightControl = (SeekBar)findViewById(R.id.backlightcontrol);
      final TextView BackLightSetting = (TextView)findViewById(R.id.backlightsetting);
      Button UpdateSystemSetting = (Button)findViewById(R.id.updatesystemsetting);

      WindowManager.LayoutParams lp = getWindow().getAttributes();
      BackLightValue = lp.screenBrightness ;
    
      UpdateSystemSetting.setOnClickListener(new Button.OnClickListener(){

  @Override
  public void onClick(View arg0) {
   // TODO Auto-generated method stub
  
   int SysBackLightValue = (int)(BackLightValue * 255);
  
   android.provider.Settings.System.putInt(getContentResolver(),
     android.provider.Settings.System.SCREEN_BRIGHTNESS,
     SysBackLightValue);
  
  }});
    
      BackLightControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

  @Override
  public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
   // TODO Auto-generated method stub
   BackLightValue = (float)arg1/100;
   BackLightSetting.setText(String.valueOf(BackLightValue));
  
   WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
   if(BackLightValue<0.1f)
	   BackLightValue=0.1f;
   layoutParams.screenBrightness = BackLightValue;
  
   getWindow().setAttributes(layoutParams);

  
  }

  @Override
  public void onStartTrackingTouch(SeekBar arg0) {
   // TODO Auto-generated method stub
  
  }

  @Override
  public void onStopTrackingTouch(SeekBar arg0) {
   // TODO Auto-generated method stub
  
  }});
  }
}