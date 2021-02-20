package ems.Employee.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.ems.model.Employee;

/**
 * @author Zumry
 * IT NO:IT19175126
 *
 */
public interface ManagerViewEmployeeServiceInterface {

	public static final Logger Log = Logger.getLogger(ManagerViewEmployeeServiceInterface.class.getName());
	
	//get employee in department
	public ArrayList<Employee> getEmployeesInDepartment(String ManagerID);

	//Get Manager ID 
	public String getManagerID(String EmployeeID);
	
}
