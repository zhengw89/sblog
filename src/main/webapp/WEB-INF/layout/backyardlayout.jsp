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
	
	<link href="<spring:url value="/style/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet"/>
	<link href="<spring:url value="/style/bootstrap/css/bootstrap-theme.min.css"/>" rel="stylesheet" />
	<link href="<spring:url value="/style/backyard-theme.css"/>" rel="stylesheet" />
	<script src="<spring:url value="/script/jquery-1.11.3.min.js"/>" type="text/javascript"></script>
	<script src="<spring:url value="/script/bootstrap/bootstrap.min.js"/>" type="text/javascript"></script>
	
	<sitemesh:write property='head' />
</head>
<body>
	<!-- Navigation -->
    <div class="navbar navbar-default navbar-custom">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<spring:url value="/"/>">Blog<small> -- ${userDisplayName}</small></a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<spring:url value="/backyard/tags"/>">Tags</a></li>
                    <li><a href="<spring:url value="/backyard/posts"/>">Posts</a></li>
                    <li>
						<form class="logout-form" action="<spring:url value="/logout" />" method="post" >
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<button class="btn btn-link" type="submit">Logout</button>
						</form>
					</li>
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