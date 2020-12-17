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
	<h1>All books!</h1>
	
	<c:forEach items="${allBooks}" var="book">
		<p><c:out value="${book.id}"></c:out></p>
		<p><c:out value="${book.title}"></c:out></p>
		<p><c:out value="${book.description}"></c:out></p>
		<p><c:out value="${book.numberOfPages}"></c:out></p>
		<a href="/books/${book.id}/show">edit book!</a>
	</c:forEach>
</body>
</html>