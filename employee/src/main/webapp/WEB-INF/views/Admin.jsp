<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>
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

</style>
</head>
<body>
	<div align="center">
		<form action="./create" method="post">
			<fieldset>
				<legend>Create Account</legend>
				<table>
					<tr>
						<td>Username :</td>
						<td><input type="text" name="username"> </td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="password" name="password"> </td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Create"> </td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>