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
	<h1>Upload the add here</h1>
	<form action="upload-add" method="POST" enctype="multipart/form-data">
		<p>Add Name : <input type="text" name="add-name"/> </p>
		<p>Add Image : <input type="file" name="add-image" /> </p>
		<p>Add Description : <input type="text" name="add-desc" /> </p>
		<p>Points : <input type="text" name="add-point" /> </p>
		<input type="submit" value="Upload Add" />
	</form>
</body>
</html>