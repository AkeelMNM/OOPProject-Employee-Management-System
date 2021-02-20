<%@page import="ems.Department.service.HRDepartmentAndManagerServiceInterface"%>
<%@page import="ems.Department.service.HRDepartmentAndManagerServiceImpt"%>
<%@page import="com.ems.model.Manager"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS & javaScript/AdminStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/AdminScript.js"></script>

<style type="text/css">
	table {
	  width: 50%;
	}
	td {
	  padding: 8px;
	}
	tr:nth-child(even){background-color: #f2f2f2}
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
					<a href="${pageContext.request.contextPath}/HR/HR Add Department.jsp"><button class="buttoninsidemenu ">Add New Department</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add Employee.jsp"><button class="buttoninsidemenu ">Add New Employees </button></a>
					

			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		
	<div class="left2" style="height:420px;">
		
		<!-- Content Part -->
		
		<%
			String ManagerId = request.getParameter("ManagerID");
			HRDepartmentAndManagerServiceInterface getManagerDetailsByID = new HRDepartmentAndManagerServiceImpt();
			Manager manager = getManagerDetailsByID.getManagerByID(ManagerId);
			
			request.setAttribute("Manager", manager);
		%>
	<div class="form">
		<form method="POST" action="${pageContext.request.contextPath}/HRUpdateManagerServlet">
			<table>
	
				<tr>
					<td> Manager ID </td>
					<td><input type="text" name="ManagerID" disabled="disabled" 
								value="<%=manager.getManagerId() %>"> </td>
				</tr>
				<tr>
					<td>Manager </td>
					<td><input type="text" name="Employee" tabindex="1" value="<%=manager.getEmployee() %>" ></td>
				</tr>
				<tr>
					<td>Department </td>
					<td><input type="text" name="Department" tabindex="2" value="<%=manager.getDepartment() %>" ></td>
				</tr>
				<tr>
					<td>Starting Date </td>
					<td><input type="date" name="Starting_Date" tabindex="3" value="<%=manager.getStartingDate() %>" ></td>
				</tr>
				<tr>
					<td> Login Id</td>
					<td><input type="text" name="loginID" tabindex="4" disabled="disabled" 
								value="<%=manager.getLoginId() %>" ></td>
				</tr>
			</table>
			
				<div class="btn">
					<br><br>
					<input type="hidden" name="ManagerID" value="<%=manager.getManagerId() %>">
					<input type="submit" value="Update Details" class="button-success" tabindex="6"> <br><br>
					
					<input type="reset" value="Reset" class="reset-button" tabindex="7">
				</div>
		</form>
	</div>


<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		
	</div>
		




<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>


