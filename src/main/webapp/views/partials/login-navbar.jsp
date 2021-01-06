<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">

		<c:choose>
			<c:when test="${pageContext.request.userPrincipal.name == null}">

				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#"
						class="text-light">Login</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0" method="post"
					action="/login-process">
					<div class="input-group input-group-sm">
						<input type="text" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm" placeholder="Email Id "
							id="username" name="username" required>
					</div>
					<div class="input-group input-group-sm mx-2">
						<input type="text" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm" placeholder="Password"
							id="password" name="password" required>
					</div>
					<button class="btn btn-sm btn-primary" type="submit">Login</button>
				</form>

			</c:when>
			<c:otherwise>
				<p class="text-light h-100 align-items-center my-2">Welcome</p>
			</c:otherwise>
		</c:choose>
	</div>
</nav>