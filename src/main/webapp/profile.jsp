<%@page import="java.util.Base64"%>
<%@page import="dto.userDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="navigation.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile page</title>
<style>
body{
	background-image: url("https://images.unsplash.com/photo-1515847049296-a281d6401047?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
	background-size: cover;
	background-repeat: no-repeat;
	font-family: "Times New Roman", Times, serif;
	color: white;
}
img{
	height: 170px;
	width: 170px;
	border: 0.5px solid white;
	border-radius: 140px;
}
.div1{
	text-align: center;
}
.div2{
	margin-left: 450px;
	text-align: center;	
	background-color: gray;
	padding: 40px;
	display: inline-block;
}
.an{
	display: inline-block;
	color: black;
	border: 1px solid;
	padding: 10px;
	text-decoration: none;
	margin-left: 70%;
	margin-top: 12px;
	border-radius: 15px;
	background-color: white;
	box-shadow: 1px 1px;
}
.an:hover {
	background-color: gray;
	cursor: pointer;
}
</style>
</head>
<body>
	<% userDto u = (userDto)request.getSession().getAttribute("user"); %>
	<a href="updateprofile?id=<%= u.getUserId() %>" class="an">UPDATE</a>
	<% int userid=u.getUserId(); %>
	
	<% String username=u.getUserName(); %>
	<% String usermail=u.getUserEmail(); %>
	<% long usercontact=u.getUserContact(); %>
	
	<div class="div1">
	<h2> Welcome! <%= username %> . . .</h2>
	<% String image = new String(Base64.getEncoder().encode(u.getUserimage())); %>
	<img alt="" height="" src="data:image/jpeg;base64,<%= image %>" >
	</div>
	<div class="div2">
		<h4> User Name: <%= username %></h4>
		<h4> User Email: <%= usermail %></h4>
		<h4> User Contact: <%= usercontact %></h4>
	</div>
	
	
	
</body>
</html>