<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp"></jsp:include>
<%
String songId = request.getParameter("songId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Player Application</title>
<style type="text/css">
#search {
	margin-left: 95px;
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


		<fieldset>
			<legend >Search Song</legend>
			<form action="./SearchSong.jsp" method="post">
				<table>
					<tr>
						<td>Song Id :</td>
						<td><input type="text" name="songId"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Play" id="submit"></td>

					</tr>

				</table>
			</form>
		</fieldset>

	</div>
	<%!Connection connection;
	PreparedStatement statement;
	ResultSet result;
	String select;
	String driverPath = "com.mysql.cj.jdbc.Driver";
	String dburl = "jdbc:mysql://localhost:3306/projects";
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

	<%if(songId != null){
	open();
	select = "select * from MusicPlayer where SongId=?";
	statement = connection.prepareStatement(select);
	statement.setInt(1, Integer.parseInt(songId));
	result = statement.executeQuery();
	while (result.next()) {
	%>
	<table id="data" >
		<tr>
			<td><%=result.getInt(1)%></td>
			<td><%=result.getString(2)%></td>
			<td><%=result.getString(3)%></td>
		</tr>
	</table>
	<%
	}}%>
	
</body>
</html>