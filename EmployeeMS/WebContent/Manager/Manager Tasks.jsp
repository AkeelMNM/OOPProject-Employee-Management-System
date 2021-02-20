<%@page import="com.ems.model.Tasks"%>
<%@page import="ems.Tasks.service.taskServiceImpt"%>
<%@page import="ems.Tasks.service.taskService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ems.Employee.service.HREmployeeServiceImpt"%>
<%@page import="ems.Employee.service.HREmployeeServiceInterface"%>
<%@page import="com.ems.model.Employee"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
					<a href="#"><button class="button ">Tasks</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Leave.jsp"><button class="button ">Leave Requests</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Department & Employees.jsp"><button class="button ">Department & Employees</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4">
			<div class="btn-group" style="padding-top:50px;">
					<a href="#"><button class="buttoninsidemenu ">Assign Tasks</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager View Tasks Of Employees.jsp"><button class="buttoninsidemenu ">View Employees Tasks</button></a>


			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		
		<div class="left2" style="height: 410px;">

		<!-- Content Part -->

		<%
			String EmployeeID = null;
			String DepartmentName = null;
			
			//Accsessing the Cookie
			Cookie[] cookies = request.getCookies();
			for(Cookie aCookie : cookies){
				if(aCookie.getName().equals("employeeid"))
				{
					EmployeeID = aCookie.getValue();
				}
			}
			
			taskService getDepName = new taskServiceImpt();
			DepartmentName = getDepName.getDepNameByEmployeeID(EmployeeID);
			
			Tasks task = new Tasks();
			
		%>

		<h2 style="text-align: center;"><u>Assigning New Tasks For Department Employees</u></h2>
		<form method="POST" action="${pageContext.request.contextPath}/addTaskServlet" style="border: none;">
			
			<table>
				
				<tr>
					<td> <input type="hidden" name="department" value="<%=DepartmentName %>"> </td>
				</tr>
				<tr><td></td></tr>
				<tr>
					<td>Task Name : </td>
					<td><input type="text" name="TaskName" ></td>
				</tr>
				<tr><td></td></tr>
				<tr>
					<td for="EmployeeID" > Select Employee : </td>
					<td> 
							<select id="EmployeeID"  name="Employee" tabindex="3" required> 
								<option> --Select-- </option> 
								<%
									taskService viewEmployeesName = new taskServiceImpt();
									ArrayList<Employee> arrayList = viewEmployeesName.getDepartmentEmployeeNames(DepartmentName);
								
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
				<tr><td></td></tr>
				<tr>
					<td>AssignDate : </td>
					<td><input type="date" name="AssignDate" /></td>
				</tr>
				
				<tr><td></td></tr>
				<tr><td></td></tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Add Task" class="button-success" /> </td>
				</tr>
				<tr>	
					<td colspan="2"><input type="reset" value="Reset" class="button-success" /></td>
				</tr>
			
			</table>
			
			</form>
		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		</div>




<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>