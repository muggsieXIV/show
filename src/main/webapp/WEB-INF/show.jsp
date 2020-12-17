<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>This is show!</h1>
	Book id: <c:out value="${book.id}"></c:out><br>
	Book name: <c:out value="${book.title}"></c:out><br>
	Book desc: <c:out value="${book.description}"></c:out><br>
	
	<a href="/books/${book.id}/edit">edit your book!</a>

</body>
</html>