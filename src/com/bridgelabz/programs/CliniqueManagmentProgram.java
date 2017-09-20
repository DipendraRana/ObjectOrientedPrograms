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
		do{
			System.out.println("What do you want to do:");
			System.out.println("1.Search Doctors");
			System.out.println("2.Search Patients");
			System.out.println("3.Take Appointment");
			int choice=scanner.nextInt();
			switch(choice){
			case 1:	System.out.println("1.Search Doctors by:"
					+"\n1.Name"
					+"\n2.ID"
					+"\n3.Specializtion"
					+"\n4.Availability");
					choice=scanner.nextInt();
					switch(choice){
					case 1: System.out.println("Enter The Name of Doctor:");
							String name=scanner.nextLine();
							if(details.searchDoctors(name)!=0)
								System.out.println("Found The "+name);
							else
								System.out.println("No Doctor with this name is present");
							break;
					case 2:	System.out.println("Enter The ID of the Doctor:");
							Long id=scanner.nextLong();
							if(details.searchDoctors(id)!=0)
								System.out.println("Found The Doctor with this"+id);
							else
								System.out.println("No Doctor with this "+id+" is present");
							break;
					case 3: System.out.println("Enter The Specializtion of the Doctor:");
							String specializtion=scanner.next();
							if(details.searchDoctors(specializtion)!=0)
								System.out.println("Found The Doctor with this"+specializtion);
							else
								System.out.println("No Doctor with this "+specializtion+" is present");
							break;
					case 4: System.out.println("Enter The shift of the Doctor:");
							String availability=scanner.next();
							if(details.searchDoctors(availability)!=0)
								System.out.println("Doctor is available in this shift");
							else
								System.out.println("No Doctor in this shift is available");
							break;
					}
					break;
			case 2:	System.out.println("2.Search Patients by:"
					+"\n1.Name"
					+"\n2.ID"
					+"\n3.Mobile No");
					choice=scanner.nextInt();
					switch(choice){
					case 1: System.out.println("Enter The Name of Paitent:");
							String name=scanner.nextLine();
							if(details.searchPatient(name)!=0)
								System.out.println("Found The "+name);
							else
								System.out.println("No paitents with this name is present");
							break;
					case 2:	System.out.println("Enter The ID of the paitent:");
							Long id=scanner.nextLong();
							if(details.searchPatient(id)!=0)
								System.out.println("Found The paitent with this"+id);
							else
								System.out.println("No paitent with this "+id+" is present");
							break;
					case 3: System.out.println("Enter The Mobile No. of the Patient:");
							Long mobileNo=scanner.nextLong();
							if(details.searchPatient(mobileNo)!=0)
								System.out.println("Found The Patient with this"+mobileNo);
							else
								System.out.println("No Patient with this "+mobileNo+" is present");
							break;
					}
					break;
			case 3: details.appointent();
					break;
			}
			System.out.println("Do you want to go again(yes/no):");
			choose=scanner.next();
		}while(choose.equals("yes"));
	}

}
