<%@ include file="../layout/taglib.jsp"%>
<script src="js/notes.js"></script>
<div class="container">
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Last name</th>
				<th>Middle name</th>
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
