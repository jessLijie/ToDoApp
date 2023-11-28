<%@ page language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="my.utm.ip.demo.mvc.models.ToDoItems"%>
<%@ page import="my.utm.ip.demo.mvc.services.MockDatabase"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/app/jsp/header.jspf"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>To Do List</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/css/newslist.css" />
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
<script>
    function filterToDoItems(selectedCategory) {
        console.log('Selected Category:', selectedCategory);

        var toDoItems = document.querySelectorAll('.todo-item');

        toDoItems.forEach(function (toDoItem) {
            var category = toDoItem.dataset.category;
            console.log('Item Category:', category);

            if (selectedCategory === 'all' || selectedCategory === category) {
                toDoItem.style.display = 'block';
            } else {
                toDoItem.style.display = 'none';
            }
        });
    }
</script>

</head>
<body>

	<div class="container">
		<h1>Today</h1>
		
		<a href="${pageContext.request.contextPath}/todo/addItem.jsp">+Add
			Item</a> <br><br>
			<label for="categoryFilter">Filter by Category:</label>
        <select id="categoryFilter" onchange="filterToDoItems(this.value)">
            <option value="all">All</option>
            <option value="Work">Work</option>
            <option value="Personal">Personal</option>
            <option value="Study">Study</option>
        </select>
		<ul>
			<%
				ArrayList<ToDoItems> toDoItems = (ArrayList<ToDoItems>) request.getAttribute("toDoItems");
				if (toDoItems != null && !toDoItems.isEmpty()) {
					for (ToDoItems toDoItem : toDoItems) {
			%>
			

			<li class="todo-item" data-category="<%=toDoItem.getCategory()%>">
				<p class="todo-title">
					<strong><span style="color: <%=toDoItem.getColorCode()%>">&#11044;</span></strong>
					<%=toDoItem.getCategory()%></p>
				<p class="todo-content">
					<strong>&#8594;</strong>
					<%=toDoItem.getItems()%></p>

				<p class="todo-content">
					<strong>&#8987;</strong>
					<fmt:formatDate value="<%=toDoItem.getDueTime()%>" pattern="hh:mm a" />
				</p>
			</li>
			
			<%
				}
			%>
		</ul>
		<%
			} else {
		%>
		<p>-- To Do List is empty --</p>
		<%
			}
		%>

		<%-- <ul>
            <c:forEach var="toDoItem" items="${toDoItems}">
                <li>
                    <p class="todo-title"><strong><span style="color: ${toDoItem.getColorCode()}">&#11044;</span></strong> ${toDoItem.getCategory()}</p>
                    <p class="todo-content"><strong>&#8594;</strong> ${toDoItem.getItems()}</p>
                    <p class="todo-content"><strong>&#128197;</strong> ${toDoItem.getDueTime()}</p>
                </li>
                <hr>
            </c:forEach>
        </ul> --%>
	</div>

</body>
</html>
