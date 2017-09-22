/*********************************************************************
 * purpose : storing List of classes and contains logic for it main
 * 			 program
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 21 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ListOfAddress {
	
	private ArrayList<JSONObject> sortTheAddress;
	
	private JSONArray listOfAddress;
	
	private JSONArray temporaryListOfAddress;
	
	private AddressField addressFeild;
	
	public Scanner scanner=new Scanner(System.in);
	
	private String path="/home/bridgeit/Documents/fileName";
	
 	public ListOfAddress() {
		this.listOfAddress=new JSONArray();
		this.sortTheAddress=new ArrayList<JSONObject>();
		this.temporaryListOfAddress=new JSONArray();
	}
	
	@SuppressWarnings("unchecked")
	public void enterTheDetails() {
		System.out.print("Enter Your First Name:");
		String firstName=scanner.next();
		System.out.print("Enter Your Last Name:");
		String lastName=scanner.next();
		scanner.nextLine();
		System.out.print("Enter Your House No. and name of the location:");
		String address=scanner.nextLine();
		System.out.print("Enter city:");
		String city=scanner.next();
		scanner.nextLine();
		System.out.print("Enter State:");
		String state=scanner.nextLine();
		System.out.print("Enter ZipCode:");
		int zip=scanner.nextInt();
		System.out.print("Enter Your Mobile Number:");
		long mobileNo=scanner.nextLong();
		addressFeild=new AddressField(firstName,lastName,address,city,state,zip,mobileNo);
		JSONObject thisAddress=addressFeild.getJsonObject();
		listOfAddress.add(thisAddress);
	}
	
	public void simpleWrite(String fileName) throws IOException {
		path=path.replace("fileName", fileName);
		FileWriter fileWriter=new FileWriter(path);
		fileWriter.write(temporaryListOfAddress.toJSONString());
		System.out.println("SuccessFully Written To File");
		fileWriter.close();
		temporaryListOfAddress.clear();
	}
	
	@SuppressWarnings("unchecked")
	public void writeToFIle() throws IOException, ParseException {
		try {
			/*System.out.println("Do you want to get previous value from File??(yes/no)");
			String choice=scanner.next();
			choice=choice.toLowerCase();
			if(choice.equals("yes")) {*/
				System.out.println("Then Enter the Name Of File:");
				String fileNameTORead=scanner.next();
				readFromFile(fileNameTORead);
			//}
		}catch(FileNotFoundException e) {
			System.out.println("There is No such File,so moving on...");
		}
		for(int thisObject=0;thisObject<listOfAddress.size();thisObject++)
			temporaryListOfAddress.add(listOfAddress.get(thisObject));
		scanner.nextLine();
		System.out.println("Enter the file name to save the data:");
		String fileName=scanner.nextLine();
		path=path.replace("fileName", fileName);
		FileWriter fileWriter=new FileWriter(path);
		fileWriter.write(temporaryListOfAddress.toJSONString());
		System.out.println("SuccessFully Written To File");
		fileWriter.close();
		listOfAddress.clear();
		temporaryListOfAddress.clear();
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray readFromFile(String fileName) throws IOException, ParseException {
		path=path.replace("fileName", fileName);
		FileReader fileReader=new FileReader(path);
		JSONParser parser=new JSONParser();
		JSONArray sotrePreviousData=(JSONArray) parser.parse(fileReader);
		for(int thisAddress=0;thisAddress<sotrePreviousData.size();thisAddress++)
			temporaryListOfAddress.add(sotrePreviousData.get(thisAddress));
		fileReader.close();
		return sotrePreviousData;
	}

	@SuppressWarnings("unchecked")
	public <T> void editAddress(T element,int choice) throws IOException, ParseException {
		int count=0;
		System.out.println("Enter the File Name from which you want to fetch data First:");
		String fileName=scanner.next();
		try {
			readFromFile(fileName);
			for(int thisAddress=0;thisAddress<temporaryListOfAddress.size();thisAddress++) {
				if(getElementFromTemporaryListOfAddress(thisAddress).containsValue(element)){
					switch(choice) {
					case 1: System.out.println("Enter the new Address:");
							String address=scanner.nextLine();
							getElementFromTemporaryListOfAddress(thisAddress).replace("Address", address);
							break;
					case 2:	System.out.println("Enter the new city:");
							String city=scanner.next();
							getElementFromTemporaryListOfAddress(thisAddress).replace("City", city);
							break;
					case 3:	System.out.println("Enter the new State:");
							String state=scanner.nextLine();
							getElementFromTemporaryListOfAddress(thisAddress).replace("State", state);
							break;
					case 4:	System.out.println("Enter the new Zip Code:");
							int zip=scanner.nextInt();
							getElementFromTemporaryListOfAddress(thisAddress).replace("Zip", zip);
							break;
					case 5:	System.out.println("Enter the new Mobile No.:");
							long mobileNo=scanner.nextLong();
							getElementFromTemporaryListOfAddress(thisAddress).replace("Mobile No.", mobileNo);
							break;
					}
					count=1;
					System.out.println("Note:Saving the changes...");
					simpleWrite(fileName);
					break;
				}
			}
			if(count==0) 
				System.out.println("The name you entered is not present in our DataBase");
		} catch (FileNotFoundException e) {
			System.out.println("There is No such File");
		}
	}
	
	public JSONObject getElementFromListOfAddress(int index) {
		return (JSONObject) listOfAddress.get(index);
	}
	
	public JSONObject getElementFromTemporaryListOfAddress(int index) {
		return (JSONObject) temporaryListOfAddress.get(index);
	}

	public void displayAddress(String firstName) throws IOException, ParseException {
		System.out.println("Enter the File Name from which you want to fetch data First:");
		String fileName=scanner.next();
		try {
			readFromFile(fileName);
			for(int thisAddress=0;thisAddress<temporaryListOfAddress.size();thisAddress++) {
				if(getElementFromTemporaryListOfAddress(thisAddress).containsValue(firstName))
					System.out.println(getElementFromTemporaryListOfAddress(thisAddress).toJSONString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("There is No such File");
		}
		temporaryListOfAddress.clear();
	}

	@SuppressWarnings("unchecked")
	public void sortTheAddress() throws IOException, ParseException {
		System.out.println("Enter the File Name from which you want to fetch data First:");
		String fileName=scanner.next();
		try {
			readFromFile(fileName);
			for(int thisAddress=0;thisAddress<temporaryListOfAddress.size();thisAddress++)
				sortTheAddress.add((JSONObject) temporaryListOfAddress.get(thisAddress));
			temporaryListOfAddress.clear();
			Collections.sort(sortTheAddress, new Comparator<JSONObject>() {
				public static final String key="First Name";
				@Override
				public int compare(JSONObject o1, JSONObject o2) {
					// TODO Auto-generated method stub
					String name1=new String();
					String name2=new String();
					name1=(String) o1.get(key);
					name2=(String) o2.get(key);
					return name1.compareToIgnoreCase(name2);
				}
			});
			for(int thisAddress=0;thisAddress<sortTheAddress.size();thisAddress++)
				temporaryListOfAddress.add(sortTheAddress.get(thisAddress));
			System.out.println("Note:Saving the changes...");
			simpleWrite(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("There is No such File");
		}
	}
	
	public void deleteAddress(String firstName) throws IOException, ParseException {
		int count=0;
		System.out.println("Enter the File Name from which you want to fetch data First:");
		String fileName=scanner.next();
		try {
			readFromFile(fileName);
			for(int thisAddress=0;thisAddress<temporaryListOfAddress.size();thisAddress++) {
				if(getElementFromTemporaryListOfAddress(thisAddress).containsValue(firstName)) {
					temporaryListOfAddress.remove(thisAddress);
					System.out.println("Note:Saving the changes...");
					simpleWrite(fileName);
					break;
				}	
			}
			if(count==0) 
				System.out.println("The name you entered is not present in our DataBase");
		} catch (FileNotFoundException e) {
			System.out.println("There is No such File");
		}
	}
}
