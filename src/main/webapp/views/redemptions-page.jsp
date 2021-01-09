<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redemption Page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />
</head>
<body>

	<jsp:include page="partials/admin-navbar.jsp"></jsp:include>


	<div class="container">
		<h1 class="display-4 bg-dark text-light mt-3 p-1 text-center rounded">${message}</h1>
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">Red. Id</th>
					<th scope="col">User Id</th>
					<th scope="col">Amount</th>
					<th scope="col">Requested On</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${redemptions}" var="redemption">

					<tr>
						<td>${redemption.id}</td>
						<td>${redemption.userId}</td>
						<td>${redemption.amount}</td>
						<td>${redemption.requestedOn}</td>
						<c:choose>
							<c:when test="${redemption.isAccepted == 1}">
								<td><span style="font-size: 1em"
									class="badge badge-success badge-pill p-2">Approved <i
										class="fas fa-check-circle"></i></span></td>
							</c:when>
							<c:otherwise>
								<td>
									<!-- <span style="font-size: 1em"
										class="badge badge-primary badge-pill p-2">Approve Now
									</span> -->

									<form method="POST" action="approve"
										class="form-inline my-2 my-lg-0">
										<input hidden name="redemption-id" value="${redemption.id}" />
										<button class="btn btn-primary rounded-pill my-2 my-sm-0"
											style="font-weight: 600" type="submit">Approve Now</button>
									</form>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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