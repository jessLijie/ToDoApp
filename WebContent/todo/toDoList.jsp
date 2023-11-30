<%@ page language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="my.utm.ip.demo.mvc.models.ToDoItems"%>
<%@ page import="my.utm.ip.demo.mvc.services.MockDatabase"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ include file="/app/jsp/header.jspf"%>
<%@ page import="my.utm.ip.demo.mvc.models.User"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>To Do List</title>
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
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
}
</style>
<script>
	function filterToDoItems(selectedCategory) {
		console.log('Selected Category:', selectedCategory);

		var toDoItems = document.querySelectorAll('.todo-item');

		toDoItems.forEach(function(toDoItem) {
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

	<%
		session = request.getSession(false);
		User user = (User) request.getSession().getAttribute("user");
	%>
	
	
	<div class="container">
		<h1>Today</h1>
		<h3>Hello <%=user.getRealName()%></h3>

		<div class= "todo-actions">
			<div class= "add-item-box">
				<a href="${pageContext.request.contextPath}/todo/addItem.jsp" class="add-item-button">+ Add Item</a>	
			</div>
			
			<div>
				<label for="categoryFilter">Filter by Category:</label> 
				<select
					id="categoryFilter" onchange="filterToDoItems(this.value)">
					<option value="all">All</option>
					<option value="Work">Work</option>
					<option value="Personal">Personal</option>
					<option value="Study">Study</option>
				</select>
			</div>
		</div>

		<ul>
			<%
				ArrayList<ToDoItems> toDoItems = (ArrayList<ToDoItems>) session.getAttribute("toDoItems");
				if (toDoItems != null && !toDoItems.isEmpty()) {
					for (ToDoItems toDoItem : toDoItems) {
					if(user.getId()==5){%>
						<li class="todo-item" data-category="<%=toDoItem.getCategory()%>">
				<p class="todo-title">
					<strong><span style="color: <%=toDoItem.getColorCode()%>">&#11044;</span></strong>
					<%=toDoItem.getCategory()%></p>
				<p class="todo-content">
					<strong>&#8594;</strong>
					<%=toDoItem.getItems()%></p>

				<p class="todo-content">
					<strong>&#8987;</strong>
					<fmt:formatDate value="<%=toDoItem.getDueTime()%>"
						pattern="hh:mm a" />
				</p>

				<p class="todo-user">
					 <%=user.getRealNameById(toDoItem.getUserId())%>
				</p>
			</li>
					<%}
					else if (toDoItem.getUserId() == user.getId()) {
						%>
			<li class="todo-item" data-category="<%=toDoItem.getCategory()%>">
			<div class= "todo-item-box">
				<div class= "todo-item-content">
					<p class="todo-title">
						<strong><span style="color: <%=toDoItem.getColorCode()%>">&#11044;</span></strong>
						<%=toDoItem.getCategory()%>
					</p>
					
					<p class="todo-content" id="todoContent<%=toDoItem.getId()%>">
					    <strong>&#8594;</strong>
					    <%=toDoItem.getItems()%>
					</p>
				</div>	
					<p class="todo-time">
						<strong>&#8987;</strong>
						<fmt:formatDate value="<%=toDoItem.getDueTime()%>"
							pattern="hh:mm a" />
					</p>
			</div>
 

			</li>

			<%
				}
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