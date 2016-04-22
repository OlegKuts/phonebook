<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script src="js/notes.js"></script>
</head>
<body>
	<div class="container">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Last Name</th>
					<th>Middle Name</th>
					<th>Cell number</th>
					<th>Home phone</th>
					<th>Email</th>
					<th>City</th>
					<th>Street</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 10%"><input id="nameFilter" type="text"
						placeholder="Name" style="width: 90%"></td>
					<td style="width: 10%"><input id="lastNameFilter" type="text"
						placeholder="Last Name" style="width: 90%"></td>
					<td></td>
					<td style="width: 17%"><input id="cellNumberFilter" type="text"
						placeholder="Cell number" style="width: 90%"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<a class="btn btn-primary btn-lg" style="float: right"
			href="<c:url value='/notes/new' />">Add new</a>
	</div>

</body>
</html>

<!--<c:forEach items="${notes}" var="note">
					<tr>
						<td><c:out value="${note.name}" /></td>
						<td><c:out value="${note.lastName}" /></td>
						<td><c:out value="${note.middleName}" /></td>
						<td><c:out value="${note.cellNumber}" /></td>
						<td><c:out value="${note.phoneNumber}" /></td>
						<td><c:out value="${note.email}" /></td>
						<td><c:out value="${note.address.city}" /></td>
						<td><c:out value="${note.address.street}" /></td>
						<td><a class="btn btn-warning btn-xs"
							href="<c:url value='/notes/edit/${note.id}' />">Edit</a></td>
						<td><form:form action='/notes/delete/${note.id}'>
								<input type="submit" value="Delete"
									class="btn btn-danger btn-xs" />
							</form:form></td>
					</tr>
				</c:forEach>-->