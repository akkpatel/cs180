//package edu.purdue.shake;

import java.util.ArrayList;
import java.util.Arrays;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ShakeListener implements SensorEventListener, OnClickListener{
 
 TextView view;
 
 int[] list = new int[14];
 int counter=0;
 
 float last_x=0;
 float last_y=0;
 float last_z=0;
 long lastUpdate = -1;
 
 boolean run;
 
 String str1 = new String();
 
 static final int SHAKE_THRESHOLD = 800;
 
 public ShakeListener(TextView text){
  view=text;
 }

 public void onAccuracyChanged(Sensor arg0, int arg1) {

 }

 public void onSensorChanged(SensorEvent event) {
   if(event.sensor.getType()==SensorManager.SENSOR_ACCELEROMETER && run){
    long curTime = System.currentTimeMillis();

    if ((curTime - lastUpdate) > 100) {
     long diff = (curTime - lastUpdate);
          lastUpdate = curTime;

    
    float x = event.values[SensorManager.DATA_X];
    float y = event.values[SensorManager.DATA_Y];
    float z = event.values[SensorManager.DATA_Z];
   
    float speed = Math.abs(x+y+z - last_x - last_y - last_z)/ diff * 10000;
    
    if(speed>600){
     view.setText(""+speed);
     final float k = speed;
     new Thread(new Runnable(){
      public void run(){
       add(list,(int)k);
      }
     }).start();
    }
    
    last_x=x;
    last_y=y;
    last_z=z;
    
   }
    
 }

}
 //TODO PART 1

 //TODO PART 4 
 public void add(int[] array, int num){

   //array[14] = num;

   this.sort(array);
   
   if(counter == 14)
     array[14] = num;
   else{
     array[counter] = num;
     counter++;
   }
 } 
 public void onClick(View v) {
  if(run){ 
   run=false;
   ((Button)v).setText("Resume");
   view.setText(printArray(list));
  }
  else{ 
   run=true;
   ((Button)v).setText("Stop");
  }
  
 }

 //TODO PART 3
 public void sort(int[] array){
   
   int temp = 0;
  
  for(int i = 0; i < 14; i++)
  {
    for(int j = i; j < 14; j++)
    {
      if(array[j] < array[j+1])
      {
        temp = array[j];
        array[j] = array[j+1];
        array[j+1] = temp;
      }
    }
  }
  
 }
 
 //TODO PART 2 
 public String printArray(int[] array){
   this.sort(list);
   for(int i = 0; i<10; i++)
   {
     view.setText(array[i]);
   }

  return " implement printArray ";
 }
 

}
