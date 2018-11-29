package ca.bcit.com4613.entity;

import java.util.Date;

public class Employee {
	String ID;
	String firstName;
	String lastName;
	Date dob;
	
	public Employee() {

	}

	public Employee(String iD, String firstName, String lastName, Date dob) {
		this.ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + "]";
	}
	
}
