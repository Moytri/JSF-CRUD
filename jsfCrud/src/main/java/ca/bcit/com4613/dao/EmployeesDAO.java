package ca.bcit.com4613.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesDAO {

	String user, pass, driver, url, query;
	private Connection conn = null;
	private Statement statement = null;
	private ResultSet queryResults = null;
	
	public EmployeesDAO(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = password;
		this.conn = connect(driver, url, user, password);
	}
	
	public Connection connect(String driver, String url, String user, String password) {
		try {			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn :: " + conn);
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("FAILED TO CONNECT TO DATABASE");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public String getEmployeeById(String id) throws SQLException {
		String query = "Select * from A01062206_Employees Where ID = '" + id.trim() + "' ";
		statement = conn.createStatement();
		queryResults = statement.executeQuery(query);
				
		if (queryResults.next()) {
			return queryResults.getString("firstName") + " " +  queryResults.getString("lastName");
		}				
		return null;
	}

}
