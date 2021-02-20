package ems.Tasks.service;

import com.ems.model.Employee;
import com.ems.model.Tasks; 
import java.util.ArrayList;
import java.util.logging.Logger;



public interface taskService {
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(taskService.class.getName());


	/*
	 */
	public void addTask(Tasks tasks);

	/**
	 *
	 */
	public Tasks getTasksByID(String taskId);
	
	/**
	 * 
	 */
	public ArrayList<Tasks> getTasksinDeparment(String Department);
	
	/**
	 * 
	 */
	public Tasks updateTasks(String taskID, Tasks tasks);

	/**
	 * 
	 */
	public void removeTasks(String taskID);
	
	public ArrayList<Tasks> getTasksInEmployeeID(String EmployeeID);

	public String getDepNameByEmployeeID(String EmployeeID);
	
	public ArrayList<Employee> getDepartmentEmployeeNames(String DepName);

	

}
