<%@page import="com.ems.model.Leave"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ems.Leave.service.LeaveServiceimpt"%>
<%@page import="ems.Leave.service.LeaveService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS & javaScript/EmployeeStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/EmployeeScript.js"></script>

<style>

.select-button {
    background-color:  #bfffc1;
    color: black;
    width: 100%;
    padding: 8px 50px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
}
form{border: none;}

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
										<a href="${pageContext.request.contextPath}/Employee/Employee Profile.jsp">View Profile</a>
										<a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
								  </div>
					</div>
					
				</div>
		</div>

<div class="left3"> <h2>EMPLOYEE PANEL<hr></h2></div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


<div class="left">
		
			<div class="btn-group">
					<a href="${pageContext.request.contextPath}/Employee/Employee Attendance.jsp"><button class="button ">Attendance</button></a>
					<a href="${pageContext.request.contextPath}/Employee/Employee Tasks.jsp"><button class="button ">Tasks</button></a>
					<a href="#"><button class="button ">Leave</button></a>
					<a href="${pageContext.request.contextPath}/Employee/Employee Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div class="left4">
			<div class="btn-group" style="padding-top:50px;">
					<a href="${pageContext.request.contextPath}/Employee/Employee Leave.jsp"><button class="buttoninsidemenu ">Apply Leave</button></a>
					<a href="#"><button class="buttoninsidemenu ">View Applyed Leaves</button></a>

			</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

		
		<div class="left2" style="height:410px;">
		
		<!-- Content Part -->

		<%
		
		String EmployeeID=null;
		String EmpName=null;
		String LeaveID = null;
		
		//Accessing Cookie
		Cookie[] cookies =request.getCookies();
		for(Cookie aCookie : cookies)
		{
			if( aCookie.getName().equals("employeeid"))
			{
				
				EmployeeID= aCookie.getValue();
			}
			
			
		}
		
			LeaveService leaveservice = new LeaveServiceimpt();
			
			EmpName=leaveservice.getEmployeeName(EmployeeID);

			ArrayList<Leave> arrayList = leaveservice.getLeaveByEmployeeName(EmpName);

		%>


		<table border="1" cellpadding="12" style="margin-left: auto; margin-right: auto;">
			<caption>
				<h2>LIST OF LEAVES</h2>
			</caption>

			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Department</th>

				<th>Starting Date</th>
				<th>End Date</th>
				<th>Leave Status</th>
				<th>Description</th>
				<th>Select</th>
			</tr>

			<%
				for (Leave leave : arrayList) {
			%>
			<tr>

				<td><%=leave.getLeaveId()%></td>


				<td><%=leave.getEmployee()%></td>

				<td><%=leave.getDepartment()%></td>



				<td><%=leave.getStarting_Date()%></td>


				<td><%=leave.getEnd_Date()%></td>

				<td><%=leave.getL_Status()%></td>


				<td><%=leave.getDescription()%></td>

				<td>
					<form method="POST" action="${pageContext.request.contextPath}/GetLeaveServlet">
						<input type="hidden" name="LeaveID" value="<%=leave.getLeaveId()%>" /> 
							<input type="submit" value="Select Leave" class="select-button" />
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