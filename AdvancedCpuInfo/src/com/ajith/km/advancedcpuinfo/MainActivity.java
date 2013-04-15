package com.ajith.km.advancedcpuinfo;

import java.io.IOException;
import java.io.InputStream;
//import java.util.StringTokenizer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	
 /** Called when the activity is first created. */
 @Override
 public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
  
     TextView CPUinfo = (TextView) findViewById(R.id.CPUinfo);
     CPUinfo.setText(ReadCPUinfo());
     if(true){ 
    	 TextView CPUfreq = (TextView) findViewById(R.id.CPUfreq);
         CPUfreq.setText(ReadCpuFrequency());
     }
	
     }
  
 

 private String ReadCPUinfo()
 {
  ProcessBuilder cmd;
 
  String result = "";
 // String max="";
 // String min="";
try{
   String[] args = {"/system/bin/cat", "/proc/cpuinfo"};
   cmd = new ProcessBuilder(args);
   
   Process process = cmd.start();
   InputStream in = process.getInputStream();
   byte[] re = new byte[1024];
   while(in.read(re) != -1){
    System.out.println(new String(re));
    result = result + new String(re);
   }
   in.close();
  } catch(IOException ex){
   ex.printStackTrace();
  }

/*try{
	   String[] args = {"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"};
	   cmd = new ProcessBuilder(args);
	   
	   Process process = cmd.start();
	   InputStream in = process.getInputStream();
	   byte[] re = new byte[1024];
	   while(in.read(re) != -1){
	    System.out.println(new String(re));
	    max = max + new String(re);
	   }
	   in.close();
	  } catch(IOException ex){
	   ex.printStackTrace();
	  }
	
	 
	 result = result + "\n Maximum Cpu Frequency is " + max ;
	
 
try{
	   String[] args = {"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"};
	   cmd = new ProcessBuilder(args);
	   
	   Process process = cmd.start();
	   InputStream in = process.getInputStream();
	   byte[] re = new byte[1024];
	   while(in.read(re) != -1){
	    System.out.println(new String(re));
	    min = min + new String(re);
	   }
	   in.close();
	  } catch(IOException ex){
	   ex.printStackTrace();
	  }

result = result + "\n Minimum Cpu Frequency is " + min;


  */
  return  result;
 }

 private String ReadCpuFrequency()
 {
	// ProcessBuilder cmd;
	 String max="Maximum Cpu Frequency is 652 MHz\n";
	 String min="Minimum Cpu Frequency is 352 MHz\nSmartassv2 Ramp Frequency is 528 MHz\n";
	
	String Live="";
	Live = max+min;


 return Live;
}

}