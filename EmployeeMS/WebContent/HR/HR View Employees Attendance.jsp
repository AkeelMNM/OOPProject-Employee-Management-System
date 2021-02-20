<%@page import="ems.attendanceStatus.service.AttendanceStatusServiceImpt"%>
<%@page import="ems.attendanceStatus.service.AttendanceStatusService"%>
<%@page import="com.ems.model.Attendance"%>
<%@page import="com.ems.model.AttendanceStatus"%>
<%@page import="ems.attendance.service.AttendanceServiceImpt"%>
<%@page import="ems.attendance.service.AttendanceService"%>
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
	text-align: center;
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
.updatebutton {

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
/* Change background color of buttons on hover */
.editbutton:hover {
  background-color: #434343;
}


form { border:0px;}

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
					<a href="${pageContext.request.contextPath}/HR/HR View Attendance.jsp"><button class="buttoninsidemenu ">View Attendance</button></a>
					<a href="#"><button class="buttoninsidemenu ">View All Employees Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees AttendanceStatus.jsp"><button class="buttoninsidemenu ">View All Employees Attendance Status</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add New Employee Attendance.jsp"><button class="buttoninsidemenu ">Add New Attendance For Employee </button></a>
					
			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		<div class="left2" style="height:430px;">

		<!-- Content Part -->

		<%
				
				//Accsessing the Cookie
				Cookie[] cookies = request.getCookies();;
				String EmployeeID = null;
				String AttendanceID;
				for (Cookie aCookie : cookies) {
					if (aCookie.getName().equals("employeeid"))
					{
						EmployeeID = aCookie.getValue();
					}
				}
				
					AttendanceService attendanceService = new AttendanceServiceImpt();
					ArrayList<Attendance> attendanceList = attendanceService.getAttendance(); //Getting Employees All Attendance
					
		%>
		
		<br>
		<form method="POST" action="${pageContext.request.contextPath}/UpdateAttendanceServlet">
		<table>
		<colgroup>
		<col span="1" style="width: 45%;">
		</colgroup>
		<td>Reset Attendance Table For New Day<input type="hidden" name ="updateTable" value="updateTable">
								<input type="hidden" name ="empID" value="<%=EmployeeID%>"></td>
						<td><input type="submit" value="Update Attendance Table" class="updatebutton"></td>
		</table>
		</form>
		
		<br>
		<table>
		
		<tr>
				<th colspan="7"class="tbhd">Employee Attendance</th>
		</tr>
		<tr>
				<th>Employee Name</th>
				<th>Employee Department</th>
				<th>Today Date</th>
				<th>Work Started Time</th>
				<th>Work End Time</th>
				<th>Attendance Status</th>
				<th>Edit</th>
		</tr>

		<%
			for(Attendance attendance : attendanceList)
			{
			%>

			<tr>
				<td><%=attendance.getEmployee()%></td>
				<td><%=attendance.getDepartment()%></td>
				<td><%=attendance.getToday_Date()%></td>
				<td><%=attendance.getStart_Time()%></td>
				<td><%=attendance.getEnd_Time()%></td>
				<td><%=attendance.getStatus()%></td>
				<td><form method="POST" action="${pageContext.request.contextPath}/DeleteAttendanceServlet">
						<input type="hidden" name ="AttID" value="<%=attendance.getAttendanceID()%>">
						<input type="hidden" name ="EID" value="<%=EmployeeID%>">
						<input type="submit" value="Remove Attendance" class="editbutton">
				</form></td>
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