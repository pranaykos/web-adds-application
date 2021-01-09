<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
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
				<li class="nav-item active"><a class="nav-link" href="profile">Profile</a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="advertises">Advertises</a></li>
				<li class="nav-item active"><a class="nav-link" href="redemption-requests">Redemption
						Req</a></li>
				<li class="nav-item active"><a class="nav-link" href="/logout">Logout</a>
				</li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container my-5">
		<div class="row">
			<div class="col-md-9 offset-sm-1">
				<div class="list-group">

					<%
						int i = 0;
					%>

					<c:forEach items="${advertises}" var="advertise">
						<div class="list-group-item list-group-item-action">
							<div class="d-flex w-100 justify-content-between">
								<h5 class="mb-1" style="font-size: 30px; font-weight: 400">${advertise.advertise.titleName}</h5>
								<small class="text-muted">${advertise.advertise.points}
									Points</small>
							</div>
							<hr>
							<p class="mb-1">${advertise.advertise.description}Maecenasseddiam
								eget risus Maecenas sed diam eget risus Mae Maecenas sed diam
								eget risus Maecenas sed diam eget risus Maecenas sed diam eget
								risus cenas sed diam eget risus</p>

							<div class="d-flex justify-content-between">
								<small class="text-muted"> Donecid elit non mi </small>

								<c:if test="${advertise.assignRecord.isSeen == 1}">
									<a class="btn btn-success btn-sm disabled" href="" role="button">Seen</a>
								</c:if>
								<c:if test="${advertise.assignRecord.isSeen == 0}">
									<a class="btn btn-primary btn-sm" href="advertise/${advertise.advertise.id}" role="button">Preview Add</a>
								</c:if>

							</div>

						</div>
					</c:forEach>
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
</body>
</html>