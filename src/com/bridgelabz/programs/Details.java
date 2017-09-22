/*********************************************************************
 * purpose : putting details of Doctors and Patients 
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 20 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Details {
	
	public static Scanner scanner=new Scanner(System.in); 
	
	private DoctorsList doctorsList;
	
	private PatientsList patientsList;
	
	private String decide;
	
	private ArrayList<ArrayList<JSONObject>> appointments;
	
	public Details(){
		this.doctorsList=new DoctorsList();
		this.patientsList=new PatientsList();
		this.appointments=new ArrayList<ArrayList<JSONObject>>();
	}
	
	public void initializeTwoDArray(){
		for(int noOfDoctors=0;noOfDoctors<doctorsList.getDoctorsListSize();noOfDoctors++)
			appointments.add(new ArrayList<JSONObject>(7));
		for(int noOfDoctors=0;noOfDoctors<doctorsList.getDoctorsListSize();noOfDoctors++)
			appointments.get(noOfDoctors).add(doctorsList.getDoctors(noOfDoctors));
	} 
	
	public void enterTheDoctorsDetails() throws IOException{
		do{
			doctorsList.enterDoctorsToList();
			System.out.println("Do you want to add another Doctor(yes/no):");
			decide=scanner.nextLine();
		}while(decide.equals("yes"));
	}
	
	public JSONObject enterThePatientsDetail() throws IOException{
		JSONObject temporaryObject=patientsList.addPatientsToList();
		return temporaryObject;
	}

	public <T> int searchDoctors(T element){
		JSONArray doctorList=doctorsList.getDoctorsList();
		for(int thisDoctor=0;thisDoctor<doctorsList.getDoctorsListSize();thisDoctor++){
			JSONObject doctor=(JSONObject) doctorList.get(thisDoctor);
			if(doctor.containsValue(element))
				return 1;
		}
		return 0;
	}
	
	public <T> int searchPatient(T element){
		JSONArray patientList=patientsList.getPatientsList();
		for(int thisPatient=0;thisPatient<patientsList.getPatientsListSize();thisPatient++){
			JSONObject patient=(JSONObject) patientList.get(thisPatient);
			if(patient.containsValue(element))
				return 1;
		}
		return 0;
	}

	public void appointent() throws IOException{
		int count=0;
		System.out.println("With whom the patient wants the appointment:");
		String name=scanner.nextLine();
		System.out.println("At What time patient wants the appointment:");
		String time=scanner.nextLine();
		for(int thisDoctor=0;thisDoctor<appointments.size();thisDoctor++){
			if(appointments.get(thisDoctor).get(0).containsValue(name)&&appointments.get(thisDoctor).size()<=6) {
				String doctorsTime=(String) appointments.get(thisDoctor).get(0).get("Shift");
				String[] doctorsTimeCheck=doctorsTime.split("\\s+");
				String[] patientsTimeCheck=time.split("\\s+");
				int startShiftTimeOfDoctors=Integer.parseInt(doctorsTimeCheck[0]);
				int endShiftTimeOfDoctors=Integer.parseInt(doctorsTimeCheck[3]);
				int patientsRequestTime=Integer.parseInt(patientsTimeCheck[0]);
				if((doctorsTimeCheck[1].equals("PM")&&startShiftTimeOfDoctors!=12)||(doctorsTimeCheck[1].equals("AM")&&startShiftTimeOfDoctors==12))
					startShiftTimeOfDoctors=Integer.parseInt(doctorsTimeCheck[0])+12;
				if((doctorsTimeCheck[4].equals("PM")&&endShiftTimeOfDoctors!=12)||(doctorsTimeCheck[4].equals("AM")&&endShiftTimeOfDoctors==12))
					endShiftTimeOfDoctors=Integer.parseInt(doctorsTimeCheck[3])+12;
				if((patientsTimeCheck[1].equals("PM")&&patientsRequestTime!=12)||(patientsTimeCheck[1].equals("AM")&&patientsRequestTime==12))
					patientsRequestTime=Integer.parseInt(patientsTimeCheck[0])+12;
				if(patientsRequestTime>=startShiftTimeOfDoctors&&patientsRequestTime<=endShiftTimeOfDoctors) {
					System.out.println("Appoint can be Fixed,so..");
					appointments.get(0).add(enterThePatientsDetail());
					System.out.println("Appointment sucessfull");
					count=1;
				}
			}
		}
		if(count==0)
			System.out.println("Appointment Unsucessfull");
	}
	
	public void showDoctorsPatients(String name) {
		int count=0,flag=0;
		for(int thisDoctor=0;thisDoctor<appointments.size();thisDoctor++){
			if(appointments.get(thisDoctor).get(0).containsValue(name)){
				if(appointments.get(thisDoctor).size()!=1) {
					for(int thisPatient=1;thisPatient<appointments.get(thisDoctor).size();thisPatient++)
						System.out.println(appointments.get(thisDoctor).get(thisPatient).toJSONString());
					flag=1;
				}
				if(flag==0)
					System.out.println("There is no Patients Right Now");
				count=1;
				break;
			}
		}
		if(count==-1)
			System.out.println("No Doctor with this name "+name);
	}
}
