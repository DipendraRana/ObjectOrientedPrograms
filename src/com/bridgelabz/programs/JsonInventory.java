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

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub 
		System.out.println("Do you want to Do:");
		System.out.println("1.Create the JSON file");
		System.out.println("2.Read from JSON file");
		int response=scanner.nextInt();
		if(response==1) {
			System.out.println("Enter file name to create with absolute address:");
			String fileName=scanner.next();
			FileWriter fileWriter=new FileWriter(fileName);
			JSONObject inventory=Utility.jasonInventory();
			fileWriter.write(inventory.toJSONString());
			fileWriter.close();
			System.out.println("Succesfully Created the Jason file");
		}
		else {
			System.out.println("Enter file name to read with absolute address:");
			String fileName=scanner.next();
			JSONParser jasonParser=new JSONParser();
			JSONObject inventory=(JSONObject) jasonParser.parse(new FileReader(fileName));
			Utility.inventoryItemValueCalculation(inventory);
		}
	}

}
