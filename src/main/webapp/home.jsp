<%@page import="java.util.Base64"%>
<%@page import="dto.userDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.dao"%>
<%@page import="dto.taskDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" href="style.css">
<style>
h2{
	color: white;
}
img{
	height: 150px;
	width: 150px;
	border: 0.5px solid white;
	border-radius: 140px;
}

</style>
</head>
<body>

<a href="addtask.jsp" class="anchor">ADD TASK</a>
<a href="logout" class="anchor">LOG OUT</a>


	<% userDto u = (userDto)request.getSession().getAttribute("user"); %>
	<% int userid=u.getUserId(); %>
	
	<% String username=u.getUserName(); %>
	
	<h2> Welcome! <%= username %> . . .</h2>
	
	<% String image = new String(Base64.getEncoder().encode(u.getUserimage())); %>
	<img alt="" height="" src="<%= image %>" >
	
	<% 
	dao d=new dao();
	List<taskDto> tasks=d.findTask(userid);
	
	%>
	<div class="container">
	
	<table>
	<thead>
	<tr>
	<th>Id </th>
	<th>Title </th>
	<th>Description </th>
	<th>Priority </th>
	<th>Due Date </th>
	<th>Edit </th>
	<th>Update </th>
	
	</tr>
	</thead>
	<% for(taskDto t : tasks) { %> 
	<tbody>
	<tr>
	<td> <%= t.getTaskid() %> </td>
	<td> <%= t.getTaskTitle() %> </td>
	<td> <%= t.getTaskDescription() %> </td>
	<td> <%= t.getTaskPriority() %> </td>
	<td> <%= t.getTaskDueDate() %> </td>
	<td> <a href="delete?id=<%= t.getTaskid()%>"> Delete</a> </td>
	<td> <a href="edit?id=<%= t.getTaskid()%>"> Update</a> </td>
	
	</tr>
	
	<% } %>
	</tbody>
	</table>
	</div>

</body>
</html>