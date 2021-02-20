<%@page import="ems.Employee.service.HREmployeeServiceInterface"%>
<%@page import="ems.Employee.service.HREmployeeServiceImpt"%>
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
	.imgcontainer {
	  text-align: center;
	  margin: 24px 0 12px 0;
	}
	
	img.avatar {
	  width: 10%;
	  border-radius: 50%;
	}
	table {
	  border-collapse: collapse;
	  width: 96%;
	}
	
	td {
	  text-align: left;
	  padding: 12px;
	}
	th{
	  text-align: left;
	  padding: 6px;
	}

	tr:nth-child(even){background-color: #f2f2f2}
	
	th {
	  background-color:#2c2c2c;
	  color: white;
	}
	div.tb{
		float:left;
		width:50%; 
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

<div class="left3"> <h2>HR PANEL<hr></h2></div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


<div class="left">
		
			<div class="btn-group">
					<a href="${pageContext.request.contextPath}/HR/HR Attendance.jsp"><button class="button ">Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Tasks.jsp"><button class="button ">Tasks</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Employee Recruitment.jsp"><button class="button ">Employee Recruitment</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Leave.jsp"><button class="button ">Leave</button></a>
					<a href="#"><button class="button ">View Profile</button></a>
			</div>

</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left5">
		
		<!-- Content Part -->

		<%
			String EmployeeID = null;
			
		//Accsessing the Cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie aCookie : cookies) {
			if (aCookie.getName().equals("employeeid"))
			{
				EmployeeID = aCookie.getValue();
			}
		}
			
		%>
		
		<div class="imgcontainer">
			<img src="${pageContext.request.contextPath}/Images/prfl.png" alt="Avatar" class="avatar" >
		</div>
		  
		<%
			//get the employee details
			HREmployeeServiceInterface getEmpDetailsByID = new HREmployeeServiceImpt();
			Employee emp = getEmpDetailsByID.getEmployeeByID(EmployeeID);
			
			request.setAttribute("employee", emp);
		%>
		
		<div class="container">
			
			<div class="tb" >
				<table>
					<tr>
						<td>Employee ID </td>
						<td> <%=emp.getEmpID() %> </td>
					</tr>
					<tr>
						<td>First Name</td>
						<td> <%=emp.getFullname() %> </td>
					</tr>
					<tr>
						<td>Job Title</td>
						<td> <%=emp.getJobTitle() %> </td>
					</tr>
					<tr>
						<td>Address</td>
						<td> <%=emp.getAddress() %> </td>
					</tr>
					<tr>
						<td>Gender</td>
						<td> <%=emp.getGender() %> </td>
					</tr>
					<tr>
						<td>Date of birth</td>
						<td> <%=emp.getDOB() %> </td>
					</tr>
					<tr>
						<th colspan="2">
						</th>
					</tr>
				</table>
			</div>
			
			<div class="tb" >
				<table>
					<tr>
						<td>Marital Status</td>
						<td> <%=emp.getMaritalStatus() %> </td>
					</tr>
					<tr>
						<td>NIC</td>
						<td> <%=emp.getNIC() %> </td>
					</tr>
					<tr>
						<td>Phone Number</td>
						<td> <%=emp.getPhoneNo() %>  </td>
					</tr>
					<tr>
						<td>Department</td>
						<td> <%=emp.getDepartment() %> </td>
					</tr>
					<tr>
						<td>Salary</td>
						<td> <%=emp.getSalary()%> </td>
					</tr>
					<tr>
						<td>Joint Date</td>
						<td> <%=emp.getJointDate() %> </td>
					</tr>
					
					<tr>
						<th colspan="2">
						</th>
					</tr>
					
				</table>
			</div>
			
		
			
		</div>
		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->



		</div>


<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>