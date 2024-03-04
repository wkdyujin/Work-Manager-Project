<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>user detail</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>
    
    <c:set var="formattedBirth" value="${user.birth}" />
	<fmt:formatDate value="${formattedBirth}" pattern="yyyy-MM-dd" var="formattedBirth"/>
    <c:set var="formattedHiredate" value="${user.hiredate}" />
	<fmt:formatDate value="${formattedHiredate}" pattern="yyyy-MM-dd" var="formattedHiredate"/>
	
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <h4 claa="title"><b>사원 정보</b></h4>
                <div class="form-group">
                    <label for="ename">사번:</label>
                    <input type="text" class="form-control" id="ename" value="${user.ename}" readonly>
                </div>
                <div class="form-group">
				    <label for="name">사원명:</label>
				    <input type="text" class="form-control" id="name" value="${user.name}" readonly>
				</div>
				<div class="form-group">
				    <label for="gender">성별:</label>
				    <input type="text" class="form-control" id="gender" value="${user.gender == 'MALE' ? '남성' : user.gender == 'FEMALE' ? '여성' : '미기입'}" readonly>
				</div>
				<div class="form-group">
			    	<label for="birth">생년월일:</label>
				    <input type="text" class="form-control" id="birth" value="${formattedBirth}" readonly>
				</div>
				<div class="form-group">
				    <label for="role">권한:</label>
				    <input type="text" class="form-control" id="role" value="${user.role == 'USER' ? '사원' : user.role == 'ADMIN' ? '관리자' : user.role == 'MANAGER' ? '팀장' : '미기입'}" readonly>
				</div>
				<div class="form-group">
				    <label for="salary">급여:</label>
				    <input type="text" class="form-control" id="salary" value="<fmt:formatNumber value="${user.salary}" pattern="#,###"/>" readonly>
				</div>
				<div class="form-group">
				    <label for="tel">연락처:</label>
				    <input type="text" class="form-control" id="tel" value="${user.tel}" readonly>
				</div>
				<div class="form-group">
				    <label for="email">이메일:</label>
				    <input type="email" class="form-control" id="email" value="${user.email}" readonly>
				</div>
				<div class="form-group">
				    <label for="location">주소:</label>
				    <input type="text" class="form-control" id="location" value="${user.location}" readonly>
				</div>
				<div class="form-group">
				    <label for="birth">입사일:</label>
				    <input type="text" class="form-control" id="hiredate" value="${formattedHiredate}" readonly>
				</div>
                
            </div>
            
            <div class="col-md-6">
                <h4 claa="title"><b>참여 프로젝트</b></h4>
                <!-- 프로젝트 정보= -->
            </div>
        </div>
    </div>
</body>
</html>
