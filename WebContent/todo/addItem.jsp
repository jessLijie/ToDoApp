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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/newslist.css" />
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
    </style>
</head>
<body>
	<div class="container">
        <h1>Add an item:</h1>
        <form action="/${Configs.APP}/toDoList" method="post">
        <label for="category">Category:</label>
        <input type="text" id="category" name="category" required><br>

        <label for="items">Items:</label>
        <textarea id="items" name="items" rows="4" required></textarea><br>

        <button type="submit">Add To-Do Item</button>
    </form>
    </div>
	
    
</body>
</html>
