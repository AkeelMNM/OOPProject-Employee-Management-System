<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management System</title>
<style>
body
{
	background-color:#2c2c2c;
	background-size: cover;
}
.button {

  background-color:#E85A4F;
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  font-size: 14px;
  transition: 0.3s;
  width:100%;
  size:10%;
  cursor:pointer;
  margin-top:5px;
  
}
/* Change background color of buttons on hover */
.button:hover {
  background-color: #0299a6;
}

/* Create an active/current "tab button" class */
.button button.active {
  background-color: #ccc;
}
.headdiv
{
	float:left;
	width:100%;
	height:20%;
	
	
}
.logindiv
{
	float:left;
	width:755px;
	height:500px;
	
	
	
	
}
.loginform
{
	float:left;
	width:70%;
	height:60%;
	margin-top:20px;
	margin-left:125px;
	box-shadow: 5px 5px 5px #888888;
	background: #edf1f4;
	
}
.descdiv
{
	float:left;
	width:49%;
	height:500px;
	
	
}
.vl 
{
	  border-left: 2px solid white;
	  height: 500px;
	  float:left;
	  
	  
}
.inputtype {width:95%;}
table{width:100%;}

h2
{
	font-family:'Gabriela';
	font-size:50px;
	color:white;
	text-align:center;
}
h3
{
	font-family:'Gabriela';
	font-size:25px;
	color:white;
	text-align:center;
}
tr{width:100%;}
p
{
	font-family:Times New Roman;
	color:white;
	font-size:25px;
	margin-top:50px;
	margin-left:10px;
}
input[type="text"]{ padding: 10px 10px; line-height:5px; border: 1.5px solid #555; }
input[type="password"]{ padding: 10px 10px; line-height:5px; border: 1.5px solid #555; }
input[type="submit"]{ padding: 10px 10px; line-height:15px; }

.tbltd
{
	font-size:20px;
	padding-top:20px;
}
#tdbutton{padding-top:20px;}
.tdsp{padding-top:5px;}

.footer
{
	width:100%;
	color:white;
}

</style>
</head> 
<body>  

<div class="headdiv">
	<h2>EMPLOYEE MANAGMENT SYSTEM </h2> <hr>
</div>

<div class="descdiv">

	<h3><u>VISION</u></h3> 
	<p>Employee Management System offers a flexible and easy to use HRIS solution for companies. By providing modules for personnel information management, leave, time & attendance, benefits and recruitment companies are able to manage the crucial organization asset - people. The combination of these modules into one application assures the perfect platform for re-engineering and aligning your HR processes along with the organizational goals.</p>
	
</div>

<div class="vl"></div>

<div class="logindiv" >
<h3><u>LOGIN</u></h3> 
		<div  class="loginform">
				<form method="POST" action="LoginServlet">
				<table>
						<tr>
							 <td class="tbltd">Username</td>
						</tr>
						
						<tr >
							 <td class="tdsp"><input type ="text" name ="username" placeholder="Email Address" class="inputtype"></td>
						</tr> 
						<tr>
							<td class="tbltd">Password</td>
						</tr>
						
						<tr>
							<td class="tdsp"><input type="password" name="password" placeholder="Password" class="inputtype"></td>
						</tr>
						
						<tr>
							<td id="tdbutton"><input type="submit" value="Sign in" class="button"></td>
						</tr>
						<%
							if(request.getAttribute("result") == "NoResult"){
						%>
						<tr>
						<td>Username or Password is Invalid</td>
						</tr>
						<%
							}
						%>
				</table>
				</form>
		</div>
		
</div >
<hr style="float:left; width:100%;">
<div class="footer">
		Copyright 2020 @ EMPLOYEE MANAGMENT SYSTEM.
		All Rights Reserved<br>
		Email : EMSSystem@info.lk<br>
		Designed by SLIIT 2nd year 1st semester software engineering students
		
</div>
</body>
</html>