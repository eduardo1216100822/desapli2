<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Form</title>
</head>
<body>		
	<form action="ClientController">
		<label>Name:</label>
		<input type="text" name="name" value="${client.name}"><br /><br />
		<label>home:</label>
		<input type="text" name="home" value="${client.home}"><br /><br />
		<label>phone:</label>
		<input type="number" name="phone" value="${client.phone}"><br /><br />
		<label>cellphone:</label>
		<input type="number" name="celphone" value="${client.celphone}"><br /><br />
		<label>Mail:</label>
		<input type="text" name="mail" value="${client.mail}"><br /><br />
		<input type="submit" name="btn_save" value="save">
	</form>
</body>
</html>