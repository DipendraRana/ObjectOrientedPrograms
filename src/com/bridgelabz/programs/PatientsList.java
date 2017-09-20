package com.bridgelabz.programs;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PatientsList {
	
	JSONArray patientsList;
	
	public Scanner scanner=new Scanner(System.in);
	
	public String path="E:\\myWorkSpace\\fileName";
	
	public PatientsList() {
		this.patientsList=new JSONArray();
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject addPatientsToList(){
		System.out.println("Enter the name of Patient:");
		String name=scanner.nextLine();
		System.out.println("Enter the Dr."+name+" ID:");
		int id=scanner.nextInt();
		System.out.println("Enter the "+name+" Mobile Numner:");
		int mobileNo=scanner.nextInt();
		System.out.println("Enter the Dr."+name+" Age:");
		int age=scanner.nextInt();
		PatientsEntry patientsEntry=new PatientsEntry(name,id,mobileNo,age);
		JSONObject patient=patientsEntry.getJsonObject();
		patientsList.add(patient);
		return patient;
	}

	public JSONArray getPatientsList(){
		return patientsList;
	}

	public int getPatientsListSize(){
		return patientsList.size();
	}
	
	public JSONObject getPatient(int index){
		return (JSONObject) patientsList.get(index);
	}
}
