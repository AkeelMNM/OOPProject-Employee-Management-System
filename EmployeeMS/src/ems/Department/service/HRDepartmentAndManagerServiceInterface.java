package ems.Department.service;

import java.util.ArrayList;

import com.ems.model.Department;
import com.ems.model.Manager;

/**
 * @author Zumry
 * IT NO:IT19175126 
 *
 */
public interface HRDepartmentAndManagerServiceInterface {

	//Adding Department
	void addDepartment(Department department);
	
	//Remove Department
	public void removeDepartment(String DepartmentID);
	
	//View Department
	public ArrayList<Department> getDepartments();
	
	//View department by id
	public Department getDepartmentByID(String DepID) ;	
	
	//View Department by Manager ID
	public ArrayList<Department> getDepartmentByManagerID(String ManagerID);
	//update department
	public Department updateDepartment(String DepID, Department dep);

	//Adding Manager to Department
	public void addManager(Manager manager,String EmpID);
	
	//View ALl Manager
	public ArrayList<Manager> getManagers();

	//view manager By Id
	public Manager getManagerByID(String ManagerID);
	
	//update manager
	public Manager updateManager(String ManagerID, Manager manager);
	
}
