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
				<li class="nav-item active"><a class="nav-link" href="">Profile</a>
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


	<div class="container mt-5">
		<div class="card">
			<h5 class="card-header text-capitalize">${user.name}</h5>
			<div class="card-body">

				<div class="row">
					<div class="col-md-6 my-4">
						<h5 class="card-title mb-1">Email</h5>
						<p class="card-text">${user.emailId}</p>
					</div>
					<div class="col-md-6 my-4">
						<h5 class="card-title mb-1">Mobile No</h5>
						<p class="card-text">${user.mobileNo}</p>
					</div>
					<div class="col-md-6">
						<h5 class="card-title mb-1">First Name</h5>
						<p class="card-text">${user.firstName}</p>
					</div>
					<div class="col-md-6">
						<h5 class="card-title mb-1">Last Name</h5>
						<p class="card-text">${user.lastName}</p>
					</div>
					<div class="col-md-6 my-4">
						<h5 class="card-title mb-1">Country</h5>
						<p class="card-text">${user.country}</p>
					</div>
					<div class="col-md-6 my-4">
						<h5 class="card-title mb-1">Mobile No</h5>
						<p class="card-text">${user.mobileNo}</p>
					</div>
					<div class="col-md-6">
						<h5 class="card-title mb-1">Address</h5>
						<p class="card-text">${user.address}loremipsumloremipsumlorem
							ipsum lorem ipsum lorem ipsum lorem ipsum</p>
					</div>
					<div class="col-md-6">
						<h5 class="card-title mb-1">Points</h5>
						<p class="card-text d-inline">${user.points}

							<c:choose>
								<c:when test="${user.points < 500}">
									<small class="ml-2 text-danger">Earn atlest 500p to
										Redemp</small>
								</c:when>
								<c:otherwise>

									<c:choose>
										<c:when test="${user.isCashClaimed > 0}">
										<h4 style="font-weight: 400" class="d-inline"><span class="badge badge-pill badge-success">Redemption request allready sent</span></h4>
									  </c:when>
										<c:otherwise>
										    <a href="claim-cash" class="btn btn-sm btn-warning ml-2 rounded-pill">$
											Claim Cash</a>
									  </c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</p>
					</div>
				</div>
			</div>
			<a href="upload-add" class="btn btn-outline-primary btn-lg rounded-0">Update</a>
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