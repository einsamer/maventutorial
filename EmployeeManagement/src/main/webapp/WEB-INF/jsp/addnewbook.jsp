<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert new book</title>
</head>
<body>
	<form:form method="post" action="/EmployeeManagement/addbook" modelAttribute="book">
		<table>
			<tr>
				<td>Book Name</td>
				<td><form:input path="bookname"  /></td>
				<td><form:errors path="bookname"/></td>
			</tr>
			<tr>
				<td>Book Image URL</td>
				<td><form:input path="bookimgurl"/></td>
			</tr>
			<tr><td colspan="2" align="center"><input type="submit" value="Create"/></td></tr>
		</table>
	</form:form>
</body>
</html>