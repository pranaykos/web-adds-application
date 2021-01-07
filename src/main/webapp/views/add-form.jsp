<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
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
				<li class="nav-item "><a class="nav-link" href="profile">Profile</a>
				</li>
				<li class="nav-item "><a class="nav-link" href="all-adds">All
						adds</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="add-report">Adds report</a></li>
				<li class="nav-item "><a class="nav-link" href="upload-add">New
						Add</a></li>
				<li class="nav-item "><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>


	<div class="container my-4">

		<h1 class="display-4 my-4 text-center ">Upload the add here</h1>


		<div class="row">
		
		
			<div class="col-md-6 offset-sm-3">
				<form action="upload-add" method="POST" enctype="multipart/form-data">
					<div class="form-row">
						<div class="col-6">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">@</div>
								</div>
								<input type="text" name="add-name" class="form-control"
									id="inlineFormInputGroup" placeholder="Add Name">
							</div>
						</div>
						<div class="col-6">
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">$</div>
								</div>
								<input type="text" name="add-point" class="form-control"
									id="inlineFormInputGroup" placeholder="Credit Points">
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputAddress">Address</label>
						<div class="custom-file">
							<input type="file" name="add-image" class="custom-file-input"
								id="validatedCustomFile" required> <label
								class="custom-file-label" for="validatedCustomFile">Choose
								Add Image...</label>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Add description</label>
						<textarea class="form-control" name="add-desc"
							id="exampleFormControlTextarea1" rows="3"></textarea>
					</div>
					<button type="reset" class="btn btn-danger">Reset</button>
					<button type="submit" class="btn btn-primary">Upload Add</button>
				</form>
			</div>
		</div>

	</div>


	<div class="container"></div>

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