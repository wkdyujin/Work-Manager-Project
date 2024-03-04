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
            <h4 class="title"><b>프로젝트 상세보기</b></h4>
        </div>
        <div class="project-info bg-light p-4 rounded">
            <h4>${project[0].pname}</h4>
            <div><strong>프로젝트 소개</strong> ${project[0].description}</div>
            <div><strong>발주처</strong> ${project[0].client}</div>
            <div><strong>예산</strong> <fmt:formatNumber value="${project[0].budget}" type="currency"/></div>
            <div><strong>착수일</strong> <fmt:formatDate value="${project[0].startDate}" pattern="yyyy-MM-dd"/></div>
            <div><strong>마감일</strong> <fmt:formatDate value="${project[0].deadline}" pattern="yyyy-MM-dd"/></div>
        </div>
        
        <div class="mt-4">
            <h4 class="title"><b>참여 사원 목록</b></h4>
            <c:if test="${session.role == 'MANAGER'}">
            	<a class="btn btn-primary mb-3" href="/path/to/add/employee">추가 직원 투입</a>
            </c:if>
            
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
                            <td>
							    <c:if test="${session.role == 'ADMIN'}">
							        <a href="/user/${employee.eid}">${employee.name}</a>
							    </c:if>
							    <c:if test="${session.role != 'ADMIN'}">
							        ${employee.name}
							    </c:if>
							</td>
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
