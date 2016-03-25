<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>
</head>
<body>
	<h2>${title}</h2>
	<div>
		<fmt:formatDate pattern="yyyy-MM-dd" value="${publishTime}" />
	</div>
	<div>
		${content}
	</div>
	<div>
		<ul>
			<c:forEach items="${tags}" var="tag">
				<li>
					<a class="btn btn-default btn-xs" href="<spring:url value="/tag/${tag.name}" />">${tag.name}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>