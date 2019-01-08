<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>BOOK</title>
</head>

<body>
<h1>
Available Books</h1>
<table border="1" >
<spring:url value="/" var="contextPath" htmlEscape="true"></spring:url>

		<tr>
			<th>ID</th>
			<th>TITLE</th>
			<th>PRICE</th>
			<th>VOLUME</th>
			<th>PUBLISHED DATE</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="11" align="center">No record found to display.</td>
			</tr>
		</c:if>
 	<%-- <c:forEach var="bks" items="${list}">
			<tr>
				<td>${bks.bookid}</td>
				<td>${bks.title}</td>
				<td>${bks.price}</td>
				<td>${bks.volume}</td> 
				<td>${bks.publishDate}</td>

			</tr>
 	</c:forEach>  --%>
 	<tr>
				<td>${list.bookid}</td>
				<td>${list.title}</td>
				<td>${list.price}</td>
				<td>${list.volume}</td> 
 				<td>${list.date}</td>
				

			</tr>
 </table>
<br>
<a href="${contextPath}addbook">ADD BOOK</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${contextPath}/">MAIN MENU</a></body>
</html>
