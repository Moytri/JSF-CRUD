package ca.bcit.com4613.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ca.bcit.com4613.entity.Employee;

public class SortHelper implements Serializable {

	private static final long serialVersionUID = 1L;
	PaginationHelper<Employee> helper = new PaginationHelper<>();
	
	public SortHelper() {
		
	}
	
	//ascending employee
	public void sortFirstNameASC(List<Employee> employees) {	     
	      Collections.sort(employees, new Comparator<Employee>() {
	        @Override
	        public int compare(Employee emp1, Employee emp2) {
	          return emp1.getFirstName().compareTo(emp2.getFirstName());
	        }
	      });
	      setEmployees(employees);
	 }
	
	//descending employee
	public void sortFirstNameDESC(List<Employee> employees) {
      Collections.sort(employees, new Comparator<Employee>() {
        @Override
        public int compare(Employee emp1, Employee emp2) {
          return emp2.getFirstName().compareTo(emp1.getFirstName());
        }
      });
      setEmployees(employees);	    
	}

	public void setEmployees(List<Employee> employees) {
		helper.setEmps(employees);
	}
}


