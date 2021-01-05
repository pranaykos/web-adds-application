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
	<h1>Create your business account</h1>
	
	
	<div>
		<h1>Registration Form</h1>
		<s:form modelAttribute="client"
				method="POST"
				action="${pageContext.request.contextPath}/client/register">
			<p>
				Email : <s:input path="email"/>
				<s:errors path="email" />
			</p>
			<p>
				Company Name : <s:input path="companyName"/>
				<s:errors path="companyName" />
			</p>
			<p>
				Username : <s:input path="username"/>
				<s:errors path="username" />
			</p>
			<p>
				Password : <s:input path="password"/>
				<s:errors path="password" />
			</p>
			<p>
				Agree to the Terms and condition: <input type="checkbox">
			</p>
			
			
			<input type="submit">
			
		</s:form>
	</div>
	
</body>
</html>