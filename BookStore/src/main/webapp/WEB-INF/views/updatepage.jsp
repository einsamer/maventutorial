<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value = '/resources/css/main.css'/>" />
<title>Insert title here</title>
<style>
.error {
	color: red;
}
</style>
<title>Add New Book</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-2"></div>
			<div class="col-xs-8">
				<form:form method="post" action="/BookStore/book/update"
					modelAttribute="book">
					<table>
						<tr>
							<td>Book Name</td>
							<td><form:input path="bookname" class="form-control" /> <form:errors
									path="bookname" class="error" /></td>
						</tr>
						<tr>
							<td>Book Author</td>
							<td><form:input path="bookauthor" class="form-control" /> <form:errors
									path="bookauthor" class="error" /></td>
						</tr>
						<tr>
							<td>Book Image URL</td>
							<td><form:input path="bookimgurl" class="form-control" /> <form:errors
									path="bookimgurl" class="error" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="Create" /></td>
						</tr>
					</table>
				</form:form>
			</div>
			<div class="col-xs-2"></div>
		</div>
	</div>

</body>
</html>
