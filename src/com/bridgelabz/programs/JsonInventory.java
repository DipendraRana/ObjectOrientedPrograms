/*********************************************************************
 * purpose : Create a JSON file having Inventory Details for 
 * 			 Rice, Pulses and Wheats with properties name, weight, 
 * 			 price per kg. 
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 14 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class JsonInventory {
	
	public static Scanner scanner=new Scanner(System.in);
	
	public JSONObject inventory;
	
	public JsonInventory() {
		inventory=new JSONObject();
	}
	
	public void writeToFile(String fileName) throws IOException {
		FileWriter fileWriter=new FileWriter(fileName);
		fileWriter.write(inventory.toJSONString());
		fileWriter.close();
	}
	
	public void addNewValuesToInventory() {
		inventory=Utility.jasonInventory();
	}
	
	public void readFromInventory(String fileName) throws FileNotFoundException, IOException, ParseException {
		JSONParser jasonParser=new JSONParser();
		inventory=(JSONObject) jasonParser.parse(new FileReader(fileName));
	}
	
	public void findValueOfSpecificItem() {
		Utility.inventoryItemValueCalculation(inventory);
	}
	
	public void printCompleteFile() {
		System.out.println(inventory.toJSONString());
	}

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub 
		String choice;
		JsonInventory inventory=new JsonInventory();
		do {
			System.out.println("Do you want to Do:");
			System.out.println("1.Create the JSON file");
			System.out.println("2.Read from JSON file");
			int response=scanner.nextInt();
			if(response==1) {
				inventory.addNewValuesToInventory();
				System.out.println("Enter file name to create with absolute address:");
				String fileName=scanner.next();
				inventory.writeToFile(fileName);
				System.out.println("Succesfully Created the Jason file");
			}
			else {
				
				try {
					System.out.println("Enter file name to read with absolute address:");
					String fileName=scanner.next();
					scanner.nextLine();
					inventory.readFromInventory(fileName);
					inventory.findValueOfSpecificItem();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("There is no such File");
				}
			}
			System.out.println("Do you want to continue(yes/no):");
			choice=scanner.next();
			choice=choice.toLowerCase();
		}while(choice.equals("yes"));
		
	}

}
