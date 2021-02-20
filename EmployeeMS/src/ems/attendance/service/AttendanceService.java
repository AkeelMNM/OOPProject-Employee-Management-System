package ems.attendance.service;

import java.util.ArrayList;

import com.ems.model.Attendance;
import com.ems.model.AttendanceStatus;
import com.ems.model.Employee;

/**
 * 
 * 
 * @author Akeel M.N.M
 * IT NO:IT19153414
 *
 */

public interface AttendanceService {
	
	
	//Add Attendance for Attendance table
	public void addAttendance(Attendance attendance);
	
	//Get Employees that Don't have Attendance form Employee table
	public ArrayList<Employee> getEmployeeListThatDontHaveAttendance();
	
	//Get Attendance ID in Attendance table
	public String getAttendanceID(String EmployeeID);
	
	//Get particular Attendance form Attendance table
	public ArrayList<Attendance> getAttendanceByID(String attendanceID);
	
	//Get All Attendance in a Department form Attendance table
	public ArrayList<Attendance> getDepartmentAttendance(String DepartmentID);

	//Get All Attendance form Attendance table
	public ArrayList<Attendance> getAttendance();
	
	//Set Work Starting time and End Time to Null in Attendance table
	public void setAttendanceStartTimeEndTimeToNull();
	
	//Update Work Start Time in Attendance table
	public ArrayList<Attendance> updateAttendanceStartTime(String attendanceID,Attendance attendance);
	
	//Update Work End Time in Attendance table
	public ArrayList<Attendance> updateAttendanceEndTime(String attendanceID,Attendance attendance);
	
	//Remove an Attendance form Attendance table
	public void removeAttendance(String attendanceID);
	
	//Get Department ID in Employee table
	public String getDepartmentID(String EmployeeID);
	
	// Get Employee Name in Employee table
	public String getEmployeeName(String EmployeeID);

	
	
	
}
