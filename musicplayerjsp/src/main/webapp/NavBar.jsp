<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Music Player Application</title>
<style type="text/css">
fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

ul {
	list-style-type: none;
	background-color: black;
	overflow: hidden;
	background-color: #333;
}

li {
	float: right;
}

li a {
	display: block;
	margin: 0px;
	padding: 15px;
}

li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
	<div align="center">
	<ul>
		<li><a style="color: white;" href="./PlayAllSong.jsp">Play All Song</a></li>
		<li><a style="color: white;" href="./UpdateSong.jsp">Update Song</a></li>
		<li><a style="color: white;" href="./SearchSong.jsp">Search Song</a></li>
		<li><a style="color: white;" href="./RemoveSong.jsp">Remove Song</a></li>
		<li><a style="color: white;" href="./AddSongs.jsp">Add Songs</a></li>
		<li><a style="color: white;" href="./MusicPlayer.jsp">Home</a></li>
	</ul>
		</div>
</body>
</html>