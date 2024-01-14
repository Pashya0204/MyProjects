<%@page import="org.apache.tomcat.websocket.PojoClassHolder"%>
<%@page import="com.project.student.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
String msg = (String) request.getAttribute("msg");
List<StudentPOJO> students = (List<StudentPOJO>) request.getAttribute("studList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
<style type="text/css">

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
		<form action="./remove" method="post">
			<fieldset>
				<legend>:: Remove Student ::</legend>
				<table>
					<tr>
						<td>Enter Id</td>
						<td><input type="number" name="id"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Remove"
							id="remove"></td>
					</tr>
				</table>
			</fieldset>
		</form>
		<%
		if (msg != null) {
		%>
		<h3><%= msg %></h3>
		<%} %>
		<%
		if (students != null) {
		%>
		<table id="data">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Email</td>
					<td>Contact</td>
					<td>Marks</td>
				</tr>
			</thead>
			<%
			for (StudentPOJO pojo : students) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getPercentage()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>


	</div>
</body>
</html>