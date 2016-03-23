<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
		<sitemesh:write property='title' />
	</title>
	
	<spring:url value="/style/bootstrap/css/bootstrap.min.css" var="css_bs"/>
	<spring:url value="/style/bootstrap/css/bootstrap-theme.min.css" var="css_bs_theme" />
	<spring:url value="/style/login.css" var="css_login"/>
	<spring:url value="/style/site-theme.css" var="css_siteTheme"/>
	<spring:url value="/script/jquery-1.11.3.min.js" var="js_jq"/>
	<spring:url value="/script/bootstrap/bootstrap.min.js" var="js_bs"/>
	
	<link href="${css_bs}" rel="stylesheet"/>
	<link href="${css_bs_theme}" rel="stylesheet" />
	<link href="${css_login}" rel="stylesheet" />
	<link href="${css_siteTheme}" rel="stylesheet" />
	<script src="${js_jq}" type="text/javascript"></script>
	<script src="${js_bs}" type="text/javascript"></script>
	
	<sitemesh:write property='head' />
</head>
<body>

	<div class="navbar navbar-bright">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<spring:url value="/"/>">Blog</a>
			</div>
			<div class="navbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<spring:url value="/posts"/>">Posts</a></li>
					<li><a href="<spring:url value="/tags"/>">Tags</a></li>
					<li><a href="#">About</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="container main-container">
		<sitemesh:write property='body' />
	</div>
	
	<div class="container">
		<div class="footer">
			<div class="footer-wrapper"></div>
		</div>
	</div>

</body>
</html>