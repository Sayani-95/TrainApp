<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="./style.jsp"%>
</head>
<body>
<a href="PassengerView">Passenger</a>
<a href="TicketsServlet">Ticket</a>
<a href="BookingsServlet">Booking</a>
<h1>Customer - List</h1>
<a href="PassengerAddServlet">Create</a>
<table class="table table-hover">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Gender</th>
    <th>Age</th>
    <th>Email</th>
    <th></th>
  </tr>
  <jsp:useBean id="passenger" scope="request" type="java.util.List"/>
  <c:forEach var="passenger" items="${passenger}">
    <tr>
      <th>${passenger.id}</th>
      <th>${passenger.name}</th>
      <th>${passenger.gender}</th>
      <th>${passenger.age}</th>
      <th>${passenger.email}</th>
      <th><a href="PassengerEditServlet?id=${passenger.id}">Edit</a></th>
    </tr>
  </c:forEach>
</table>
</body>
</html>