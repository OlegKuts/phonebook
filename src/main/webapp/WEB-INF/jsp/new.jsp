<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form:form modelAttribute="noteForm" cssClass="form-horizontal"
			action="/notes/create">
			<div class="form-group">
				<label for="note.name" class="col-sm-2 control-label">Name:</label>
				<div class="col-sm-4">
					<form:input path="note.name" cssClass="form-control" />
					<form:errors path="note.name" cssClass="text-danger" />
				</div>
			</div><div class="form-group">
				<label for="note.lastName" class="col-sm-2 control-label">Last Name:</label>
				<div class="col-sm-4">
					<form:input path="note.lastName" cssClass="form-control" />
					<form:errors path="note.lastName" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label for="note.middleName" class="col-sm-2 control-label">Middle Name:</label>
				<div class="col-sm-4">
					<form:input path="note.middleName" cssClass="form-control" />
					<form:errors path="note.middleName" cssClass="text-danger" />
				</div>
			</div><div class="form-group">
				<label for="note.cellNumber" class="col-sm-2 control-label">Cell number:</label>
				<div class="col-sm-4">
					<form:input path="note.cellNumber" cssClass="form-control" />
					<form:errors path="note.cellNumber" cssClass="text-danger" />
				</div>
			</div><div class="form-group">
				<label for="note.phoneNumber" class="col-sm-2 control-label">Home phone:</label>
				<div class="col-sm-4">
					<form:input path="note.phoneNumber" cssClass="form-control" />
					<form:errors path="note.phoneNumber" cssClass="text-danger" />
				</div>
			</div><div class="form-group">
				<label for="note.email" class="col-sm-2 control-label">Email:</label>
				<div class="col-sm-4">
					<form:input path="note.email" cssClass="form-control" />
					<form:errors path="note.email" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label for="address.city" class="col-sm-2 control-label">City:</label>
				<div class="col-sm-4">
					<form:input path="address.city" cssClass="form-control" />
					<form:errors path="address.city" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<label for="address.street" class="col-sm-2 control-label">Street:</label>
				<div class="col-sm-4">
					<form:input path="address.street" cssClass="form-control" />
					<form:errors path="address.street" cssClass="text-danger" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10">
					<input type="submit" value="Save" class="btn btn-lg btn-primary" />
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>