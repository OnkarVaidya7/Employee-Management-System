<%@page import="jsp_employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Employee employee = (Employee)request.getAttribute("emp"); %>
	<form action="edit" method="post">
		Id:<input type="hidden" name="id" value=<%=employee.getId()%> readonly><br>
		<br> Name:<input type="text" name="name" value=<%=employee.getName()%>><br>
		<br> Phone:<input type="tel" name="phone" value=<%=employee.getPhone()%>><br>
		<br> Address:<input type="text" name="address" value=<%=employee.getAddress()%>><br>
		<br> Email:<input type="email" name="email" value=<%=employee.getEmail()%>><br>
		<br> Password:<input type="text" name="password" value=<%=employee.getPassword()%>><br>
		<br>
		<button>Update</button>
	</form>
</body>
</html>