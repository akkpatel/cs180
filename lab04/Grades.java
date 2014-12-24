/* 
 * Lab04.java
 * Lab04
 * Anand Patel
 * Section 005
 */

import java.util.*;
import javax.swing.*;
public class Grades {
 public static void main(String []args) {
   
  
   Scanner s = new Scanner(System.in);
  
   System.out.format("Enter Projects total ");
   float projectS=0;
   projectS = s.nextFloat();
   System.out.format("Enter Lab total");
   float labtotalS=0;
   labtotalS = s.nextFloat();
   System.out.format("Enter Midterm #1 Score ");
   float midterm1S=0;
   midterm1S = s.nextFloat();
   System.out.format("Enter Midterm #2 Score ");
   float midterm2S=0;
   midterm2S = s.nextFloat();
   System.out.format("Enter final exam Score ");
   float finalexamS=0;
   finalexamS = s.nextFloat();
   
   float finalS = 0;
   finalS = projectS + labtotalS + midterm1S + midterm2S + finalexamS; 
   float wholetotalS = 0;
   wholetotalS = (projectS * 25/100) + (labtotalS * 15/100) + (midterm1S * 15/100) + (midterm2S * 15/100) + (finalexamS * 30/100);
   int letterGrade = ((int)(wholetotalS/90)) + ((int)(wholetotalS/80)) + ((int)(wholetotalS/70)) + 2*((int)(wholetotalS/60));
   System.out.format("project total %5.2f\n", projectS);
   System.out.format("Lab total %5.2f\n", labtotalS);
   System.out.format("Midterm #1 %5.2f\n", midterm1S);
   System.out.format("Midterm #2 %5.2f\n", midterm2S);
   System.out.format("Final Exam %5.2f\n", finalexamS);
   System.out.format("Course total %5.2f\n", finalS);
   System.out.format(" %c", letterGrade); }
}




  