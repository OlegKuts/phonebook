<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Notes</title>

<!-- Bootstrap -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<th>Id</th>
				<th>Name</th>
				<th>State</th>
				<th>Edit</th>
				<th>Delete</th>
			</thead>
			<tbody>
				<c:forEach items="${notes}" var="note">
					<tr>
						<td><c:out value="${note.id}" /></td>
						<td><c:out value="${note.name}" /></td>
						<td><c:out value="${note.address.state}" /></td>
						<td><a class="btn btn-warning btn-sm"
							href="<c:url value='/notes/edit/${note.id}' />">Edit</a></td>
						<td><form:form action='/notes/delete/${note.id}'>
								<input type="submit" value="Delete"
									class="btn btn-danger btn-sm" />
							</form:form></td>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-primary btn-lg" style="float:right" href="<c:url value='/notes/new' />">Add
				new</a>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>