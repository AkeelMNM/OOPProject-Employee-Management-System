package com.ems.model;

public class Manager {
	
	private String ManagerId;
	private String Employee;
	private String Department;
	private String StartingDate;
	private int LoginId;
	
	
	public int getLoginId() {
		return LoginId;
	}

	public void setLoginId(int loginId) {
		LoginId = loginId;
	}



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

	public String getManagerId() {
		return ManagerId;
	}
	
	public void setManagerId(String managerId) {
		ManagerId = managerId;
	}
	
	public String getStartingDate() {
		return StartingDate;
	}
	
	public void setStartingDate(String startingDate) {
		StartingDate = startingDate;
	}

	@Override
	public String toString() {
		return "Manager [ManagerId=" + ManagerId + ", Employee=" + Employee + ", Department=" + Department
				+ ", StartingDate=" + StartingDate + ", LoginId=" + LoginId + "]";
	}

	
	
	


}
