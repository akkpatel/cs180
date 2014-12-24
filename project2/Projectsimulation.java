/**
* Project2 -- SpaceSimulation
* This program imports the gui package already created,
* and we have to use that package, methods and classes
* provided by the teacher to make the game run in a 
* technical way.
*
* @author Anand Patel
*
* @recitation 001 and Lorenzo D. Martino
*
* @date October 7, 2010
*
* @C_date October 8,2010
*/

import javax.swing.*;
import java.lang.*;
import java.util.*;
public class Projectsimulation{
  public static void main(String [] args){
    
       long startTime=System.currentTimeMillis();
       
    //import the class file

    Gui g = new Gui();
    boolean condition = true;
    while(condition==true){
      g.display();
    int x=g.getX();
    int y=g.getY();
    //teleportation
    if(x>860){
      g.setX(0);
      g.setY(y);
     }
    if(x<0){
      g.setX(860);
      g.setY(y);
     }
    if(y>860){
      g.setX(x);
      g.setY(0);
     }
    if(y<0){
      g.setX(x);
      g.setY(860);
     }
    //detecting collisions
    for(int i=0; i<10; i++){
      x=g.getX(); 
      y=g.getY();
        double a = g.getEnemyX(i);
        double b = g.getAsteroidX(i);
        double c = g.getEnemyY(i);
        double d = g.getAsteroidY(i);
        double e = (a-x);
        double f = (c-y);
        double h = Math.pow(e,2);
        double j = Math.pow(f,2);
        double k = Math.sqrt(h+j);
        double l = (b-x);
        double m = (d-y);
        double n = Math.pow(l,2);
        double o = Math.pow(m,2);
        double p = Math.sqrt(n+o);
    if (k<=28){
         g.increaseScore(); 
         g.changeEnemy(i);
    }
    if (p<=28){
         g.decreaseScore(); 
         g.changeAsteroid(i);
    }
    }
    long finishTime=System.currentTimeMillis();
    long timeLapsed=finishTime-startTime;
    if(timeLapsed>30000){
    condition=false;
    }
      }
    
    JOptionPane.showMessageDialog(null,"Your Score: " +g.getScore(),"Game Ended",JOptionPane.INFORMATION_MESSAGE);
  } 
  }
  
  
 

