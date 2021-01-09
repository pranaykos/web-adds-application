<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-secondary my-0">
	<div class="container">
		<a class="navbar-brand text-capitalize" href="#">Hi, ${username}</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item "><a class="nav-link"
					href="${pageContext.request.contextPath}/user/profile">Profile</a></li>
				<li class="nav-item "><a class="nav-link"
					href="${pageContext.request.contextPath}/user/advertises">Advertises</a></li>
				<li class="nav-item "><a class="nav-link" href="#">Redemption
						Req</a></li>
				<li class="nav-item "><a class="nav-link" href="/logout">Logout</a>
				</li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container my-0">
		<div class="card mb-3 w-100">
			<div class="row no-gutters">
				<div class="col-md-8">
					<img src="${advertise.imagePath}" class="card-img h-100" alt="..." />
				</div>
				<div class="col-md-4">
					<div class="card-body">
						<h5 class="card-title">${advertise.titleName}</h5>
						<p class="card-text">${advertise.description}</p>
						<p class="card-text">
							<small class="text-muted">${advertise.createdOn}</small>
						</p>
						<div class="d-flex">
							<h3 id="timer" class="d-inline mr-3">10</h3>
							<div id="result" class="d-inline-block"></div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>



	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

	<script type="text/javascript" src="/js/timer.js"></script>
</body>
</html>