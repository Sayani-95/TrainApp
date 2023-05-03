<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Passenger Create</title>
</head>
<body>
<div class="d-flex align-items-center flex-column">
	<a href="PassengerView" class="btn btn-primary text-center p-2">Passenger Portal </a>
	<br/> 
	<a href="TicketsServlet" class="btn btn-primary text-center p-2">Ticket details</a>
	<a href="BookingsServlet" class="btn btn-primary text-center p-2">Bookings</a>
</div>
<h1>Add Passenger</h1>
<form action="PassengerAddServlet" method="post">
    <label for="name">Name: </label><input type="text" id="name" name="name" value="<%if (request.getParameter("name") != null){%><%=request.getParameter("name")%><%}%>" required><br>
    <label for="last_name">Gender: </label><input type="text" id="gender" name="gender" value="<%if (request.getParameter("gender") != null){%><%=request.getParameter("gender")%><%}%>" required><br>
    <label for="last_name">Age: </label><input type="text" id="age" name="age" value="<%if (request.getParameter("age") != null){%><%=request.getParameter("age")%><%}%>" required><br>
    <label for="last_name">Email: </label><input type="text" id="email" name="email" value="<%if (request.getParameter("email") != null){%><%=request.getParameter("email")%><%}%>" required><br>
    <input type="submit" value="Create">
</form>
</body>
</html>