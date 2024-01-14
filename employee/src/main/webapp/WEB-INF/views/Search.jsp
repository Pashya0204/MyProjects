<%@page import="com.project.employee.pojo.EmployeePOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
String msg = (String) request.getAttribute("msg");
EmployeePOJO employee = (EmployeePOJO) request.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Employee</title>
<style type="text/css">
#search {
	margin :0 Auto;
}
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

thead {
	color: white;
	width: 100%;
	background: #000;
	padding: ($half-spacing-unit* 1.5) 0;
	width: 100%;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#data td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>

	<div align="center">
		<form action="./search" method="post">
			<fieldset>
				<legend>:: Search Employee ::</legend>
				<table>
					<tr>
						<td>Employee Id</td>
						<td><input type="number" name=id></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Search"
							id="search"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<div align="center">
		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>
		<%
		if (employee != null) {
		%>
		<table id="data">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Contact</td>
					<td>Email</td>
					<td>Designation</td>
					<td>Salary</td>
				</tr>
			</thead>
			<tr>
				<td><%=employee.getId()%></td>
				<td><%=employee.getName()%></td>
				<td><%=employee.getContact()%></td>
				<td><%=employee.getEmail()%></td>
				<td><%=employee.getDesignation()%></td>
				<td><%=employee.getSalary()%></td>
			</tr>
		</table>
		<%
		}
		%>
	</div>
</body>
</html>