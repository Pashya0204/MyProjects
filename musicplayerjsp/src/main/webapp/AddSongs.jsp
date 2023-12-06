<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="MusicPlayer.jsp"></jsp:include>
<%
String songId = request.getParameter("songId");
String songName = request.getParameter("songName");
String singerName = request.getParameter("singerName");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Player</title>
<style type="text/css">
#submit {
	margin-left: 100px;
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
#data td {
	
	text-align: center;
}
</style>
</head>
<body>
	<div align="center">

		<fieldset>
			<legend align="center">Add Songs</legend>
			<form action="./AddSongs.jsp" method="post">
				<table>
					<tr>
						<td><b>Song Id :</b></td>
						<td><input type="number" name="songId"></td>
					</tr>
					<tr>
						<td><b>Song Name : </b></td>
						<td><input type="text" name="songName"></td>
					</tr>
					<tr>
						<td><b> Singer Name : </b></td>
						<td><input type="text" name="singerName"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add Song "
							id="submit"></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>

	<%!Connection connection;
	PreparedStatement statement;
	String insert;
	int result = 0;
	String dburl = "jdbc:mysql://localhost:3306/projects";
	String driverPath = "com.mysql.cj.jdbc.Driver";
	String user = "root";
	String password = "root";%>
	<%!private void openConnection() {
		try {

			Class.forName(driverPath);

			connection = DriverManager.getConnection(dburl, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}

	}%>
	<%!private void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
				if (statement != null) {
					statement.close();
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}%>
	<%
	if (songId != null && songName != null && singerName != null) {
		openConnection();
		insert = "insert into MusicPlayer values (?,?,?)";
		statement = connection.prepareStatement(insert);
		statement.setString(1, songId);
		statement.setString(2, songName);
		statement.setString(3, singerName);
		result = statement.executeUpdate();
		if (result != 0) {
	%>

	<h3 align="center" >
		Query Ok <%=result %> Row's Inserted Successfully
	</h3>

	<%
	}
	}
	%>
	<% closeConnection(); %>
	
	
</body>
</html>