<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</head>
<body>
	<form:form modelAttribute="userForm" cssClass="form-horizontal">
	<div class="form-group">
		<label for="login" class="col-sm-2 control-label">Login:</label>
		<div class="col-sm-4">
			<form:input path="login" cssClass="form-control" />
			<form:errors path="login" cssClass="text-danger"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password:</label>
		<div class="col-sm-4">
			<form:password path="password" cssClass="form-control" />
			<form:errors path="password" cssClass="text-danger"/>
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">First
			Name:</label>
		<div class="col-sm-4 ">
			<form:input path="name" cssClass="form-control" />
			<form:errors path="name" cssClass="text-danger"/>
		</div>
	</div>
	<div class="form-group">
		<label for="lastName" class="col-sm-2 control-label">Last
			Name:</label>
		<div class="col-sm-4">
			<form:input path="lastName" cssClass="form-control" />
			<form:errors path="lastName" cssClass="text-danger"/>
		</div>
	</div>
	<div class="form-group">
		<label for="middleName" class="col-sm-2 control-label">Middle Name:</label>
		<div class="col-sm-4">
			<form:input path="middleName" cssClass="form-control"/>
			<form:errors path="middleName" cssClass="text-danger"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2 col-sm-offset-5">
			<input type="submit" value="Register" class="btn btn-lg btn-primary" />
		</div>
	</div>
</form:form>
</body>
</html>