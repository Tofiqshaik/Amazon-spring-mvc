<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="save" modelAttribute="user">
	<form:label path="id">ID</form:label>
	<form:input path="id"/><br><br>
	<form:label path="name">NAME</form:label>
	<form:input path="name"/><br><br>
	<form:label path="email">EMAIL</form:label>
	<form:input path="email"/><br><br>
	<form:label path="password">PASSWORD</form:label>
	<form:input path="password"/><br><br>
	<form:label path="role">ROLE</form:label>
	<form:radiobutton path="role" value="Admin"/>Admin<form:radiobutton path="role" value="Customer"/>Customer<br><br>
	<input type="submit" value="submit">
	
	
	</form:form>
</body>
</html>