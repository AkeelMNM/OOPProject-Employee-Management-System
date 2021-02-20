package com.ems.util;

public class CommonConstants {
	
	/** ---------------------------------- Common to Everyone ---------------------------------------------------------**/
	
	//Constant for query tag in EmployeeMSDBQuery.xml 
	public static final String TAG_NAME ="query";
	
	//Constant for query id in EmployeeMSDBQuery.xml 
	public static final String ATT_ID ="id";
	
	//Constant for query id for get Login in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_LOGIN ="get_login";
	
	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	
	
	/** ----------------------------------Attendance & AttendanceStatus ---------------------------------------------------------**/
	
	/** ------------------------------------     For Attendance    -------------------------------------------------- **/
	 
	 
	//Constant for query id for insert Attendance in EmployeeMSDBQuery.xml 
	public static final String Query_ID_INSERT_ATTENDANCE ="insert_attendance";
	
	//Constant for query id for get AttendanceID in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_ATTENDANCE_ID ="get_attendanceId";
	
	//Constant for query id for get an Attendance in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_ATTENDANCE ="get_attendance";
	
	//Constant for query id for get All Attendance in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_ALL_ATTENDANCE ="get_all_attendance";
	
	//Constant for query id for get Employees that don't have Attendance in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_EMPLOYEE_THAT_DONT_HAVE_ATTENDANCE ="get_employee_dont_have_attendance";
	
	//Constant for query id for get Department Employees Attendance in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_ALL_ATTENDANCE_IN_DEPARTMENT ="get_all_attendance_in_department";
	
	
	//Constant for query id for update Attendance Start_time  in EmployeeMSDBQuery.xml 
	public static final String Query_ID_UPDATE_ATTENDANCE_START_TIME ="update_attendance_start_time";
	
	//Constant for query id for update Attendance End_time  in EmployeeMSDBQuery.xml 
	public static final String Query_ID_UPDATE_ATTENDANCE_END_TIME ="update_attendance_end_time";
	
	//Constant for query id for Set Attendance Start_time,End_time to NULL  in EmployeeMSDBQuery.xml 
	public static final String Query_ID_SET_ATTENDANCE_START_TIME_END_TIME_TO_NULL ="set_attributes_to_null";
	
	//Constant for query id for remove Attendance in EmployeeMSDBQuery.xml 
	public static final String Query_ID_REMOVE_ATTENDANCE ="remove_attendance";
	
	//Constant for query id for get All Attendance IDs in EmployeeMSDBQuery.xml 
	public static final String Query_ID_ALL_ATTENDANCE_IDS ="get_attendanceids";
	
	//Constant for Employee Attendance ID prefix 
	public static final String ATTENDANCE_ID_PREFIX ="A000";
	
	//-----------------------------------------------------------------------------//
	
	/** ------------------------------------     For AttendanceStatus    -------------------------------------------------- **/
	
	//Constant for query id for insert AttendanceStatus in EmployeeMSDBQuery.xml 
	public static final String Query_ID_INSERT_ATTENDANCESTATUS ="insert_attendanceStatus";
	
	//Constant for query id for get AttendanceStatus ID in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_ATTENDANCE_STATUS_ID ="get_attendanceStatusId";
	
	//Constant for query id for get an AttendanceStatus in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_ATTENDANCESTATUS ="get_attendanceStatus";
	
	//Constant for query id for get Department Employees Attendance in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_ALL_ATTENDANCESTATUS_IN_DEPARTMENT ="get_all_attendanceStatus_in_department";
	
	//Constant for query id for get All AttendanceStatus in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_ALL_ATTENDANCESTATUS ="get_all_attendanceStatus";
	
	//Constant for query id for update AttendanceStatus no of working days in EmployeeMSDBQuery.xml 
	public static final String Query_ID_UPDATE_ATTENDANCESTATUS_NO_WORKING_DAYS ="update_attendance_no_of_working_days";
	
	//Constant for query id for update AttendanceStatus no of leave days in EmployeeMSDBQuery.xml 
	public static final String Query_ID_UPDATE_ATTENDANCESTATUS_NO_LEAVE_DAYS ="update_attendance_no_of_leave_days";
	
	//Constant for query id for update AttendanceStatus no of leave days in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_ATTENDANCE_WHOS_ABSENT ="get_attendance_whos_absent";
	
	//Constant for query id for Set AttendanceStatus Working days and Leave Days to NULL  in EmployeeMSDBQuery.xml 
	public static final String Query_ID_SET_ATTENDANCESTATUS_WORKINGDAYS_LEAVEDAYS_TO_NULL ="set_attSt_attributes_to_null";
	
	//Constant for query id for remove AttendanceStatus in EmployeeMSDBQuery.xml 
	public static final String Query_ID_REMOVE_ATTENDANCESTATUS ="remove_attendanceStatus";
	
	//Constant for query id for get AttendanceStatus ID in EmployeeMSDBQuery.xml 
	public static final String Query_ID_ALL_ATTENDANCESTATUS_IDS ="get_attendanceStatusids";
	
	//Constant for Employee AttendanceStatus ID prefix 
	public static final String ATTENDANCESTATUS_ID_PREFIX ="As00";
	

	//Constant for query id for get Employees ID's in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_MANAGERS_DEPAERMENT_ID ="get_Managers_Department_ID";
	
	//Constant for query id for  get Employee name in EmployeeMSDBQuery.xml 
	public static final String Query_ID_GET_EMPLOYEE_NAME ="get_employee_name";
	

	//------------------------------------------------------------------------------//
	
	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	
	
	
	/** ----------------------------------Employee & Department & Manger & login  ---------------------------------------------------------**/

	
	//Login Table *************************************************************************************************
	
	/** Constant for login id prefix */
	public static final Integer Query_id_LOGIN_ID_PREFIX = 0;

	public static final String Query_id_INSERT_LOGIN_DETAILS = "insert_login_Details";
	
	public static final String Query_id_GET_LOGIN_IDS = "Login_ids";
	
	public static final String Query_id_GET_LOGINID_FOR_MANAGER_TABLE ="get_loginID_for_manager_table";
	
	
	
	//Manager *************************************************************************************************
	
	/** Constant for Manager id prefix */
	public static final String Query_id_MANAGER_ID_PREFIX = "Man0";
	
	public static final String Query_id_GET_MANAGER_BY_ID = "Manager_by_id";
	
	public static final String Query_id_GET_MANAGER_BY_ID_All_details = "Manager_by_id_All_Details";

	/** All each department employee details (Manager) */
	public static final String Query_id_GET_EMPLOYEES_DETAILS_BY_MANAGER = "Manager_Dep_Employee";
	
	public static final String Query_id_INSERT_MANAGER_DETAILS = "insert_Manager_Details";
	
	public static final String Query_id_GET_ALL_MANAGERS = "all_Managers";
	
	public static final String Query_id_REMOVE_MANAGER_BY_ID = "remove_Manager";
	
	public static final String Query_id_GET_MANAGER_IDS = "Manager_ids";
	
	public static final String Query_id_UPDATE_MANAGER_DETAILS = "update_manager_Details";
	
	public static final String Query_id_GET_MANAGER_ID_BY_EmpID = "Get_managerID_by_EmpID";
	
	
	//Department *************************************************************************************************
	
	/** Constant for Department id prefix */
	public static final String Query_id_DEPARTMENT_ID_PREFIX = "Dep0";
	
	public static final String Query_id_INSERT_DEPARTMENT_DETAILS = "insert_Dep_Details";
	
	public static final String Query_id_GET_DEPARTMENT_BY_ID = "Dep_by_id";
	
	public static final String Query_id_GET_DEPARTMENT_BY_NAME = "Dep_by_name";
	
	public static final String Query_id_GET_ALL_DEPARTMENT = "all_Dep";
	
	public static final String Query_id_REMOVE_DEPARTMENT_BY_ID = "remove_Dep";
	
	public static final String Query_id_UPDATE_DEPARTMENT_DETAILS = "update_Dep_Details";
	
	public static final String Query_id_GET_DEPARTMENT_IDS = "Dep_ids";
	
	
	//Employee ****************************************************************************************************
	
	/** Constant for employee id prefix */
	public static final String Query_id_EMPLOYEE_ID_PREFIX = "Em00";
	
	public static final String Query_id_INSERT_EMP_DETAILS = "insert_emp_Details";
	
	public static final String Query_id_GET_EMPLOYEE_BY_ID = "employee_by_id";
	
	public static final String Query_id_GET_ALL_EMPLOYEE = "all_employees";
	
	public static final String Query_id_REMOVE_EMPLOYEE_BY_ID = "remove_employee";
	
	public static final String Query_id_UPDATE_EMP_DETAILS = "update_emp_Details";
	
	public static final String Query_id_GET_EMPLOYEE_IDS = "employee_ids";
	
	
	
	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	
	
	
	/** ----------------------------------         Leave          ---------------------------------------------------------**/
	
	/** Constant for query id of insert leave in EmployeeMSDDBQuery.xml */
	public static final String QUERY_ID_INSERT_LEAVE = "insert_leave";

	/** Constant for query id of get leave by id in EmployeeMSDBQuery.xml */
	public static final String QUERY_ID_GET_LEAVE_BY_ID = "leave_by_id";
	
	
	/** Constant for query id of get an leave  by employee name in EmployeeMSDBQuery.xml */
	public static final String QUERY_ID_GET_LEAVE_BY_EMPLOYEE_NAME = "leave_by_employeename";

	/** Constant for query id of get all leaves in EmployeeMSDBQuery.xml */
	public static final String QUERY_ID_ALL_LEAVES = "all_leaves";
	
	/** Constant for query id of remove a leave in EmployeeMSDBQuery.xml */
	public static final String QUERY_ID_REMOVE_LEAVE = "remove_Leave";

	/** Constant for query id of update a leave in EmployeeMSDBQuery.xml */
	public static final String QUERY_ID_UPDATE_LEAVE = "update_leave";

	/** Constant for query id of get all leave id's in EmployeeMSDBQuery.xml */
	public static final String QUERY_ID_GET_LEAVE_IDS = "get_all_leave_ids";
	
	/** Constant for employee id prefix */
	public static final String LEAVE_ID_PREFIX = "Le00";
	
	/** Constant for query id of get employee name for leave in EmployeeMSDDBQuery.xml */
	public static final String QUERY_ID_GET_EMPLOYEE_NAME_FOR_LEAVE="GET_NAME";
	
	/** Constant for query id of  of get Department name for leave in EmployeeMSDDBQuery.xml */
	public static final String QUERY_ID_GET_LEAVE_DEPARTMENT_NAME = "leave_department_name";
	
	/** Constant for query id of  get  all Department leave  for manager in EmployeeMSDDBQuery.xml */
	public static final String QUERY_ID_GET_ALL_DEPARTMENT_LEAVE = "get_all_department_leave";
	
	/** Constant for query id of update leave permission from manager in EmployeeMSDDBQuery.xml */
	public static final String QUERY_ID_UPDATE_LEAVE_PERMISSION="update_leavepermission";

	
	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	
	
	
	/** ----------------------------------         Tasks            ---------------------------------------------------------**/
	
	/** Constant for Task id prefix */
	public static final String Query_id_TASK_ID_PREFIX = "Ta00";
	

	/** Constant for query id of insert employees in EmployeeQuery.xml */
	public static final String QUERY_ID_INSERT_TASK = "insert_task";

	/** Constant for query id of get an employee in EmployeeQuery.xml */
	public static final String QUERY_ID_GET_TASK = "task_by_id";

	/** Constant for query id of get all employees in EmployeeQuery.xml */
	public static final String QUERY_ID_ALL_TASK = "all_task";

	/** Constant for query id of remove a employee in EmployeeQuery.xml */
	public static final String QUERY_ID_REMOVE_TASK = "remove_task";

	/** Constant for query id of update a employee in EmployeeQuery.xml */
	public static final String QUERY_ID_UPDATE_TASK = "update_task";

	/** Constant for query id of get all employee ids in EmployeeQuery.xml */
	public static final String QUERY_ID_GET_TASK_IDS = "task_ids";
	
	public static final String Query_id_GET_TASK_BY_EmployeeID = "get_task_by_EmployeeID";
	
	public static final String Query_id_GET_DEP_NAME_BY_EMPLOYEE_ID = "get_dep_name_by_employee_id";
	

	public static final String Query_id_GET_EMPLOYEE_NAME = "get_employees_name";
	

	/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
	

	
		
	
	//Constant for column index one 
	public static final int COLUMN_INDEX_ONE = 1;
	
	//Constant for column index two 
	public static final int COLUMN_INDEX_TWO = 2;
	
	//Constant for column index three 
	public static final int COLUMN_INDEX_THREE = 3;
	
	//Constant for column index four 
	public static final int COLUMN_INDEX_FOUR = 4;
	
	//Constant for column index five 
	public static final int COLUMN_INDEX_FIVE = 5;
	
	//Constant for column index six 
	public static final int COLUMN_INDEX_SIX = 6;
	
	//Constant for column index seven 
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	//Constant for column index eight 
	public static final int COLUMN_INDEX_EIGHT = 8;
	
	//Constant for column index nine
	public static final int COLUMN_INDEX_NINE = 9;

	//Constant for column index ten
	public static final int COLUMN_INDEX_TEN = 10;
	
	//Constant for column index eleven
	public static final int COLUMN_INDEX_ELEVEN = 11;

	//Constant for column index twelve
	public static final int COLUMN_INDEX_TWELVE = 12;
	
	//Constant for column index thirteen
	public static final int COLUMN_INDEX_THIRTEEN = 13;

	
}
