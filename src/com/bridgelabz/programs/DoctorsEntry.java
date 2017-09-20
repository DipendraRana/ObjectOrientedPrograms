package com.bridgelabz.programs;

import org.json.simple.JSONObject;

public class DoctorsEntry {
	
	private String doctorsName;
	
	private int id;
	
	private String specialization;
	
	private String availability;
	
	private JSONObject doctorDetails;
	
	public DoctorsEntry(String doctorsName,int id,String specialization,String availability){
		this.doctorsName=doctorsName;
		this.id=id;
		this.specialization=specialization;
		this.availability=availability;
		this.doctorDetails=new JSONObject();
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJsonObject(){
		doctorDetails.put("Name", doctorsName);
		doctorDetails.put("ID", id);
		doctorDetails.put("Specialization", specialization);
		doctorDetails.put("Shift", availability);
		return doctorDetails;
	}
}
