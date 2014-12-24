/**

* Program Name: Menu Project

* This program is a java based game. It includes a variety of 
* features that any computer based game has. The program required an input which was already provided for us
* (the GUI file). From those inputs provided i have created a program that computes
* all the data and runs a game.

*

* Authors: Abhishek Gupta and Anand Patel

*

* Recitation section number: 001  Recitation instructor's name: Lorenzo Martin

*

* 07/14/2010

*

* 07/18/2010

*/

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class MenuProjects implements MenuListener,ActionListener{ 
 String [] names = new String [15] ; 
 int [] scores = new int [15]; 
  String name;
  JMenu gameMenu, settingsMenu, scoresMenu;
  JMenuItem start,quit,pause,exit,speedinc,speeddec,deselected;
  JMenuBar mbar; 
  Gui g,f; 
  int counter =0;
  boolean speedchange = false; 
  boolean newGameFlag=false; 
  boolean quitGameFlag= false; 
  int speed ; 
  boolean hasExited = false; 
  int cx ; //cursor x
  int cy; //cursor y
  double gx=0; // green x // - > enemies
  double gy=0; //green y 
  double rx=0; // redx -> asteroids
  double ry=0; //redy
  double distanceFromRed; 
  double distanceFromGreen; 
  boolean colRed = false; 
  boolean colGreen= false; 
  int xTeleLeft ; 
  int xTeleRight; 
  int yTeleUp; 
  int yTeleDown ;  
  double xDiff; 
  double yDiff;
  long timeDifference = 0 ; 
  int score = 0; 
  long  time1 = System.currentTimeMillis()  ; 
  long time2 = System.currentTimeMillis(); 
  boolean running =false; 
//  public static boolean playAgain = false; 
  String menuChoice = "" ; 
  boolean nameEntered =false;
// long timeDifference= 0;
  int startGame=0; 
  boolean restart = false; 
  // Create menus
  public void createMenus(){ 
    gameMenu=new JMenu("Game");
    
    gameMenu.addMenuListener(this);
    settingsMenu=new JMenu("Settings");
    
    settingsMenu.addMenuListener(this);
    scoresMenu=new JMenu("Scores");
    
    scoresMenu.addMenuListener(this);
  }
  ///  startnewgame, quit game, pause , exit
  // Create menu items
  public void createItems(){ 
    start=new JMenuItem("Start New Game");
    quit=new JMenuItem("Quit Game"); 
    pause=new JMenuItem("Pause");
    exit=new JMenuItem("Exit");
    speedinc=new JMenuItem("Increase Speed");
    speeddec=new JMenuItem("Decrease Speed");
    deselected = new JMenuItem (" " ); 
    
    // Add action listeners
    start.addActionListener(this);
    quit.addActionListener(this);
    pause.addActionListener(this);
    exit.addActionListener(this);
    speedinc.addActionListener(this);
    speeddec.addActionListener(this);
    
    // Add the items to menus
    gameMenu.add(start); 
    gameMenu.add(quit); 
    gameMenu.add(pause); 
    gameMenu.add(exit);
    settingsMenu.add(speedinc); 
    settingsMenu.add(speeddec); 
  }
  
  
  // Create menu bar
  public void createMenuBar(){
    mbar=new JMenuBar();
    mbar.add(gameMenu);
    mbar.add(settingsMenu); 
    mbar.add(scoresMenu); 
  }
  
  public void menuCanceled(MenuEvent e){
    
    
  }
  
  public void menuDeselected(MenuEvent e){
    
    
  }
  
  public void menuSelected(MenuEvent e){
    Object ob=e.getSource();
    
     if(running == true) { 
      pause.setText("Resume");
      }
    if (ob==gameMenu) { 
      menuChoice = "Game"; 
    } 
    else if (ob == settingsMenu){ 
      menuChoice = "Settings"; 
    } 
    else { 
      menuChoice = "Scores"; 
    } 
    
  }
  
  
  public void actionPerformed(ActionEvent e){
    Object menuItem=e.getSource();
    
    
    
    
    if(menuChoice.equals("Game")){
     
      findGameSelected(menuItem);
      
    }
    else if(menuChoice.equals("Settings")){
      findSettingsSelected(menuItem); 
    } 
    else if(menuChoice.equals("scores")){
      
      displayScore(menuItem); 
      
    }
    
  }
  public void createGui(){ 
    
    f = new Gui(); 
    f.setJMenuBar(mbar); 
    xTeleLeft = 30; 
    xTeleRight = f.getWidth() -30; 
    yTeleUp = 30; 
    yTeleDown = f.getHeight()-30;  
    f.display(); 
    
  } 
  public void findGameSelected(Object item ){
  //  pause.setText("Resume"); 
    
      if (item == start ) { 
        
        if( running == true ) { 
          pause.setText("Resume"); 
          String choice = JOptionPane.showInputDialog(null," Are you sure you want to restart?  : " , "Name", JOptionPane.QUESTION_MESSAGE);
          if(choice.equals("NO")){ 
            pause.setText("Pause"); 
          } 
          else{ 
             pause.setText("Pause"); 
         //    nameEntered = false; 
          //   timeDifference = 0;
          quitGameFlag = true; 
             newGameFlag = false; 
            quitGameFlag = false; 
          }
        }
        if(running == false){
        if(hasExited == true){ 
       pause.setText("Pause"); 
         //    nameEntered = false; 
          //   timeDifference = 0;
          quitGameFlag = true; 
             newGameFlag = false; 
            quitGameFlag = false; 
        } 
        else{ 
         newGameFlag=true;; 
        } 
        }
        // playGame();
      }
      
      
      //quitop = false;
      // String name = JOptionPane.showMessageDialog(null," Your Name : " , "Name", JOptionPane.INFORMATION_MESSAGE);
      
      if (item == quit) { 
        System.exit(0);
        //quitop=true;
        
      } 
      if (item== pause) { 
        pauseGame();  
      }
      if( item==exit){ 
        
        String choice = JOptionPane.showInputDialog(null," Are you sure you want to exit?  : " , "Name", JOptionPane.QUESTION_MESSAGE);
        if(choice.equals("NO")){ 
          pause.setText("Pause"); 
        }
        else{ 
     // running = false; 
     // timeDifference = 40000;
//timeDifference = 0; 
          
       JOptionPane.showMessageDialog(null,"Your game has ended. You're score is " + score, "Score" , JOptionPane.INFORMATION_MESSAGE) ; 
        running = false; 
       quitGameFlag = true;
        newGameFlag = false; 
        hasExited = true;
        
        
        }
        
      } 
      //} 
    } 
  
  
  public void findSettingsSelected(Object item){
   
    if (item ==speedinc) { 
      speedchange = true;
      String speedplus = JOptionPane.showInputDialog(null," By how much would you like to increase the speed by  ? " , "Speed", JOptionPane.QUESTION_MESSAGE);
      if(speed -Integer.valueOf((speedplus)).intValue()>=0){
      speed -=  Integer.valueOf((speedplus)).intValue();
    }
      
    }
    else{ 
      speedchange = true; 
      String speedminus = JOptionPane.showInputDialog(null," By how much would you like to decrease the speed by  ? " , "Speed", JOptionPane.QUESTION_MESSAGE);
   speed += Integer.valueOf((speedminus)).intValue();
    } 
     pause.setText("Pause"); 
  }
  
  public void displayScore(Object item){ 
  sort();
 // for ( int i =0;i<counter;i++){ 
// JOptionPane.showMessageDialog(null, "" +names[i] + " " + scores[i] +" " , JOptionPane.INFORMATION_MESSAGE) ; 
   String s;
     s = " ";
    for(int i=0; i<counter; i++){
      s=s+names[i]+" "+scores[i]+"\n";
      
}
    
    JOptionPane.showMessageDialog(null,scores,"Top Scores",JOptionPane.INFORMATION_MESSAGE);
  }  
  //method for creating the gui 
  public void gamer() { 
    
    while(quitGameFlag==false){
      while(newGameFlag == false){
        try{
          
          Thread.sleep(10);
        }catch(Exception e){}
      }
      reset();
    //  running = true; 
      playGame(); 
      
       JOptionPane.showMessageDialog(null,"Your game has ended. You're score is " + score, "Score" , JOptionPane.INFORMATION_MESSAGE) ; 
     scores[counter]=score; 
     names[counter] = name;
     counter++;
       running = false; 
      newGameFlag = false; 
      
    }
  }
  public void adjustNewGameFlag(){ 
    if (newGameFlag== false){ 
      newGameFlag =true; 
    }
    else newGameFlag= false; 
  } 
  
  public void playGame() { 
    //   running = true;
    /*  int cx ; //cursor x
     int cy; //cursor y
     double gx=0; // green x // - > enemies
     double gy=0; //green y 
     double rx=0; // redx -> asteroids
     double ry=0; //redy
     double distanceFromRed; 
     double distanceFromGreen; 
     boolean colRed = false; 
     boolean colGreen= false; 
     int xTeleLeft = 30; 
     int xTeleRight = f.getWidth() -30; 
     int yTeleUp = 30; 
     int yTeleDown = f.getHeight()-30;  
     double xDiff; 
     double yDiff; 
     timeDifference = 0 ; 
     int score = 0; 
     long  time1 = System.currentTimeMillis()  ; 
     long time2 = System.currentTimeMillis(); 
     */
  //  while( nameEntered == false) { 
    name = JOptionPane.showInputDialog(null," Your Name : " , "Name", JOptionPane.QUESTION_MESSAGE);
    nameEntered =true;
 // restart=false;
   // }
    
    
    
    while ( timeDifference < 30000){
      if(isPaused()==false && nameEntered==true) {
        f.display();
        running = true;
        time2 = System.currentTimeMillis(); 
        timeDifference= time2-time1;
        cx = f.getX(); 
        cy = f.getY(); 
        cy= f.getY(); 
        if( cx < 28) { 
          f.setX(xTeleRight); 
        } 
        if ( cx> xTeleRight +2){ 
          f.setX(xTeleLeft); 
        } 
        if ( cy < 28) { 
          g.setY(yTeleDown); 
        }  
        if( cy> f.getHeight()+2){ 
          f.setY(yTeleUp); 
        } 
        for( int i = 0 ; i < 10; i++)
        { // this is for the enemies 
          gx=  f.getEnemyX(i); 
          gy =   f.getEnemyY(i);
          // this is for the asteroids
          rx =  f.getAsteroidX(i); 
          ry =   f.getAsteroidY(i);
          
          //checking the collision for asteroids
          xDiff = Math.pow( (cx-rx),2); 
          yDiff = Math.pow( ( cy-ry),2); 
          distanceFromRed = Math.sqrt( xDiff+yDiff); 
          if( distanceFromRed < 28.0) { 
            colRed = true;   
            
            f.changeAsteroid(i); 
            f.decreaseScore(); 
            score--;
          } 
          /// checking collisions for enemies
          xDiff = Math.pow( (cx-gx),2); 
          yDiff = Math.pow( ( cy-gy),2); 
          distanceFromGreen = Math.sqrt( xDiff+yDiff); 
          if( distanceFromGreen < 28.0) { 
            colGreen = true;  
            
            f.changeEnemy(i);  
            f.increaseScore();
            score++;
          }
        }
        
      }  
      time2 = System.currentTimeMillis(); 
      timeDifference = time2-time1; 
     
      
         try{
          
          Thread.sleep(speed);
        }catch(Exception e){}
      }
      
    }
    // nameEntered =false;
  
  
  
  
  
  
  
  public  boolean isPaused(){ 
    String  pos =  pause.getText(); 
    boolean a = false; 
    if (pos.equals("Pause")){ 
      a= false; 
    }
    if(pos.equals("Resume")){ 
      a= true; 
    }
    return a; 
  }   
  public void pauseGame(){ 
   String  pos =  pause.getText(); 
        if (pos.equals("Pause")){ 
          // pauseop =true; 
          pause.setText("Resume"); 
        }
        if(pos.equals("Resume")){ 
          // pauseop =false; 
          pause.setText("Pause"); 
        }
  } 
  
  public void reset() { 
    running = false; 
    nameEntered = false; 
    
    speed = 0;
    gx=0; // green x // - > enemies
    gy=0; //green y 
    rx=0; // redx -> asteroids
    ry=0; //redy
    // distanceFromRed; 
    //  distanceFromGreen; 
    colRed = false; 
    colGreen= false; 
    xTeleLeft = 30; 
    xTeleRight = f.getWidth() -30; 
    yTeleUp = 30; 
    yTeleDown = f.getHeight()-30;  
    // xDiff; 
    // yDiff;
    timeDifference = 0 ; 
    score = 0; 
    time1 = System.currentTimeMillis()  ; 
    time2 = System.currentTimeMillis(); 
  } 
 
  public void sort(){
 int tempInt = 0; 
 String tempString = ""; 
  for(int i=0; i < counter; i++){
  for(int j=0; j <counter-1; j++){
     if(scores[j] < scores[j+1]){
        tempInt = scores[j];
        tempString = names[j];
        scores[j] = scores[j+1];
        names[j] = names[j+1];
       scores[j+1] = tempInt;
       names[j+1] = tempString;
     }
  }
  }

  }
// method for creating the menu 
  
  
//playing the game 
  
  
  
//} 
  public static void main( String args[]){ 
    
    MenuProjects m = new MenuProjects(); 
    m.createMenus();
    m.createItems(); 
    m.createMenuBar(); 
    m.createGui(); 
    m.gamer();
    
  }
  
}
