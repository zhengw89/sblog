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
	<h1>Tags</h1>
	<a href="<spring:url value="/backyard/tag/create" />" class="btn btn-default">Create Tag</a>
	<table class="table table-striped table-hover">
		<thead>
			<th style="width: 80%">Name</th>
			<th>Operate</th>
		</thead>
		<tbody>
			<c:forEach items="${tags}" var="tag">
				<tr>
					<td>${tag.name}</td>
					<td>
						<a href="#" data-toggle="modal" data-target="#delete-${tag.id}">Delete</a>
						<div id="delete-${tag.id}" class="modal fade" tabindex="-1" role="dialog">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<form method="POST" action="<spring:url value="/backyard/tag/delete" />">
										<input name="tagId" type="hidden" value="${tag.id}" />
										<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
											<h4 class="modal-title">Delete Tag</h4>
										</div>
										<div class="modal-body">
											<em>delete tag</em> <strong>${tag.name}</strong> ？
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
											<button class="btn btn-primary" type="submit">OK</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>