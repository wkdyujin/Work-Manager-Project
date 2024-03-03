<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorkManager</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	    <a class="navbar-brand" href="/">WorkManager</a>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	    </button>
	    
	    <c:if test="${not empty session}">
	    <div class="collapse navbar-collapse" id="navbarNav">
	        <ul class="navbar-nav mx-auto">
	            <c:if test="${session.role == 'ADMIN'}">
		            <li class="nav-item dropdown" mr-5>
		                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownHR" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		                    EMPLOYEE
		                </a>
		                <div class="dropdown-menu" aria-labelledby="navbarDropdownHR">
		                  <a class="dropdown-item" href="/user/list">전체 직원 조회</a>
		                  <a class="dropdown-item" href="/auth/register">직원 추가</a>
		                </div>
		            </li>
	            </c:if>
	            
	            <li class="nav-item dropdown" mr-5>
	                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownProjects" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                  PROJECT
	                </a>
	                <div class="dropdown-menu" aria-labelledby="navbarDropdownProjects">
	                  <a class="dropdown-item" href="/project/list">전체 프로젝트 조회</a>
	            		<c:if test="${session.role == 'MANAGER'|| session.role == 'USER'}">
		                  <a class="dropdown-item" href="/myProjects">참여 중인 프로젝트</a>
		            	</c:if>
	            		<c:if test="${session.role == 'MANAGER'}">
		                  <a class="dropdown-item" href="/project/register">프로젝트 생성</a>
		            	</c:if>
	                </div>
	            </li>
	            
	            <li class="nav-item dropdown">
	                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownEvaluate" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                  EVALUATE
	                </a>
	                <div class="dropdown-menu" aria-labelledby="navbarDropdownEvaluate">
	            		<c:if test="${session.role == 'ADMIN'}">
		                  <a class="dropdown-item" href="/evaluate">전체 평가 조회</a>
		            	</c:if>
	            		<c:if test="${session.role == 'MANAGER'|| session.role == 'USER'}">
		                  <a class="dropdown-item" href="/CreateEvaluate">평가 작성</a>
		            	</c:if>
	                </div>
	            </li>
	        </ul>
	        <ul class="navbar-nav">
	            <li class="nav-item">
	                <a class="nav-link" href="#">MYPAGE</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link" href="/auth/logout">LOGOUT</a>
	            </li>
	        </ul>
	    </div>
        </c:if>
	</nav>

</body>
</html>
