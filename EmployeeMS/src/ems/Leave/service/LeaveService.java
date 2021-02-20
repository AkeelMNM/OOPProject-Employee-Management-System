

package ems.Leave.service;

/**
 * 
 * @author Nusky
 * IT NO:IT19167442
 */

import com.ems.model.Leave;

import java.util.ArrayList;
import java.util.logging.Logger;


public interface LeaveService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(LeaveService.class.getName());
	
	
	/**
	 * Add/insert Leave for Leave table
	 * @param Leave
	 */
	public void addLeave(Leave leave);
	
	
	
	/**
	 * Update existing Leave
	 * @param leaveID
	 * @param Leave
	 * 
	 * @return
	 */
	public void updateLeave(String leaveID, Leave leave);

	
	
	/**
	 * Remove/delete existing Leave
	 * 
	 * @param LeaveID
	 */
	public void removeLeave(String leaveID);
	
	
	/**
	 * Get Particular Leave
	 * 
	 * @param LeaveID
	 * @return 
	 */
	public ArrayList<Leave> getLeaveByEmployeeName(String EmployeeName);
	
	
	/**
	 * Get All Leave
	 * 
	 * @param employeename
	 */
	public ArrayList<Leave> getAllLeave();
	
	/**
	 * Get employee name
	 * 
	 * @param employee id
	 */
	
	public String getEmployeeName(String EmployeeID);
	
	/**
	 * Get leave by id
	 * 
	 * @param leave id
	 */
	
	public ArrayList<Leave> getLeaveByID(String LeaveID);
	
	/**
	 * Get leave for employee department
	 * 
	 * @param employee id
	 */
	
	public String getLeaveEmployeeDepartment(String EmployeeID ) ;
	
	
	/**
	 * Get all department leave
	 * 
	 * @param DepartmentName
	 */
	
	public ArrayList<Leave> getallDepartmentLeave(String DepartmentName);
	
	

	/**
	 * Get manager update leave permission
	 * 
	 * @param Leaveid,status
	 */
	
	public void updateLeavePermission(String LeaveID,String Status);
	


	
	

	

	

}
