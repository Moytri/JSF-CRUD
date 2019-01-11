package ca.bcit.com4613.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import ca.bcit.com4613.entity.Employee;
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
	
	
	private Employee employee;
	private static final Logger logger = Logger.getLogger(EmployeesBean.class);
	
	private LazyDataModel<Employee> employees;
	
	@PostConstruct
	public void init(){
		try {
			employees = new EmployeeLazyList();
		} catch (ClassNotFoundException | SQLException e) {
			logger.error("Couldn't get the list of employees " , e );
		}
	}
	
	public LazyDataModel<Employee> getAllEmployees() throws ClassNotFoundException, SQLException{
		return employees;
	}


	public Employee getEmployee() {
		if ( employee==null ){
			employee = new Employee();
		}
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	public void findEmployee() {
		setRequestedOperation("findEmployee");
		response = service.findEmployeeById(id);
	}

	public String getRequestedOperation() {
		return requestedOperation;
	}

	public void setRequestedOperation(String requestedOperation) {
		this.requestedOperation = requestedOperation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}			
}
