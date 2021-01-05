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
	<h1>Updation Form</h1>

	<s:form modelAttribute="student" method="POST" action="update-student">

	<s:hidden path="id"/>

		<p>
			Name :
			<s:input path="name"/>
			<s:errors path="name" />
		</p>

		<p>
			Profession :
			<s:input path="profession" />
			<s:errors path="profession" />
		</p>
		
		<input type="submit" value="Update"/>

	</s:form>
</body>
</html>