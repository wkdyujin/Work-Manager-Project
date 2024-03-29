<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사원 목록</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        .table-responsive {
            max-width: 90%;
            margin: auto;
        }
        .item {
        	margin-top: 10px
        }
        .title {
        	margin-top: 30px
        }
    </style>
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>

    <div class="table-responsive">
    	<h4 class="title"><b>전체 사원 목록</b></h4>
    	<a class="btn btn-primary item float-right mb-1" href="/auth/register">신규 사원 등록</a>
    	
        <table class="table item">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">사번</th>
                    <th scope="col">사원명</th>
                    <th scope="col">권한</th>
                    <th scope="col">급여</th>
                    <th scope="col">연락처</th>
                    <th scope="col">이메일</th>
                    <th scope="col">입사일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.ename}</td>
                        <td><a href="${user.id}">${user.name}</a></td>
                        <td>
	                        <c:choose>
	                            <c:when test="${user.role == 'USER'}">사원</c:when>
	                            <c:when test="${user.role == 'ADMIN'}">관리자</c:when>
	                            <c:when test="${user.role == 'MANAGER'}">팀장</c:when>
	                            <c:otherwise>미기입</c:otherwise>
	                        </c:choose>
                        </td>
                        <td><fmt:formatNumber value="${user.salary}" pattern="#,###"/></td>
                        <td>${user.tel}</td>
                        <td>${user.email}</td>
                        <td><fmt:formatDate value="${user.hiredate}" pattern="yyyy-MM-dd"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
