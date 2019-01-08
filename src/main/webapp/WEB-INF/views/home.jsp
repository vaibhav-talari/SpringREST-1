<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<title>Home</title>
</head>
<body class="text-center">
<h1>
Welcome to test Page</h1>

<spring:url value="/" var="contextPath" htmlEscape="true" />
<P>  <a href="${contextPath}login">login</a> </P>







</body>
</html>
