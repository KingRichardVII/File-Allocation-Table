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
}//end of main method