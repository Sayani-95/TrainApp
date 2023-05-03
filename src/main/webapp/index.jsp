<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ticket Management System</title>
    <%@include file="./style.jsp"%>
</head>
<body>
<h1>Sign In</h1>
<div>Populated users (username/password): admin@123/admin@123</div>
<form action="SignInServlet" method="post">
	<div class="row">
				<div class="col">
					<div class="form-group">
    <label for="username">Username: </label><input type="text" id="username" name="username" value="<%if (request.getParameter("username") != null)
    {%><%=request.getParameter("username")%><%}%>" required><br>
    </div>
    </div>
    </div>
    <div class="row">
				<div class="col">
					<div class="form-group">
    <label for="password">Password: </label><input type="password" id="password" name="password" value="<%if (request.getParameter("password") != null)
    {%><%=request.getParameter("password")%><%}%>" required><br>
    </div>
    </div>
    </div>
    <button type="submit" class="btn btn-primary">Sign In</button>
</form>
<% if (request.getAttribute("error") != null) {%>
<div style="color: red"><%=request.getAttribute("error")%></div>
<%}%>
</body>
</html>