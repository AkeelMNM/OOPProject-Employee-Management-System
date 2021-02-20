<%@page import="ems.Tasks.service.taskService"%>
<%@page import="ems.Tasks.service.taskServiceImpt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ems.model.Tasks"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS & javaScript/ManagerStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/ManagerScript.js"></script>
		
<style type="text/css">

.button-success {
		border:none;
		outline:none;
		border-radius:3px;
		padding :5px;
		background-color : #0299a6 ;
		color : white ;
		font-size: 90%;
		width: 120px
	}  
	.button-success:hover {
		cursor: pointer ;
		background: #60f04a;
		color:black;
	}

form{border: none;}

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
										<a href="${pageContext.request.contextPath}/Manager/Manager Profile.jsp">View Profile</a>
										<a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
								  </div>
					</div>
					
				</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
<div class="left3"> <h2>MANAGER PANEL<hr></h2></div>

<div class="left">
		
			<div class="btn-group">
					<a href="${pageContext.request.contextPath}/Manager/Manager Attendance.jsp"><button class="button ">Attendance</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Tasks.jsp"><button class="button ">Tasks</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Leave.jsp"><button class="button ">Leave Requests</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Department & Employees.jsp"><button class="button ">Department & Employees</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4">
			<div class="btn-group" style="padding-top:50px;">
					<a href="${pageContext.request.contextPath}/Manager/Manager Tasks.jsp"><button class="buttoninsidemenu ">Assign Tasks</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager View Tasks Of Employees.jsp"><button class="buttoninsidemenu ">View Employees Tasks</button></a>


			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		
		<div class="left2" style="height: 410px">

		<!-- Content Part -->

		<%
			String TaskID = request.getParameter("TaskID");
			
			taskService getTsk = new taskServiceImpt();
			Tasks task = getTsk.getTasksByID(TaskID);
		
		%>

		<div>
			<form method="POST" action="${pageContext.request.contextPath}/updateTaskServlet">
				<table border="1" cellpadding="12">
						
						<tr>
							<td>Task ID</td>
							<td> <input type="text" name="TaskId" disabled="disabled" 
										value="<%=task.getTaskId() %>"> </td>
						</tr>
						
						<tr>
							<td>Department : </td>
							<td> <input type="text" name="department" disabled="disabled"
										value="<%=task.getDepartment() %>" >
								<input type="hidden" name="department"
										value="<%=task.getDepartment() %>" > </td>
						</tr>
				
						<tr>
							<td>Task Name : </td>
							<td> <input type="text" name="TaskName" value="<%=task.getTask_Name() %>" > </td>
						</tr>
						
						<tr>
							<td> Employee : </td>
							<td> <input type="text" name="employee" value="<%=task.getEmployee() %>" > </td>
						</tr>
		
						<tr>
							<td>AssignDate : </td>
							<td><input type="date" name="AssignDate" value="<%=task.getAssignDate() %>" /></td>	
						</tr>   
				</table>
					<br><br>
					<input type="hidden" name="TaskId" value="<%=task.getTaskId()%>">
					<input type="submit" value="Update Details" class="button-success"> <br><br>
					
					<input type="reset" value="Reset" class="button-success">
				
			</form>	

		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		</div>




<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>