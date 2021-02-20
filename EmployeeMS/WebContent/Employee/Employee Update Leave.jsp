<%@page import="java.util.ArrayList"%>
<%@page import="com.ems.model.Leave"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS & javaScript/EmployeeStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/EmployeeScript.js"></script>
		
<style>

.delete-button {
    background-color: #bedceb; /* red */
    color: black;
    
    padding: 8px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
}

.update-button {
    background-color: #bfffc1; /* green */
    color: black;
    
    padding: 8px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
}

.tag{
color:black;
text-align: left
width: 50%;
 padding: 5px;

}
.button1{
  background-color:#E85A4F;
  border: none;
  color: white;
  padding: 10px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;

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
						<a href ="${pageContext.request.contextPath}/Employee/Employee Applyed Leave.jsp"><button class="buttoninsidemenu ">View Applyed Leaves</button></a>

				</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		<div class="left2" style="height:410px;">
		
		<!-- Content Part -->
<%
		ArrayList<Leave> leavelist = (ArrayList<Leave>)request.getAttribute("Leave");
			
	
	%>
		<h3 style="text-align:center;"><u>Update Leave</u></h3>
	<form method="POST" action="${pageContext.request.contextPath}/UpdateLeaveServlet">

	<table>
	<% for(Leave leave : leavelist){
	%>
	<tr><td>Employee Name</td>
		<td><input type="text" name="employee" value = "<%=leave.getEmployee()%>"></td>
	</tr>
	<tr>
		<td>Department</td>
		<td><input type="text" " name="Department" value="<%=leave.getDepartment()%>"></td>
	</tr>
	<tr>
	<td>From Date</td>
	<td><input type="text"  name="Starting_Date"  value = "<%=leave.getStarting_Date()%>"></td>
	</tr>
	<tr>
		<td>To Date</td>
		<td><input type="text"  name="End_Date" value = "<%=leave.getEnd_Date()%>"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="hidden"  name="L_Status" value="Pending" ></td>
	</tr>
	<tr>
		<td>Description</td>
		<td><textarea rows="7" cols="50" name="Description"><%=leave.getDescription()%></textarea></td>
	</tr>
	<tr><td><input type="hidden" name="LeaveID"value="<%=leave.getLeaveId()%>" /> 
			<input type="submit" value="Update Leave" class="update-button"/>
	</form></td>
	</tr>
	<tr><td><form method="POST" action="${pageContext.request.contextPath}/DeleteLeaveServlet">
					<input type="hidden" name="LeaveID"value="<%=leave.getLeaveId()%>" /> 
					<input type="submit" value="Delete Leave" class="delete-button"/>
				</form></td></tr>

<%} %>

</table>

		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		

		</div>

<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>