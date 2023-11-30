<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="my.utm.ip.demo.mvc.app.Configs"%>
<%@ page import="my.utm.ip.demo.mvc.models.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/login_error.css" />
    <title>Login Error</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
    <div class="container">
		<h1>Cannot login! Invalid username or password</h1>
		<h4>Please try <a href="login.jsp">login</a> again</h4>
    </div>
</body>
</html>