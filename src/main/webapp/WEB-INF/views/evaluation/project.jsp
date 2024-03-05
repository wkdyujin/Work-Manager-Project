<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>confirm project evaluation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            display: flex;
        }
        .employees, .evaluation {
            flex: 1;
            margin-right: 20px;
        }
        .evaluation {
		    display: none;
		}
    </style>
</head>
<body>
	<%@include file="/WEB-INF/views/include/header.jsp"%>
	
	<div class="container mt-4">
   		<h4 class="title mb-4"><b>${project.pname}</b></h4>
   	</div>
    <div class="container mt-3">
        <div class="employees">
            <h5><b>참여 사원 목록</b></h5>
            <p style="color: gray;">사원명을 선택하여 세부내역 확인할 수 있습니다.</p>
            
            <table class="table mt-4">
                <thead>
                    <tr>
                        <th scope="col">사번</th>
                        <th scope="col">사원명</th>
                        <th scope="col">PM 평가</th>
                        <th scope="col">발주처 평가</th>
                        <th scope="col">동료 평가 평점</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${empEvalList}">
                        <tr>
                            <td>${user.ename}</td>
                            <td style="cursor: pointer; color: blue;">${user.name}</td>
                            <td>${user.pmScore}</td>
                            <td>${user.clientScore}</td>
                            <td>${user.peerScore}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
        <div class="evaluation">
            <h5 class="subtitle mb-4"><b>평가 세부내역</b></h5>
        </div>
        
	</div>	
</body>
</html>