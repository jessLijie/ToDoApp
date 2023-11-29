<%@ page language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="my.utm.ip.demo.mvc.models.ToDoItems"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/app/jsp/header.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Items</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/css/todo.css" />
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 600px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #333;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin-bottom: 5px;
	color: #333;
}

select, textarea, input {
	margin-bottom: 10px;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
	font-size: 16px;
}

select {
	appearance: none;
	background-color: #fff;
	background-image: linear-gradient(45deg, transparent 50%, #ccc 50%),
		linear-gradient(135deg, #ccc 50%, transparent 50%);
	background-position: calc(100% - 20px) calc(1em + 2px),
		calc(100% - 15px) calc(1em + 2px);
	background-size: 5px 5px, 5px 5px;
	background-repeat: no-repeat;
}

select:hover {
	background-color: #f9f9f9;
}

button {
	background-color: #3498db;
	color: #fff;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

button:hover {
	background-color: #2980b9;
}

#dueTime {
	display: flex;
}

#dueHour, #dueMinute, #dueSecond {
	width: 100px;
	margin-right: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Add an item:</h1>
		<form action="/${Configs.APP}/addItemController" method="post">
			<label for="colorCode">Color Label</label> <select id="colorCode"
				name="colorCode" required>
				<option value="#e74c3c" style="background-color: #e74c3c;">Red</option>
				<option value="#3498db" style="background-color: #3498db;">Blue</option>
				<option value="#e67e22" style="background-color: #e67e22;">Orange</option>
				<option value="#f39c12" style="background-color: #F5FF33;">Yellow</option>
				<option value="#2ecc71" style="background-color: #2ecc71;">Green</option>
				<option value="#8e44ad" style="background-color: #8e44ad;">Purple</option>

			</select> <br> <label for="category">Category</label> <select
				id="category" name="category" required>
				<option value="Work">Work</option>
				<option value="Personal">Personal</option>
				<option value="Study">Study</option>
			</select><br> <label for="items">Item</label>
			<textarea id="items" name="items" rows="4" required></textarea>
			<br> <label for="dueTime">Due Time</label> <input type="time"
				id="dueTime" name="dueTime" required> <br>



			<button type="submit">Add To-Do Item</button>
		</form>
	</div>


</body>
</html>
