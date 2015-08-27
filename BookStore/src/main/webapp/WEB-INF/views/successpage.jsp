<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="page-title label-info">
	<h3 class = "page-title-content">Login Successfully!</h3>
</div>

<c:if test="${ userSession != null}">
	Welcome, ${userSession.name}!
</c:if>
<a href = "/BookStore/book/listajs">Click here to return the homepage</a>
