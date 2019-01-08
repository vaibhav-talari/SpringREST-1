<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>BOOK</title>
</head>
<style>
.error {
	color: #ff0000;
}
</style>
<body class="container">
	<h1 class="text-center">PLEASE ENTER BOOK DETAILS</h1>
	<hr>
	<%-- <form:errors path="booksadd.*" cssClass="error" /> --%>
	<form:form method="POST" action="addbook" modelAttribute="booksadd">
		<div class="form-group">
			<label>BOOK-ID:</label> <input type="number" class="form-control"
				name="bookid" placeholder="Enter Book ID">
			<form:errors path="bookid" cssClass="error" />
		</div>

		<div class="form-group">
			<label>BOOK-TITLE:</label> <input type="text" class="form-control"
				name="title" placeholder="Enter Book Title">
			<form:errors path="title" cssClass="error" />
		</div>
		<div class="form-group">
			<label>BOOK-PRICE:</label> <input type="number" class="form-control"
				name="price" placeholder="Enter Book Price">
			<form:errors path="price" cssClass="error" />
		</div>
		<div class="form-group">
			<label>BOOK-VOLUME:</label> <input type="number" class="form-control"
				name="volume" placeholder="Enter Book Volume">
			<form:errors path="volume" cssClass="error" />
		</div>
		  <div class="form-group">
			<label>BOOK-PUBLISHED DATE:</label> <input type="date" class="form-control"
				name="publishDate"
				placeholder="Enter Book Published Date (DD/MM/YYYY)">
			<form:errors path="publishDate" cssClass="error" />
		</div> 
		 
		
		<br>
		<button type="submit" class="btn btn-outline-dark">ADD BOOK</button>
		<button type="reset" class="btn btn-outline-dark">RESET</button>
	</form:form>
</body>
</html>
