package ems.login.serviceAndservlet;

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

import com.ems.model.Login;
import com.ems.util.CommonConstants;
import com.ems.util.DBConnection;
import com.ems.util.QueryUtil;

/**
 * 
 * 
 * @author Akeel M.N.M
 * IT NO:IT19153414
 *
 */


public class LoginServiceImpt {
	
	
		//Initialize logger//
		public static final Logger log = Logger.getLogger(LoginServiceImpt.class.getName());
		
		private static Connection connection;
		
		private static Statement statement;
		
		private PreparedStatement preparedStatement;
		

		    
public boolean checkUser(String Username,String Password) 
		    {
		        boolean st = false;
		        try {
		        	
		        	connection = DBConnection.getDBConnection();
		        	
		        	preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_LOGIN));
					
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Username);
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, Password);
					
		            ResultSet rs =preparedStatement.executeQuery();
		            st = rs.next();

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
		        return st;                 
}   


	
public ArrayList<String> checkLogin(String Username,String Password)
{
			ArrayList<String> loginList = new ArrayList<String>();
			
			try
			{
					connection = DBConnection.getDBConnection();
					
					//Login Query will be Retrieve from EmployeeMSDBQuery.xml
					preparedStatement = connection .prepareStatement(QueryUtil.queryByID(CommonConstants.Query_ID_GET_LOGIN));
					
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Username);
					preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, Password);
					
					ResultSet result = preparedStatement.executeQuery();
					
						while(result.next())
						{
								
								loginList.add(result.getString(CommonConstants.COLUMN_INDEX_ONE));
								loginList.add(result.getString(CommonConstants.COLUMN_INDEX_TWO));
								loginList.add(result.getString(CommonConstants.COLUMN_INDEX_THREE));
								loginList.add(result.getString(CommonConstants.COLUMN_INDEX_FOUR));
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
			return loginList;
}

}
