<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form action="./create" method="post">
			<fieldset>
				<legend>:: Create Admin Account ::</legend>
				<table>
					<tr>
						<td>UserName :</td>
						<td><input type="text" name="username"> </td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="password" name="password"> </td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Create Account"> </td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>