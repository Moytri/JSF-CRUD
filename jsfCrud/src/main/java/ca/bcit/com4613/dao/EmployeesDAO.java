package ca.bcit.com4613.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ca.bcit.com4613.entity.Employee;
import ca.bcit.com4613.utility.Utility;

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
	}
	
	public void connect() {
		connect(driver, url, user, pass);
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
	
	public List<Employee> getEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		connect();
		String query = "Select * from A01062206_Employees";
		
		statement = conn.createStatement();
		queryResults = statement.executeQuery(query);
		
		while(queryResults.next()) {
			Employee emp = new Employee();
	
	    	emp.setID(queryResults.getString(1));
	    	emp.setFirstName(queryResults.getString(2));
	        emp.setLastName(queryResults.getString(3));
	        emp.setDob(Utility.convertFromSqlToUtil(queryResults.getDate(4)));
	        employees.add(emp);
		}

		return employees;
	}
	
	public String getEmployeeById(String id) throws SQLException {
		connect();
		String query = "Select * from A01062206_Employees Where ID = '" + id.trim() + "' ";
		statement = conn.createStatement();
		queryResults = statement.executeQuery(query);
				
		if (queryResults.next()) {
			return queryResults.getString("firstName") + " " +  queryResults.getString("lastName");
		}				
		return null;
	}

}
