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
		<div class="row">
			<div class="col-md-4">
				<div class="card text-white bg-warning mb-3"
					style="max-width: 18rem;">
					<div class="card-header text-center">All adds</div>
					<div class="card-body p-3">
						<h5 class="card-title display-3 text-center">7</h5>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card text-white bg-danger mb-3"
					style="max-width: 18rem;">
					<div class="card-header text-center">Assigned adds</div>
					<div class="card-body p-3">
						<h5 class="card-title display-3 text-center">4</h5>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card text-white bg-success mb-3"
					style="max-width: 18rem;">
					<div class="card-header text-center">Unassigned adds</div>
					<div class="card-body p-3">
						<h5 class="card-title display-3 text-center">3</h5>
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