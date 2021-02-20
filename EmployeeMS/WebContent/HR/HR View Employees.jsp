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

<style>
		Form {border:none;}
		
		table {
		  border-collapse: collapse;
		  width: 100%;
		}
		
		th, td {
		  text-align: left;
		  padding: 8px;
		}
		
		tr:nth-child(even){background-color: #f2f2f2}
		
		th {
		  background-color: #61605a;
		  color: white;
		}

		.EditButton {
   			width: 25px;
    		height: 25px;
    		border:none !important;
    	}
		
		.DeleteButton {
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
					<a href="${pageContext.request.contextPath}/HR/HR Employee Recruitment.jsp"><button class="button ">Employee Recruitment</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Leave.jsp"><button class="button ">Leave</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4" style="height:420px;">
			<div class="btn-group" style="padding-top:50px;">
					
					<a href="${pageContext.request.contextPath}/HR/HR Employee Recruitment.jsp"><button class="buttoninsidemenu ">View Department</button></a>
					<a href="#"><button class="buttoninsidemenu ">View Employees</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add Department.jsp"><button class="buttoninsidemenu ">Add New Department</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add Employee.jsp"><button class="buttoninsidemenu ">Add New Employees </button></a>
					


			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		<div class="left2">

		<!-- Content Part -->
<table>
			<caption><h2>List of Employees</h2></caption>
		  	<tr>
                <th>Employee Name</th>
                <th>Job Title</th>
                <th>Address</th>
                <th>Gender</th>
                <th>Date of birth</th>
                <th>Marital Status</th>
                <th>NIC</th>
                <th>Phone Number</th>
                <th>Joint_Date</th>
                <th>Salary</th>
                <th>Department</th>
            </tr>
            
            <%
            	HREmployeeServiceInterface ViewEmployees = new HREmployeeServiceImpt();
            	ArrayList<Employee> arrayList = ViewEmployees.getEmployees();
            	
            	for(Employee employee : arrayList) 
            	{
            %>
            
            <tr> 
            	<td> <%=employee.getFullname() %></td>
            	<td> <%=employee.getJobTitle() %> </td>
            	<td> <%=employee.getAddress() %></td>
            	<td> <%=employee.getGender() %></td>
            	<td> <%=employee.getDOB() %> </td>
            	<td> <%=employee.getMaritalStatus() %> </td>
            	<td> <%=employee.getNIC() %> </td>
            	<td> <%=employee.getPhoneNo() %> </td>
            	<td> <%=employee.getJointDate() %> </td>
            	<td> <%=employee.getSalary() %> </td>
            	<td> <%=employee.getDepartment() %> </td>
				 
				 <td class="EditButton">
            		<form method="POST" action="HR Edit Employee.jsp" >
            			<input type="hidden" name="EmployeeID" value="<%=employee.getEmpID() %>">
            			<input type="image" src="${pageContext.request.contextPath}/Images/edit.png" alt="submit" width="25px" height="25px" > 
				 	</form>
				 </td>
				 
				 <td class="DeleteButton">
            		<form method="POST" action="${pageContext.request.contextPath}/HRDeleteEmployeeServlet">
            			<input type="hidden" name="EmployeeID" value="<%=employee.getEmpID() %>"/>
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