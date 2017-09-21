package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class AddressBookProblem {
	
	public static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		int choose;
		String answer;
		ListOfAddress listOfAddress=new ListOfAddress();
		do {
			System.out.println("What do you want to do:"
					+"\n1.Add Adresses"
					+"\n2.Edit Data"
					+"\n3.View Address"
					+"\n4.Sort Address"
					+"\n5.Save all Changes to File"
					+"\n6.Read From File"
					+"\n7.Delete Address");
			choose=scanner.nextInt();
			switch(choose) {
			case 1: listOfAddress.enterTheDetails();
					break;
			case 2: System.out.println("What do you want to Edit:"
					+"\n1.Address"
					+"\n2.City"
					+"\n3.State"
					+"\n4.ZipCode"
					+"\n5.Mobile No.");
					int choice=scanner.nextInt();
					System.out.println("Enter the first name or last name from which you to edit");
					String name=scanner.next();
					listOfAddress.editAddress(name, choice);
					break;
			case 3: System.out.println("Enter the first name of a person whose address you wan to see:");
					String firstName=scanner.next();
					listOfAddress.displayAddress(firstName);
					break;
			case 4:	System.out.println("Enter the file name from which you want to read the data:");
					String fileNameToReadForSort=scanner.nextLine();
					listOfAddress.namesFromFileToArray(fileNameToReadForSort);
					listOfAddress.sortTheAddress();
					break;
			case 5:	System.out.println("Enter the file name to save the data:");
					String fileName=scanner.nextLine();
					listOfAddress.writeToFIle(fileName);
					break;
			case 6:	System.out.println("Enter the file name from which you want to read the data:");
					String fileNameToRead=scanner.nextLine();
					listOfAddress.readFromFile(fileNameToRead);
					break;
			case 7:	System.out.println("Enter the file name from which you want to read the data:");
					String fileNameToReadToDelete=scanner.nextLine();
					listOfAddress.readFromFile(fileNameToReadToDelete);
					System.out.println("Enter the first name of whom you want to delete the data:");
					String firstNameForDelete=scanner.next();
					listOfAddress.deleteAddress(firstNameForDelete);
			}
			System.out.println("Do you want to continue(yes/no):");
			answer=scanner.next();
			answer=answer.toLowerCase();
		}while(answer.equals("yes"));
	}

}
