<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="MusicPlayer.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Player</title>
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

.data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

.data td {
	border: 1px solid black;
	text-align: center;
}

</style>
</head>
<body>

	<%!Connection connection;
	PreparedStatement statement;
	ResultSet result;
	String dburl = "jdbc:mysql://localhost:3306/projects";
	String driverPath = "com.mysql.cj.jdbc.Driver";
	String select;
	String user = "root";
	String password = "root";%>
	<%!private void open() {
		try {
			Class.forName(driverPath);

			connection = DriverManager.getConnection(dburl, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}%>
	<%!private void close() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}%>
	<%{
	open();
	select = "select * from MusicPlayer";
	statement = connection.prepareStatement(select);
	result = statement.executeQuery();
	}%>


	<div align="center">
		<table class="data">
			<tr>
				<td><b>SongId</b></td>
				<td><b>Song Name</b></td>
				<td><b>Singer Name</b></td>
			</tr>
		</table>

		<%
		while (result.next()) {
		%>
		<table class="data"> 
			<tr>
				<td ><%=result.getInt(1)%></td>
				<td ><%=result.getString(2)%></td>
				<td ><%=result.getString(3)%></td>
			</tr>
		</table>
	</div>
	<%
	}
	%>
	<% close(); %>
</body>
</html>