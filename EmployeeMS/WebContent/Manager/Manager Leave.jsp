<%@page import="com.ems.model.Leave"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ems.Leave.service.LeaveServiceimpt"%>
<%@page import="ems.Leave.service.LeaveService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/CSS & javaScript/ManagerStyles.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="${pageContext.request.contextPath}/CSS & javaScript/ManagerScript.js"></script>
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

<div class="left3"> <h2>MANAGER PANEL<hr></h2></div>
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


<div class="left">
		
			<div class="btn-group">
					<a href="${pageContext.request.contextPath}/Manager/Manager Attendance.jsp"><button class="button ">Attendance</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Tasks.jsp"><button class="button ">Tasks</button></a>
					<a href="#"><button class="button ">Leave Requests</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Department & Employees.jsp"><button class="button ">Department & Employees</button></a>
					<a href="${pageContext.request.contextPath}/Manager/Manager Profile.jsp"><button class="button ">View Profile</button></a>
			</div>
	
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		<div class="left5" style="height:420px;">

		<!-- Content Part -->

		<%
		
		String EmployeeID=null;
		
		
		Cookie[] cookies =request.getCookies();
		for(Cookie aCookie : cookies)
		{
			if( aCookie.getName().equals("employeeid"))
			{
				EmployeeID= aCookie.getValue();
			}
		}
		
			LeaveService leaveservice = new LeaveServiceimpt();
			String DepartmentName = leaveservice.getLeaveEmployeeDepartment(EmployeeID);
			ArrayList<Leave> leavelist =leaveservice.getallDepartmentLeave(DepartmentName);

		%>

		<table border="1" cellpadding="12" style="text-align:center; margin-left: auto; margin-right: auto;">
			<caption>
				<h2>List of Leaves</h2>
			</caption>

			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Department</th>
				<th>Starting Date</th>
				<th>End Date</th>
				<th>Leave Status</th>
				<th>Description</th>
				<th colspan="2">Select</th>
			</tr>

			<%
				for (Leave leave :leavelist ) {
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
					 <form method="POST" action="${pageContext.request.contextPath}/ApproveLeaveServlet" style="border:none;">
						<input type="hidden" name="LeaveID" value="<%=leave.getLeaveId()%>" /> 
							<input type="hidden" name="Status" value="Approve" />
							  <input type="submit" value="Approve" class="button8"/>
					</td>          
					</form>
					<td>
					
					 <form method="POST" action="${pageContext.request.contextPath}/ApproveLeaveServlet" style="border:none;">
						<input type="hidden" name="LeaveID" value="<%=leave.getLeaveId()%>" /> 
							<input type="hidden" name="Status" value="Reject" />
					          <input type="submit" value="Reject" class="button8"/>
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