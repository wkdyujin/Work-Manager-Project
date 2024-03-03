<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project List</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>
    
    <div class="container mt-3">
        <a href="/project/register" class="btn btn-primary mb-3">New Project</a>
        <div class="row">
            <c:forEach var="project" items="${projectList}">
                <div class="col-md-4 mb-3">
                    <div class="card h-100" onclick="location.href='/project/detail/${project.id}'" style="cursor: pointer;">
                        <div class="card-body">
                            <h5 class="card-title">${project.pname}</h5>
                            <p class="card-text">${project.description}</p>
                            <p class="card-text"><small class="text-muted">Start: ${project.startDate}</small></p>
                            <p class="card-text"><small class="text-muted">Deadline: ${project.deadline}</small></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
