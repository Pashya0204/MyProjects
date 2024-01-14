<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

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
#data td {
	
	text-align: center;
}
</style>
</head>
<body>
	<div align="center">
		<form action="./add" method="post">
			<fieldset>
				<legend>Student Details</legend>
				<table id="data">
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email"></td>
					</tr>
					<tr>
						<td>Percentage</td>
						<td><input type="text" name="percent"></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type="text" name="contact"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add" id="submit"></td>
					</tr>
				</table>
			</fieldset>
			<%
			if (msg != null) {
			%>
			<h2><%=msg%></h2>
			<%
			}
			%>
		</form>


	</div>
</body>
</html>