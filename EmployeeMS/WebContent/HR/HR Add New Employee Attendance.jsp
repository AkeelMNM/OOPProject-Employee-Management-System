<%@page import="com.ems.model.Employee"%>
<%@page import="com.ems.model.Attendance"%>
<%@page import="ems.attendance.service.AttendanceService"%>
<%@page import="ems.attendance.service.AttendanceServiceImpt"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS & javaScript/AdminStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/AdminScript.js"></script>
		
<!-- Content Part CSS -->
<style type="text/css">
table
{
	border-collapse: collapse;
	width: 100%;
}
tr{background-color: #f2f2f2}
th,td
{
	text-align: left;
	padding:9px;
}
th
{	
	background-color: #db6161;
	color: white;
}
th.tbhd
{
	background-color: #4d5870;
	color: white;
}
.searchbutton {

  background-color:	#60a3bc;
  border: none;
  color: white;
  padding: 7px ;
  text-align: center;
  text-decoration: none;
  font-size: 13px;
  transition: 0.3s;
  cursor:pointer;
  border-radius: 5px;

  
}

.editbutton {

  background-color:	#ed3330;
  border: none;
  color: white;
  padding: 7px ;
  text-align: center;
  text-decoration: none;
  font-size: 13px;
  transition: 0.3s;
  cursor:pointer;
  border-radius: 5px;

  
}

/* Change background color of buttons on hover */
.editbutton:hover {
  background-color: #434343;
}
/* Change background color of buttons on hover */
.searchbutton:hover {
  background-color: #434343;
}
form { border: none;}
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
		
			<div class="btn-group" style="margin-bottom:7px;">
					<a href="${pageContext.request.contextPath}/HR/HR Attendance.jsp"><button class="button ">Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Tasks.jsp"><button class="button ">Tasks</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Employee Recruitment.jsp"><button class="button ">Employee Recruitment</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Leave.jsp"><button class="button ">Leave</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4" style="height:420px;">
			<div class="btn-group" style="padding-top:20px; height:400px;">
					<a href="${pageContext.request.contextPath}/HR/HR Attendance.jsp"><button class="buttoninsidemenu ">Attendance Marking</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Attendance.jsp"><button class="buttoninsidemenu ">View Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees Attendance.jsp"><button class="buttoninsidemenu ">View All Employees Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees AttendanceStatus.jsp"><button class="buttoninsidemenu ">View All Employees Attendance Status</button></a>
					<a href="#"><button class="buttoninsidemenu ">Add New Attendance For Employee </button></a>
					

			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		<div class="left2" style="height:430px;">

		<!-- Content Part -->
		<br>
		<form method="POST" action="${pageContext.request.contextPath}/GetAttendanceServlet">
		<table>
		<colgroup>
		<col span="1" style="width: 45%;">
		</colgroup>
		<tr>
				<td>Search Newly Added Employees Details in the System</td>
				<td><input type="hidden" name="getEmp" value="chkEmp"/>
				<input type="submit" value="Search In System" class="searchbutton"></td>
		
		</tr>
		</table>
		</form>
		
		<%
			String no = String.valueOf(request.getAttribute("emp"));
			
			if(no.equals("getEmployee"))
			{
					AttendanceService attendanceService = new AttendanceServiceImpt();
					ArrayList<Employee> employeeList = attendanceService.getEmployeeListThatDontHaveAttendance();
				%>
			<br>
			<table>

			<tr>
					<th>Employee ID</th>
					<th>Department</th>
					<th>Employee Name</th>
					<th>Gender</th>
					<th>Joined Date</th>
			</tr>
					<% for(Employee employee : employeeList)
					{
				%>
				<tr>
					<td><%=employee.getEmpID()%></td>
					<td><%=employee.getDepartment()%></td>
					<td><%=employee.getFullname()%></td>
					<td><%=employee.getGender()%></td>
					<td><%=employee.getJointDate()%></td>
				</tr>
			<%
				}%>
				</table>
		<% 	}
		%>

		<br>
		<form method="post" action="${pageContext.request.contextPath}/AddAttendanceServlet">
		<table>
			<tr>
				<td>Enter Employee ID </td>
				<td><input type="text" name="employee" ></td>
			</tr>
			<tr>
				<td>Enter Employee Name</td>
				<td><input type="text" name="employeeName"></td>
			</tr>
			<tr>
				<td>Enter Employee Department Name </td>
				<td><input type="text" name="department" ></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create Attendance"  class="editbutton"></td>
			</tr>
			
		</table>
		</form>

		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		</div>


<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>

</html>