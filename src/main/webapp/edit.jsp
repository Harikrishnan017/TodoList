<%@page import="dto.taskDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit the task</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="body">
<div class="contain" id="contains">
<% taskDto task= (taskDto) request.getAttribute("task"); %>

<form action="update" method="post">
	<h1><u> Update task</u></h1>

	Task id: <input type="text" name="taskid" placeholder="Enter task Id" value="<%= task.getTaskid() %>" hidden="true"> <br> <br>
	Task Title: <input type="text" name="tasktitle" placeholder="Enter task title" value="<%= task.getTaskTitle() %>"> <br> <br>
	Task Description: <input type="text" name="taskdesc" placeholder="Enter task description" value="<%= task.getTaskDescription() %>"> <br> <br>
	Current task priority is: <p> <b><%= task.getTaskPriority() %> </b></p>
	Task Priority: 
	<input type="radio" name="taskpriority" value="High">High 
	<input type="radio" name="taskpriority" value="Low">Low <br> <br>
	Task Due date: <input type="date" name="duedate" placeholder="Enter duedate" value="<%= task.getTaskDueDate() %>"> <br> <br>
	<button>Submit</button>
</form>
</div>
</body>
</html>