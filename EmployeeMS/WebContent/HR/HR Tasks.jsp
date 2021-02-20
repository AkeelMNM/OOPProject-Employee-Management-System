<%@page import="ems.Tasks.service.taskService"%>
<%@page import="ems.Tasks.service.taskServiceImpt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ems.model.Tasks"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS & javaScript/AdminStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/AdminScript.js"></script>
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
					<a href="#"><button class="button ">Tasks</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Employee Recruitment.jsp"><button class="button ">Employee Recruitment</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Leave.jsp"><button class="button ">Leave</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		
		<div class="left5" style="height: 410px;">
		
		<!-- Content Part -->

		<%
			String EmployeeID = null;
			
			//Accsessing the Cookie
			Cookie[] cookies = request.getCookies();
			for(Cookie aCookie : cookies){
				if(aCookie.getName().equals("employeeid"))
				{
					EmployeeID = aCookie.getValue();
				}
			}
			
		%>		
		
		<div>
			<table border="1" cellpadding="12" style="margin-left: auto; margin-right: auto;">
			 <caption><h2>List of Tasks</h2></caption>
			  <tr>
	                <th>Employee Name</th>
	                <th>Department</th>
	                <th>Task Name</th>
	                <th>Assign Date </th>
	            </tr>
	            <%
	            taskService EmployeeTaskList = new taskServiceImpt();
				ArrayList<Tasks> arrayList = EmployeeTaskList.getTasksInEmployeeID(EmployeeID);
				
				for(Tasks task : arrayList){
				%>
				 <tr>
					<td> <%=task.getEmployee() %> </td>
					<td> <%=task.getDepartment() %> </td>
					<td> <%=task.getTask_Name() %></td>
					<td> <%=task.getAssignDate() %> </td>	
				</tr>			
				<%	
				   }
	            %>     
			</table>
		</div>
		









		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		</div>




<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>