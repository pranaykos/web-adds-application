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

<link rel="stylesheet" href="../css/style.css">
</head>
<body>

	<jsp:include page="partials/login-navbar.jsp"></jsp:include>

	<jsp:include page="partials/default-navbar.jsp"></jsp:include>


	<div class="container-fluid mt-5">
		<div class="row">
			<div class="col-md-3 offset-md-1">
				<h1 style="font-weight: 400" class="text-center mb-3">Dear Customer</h1>
				<p class="text-center policy">We here provide you with some
					advertisements of our clients who in turn pay you for viewing
					their ads. You will have to register with us in order to receive
					benefits of our site. Your e-mail id will be your login id. After
					successful registration you will receive ads in your inbox and
					start earning. You can change your password anytime as per your
					wish later. You are expected to read the EULA very carefully
					understand and agree to the terms and conditions. You are expected
					not to hide/minimize/overlook the contents of the advertisement.
					You will receive advertisements in your inbox. Each advertisement
					after its successful execution will be the key to deposit real
					money in your account. You are expected to read each advertisement
					very carefully and propagate the matter to as much of persons /
					friends / relatives so that content is known widely to large mass
					of people.</p>
			</div>
			<div class="col-md-4">
				<h1 style="font-weight: 400" class="text-center mb-3">Dear
					Advertiser/Client</h1>
				<p class="text-center policy">Advertisement does not guarantee a sudden boost in sales 
					neither has it guaranteed sales but it'necessary part of business
					of any type without which no business survives. Whatever is your
					product / service your business won't flourish without advertising
					it. You may upload with our help your advertisement which will be
					viewed by sensible people. Your advertisement may consist of
					various types of mixed contents. Presently images are being
					published later on we will provide the URL of your web-site /
					advertisement (what-ever you choose to publicize); the upgradation
					work is in progress. Our customers will receive your advertisement
					in their inbox of our site they will read the contents understand
					and propagate the same to all the persons they are in contact. A
					very large mass of people will come to know what you want to say.
					So your purpose of advertising is solved. If you do not have
					web-site of your own we have dedicated team of experts who will
					design the web-site for your company. Now-a-days internet is in
					everybody's life and so there are lot more chances to get
					publicity. So why not e-advertise.s</p>
			</div>
			<div class="col-md-3">

				<h1 style="font-weight: 400" class="text-center">Registration
					Form</h1>
				<s:form modelAttribute="applicationUser" method="POST"
					action="${pageContext.request.contextPath}/user/register">

					<table class="table table-sm table-borderless rounded pb-4">
						<tbody>
							<tr>
								<td class="text-center">Name <s:errors path="name"
										cssClass="text-danger" cssStyle="font-weight:600" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-group input-group-sm my-0">
										<s:input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" path="name" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-center">Email Id : <s:errors path="emailId"
										cssClass="text-danger" cssStyle="font-weight:600" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-group input-group-sm my-0">
										<s:input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" path="emailId" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-center">password : <s:errors
										path="password" cssClass="text-danger"
										cssStyle="font-weight:600" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-group input-group-sm my-0">
										<s:input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" path="password" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-center">Confirm Password : <s:errors
										path="confirmPassword" cssClass="text-danger"
										cssStyle="font-weight:600" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-group input-group-sm my-0">
										<s:input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm"
											path="confirmPassword" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-center">First Name : <s:errors
										path="firstName" cssClass="text-danger"
										cssStyle="font-weight:600" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-group input-group-sm my-0">
										<s:input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" path="firstName" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-center">Last Name : <s:errors
										path="lastName" cssClass="text-danger"
										cssStyle="font-weight:600" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-group input-group-sm my-0">
										<s:input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" path="lastName" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-center">Address : <s:errors path="address"
										cssClass="text-danger" cssStyle="font-weight:600" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-group input-group-sm my-0">
										<s:input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" path="address" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-center">Country : <s:errors path="country"
										cssClass="text-danger" cssStyle="font-weight:600" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-group input-group-sm my-0">
										<s:input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" path="country" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-center">Mobile No : <s:errors
										path="mobileNo" cssClass="text-danger"
										cssStyle="font-weight:600" /></td>
							</tr>
							<tr>
								<td class="text-center">
									<div class="input-group input-group-sm my-0">
										<s:input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm" path="mobileNo" />
									</div>
								</td>
							</tr>
							<tr>
								<td class="text-center">Agree to the Terms and condition:
									<div class="form-check" class="d-inline">
										<input class="form-check-input position-static"
											type="checkbox" id="blankCheckbox" value="option1"
											aria-label="...">
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="1" class="text-center">
									<button type="submit" class="btn btn-success btn-sm">Register</button>
									<button type="reset" class="btn btn-primary btn-sm">Reset</button>
								</td>
							</tr>
						</tbody>
					</table>

				</s:form>
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


	<script type="text/javascript" src="../js/script.js"></script>

</body>
</html>