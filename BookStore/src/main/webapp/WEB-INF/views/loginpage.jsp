<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
			<div class="col-xs-2"></div>
			<div class="col-xs-8">
				<form:form method="post" action="/BookStore/user/login"
					modelAttribute="user">
					<table>
						<tr>
							<td>Name</td>
							<td><form:input path="username" class="form-control" /> </td>
						</tr>
						<tr>
							<td>Password</td>
							<td><form:input path="password" class="form-control" /> </td>
						</tr>
						<tr>
							<td align="center"><input type="submit" class = "btn btn-info"
								value="Sign In" /></td>
							<td align="center">
								<label class = "label label-danger">Forget password?</label>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
			<div class="col-xs-2"></div>