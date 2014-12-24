package edu.purdue.ball;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Vibrator;

public class Bomb extends ActionPoint {

 BasePoint cursor;
  
 public Bomb(BasePoint x){
  super();
  cursor=x;
  x_vel=2;
  y_vel=2;
  this.setColor(Color.BLACK);

 }
 
 public void move(){
   
   double x1 = cursor.x-x;
   double y1 = cursor.y-y;
   double vec = Math.sqrt( Math.pow(x1,2) + Math.pow(y1,2));
   double vecX = x1/vec;
   double vecY = y1/vec;
   double vec1 = vecX*3;
   double vec2 = vecY*3;

   x+=vec1;
   y+=vec2;
   
   position();
 }
}
