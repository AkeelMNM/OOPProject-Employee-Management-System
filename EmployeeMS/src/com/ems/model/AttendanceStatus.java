package com.ems.model;

public class AttendanceStatus {
	
	String AttStId;
	String AttId;
	String Employee;
	String Department;
	int NoWorkingDays;
	int NoLeaveDays;
	
	
	public String getEmployee() {
		return Employee;
	}

	public void setEmployee(String employee) {
		Employee = employee;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getAttStId() {
		return AttStId;
	}
	
	public void setAttStId(String attStId) {
		AttStId = attStId;
	}
	
	public String getAttId() {
		return AttId;
	}
	
	public void setAttId(String attId) {
		AttId = attId;
	}


	public int getNoWorkingDays() {
		return NoWorkingDays;
	}
	
	public void setNoWorkingDays(int noWorkingDays) {
		NoWorkingDays = noWorkingDays;
	}
	
	public int getNoLeaveDays() {
		return NoLeaveDays;
	}
	
	public void setNoLeaveDays(int noLeaveDays) {
		NoLeaveDays = noLeaveDays;
	}
	
	@Override
	public String toString() {
		return "AttendanceStatus [AttStId=" + AttStId + ", AttId=" + AttId + ", Employee=" + Employee + ", Department="
				+ Department + ", NoWorkingDays=" + NoWorkingDays + ", NoLeaveDays=" + NoLeaveDays + "]";
	}


	
	

}
