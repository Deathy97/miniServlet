<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,es.salesianos.model.User"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body>
	<%
		List<User> userList = (List<User>) request.getAttribute("userList");
	pageContext.setAttribute("userList", userList);
	%>
	User List
	<table border="1">
		<thead>
			<tr>
				<td>DNI</td>
				<td>Nombre</td>
				<td>Apellido</td>
			</tr>
		</thead>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td><c:out value="${user.dni}" /></td>
				<td><c:out value="${user.nombre}" /></td>
				<td><c:out value="${user.apellido}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>