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
			</div>
			<div class="form-group">
				<label for="note.name" class="col-sm-2 control-label">State:</label>
				<div class="col-sm-4">
					<form:input path="address.state" cssClass="form-control" />
					<form:errors path="address.state" cssClass="text-danger" />
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