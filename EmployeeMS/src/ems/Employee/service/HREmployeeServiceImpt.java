package ems.Employee.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.ems.model.Employee;
import com.ems.model.Login;
import com.ems.util.CommonConstants;
import com.ems.util.CommonUtil;
import com.ems.util.DBConnection;
import com.ems.util.QueryUtil;

/**
 * @author Zumry
 * IT NO:IT19175126
 *
 */
public class HREmployeeServiceImpt implements HREmployeeServiceInterface{

	public static final Logger Log = Logger.getLogger(HREmployeeServiceImpt.class.getName());
	
	private static Connection connection;
	private PreparedStatement preparedStatement;
	private PreparedStatement preparedStatement2;


	
	/*********************************** Add employees for employee table and Login Details add Login table *****************************************/
	@Override
	public void addEmployee(Employee employee,Login login) {

		String EmployeeID = CommonUtil.generateEmployeeIDs(getEmployeeIDs());
		int LoginID = CommonUtil.generateLoginIDs(getLoginIDs());
		
		
		try {
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_INSERT_EMP_DETAILS));
			preparedStatement2 = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_INSERT_LOGIN_DETAILS));
			
			connection.setAutoCommit(false);
			
			//Generate employee IDs
			employee.setEmpID(EmployeeID);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,employee.getEmpID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO,employee.getFullname());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE,employee.getJobTitle());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR,employee.getAddress());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE,employee.getGender());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX,employee.getDOB());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN,employee.getMaritalStatus());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT,employee.getNIC());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, employee.getPhoneNo());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TEN, employee.getJointDate());
			preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_ELEVEN,employee.getSalary());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE,employee.getDepartment());
			
			// Add employee
			preparedStatement.execute();
			connection.commit();
			
			login.setLoginID(LoginID);
			login.setEmployeeId(EmployeeID);
			
			preparedStatement2.setInt(CommonConstants.COLUMN_INDEX_ONE, login.getLoginID());
			preparedStatement2.setString(CommonConstants.COLUMN_INDEX_TWO, login.getEmployeeId());
			preparedStatement2.setString(CommonConstants.COLUMN_INDEX_THREE, login.getUsername());
			preparedStatement2.setString(CommonConstants.COLUMN_INDEX_FOUR, login.getPassword());
			preparedStatement2.setString(CommonConstants.COLUMN_INDEX_FIVE, login.getRole());
			
			//Add Login Details
			preparedStatement2.execute();
			connection.commit();
			

		} catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
			Log.log(Level.SEVERE, ex.getMessage());
		} finally {
			 
			//Close prepared statement and database connectivity at the end of transaction 
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
					preparedStatement2.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				Log.log(Level.SEVERE, e.getMessage());
			}
		}
		
	}
	

	//Get Employees IDs
	private ArrayList<String> getEmployeeIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_EMPLOYEE_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		}catch(SQLException | ParserConfigurationException | ClassNotFoundException | SAXException | IOException ex) {
			Log.log(Level.SEVERE, ex.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException ex) {
				Log.log(Level.SEVERE, ex.getMessage());
			}
		}
		
		return arrayList;
	}
	
	//Get Logins IDs
	private ArrayList<Integer> getLoginIDs(){
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		try {
			connection = DBConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_LOGIN_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				arrayList.add(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
			}
		}catch(SQLException | ParserConfigurationException | ClassNotFoundException | SAXException | IOException ex) {
			Log.log(Level.SEVERE, ex.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			}catch(SQLException ex) {
				Log.log(Level.SEVERE, ex.getMessage());
			}
		}
		
		return arrayList;
	}
	
	
	
	
	/********************************************* Delete Employee ***************************************************************/
	@Override
	public void removeEmployee(String EmployeeID)
	{
		// Before deleting check whether employee ID is available
		if(EmployeeID != null & !EmployeeID.isEmpty())
		{
			try {
				connection = DBConnection.getDBConnection();
				
				preparedStatement= connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_REMOVE_EMPLOYEE_BY_ID));

				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EmployeeID);
				
				preparedStatement.executeUpdate();
			
			}catch(SQLException | SAXException | IOException | ClassNotFoundException | ParserConfigurationException ex) {
				Log.log(Level.SEVERE, ex.getMessage());
			}finally {
				try{
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(connection != null) {
						connection.close();
					}
				}catch(SQLException ex) {
					Log.log(Level.SEVERE , ex.getMessage());
				}
			}
		}
	}	
	
	
	/********************************************* View Employees Details ***************************************************************/
	
	@Override
	public ArrayList<Employee> getEmployees() {
			
			return actionOnEmployee(null);
		}

	
	private ArrayList<Employee> actionOnEmployee(String EmployeeID) {

		ArrayList<Employee> EmplyeeList = new ArrayList<Employee>();
		try {
			connection = DBConnection.getDBConnection();
			
			//Before fetching employee it checks whether employee ID is available
			if(EmployeeID != null && !EmployeeID.isEmpty()) 
			{
				//get one employee details (view)
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_EMPLOYEE_BY_ID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EmployeeID);
			}
			
			//get all employee details(view)
			else 
			{
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_ALL_EMPLOYEE));
			}
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				Employee employee = new Employee();
				employee.setEmpID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				employee.setFullname(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				employee.setJobTitle(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				employee.setAddress(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				employee.setGender(resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE));
				employee.setDOB(resultSet.getString(CommonConstants.COLUMN_INDEX_SIX));
				employee.setMaritalStatus(resultSet.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				employee.setNIC(resultSet.getString(CommonConstants.COLUMN_INDEX_EIGHT));
				employee.setPhoneNo(resultSet.getString(CommonConstants.COLUMN_INDEX_NINE));
				employee.setJointDate(resultSet.getString(CommonConstants.COLUMN_INDEX_TEN));
				employee.setSalary(resultSet.getDouble(CommonConstants.COLUMN_INDEX_ELEVEN));
				employee.setDepartment(resultSet.getString(CommonConstants.COLUMN_INDEX_TWELVE));
				
				EmplyeeList.add(employee);
				
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			Log.log(Level.SEVERE, e.getMessage());
		}finally {
			
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				Log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return EmplyeeList;
		
 	}

	
	/********************************************* Employee details update ***************************************************************/
	@Override
	public Employee updateEmployee(String EmployeeID, Employee Employee) {
		
		if(EmployeeID != null && !EmployeeID.isEmpty()) 
		{
			try {
				connection = DBConnection.getDBConnection();
				
				preparedStatement =connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_UPDATE_EMP_DETAILS));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Employee.getFullname());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, Employee.getJobTitle());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, Employee.getAddress());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, Employee.getGender());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE,Employee.getDOB());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX,Employee.getMaritalStatus());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, Employee.getNIC());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, Employee.getPhoneNo());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_NINE, Employee.getJointDate());
				preparedStatement.setDouble(CommonConstants.COLUMN_INDEX_TEN, Employee.getSalary());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ELEVEN, Employee.getDepartment());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWELVE, Employee.getEmpID());
				preparedStatement.executeUpdate();
				
				
			}catch(SQLException | SAXException | ClassNotFoundException | IOException | ParserConfigurationException ex) {
				Log.log(Level.SEVERE, ex.getMessage());
			}finally {
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(connection != null ) {
						connection.close();
					}
				}catch(SQLException ex){
					Log.log(Level.SEVERE, ex.getMessage());
				}
			}
		}
		
		return getEmployeeByID(EmployeeID);
		
	}
	
	
	public Employee getEmployeeByID(String EmployeeID) {

		return actionOnEmployee(EmployeeID).get(0);
	}



}
