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

import com.bridgelabz.utility.Utility;

public class RegularExpression {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message="Hello <<name>>, We have your full name as <<full name>> in our system."
				+ "\nYour contact number is 91-xxxxxxxxxx."
				+ "\nPlease,let us know in case of any clarification"
				+ "\nThank you BridgeLabz 01/01/2016.";
		Utility.regularExpression(message);
	}

}
