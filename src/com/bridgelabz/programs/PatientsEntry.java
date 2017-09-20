package com.bridgelabz.programs;

import org.json.simple.JSONObject;

public class PatientsEntry {
	
	private String patientsName;
	
	private int id;
	
	private int mobileNo;
	
	private int age;
	
	private JSONObject patient;
	
	public PatientsEntry(String patientsName,int id,int mobileNo,int age) {
		this.patientsName=patientsName;
		this.id=id;
		this.mobileNo=mobileNo;
		this.age=age;
		this.patient=new JSONObject();
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJsonObject(){
		patient.put("Name", patientsName);
		patient.put("ID", id);
		patient.put("Mobile No.", mobileNo);
		patient.put("Age", age);
		return patient;
	}
		
}
