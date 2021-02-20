package ems.attendanceStatus.service;

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

import com.ems.model.AttendanceStatus;
import com.ems.util.CommonConstants;
import com.ems.util.CommonUtil;
import com.ems.util.DBConnection;
import com.ems.util.QueryUtil;

import ems.attendance.service.AttendanceServiceImpt;

/**
 * 
 * 
 * @author Akeel M.N.M
 * IT NO:IT19153414
 *
 */

public class AttendanceStatusServiceImpt implements AttendanceStatusService {
	
		//Initialize logger//
		public static final Logger log = Logger.getLogger(AttendanceServiceImpt.class.getName());
		
		private static Connection connection;
		
		private static Statement statement;
		
		private PreparedStatement preparedStatement;

	
	
	/**----------------      Add AttendanceStautus for AttendanceStautus table      -----------------**/
@Override	
public void addAttendanceStatus(AttendanceStatus attendanceStatus)
{
	String attendanceStatusID=CommonUtil.generateAtSIDs(getAttendanceStatusIDs());
		
	try
	{
			connection = DBConnection.getDBConnection();
			
			// Insert AttendanceStatus Query will be Retrieve from EmployeeMSDBQuery.xml
			preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_INSERT_ATTENDANCESTATUS));
			connection.setAutoCommit(false);
			
			//Generate Attendance IDs
			attendanceStatus.setAttStId(attendanceStatusID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, attendanceStatus.getAttStId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, attendanceStatus.getAttId());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, attendanceStatus.getEmployee());
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, attendanceStatus.getDepartment());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, attendanceStatus.getNoWorkingDays());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SIX, attendanceStatus.getNoLeaveDays());

			//Add Attendance
			preparedStatement.execute();
			connection.commit();
			
	} catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e) {
			
			log.log(Level.SEVERE,e.getMessage());
	}
	finally
	{
			//Closing DB Connection and Prepared statement
			try 
			{	
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
				if(connection != null)
				{
					connection.close();
				}
				
			}
			catch (SQLException e)
			{
				log.log(Level.SEVERE,e.getMessage());
			}
			
	}
}

/**--------------         Get AttendanceStatus ID in AttendanceStatus table       --------------------**/
@Override
public String getAttendanceStatusID(String AttendanceID)
{
		String AttStID = null;
		//Checking the Employee id is available
			
		if(AttendanceID != null && !AttendanceID.isEmpty())
		{
			try 
			{
				connection = DBConnection.getDBConnection();
				
				// Get AttendanceStatus ID Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ATTENDANCE_STATUS_ID));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, AttendanceID);
				
				
				ResultSet result = preparedStatement.executeQuery();
				
				if(result.next())
				{
					AttStID = result.getString(1); 
				}
			}
			catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e)
			{
				
				log.log(Level.SEVERE,e.getMessage());
			}
			finally
			{
				//Closing DB Connection and Prepared statement
				try 
				{	
					if(preparedStatement != null)
					{
						preparedStatement.close();
					}
					if(connection != null)
					{
						connection.close();
					}
					
				}
				catch (SQLException e)
				{
					log.log(Level.SEVERE,e.getMessage());
				}
				
			}
		}
		return AttStID;

}
	
	/**--------------            Get a Particular AttendanceStautus form AttendanceStautus table       ---------------**/
@Override	
public ArrayList<AttendanceStatus> getAttendanceStatusByID(String attendanceStatusId)
{
		ArrayList<AttendanceStatus> attendanceStatusList = new ArrayList<AttendanceStatus>();
		
		try
		{
				connection = DBConnection.getDBConnection();
				
				//Get AttendanceStatus by ID Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ATTENDANCESTATUS));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, attendanceStatusId);
				
				ResultSet result = preparedStatement.executeQuery();
				
					while(result.next())
					{
		
							AttendanceStatus attendanceStatus = new AttendanceStatus();
							
							attendanceStatus.setAttStId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
							attendanceStatus.setAttId(result.getString(CommonConstants.COLUMN_INDEX_TWO));
							attendanceStatus.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_THREE));
							attendanceStatus.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
							attendanceStatus.setNoWorkingDays(result.getInt(CommonConstants.COLUMN_INDEX_FIVE));
							attendanceStatus.setNoLeaveDays(result.getInt(CommonConstants.COLUMN_INDEX_SIX));
							
							attendanceStatusList.add(attendanceStatus);
					}
				
		} 
		catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e) {
				
				log.log(Level.SEVERE,e.getMessage());
		}
		finally
		{
				//Closing DB Connection and Prepared statement
				try 
				{	
					if(preparedStatement != null)
					{
						preparedStatement.close();
					}
					if(connection != null)
					{
						connection.close();
					}
					
				}
				catch (SQLException e)
				{
					log.log(Level.SEVERE,e.getMessage());
				}
				
		}
		return attendanceStatusList;
			
}

	/**-----------------------          Get All AttendanceStatus in a Department from AttendanceStatus table        ---------------------**/
@Override
public ArrayList<AttendanceStatus> getDepartmentAttendanceStatus(String DepartmentName)
{
		ArrayList<AttendanceStatus> attendanceStatusList = new ArrayList<AttendanceStatus>();
		
		try
		{
					connection = DBConnection.getDBConnection();
					
					// Get All Attendance in a Department Query will be Retrieve from EmployeeMSDBQuery.xml
					preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ALL_ATTENDANCESTATUS_IN_DEPARTMENT));
					
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, DepartmentName);
					
					ResultSet result = preparedStatement.executeQuery();
					
					while(result.next())
					{
							AttendanceStatus attendancestatus = new AttendanceStatus();
							
							attendancestatus.setAttStId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
							attendancestatus.setAttId(result.getString(CommonConstants.COLUMN_INDEX_TWO));
							attendancestatus.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_THREE));
							attendancestatus.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
							attendancestatus.setNoWorkingDays(result.getInt(CommonConstants.COLUMN_INDEX_FIVE));
							attendancestatus.setNoLeaveDays(result.getInt(CommonConstants.COLUMN_INDEX_SIX));
							
							attendanceStatusList.add(attendancestatus);
					}
					
		} 
		catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e) {
					
					log.log(Level.SEVERE,e.getMessage());
		}
		finally
		{
					//Closing DB Connection and Prepared statement
					try 
					{	
						if(preparedStatement != null)
						{
							preparedStatement.close();
						}
						if(connection != null)
						{
							connection.close();
						}
						
					}
					catch (SQLException e)
					{
						log.log(Level.SEVERE,e.getMessage());
					}
					
		}
		return attendanceStatusList;
}
	
	/**-------------------        Get All AttendanceStautus form AttendanceStautus table          ----------------------------**/
@Override	
public ArrayList<AttendanceStatus> getAttendanceStatus()
{
		ArrayList<AttendanceStatus> attendanceStatusList = new ArrayList<AttendanceStatus>();
		
		try
		{
			connection = DBConnection.getDBConnection();
			
			//Get All AttendanceStatus Query will be Retrieve from EmployeeMSDBQuery.xml
			preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ALL_ATTENDANCESTATUS));
			
			ResultSet result = preparedStatement.executeQuery();
			
				while(result.next())
				{
	
						AttendanceStatus attendanceStatus = new AttendanceStatus();
						
						attendanceStatus.setAttStId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
						attendanceStatus.setAttId(result.getString(CommonConstants.COLUMN_INDEX_TWO));
						attendanceStatus.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_THREE));
						attendanceStatus.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
						attendanceStatus.setNoWorkingDays(result.getInt(CommonConstants.COLUMN_INDEX_FIVE));
						attendanceStatus.setNoLeaveDays(result.getInt(CommonConstants.COLUMN_INDEX_SIX));
						
						attendanceStatusList.add(attendanceStatus);
				}
			
		} 
		catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e) {
			
			log.log(Level.SEVERE,e.getMessage());
		}
		finally
		{
			//Closing DB Connection and Prepared statement
			try 
			{	
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
				if(connection != null)
				{
					connection.close();
				}
				
			}
			catch (SQLException e)
			{
				log.log(Level.SEVERE,e.getMessage());
			}
			
		}
		return attendanceStatusList;
		
}

	
	/**---------------------       Update Numbers of Working Days in AttendanceStautus table      -----------------**/
@Override
public ArrayList<AttendanceStatus> updateAttendanceStatusWorkingDays(String attendanceStatusId,AttendanceStatus attendanceStatus)
{
	//Checking the attendance id is available
		
	if(attendanceStatusId != null && !attendanceStatusId.isEmpty())
	{
			try 
			{
				connection = DBConnection.getDBConnection();
				
				//Incrementing the Number of working days with one
				int WorkingDays = attendanceStatus.getNoWorkingDays() + 1 ;
				
				//Update Numbers of Working Days Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_UPDATE_ATTENDANCESTATUS_NO_WORKING_DAYS));
				
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, WorkingDays);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, attendanceStatus.getAttStId());
				preparedStatement.executeUpdate();
			}
			catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e)
			{
				
				log.log(Level.SEVERE,e.getMessage());
			}
			finally
			{
				//Closing DB Connection and Prepared statement
				try 
				{	
					if(preparedStatement != null)
					{
						preparedStatement.close();
					}
					if(connection != null)
					{
						connection.close();
					}
					
				}
				catch (SQLException e)
				{
					log.log(Level.SEVERE,e.getMessage());
				}
				
			}
	}
	return getAttendanceStatusByID(attendanceStatusId);
		
}

		/**---------------------      Update AttendanceStatus LeaveDays of Absent Employees in AttendanceStautus table      -----------------**/
@Override
public void updateAttendanceStatusLeaveDays()
{
			
				try 
				{
					connection = DBConnection.getDBConnection();
					
					//Get All Attendance of Employees who are Absent Query will be Retrieve from EmployeeMSDBQuery.xml
					preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ATTENDANCE_WHOS_ABSENT));
					
					ResultSet result = preparedStatement.executeQuery();
					
					ArrayList<AttendanceStatus> attendanceStatusList = new ArrayList<AttendanceStatus>();
					
					while(result.next())
					{
		
							AttendanceStatus attendanceStatus = new AttendanceStatus();
							
							attendanceStatus.setAttStId(result.getString(CommonConstants.COLUMN_INDEX_ONE));
							attendanceStatus.setNoLeaveDays(result.getInt(CommonConstants.COLUMN_INDEX_TWO));
							
							attendanceStatusList.add(attendanceStatus);
					}
					
					//Incrementing existing No of leave by one for the Absent Employee
					for (int i = 0; i < attendanceStatusList.size(); i ++) {
					    int oldVal = attendanceStatusList.get(i).getNoLeaveDays();
					    int newVal = oldVal + 1;
					    attendanceStatusList.get(i).setNoLeaveDays(newVal);
					}
					
					//Update Numbers of Leave Days Query will be Retrieve from EmployeeMSDBQuery.xml
					preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_UPDATE_ATTENDANCESTATUS_NO_LEAVE_DAYS));
					
					for (int i = 0; i < attendanceStatusList.size(); i ++)
					{
							preparedStatement.setInt(CommonConstants.COLUMN_INDEX_ONE, attendanceStatusList.get(i).getNoLeaveDays());
							preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, attendanceStatusList.get(i).getAttStId());
							preparedStatement.executeUpdate();
					}
				}
				catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e)
				{
					
					log.log(Level.SEVERE,e.getMessage());
				}
				finally
				{
					//Closing DB Connection and Prepared statement
					try 
					{	
						if(preparedStatement != null)
						{
							preparedStatement.close();
						}
						if(connection != null)
						{
							connection.close();
						}
						
					}
					catch (SQLException e)
					{
						log.log(Level.SEVERE,e.getMessage());
					}
					
				}
}


		/**--------------         Set Working Days and Leave Days to Null in AttendanceStatus table       --------------------**/
@Override
public void resetAttendanceStatusWorkingandLeaveDays()
{

		try 
		{
				connection = DBConnection.getDBConnection();
				
				//Set Work Starting time and End Time to Null Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_SET_ATTENDANCESTATUS_WORKINGDAYS_LEAVEDAYS_TO_NULL));
				
				preparedStatement.executeUpdate();
		}
		catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e)
		{
				
				log.log(Level.SEVERE,e.getMessage());
		}
		finally
		{
				//Closing DB Connection and Prepared statement
				try 
				{	
					if(preparedStatement != null)
					{
						preparedStatement.close();
					}
					if(connection != null)
					{
						connection.close();
					}
					
				}
				catch (SQLException e)
				{
					log.log(Level.SEVERE,e.getMessage());
				}
				
		}
}
	
	/**--------      Remove An AttendanceStautus form AttendanceStautus table     --------**/
@Override	
public void removeAttendanceStautus(String attendanceStatusID)
{
	if(attendanceStatusID != null && !attendanceStatusID.isEmpty())
	{
			try 
			{
				connection = DBConnection.getDBConnection();
				
				//Delete An AttendanceStatus Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_REMOVE_ATTENDANCESTATUS));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, attendanceStatusID);
				
				preparedStatement.executeUpdate();
			}
			catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e)
			{
				
				log.log(Level.SEVERE,e.getMessage());
			}
			finally
			{
				//Closing DB Connection and Prepared statement
				try 
				{	
					if(preparedStatement != null)
					{
						preparedStatement.close();
					}
					if(connection != null)
					{
						connection.close();
					}
					
				}
				catch (SQLException e)
				{
					log.log(Level.SEVERE,e.getMessage());
				}
				
			
			}
	}
}
	
	/**---------------------             Array of AttendanceStatus id list will be return         ---------------**/

private ArrayList<String> getAttendanceStatusIDs()
{
		ArrayList<String> arraylist = new ArrayList<String>();
				
		try {
					
					connection = DBConnection.getDBConnection();
					
					//Get All AttendanceStatus IDs Query will be Retrieve from EmployeeMSDBQuery.xml
					preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_ALL_ATTENDANCESTATUS_IDS));
					
					ResultSet result = preparedStatement.executeQuery();
					while(result.next())
					{
						arraylist.add(result.getString(CommonConstants.COLUMN_INDEX_ONE));
					}	
		} 
		catch (IOException | ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e)
		{	
					log.log(Level.SEVERE,e.getMessage());
		}
		finally
		{
					//Closing DB Connection and Prepared statement
					try 
					{
						
						if(preparedStatement != null)
						{
							preparedStatement.close();
						}
						if(connection != null)
						{
							connection.close();
						}
						
					} 
					catch (SQLException e) 
					{
						log.log(Level.SEVERE,e.getMessage());
					}
					
		}
		return arraylist;
}

}
