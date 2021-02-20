<%@page import="com.ems.model.Attendance"%>
<%@page import="com.ems.model.AttendanceStatus"%>
<%@page import="ems.attendance.service.AttendanceService"%>
<%@page import="ems.attendance.service.AttendanceServiceImpt"%>
<%@page import="ems.attendanceStatus.service.AttendanceStatusService"%>
<%@page import="ems.attendanceStatus.service.AttendanceStatusServiceImpt"%>
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
		<div class="left4">
			<div class="btn-group" style="padding-top:20px; height:400px;">
					<a href="${pageContext.request.contextPath}/HR/HR Attendance.jsp"><button class="buttoninsidemenu ">Attendance Marking</button></a>
					<a href="#"><button class="buttoninsidemenu ">View Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees Attendance.jsp"><button class="buttoninsidemenu ">View All Employees Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees AttendanceStatus.jsp"><button class="buttoninsidemenu ">View All Employees Attendance Status</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add New Employee Attendance.jsp"><button class="buttoninsidemenu ">Add New Attendance For Employee </button></a>
					


			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		<div class="left2" style="height:430px;">

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

		<br>
		<table>
		
		<tr>
				<th colspan="4"class="tbhd">Employee Attendance</th>
		</tr>

		<%
			for(Attendance attendance : arrayList)
			{
			%>
			<tr>
				<th>Today Date</th>
				<th>Work Started Time</th>
				<th>Work End Time</th>
				<th>Attendance Status</th>
			</tr>
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