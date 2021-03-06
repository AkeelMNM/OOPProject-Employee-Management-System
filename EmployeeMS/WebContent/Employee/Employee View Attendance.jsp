<%@page import="com.ems.model.Attendance"%>
<%@page import="com.ems.model.AttendanceStatus"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ems.attendance.service.AttendanceServiceImpt"%>
<%@page import="ems.attendance.service.AttendanceService"%>
<%@page import="ems.attendanceStatus.service.AttendanceStatusServiceImpt"%>
<%@page import="ems.attendanceStatus.service.AttendanceStatusService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<!-- Content Part CSS -->
<style type="text/css">

table
{
	border-collapse: collapse;
	width: 100%;
}
tr:nth-child(even){background-color: #f2f2f2}
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
</style>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS & javaScript/EmployeeStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/EmployeeScript.js"></script>
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
										<a href="${pageContext.request.contextPath}/Employee/Employee Profile.jsp">View Profile</a>
										<a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
								  </div>
					</div>
					
				</div>
		</div>


<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
<div class="left3"> <h2>EMPLOYEE PANEL<hr></h2></div>


<div class="left">
		
			<div class="btn-group">
					<a href="${pageContext.request.contextPath}/Employee/Employee Attendance.jsp"><button class="button ">Attendance</button></a>
					<a href="${pageContext.request.contextPath}/Employee/Employee Tasks.jsp"><button class="button ">Tasks</button></a>
					<a href="${pageContext.request.contextPath}/Employee/Employee Leave.jsp"><button class="button ">Leave</button></a>
					<a href="${pageContext.request.contextPath}/Employee/Employee Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4">
			<div class="btn-group" style="padding-top:50px;">
					<a href="${pageContext.request.contextPath}/Employee/Employee Attendance.jsp"><button class="buttoninsidemenu ">Attendance Marking</button></a>
					<a href="#"><button class="buttoninsidemenu ">View Attendance</button></a>


			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		<div class="left2" style="height:410px;">
		
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
			
			AttendanceService attendanceService = new AttendanceServiceImpt();
			
			EmpName = attendanceService.getEmployeeName(EmployeeID); //Getting Employee Name
			
			String attendanceID = attendanceService.getAttendanceID(EmpName); //Getting Employee Attendance ID
			
			AttendanceStatusService attendanceStatusService = new AttendanceStatusServiceImpt();
			
			String AttStID = attendanceStatusService.getAttendanceStatusID(attendanceID); //Getting AttendanceStatus ID 
			
			ArrayList<AttendanceStatus> arrayStList = attendanceStatusService.getAttendanceStatusByID(AttStID); //Getting Employee AttendanceStatus Details
			
			ArrayList<Attendance> arrayList = attendanceService.getAttendanceByID(attendanceID); //Getting Employee Attendance Details
		%>

		<br><br>
		<table>
		
		<tr>
				<th colspan="4" class="tbhd">Employee Attendance</th>
		</tr>
		<tr>
				<th>Today Date</th>
				<th>Work Started Time</th>
				<th>Work End Time</th>
				<th>Attendance Status</th>
		</tr>

		<%
			for(Attendance attendance : arrayList)
			{
			%>
			<tr>
				<td><%=attendance.getToday_Date()%></td>
				<td><%=attendance.getStart_Time()%></td>
				<td><%=attendance.getEnd_Time()%></td>
				<td><%=attendance.getStatus()%></td>
			</tr>
		<%
			}
		
		%>

		</table>

		<br><br>
		<table>
		
			<tr>
					<th colspan="2">Employee Attendance Details</th>
			</tr>
		<%
			for(AttendanceStatus attendanceStatus : arrayStList)
			{
			%>
			<tr>
				<td>Employee Name</td>
				<td><%=attendanceStatus.getEmployee()%></td>
			</tr>
						<tr>
				<td>Employee Working Department</td>
				<td><%=attendanceStatus.getDepartment()%></td>
			</tr>
			<tr>
				<td>Number Of Worked Days</td>
				<td><%=attendanceStatus.getNoWorkingDays()%></td>
			</tr>
			<tr>
				<td>Number Of Days On Leave</td>
				<td><%=attendanceStatus.getNoLeaveDays()%></td>
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