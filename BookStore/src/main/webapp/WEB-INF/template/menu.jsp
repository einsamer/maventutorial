<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<ul class="nav nav-pills nav-stacked">
	<li class="btn btn-success listpage-item"><a href="#"><spring:message
				code="menu.home" text="HOMEPAGE" /></a></li>
	<li class="btn btn-success listpage-item"><a
		href="/BookStore/user/login"> <spring:message code="menu.signin"
				text="SIGN IN" /></a></li>
	<li class="btn btn-success listpage-item"><a href="#"><spring:message
							code="menu.signup" text="SIGN-UP" /></a>
	<li>
	<li class="btn btn-success listpage-item"><a href="#"><spring:message
							code="menu.contact" text="CONTACT" /></a></li>
	<li>
	<li class="btn btn-success listpage-item"><a
		href="/BookStore/user/personal">
		<spring:message
							code="menu.setting" text="USER SETTINGS" />
</a></li>
</ul>