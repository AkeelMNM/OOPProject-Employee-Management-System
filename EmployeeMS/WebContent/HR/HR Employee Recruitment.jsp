<%@page import="com.ems.model.Manager"%>
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

<style>
	Form {border:none;}
	table {
	  border-collapse: collapse;
	  margin:0 auto;
	  width: 75%;
	}
	
	th, td {
	  text-align: left;
	  padding: 10px;
	}
	
	tr:nth-child(even){background-color: #f2f2f2}
	
	th {
	  background-color: #61605a;
	  color: white;
	}
	
	.Button {
		padding: 10px;
 		padding-right:1%;
 		padding-left: 1%;
 		width: 25px;
   		height: 25px;
   		border:none !important;	
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
					<a href="#"><button class="button ">Employee Recruitment</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Leave.jsp"><button class="button ">Leave</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4" style="height:535px;">
			<div class="btn-group" style="padding-top:50px;">
			
					<a href="#"><button class="buttoninsidemenu ">View Department</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees.jsp"><button class="buttoninsidemenu ">View Employees</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add Department.jsp"><button class="buttoninsidemenu ">Add New Department</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add Employee.jsp"><button class="buttoninsidemenu ">Add New Employees </button></a>
					
					


			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		<div class="left2">
		
		<!-- Content Part -->

		<table>
			<caption><h2>List of Department</h2></caption>
		  	<tr>
                <th>Department ID</th>
                <th>Name</th>
                <th>Location</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
			
			<%
				HRDepartmentAndManagerServiceInterface iHRviewDepartment = new HRDepartmentAndManagerServiceImpt();
				ArrayList<Department> DepartmentList = iHRviewDepartment.getDepartments();
						
				for(Department dep : DepartmentList)
				{
			%>
			<tr> 
            	<td> <%=dep.getDepID() %> </td>
            	<td> <%=dep.getName() %></td>
            	<td> <%=dep.getLocation() %></td>
            	
            	<td class="Button">
            		<form method="POST" action="HR Edit Department.jsp">
            			<input type="hidden" name="DepartmentID" value="<%=dep.getDepID() %>"/>
				 		<input type="image" src="${pageContext.request.contextPath}/Images/edit.png" alt="submit" width="25px" height="25px" >
				 	</form>
				 </td>
				 
				 <td class="Button">
            		<form method="POST" action="${pageContext.request.contextPath}/HRDeleteDepartmentServlet">
            			<input type="hidden" name="DepartmentID" value="<%=dep.getDepID() %>"/>
				 		<input type="image" src="${pageContext.request.contextPath}/Images/delete.png" alt="submit" width="25px" height="25px"> 
				 	</form>
				 </td>	
				 
            </tr>
            <%	
			   }
            %>
		</table>


	<!-- ++++++++++++++++++++++++++++ Manager Table +++++++++++++++++++++++++++++++ -->

		<table>
			<caption><h2>List of Department Managers </h2></caption>
		  	<tr>
                <th>Department Name</th>
                <th>Manager Name</th>
                <th>Starting Date</th>
                <th>Edit</th>
            </tr>
			
			<%
				HRDepartmentAndManagerServiceInterface iHRviewManager = new HRDepartmentAndManagerServiceImpt();
				ArrayList<Manager> ManagerList = iHRviewManager.getManagers();
						
				for(Manager manager : ManagerList)
				{
			%>
			<tr> 
            	<td> <%=manager.getDepartment() %> </td>
            	<td> <%=manager.getEmployee() %></td>
            	<td> <%=manager.getStartingDate() %></td>
            	
            	<td class="Button">
            		<form method="POST" action="HR Edit Manager.jsp">
            			<input type="hidden" name="ManagerID" value="<%=manager.getManagerId() %>"/>
				 		<input type="image" src="${pageContext.request.contextPath}/Images/edit.png" alt="submit" width="25px" height="25px" >
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