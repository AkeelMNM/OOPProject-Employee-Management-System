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

.tag{
color:black;
text-align: left; 
width: 50%;
 padding: 5px;
   padding: 100;

}
.button1{
  background-color:#62f567;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 3px 1px;
  cursor: pointer;

}
form{border: none;}
</style>

</head>
<body>
<!-- Header Part -->
		<div class="bigDiv">
				<div class="logo">
					<img src="../Images/MainLogo.png" alt="MainLogo" id="logo">
				</div>
				<div class="name">
					<h1>Employee Management System</h1>
				</div>
				<div class="manage">
					<div class="adminlogo">
						<img src="../Images/AdminLogo.png" alt="MainLogo" id="logoA">
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
</div>
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
						<a href="#"><button class="buttoninsidemenu ">Apply Leave</button></a>
						<a href ="${pageContext.request.contextPath}/Employee/Employee Applyed Leave.jsp"><button class="buttoninsidemenu ">View Applyed Leaves</button></a>

				</div>
		</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		<div class="left2" style="height:410px;">
		
		<!-- Content Part -->
		<h3 style="text-align:center;"><u>Apply Leave</u></h3>
		<form method="POST" action="${pageContext.request.contextPath}/AddLeaveServlet">

		<table>
		<tr>
			<td>Employee Name</td>
			<td><input type="text" name="employee" ></td>
		</tr>
		<tr>
			<td>Department</td>
			<td><input type="text" " name="Department" ></td>
		</tr>
		<tr>
			<td>From Date</td>	
			<td><input type="date"  name="Starting_Date" ></td>
		</tr>
		<tr>
			<td>To Date</td>
			<td><input type="date"  name="End_Date" ></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="hidden"  name="L_Status" value="Pending" ></td>
		</tr>
		<tr>
			<td>Description	</td>
			<td><textarea rows="6" cols="50" name="Description"></textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value ="Apply Leave" class="button1"/></td>
		</tr>
		<tr> 
			<td><input type="reset" value ="Reset"class="button1" /> </td>
		</tr>
		</table>
	</form>


		<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->


		

		</div>

<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>