package com.ems.model;

public class Attendance {
	
	private String AttendanceID;
	private String Employee;
	private String Department;
	private String Today_Date;
	private String Start_Time;
	private String End_Time;
	private String Status;
	
	
	public String getToday_Date() {
		return Today_Date;
	}

	public void setToday_Date(String today_Date) {
		Today_Date = today_Date;
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

	public String getAttendanceID() {
		return AttendanceID;
	}
	
	public void setAttendanceID(String attendanceID) {
		AttendanceID = attendanceID;
	}
	
	public String getStart_Time() {
		return Start_Time;
	}
	
	public void setStart_Time(String start_Time) {
		Start_Time = start_Time;
	}
	
	public String getEnd_Time() {
		return End_Time;
	}
	
	public void setEnd_Time(String end_Time) {
		End_Time = end_Time;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Attendance [AttendanceID=" + AttendanceID + ", Employee=" + Employee + ", Department=" + Department
				+ ", Today_Date=" + Today_Date + ", Start_Time=" + Start_Time + ", End_Time=" + End_Time + ", Status="
				+ Status + "]";
	}


}
