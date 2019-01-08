
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>Login</title>

</head>
<style>
.error {
	color: #ff0000;
}
</style>
<body class="text-center mt-5">
	<spring:url value="/" var="contextPath" htmlEscape="true" />
	<div class="container">
		<div class="col-4 offset-4">

			<form:errors path="myUser.*" cssClass="error" />

			<form:form method="POST" action="${contextPath}authenticate">

				<h1 class="h3 mb-3 font-weight-normal">Login</h1>
				<input type="text" name="userName" id="userName"
					class="form-control" placeholder="User Name">
				<br>
				<input type="password" name="password" id="password"
					class="form-control" placeholder="Password">
				<%-- <p>
					<form:errors path="myUser.password"  />
				</p> --%>
				<br>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
			</form:form>
		</div>
	</div>
</body>
</body>
</html>