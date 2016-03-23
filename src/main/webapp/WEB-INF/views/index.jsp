<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Index</title>
</head>
<body>
	<div>
		<h2 class="post-item">Latest Posts</h2>
		<c:forEach items="${posts}" var="post">
			<a href="<spring:url value="/post/${post.id}" />">
				<div class="post-item">
					<h2>${post.title}</h2>
					<div class="post-date">
						<fmt:formatDate pattern="yyyy-MM-dd" value="${post.publishTime}" />
					</div>
				</div>
			</a>
		</c:forEach>
	</div>
</body>
</html>