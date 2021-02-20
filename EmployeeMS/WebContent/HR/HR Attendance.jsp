<%@page import="com.ems.model.Attendance"%>
<%@page import="ems.attendance.service.AttendanceService"%>
<%@page import="ems.attendance.service.AttendanceServiceImpt"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	background-color: #8B8378;
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
  width:25%;
  cursor:pointer;
  border-radius: 5px;

  
}
/* Change background color of buttons on hover */
.signbutton:hover {
  background-color: #00c2c7;
}

/* Create an active/current "tab button" class */
.signbutton button.active {
  background-color: #00c2c7;
}

form { border:0px;}

h4
{
	text-align:center;
	font-size: 1.5em;
	font-family:'Gabriela';
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
</div>

<div class="left">
		
			<div class="btn-group" style="margin-bottom:7px;">
					<a href="#"><button class="button ">Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Tasks.jsp"><button class="button ">Tasks</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Employee Recruitment.jsp"><button class="button ">Employee Recruitment</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Leave.jsp"><button class="button ">Leave</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4" style="height:410px;">
			<div class="btn-group" style="padding-top:20px;">
					<a href="#"><button class="buttoninsidemenu ">Attendance Marking</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Attendance.jsp"><button class="buttoninsidemenu ">View Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees Attendance.jsp"><button class="buttoninsidemenu ">View All Employees Attendance</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR View Employees AttendanceStatus.jsp"><button class="buttoninsidemenu ">View All Employees Attendance Status</button></a>
					<a href="${pageContext.request.contextPath}/HR/HR Add New Employee Attendance.jsp"><button class="buttoninsidemenu ">Add New Attendance For Employee </button></a>

			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		
		<div class="left2" style="height:420px;">

		<!-- Content Part -->

		<% String EmployeeID = null ;
		
		//Getting Employee ID from LoginServlet
		if(request.getAttribute("employee") == null)
		{
			EmployeeID= String.valueOf(request.getAttribute("employeeid"));
			//Creating Cookie
			Cookie Empid = new Cookie("employeeid", EmployeeID); //setting Employee ID to Cookie
			Empid.setMaxAge(60*60*24);
			response.addCookie(Empid);
			
		}
		//Getting Employee ID from UpdateAttendanceServlet
		if(request.getAttribute("employeeid") == null)
		{
			EmployeeID= String.valueOf(request.getAttribute("employee"));
			//Creating Cookie
			Cookie Empid = new Cookie("employeeid", EmployeeID); //setting Employee ID to Cookie
			Empid.setMaxAge(60*60*24);
			response.addCookie(Empid);
			
		}
		//Getting Employee ID from Cookie
		if(request.getAttribute("employee") == null && request.getAttribute("employeeid") == null)
		{
			//Accsessing the Cookie
			Cookie[] cookies = request.getCookies();
			for (Cookie aCookie : cookies) {
				if (aCookie.getName().equals("employeeid"))
				{
					EmployeeID = aCookie.getValue();
				}
			}
			
		}
		
		%>
			
		
		
		<h4><u>Mark Your Attendance</u></h4>
		<form method="POST"	 action="${pageContext.request.contextPath}/UpdateAttendanceServlet">
		
		<table>
		<tr>
			<th colspan="2">START WORK</th>

		</tr>
		
			<% 
				//---------------- Checking if employee already Sign in  ----------------------------//

				AttendanceService attendanceService = new AttendanceServiceImpt();
				String AttendanceID = null;
				String EmpName = null;
				
				
					EmpName = attendanceService.getEmployeeName(EmployeeID); //Getting Employee Name
					AttendanceID = attendanceService.getAttendanceID(EmpName); //Getting Employee Attendance ID

	

				ArrayList<Attendance> arrayList = attendanceService.getAttendanceByID(AttendanceID); //Getting Attendance Details of Employee
			
				String StTime = null;
				
				for(Attendance attendance : arrayList)
				{ 
					StTime = attendance.getStart_Time();
				}
				
				if(StTime == null){  //if Emplyee didn't Sign in
				%>
					<tr>
						<td>Enter Today Date</td>
						<td><input type="date" name="Today_date"></td>
					</tr>
					<tr>
						<td>Enter Starting Time</td>
						<td><input type="time" name="Start_Time"></td>
					</tr>
					<tr colspan="2">
						<td><input type="hidden" name="attendanceID" value="<%=AttendanceID%>">
						<input type="hidden" name="empID" value="<%=EmployeeID%>">
						<input type="hidden" name="Role" value="HR">
						<input type="submit" value="Sign in" class="signbutton">
						</td><td></td>
					</tr>
				<% 
				}  
				else { //if Emplyee did Sign in
				%>
					<tr>
						<td>Enter Today Date</td>
						<td><input type="date" name="Today_date" disabled /></td>
					</tr>
					<tr>
						<td>Enter Starting Time</td>
						<td><input type="time" name="Start_Time" disabled/></td>
					</tr>
					<tr colspan="2">
						<td><input type="submit" value="Sign in" class="signbutton"  disabled >
						<input type="hidden" name="attendanceID" value="<%=AttendanceID%>"  />
						</td><td></td>
					</tr>
				<% 
				}
				%>
		</table>
		</form>
		
		<br>
		
		<form method="POST"	 action="${pageContext.request.contextPath}/UpdateAttendanceServlet">
		
		<table>
		<colgroup>
		<col span="1" style="width: 47%;">
		</colgroup>
		<tr>
			<th colspan="2">END WORK</th>
		</tr>
		<%
		String EnTime = null;
		
		for(Attendance attendance : arrayList)
		{ 
			EnTime = attendance.getEnd_Time();
		} 
		
		if(EnTime == null){
		%>
			<tr>
					<td>Enter Ending Time</td>
					<td><input type="time" name="End_Time"></td>
			</tr>
			<tr colspan="2">
					<td><input type="hidden" name="attendanceID" value="<%=AttendanceID%>">
					<input type="hidden" name="empID" value="<%=EmployeeID%>">
					<input type="hidden" name="Role" value="HR">
					<input type="submit" value="Sign Out" class="signbutton">
					</td><td></td>
			</tr>

		<%
		}
		else{
		%>
			
			<tr>
					<td>Enter Ending Time</td>
					<td><input type="time" name="End_Time" disabled/></td>
			</tr>
			<tr colspan="2">
					<td><input type="submit" value="Sign Out" class="signbutton" disabled/>
					<input type="hidden" name="attendanceID" value="<%=AttendanceID%>"/>
					</td><td></td>
			</tr>

		<%
		}
		%>
		</table>
		</form>









		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		
		</div>
		




<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>