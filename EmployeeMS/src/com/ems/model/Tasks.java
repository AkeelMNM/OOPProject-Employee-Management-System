package com.ems.model;

public class Tasks {

	private String TaskId;
	private String Employee;
	private String Department;
	private String Task_Name;
	private String AssignDate;

	

	public String getEmployee() {
		return Employee;
	}

	public void setEmployee(String employee) {
		Employee = employee;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getTaskId() {
		return TaskId;
	}
	
	public void setTaskId(String taskId) {
		TaskId = taskId;
	}
	
	public String getTask_Name() {
		return Task_Name;
	}
	
	public void setTask_Name(String task_Name) {
		Task_Name = task_Name;
	}
	
	public String getAssignDate() {
		return AssignDate;
	}
	
	public void setAssignDate(String assignDate) {
		AssignDate = assignDate;
	}

	@Override
	public String toString() {
		return "Tasks [TaskId=" + TaskId + ", Employee=" + Employee + ", Department=" + Department + ", Task_Name="
				+ Task_Name + ", AssignDate=" + AssignDate + "]";
	}

	
	
}
