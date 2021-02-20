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
import com.ems.util.CommonConstants;
import com.ems.util.DBConnection;
import com.ems.util.QueryUtil;

/**
 * @author Zumry
 * IT NO:IT19175126
 *
 */
public class ManagerViewEmployeeServiceImpt implements ManagerViewEmployeeServiceInterface{

		public static final Logger Log = Logger.getLogger(ManagerViewEmployeeServiceImpt.class.getName());

		private static Connection connection;
		private PreparedStatement preparedStatement;	
		
		
	/********************************************* view employees for manager panel ***************************************************************/	
	//get employee In department
	@Override
	public ArrayList<Employee> getEmployeesInDepartment(String ManagerID) 
	{
		ArrayList<Employee> DepartmentEmployeesList = new ArrayList<Employee>();
		String depID = null;
		
		if(ManagerID != null && !ManagerID.isEmpty())
		{				
			try 
			{
				connection = DBConnection.getDBConnection();
				
				//Get Manager Id Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_MANAGER_BY_ID));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, ManagerID);
				
				ResultSet result = preparedStatement.executeQuery();
				
			
				if(result.next()) 
				{
					depID = result.getString(1);
				}
				
			}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
				Log.log(Level.SEVERE, ex.getMessage());
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
					Log.log(Level.SEVERE, e.getMessage());
				}
			
			}

		}
		
		try {
			connection = DBConnection.getDBConnection();
			
			//Get Employee details by Department ID query will be Retrieve from EmployeeMSDBQuery.xml
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_EMPLOYEES_DETAILS_BY_MANAGER));
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,depID );
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
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
				
				DepartmentEmployeesList.add(employee);
				
			}
				
		}catch(SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException ex) {
			Log.log(Level.SEVERE, ex.getMessage());
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
				Log.log(Level.SEVERE, e.getMessage());
			}
		}
		
		return DepartmentEmployeesList;
		
	}

	
	/********************************************* get manager ID by employee ID (cookies) ***************************************************************/
	@Override
	public String getManagerID(String EmployeeID)
	{
		
		String ManagerID = null;
		
		//checking the employee id is available
		if(EmployeeID != null && !EmployeeID.isEmpty())
		{
			try {
				connection = DBConnection.getDBConnection();
				
				//Get Manager ID query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_id_GET_MANAGER_ID_BY_EmpID));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EmployeeID);
				
				ResultSet result = preparedStatement.executeQuery();
				
				if(result.next())
				{
					ManagerID = result.getString(1);
				}
				
			}catch(SQLException | IOException | ClassNotFoundException | ParserConfigurationException | SAXException ex) {
				Log.log(Level.SEVERE, ex.getMessage());
			}finally {
			
				//Closing DB Connection and Prepared Statement
				try {
					if(preparedStatement != null) {
						preparedStatement.close();
					}
					if(connection != null) {
						connection.close();
					}
				}catch (SQLException e) {
					Log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		
		return ManagerID;
	}
	
	

}
