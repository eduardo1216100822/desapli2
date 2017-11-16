<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client List</title>
</head>
<table border="1">
		<tr>
			<th>
				<form action="ClientReport">
					<input type="submit" name="btn_report" value="Report">
				</form>
				<form action="ClientController">
					<input type="submit" name="btn_new" value="New">
				</form>
			</th>
			<th>Id</th>
			<th>Name</th>
			<th>Home</th>
			<th>Phone</th>
			<th>CellPhone</th>
			<th>Mail</th>
		</tr>
			<c:forEach var="client" items="${clients}">
				<tr>
					<td>
						<form action="ClientController">
							<input type="hidden" name="id" value="${client.id}">
							<input type="submit" name="btn_edit" value="Edit">
							<input type="submit" name="btn_delete" value="Delete">
						</form>
					</td>
					<td>${client.id}</td>
					<td>${client.name}</td>
					<td>${client.home}</td>
					<td>${client.phone}</td>
					<td>${client.celphone}</td>
					<td>${client.mail}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>