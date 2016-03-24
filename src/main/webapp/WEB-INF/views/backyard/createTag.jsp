<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Create Tag</title>
</head>
<body>
	<h1>Create Tag</h1>
	
	<spring:url value="/backyard/tag/create" var="createTagActionUrl"/>
	<form:form method="POST" action="${createTagActionUrl}" class="form-horizontal" commandName="tag">
		<div class="form-group">
			<div class="col-sm-2 control-label">
				<label>Tag</label>
			</div>
			<div class="col-sm-10">
				<form:input path="tag" type="text" class="form-control"/>
				<form:errors path="tag" cssClass="error"/>
			</div>
		</div>
		<div class="form-group">
            <div class="col-sm-2 control-label">
                <button class="btn btn-primary" type="submit">Create</button>
            </div>
        </div>
	</form:form>
</body>
</html>