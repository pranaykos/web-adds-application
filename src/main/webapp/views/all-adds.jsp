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

	<div class="container my-4">

		<div class="row row-cols-1 row-cols-md-3">

			<c:forEach items="${advertises}" var="advertise">

				<div class="col mb-4">
					<div class="card" style="width: 18rem;">
						<img src="${advertise.imagePath}" class="card-img-top" style="max-height: 200px" alt="...">
						<div class="card-body">
							<h5 class="card-title">${advertise.titleName}</h5>
							<p class="card-text">${advertise.description} Some quick example text to build on the
								card title and make up the bulk of the card's content.</p>
								<div class="w-100">
									<c:if test="${advertise.isAssigned == 0}">
										<a href="add?id=${advertise.id}" class="btn btn-primary mr-auto">Assign add</a>										
									</c:if>
									<c:if test="${advertise.isAssigned == 1}">
										<a href="add?id=${advertise.id}" class="btn btn-success disabled mr-auto">Assigned</a>
									</c:if>
									<div class="d-inline-block">${advertise.points} Pts</div>
								</div>
						</div>
					</div>
				</div>


			</c:forEach>


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