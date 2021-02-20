package ems.Employee.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.ems.model.Employee;
import com.ems.model.Login;

/**
 * @author Zumry
 * IT NO:IT19175126 
 *
 */
public interface HREmployeeServiceInterface {

	public static final Logger Log = Logger.getLogger(HREmployeeServiceInterface.class.getName());
	
	//Add employees and create login for User
	public void addEmployee(Employee employee ,Login login);
	
	//Delete Employee
	public void removeEmployee(String EmployeeID);
	
	//Get one (or) all employee details
	public ArrayList<Employee> getEmployees();
	
	//Employee details update 
	public Employee updateEmployee(String EmployeeID, Employee Employee);
	
	public Employee getEmployeeByID(String EmployeeID);
	
	
}
