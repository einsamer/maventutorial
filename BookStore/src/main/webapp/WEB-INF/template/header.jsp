
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- top-menu -->
<nav class="navbar navbar-default navbar-fixed-top topnav">
	<div class="container topnav">
		<div class="navbar-header">
			<a class="navbar-brand topnav" href="/BookStore/book/listajs">BOOK
				STORE</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="topnav menu-item"><a href="#About"> <spring:message
							code="header.about" text="About us" />
				</a>
				<li class="topnav menu-item"><a href="#Content"><spring:message
							code="header.home" text="Homepage" /></a>
				<li class="topnav menu-item"><a href="#Contact"> <spring:message
							code="header.contact" text="Contact" />
				</a>
				<li id="lang-menu" class="dropdown"><p
						class="dropdown-toggle language-item" data-toggle="dropdown">
						<spring:message code="header.language" text="language" />
						<span class="caret"></span>
					</p>
					<ul class="dropdown-menu language-list">
						<li><p class="local-lang" href="en">English</p></li>
						<li><p class="local-lang" href="vn">Vietnamese</p></li>
						<li><p class="local-lang" href="fr">Français</p></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>
<!-- end top-menu -->
<div class="intro-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12 intro-content">
				<h1 class="intro-title intro-text">BOOK STORE</h1>
				<h3 class="intro-text">Show your book - Show your passion</h3>
				<hr>
				<ul class="list-inline">
					<li class="btn btn-danger"><i
						class="fa fa-facebook-official fa-5"></i> <span>FACEBOOK</span></li>
					<li class="btn btn-danger"><i class="fa fa-google-plus fa-5"></i>
						<span>GOOGLE+</span></li>
					<li class="btn btn-danger"><i class="fa fa-twitter fa-5"></i>
						<span>TWITTER</span></li>
				</ul>
			</div>
		</div>
	</div>
</div>