/*********************************************************************
 * purpose : The software to be designed is a program that can be used
 * 			 to maintain an address book. An address book holds a
 * 			 collection of entries, each recording a person's first
 * 			 and last names, address, city, state, zip, and phone number.
 *			 It must be possible to add a new person to an address
 *			 book, to edit existing information about a person
 *			 (except the person's name), and to delete a person. It must
 *			 be possible to sort the entries in the address book
 *			 alphabetically by last name (with ties broken by first
 *			 name if necessary), or by ZIP code (with ties broken by 
 *			 name if necessary). It must be possible to print out all the entries in the address book
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 21 September 2017          
 *********************************************************************/

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
					+"\n4.Sort Address by First Name"
					+"\n5.Save all Changes to File"
					+"\n6.Delete Address");
			choose=scanner.nextInt();
			switch(choose) {
			case 1: String choice;
					do{
						listOfAddress.enterTheDetails();
						System.out.println("Do you want to enter more Adress(yes/no):");
						choice=scanner.next();
						choice=choice.toLowerCase();
					}while(choice.equals("yes"));
					System.out.println("Note:Save the changes first before moving further...");
					break;
			case 2: System.out.println("What do you want to Edit:"
					+"\n1.Address"
					+"\n2.City"
					+"\n3.State"
					+"\n4.ZipCode"
					+"\n5.Mobile No.");
					int choice1=scanner.nextInt();
					System.out.println("Enter the first name or last name from which you want to edit");
					String name=scanner.next();
					listOfAddress.editAddress(name, choice1);
					break;
			case 3: System.out.println("Enter the first name of a person whose address you want to see:");
					String firstName=scanner.next();
					listOfAddress.displayAddress(firstName);
					break;
			case 4:	System.out.println("The sorting is based on First Names");
					listOfAddress.sortTheAddress();
					break;
			case 5: listOfAddress.writeToFIle();
					break;
			case 6:	System.out.println("Enter the file name from which you want to read the data:");
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
