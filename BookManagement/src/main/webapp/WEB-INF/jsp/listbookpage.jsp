<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src = '<c:url value = "/resources/js/main.js"></c:url>'></script>
<title>List Book</title>
</head>
<body>
	<h2>List Book</h2>
	<h4><a href = "/BookManagement/bookmng/addnewbook">Add new book</a></h4>
	Search: <input type = "text" id = "searchform" class = "form-control" />
			<button class = "btn btn-info" id = "btnSearch">Search</button>
	<table class = "table table-bordered">
	<c:forEach items="${listbook}" var="book">
		<tr>
			<td>
			<c:out value="${book.bookid }" />
			</td>
		<td><c:out value="${book.bookname }" />
		<td><c:out value="${book.bookprice }" />
		</td>
		<td><a href = "/BookManagement/bookmng/update?id=<c:out value="${book.bookid }"/>
													&name=<c:out value="${book.bookname }" />
													&url=<c:out value="${book.bookimgurl }" />
													&price=<c:out value="${book.bookprice }" />
													">
			<Button class = "btn btn-info">Edit</Button>
			</a></td>
		<td><a href = '<c:out value="${book.bookimgurl }" />'>Image Link</a></td>
		<td><a href = "/BookManagement/bookmng/delete?id=<c:out value="${book.bookid }" />">Delete</a></td>
		<td><a href = '<c:out value="/BookManagement/bookmng/jsonbook/${book.bookid }/
																	${book.bookname }/
																	${book.bookimgurl }/
																	${book.bookprice }" />'>Get JSON</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>