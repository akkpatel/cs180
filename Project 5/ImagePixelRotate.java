import java.awt.image.*;
import javax.swing.*;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;


public class ImagePixelRotate implements ActionListener {
BufferedImage im;
JLabel  label = new JLabel(); // Space for three  labels
    JFrame  frame = new JFrame(); // Space for three frames
    JMenuBar menuBar;
    JMenu pixelRotate;
    JMenuItem leftRotate, rightRotate;
    String  frameTitle= "PIXEL ROTATION";
    int imageWidth, imageHeight; // To be calculated after the image is read.
   

public ImagePixelRotate(){
   
   
        // Read image into a BufferedImage. 
        // To begin with all images are identical.
        // There will an exception if the image file does not exit.
        try{
            im =ImageIO.read(new File("Snail.jpg"));
            }catch(Exception e){
            System.out.println("File read unsuccessful");
            System.exit(0);
        }// End of try-catch     
        
            createGui();
        // Get image width and height.
        // These are the same for all three images.
        
        int imageWidth=im.getWidth();
        int imageHeight=im.getHeight(); 
        System.out.println("Image width and height: "+imageWidth+" "+imageHeight);
        
               
}// End of constructor

 public void createGui(){
   
           label = new JLabel();
           label.setHorizontalAlignment(JLabel.CENTER);
           label.setIcon(new ImageIcon(im));
           
           menuBar = new JMenuBar();
           
           pixelRotate = new JMenu("PIXEL ROTATE");
           
           leftRotate = new JMenuItem("Left");
           leftRotate.addActionListener(this);
           rightRotate = new JMenuItem("Right");
           rightRotate.addActionListener(this);
          
           
           pixelRotate.add(leftRotate);
           pixelRotate.add(rightRotate);
          
           
           menuBar.add(pixelRotate);
           
           
           // Create frame
           frame = new JFrame(frameTitle);
           frame.setJMenuBar(menuBar);
           //frame.setSize(imageWidth, imageHeight);
           frame.add(label, BorderLayout.CENTER);
           frame.setVisible(true);

 
 
 }
 
 public void rotatePixel(char choice){
 for(int i = 0; i < imageWidth; i++){
              for(int j = 0; j < imageHeight; j++){
                  
                  // Get the RGB of the pixel and cate a Color object.
                  int rgb = im.getRGB(i, j);
                  Color oldPixel = new Color(rgb);
                  
                  // Now get the colors from the Color object and apply filters
                  int red = oldPixel.getRed();
                  int green = oldPixel.getGreen();
                  int blue = oldPixel.getBlue();
                  // Create a Color object with updated colors.
                  Color newPixel = new Color(green, blue, red); ;
                  
                  if(choice == 'l'){
                 newPixel = new Color(green, blue, red );
                  
                  }else if(choice == 'r'){
                  newPixel = new Color(blue, red, green );
                  
                  }
                  
                  // Get the RGB of the new Color object and reset the image pixel.
                  rgb = newPixel.getRGB();
                  im.setRGB(i, j, rgb);
              }// End of height loop    
          }// End of width loop
            label.setIcon(new ImageIcon(im));

  
 
 
 }
 
 
 
 public void actionPerformed(ActionEvent e){
   
   Object b = e.getSource();
       
   if(b == leftRotate){
    rotatePixel('l');    
       
   }else if(b == rightRotate){
    rotatePixel('r');
           
   }
 
 }
  
 
 
public static void main(String[] args) {
new ImagePixelRotate();

}

}

