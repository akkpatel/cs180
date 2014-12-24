public class Tree {
 
 private Node head; //head node
 
 //creates an empty tree
 public Tree() {
  head=null;
 }
 
 //creates a tree w/ head as the head
 public Tree(Node head) {
   this.head=head;
  }
 
 //returns head
 public Node getHead() {
  return head;
 }
 
 //sets head
 public void setHead(Node Head) {
  this.head=head;
 }
 
 //sets as head if null, otherwise adds to head
 public void add(int value) {
   if(head==null)
    head=new Node(value);
   else
    head.add(new Node(value));
 }
 
 //TODO: wirte a method to sum all values
 public int addTree(Node node) {
  //write addTree(...) here\
   
   int num = node.getValue();
   
   if(node.getRight() != null){
     num += addTree(node.getRight());
   }

     if(node.getLeft() != null){
       num += addTree(node.getLeft());
     }
     
  return num;
 }
 //TODO: write a print all nodes starting a the left most and working the way up
 public void printTree(Node node) {
  //write printTree(...) here
   
   if(node.getLeft() != null){
     printTree(node.getLeft());
     
   }
   
   System.out.println(node.getValue());
   
   if(node.getRight() != null){
    printTree(node.getRight());
   }
   }
 }
