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
   		<h4 class="title mb-4"><b>${peDtoList[0].pname}</b></h4> <!-- TODO: 평가점수까지 포함한 DTO로 변경 -->
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
                        <th scope="col">배정 직무</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${peDtoList}">
                        <tr onclick="addEmployee('${user.pid}', '${user.eid}', '${user.ename}', '${user.name}');">
                            <td>${user.ename}</td>
                            <td style="cursor: pointer; color: blue;">${user.name}</td>
                            <td>${user.role}</td>
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