<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="body">

<div class="contain" id="contains">
<h1><u>Login Page</u></h1>
<form action="login" method="post">

Email: <input type="email" name="email" placeholder="Enter your email"> <br> <br> 
Password: <input type="text" name="password" placeholder="Enter your password"> <br> <br>
<button>Submit</button>
</form>

<% String msg=(String) request.getAttribute("message"); %>
<% if(msg!=null){ %>

<h3><%= msg %></h3>

<% } %>
</div>

</body>
</html>