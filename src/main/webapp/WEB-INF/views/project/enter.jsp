<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Input employee to project</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .title {
            margin-bottom: 30px;
        }
        .btn {
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .container {
            display: flex;
            justify-content: space-between;
        }
        .employeeTable, .employeeInputs {
            flex-basis: 48%; /* 화면을 대략 반반 나눔 */
        }
    </style>
    <script src="/js/enter.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>
    
    <div class="container mt-5">
        <div class="employeeTable">
            <h4 class="title"><b>직원 목록</b></h4>
            <table class="table">
                <!-- 테이블 헤더 -->
                <thead>
                    <tr>
                        <th scope="col">사번</th>
                        <th scope="col">사원명</th>
                        <th scope="col">이메일</th>
                        <th scope="col">연차</th>
                    </tr>
                </thead>
                <!-- 테이블 본문 -->
                <tbody>
                    <c:forEach var="user" items="${empList}">
                        <tr onclick="addEmployee('${user.id}', '${user.ename}', '${user.name}');">
                            <td>${user.ename}</td>
                            <td style="cursor: pointer;">${user.name}</td>
                            <td>${user.email}</td>
                            <td><fmt:formatDate value="${user.hiredate}" pattern="yyyy-MM-dd"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <div class="employeeInputs">
            <h4 class="title"><b>투입할 직원</b></h4>
            <form action="/project/employee/${project.id}" method="POST" id="enterForm">
                <button type="submit" class="btn btn-primary">등록</button>
                <div id="employeeInputsContainer"></div>
            </form>
        </div>
    </div>
</body>
</html>


