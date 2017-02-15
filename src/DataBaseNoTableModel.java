/**
 * @(#)DataBaseNoTableModel.java
 *
 *
 * @author 
 * @version 1.00 2014/10/17
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseNoTableModel
{
	static final String DATABASE_URL = "jdbc:mysql://localhost/ars";  // database url
   	static final String USERNAME = "ars";   // database name
   	static final String PASSWORD = "ars";  // database password
   	
	private Connection connection = null;  // variable to manage connection
    private Statement statement = null;    // variable to manage statement
    private	ResultSet resultSet = null;    // variable to manage results
    private String query = "";				
    private int resultSetUpdate;

    public DataBaseNoTableModel()
    {
    	try
    	{
    		connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD ); // establish connection to database
    		statement = connection.createStatement();  
    	}
    	catch( Exception sqlException )
    	{

    	}
    }

    public void setQuery( String q )
    {
    	query = q;
    }

    public ResultSet getResultSet()
    {
    	return resultSet;
    }
    
    public int getResultSetUpdate()
    {
    	return resultSetUpdate;
    }

    public void execute()
    {
    	try
    	{
    		resultSet = statement.executeQuery( query );
    	}
    	catch( SQLException sqlException )
    	{
    		sqlException.printStackTrace();
    	}
    }

    public void executeUpdate()
    {
    	try
    	{
    		resultSetUpdate = statement.executeUpdate( query );
    	}
    	catch( SQLException sqlException )
    	{
    		sqlException.printStackTrace();
    	}
    }

    public void close()
    {
    	try
    	{
    		statement.close();
    		connection.close();
    	}
    	catch( Exception exception )
    	{
    		exception.printStackTrace();
    	}
    }

}