<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
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
	<ul>
		<li><a href="./logout"  style="color: white;">Logout</a></li>
		<li><a href="./update"  style="color: white;">Update</a></li>
		<li><a href="./remove"  style="color: white;">Remove</a></li>
		<li><a href="./search"  style="color: white;">Search</a></li>
		<li><a href="./add"     style="color: white;">Add</a></li>
		<li><a href="./home"    style="color: white;">Home</a></li>
	</ul>
</body>
</html>