<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME</title>
</head>
<body>
Welcome guest, <a href = "/BookStore/book/listbook">Click here to continue our site</a> 
</body>
</html>-->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<p>A good novel tells us the truth about its hero; but a bad novel
	tells us the truth about its author. – Gilbert K. Chesterton</p>
<p>There is a great deal of difference between an eager man who
	wants to read a book and the tired man who wants a book to read.
	– Gilbert K. Chesterton
<p>A book is a version of the world. If you do not like it, ignore
	it or offer your own version in return. – Salman Rushdie</p>
	
	<h1>Spring MVC internationalization example</h1>

Language : <a href="?language=en">English</a>|<a href="?language=vn">Vietnamese</a>

<h2>
welcome.springmvc : <spring:message code="welcome.springmvc" text="default text" />
</h2>

Current Locale : ${pageContext.response.locale}
	