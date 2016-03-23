<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Posts</title>
</head>
<body>
	<h1>Posts</h1>
	<a href="<spring:url value="/backyard/post/create" />" class="btn btn-default">Create Post</a>
	<table class="table table-striped table-hover">
		<thead>
			<th style="width: 80%">Title</th>
			<th>Operate</th>
		</thead>
		<tbody>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td>${post.title}</td>
					<td>
						<a href="#">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>