/*********************************************************************
 * purpose : Inventory Factory class creation
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 19 September 2017          
 *********************************************************************/

package com.bridgelabz.utility;

import java.util.ArrayList;

import com.bridgelabz.programs.JsonInventory;

public class InventoryFactory {
	
	protected ArrayList<JsonInventory> listOfInventory;
	
	public InventoryFactory() {
		listOfInventory=new ArrayList<JsonInventory>(); 
	}
	
	public void addNewInventory() {
		JsonInventory inventory=new JsonInventory();
		listOfInventory.add(inventory);
	}
	
	public ArrayList<JsonInventory> getListOfInventory(){
		return listOfInventory;
	}
	
	public JsonInventory getThisInventory(int number) {
		return listOfInventory.get(number);
	}
}
