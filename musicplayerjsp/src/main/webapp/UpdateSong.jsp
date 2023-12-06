<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page
	import="org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="PlayAllSong.jsp"></jsp:include>
<%
String songId = request.getParameter("songId");
String songName = request.getParameter("songName");
String singerName = request.getParameter("singerName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Player Application</title>
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

	<h3 align="center">Check the above table & choose the songId which
		you need to update the song</h3>
	<div align="center">
		<form action="./UpdateSong.jsp" method="post">
			<fieldset>
				<legend >
					<b>Updating Song</b>
				</legend>

				<table>

					<tr>
						<td>Song Id</td>
						<td><input type="number" name="songId"></td>
					</tr>
					<tr>
						<td>Song Name :</td>
						<td><input type="text" name="songName"></td>
					</tr>
					<tr>
						<td>Singer Name :</td>
						<td><input type="text" name="singerName"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Update"
							id="submit"></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>

	<%!Connection connection;
	PreparedStatement statement;
	int result = 0;
	String update;
	String dburl = "jdbc:mysql://localhost:3306/projects";
	String driverPath = "com.mysql.cj.jdbc.Driver";
	String user = "root";
	String password = "root";%>

	<%!private void open() {
		try {
			Class.forName(driverPath);
			connection = DriverManager.getConnection(dburl, user, user);
		} catch (Exception e) {
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
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}%>

	<%
	if (songId != null && songName != null && singerName != null) {
		open();
		update = "update MusicPlayer set SongName=?,SingerName=? where SongId=?";
		statement = connection.prepareStatement(update);
		statement.setString(1, songName);
		statement.setString(2, singerName);
		statement.setString(3, songId);

		result = statement.executeUpdate();

	}
	%>
	<%
	if (result > 0) {
	%>
	<h3 align="center">Query Ok <%=result%>Row's Updated Successfully...
	</h3>
	<%
	}
	%>
	<%
	close();
	%>

</body>
</html>