<%@ include file="../layout/taglib.jsp"%>
<div class="container">
	<form:form modelAttribute="noteForm" cssClass="form-horizontal"
		action="/notes/update">
		<div class="form-group">
			<label for="note.name" class="col-md-2 control-label">Name:</label>
			<div class="col-md-4">
				<form:input path="note.name" cssClass="form-control" />
				<form:errors path="note.name" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group">
			<label for="note.lastName" class="col-md-2 control-label">Last
				name:</label>
			<div class="col-md-4">
				<form:input path="note.lastName" cssClass="form-control" />
				<form:errors path="note.lastName" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group">
			<label for="note.middleName" class="col-md-2 control-label">Middle
				name:</label>
			<div class="col-md-4">
				<form:input path="note.middleName" cssClass="form-control" />
				<form:errors path="note.middleName" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group">
			<label for="note.cellNumber" class="col-md-2 control-label">Cell
				number:</label>
			<div class="col-md-4">
				<form:input path="note.cellNumber" cssClass="form-control" />
				<form:errors path="note.cellNumber" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group">
			<label for="note.phoneNumber" class="col-md-2 control-label">Home
				phone:</label>
			<div class="col-md-4">
				<form:input path="note.phoneNumber" cssClass="form-control" />
				<form:errors path="note.phoneNumber" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group">
			<label for="note.email" class="col-md-2 control-label">Email:</label>
			<div class="col-md-4">
				<form:input path="note.email" cssClass="form-control" />
				<form:errors path="note.email" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group">
			<label for="address.city" class="col-md-2 control-label">City:</label>
			<div class="col-md-4">
				<form:input path="address.city" cssClass="form-control" />
				<form:errors path="address.city" cssClass="text-danger" />
			</div>
		</div>
		<div class="form-group">
			<label for="address.street" class="col-md-2 control-label">Street:</label>
			<div class="col-md-4">
				<form:input path="address.street" cssClass="form-control" />
				<form:errors path="address.street" cssClass="text-danger" />
			</div>
		</div>
		<form:hidden path="note.id" />
		<form:hidden path="note.user.id" />
		<form:hidden path="address.id" />
		<div class="form-group">
			<div class="col-md-2 col-md-offset-5">
				<input type="submit" value="Edit" class="btn btn-lg btn-primary" />
			</div>
		</div>
	</form:form>
</div>
