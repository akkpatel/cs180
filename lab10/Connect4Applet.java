import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class Connect4Applet extends JApplet{
   public void init() {
     setLayout(new BorderLayout());
     add(new JLabel("Connect 4"), BorderLayout.NORTH);
   
     JPanel p = new JPanel(new GridLayout(9, 7, 10, 10));
     IconPanel [][] panel = new IconPanel [8][7];
     JPanel panel2 = new JPanel();
     JButton [] click = new JButton [7];
     int [][] array = new int[8][7];
     
     for(int i = 0; i<8; i++){
       for(int j = 0; j<7; j++){
         array[i][j] = 0;
       }
     }
     
     for(int i = 0; i<9; i++){
       for(int j = 0; j<7; j++){
         if(i < 8)
           panel2.add(panel[i][j]);
         else
           panel2.add(click [7]);
              panel[i][j].setColor(array[i][j]);
       }
     }
     
     for(int i = 0; i < 8; i++){
     }
   }
     
   
   public static void main(String[] args){
       
   }
}
