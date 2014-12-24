/* 
 * PhotoGUI.java 
 * The GUI and Action handler portion of a program designed to
 * allow you to load pictures then mirror, reflect a down the middle,
 * adjust the color, or rotate the colors in the pixel
 * 
 * @author Tyler Holzer 
 * 
 * @date 11/11/2010
 *
 * @C_date 7/30/2010
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PhotoGUI extends JFrame implements ActionListener {

 private JLabel image; //contains the image to display
 private JScrollPane pane; //scrollable pane that holds the image
 private JMenuBar menuBar; //the menubar
 private JMenu file,operations,threadMenu;
 private JMenu mirror, reflect, adjust, pixelRotate;
 private JMenuItem open, save,horizontal, vertical,leftSide,rightSide,top,bottom,red,green,blue,rg,rb,gb,rgb; //menuitem
 private JRadioButtonMenuItem button;
 private Picture pic; //holds the actual picture
 private JFileChooser fc; //file chooser to choose file
 
 /*constructor
  * sets the components of the GUI as well as initializes picture, numthreadMenus, and threadMenus
  **/
 public PhotoGUI() {
  super("PhotoGUI"); // Sets the title of the super (parent) class (the JFrame)
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  
  //initialize file chooser
  fc = new JFileChooser(); 
  
  //initialize the display window
  image=new JLabel();
  pane=new JScrollPane();
  pane.getViewport().add(image);
  add(pane,BorderLayout.CENTER); // Add pane to the frame.
  setSize(600,600);
  
  //initialize the menuBar with File menu. More menus need to be added by the students.
  menuBar=new JMenuBar();
  file=new JMenu("File");
  operations=new JMenu("Operations");
  threadMenu=new JMenu("Thread");
  
  
  //initialize and add open and save to the file menu
  open=new JMenuItem("Open");
  open.addActionListener(this);
  save=new JMenuItem("Save");
  save.addActionListener(this);
  file.add(open);
  file.add(save);
  
  mirror = new JMenu("Mirror");
  reflect = new JMenu("Reflect");
  adjust = new JMenu("Adjust");
  pixelRotate = new JMenu("Pixel Rotate");
  
  horizontal = new JMenuItem("Horizontal");
  vertical = new JMenuItem("Vertical");
  leftSide = new JMenuItem("Left Side");
  rightSide = new JMenuItem("Right Side");
  top = new JMenuItem("Top");
  bottom = new JMenuItem("Bottom");
  red = new JMenuItem("Red");
  green = new JMenuItem("Green");
  blue = new JMenuItem("Blue");
  rg = new JMenuItem("Red-Green");
  gb = new JMenuItem("Green-Blue");
  rb = new JMenuItem("Red-Blue");
  rgb = new JMenuItem("Red-Green-Blue");
  
  mirror.add(horizontal);
  mirror.add(vertical);
  
  reflect.add(leftSide);
  reflect.add(rightSide);
  reflect.add(top);
  reflect.add(bottom);
  
  adjust.add(red);
  adjust.add(green);
  adjust.add(blue);
  adjust.add(rg);
  adjust.add(gb);
  adjust.add(rb);
  adjust.add(rgb);
  
  pixelRotate.add(top);
  pixelRotate.add(bottom);
  
  operations.add(mirror);
  operations.add(reflect);
  operations.add(adjust);
  operations.add(pixelRotate);
  
  menuBar.add(file);
  menuBar.add(operations);
  menuBar.add(threadMenu);
  
  
  
  
  // create radiobuttons
  ButtonGroup radio = new ButtonGroup();
  button = new JRadioButtonMenuItem("1");
  radio.add(button);
  threadMenu.add(button);
  
  button = new JRadioButtonMenuItem("2");
  radio.add(button);
  threadMenu.add(button);
  
  button = new JRadioButtonMenuItem("3");
  radio.add(button);
  threadMenu.add(button);
  
  button = new JRadioButtonMenuItem("4");
  radio.add(button);
  threadMenu.add(button);
  
  button = new JRadioButtonMenuItem("5");
  radio.add(button);
  threadMenu.add(button);
  
  button = new JRadioButtonMenuItem("6");
  radio.add(button);
  threadMenu.add(button);
  
  button = new JRadioButtonMenuItem("7");
  radio.add(button);
  threadMenu.add(button);
  
  button = new JRadioButtonMenuItem("8");
  radio.add(button);
  threadMenu.add(button);
  //pack and set display visible
  add(menuBar,BorderLayout.NORTH);
  pack();
  setVisible(true);
  
  //initialize pic
  pic=null;
    }
    
    /*
     * ActionPerformed
     * handles all actions that occur in the GUI, while this method is being run, all buttons are deactivated
     * 
     * @param ActionEvent e: the event that caused this to be run
     */
    public void actionPerformed(ActionEvent e) {
     String filename="";
     
     //handles open being pressed
     if(e.getSource()==open) {
         try {
             fc.showOpenDialog(this);
             filename=fc.getSelectedFile().getPath();
             pic = new Picture(filename);
         }
         catch(ImageException ie) {
             pic=null; //display error if exception is caught
             JOptionPane.showMessageDialog(null,"An error has occured while opening the file you specified\nPlease verify the filename is correct and try again","Error",0);
         }
         catch(Exception E) { //handles the user closing or pressing the X on the JOptionPane
             pic=null;
         }
         if(pic!=null) { //if sucessful, update the title and pane
             setTitle("PhotoGUI -- "+filename);
             pane.getViewport().remove(image);
             image=pic.getImage();
             pane.getViewport().add(image);
             pack();
         }
     }
     //handles save being pressed
     if(e.getSource()==save) {
      try {
       fc.showSaveDialog(this);
       filename=fc.getSelectedFile().getPath();
       pic.save(filename);
      }
      catch(ImageException ie) {
       filename=""; //display error if exception is caught
       JOptionPane.showMessageDialog(null,"An error has occured while saving\nPlease verify the name is valid and try again","Error",0);
      }
      catch(Exception E) { //handles the user closing or pressing the X on the JOptionPane
       filename="";
      }
      if(filename!="") { //update title
       setTitle("PhotoGUI -- "+filename);
    pane.getViewport().remove(image);
       image=pic.getImage();
       pane.getViewport().add(image);
       pack();
      }
     }
     //refresh GUI
     repaint();
    }
     
 /*
  * main()
  * creates a PhotoGUI gui
  */
 public static void main(String [] args) {
  PhotoGUI gui= new PhotoGUI();
 }
}