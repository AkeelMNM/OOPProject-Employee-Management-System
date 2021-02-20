package ems.Leave.service;

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

import com.ems.model.Leave;
import com.ems.util.CommonConstants;
import com.ems.util.CommonUtil;
import com.ems.util.DBConnection;
import com.ems.util.QueryUtil;


/**
 * 
 * @author Nusky
 * IT NO:IT19167442
 */

public  class LeaveServiceimpt implements LeaveService {
	
	/** Initialize logger */
	/*public static final Logger log = Logger.getLogger(LeaveServiceimpt.class.getName());*/
	
	  public static final Logger log=Logger.getLogger(LeaveServiceimpt.class.getName());
	

	private static Connection connection;

	private static java.sql.Statement statement;	

	private PreparedStatement preparedStatement;
	
	
	
	
	
	
	
// add leave
	public  void addLeave(Leave leave) {
		
		
	String LeaveID =CommonUtil.generateLIDs(getLeaveIDs());
		
		try {
				connection = DBConnection.getDBConnection();
				/*
				 * Query is available in LeaveMSDBQuery.xml file and use
				 * insert_Leave key to extract value of it
				 */
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_LEAVE));
				connection.setAutoCommit(false);
				
				//Generate Leave IDs
				leave.setLeaveId(LeaveID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE ,leave.getLeaveId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, leave.getEmployee());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, leave.getDepartment());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, leave.getStarting_Date());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, leave.getEnd_Date());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, leave.getL_Status());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, leave.getDescription());

				// Add Leave
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

	public ArrayList<Leave> getLeaveByID(String LeaveID) {

		ArrayList<Leave> LeaveList = new ArrayList<Leave>();
		
		try {
		connection = DBConnection.getDBConnection();
		/*
		 * Before fetching employee it checks whether employee ID is
		 * available
		 */
		if (LeaveID != null && !LeaveID.isEmpty()) {
			/*
			 * Get employee by ID query will be retrieved from
			 * EmployeeMSDBQuery.xml
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_LEAVE_BY_ID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, LeaveID);
		}

		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			
			Leave leave = new Leave();
			
			
			leave.setLeaveId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
			leave.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_TWO));
			leave.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_THREE));
			leave.setStarting_Date(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
			leave.setEnd_Date(result.getString(CommonConstants.COLUMN_INDEX_FIVE));
			leave.setL_Status(result.getString(CommonConstants.COLUMN_INDEX_SIX));
			leave.setDescription(result.getString(CommonConstants.COLUMN_INDEX_SEVEN));
			
			LeaveList.add(leave );
			
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
	return LeaveList;
}

	
	public ArrayList<Leave> getLeaveByEmployeeName(String EmployeeName) {

		ArrayList<Leave> LeaveList = new ArrayList<Leave>();
		
		try {
		connection = DBConnection.getDBConnection();
		/*
		 * Before fetching employee id checks whether employee ID is
		 * available
		 */
		if (EmployeeName != null && !EmployeeName.isEmpty()) {
			/*
			 * Get employee by ID query will be retrieved from
			 * EmployeeMSDBQuery.xml
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_LEAVE_BY_EMPLOYEE_NAME));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EmployeeName);
		}

		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			
			Leave leave = new Leave();
			
			
			leave.setLeaveId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
			leave.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_TWO));
			leave.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_THREE));
			leave.setStarting_Date(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
			leave.setEnd_Date(result.getString(CommonConstants.COLUMN_INDEX_FIVE));
			leave.setL_Status(result.getString(CommonConstants.COLUMN_INDEX_SIX));
			leave.setDescription(result.getString(CommonConstants.COLUMN_INDEX_SEVEN));
			
			LeaveList.add(leave );
			
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
	return LeaveList;
}

	
	
	
	public ArrayList<Leave> getallDepartmentLeave(String DepartmentName) {

		ArrayList<Leave> LeaveList = new ArrayList<Leave>();
		
		try {
		connection = DBConnection.getDBConnection();
		/*
		 * Before fetching employee it checks whether employee ID is
		 * available
		 */
		if ( DepartmentName!= null && !DepartmentName.isEmpty()) {
			/*
			 * Get employee by ID query will be retrieved from
			 * EmployeeMSDBQuery.xml
			 */
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ALL_DEPARTMENT_LEAVE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,DepartmentName);
		}

		ResultSet result = preparedStatement.executeQuery();

		while (result.next()) {
			
			Leave leave = new Leave();
			
			
			leave.setLeaveId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
			leave.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_TWO));
			leave.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_THREE));
			leave.setStarting_Date(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
			leave.setEnd_Date(result.getString(CommonConstants.COLUMN_INDEX_FIVE));
			leave.setL_Status(result.getString(CommonConstants.COLUMN_INDEX_SIX));
			leave.setDescription(result.getString(CommonConstants.COLUMN_INDEX_SEVEN));
			
			LeaveList.add(leave );
			
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
	return LeaveList;
}

	



	public ArrayList<Leave> getAllLeave() {
		
		ArrayList<Leave> LeaveList = new ArrayList<Leave>();
		try {
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_LEAVES));
		

			ResultSet result = preparedStatement.executeQuery();

			while (result.next()) {
				
				Leave leave = new Leave();
				
				
				leave.setLeaveId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
				leave.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_TWO));
				leave.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_THREE));
				leave.setStarting_Date(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
				leave.setEnd_Date(result.getString(CommonConstants.COLUMN_INDEX_FIVE));
				leave.setL_Status(result.getString(CommonConstants.COLUMN_INDEX_SIX));
				leave.setDescription(result.getString(CommonConstants.COLUMN_INDEX_SEVEN));
				
				LeaveList.add(leave );
				
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
		return LeaveList;
}


	
	


	//delete leave
	public void removeLeave(String leaveID) {

		
		// Before deleting check whether leave ID is available
				if (leaveID != null && !leaveID.isEmpty()) {
					/*
					 * Remove leave query will be retrieved from EmployeeMSDBQuery.xml
					 */
					try {
						
						connection = DBConnection.getDBConnection();
						preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_LEAVE));
						
						preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, leaveID);
						
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
	
	
	
	

	
	
	
	//update leave
	public void  updateLeave(String leaveID, Leave leave) {

		
		/*
		 * Before fetching leave it checks whether leave ID is available
		 */
		if (leaveID != null && !leaveID.isEmpty()) {
			/*
			 * Update Leave query will be retrieved from EmployeeMSDBQuery.xml
			 */
			try {
				connection = DBConnection.getDBConnection();
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_LEAVE));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, leave.getLeaveId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, leave.getEmployee());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, leave.getDepartment());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, leave.getStarting_Date());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, leave.getEnd_Date());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, leave.getL_Status());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, leave.getDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_EIGHT, leaveID);
				
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


private ArrayList<String> getLeaveIDs(){
	
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of LeaveIDs will be retrieved from EmployeeMSDBQuery.xml
		 */
		try {
			connection = DBConnection.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_LEAVE_IDS));
			
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



@Override
public String getEmployeeName(String EmployeeID) {
	
	
	String Employeename =null;

	if (EmployeeID != null && !EmployeeID.isEmpty() )
	{
		
		
		try 
		{
			
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_EMPLOYEE_NAME_FOR_LEAVE));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EmployeeID);
		  
			ResultSet result = preparedStatement.executeQuery();
			
			
			if(result.next())
			{
				Employeename=result.getString(1);
				
				
			}
			
			
			
		}
		catch (SQLException | SAXException | IOException | ParserConfigurationException| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
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
	return Employeename;
}
	

	
	

public String getLeaveEmployeeDepartment(String EmployeeID) {
	
	String DepID =null;

	if (EmployeeID != null && !EmployeeID.isEmpty() )
	{
		try 
		{
			
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_LEAVE_DEPARTMENT_NAME));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EmployeeID);
		  
			ResultSet result = preparedStatement.executeQuery();
			
			
			if(result.next())
			{
				DepID=result.getString(1);
				
			}
			
			
			
		}
		catch (SQLException | SAXException | IOException | ParserConfigurationException| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
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
			
	return DepID;
	
		
	}
	




public void updateLeavePermission(String LeaveID,String Status)
{
	
	
	

	if (LeaveID != null && !LeaveID.isEmpty() )
	{
		try 
		{
			
			connection = DBConnection.getDBConnection();
			
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_LEAVE_PERMISSION));
			
		  
			
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE,Status);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO,LeaveID);
			  preparedStatement.executeUpdate();
		
				
		}
		catch (SQLException | SAXException | IOException | ParserConfigurationException| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally {
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
			
	return;
	
	
	
	
}


	





}
