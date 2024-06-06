<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add task</title>
<link rel="stylesheet" href="style.css">
</head>
<body class="body">
<div class="contain" id="contains">
<form action="addtask" method="post">
	<h1><u>Add task</u></h1>

	Task id: <input type="text" name="taskid" placeholder="Enter task Id"> <br> <br>
	Task Title: <input type="text" name="tasktitle" placeholder="Enter task title"> <br> <br>
	Task Description: <input type="text" name="taskdesc" placeholder="Enter task description"> <br> <br>
	Task Priority: 
	<input type="radio" name="taskpriority" value="High">High 
	<input type="radio" name="taskpriority" value="Low">Low <br> <br>
	Task Due date: <input type="date" name="duedate" placeholder="Enter duedate"> <br> <br>
	<button>Submit</button>
</form>
</div>
</body>
</html>