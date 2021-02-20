package ems.Tasks.service;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.ems.model.Employee;
import com.ems.model.Tasks;
import ems.Tasks.service.taskServiceImpt;
import com.ems.util.CommonConstants;
import com.ems.util.CommonUtil;
import com.ems.util.DBConnection;
import com.ems.util.QueryUtil;

public class taskServiceImpt implements taskService {

	public static final Logger log = Logger.getLogger(taskServiceImpt.class.getName());

	private static Connection connection;

	private static Statement statement;

	
	private PreparedStatement preparedStatement;

	
	

	
	@Override
	public void addTask(Tasks tasks) {

		String TaskID = CommonUtil.generateTaskIDs(getTaskIDs());
		
		try {
			connection = DBConnection.getDBConnection();
	
			preparedStatement = connection
					.prepareStatement(com.ems.util.QueryUtil.queryByID(com.ems.util.CommonConstants.QUERY_ID_INSERT_TASK));
			connection.setAutoCommit(false);
			
			//Generate employee IDs
			tasks.setTaskId(TaskID);
			preparedStatement.setString(com.ems.util.CommonConstants.COLUMN_INDEX_ONE, tasks.getTaskId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, tasks.getEmployee());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, tasks.getDepartment());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, tasks.getTask_Name());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, tasks.getAssignDate());
			
			// Add employee
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public Tasks getTasksByID(String taskId) {

		return actionOnTasks(taskId).get(0);
	}
	
	/**
	 * Get all list of Tasks in Department
	 * 
	 * @return ArrayList<Employee> 
	 * 						- Array of Tasks list will be return
	 * 
	 * @see #actionOnEmployee()
	 */
	@Override
	public ArrayList<Tasks> getTasksinDeparment(String DepartmentName) {
		
			ArrayList<Tasks> tasklist = new ArrayList<Tasks>();
		
		try {
				if (DepartmentName!= null && !DepartmentName.isEmpty()) {
					connection = DBConnection.getDBConnection();
					preparedStatement = connection
							.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_TASK));
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, DepartmentName);
			}
			ResultSet resultSet = preparedStatement.executeQuery();
	
			while (resultSet.next()) {
				Tasks tasks = new Tasks();
				tasks.setTaskId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				tasks.setEmployee(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				tasks.setDepartment(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				tasks.setTask_Name(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				tasks.setAssignDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				
				tasklist.add(tasks);
			}

	} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
		log.log(Level.SEVERE, e.getMessage());
	} finally {
		/*
		 * Close prepared statement and database connectivity at the end of
		 * transaction
		 */
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	return tasklist;
	
}
	
	@Override
	public void removeTasks(String taskId) {

		// Before deleting check whether employee ID is available
		if (taskId != null && !taskId.isEmpty()) {

			try {
				connection = DBConnection.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_TASK));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, taskId);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	
	
	private ArrayList<Tasks> actionOnTasks(String taskId) {

		ArrayList<Tasks> tasklist = new ArrayList<Tasks>();
		try {
			connection = DBConnection.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (taskId!= null && !taskId.isEmpty()) {
				
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TASK));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, taskId);
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Tasks tasks = new Tasks();
				tasks.setTaskId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				tasks.setEmployee(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				tasks.setDepartment(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				tasks.setTask_Name(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				tasks.setAssignDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				
				tasklist.add(tasks);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return tasklist;
	}


	@Override
	public Tasks updateTasks(String taskId, Tasks tasks) {

		/*
		 * Before fetching employee it checks whether employee ID is available
		 */
		if (taskId != null && !taskId.isEmpty()) {
			
			try {
				connection = DBConnection.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_TASK));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, tasks.getEmployee());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, tasks.getDepartment());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, tasks.getTask_Name());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, tasks.getAssignDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, tasks.getTaskId());
		
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated employee
		return getTasksByID(taskId);
	}
	

	private ArrayList<String> getTaskIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnection.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_TASK_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
	
	/********************************************* view Tasks for Employee panel ***************************************************************/	
	@Override
	public ArrayList<Tasks> getTasksInEmployeeID(String EmployeeID) 
	{
		ArrayList<Tasks> EmployeeTaskList = new ArrayList<Tasks>();
		String depID = null;
		
		try {
			
			connection = DBConnection.getDBConnection();
			
			if(EmployeeID != null && !EmployeeID.isEmpty())
			{				
			
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_TASK_BY_EmployeeID));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,EmployeeID );
				
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) 
				{
					Tasks task = new Tasks();
					
					task.setTaskId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
					task.setEmployee(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
					task.setDepartment(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
					task.setTask_Name(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
					task.setAssignDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));					
					
					EmployeeTaskList.add(task);
					
				}
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
			log.log(Level.SEVERE, ex.getMessage());
		}finally {
			
			//Closing DB Connection and Prepared Statement
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return EmployeeTaskList;
		
	}
	
	//Get Department Name by Employee ID
	@Override
	public String getDepNameByEmployeeID(String EmployeeID)
	{
		String DepartmentName = null ;
		
		try {
			
			connection = DBConnection.getDBConnection();

			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_DEP_NAME_BY_EMPLOYEE_ID));
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,EmployeeID );
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				DepartmentName = resultSet.getString(1);
			}
	
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
			log.log(Level.SEVERE, ex.getMessage());
		}finally {
			
			//Closing DB Connection and Prepared Statement
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		
		}
		
		return DepartmentName;
	}
	
	//Get Employees Name 
	@Override
	public ArrayList<Employee> getDepartmentEmployeeNames(String DepName)
	{
		
		ArrayList<Employee> EmplyeeNameList = new ArrayList<Employee>();
		try {
			
			connection = DBConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_EMPLOYEE_NAME));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,DepName);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				Employee employee = new Employee();
				
				employee.setFullname(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				
				EmplyeeNameList.add(employee);
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return EmplyeeNameList;	
	}


	
}
