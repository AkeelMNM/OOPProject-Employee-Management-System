package ems.attendanceStatus.service;

import java.util.ArrayList;
import com.ems.model.AttendanceStatus;

/** 
 * 
 * @author Akeel M.N.M
 * IT NO:IT19153414
 *
 */

public interface AttendanceStatusService {
	
		//add AttendanceStautus for AttendanceStautus table
		public void addAttendanceStatus(AttendanceStatus attendanceStatus);
		
		//Get AttendanceStatus ID in AttendanceStatus table
		public String getAttendanceStatusID(String AttendanceID);
		
		//Get a Particular AttendanceStautus form AttendanceStautus table	
		public ArrayList<AttendanceStatus> getAttendanceStatusByID(String attendanceStatusId);
		
		//Get All AttendanceStatus in a Department from AttendanceStatus table
		public ArrayList<AttendanceStatus> getDepartmentAttendanceStatus(String DepartmentName);

		//get All AttendanceStautus form AttendanceStautus table
		public ArrayList<AttendanceStatus> getAttendanceStatus();
			
		//Update Numbers of Working Days in AttendanceStautus table
		public ArrayList<AttendanceStatus> updateAttendanceStatusWorkingDays(String attendanceStatusId,AttendanceStatus attendanceStatus);
		
		//Update AttendanceStatus LeaveDays of Absent Employees in AttendanceStautus table
		public void updateAttendanceStatusLeaveDays();
		
		//Remove AttendanceStautus form AttendanceStautus table
		public void removeAttendanceStautus(String attendanceStatusID);
		
		//Set Working Days and Leave Days to Null in AttendanceStatus table
		public void resetAttendanceStatusWorkingandLeaveDays();
		
		

}
