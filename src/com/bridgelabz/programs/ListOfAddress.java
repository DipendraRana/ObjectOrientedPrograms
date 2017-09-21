package com.bridgelabz.programs;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ListOfAddress {
	
	private ArrayList<String> names;
	
	private JSONArray listOfAddress;
	
	private AddressFeild addressFeild;
	
	public Scanner scanner=new Scanner(System.in);
	
	private String path="/home/bridgeit/Documents/fileName";
	
 	public ListOfAddress() {
		this.listOfAddress=new JSONArray();
		this.names=new ArrayList<String>();
	}
	
	@SuppressWarnings("unchecked")
	public void enterTheDetails() {
		System.out.print("Enter Your First Name:");
		String firstName=scanner.next();
		System.out.print("Enter Your Last Name:");
		String lastName=scanner.next();
		System.out.print("Enter Your House No. and name of the location:");
		String address=scanner.nextLine();
		System.out.print("Enter city:");
		String city=scanner.next();
		System.out.print("Enter State:");
		String state=scanner.nextLine();
		System.out.print("Enter ZipCode:");
		int zip=scanner.nextInt();
		System.out.print("Enter Your Mobile Number:");
		long mobileNo=scanner.nextLong();
		addressFeild=new AddressFeild(firstName,lastName,address,city,state,zip,mobileNo);
		JSONObject thisAddress=addressFeild.getJsonObject();
		listOfAddress.add(thisAddress);
		names.add(firstName);
	}

	@SuppressWarnings("unchecked")
	public void writeToFIle(String fileName) throws IOException, ParseException {
		JSONArray sotrePreviousData=readFromFile(fileName);
		System.out.println("Do you want to get previous value from File(yes/no)");
		String choice=scanner.next();
		choice=choice.toLowerCase();
		if(!sotrePreviousData.isEmpty()&&choice.equals("yes")) {
			for(int thisAddress=0;thisAddress<sotrePreviousData.size();thisAddress++)
				listOfAddress.add(sotrePreviousData.get(thisAddress));
		}
		path=path.replace("fileName", fileName);
		FileWriter fileWriter=new FileWriter(path);
		fileWriter.write(listOfAddress.toJSONString());
		fileWriter.close();
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray readFromFile(String fileName) throws IOException, ParseException {
		path=path.replace("fileName", fileName);
		FileReader fileReader=new FileReader(path);
		JSONParser parser=new JSONParser();
		JSONArray sotrePreviousData=(JSONArray) parser.parse(fileReader);
		for(int thisAddress=0;thisAddress<sotrePreviousData.size();thisAddress++)
			listOfAddress.add(sotrePreviousData.get(thisAddress));
		return sotrePreviousData;
	}

	@SuppressWarnings("unchecked")
	public <T> void editAddress(T element,int choice) {
		for(int thisAddress=0;thisAddress<listOfAddress.size();thisAddress++) {
			if(getElementFromListOfAddress(thisAddress).containsValue(element)){
				System.out.println("Enter the new value:");
				switch(choice) {
				case 1: String address=scanner.nextLine();
						getElementFromListOfAddress(thisAddress).replace("Address", address);
						break;
				case 2:	String city=scanner.next();
						getElementFromListOfAddress(thisAddress).replace("City", city);
						break;
				case 3:	String state=scanner.nextLine();
						getElementFromListOfAddress(thisAddress).replace("State", state);
						break;
				case 4:	int zip=scanner.nextInt();
						getElementFromListOfAddress(thisAddress).replace("Zip", zip);
						break;
				case 5:	long mobileNo=scanner.nextLong();
						getElementFromListOfAddress(thisAddress).replace("Mobile No.", mobileNo);
						break;
				}	
			}
		}
	}
	
	public JSONObject getElementFromListOfAddress(int index) {
		return (JSONObject) listOfAddress.get(index);
	}

	public void displayAddress(String firstName) {
		for(int thisAddress=0;thisAddress<listOfAddress.size();thisAddress++) {
			if(getElementFromListOfAddress(thisAddress).containsKey(firstName))
				System.out.println(getElementFromListOfAddress(thisAddress).toJSONString());
		}
	}

	public void namesFromFileToArray(String fileName) throws IOException, ParseException {
		for(int thisAddress=0;thisAddress<listOfAddress.size();thisAddress++)
			names.add((String) getElementFromListOfAddress(thisAddress).get("First Name"));
	}
	
	public void sortTheAddress() {
		names.sort(null);
		for(int i=0;i<names.size();i++) {
			for(int j=0;j<listOfAddress.size();j++) {
				if(getElementFromListOfAddress(j).containsKey(names.get(i))) 
					System.out.println(getElementFromListOfAddress(j).toJSONString());
			}
		}
	}

	public void deleteAddress(String firstName) {
		for(int thisAddress=0;thisAddress<listOfAddress.size();thisAddress++) {
			if(getElementFromListOfAddress(thisAddress).containsValue(firstName))
				listOfAddress.remove(thisAddress);
		}
	}
}
