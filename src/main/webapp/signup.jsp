<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up page</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="body">

<div class="contain" id="contains">
<h1> <u> Sign Up Page </u></h1>

<form action="signup" method="post" enctype="multipart/form-data">

User Id: <input type="text" name="id" placeholder="Enter user Id"> <br> <br>
User Name: <input type="text" name="name" placeholder="Enter user name"> <br> <br>
User Email: <input type="text" name="email" placeholder="Enter user Email"> <br> <br>
User Contact: <input type="number" name="contact" placeholder="Enter user contact"> <br> <br>
User Password: <input type="password" name="password" placeholder="Enter password"> <br> <br>
User Image: <input type="file" name="image" placeholder="Upload image"> <br> <br>
<button>Submit</button>

</form>
</div>

</body>
</html>