/**************************************************************************************
 * purpose : This programme is used to manage a list of Doctors associated with the
 * 			 Clinique. This also manages the list of patients who use the clinique.
 * 			 It manages Doctors by Name, Id, Specialization and Availability
 * 			 (AM,  PM or both). It manages Patients by Name, ID, Mobile Number and Age.
 * 			 The Program allows users to search Doctor by name, id, Specialization
 * 			 or Availability. Also the programs allows users to search patient by name,
 * 			 mobile number or id. The programs allows patients to take appointment with
 * 			 the doctor. A doctor at  any availability time can see only 5 patients.
 * 			 If exceeded the user can take appointment for patient at different date or
 * 			 availability time. Print the Doctor Patient Report. Also show which
 * 			 Specialization is popular in the Clinique as well as which Doctor is popular
 *           
 * @author Dipendra Rana
 * @version 2.0
 * @since 20 September 2017          
 **************************************************************************************/

package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Scanner;

public class CliniqueManagmentProgram {
	
	public static Scanner scanner=new Scanner(System.in); 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Details details=new Details();
		String choose;
		System.out.println("Enter Doctors Details");
		details.enterTheDoctorsDetails();
		details.initializeTwoDArray();
		do{
			System.out.println("What do you want to do:");
			System.out.println("1.Search Doctors");
			System.out.println("2.Search Patients");
			System.out.println("3.Take Appointment");
			System.out.println("4.Look At Doctors Patients");
			int choice=Integer.parseInt(scanner.nextLine());
			switch(choice){
			case 1:	System.out.println("Search Doctors by:"
					+"\n1.Name"
					+"\n2.ID"
					+"\n3.Specializtion"
					+"\n4.Availability");
					choice=Integer.parseInt(scanner.nextLine());
					switch(choice){
					case 1: System.out.println("Enter The Name of Doctor:");
							String name=scanner.nextLine();
							if(details.searchDoctors(name)!=0)
								System.out.println("Found The "+name);
							else
								System.out.println("No Doctor with this name is present");
							break;
					case 2:	System.out.println("Enter The ID of the Doctor:");
							Integer id=Integer.parseInt(scanner.nextLine());
							if(details.searchDoctors(id)!=0)
								System.out.println("Found The Doctor with this ID "+id);
							else
								System.out.println("No Doctor with this ID "+id+" is present");
							break;
					case 3: System.out.println("Enter The Specializtion of the Doctor:");
							String specializtion=scanner.nextLine();
							if(details.searchDoctors(specializtion)!=0)
								System.out.println("Found The Doctor with this Specializtion "+specializtion);
							else
								System.out.println("No Doctor with this Specializtion "+specializtion+" is present");
							break;
					case 4: System.out.println("Enter The shift of the Doctor:");
							String availability=scanner.nextLine();
							if(details.searchDoctors(availability)!=0)
								System.out.println("Doctor is available in this shift");
							else
								System.out.println("No Doctor in this shift is available");
							break;
					}
					break;
			case 2:	System.out.println("Search Patients by:"
					+"\n1.Name"
					+"\n2.ID"
					+"\n3.Mobile No");
					choice=Integer.parseInt(scanner.nextLine());
					switch(choice){
					case 1: System.out.println("Enter The Name of Paitent:");
							String name=scanner.nextLine();
							if(details.searchPatient(name)!=0)
								System.out.println("Found The "+name);
							else
								System.out.println("No paitents with this name is present");
							break;
					case 2:	System.out.println("Enter The ID of the paitent:");
							int id=Integer.parseInt(scanner.nextLine());
							if(details.searchPatient(id)!=0)
								System.out.println("Found The paitent with this ID "+id);
							else
								System.out.println("No paitent with this ID "+id+" is present");
							break;
					case 3: System.out.println("Enter The Mobile No. of the Patient:");
							long mobileNo=Integer.parseInt(scanner.nextLine());
							if(details.searchPatient(mobileNo)!=0)
								System.out.println("Found The Patient with this Mobile No. "+mobileNo);
							else
								System.out.println("No Patient with this Mobile No. "+mobileNo+" is present");
							break;
					}
					break;
			case 3: details.appointent();
					break;
			case 4:	System.out.println("Enter the name of the Doctor:");
					String name=scanner.nextLine();
					details.showDoctorsPatients(name);
					break;
			}
			System.out.println("Do you want to go again(yes/no):");
			choose=scanner.nextLine();
		}while(choose.equals("yes"));
	}

}
