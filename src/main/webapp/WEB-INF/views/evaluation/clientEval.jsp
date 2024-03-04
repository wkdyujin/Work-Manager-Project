<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>create client evaluation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>
    <c:if test="${message != null}">
    	${message}
    </c:if>
    
	<div class="container">
		<form action="/evaluation/client/csv/${id}" method="post" enctype="multipart/form-data">
	    <input type="file" name="file" />
	    <button type="submit" class="btn btn-primary">평가 시트 등록</button>
		</form>
	</div>
</body>
</html>