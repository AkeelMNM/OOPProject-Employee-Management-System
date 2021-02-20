package com.ems.model;

public class Leave {

	private String LeaveId;
	private String Employee;
	private String Department;
	private String Starting_Date;
	private String End_Date;
	private String L_Status;
	private String description;
	
	

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

	public String getLeaveId() {
		return LeaveId;
	}
	
	public void setLeaveId(String leaveId) {
		LeaveId = leaveId;
	}
	
	public String getStarting_Date() {
		return Starting_Date;
	}
	
	public void setStarting_Date(String starting_Date) {
		Starting_Date = starting_Date;
	}
	
	public String getEnd_Date() {
		return End_Date;
	}
	
	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}
	
	public String getL_Status() {
		return L_Status;
	}
	
	public void setL_Status(String l_Status) {
		L_Status = l_Status;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Leave [LeaveId=" + LeaveId + ", Employee=" + Employee + ", Department=" + Department
				+ ", Starting_Date=" + Starting_Date + ", End_Date=" + End_Date + ", L_Status=" + L_Status
				+ ", description=" + description + "]";
	}
	

	
	

}
