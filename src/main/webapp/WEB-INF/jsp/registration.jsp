<%@ include file="../layout/taglib.jsp"%>
<form:form modelAttribute="userForm" cssClass="form-horizontal">
	<div class="form-group">
		<label for="login" class="col-md-2 control-label">Login:</label>
		<div class="col-md-4">
			<form:input path="login" cssClass="form-control" />
			<form:errors path="login" cssClass="text-danger" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-md-2 control-label">Password:</label>
		<div class="col-md-4">
			<form:password path="password" cssClass="form-control" />
			<form:errors path="password" cssClass="text-danger" />
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-md-2 control-label">Name:</label>
		<div class="col-md-4 ">
			<form:input path="name" cssClass="form-control" />
			<form:errors path="name" cssClass="text-danger" />
		</div>
	</div>
	<div class="form-group">
		<label for="lastName" class="col-md-2 control-label">Last
			name:</label>
		<div class="col-md-4">
			<form:input path="lastName" cssClass="form-control" />
			<form:errors path="lastName" cssClass="text-danger" />
		</div>
	</div>
	<div class="form-group">
		<label for="middleName" class="col-md-2 control-label">Middle
			name:</label>
		<div class="col-md-4">
			<form:input path="middleName" cssClass="form-control" />
			<form:errors path="middleName" cssClass="text-danger" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-2 col-md-offset-5">
			<input type="submit" value="Register" class="btn btn-lg btn-primary" />
		</div>
	</div>
</form:form>
