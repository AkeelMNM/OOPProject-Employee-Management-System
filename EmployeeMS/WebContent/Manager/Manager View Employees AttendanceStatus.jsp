<%@page import="com.ems.model.AttendanceStatus"%>
<%@page import="ems.attendanceStatus.service.AttendanceStatusServiceImpt"%>
<%@page import="ems.attendanceStatus.service.AttendanceStatusService"%>
<%@page import="com.ems.model.Attendance"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ems.attendance.service.AttendanceServiceImpt"%>
<%@page import="ems.attendance.service.AttendanceService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS & javaScript/ManagerStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/ManagerScript.js"></script>
		
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
	background-color: #b34426;
	color: white;
}
th.tbhd
{
	background-color: #4d5870;
	color: white;
}
.signbutton {

  background-color:	#4d5870;
  border: none;
  color: white;
  padding: 7px ;
  text-align: center;
  text-decoration: none;
  font-size: 13px;
  transition: 0.3s;
  width:30%;
  cursor:pointer;

  
}
/* Change background color of buttons on hover */
.signbutton:hover {
  background-color: #00c2c7;
}

/* Create an active/current "tab button" class */
.signbutton button.active {
  background-color: #00c2c7;
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
					<a href="${pageContext.request.contextPath}/Manager/Manager Tasks.jsp"><button class="button ">Tasks</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Leave.jsp"><button class="button ">Leave Requests</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Department & Employees.jsp"><button class="button ">Department & Employees</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4">
			<div class="btn-group" style="padding-top:50px;">
					<a href="${pageContext.request.contextPath}/Manager/Manager Attendance.jsp"><button class="buttoninsidemenu ">Attendance Marking</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager View Attendance.jsp"><button class="buttoninsidemenu ">View Attendance</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager View Employees Attendance.jsp"><button class="buttoninsidemenu ">View Employees Attendance in Department</button></a>
					<a href="#"><button class="buttoninsidemenu ">View Employees Attendance Status in Department</button></a>


			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		<div class="left2" style="height:410px;">

		<!-- Content Part -->

		<% //Accsessing the Cookie
		Cookie[] cookies = request.getCookies();;
		String EmployeeID = null;
		for (Cookie aCookie : cookies) {
			if (aCookie.getName().equals("employeeid"))
			{
				EmployeeID = aCookie.getValue();
			}
		}
		
		AttendanceService attendanceService = new AttendanceServiceImpt();
		String EmpName = attendanceService.getEmployeeName(EmployeeID); //Getting Manager Name
		String DepartmentName = attendanceService.getDepartmentID(EmpName); //Getting Department Name
		
		AttendanceStatusService attendanceStatusService = new AttendanceStatusServiceImpt();
		ArrayList<AttendanceStatus> attendanceStatusList = attendanceStatusService.getDepartmentAttendanceStatus(DepartmentName); //Getting Department Employees Attendance
		
		
		%>
		<br>
				<table>
		
		<tr>
				<th colspan="4"class="tbhd">Employees Attendance Status</th>
		</tr>
		<tr>
				<th>Employee Name</th>
				<th>Employee Department</th>
				<th>Number Of Worked Days</th>
				<th>Number Of Days On Leave</th>
		</tr>

		<% for(AttendanceStatus attendancestatus : attendanceStatusList)
					{
				%>
				<tr>
					<td><%=attendancestatus.getEmployee()%></td>
					<td><%=attendancestatus.getDepartment()%></td>
					<td><%=attendancestatus.getNoWorkingDays()%></td>
					<td><%=attendancestatus.getNoLeaveDays()%></td>
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