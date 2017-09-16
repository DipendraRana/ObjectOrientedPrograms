/*********************************************************************
 * purpose : Read in the following message: Hello <<name>>, We have
 * 			 your full name as <<full name>> in our system. your
 * 			 contact number is 91-xxxxxxxxxx. Please,let us know in
 * 			 case of any clarification Thank you BridgeLabz 01/01/2016.
 * 			 Use Regex to replace name, full name, Mobile#, and Date
 * 			 with proper value.
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 11 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class RegularExpression {
	
	public static Scanner scanner=new Scanner(System.in);
	
	protected String message;
	
	public RegularExpression() {
		message="Hello <<name>>, "
				+ "\nWe have your full name as <<full name>> in our system. Your contact number is 91-xxxxxxxxxx. "
				+ "\nPlease,let us know in case of any clarification."
				+ "\n\nThank you"
				+ "\n\nBridgeLabz"
				+ "\n01/01/2016.";
	}
	
	public void sendMessage() {
		Utility.regularExpression(message);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegularExpression replaceString=new RegularExpression();
		String choice;
		do {
			replaceString.sendMessage();
			System.out.println("Do you want to send Another Message(yes/no)");
			choice=scanner.next();
		}while(choice.equals("yes"));
	}

}
