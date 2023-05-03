<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="CustomersServlet">Customer</a>
<a href="TicketsServlet">Ticket</a>
<a href="BookingsServlet">Booking</a>
<h1>Ticket - List</h1>
<a href="TicketAddServlet">Create</a>
<table border="3">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Ticket Date</th>
    <th></th>
  </tr>
  <jsp:useBean id="ticket" scope="request" type="java.util.List"/>
  <c:forEach var="ticket" items="${ticket}">
    <tr>
      <th>${ticket.id}</th>
      <th>${ticket.name}</th>
      <th>${ticket.ticket_date}</th>
      <th><a href="EditTicketServlet?id=${ticket.id}">Update</a></th>
    </tr>
  </c:forEach>
</table>
</body>
</html>