<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
</head>
<body>
	<b style="color:red">Error</b>, el usuario
	<b><%=request.getParameter("nombre")%></b>
	<b><%=request.getParameter("apellido")%></b> ya existe.
</body>
</html>