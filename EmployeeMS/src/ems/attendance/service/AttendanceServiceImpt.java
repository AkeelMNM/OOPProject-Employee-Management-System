package ems.attendance.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.ems.model.Attendance;
import com.ems.model.Employee;
import com.ems.util.CommonConstants;
import com.ems.util.CommonUtil;
import com.ems.util.DBConnection;
import com.ems.util.QueryUtil;

/**
 * 
 * 
 * @author Akeel M.N.M
 * IT NO:IT19153414
 *
 */

public class AttendanceServiceImpt implements AttendanceService{
	
	//Initialize logger//
	public static final Logger log = Logger.getLogger(AttendanceServiceImpt.class.getName());
	
	private static Connection connection;
	
	private static Statement statement;
	
	private PreparedStatement preparedStatement;
	
	
	
	
	
	/** -------------    Add Attendance for Attendance table        ------------------------**/

@Override
public void addAttendance(Attendance attendance)
{
			
	String attendanceID=CommonUtil.generateAIDs(getAttendanceIDs());
			
		try
		{
				connection = DBConnection.getDBConnection();
				
				//Insert Attendance Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_INSERT_ATTENDANCE));
				connection.setAutoCommit(false);
				
				//Generate Attendance IDs
				attendance.setAttendanceID(attendanceID);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, attendance.getAttendanceID());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, attendance.getEmployee());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, attendance.getDepartment());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, attendance.getToday_Date());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, attendance.getStart_Time());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, attendance.getEnd_Time());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_SEVEN, attendance.getStatus());
				
				//Add Attendance
				preparedStatement.execute();
				connection.commit();
				
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
			
}

/**-------------------------           Get Employees that Don't have Attendance form Employee table          ----------------------**/
@Override
public ArrayList<Employee> getEmployeeListThatDontHaveAttendance()
{
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		try
		{
				connection = DBConnection.getDBConnection();
				
				//Get EmployeeList That Don't Have Attendance Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_EMPLOYEE_THAT_DONT_HAVE_ATTENDANCE));
				
				ResultSet result = preparedStatement.executeQuery();
				
				while(result.next())
				{
						Employee employee = new Employee();
						
						employee.setEmpID(result.getString(CommonConstants.COLUMN_INDEX_ONE));
						employee.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_TWO));
						employee.setFullname(result.getString(CommonConstants.COLUMN_INDEX_THREE));
						employee.setGender(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
						employee.setJointDate(result.getString(CommonConstants.COLUMN_INDEX_FIVE));
						
						
						employeeList.add(employee);
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
		return employeeList;
}


					/**--------------         Get Employee Name in Employee table       --------------------**/
@Override
public String getEmployeeName(String EmployeeID)
{
		String EmpName = null;
		//Checking the Employee id is available
	
		if(EmployeeID != null && !EmployeeID.isEmpty())
		{
			try 
			{
				connection = DBConnection.getDBConnection();
				
				// Get Employee Name Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_EMPLOYEE_NAME));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EmployeeID);
				
				
				ResultSet result = preparedStatement.executeQuery();
				
				if(result.next())
				{
					EmpName = result.getString(1); 
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
		return EmpName;

}

		/**--------------         Get Attendance ID in Attendance table       --------------------**/
@Override
public String getAttendanceID(String Employee)
{
		String AttID = null;
		//Checking the Employee id is available
			
		if(Employee != null && !Employee.isEmpty())
		{
			try 
			{
				connection = DBConnection.getDBConnection();
				
				// Get Attendance ID Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ATTENDANCE_ID));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Employee);
				
				
				ResultSet result = preparedStatement.executeQuery();
				
				if(result.next())
				{
					AttID = result.getString(1); 
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
		return AttID;

}
		
		/**---------------------          Get particular Attendance from Attendance table          -------------------**/
@Override		
public ArrayList<Attendance> getAttendanceByID(String attendanceID)
{
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
		
		try
		{
				connection = DBConnection.getDBConnection();
				
				//Get Attendance by ID Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ATTENDANCE));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, attendanceID);
				
				ResultSet result = preparedStatement.executeQuery();
				
					while(result.next())
					{
							Attendance attendance = new Attendance();
							
							attendance.setAttendanceID(result.getString(CommonConstants.COLUMN_INDEX_ONE));
							attendance.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_TWO));
							attendance.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_THREE));
							attendance.setToday_Date(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
							attendance.setStart_Time(result.getString(CommonConstants.COLUMN_INDEX_FIVE));
							attendance.setEnd_Time(result.getString(CommonConstants.COLUMN_INDEX_SIX));
							attendance.setStatus(result.getString(CommonConstants.COLUMN_INDEX_SEVEN));
							
							attendanceList.add(attendance);
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
		return attendanceList;
}

         /**-----------------------          Get All Attendance in a Department from Attendance table        ---------------------**/
@Override
public ArrayList<Attendance> getDepartmentAttendance(String DepartmentName)
{
		ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
		
		try
		{
					connection = DBConnection.getDBConnection();
					
					// Get All Attendance in a Department Query will be Retrieve from EmployeeMSDBQuery.xml
					preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ALL_ATTENDANCE_IN_DEPARTMENT));
					
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, DepartmentName);
					
					ResultSet result = preparedStatement.executeQuery();
					
					while(result.next())
					{
							Attendance attendance = new Attendance();
							
							attendance.setAttendanceID(result.getString(CommonConstants.COLUMN_INDEX_ONE));
							attendance.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_TWO));
							attendance.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_THREE));
							attendance.setToday_Date(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
							attendance.setStart_Time(result.getString(CommonConstants.COLUMN_INDEX_FIVE));
							attendance.setEnd_Time(result.getString(CommonConstants.COLUMN_INDEX_SIX));
							attendance.setStatus(result.getString(CommonConstants.COLUMN_INDEX_SEVEN));
							
							attendanceList.add(attendance);
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
		return attendanceList;
}


		/**-------------------------           Get All Attendance from Attendance table          ----------------------**/
@Override		
public ArrayList<Attendance> getAttendance()
{
	ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
	
	try
	{
				connection = DBConnection.getDBConnection();
				
				//Get All Attendance Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_ALL_ATTENDANCE));
				
				ResultSet result = preparedStatement.executeQuery();
				
				while(result.next())
				{
						Attendance attendance = new Attendance();
						
						attendance.setAttendanceID(result.getString(CommonConstants.COLUMN_INDEX_ONE));
						attendance.setEmployee(result.getString(CommonConstants.COLUMN_INDEX_TWO));
						attendance.setDepartment(result.getString(CommonConstants.COLUMN_INDEX_THREE));
						attendance.setToday_Date(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
						attendance.setStart_Time(result.getString(CommonConstants.COLUMN_INDEX_FIVE));
						attendance.setEnd_Time(result.getString(CommonConstants.COLUMN_INDEX_SIX));
						attendance.setStatus(result.getString(CommonConstants.COLUMN_INDEX_SEVEN));
						
						attendanceList.add(attendance);
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
	return attendanceList;
}

			/**--------------         Set Work Starting time and End Time to Null in Attendance table       --------------------**/
@Override
public void setAttendanceStartTimeEndTimeToNull()
{
			
		try 
		{
					connection = DBConnection.getDBConnection();
					
					//Set Work Starting time and End Time to Null Query will be Retrieve from EmployeeMSDBQuery.xml
					preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_SET_ATTENDANCE_START_TIME_END_TIME_TO_NULL));
					
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
			
		
		/**--------------         Update Work Starting time in Attendance table       --------------------**/
@Override		
public ArrayList<Attendance> updateAttendanceStartTime(String attendanceID,Attendance attendance)
{
	//Checking the attendance id is available
			
	if(attendanceID != null && !attendanceID.isEmpty())
	{
		String TDate =attendance.getToday_Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try 
		{
			date = sdf.parse(TDate);
		} catch (ParseException e) 
		{
			log.log(Level.SEVERE,e.getMessage());
		}
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
			try 
			{
					connection = DBConnection.getDBConnection();
					
					//Update Work Starting time Query will be Retrieve from EmployeeMSDBQuery.xml
					preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_UPDATE_ATTENDANCE_START_TIME));
					
					preparedStatement.setDate(CommonConstants.COLUMN_INDEX_ONE, sqlStartDate);
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, attendance.getStart_Time());
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, attendance.getStatus());
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, attendance.getAttendanceID());
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
	return getAttendanceByID(attendanceID);
			
}

				/**--------------         Update Work Ending time in Attendance table       --------------------**/
@Override
public ArrayList<Attendance> updateAttendanceEndTime(String attendanceID,Attendance attendance)
{
		//Checking the attendance id is available
			
		if(attendanceID != null && !attendanceID.isEmpty())
		{
			try 
			{
					connection = DBConnection.getDBConnection();
					
					//Update Work Ending time Query will be Retrieve from EmployeeMSDBQuery.xml
					preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_UPDATE_ATTENDANCE_END_TIME));
					
		
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, attendance.getEnd_Time());
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, attendance.getAttendanceID());
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
		return getAttendanceByID(attendanceID);
			
}
		
		/**-----------------------              Remove An Attendance form Attendance table          --------------------**/
@Override	
public void removeAttendance(String attendanceID)
{
	//Checking the attendance id is available
			
	if(attendanceID != null && !attendanceID.isEmpty())
	{
		try 
		{
				connection = DBConnection.getDBConnection();
				
				//Delete An Attendance Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_REMOVE_ATTENDANCE));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, attendanceID);
				
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

		/**--------------         Get An Department ID in Employee table       --------------------**/
@Override
public String getDepartmentID(String EmployeeName)
{
		String DepName = null;
		//Checking the Employee id is available
			
		if(EmployeeName != null && !EmployeeName.isEmpty())
		{
			try 
			{
				connection = DBConnection.getDBConnection();
				
				// Get Department ID Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_MANAGERS_DEPAERMENT_ID));
				
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, EmployeeName);
				
				
				ResultSet result = preparedStatement.executeQuery();
				
				if(result.next())
				{
					DepName = result.getString(1); 
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
		return DepName;

}

		
		
		/**---------------------------                 Array of Attendance id list will be return            ---------------------------**/
		
private ArrayList<String> getAttendanceIDs()
{
		ArrayList<String> arraylist = new ArrayList<String>();
			
		try {
				
				connection = DBConnection.getDBConnection();
				
				//Get All Attendance ID Query will be Retrieve from EmployeeMSDBQuery.xml
				preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_ALL_ATTENDANCE_IDS));
				
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
