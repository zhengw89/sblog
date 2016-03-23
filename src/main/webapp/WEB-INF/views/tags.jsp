<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Tags</title>
</head>
<body>
	<div>
		<ul>
			<c:forEach items="${tagSummarys}" var="tagSummary">
				<li>
					<a class="btn btn-default" href="<spring:url value="/tag/${tagSummary.tagName}" />">${tagSummary.tagName} -- ${tagSummary.postCount}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>