<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="my.utm.ip.demo.mvc.app.Configs"%>
<%@ page import="my.utm.ip.demo.mvc.models.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/login.css" />
    <title>Login Form</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
    <div class="container">
        <c:choose>
            <c:when test="${user.getAuthenticated()}">
                <c:redirect url="/toDoList" />
            </c:when>
            <c:otherwise>
                <h1>Login Page</h1>
                <form id="loginForm" action="/${Configs.APP}/login" method="post">
                    <div class= "login_box">
                    	<input type="text" id="username" name="username" placeholder= "Username" required>
                    </div>
                    <div class= "login_box">
                    	<input type="text" id="password" name="password" placeholder= "Password" required>
                    </div>                    
                    <label for="login"></label>
                    <input type="submit" id="login" name="login" value="Login">
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>