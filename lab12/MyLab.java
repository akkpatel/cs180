import java.util.Vector;

import edu.purdue.cs180.Shutter;
import edu.purdue.cs180.Display;
import edu.purdue.cs180.Picture;

public class MyLab extends Thread 
{
  
  int num = 0;   // holds the value for adding a picture objet to the pics array
  Picture[] pics = new Picture[5]; //holds all pictures
  int length = 0;  //holds how many picture are in the pics array, used primarly 
       //when there are less than 5 pictures in the pics array
  int showInt = 0; //holds the position in the array for which picture is shown in the left screen.
  
  public MyLab(){
    
    new Thread(){
      public void run(){
        while(true){
         //TODO: Implement Taking Picture
          Show picture = picturewaitForButton();
          Display.showPicture(picture); // this two lines clicks the shutter button to take a picture.
          Display.setText("Picture" + (num + 1));
          
          pics[num] = picture;
          
          showInt = num;
          
          num++;
          
        }
      }
    }.start();
    
    
    new Thread(){
      public void run(){
        while(true){
         //TODO: Implement Button Action
          
          length = pics.length - 1;
          
          if(Display.waitForButton()){
            showInt += 1;
            
            if (showInt > length)
              showInt = length;
            
            Display.showPicture(pics[showInt]);
          }
          else{
            showInt -= 1;
            
            if (showInt < 0)
              showInt = 0;
            
            Display.showPicture(pics[showInt]);
          }
          
          
        }
        
      }
      
    }.start();
    
  }
  
      
  
  public static void main(String[] args) 
  { 
    
    new MyLab();
    
  }
}
