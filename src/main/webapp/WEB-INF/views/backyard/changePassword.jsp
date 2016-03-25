<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Change password</title>
</head>
<body>
	<h1>Change password</h1>
	
	<spring:url value="/backyard/changePassword" var="changePasswordActionUrl"/>
	<form:form method="POST" action="${changePasswordActionUrl}" class="form-horizontal" commandName="model">
	
		<div class="form-group">
			<div class="col-sm-2 control-label">
				<label>New Password</label>
			</div>
			<div class="col-sm-10">
				<form:input path="newPassword" type="password" class="form-control"/>
				<form:errors path="newPassword" cssClass="error"/>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-2 control-label">
				<label>Confirm Password</label>
			</div>
			<div class="col-sm-10">
				<form:input path="confirmPassword" type="password" class="form-control"/>
				<form:errors path="confirmPassword" cssClass="error"/>
			</div>
		</div>
		
		<div class="form-group">
            <div class="col-sm-2 control-label">
                <button class="btn btn-primary" type="submit">Change</button>
            </div>
        </div>
	</form:form>
</body>
</html>