/*
 * Picture.java 
 * Part of a program designed to allow you to load pictures
 * then mirror, reflect a down the middle, adjust the color, 
 * or rotate the colors in the pixel. This holds and allows 
 * you to edit the image's pixels
 * 
 * @author Tyler Holzer 
 * 
 * @date 07/26/2010
 *
 * @C_date 7/30/2010
 */
 
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Picture {
 
 private BufferedImage image;
 private String filename;
 
 /*
  * Constructor
  * takes a filename as a input then attemps to open said filename
  * as an image, throws an ImageException if an error occurs
  * 
  * @param filename: the filename of the pic
  */
 public Picture(String filename) throws ImageException {
  this.filename=filename;
  //try opening
  try {
   File file = new File(filename);
   image=ImageIO.read(file);
  }
  //if faliure, throw ImageException
  catch (IOException e) {
            throw new ImageException();
        }
        if (image == null) {
            throw new ImageException();
        }
 }

 /*
  * getImage()
  * returns the image in the form of a JLabel
  * 
  * @return a JLabel with the image inside
  */
 public JLabel getImage() {
     return new JLabel(new ImageIcon(image));
 }
 
 /*
  * save(...)
  * attempts to save the image under the provided filename
  * 
  * @param filename filename to be saved to
  */
 public void save(String filename) throws ImageException {
     File file=new File(filename);
     String suffix = filename.substring(filename.lastIndexOf('.') + 1); //get suffix
     suffix = suffix.toLowerCase();
     //try writing, throw ImageException if error occurs
     try { 
         ImageIO.write(image, suffix, file);
     }
     catch (IOException e) {
         throw new ImageException();
     }
     //attempt to open image to verify picture was saved
     try {
         image=ImageIO.read(file);
     }
     catch (IOException e) {
         throw new ImageException();
     }
     if (image == null) {
         throw new ImageException();
     }
     //change pic's filename
     else
         this.filename=filename;
 }
}
