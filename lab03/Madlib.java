/* 
 * Lab03.java
 * Lab03
 * Anand Patel
 * Section 005
 * In this lab you will take user input of strings to create a madlib
 */
 
import java.util.*;
import javax.swing.*;
public class Madlib {
 public static void main(String []args) {
    //set up variable here

    //create a new scanner
  Scanner s = new Scanner(System.in);
  
    //prompt the user for 10 nouns, 2 verbs, 4 adj, 1 name. 
  System.out.print("enter First noun ");
  String noun1=s.nextLine(); 
  System.out.print("enter Second noun ");
  String noun2=s.nextLine();
  System.out.print("enter Third noun ");
  String noun3=s.nextLine();
  System.out.print("enter First verb ");
  String verb1=s.nextLine();
  System.out.print("enter Second verb ");
  String verb2=s.nextLine();
  System.out.print("enter First adj ");
  String adj1=s.nextLine();
  System.out.print("enter Second adj ");
  String adj2=s.nextLine();
  System.out.print("enter Third adj ");
  String adj3=s.nextLine();
  System.out.print("enter name ");
  String name1=s.nextLine();
  
  System.out.println("purdue\n\nPurdue University is a very " + adj1 + " educational " + noun1 +". At Purdue, all the students are extremely " + adj2 +", and like to " + verb1 + ", " + verb2 +", and study. Purdue was founded in 1869 and named after benefactor " + name1 + ". The University is one of the " + noun2 + "'s leading research institutions with a reputation for excellent and affordable " + noun3 + ". And we have a really big drum. Obviously we're " + adj3 + ".\n\n");
   
  String noun4 = JOptionPane.showInputDialog("Enter First Noun: "); 
  String noun5 = JOptionPane.showInputDialog("Enter Second Noun: ");
  String noun6 = JOptionPane.showInputDialog("Enter Third Noun: ");
  String noun7 = JOptionPane.showInputDialog("Enter Fourth Noun: ");
  String noun8 = JOptionPane.showInputDialog("Enter Fifth Noun: ");
  String noun9 = JOptionPane.showInputDialog("Enter Sixth Noun: ");
  String noun10 = JOptionPane.showInputDialog("Enter Seventh Noun: ");
  String adj4 = JOptionPane.showInputDialog("Enter First Adj: ");
  
  JOptionPane.showMessageDialog(null,"Computer Science is Awesome!\n\nComputer Science is the very best discipline in the " + noun4 + ". Computer scientists get to create " + adj4 + " software to solve age-old problems such as how to calculate the " + noun5 + " of a " + noun6 + " and how to efficiently search a " + noun7 + " for a specific " + noun8 + ". Computer scientists are always on the cutting " + noun9 + " of technology, and enjoy speaking in binary in order to impress the nearby " + noun10 + ".");
                       
   //combine the madlib string and print it out
  
    //Lucky Number
    Random generator = new Random();
    int r = generator.nextInt(91);
    r += 10;
    System.out.println("Your lucky number is " + r + ".");
  }
}
