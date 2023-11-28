<%@ page language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="my.utm.ip.demo.mvc.models.News"%>
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
<title>News List</title>
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

.news-container {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	justify-content: space-around;
}

.news-box {
	width:800px;
	cursor: pointer;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	transition: transform 0.3s;
}

.news-box:hover {
	transform: scale(1.05);
}

.news-box img {
	width: 100%;
	height: 200px;
	object-fit: cover;
	border-bottom: 1px solid #ddd;
}

.news-details {
	padding: 15px;
}

.news-title {
	font-size: 1.2rem;
	margin-bottom: 10px;
	color: #333;
}

.news-author {
	font-size: 0.8rem;
	color: #777;
}

.news-date {
	font-size: 0.8rem;
	color: #777;
	margin-top: 5px;
}
</style>
<script>
	// Function to calculate the time elapsed
	function timeElapsed(publishDate) {
		const now = new Date();
		const publishedAt = new Date(publishDate);
		const elapsedMilliseconds = now - publishedAt;
		const elapsedSeconds = Math.floor(elapsedMilliseconds / 1000);

		if (elapsedSeconds < 60) {
			return elapsedSeconds + ' seconds ago';
		}

		const elapsedMinutes = Math.floor(elapsedSeconds / 60);
		if (elapsedMinutes < 60) {
			return elapsedMinutes
					+ (elapsedMinutes === 1 ? ' minute ago' : ' minutes ago');
		}

		const elapsedHours = Math.floor(elapsedMinutes / 60);
		if (elapsedHours < 24) {
			return elapsedHours
					+ (elapsedHours === 1 ? ' hour ago' : ' hours ago');
		}

		const options = {
			year : 'numeric',
			month : 'long',
			day : 'numeric',
			timeZone : 'Asia/Kuala_Lumpur'
		};
		return publishedAt.toLocaleString('en-US', options);
	}

	// Redirect to the detailed content page when a news box is clicked
	function redirectToDetailPage(contentUrl) {
		window.location.href = contentUrl;
	}

	// Update the time elapsed for each news item
	document.addEventListener('DOMContentLoaded', function() {
		const newsBoxElements = document.querySelectorAll('.news-box');

		newsBoxElements.forEach(function(element) {
			element.addEventListener('click', function() {
				const contentUrl = element.getAttribute('data-content-url');
				redirectToDetailPage(contentUrl);
			});

			const publishDate = element.getAttribute('data-publish-date');
			const elapsed = timeElapsed(publishDate);
			element.querySelector('.news-date').textContent = elapsed;
		});
	});
</script>
</head>
<body>

	<div class="container">
		<h1>News List</h1>

		<div class="news-container">
			<%-- <%
		
		    ArrayList<News> newsList = (ArrayList<News>) request.getAttribute("news");
		    if (newsList != null && !newsList.isEmpty()) {
		        for (News newsItem : newsList) {
		%>
		            <p><img src="${pageContext.request.contextPath}${newsItem.getImageUrl()}"
		                    alt="images">
		                    </p>
		                   
		                    <p>${newsItem.getTitle()}</p>
		                    
		<%
		        }
		    } else {
		%>
		        <p>No news to display</p>
		<%
		    }
		%> --%>
					

			<%
                ArrayList<News> newsList = (ArrayList<News>) request.getAttribute("news");
                if (newsList != null && !newsList.isEmpty()) {
                    for (News newsItem : newsList) {
                    	System.out.println("News Title: " + newsItem.getTitle());
                        System.out.println("Image Path: " + newsItem.getImageUrl());
                    	
            %>
            <div class="news-box" data-content-url="<%=newsItem.getContent()%>"
                 data-publish-date="<%=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(newsItem.getDate())%>">
                <div class="news-publisher"><%=newsItem.getPublisher()%></div>
                <img src="${pageContext.request.contextPath}/app/images/${newsItem.getImageUrl()}"
                    alt="images">
                <div class="news-details">
                    <div class="news-title"><%=newsItem.getTitle()%></div>
                    <div class="news-author"><%=newsItem.getAuthor()%></div>
                    <div class="news-date"></div>
                </div>
            </div>
            <%
                }
                } else {
            %>
            <p>No news to display</p>
            <%
                }
            %> 
		</div>

	</div>

</body>
</html>
