package com.ems.model;

public class Login {
	
	private int LoginID ;
	private String EmployeeId;
	private String Username;
	private String Password;
	private String Role;
	
	



	public String getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}

	public int getLoginID() {
		return LoginID;
	}
	
	public void setLoginID(int loginID) {
		LoginID = loginID;
	}
	
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public String getRole() {
		return Role;
	}
	
	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "Login [LoginID=" + LoginID + ", EmployeeId=" + EmployeeId + ", Username=" + Username + ", Password="
				+ Password + ", Role=" + Role + "]";
	}




	
	
	

}
