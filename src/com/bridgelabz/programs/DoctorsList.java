package com.bridgelabz.programs;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DoctorsList {
	
	private JSONArray doctorsList;
	
	public Scanner scanner=new Scanner(System.in);
	
	public String path="E:\\myWorkSpace\\fileName"; 
	
	public DoctorsList(){
		this.doctorsList=new JSONArray();
	}
	
	@SuppressWarnings("unchecked")
	public void enterDoctorsToList() {
		System.out.println("Enter the name of Doctor:");
		String name=scanner.nextLine();
		System.out.println("Enter the Dr."+name+" ID:");
		int id=scanner.nextInt();
		System.out.println("Enter the Dr."+name+" Specialization:");
		String specialization=scanner.nextLine();
		System.out.println("Enter the Dr."+name+" Shift:");
		String availability=scanner.nextLine();
		DoctorsEntry doctorEntry=new DoctorsEntry(name,id,specialization,availability);
		JSONObject doctor=doctorEntry.getJsonObject();
		doctorsList.add(doctor);
	}
	
	/*public void writeTheListToFile(String fileName) throws IOException{
		path=path.replace("fileName", fileName);
		FileWriter fileWriter=new FileWriter(path);
		fileWriter.write(doctorsList.toJSONString());
		fileWriter.close();
	}*/

	public JSONArray getDoctorsList(){
		return doctorsList;
	}

	public int getDoctorsListSize(){
		return doctorsList.size();
	}
	
	public JSONObject getDoctors(int index){
		return (JSONObject) doctorsList.get(index);
	}
}
