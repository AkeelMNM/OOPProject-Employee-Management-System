<%@page import="ems.Employee.service.HREmployeeServiceImpt"%>
<%@page import="ems.Employee.service.HREmployeeServiceInterface"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ems.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS & javaScript/AdminStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/AdminScript.js"></script>

<style type="text/css">
	
	.fieldset1 {
		Width:50%; }
	.fieldset2 {
		Width:50%; }
	Form {border:none;}
	div.form{
		padding:1%;
	}
	div.btn{
		padding-left: 16%;
		padding-bottom: 2%;
	}
	.button-success {
		border:none;
		outline:none;
		border-radius:10px;
		padding : .90% 2% ;
		width:25%;
		background-color : #0299a6 ;
		color : white ;
		font-size: 90%;
	}  
	.button-success:hover {
		cursor: pointer ;
		background: #60f04a;
		color:black;
	}
	
	.reset-button{
		border:none;
		outline:none;
		border-radius:10px;
		padding : .90% 2% ;
		width:25%;
		background-color : #0299a6 ;
		color : white ;
		font-size: 90%;
	}
	.reset-button:hover {
		cursor: pointer ;
		background: #d92626;
		color:black;
	}

</style>

</head>
<body>
<!-- Header Part -->
		<div class="bigDiv">
				<div class="logo">
					<img src="${pageContext.request.contextPath}/Images/MainLogo.png" alt="MainLogo" id="logo">
				</div>
				<div class="name">
					<h1>Employee Management System</h1>
				</div>
				<div class="manage">
					<div class="adminlogo">
						<img src="${pageContext.request.contextPath}/Images/AdminLogo.png" alt="MainLogo" id="logoA">
					</div>
					<div class="dropdown">
						  <button onclick="myFunction()" class="dropbtn">Manage</button>
								  <div id="myDropdown" class="dropdown-content">
										<a href="${pageContext.request.contextPath}/HR/HR Profile.jsp">View Profile</a>
										<a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
								  </div>
					</div>
					
				</div>
		</div>


<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
<div class="left3"> <h2>HR PANEL<hr></h2></div>
</div>

<div class="left">
		
			<div class="btn-group">
					<a href="${pageContext.request.contextPath}/HR/HR Attendance.jsp"><button class="button ">Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Tasks.jsp"><button class="button ">Tasks</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Employee Recruitment.jsp"><button class="button ">Employee Recruitment</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Leave.jsp"><button class="button ">Leave</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4">
			<div class="btn-group" style="padding-top:50px;">
					<a href="${pageContext.request.contextPath}/HR/HR Employee Recruitment.jsp"><button class="buttoninsidemenu ">View Department</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees.jsp"><button class="buttoninsidemenu ">View Employees</button></a>
					<a href="#"><button class="buttoninsidemenu ">Add New Department</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add Employee.jsp"><button class="buttoninsidemenu ">Add New Employees </button></a>
					

			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		
		<div class="left2" style="height:415px;">
		
		<!-- Content Part -->
		
		<div class="form">
			<form method="POST" action="${pageContext.request.contextPath}/AddDepartmentServlet">
				
				<fieldset class="fieldset1">
					<legend>Department Information:</legend>
					<table>
						<tr>
							<td>Department Name</td>
							<td><input type="text" name="Dep_Name" tabindex="1" required></td>
						</tr>
						<tr>
							<td>Location</td>
							<td><input type="text" name="Location" tabindex="2" required></td>
						</tr>
					</table>
				 </fieldset>
				 
				 		<!-- ************ 2nd fieldset  ************ -->
				 
				 <fieldset class="fieldset2"> 
				 	<legend>Create Department Manager:</legend>
					<table>
						<tr>
						<td for="EmployeeID" > Manager </td>
							<td> 
								<select id="EmployeeID"  name="Employee" tabindex="3" required> 
									<option> --Select-- </option> 
									<%
										HREmployeeServiceInterface viewEmployeeIDs = new HREmployeeServiceImpt();
										ArrayList<Employee> arrayList = viewEmployeeIDs.getEmployees();
									
										for(Employee employee : arrayList)
										{
									%>
								
									<option value="<%=employee.getFullname() %>">  <%=employee.getFullname() %>  </option> 			
										
									<%
										}
									%>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>Starting Date</td>
							<td><input type="Date" name="Starting_Date" tabindex="4" required></td>
						</tr>
						
						</table>
				</fieldset>
				
					<div class="btn">
						<br><br>
						<input type="submit" value="Add Department" class="button-success" tabindex="5" /> <br><br>
						<input type="reset" value="Reset" class="reset-button" tabindex="6" />
					</div>
		
			</form>
		</div>	


<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	</div>
		




<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>