<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value = '/resources/css/main.css'/>"/>
<script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script src = "http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript" src = "<c:url value = '/resources/js/mainjs.js'/>"></script>
<title>BOOKS!!!!!!</title>
</head>
<body>
	<table class="table">
		<c:forEach items="${listbook}" var="book">
			<tr class = "bookrow">
				<td>${book.bookid}
					<input type = "hidden" class = "bookimgurl" value = "${book.bookimgurl }"/>
				</td>
				<td>${book.bookauthor}</td>
				<td>${book.bookname }</td>
				<td><a href = "/BookStore/book/delete/${book.bookid}">
								<button class = "btn btn-info">DELETE</button>
								</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href = "/BookStore/book/addbook">Click here to add new one</a>
	
	<div class = "img-container">
		<img id = "img-show" alt="Default" src="<c:url value = '/resources/images/default.png'/>" />
	</div>
</body>
</html>