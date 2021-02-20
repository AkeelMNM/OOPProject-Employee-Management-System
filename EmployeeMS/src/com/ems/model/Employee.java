package com.ems.model;

public class Employee {
	
	private String EmpID;
	private String Fullname;
	private String JobTitle;
	private String Address;
	private String Gender;
	private String NIC;
	private String phoneNo;
	private String JointDate;
	private String DOB;
	private String MaritalStatus;
	private double salary;
	private String Department;
	
	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getEmpID() {
		return EmpID;
	}
	
	public void setEmpID(String empID) {
		EmpID = empID;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getGender() {
		return Gender;
	}
	
	public void setGender(String gender) {
		Gender = gender;
	}
	
	public String getNIC() {
		return NIC;
	}
	
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getJointDate() {
		return JointDate;
	}
	
	public void setJointDate(String jointDate) {
		JointDate = jointDate;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getMaritalStatus() {
		return MaritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}

	@Override
	public String toString() {
		return "Employee [EmpID=" + EmpID + ", Fullname=" + Fullname + ", JobTitle=" + JobTitle + ", Address=" + Address
				+ ", Gender=" + Gender + ", NIC=" + NIC + ", phoneNo=" + phoneNo + ", JointDate=" + JointDate + ", DOB="
				+ DOB + ", MaritalStatus=" + MaritalStatus + ", salary=" + salary + ", Department=" + Department + "]";
	}





}
