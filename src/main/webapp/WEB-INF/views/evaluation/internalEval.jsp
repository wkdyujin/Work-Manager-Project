<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Internal Evaluation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>
    <c:if test="${session.role == 'MANAGER'}">
    	<!-- PM 평가 -->
    	pm 평가
    </c:if>
    <c:if test="${session.role == 'USER'}">
    	<!-- 동료 평가 -->
    	동료 평가
    </c:if>
</body>
</html>