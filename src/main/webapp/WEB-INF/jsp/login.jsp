<%@ include file="../layout/taglib.jsp"%>

<c:if test="${param.successful ne null}">
	<div class="alert alert-success">Registration successful</div>
</c:if>
<c:if test="${param.error ne null}">
	<div class="alert alert-danger">Your login attempt was not
		successful, try again</div>
</c:if>
<form class="form-signin" role="form"
	action="<spring:url value="/login" />" method="POST">
	<h2 class="form-signin-heading">Please sign in</h2>
	<input type="text" name="username" class="form-control"
		placeholder="Name"> <input type="password" name="password"
		class="form-control" placeholder="Password">
	<!--  <input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />-->
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
		in</button>
</form>
<style>
<!--
.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}
.form-signin .checkbox {
	font-weight: normal;
}
.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}
.form-signin .form-control:focus {
	z-index: 2;
}
.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
-->
</style>