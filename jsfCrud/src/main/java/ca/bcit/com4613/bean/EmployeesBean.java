package ca.bcit.com4613.bean;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import ca.bcit.com4613.service.EmployeesService;
import ca.bcit.com4613.utility.Response;

@ManagedBean (name = "employeesBean")
@SessionScoped
public class EmployeesBean implements Serializable {


	private static final long serialVersionUID = 1L;
	String id;
	String firstName;
	String lastName;
	Date dob;
	String role;
	Response response;
	String requestedOperation;
	
	EmployeesService service = new EmployeesService();
	
	public void findEmployee() {
		setRequestedOperation("findEmployee");
		response = service.findEmployeeById(id);
	}

	public EmployeesService getService() {
		return service;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setService(EmployeesService service) {
		this.service = service;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDob() {
		return dob;
	}

	public String getRole() {
		return role;
	}

	public Response getResponse() {
		return response;
	}

	public String getRequestedOperation() {
		return requestedOperation;
	}

	public void setRequestedOperation(String requestedOperation) {
		this.requestedOperation = requestedOperation;
	}
				
}
