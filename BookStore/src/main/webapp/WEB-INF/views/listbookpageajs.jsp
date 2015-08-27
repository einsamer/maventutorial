<!-- lib declare -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- end lib declare -->


<div class="main-content" ng-app="bookApp"
	ng-controller="bookCtrl">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="center-content">
			<ul class="nav">
				<li>
					<button ng-click="nav_listbook()" class="btn btn-info">LIST
						BOOK</button>
				</li>
			</ul>
			<div>
				<input ng-keydown="nav_listbook()" type="text" class="form-control"
					ng-model="cons">
				<table class="table">
					<tr
						ng-repeat="(key, book) in books | filter:cons| orderBy:'bookname'">
						<td>{{book.bookid}}</td>
						<td>{{book.bookname}}</td>
						<td>{{book.bookauthor}}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>