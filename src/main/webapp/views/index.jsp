<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Home page</h1>


	<div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
			do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
			enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
			ut aliquip ex ea commodo consequat. Duis aute irure dolor in
			reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
			pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
			culpa qui officia deserunt mollit anim id est laborum.
		</p>
	</div>

	<div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed
			do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
			enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi
			ut aliquip ex ea commodo consequat. Duis aute irure dolor in
			reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla
			pariatur. Excepteur sint occaecat cupidatat non proident, sunt in
			culpa qui officia deserunt mollit anim id est laborum.
		</p>
	</div>
	
	<div>
		<h1>Registration Form</h1>
		<s:form modelAttribute="applicationUser"
				method="POST"
				action="${pageContext.request.contextPath}/user/register">
			<p>
				Name : <s:input path="name"/>
				<s:errors path="name" />
			</p>
			<p>
				Email ID : <s:input path="emailId"/>
				<s:errors path="emailId" />
			</p>
			<p>
				Password : <s:input path="password"/>
				<s:errors path="password" />
			</p>
			<p>
				Confirm password : <s:input path="confirmPassword"/>
				<s:errors path="confirmPassword" />
			</p>
			<p>
				First nane : <s:input path="firstName"/>
				<s:errors path="firstName" />
			</p>
			<p>
				Last Name : <s:input path="lastName"/>
				<s:errors path="lastName" />
			</p>
			<p>
				Address : <s:textarea path="address"/>
				<s:errors path="address" />
			</p>
			<p>
				Country : <s:input path="country"/>
				<s:errors path="country" />
			</p>
			<p>
				Mobile No : <s:input path="mobileNo"/>
				<s:errors path="mobileNo" />
			</p>
			<p>
				Agree to the Terms and condition: <input type="checkbox">
			</p>
			
			
			<input type="submit">
			
		</s:form>
	</div>


</body>
</html>