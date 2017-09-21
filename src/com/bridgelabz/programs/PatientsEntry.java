/*********************************************************************
 * purpose : Patients Entry Class 
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 20 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import org.json.simple.JSONObject;

public class PatientsEntry {
	
	private String patientsName;
	
	private int id;
	
	private long mobileNo;
	
	private int age;
	
	private JSONObject patient;
	
	public PatientsEntry(String patientsName,int id,long mobileNo,int age) {
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
