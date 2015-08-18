<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>List Book</title>
</head>
<body>
	<h2>List Book</h2>
	<h4><a href = "/EmployeeManagement/addnewbook">Add new book</a></h4>
	<table class = "table table-bordered">
	<c:forEach begin="0" end="${fn:length(listbook) - 1 }" var="index">
		<tr>
			<td>
			<c:out value="${listbook[index].bookid }" />
			</td>
		<td><c:out value="${listbook[index].bookname }" />
		</td>
		<td><a href = "/EmployeeManagement/update?id=<c:out value="${listbook[index].bookid }"/>
													&name=<c:out value="${listbook[index].bookname }" />
													&url=<c:out value="${listbook[index].bookimgurl }" />
													">
			<Button class = "btn btn-info">Edit</Button>
			</a></td>
		<td><c:out value="${listbook[index].bookimgurl }" /></td>
		<td><a href = "/EmployeeManagement/delete?id=<c:out value="${listbook[index].bookid }" />">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>