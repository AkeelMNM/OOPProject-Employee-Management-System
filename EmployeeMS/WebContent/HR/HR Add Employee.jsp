<%@page import="ems.Department.service.HRDepartmentAndManagerServiceInterface"%>
<%@page import="ems.Department.service.HRDepartmentAndManagerServiceImpt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ems.model.Department"%>

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
		<div class="left4" style="height:630px;">
			<div class="btn-group" style="padding-top:50px;">
					<a href="${pageContext.request.contextPath}/HR/HR Employee Recruitment.jsp"><button class="buttoninsidemenu ">View Department</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees.jsp"><button class="buttoninsidemenu ">View Employees</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add Department.jsp"><button class="buttoninsidemenu ">Add New Department</button></a>
					<a href="#"><button class="buttoninsidemenu ">Add New Employees </button></a>
					

			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		
		<div class="left2" >
		
		<!-- Content Part -->
	
	<div class="form">
		<form method="POST" action="${pageContext.request.contextPath}/AddEmployeeServlet">
		
		
		<fieldset class="fieldset1">	
			<legend>Personal Information:</legend>
			<table>
				<tr>
					<td>Full Name : </td>
					<td><input type="text" name="name" tabindex="1" required></td>
				</tr>
				<tr>
					<td>Job Title : </td>
					<td><input type="text" name="JobTitle" tabindex="2" required></td>
				</tr>
				<tr>
					<td>Address : </td>
					<td><input type="text" name="Address" tabindex="3" required></td>
				</tr>
				<tr>
					<td>Gender : </td>
					<td><input type="radio" name="gender" value="Male" tabindex="4" checked="checked"> Male</td>	
					<td><input type="radio" name="gender" value="Female" tabindex="5" > Female</td>
				</tr>
				<tr>
					<td>Date of birth : </td>
					<td><input type="Date" name="DOB" tabindex="6" required pattern="[0-9]{9}[v|V]" ></td>
				</tr>
				<tr>
					<td>Marital Status : </td>
					<td><input type="radio" name="MaritalStatus" value="Single" tabindex="7" checked="checked"> Single </td>	
					<td><input type="radio" name="MaritalStatus" value="Married" tabindex="8" > Married</td>
				</tr>
				<tr>
					<td>NIC : </td>
					<td><input type="text" name="NIC" tabindex="9" required pattern="[0-9]{9}[v|V]" ></td>
				</tr>
				<tr>
					<td>Phone Number : </td>
					<td><input type="text" name="PhoneNo" tabindex="10" required pattern="[0-9]{10}" ></td>
				</tr>
				<tr>
					<td for="dep" >Department : </td>
					<td>
						<select id="dep"  name="department" tabindex="11" required> 
								<option> --Select-- </option> 
								<%
									HRDepartmentAndManagerServiceInterface iHRviewDepartment = new HRDepartmentAndManagerServiceImpt();
									ArrayList<Department> DepartmentList = iHRviewDepartment.getDepartments();
									
									for(Department dep : DepartmentList)
									{
								%>
							
								<option value="<%=dep.getName() %>">  <%=dep.getName() %>  </option> 			
									
								<%
									}
								%>
							</select>
					</td>
				</tr>
				<tr>
					<td>Salary : </td>
					<td><input type="text" name="salary" tabindex="12" required></td>
				</tr>
				<tr>
					<td>Joint Date : </td>
					<td><input type="date" name="Joint_date" tabindex="13" required></td>
				</tr>
			
			</table>
		</fieldset>	
			
		
		<fieldset class="fieldset2">
			<legend>Create Login for User:</legend>	
			<table>
				<tr>
					<td for="role"  > Role : </td>
					<td>  <select id="role" name="Role" tabindex="14" required> 
											<option value="Employee" > Employee </option> 
											<option value="Manager"> Manager </option>
											<option value="HR"> HR </option>
										
							</select>
					</td>
				</tr>
				
				<tr>
					<td>Email Address : </td>
					<td><input type="text" name="username" tabindex="15" required pattern="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A_Za-z]{2,3}" ></td>
				</tr>
				
				<tr>
					<td>Password : </td>
					<td><input type="password" name="pwd" id="pwd" onkeyup="check()" tabindex="16" required ></td>
				</tr>
				<tr>
					<td>Confirm Password : </td>
					<td><input type="password" name="confirm_pwd" id="confirm_pwd" onkeyup="check()" tabindex="16" required ></td>
				</tr>
				<tr>
					<td></td>
					<td> <span id='Pwd_msg'></span>  </td>
				</tr>
			</table>
		</fieldset>
		
			<div class="btn">
				<br><br>
				<input type="submit" value="Add Employee" class="button-success" tabindex="17">  <br><br>
				
				<input type="reset" value="Reset" class="reset-button" tabindex="18">
			</div>
			
		</form>
	</div>
	
	<!-- Confirm Password Check function -->
	<script>
		function check() 
		{
			if (document.getElementById('pwd').value == document.getElementById('confirm_pwd').value)
			{
				document.getElementById('Pwd_msg').style.color = '#0299a6';
				document.getElementById('Pwd_msg').innerHTML = 'Password matching';
			}
			else {
				document.getElementById('Pwd_msg').style.color = 'red';
				document.getElementById('Pwd_msg').innerHTML = 'Password not matching';
			}
		}		
	</script>

<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		</div>
		




<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>