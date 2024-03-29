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
            <c:if test="${isDeadlinePassed}">
            	<button type="button" class="btn btn-outline-success" disabled>마감</button>
            	<c:if test="${session.role != 'ADMIN'}">
            		<a href="/evaluation/internal/form/${project[0].pid}" class="btn btn-primary">참여 사원 평가</a>
	            </c:if>
	            <c:if test="${session.role == 'ADMIN'}">
	            	<a href="/evaluation/project/${project[0].pid}" class="btn btn-primary">평가 결과 확인</a>
	            </c:if>
            </c:if>
            <c:if test="${not isDeadlinePassed}">
				<button type="button" class="btn btn-outline-danger" disabled>진행중</button>
            </c:if>
            
            <c:if test="${session.role == 'MANAGER' && isDeadlinePassed}">
			    <a href="/evaluation/client/form/${project[0].pid}" class="btn btn-success float-right ml-1">평가표 등록(CSV)</a>
	           	<a href="/project/csv/${project[0].pid}" class="btn btn-success float-right ml-1">평가표 추출(CSV)</a>
            </c:if>
            
            <c:if test="${ errorMsg != null}">
            	<p style="color:red">${errorMsg}
            </c:if>
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
            	<a class="btn btn-primary mb-3" href="/project/employee/${project[0].pid}">추가 직원 투입</a>
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
