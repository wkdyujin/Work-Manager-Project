<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Detail</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .project-info { margin-bottom: 20px; }
        .project-info div { margin-bottom: 10px; }
        .header { margin-top: 20px; margin-bottom: 20px; }
    </style>
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>
    <div class="container">
        <div class="header">
            <h2>프로젝트 상세보기</h2>
        </div>
        <div class="project-info bg-light p-4 rounded">
            <h4>${project[0].pname}</h4>
            <div><strong>프로젝트 설명:</strong> ${project[0].description}</div>
            <div><strong>발주처:</strong> ${project[0].client}</div>
            <div><strong>예산:</strong> <fmt:formatNumber value="${project[0].budget}" type="currency"/></div>
            <div><strong>시작일:</strong> <fmt:formatDate value="${project[0].startDate}" pattern="yyyy-MM-dd"/></div>
            <div><strong>마감일:</strong> <fmt:formatDate value="${project[0].deadline}" pattern="yyyy-MM-dd"/></div>
        </div>
        
        <div class="mt-4">
            <h3>투입 직원 목록</h3>
            <button class="btn btn-primary mb-3" onclick="location.href='/path/to/add/employee'">추가 직원 투입</button>
            <table class="table table-striped">
                <thead class="thead-light">
                    <tr>
                        <th>사번</th>
                        <th>사원명</th>
                        <th>직무</th>
                        <th>투입일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${project}" var="employee" varStatus="status">
                        <tr class="${employee.role == 'PM' ? 'table-primary' : ''}">
                            <td>${employee.ename}</td>
                            <td>${employee.name}</td>
                            <td>${employee.role}</td>
                            <td><fmt:formatDate value="${employee.enterDate}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
