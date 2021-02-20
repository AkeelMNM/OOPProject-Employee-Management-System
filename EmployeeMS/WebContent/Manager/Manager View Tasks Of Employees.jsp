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
					<a href="#"><button class="buttoninsidemenu ">View Employees Tasks</button></a>


			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		
		<div class="left2" style="height: 410px;">

		<!-- Content Part -->
		
		<%
			String EmployeeID = null;
			String EmpName = null;
	
			//Accsessing the Cookie
			Cookie[] cookies = request.getCookies();
			for (Cookie aCookie : cookies) {
				if (aCookie.getName().equals("employeeid"))
				{
					EmployeeID = aCookie.getValue();
				}
			}
			
		
		%>
		
		<table border="1" cellpadding="12" style="margin-left: auto; margin-right: auto;">
		 <caption><h2>List of All Employees Tasks</h2></caption>
		  
		 	<tr>
               	<th>Employee Name</th>
	            <th>Department</th>
	           	<th>Task Name</th>
	            <th>Assign Date </th>
	            <th colspan="2">Edit</th>
	            
            </tr>
            <%
            taskService TaskService = new taskServiceImpt();
            String DepartmentName = TaskService.getDepNameByEmployeeID(EmployeeID);
			ArrayList<Tasks> arrayList = TaskService.getTasksinDeparment(DepartmentName);
			
			for(Tasks task : arrayList){
			%>
			 <tr>
				<td> <%=task.getEmployee() %> </td>
				<td> <%=task.getDepartment() %> </td>
				<td> <%=task.getTask_Name() %> </td>
				<td> <%=task.getAssignDate() %> </td>
				
				<td class="EditButton">
            		<form method="POST" action="${pageContext.request.contextPath}/Manager/Manager Edit Task.jsp" style="border: none;" >
            			<input type="hidden" name="TaskID" value="<%=task.getTaskId() %>">
            			<input type="image" src="${pageContext.request.contextPath}/Images/edit.png" alt="submit" width="25px" height="25px" > 
				 	</form>
				 </td>
				 
				 <td class="DeleteButton">
            		<form method="POST" action="${pageContext.request.contextPath}/deleteTaskServlet" style="border: none;">
            			<input type="hidden" name="TaskID" value="<%=task.getTaskId() %>"/>
				 		<input type="image" src="${pageContext.request.contextPath}/Images/delete.png" alt="submit" width="25px" height="25px"> 
				 	</form>
				 </td>			
			</tr>			
			<%	
			   }
            %>     
		</table>
		










		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		</div>




<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>