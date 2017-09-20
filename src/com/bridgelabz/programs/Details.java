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
		this.initializeTwoDArray();
	}
	
	public void initializeTwoDArray(){
		for(int noOfDoctors=0;noOfDoctors<doctorsList.getDoctorsListSize();noOfDoctors++)
			appointments.addAll(new ArrayList<ArrayList<JSONObject>>(6));
		for(int noOfDoctors=0;noOfDoctors<doctorsList.getDoctorsListSize();noOfDoctors++)
			appointments.get(noOfDoctors).add(doctorsList.getDoctors(noOfDoctors));
	} 
	
	public void enterTheDoctorsDetails() throws IOException{
		do{
			doctorsList.enterDoctorsToList();
			System.out.println("Do you want to add another Doctor(yes/no):");
			decide=scanner.next();
		}while(decide.equals("yes"));
	}
	
	public JSONObject  enterThePatientsDetail() throws IOException{
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
		System.out.println("With whom the patient wants the appointment and at What time:");
		String name=scanner.nextLine();
		System.out.println("At What time patient wants the appointment:");
		String time=scanner.nextLine();
		for(int thisDoctor=0;thisDoctor<appointments.size();thisDoctor++){
			if(appointments.get(0).contains(name)&&appointments.get(0).size()<=6&&appointments.get(0).contains(time)){
				System.out.println("Appoint can be Fixed,so..");
				appointments.get(0).add(enterThePatientsDetail());
			}
				
		}
	}
}
