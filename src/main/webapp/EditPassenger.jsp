<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<a href="PassengerView">Customer</a>
<a href="TicketsServlet">Ticket</a>
<a href="BookingsServlet">Booking</a>
<h1>Customer - Update</h1>
<jsp:useBean id="passenger" scope="request" type="com.sp.midTerm.model.Passenger"/>
<form action="PassengerEditServlet?id=${passenger.id}" method="post">
    <label for="name">First name: </label><input type="text" id="name" name="name" value="<%if (passenger.getName() != null){%><%=passenger.getName()%><%}%>" required><br>
    <label for="gender">Gender: </label><input type="text" id="gender" name="gender" value="<%if (passenger.getGender() != null){%><%=passenger.getGender() %><%}%>" required><br>
    <label for="age">Age: </label><input type="text" id="age" name="age" value="<%if (passenger.getAge() != null){%><%=passenger.getAge() %><%}%>" required><br>
    <label for="email">Email: </label><input type="text" id="email" name="email" value="<%if (passenger.getEmail() != null){%><%=passenger.getEmail() %><%}%>" required><br>
    <input type="submit" value="Update">
</form>
</body>
</html>