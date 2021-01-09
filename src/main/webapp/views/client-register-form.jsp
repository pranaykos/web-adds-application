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


	<div class="container shadow p-3 mb-5 bg-white rounded mt-5">
		<h1 style="font-weight: 400">Create your business account</h1>
		<hr>
		<s:form modelAttribute="client" method="POST"
			action="${pageContext.request.contextPath}/client/register">
			<div class="form-row d-flex justify-content-center">
				<div class="form-group col-md-5">
					<label for="inputEmail4">Email</label>
					<s:input type="email" path="email" cssClass="form-control"
						id="inputEmail4" />
					<small><s:errors cssClass="text-danger" path="email" /></small>
				</div>
				<div class="form-group col-md-5">
					<label for="inputPassword4">Company Name</label>
					<s:input type="text" path="companyName" cssClass="" class="form-control"
						id="inputPassword4" />
					<small><s:errors  cssClass="text-danger" path="companyName" /></small>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-5 offset-sm-1">
					<label for="inputEmail4">Username</label>
					<s:input type="text" path="username" cssClass="form-control"
						id="inputEmail4" />
					<small><s:errors  cssClass="text-danger" path="username" /></small>
				</div>
				<div class="form-group col-md-5">
					<label for="inputPassword4">Password</label>
					<s:input type="text" path="password" cssClass="form-control"
						id="inputPassword4" />
					<small><s:errors  cssClass="text-danger" path="password" /></small>
				</div>
				<div class="form-group col-md-5 offset-sm-1">
					<label for="inputPassword4">Confirm Password</label>
					<s:input type="text" path="confirmPassword" cssClass="form-control"
						id="inputPassword4" />
					<small><s:errors  cssClass="text-danger" path="confirmPassword" /></small>
				</div>
			</div>

			<div class="d-flex justify-content-center">
				<div class="form-group col-md-10 p-0 ">
					<label for="exampleFormControlTextarea1">Address</label>
					<s:textarea cssClass="form-control" path="address"
						id="exampleFormControlTextarea1" rows="3" />
					<small><s:errors  path="address" cssClass="text-danger"></s:errors></small>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5 offset-sm-1">
					<input type="checkbox"> Agree to the Terms and condition:
				</div>
				<button type="submit" class="btn btn-outline-success col-md-5">Register
					with Us</button>
			</div>
		</s:form>
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