/*********************************************************************
 * purpose : Class for Address Field
 *           
 * @author Dipendra Rana
 * @version 1.0
 * @since 21 September 2017          
 *********************************************************************/

package com.bridgelabz.programs;

import org.json.simple.JSONObject;

public class AddressField {

	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private int zip;
	
	private long mobileNo;
	
	public AddressField(String firstName,String lastName,String address,String city,String state,int zip,long mobileNo) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.mobileNo=mobileNo;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getJsonObject() {
		JSONObject entry=new JSONObject();
		entry.put("First Name", firstName);
		entry.put("Last Name", lastName);
		entry.put("Address", address);
		entry.put("City", city);
		entry.put("State", state);
		entry.put("Zip", zip);
		entry.put("Mobile No.", mobileNo);
		return entry;
	}

}
