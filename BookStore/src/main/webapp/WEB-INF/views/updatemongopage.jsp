<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<div class="container">
		<div class="row">
			<div class="col-xs-2"></div>
			<div class="col-xs-8" ng-app = "bookMONApp" >
				<form:form method="post" action="/BookStore/book/mongoupdate"
					ng-controller = "bookMongoCtrl"
					modelAttribute="bookMON" name = "updateForm" novalidate = "novalidate">
					<form:hidden name = "_id" path="_id" />
					<form:hidden name = "bookid" path="bookid" />
					<table>
						<tr>
							<td>Book Name</td>
							<td><form:input name = "bookname" path="bookname" ng-model = "bookname" ng-init ="bookname = '${bookMON.bookname}'" class="form-control" required = "required"/>
							 <span class = "error" ng-show="updateForm.bookname.$error.required">Book name is required.</span>
						</tr>
						<tr>
							<td>Book Author</td>
							<td><form:input name = "bookauthor" path="bookauthor" ng-model = "bookauthor" ng-init ="bookauthor = '${bookMON.bookauthor}'"  class="form-control" required = "required"/>
							 <span class = "error" ng-show="updateForm.bookauthor.$error.required">Book Author is required</span></td>
									
						</tr>
						<tr>
							<td>Book Image URL</td>
							<td><form:input path="bookimgurl" ng-model = "bookimgurl" ng-init = "bookimgurl = '${bookMON.bookimgurl}'" class="form-control" required = "required"/> <form:errors
									path="bookimgurl" class="error" />
								<span class = "error" ng-show="updateForm.bookimgurl.$error.required">Book Image Url is not required, but you still have to fill it up ^_^!</span>
									</td>
						</tr>
						<tr>
							<td  align="left"><input type="submit"
							ng-disabled = "updateForm.bookname.$dirty && updateForm.bookname.$invalid"
								value="Create" />
							</td>
						</tr>
					</table>
				</form:form>
			</div>
			<div class="col-xs-2"></div>
			<script>
				$("#_id").submit(function() {
					alert($(this).val());
					
				})
			</script>
		</div>
	</div>
