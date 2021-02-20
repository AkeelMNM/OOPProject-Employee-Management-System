package com.ems.model;

public class Department {

	private String DepID;
	private String Name;
	private String Location;
	
	
	public String getDepID() {
		return DepID;
	}
	
	public void setDepID(String depID) {
		DepID = depID;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getLocation() {
		return Location;
	}
	
	public void setLocation(String location) {
		Location = location;
	}
	
	@Override
	public String toString() {
		return "Department [DepID=" + DepID + ", Name=" + Name + ", Location=" + Location + "]";
	}
}
