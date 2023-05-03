<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="PassengerView">Customer</a>
<a href="TicketsServlet">Ticket</a>
<a href="BookingsServlet">Booking</a>
<h1>Booking - List</h1>
<a href="BookingAddServlet">Add Booking</a>
<table border="3">
  <tr>
    <th>Id</th>
    <th>Customer</th>
    <th>Ticket</th>
    <th></th>
  </tr>
  <jsp:useBean id="booking" scope="request" type="java.util.List"/>
  <c:forEach var="booking" items="${booking}">
    <tr>
      <th>${booking.id}</th>
      <th>${booking.customer.id} ${booking.customer.name} ${booking.customer.gender}  ${booking.customer.age}  ${booking.customer.email}</th>
      <th>${booking.ticket.id} ${booking.ticket.name} ${booking.ticket.ticket_date}</th>
      <th>${booking.seatType}</th>
      <th><a href="BookingEditServlet?id=${booking.id}">Update</a> <a href="BookingDeleteServlet?id=${booking.id}">Delete</a></th>
    </tr>
  </c:forEach>
</table>
</body>
</html>
