
<%@page import="dto.userDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update user profile</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="body">
<div class="contain" id="contains">
<% userDto user= (userDto) request.getAttribute("user"); %>

<h1> <u> Update User Details </u></h1>


<form action="updateuser" method="post" enctype="multipart/form-data">

User Id: <input type="text" name="id" placeholder="Enter user Id" value="<%= user.getUserId() %>" hidden="true"> <br> <br>
User Name: <input type="text" name="name" placeholder="Enter user name" value="<%= user.getUserName() %>"> <br> <br>
User Email: <input type="text" name="email" placeholder="Enter user Email" value="<%= user.getUserEmail() %>"> <br> <br>
User Contact: <input type="text" name="contact" placeholder="Enter user contact" value="<%= user.getUserContact() %>"> <br> <br>
User Password: <input type="text" name="password" placeholder="Enter password" value="<%= user.getUserPassword() %>"> <br> <br>
User Image: <input type="file" name="image" placeholder="Upload image" value="<%= user.getUserimage()%>"> <br> <br>
<button>Submit</button>

</form>
</div>

</body>
</html>