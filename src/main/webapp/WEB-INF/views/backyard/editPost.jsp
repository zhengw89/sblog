<%@page import="com.sblog.web.viewmodel.EditPostModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edit Post</title>
</head>
<body>
	<spring:url value="/backyard/post/edit/${postId}" var="editPostActionUrl"/>
	<form:form method="POST" action="${editPostActionUrl}" class="form-horizontal" commandName="post">
		<div class="form-group">
			<div class="col-sm-2 control-label">
				<label>Title</label>
			</div>
			<div class="col-sm-10">
				<form:input path="title" type="text" class="form-control"/>
				<form:errors path="title" cssClass="error"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2 control-label">
				<label>Content</label>
			</div>
			<div class="col-sm-10">
				<form:textarea path="content" rows="5" cols="30" class="form-control"/>
				<form:errors path="content" cssClass="error"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2 control-label">
				<label>Tags</label>
			</div>
			<div class="col-sm-10">
				<c:forEach items="${post.tagStatus}" var="tagStatus">
					<c:choose>
					    <c:when test="${tagStatus.isChecked}">
					        <form:checkbox path="tags" id="${tagStatus.tagId}" value="${tagStatus.tagId}" checked="checked"></form:checkbox>${tagStatus.tagName}
					    </c:when>
					    <c:otherwise>
					        <form:checkbox path="tags" id="${tagStatus.tagId}" value="${tagStatus.tagId}"></form:checkbox>${tagStatus.tagName}
					    </c:otherwise>
					</c:choose>
					
				</c:forEach>
			</div>
		</div>
		<div class="form-group">
            <div class="col-sm-2 control-label">
                <button class="btn btn-primary" type="submit">Edit</button>
            </div>
        </div>
	</form:form>
</body>
</html>