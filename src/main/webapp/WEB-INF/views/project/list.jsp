<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
	    .custom-small-padding {
	        padding-bottom: 0px;
	    }
	</style>
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>
    
    <div class="container mt-3">
    	<c:if test="${session.role == 'MANAGER'}">
        	<a href="/project/register" class="btn btn-primary mb-3">신규 프로젝트 등록</a>
        </c:if>
        	
        <div class="row">
            <c:forEach var="project" items="${projectList}">
                <div class="col-md-12 mb-3">
                    <div class="card h-100" onclick="location.href='/project/detail/${project.id}'" style="cursor: pointer;">
                        <div class="card-body">
                            <h5 class="card-title">${project.pname}</h5>
                            <p class="card-text">${project.description}</p>
                            <div class="row container">
	                            <p class="card-text mr-5">
	                            	<small class="text-muted">착수일: <fmt:formatDate value="${project.startDate}" pattern="yyyy-MM-dd" /></small>
	                            </p>
	                            <p class="card-text">
	                            	<small class="text-muted">마감일: <fmt:formatDate value="${project.deadline}" pattern="yyyy-MM-dd" /></small>
	                            </p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
