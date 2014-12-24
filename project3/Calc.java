/**
* Project 3 -- Calculator

* This program basically makes calculator for first graders to help them in the homework.
* It inputs value from the user and perform basic function like adding, subtracting, multiplication and divison,
* and provides users with the solution to their math problems.

* @author Abhishek Gupta, Anand Patel

* Anand Patel
* @recitation 001(Lorenzo Martin)
* Abhishek Gupta
* @recitation 005(Amanda day)

*

* @date October 25, 2010

*

* @C_date October 27,2010

*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.DecimalFormat; 
public class Calc implements ActionListener{ 

  double cnum1 = 0.0;  // numbers that will be converted when performing calculations
  double cnum2 = 0.0;
  String[] value; // this makes it more conventient to be put on to Jbutton
  JButton[] button;  
  String [] op;  // operation strings
  JFrame f; // frame
  JPanel text; // textfield panel
  JPanel but; // button panel
  JPanel fin; // final panel
  JTextField  tField; // textfield
  boolean defaultValue = false;  // checks whether the defualt value for num1 has changed or not
  String result = " "; 
  String st=" ";
  String num1 = " 0"; 
  String num2 = "" ;  
  String op1 = "j";// default value 
  String op2 = "j"; // default value 
  String finalResult = " " ; 
  boolean defaultNumOne = true;  
  boolean decimalPointOne = false; //checks whether or not decimal for num1 has been added
  boolean decimalPointTwo = false; // checks if decimal for num 2 has been added
  final int buttonNumber = 16; 
  public void createLabels(){
    value = new String[buttonNumber]; 
    value[0] =  "0" ; 
    value[1] =  "1";
    value[2] =  "2";
    value[3] =  "3";
    value[4] =  "4";
    value[5] =  "5";
    value[6] =  "6";
    value[7] =  "7";
    value[8] =  "8";
    value[9] =  "9";
    value[10] = "."; 
    value[11] ="/";  
    value[12] ="X";  
    value[13] =  "+";
    value[14] = "-"; 
    value[15] =  "=";
  } 
  //create JButtons
  public void createButtons(){ 
    button= new JButton[buttonNumber]; 
    button[0] = new JButton( value[0]); 
    button[1] = new JButton( value[1]); 
    button[2] = new JButton( value[2]); 
    button[3] = new JButton( value[3]); 
    button[4] = new JButton( value[4]); 
    button[5] = new JButton( value[5]); 
    button[6] = new JButton( value[6]); 
    button[7] = new JButton( value[7]); 
    button[8] = new JButton( value[8]); 
    button[9] = new JButton( value[9]); 
    button[10] = new JButton( value[10]); 
    button[11] = new JButton( value[11]); 
    button[12] = new JButton( value[12]); 
    button[13] = new JButton( value[13]); 
    button[14] = new JButton( value[14]); 
    button[15] = new JButton( value[15]); 
  } 
  //Create Panels
  public void createPanels()  {
    //text Panel
    text = new JPanel(); 
    
    text.add(tField); 
    // button Pane; 
    but = new JPanel( new GridLayout(4,4)); 
    but.setPreferredSize(new Dimension(300,200)); 
    
    for(int i=0; i<buttonNumber; i++){
      but.add(button[i]);  
      button[i].addActionListener(this); // Add an action listenr to the Number button
    }
    // final Panel
    fin = new JPanel(); 
    fin.add(text); 
    
    fin.add(but); 
    
    
  } 
  //Create Frame
  public void createFrame(){ 
    f = new JFrame("Calculator"); 
    f.setSize(300,300); 
    f.add(fin);
    f.setVisible(true); 
    f.setResizable(false);
    // f.setEditable(false); 
    // f.setDefaultCloseOperation(EXIT_ON_CLOSE);
  } 
  //Create TextField
  public void createTextField() { 
    // t.Field.setEditable(false); 
    tField = new JTextField("0");
    tField.setPreferredSize(new Dimension(300,50));
  } 
  //Implements the actionlistener
  public void actionPerformed(ActionEvent e){
    Object click=e.getSource(); 
    for ( int i = 0; i<= 15 ; i++){ 
      
      //  Label dS = value[i];
      if(click == button[i]){
        if( i<=10){ // all values less than 10 are digits
          assignmentDigit( value[i]); // assign digit
          return;
        }
        else { 
          assignmentOperator(value[i]); // the others are greater.  assign operator
          
          return;
          
        } 
        
        
      }
    }
    
  } 
  
  
  public void assignmentOperator(String s ) {
    if ( op1.equals( "j")&& s.equals("=") == false ) { // if the first operator has a default value then give it to the first operator if the operation isnt an equal
      op1 = s; 
      st= " " ; 
      defaultNumOne= false; 
    } 
    
    else if ( (op1.equals("j"))==false && num2.length() > 0 ) { // other wise  if num2 has been entered ; the second operator gets the value
      op2 = s ; 
      st= " " ; 
     // System.out.println( num1 + " " + num2 + " " + op1 + " " + op2); 
      if( op2.equals("=")==false) {
        compute(); 
        resetNormal(); // if its not the equal sign , there is a different reset method
      }
      else{ 
        compute(); 
        resetEqual(); // if the second sign is equal then everything gets reset
      } 
    }
  }
  public void assignmentDigit(String s){ 
    //  while ( num1.length()<9 && num2.length()<9){ 
    if ( s.equals(".") ){  // if decimal 
      if( op1.equals("j")&& decimalPointOne== false) { // indicates the first number is being entered 
        st = st+ s; 
        decimalPointOne = true; // the boolean gets set to true, no more decimal points can be entered for num1
      } 
      else if ( !(op1.equals("j"))&& decimalPointTwo== false) { 
        st = st+ s; 
        decimalPointTwo = true;// the boolean gets set to true, no more decimal points can be entered for num1
      } 
    }  
    
    
    
    
    for ( int i = 0 ; i < 10 ; i++) { 
      if ( value[i].equals(s)) { 
        st = st+s;
      }
    }
    if ( op1.equals("j")){  // depending on the operation sign the values get added either to num1 or num2
      num1 = st; 
      tField.setText(num1); 
    } 
    else { 
      num2 = st; 
      tField.setText(num2); 
    } 
    
    
    
// }
  }
  
  public void compute (){  // simple computation method
    cnum1 = Double.parseDouble(num1); 
    cnum2 = Double.parseDouble(num2); 
    char c  = 'c'; 
    // fm1 = new NumberFormat(); 
    double answer = 0.0; 
    String originalResult = " " ; 
    int counter = 0 ; 
    if ( op1.equals("X")){ 
      answer = cnum1*cnum2; 
      //else {}
    } 
    if ( op1.equals("/") ){ 
      if (cnum2 !=0.0){ 
        answer = cnum1/cnum2; 
      } 
      else { 
        tField.setText( " undefined" ) ; 
        //  resetEqual();
      } 
    }
    
    if ( op1.equals("+")){ 
      answer = cnum1+cnum2; 
    }
    if ( op1.equals("-")){ 
      answer = cnum1-cnum2; 
    }
    
    originalResult = Double.toString(answer); 
   // System.out.println(originalResult); 
    while( counter < 8  ) {  // I forgot the substring method existed.. so I sort of made my own :) 
      if ( counter > originalResult.length()-1) { 
        c = '0'; 
        result= result+ c; 
      } 
      else{ 
        c = originalResult.charAt(counter); 
        result= result+c;
      } 
      
      counter++; 
    }
    finalResult = result; 
    tField.setText(finalResult);
    System.out.println( num1 + " " + num2 + " " + op1 + " " + op2); 
  }
  
  
  
  
  public void resetEqual() { // everything gets reset when the equal sign is pressed
    num1 = "0" ; 
    num2 = ""; 
    st = " " ; 
    op1 = "j"; 
    op2 = "j"; 
    finalResult = " " ; 
    result = "";
    decimalPointOne = false; 
    decimalPointTwo = false; 
  } 
  public void resetNormal(){ // only certain elements get reset.
    num1 = result; 
    num2 = "" ; 
    st = " " ; 
    op1 = op2; 
    op2 = "j"; 
    
    decimalPointTwo = false; 
    result = "";
  } 
  
  
  
//f5
  public static void main (String [] args) { // main method
    Calc c = new Calc(); 
    c.createLabels();
    c.createButtons();
    c.createTextField();
    c.createPanels();
    c.createFrame();
  } 
} 