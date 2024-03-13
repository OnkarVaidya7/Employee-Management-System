<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<h2><%=message%></h2>
	<%
	}
	%>
	<form action="save" method="post">
		Id:<input type="number" name="id"><br>
		<br> Name:<input type="text" name="name"><br>
		<br> Phone:<input type="tel" name="phone"><br>
		<br> Address:<input type="text" name="address"><br>
		<br> Email:<input type="email" name="email"><br>
		<br> Password:<input type="text" name="password"><br>
		<br>
		<button>Register</button>
	</form>
</body>
</html>