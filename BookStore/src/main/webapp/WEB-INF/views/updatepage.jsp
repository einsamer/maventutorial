<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<div class="container">
		<div class="row">
			<div class="col-xs-2"></div>

			<div class="col-xs-8" ng-app = "bookApp" >
				<form:form method="post" action="/BookStore/book/update"
					ng-controller = "bookCtrl"
					modelAttribute="book" name = "updateForm" novalidate = "novalidate">
					<form:hidden path="bookid" />
					<table>
						<tr>
							<td>Book Name</td>
							<td><form:input name = "bookname" ng-model = "bookname" path="bookname" class="form-control" required = "required"/>
							 <span ng-show="updateForm.bookname.$error.required">Username is required.</span>
							 <form:errors
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
							<td  align="left"><input type="submit"
							ng-disabled = "updateForm.bookname.$dirty && updateForm.bookname.$invalid"
								value="Create" />
							</td>
							<td  align="left">
								<label class = "label label-danger" ng-click = "info()" >Click Me</label>
							</td>
						</tr>
					</table>
				</form:form>
				<form name = "testForm" ng-controller = "bookCtrl" novalidate = "novalidate">
					<input type = "text" name = "testInput" ng-model = "testInput" required = "required"/>
					<span ng-show="testForm.testInput.$error.required">Username is required.</span>
					<input type = "submit" ng-click = "info()" ng-disabled = "testForm.testInput.$dirty && testForm.testInput.$invalid" value = "Click On Me" />
				</form>
			</div>
			<div class="col-xs-2"></div>
			
		</div>
	</div>
	<script>
		var bookApp = angular.module("bookApp", []);
		bookApp.controller ("bookCtrl", function($scope){
			$scope.testInput = "";
			$scope.info = function() {
				alert("OK");
			}
		});
	</script>
