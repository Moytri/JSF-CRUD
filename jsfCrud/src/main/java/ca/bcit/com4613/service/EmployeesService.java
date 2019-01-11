package ca.bcit.com4613.service;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import ca.bcit.com4613.dao.EmployeesDAO;
import ca.bcit.com4613.entity.Employee;
import ca.bcit.com4613.utility.ReadPropertiesFile;
import ca.bcit.com4613.utility.Response;

public class EmployeesService {

	String user, pass, driver, url;
	EmployeesDAO empDAO;
	
	public EmployeesService() {		
		user = ReadPropertiesFile.getString("db", "user");
		pass = ReadPropertiesFile.getString("db", "pass");
		driver = ReadPropertiesFile.getString("db", "driver");
		url = ReadPropertiesFile.getString("db", "url");
		empDAO = new EmployeesDAO(driver, url, user, pass);		
	}
	
	//returns all the employee in the table
	public List<Employee> getEmployees() {
		try {
			return empDAO.getEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Response findEmployeeById(String id) {
		String idValidationStatus = idValidation(id);
		
		if(idValidationStatus.equals("error")) 
			return new Response("901","invalid employee data!"); //for invalid user input (id) db operation is not performed
		
		try {
			String empName = empDAO.getEmployeeById(id);
			if(empName != null && !empName.isEmpty()) {
				return new Response("000", empName);
			}
			return new Response("801", "No match found");
		} 
		catch (SQLException e) {
			return new Response("801", "No match found");
		}
	}
	
	
	//filtering id according to the business requirement
	//send success or error status based on logic
	//this method is used to validate ID for add, search, and remove employee operation
	private String idValidation(String id) {

		String regex = "^A0[0-9]{7}";
		String status = "success";		
		boolean matches = Pattern.matches(regex, id);
		
		if(matches == false) {
			status = "error";
		}
		return status;
	}
}
