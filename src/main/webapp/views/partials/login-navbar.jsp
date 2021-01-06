
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
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
	</div>
</nav>