package ems.Department.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.ems.model.Department;
import com.ems.model.Manager;
import com.ems.util.CommonConstants;
import com.ems.util.CommonUtil;
import com.ems.util.DBConnection;
import com.ems.util.QueryUtil;

/**
 * @author Zumry
 *	IT NO:IT19175126
 */

public class HRDepartmentAndManagerServiceImpt implements HRDepartmentAndManagerServiceInterface {

	public static final Logger Log = Logger.getLogger(HRDepartmentAndManagerServiceImpt.class.getName());
	
	private static Connection connection;
	
	private PreparedStatement preparedStatement;
	private PreparedStatement preparedStatement1;

	
	/*********************************** Add Department and Add Manager function *************************************/
	
	@Override
	public void addDepartment(Department department) 
	{
		
		String DepID = CommonUtil.generateDepartmentIDs(getDepartmentIDs());
		
		try {
			
			connection = DBConnection.getDBConnection();	
			
			//Insert Department Details 
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_INSERT_DEPARTMENT_DETAILS));
			connection.setAutoCommit(false);
			
			department.setDepID(DepID);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, department.getDepID());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, department.getName());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, department.getLocation());
			
			//Add
			preparedStatement.execute();
			connection.commit();
		
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
			Log.log(Level.SEVERE, ex.getMessage());
		}finally {
			
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				Log.log(Level.SEVERE, e.getMessage());
			}
		}
	}
	
	@Override
	public void addManager(Manager manager,String EmpID) 
	{

		String ManagerID = CommonUtil.generateManagerIDs(getManagerIDs());
		int LoginID = 0;
		
		try {
			
			connection = DBConnection.getDBConnection();

			//Get login ID for manager table
			preparedStatement1 =connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_LOGINID_FOR_MANAGER_TABLE));
			preparedStatement1.setString(CommonConstants.COLUMN_INDEX_ONE, EmpID );
			
			ResultSet resultSet = preparedStatement1.executeQuery();
			
			if(resultSet.next())
			{
				LoginID = resultSet.getInt(1);
			}

			//Insert Manager details into manager table
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_INSERT_MANAGER_DETAILS));
			connection.setAutoCommit(false);
			
			manager.setManagerId(ManagerID);
			manager.setLoginId(LoginID);
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, manager.getManagerId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, manager.getEmployee());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, manager.getDepartment());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, manager.getStartingDate());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, manager.getLoginId());
			
			//Add
			preparedStatement.execute();
			connection.commit();
		
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
			Log.log(Level.SEVERE, ex.getMessage());
		}finally {
			
			try {
				if(preparedStatement != null && preparedStatement1 != null) {
					preparedStatement.close();
					preparedStatement1.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				Log.log(Level.SEVERE, e.getMessage());
			}
		}
		
	}
	
	/*********************************** get All Department IDs function *************************************/
	
	private ArrayList<String> getDepartmentIDs() {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_DEPARTMENT_IDS));
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
	
	private ArrayList<String> getManagerIDs() {
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			connection = DBConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_MANAGER_IDS));
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
	
	/************************************************ Remove Department *****************************************/
	@Override
	public void removeDepartment(String DepartmentID)
	{
		// Before deleting check whether department ID is available
		if(DepartmentID != null && !DepartmentID.isEmpty()) 
		{
			try {
				connection = DBConnection.getDBConnection();
				
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_REMOVE_DEPARTMENT_BY_ID));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, DepartmentID);
				preparedStatement.executeUpdate();
				
			}catch(SQLException | SAXException | ClassNotFoundException | IOException |  ParserConfigurationException ex) {
				Log.log(Level.SEVERE, ex.getMessage());
			}finally {
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(connection != null) {
						connection.close();
					}
				}catch(SQLException ex){
					Log.log(Level.SEVERE, ex.getMessage());
				}
			}
		}
		
	}	
	
	
	/********************************************************** View Department *****************************************/
	//view Departments
	@Override
	public ArrayList<Department> getDepartments() {
	
		return actionOnDepartment(null);
	}
	
	//View Department by ID
	@Override
	public Department getDepartmentByID(String DepID) {

		return actionOnDepartment(DepID).get(0);
	}	

	//view departments/department function
	private ArrayList<Department> actionOnDepartment(String depId) {

		ArrayList<Department> DepartmentList = new ArrayList<Department>();
		
		try {
			connection = DBConnection.getDBConnection();
			
			if(depId != null && !depId.isEmpty()) {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_DEPARTMENT_BY_ID));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, depId);
			}
			else {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_ALL_DEPARTMENT));
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Department dep = new Department();
				dep.setDepID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				dep.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				dep.setLocation(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				DepartmentList.add(dep);
				
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
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
		
		return DepartmentList ;
	}
	
	//View Department by Manager ID
	public ArrayList<Department> getDepartmentByManagerID(String ManagerID) {

		ArrayList<Department> DepartmentList = new ArrayList<Department>();
		
		try {
			connection = DBConnection.getDBConnection();
			
			if(ManagerID != null && !ManagerID.isEmpty()) {
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_DEPARTMENT_BY_NAME));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, ManagerID);
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Department dep = new Department();
				dep.setDepID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				dep.setName(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				dep.setLocation(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				DepartmentList.add(dep);
				
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
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
		
		return DepartmentList ;
	}
	
	/********************************************* Update Department details  ***************************************************************/
	@Override
	public Department updateDepartment(String DepID, Department dep) {
		
		if(DepID != null && !DepID.isEmpty()) 
		{
			try {
				connection = DBConnection.getDBConnection();
				
				preparedStatement =connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_UPDATE_DEPARTMENT_DETAILS));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, dep.getName());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, dep.getLocation());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, dep.getDepID());
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
		
		return getDepartmentByID(DepID);
		
	}
	
	
	/********************************************************** View Manager List *****************************************/

	//All Managers List
	@Override
	public ArrayList<Manager> getManagers() {
		
		return actionOnManager(null);
	}
	
	//manager list by ID
	@Override
	public Manager getManagerByID(String ManagerID) {

		return actionOnManager(ManagerID).get(0);
	}

	//manager all list/by ID function
	private ArrayList<Manager> actionOnManager(String ManagerID) 
	{
		
		ArrayList<Manager> ManagerList = new ArrayList<Manager>();
		
		try {
			connection = DBConnection.getDBConnection();
			
			if(ManagerID != null && !ManagerID.isEmpty())
			{
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_MANAGER_BY_ID_All_details));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, ManagerID);
			}
			else 
			{
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_ALL_MANAGERS));
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Manager manager = new Manager();
				
				manager.setManagerId(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				manager.setEmployee(resultSet.getString(CommonConstants.COLUMN_INDEX_TWO));
				manager.setDepartment(resultSet.getString(CommonConstants.COLUMN_INDEX_THREE));
				manager.setStartingDate(resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR));
				manager.setLoginId(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE));
				
				ManagerList.add(manager);
				
			}
			
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
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
		
		return ManagerList ;
	}	
	
	
	/********************************************* Update Manager details  ***************************************************************/
	@Override
	public Manager updateManager(String ManagerID, Manager manager) {
		
		if(ManagerID != null && !ManagerID.isEmpty()) 
		{
			try {
				connection = DBConnection.getDBConnection();
				
				preparedStatement =connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_UPDATE_MANAGER_DETAILS));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, manager.getEmployee());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, manager.getDepartment());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, manager.getStartingDate());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, manager.getManagerId());
				
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
		
		return getManagerByID(ManagerID);
		
	}
		
	
	
}
