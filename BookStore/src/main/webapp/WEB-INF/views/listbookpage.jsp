<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BOOKS!!!!!!</title>
</head>
<body>
	<table class="table">
		<c:forEach items="${listbook}" var="book">
			<tr>
				<td>${book.bookid}</td>
				<td>${book.bookauthor}</td>
				<td>${book.bookname }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>