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



	<nav class="navbar navbar-expand-lg navbar-dark bg-info">
	<div class="container">
		<a class="navbar-brand" href="">Client Manager</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="profile">Profile</a>
				</li>
				<li class="nav-item "><a class="nav-link" href="all-adds">All
						adds</a></li>
				<li class="nav-item "><a class="nav-link" href="add-report">Adds
						report</a></li>
				<li class="nav-item "><a class="nav-link" href="upload-add">New Add</a></li>
				<li class="nav-item "><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>



	<div class="container mt-5">
		<div class="card">
			<h5 class="card-header text-capitalize">${client.companyName}</h5>
			<div class="card-body">

				<div class="row">
					<div class="col-md-6 my-4">
						<h5 class="card-title mb-1">Email</h5>
						<p class="card-text">${client.email}</p>
					</div>
					<div class="col-md-6 my-4">
						<h5 class="card-title mb-1">Username</h5>
						<p class="card-text">${client.username}</p>
					</div>
					<div class="col-md-6 my-4">
						<h5 class="card-title mb-1">Total adds</h5>
						<p class="card-text">${client.totalAdds}</p>
					</div>
					<div class="col-md-6 my-4">
						<h5 class="card-title mb-1">Assigned adds</h5>
						<p class="card-text">${totalAssigned}</p>
					</div>
					<div class="col-md-6 my-4">
						<h5 class="card-title mb-1">Address</h5>
						<p class="card-text">${client.address}</p>
					</div>
				</div>
			</div>
			<a href="upload-add" class="btn btn-outline-primary">Upload add</a>
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