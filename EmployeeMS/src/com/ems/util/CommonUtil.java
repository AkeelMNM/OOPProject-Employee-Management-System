package com.ems.util;

import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

import ems.attendance.service.AttendanceService;

public class CommonUtil {
	
	public static final Logger log = Logger.getLogger(AttendanceService.class.getName());
	
	
	/** ----------------------------------Attendance & AttendanceStatus ---------------------------------------------------------**/
	
	//Creating new Attendance ID
	
	public static String generateAIDs(ArrayList<String> arrayList)
	{
		String id;
		int alSize = arrayList.size();
		alSize++;
		id=CommonConstants.ATTENDANCE_ID_PREFIX + alSize;
		if(arrayList.contains(id))
		{
			alSize++;
			id=CommonConstants.ATTENDANCE_ID_PREFIX + alSize;
		}
		return id;
	}
	
	//Creating new AttendanceStatus ID
	
	public static String generateAtSIDs(ArrayList<String> arrayList)
	{
		String id;
		int alSize = arrayList.size();
		alSize++;
		id=CommonConstants.ATTENDANCESTATUS_ID_PREFIX + alSize;
		if(arrayList.contains(id))
		{
			alSize++;
			id=CommonConstants.ATTENDANCESTATUS_ID_PREFIX + alSize;
		}
		return id;
	}
	
	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	
	
	/** ----------------------------------Employee & Department & Manger & login  ---------------------------------------------------------**/
	
	//generate new Employee ID
		public static String generateEmployeeIDs(ArrayList<String> arrayList) {
			
			String id;
			int next = arrayList.size();
			next++;
			id = CommonConstants.Query_id_EMPLOYEE_ID_PREFIX + next ;
			
			if(arrayList.contains(id))
			{
				next++;
				id = CommonConstants.Query_id_EMPLOYEE_ID_PREFIX + next ;
			}
			return id;
		}
		
		//generate new Login ID
			public static int generateLoginIDs(ArrayList<Integer> arrayList) {
				
				int id;
				int next = arrayList.size();
				next++;
				id = CommonConstants.Query_id_LOGIN_ID_PREFIX + next ;
				
				if(arrayList.contains(id))
				{
					next++;
					id = CommonConstants.Query_id_LOGIN_ID_PREFIX + next ;
				}
				return id;
			}
		
		
		
		//generate new Department ID
		public static String generateDepartmentIDs(ArrayList<String> arrayList) {
			
			String id;
			int next = arrayList.size();
			next++;
			id = CommonConstants.Query_id_DEPARTMENT_ID_PREFIX + next ;
			
			if(arrayList.contains(id))
			{
				next++;
				id = CommonConstants.Query_id_DEPARTMENT_ID_PREFIX + next ;
			}
			return id;
		}
		
		
		//generate new Manager ID
		public static String generateManagerIDs(ArrayList<String> arrayList) {
			
			String id;
			int next = arrayList.size();
			next++;
			id = CommonConstants.Query_id_MANAGER_ID_PREFIX + next ;
			
			if(arrayList.contains(id))
			{
				next++;
				id = CommonConstants.Query_id_MANAGER_ID_PREFIX + next ;
			}
			return id;
		}
	
	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	
	
	
	/** ----------------------------------         Leave          ---------------------------------------------------------**/
	
		//Creating new Attendance ID
		
		public static String generateLIDs(ArrayList<String> arrayList)
		{
			String id;
			int alSize = arrayList.size();
			alSize++;
			id=CommonConstants.LEAVE_ID_PREFIX + alSize;
			if(arrayList.contains(id))
			{
				alSize++;
				id=CommonConstants.LEAVE_ID_PREFIX + alSize;
			}
			return id;
		}

	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	
	
	
	/** ----------------------------------         Tasks            ---------------------------------------------------------**/
	
		//generate new Task ID
		public static String generateTaskIDs(ArrayList<String> arrayList) {
			
			String id;
			int next = arrayList.size();
			next++;
			id = CommonConstants.Query_id_TASK_ID_PREFIX + next ;
			
			if(arrayList.contains(id))
			{
				next++;
				id = CommonConstants.Query_id_TASK_ID_PREFIX + next ;
			}
			return id;
		}

	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/

	
}
