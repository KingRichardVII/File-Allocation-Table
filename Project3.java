// Richard Phan
// COMP 322 Fall 2025
// Project 3

import java.util.Scanner;

public class Project3 {
   //Global Variables
   private static Scanner input = new Scanner(System.in);
   private static Block[] table;
   private static int headIndex = -1;
   
   //Main Method
   public static void main(String[] args){
      //Enter table size
      System.out.println("Enter the table size: ");
      if (!input.hasNextInt()){ //data type check
         System.out.println("Invalid input.");
         System.exit(0);
      }
      int tableSize = input.nextInt();
      input.nextLine(); //input flush
      if (tableSize <= 0){//valid data check
         System.out.println("Invalid table size.");
         System.exit(0);
      }
      //Create file allocation table
      table = new Block[tableSize];
      for (int i = 0; i < table.length; i++){
         table[i] = new Block();
      }
      //Main loop
      int option = 0; // any value other than 4
         while (option != 4) {
         System.out.println();
         System.out.println("1) Print the table and the file");
         System.out.println("2) Add a block to the file");
         System.out.println("3) Remove a block from the file");
         System.out.println("4) Quit the program");
         System.out.println("Enter selection: ");
         if (input.hasNextInt()) {
            option = input.nextInt();
         } else {
            option = 0; // any value other than 1,2,3,4
         }
         input.nextLine();//input flush
         switch (option) {
            case 1:
               printTableAndFile();
               break;
            case 2:
               addBlock();
               break;
            case 3:
               removeBlock();
               break;
            case 4: 
               System.out.println("Goodbye!");
               break;
            default:
               System.out.println("Invalid option, try again.");
          }// end of switch statement
      } // end of main loop
}//end of main method

//Print table and File
public static void printTableAndFile(){
   //print the table view header row
   System.out.println("Table View: ");
   System.out.println("Index\tData\tNext");
   //Print every block from the table as a row
   for (int i = 0; i < table.length; i++) {
      System.out.println(i + "\t" + table[i].getData() + "\t" + table[i].getNextIndex());
      }
}// end of Print Table and File

//add block
public static void addBlock() {
   //Enter the new block index
   System.out.println("Enter an index for the block to add: ");
   if (!input.hasNextInt()){//Data type check
      System.out.println("Invalid input");
      input.nextLine(); //input flush
      return;
   }
   int newIndex = input.nextInt();
   input.nextLine(); //input flushing
   if (newIndex < 0 || newIndex >= table.length){//valid data check
      System.out.println("Invalid block index");
      return; 
   }
   //enter data for new block
   System.out.println("Enter an unsigned integer of data: ");
   if (!input.hasNextInt()) {
      System.out.println("Invalid input");
      input.nextLine();
      return;
   }
   int newData = input.nextIn();
   input.nextLine(); //input flush
   if (newData < 0) { //valid data check
      System.out.println("Invalid Data");
      return;
   }
   //check value of head index
   if (headIndex == -1) {
      //assign new block to head of file
      headIndex = newIndex;
      table[newIndex].setData(newData);
      System.out.println("Added first block at index " + newIndex + ".");
   }else {
      //iterate thru file and detect if new index is in use or not
      //NOTE - new index will always be in use if table is full
      int currentIndex = headIndex;
      while (currentIndex != newIndex) {
         //the new index is not in use if the end of the file is reached
         if (table[currentIndex].getNextIndex() == -1) {
            //assign new block to end of file 
            table[currentIndex].setNextIndex(newIndex);
            table[newIndex].setData(newData);
            System.out.println("Added new block at index " + newIndex + ".");
            return;
         }
         currentIndex = table[currentIndex].getNextIndex();
      }
      System.out.println("Duplicate block index detected");
   }
}// end of add block

//remove block
public static void removeBlock() {
   System.out.print.ln("REMOVE BLOCK"); //FIXME: placeholder, remove later
}// end of remove
}

      