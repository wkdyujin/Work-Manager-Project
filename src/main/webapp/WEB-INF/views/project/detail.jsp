<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>project detail</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>프로젝트 상세보기</h2>
    <!-- 프로젝트 기본 정보 표시 (첫 번째 DTO) -->
    <div>프로젝트명: ${project[0].pname}</div>
    <div>프로젝트 설명: ${project[0].description}</div>
    <div>발주처: ${project[0].client}</div>
    <div>예산: ${project[0].budget}</div>
    <div>시작일: ${project[0].startDate}</div>
    <div>마감일: ${project[0].deadline}</div>
    
    <h3>투입 직원 목록</h3>
    <button onclick="location.href='/path/to/add/employee'">추가 직원 투입</button>
    <table class="table">
        <thead>
            <tr>
                <th>사번</th>
                <th>사원명</th>
                <th>직무</th>
                <th>투입일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${project}" var="employee" varStatus="status">
                <c:if test="${employee.role == 'PM'}">
                    <tr>
                        <td>${employee.ename}</td>
                        <td>${employee.name}</td>
                        <td>${employee.role}</td>
                        <td>${employee.enterDate}</td>
                    </tr>
                </c:if>
            </c:forEach>
            <c:forEach items="${project}" var="employee" varStatus="status">
                <c:if test="${employee.role != 'PM'}">
                    <tr>
                        <td>${employee.ename}</td>
                        <td>${employee.name}</td>
                        <td>${employee.role}</td>
                        <td>${employee.enterDate}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
