<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="partials/admin-navbar.jsp"></jsp:include>

	<div class="container my-5">
		<div class="card mb-3 w-100">
			<div class="row no-gutters">
				<div class="col-md-6">
					<img src="${advertise.imagePath}" class="card-img h-100" alt="...">
				</div>
				<div class="col-md-6">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
						<p class="card-text">
							<small class="text-muted">Last updated 3 mins ago</small>
						</p>
					</div>
				</div>
			</div>
		</div>

	</div>


	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div>
					<form action="assign-adds" class="form-inline" method="POST">

						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Select</th>
									<th scope="col">ID</th>
									<th scope="col">Name</th>
									<th scope="col">Point</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="user">

									<tr>
										<th scope="row"><input type="checkbox" name="country"
											value="${user.id}" /></th>
										<td>${user.id}</td>
										<td>${user.name}</td>
										<td>${user.points}</td>
									</tr>
									<br>
								</c:forEach>

							</tbody>
						</table>

						<input value="${addId}" name="addId" hidden /> 
						<input type="submit" value="Add user" class="btn btn-warning">
						<a class="btn btn-success ml-3" href="assign-users?addId=${addId}">Submit</a>
					</form>
				</div>
			</div>
			<div class="col-md-6">
				<div>
					<table class="table">
						<thead class="thead-light">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Name</th>
								<th scope="col">Points</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${assignedusers}" var="user">
								<tr>
									<td>${user.id}</td>
									<td>${user.name}</td>
									<td>${user.points}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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