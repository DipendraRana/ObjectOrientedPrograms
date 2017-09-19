/*********************************************************************
 * purpose : Extend the above program to Create InventoryManager to
 * 			 manage the Inventory. The Inventory Manager will use
 * 			 InventoryFactory to create Inventory Object from JSON.
 * 			 The InventoryManager will call each Inventory Object in
 * 			 its list to calculate the Inventory Price and then call
 * 			 the Inventory Object to return the JSON String. The main
 * 			 program will be with InventoryManager
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 19 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.InventoryFactory;

public class InventoryManager {
	
	public static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InventoryFactory createInventory=new InventoryFactory();
		System.out.println("How Many Inventory You want To create:");
		int noOfInventory=scanner.nextInt();
		for(int inventryNo=0;inventryNo<noOfInventory;inventryNo++) {
			createInventory.addNewInventory();
		}
		System.out.println("Enter which inventory you want to see:");
		int inventoryNo=scanner.nextInt();
		createInventory.getThisInventory(inventoryNo).printCompleteFile();
		
	}

}
