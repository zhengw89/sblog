<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	
	<link href="<spring:url value="/style/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet"/>
	<link href="<spring:url value="/style/bootstrap/css/bootstrap-theme.min.css"/>" rel="stylesheet" />
	<link href="<spring:url value="/style/login.css"/>" rel="stylesheet"/>
	<script src="<spring:url value="/script/jquery-1.11.3.min.js"/>" type="text/javascript"></script>
	<script src="<spring:url value="/script/bootstrap/bootstrap.min.js"/>" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<form method="POST" action="<spring:url value="/login" />" class="form-signin">
			<h2>登录</h2>
			
			<div>用户名</div>
			<div class="form-group">
				<input name="username" type="text" class="form-control"/>
			</div>
			
			<div>密码</div>
			<div class="form-group">
				<input name="password" type="password" class="form-control"/>
			</div>
			<div>
				<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
			</div>
			
			<button class="btn btn-primary" type="submit">登录</button>
		</form>
	</div>
</body>
</html>