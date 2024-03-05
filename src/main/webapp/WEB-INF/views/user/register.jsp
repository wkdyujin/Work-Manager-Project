<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>직원 추가</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<style>
		.btn {
			margin-bottom: 10px;
		}
		.row-item {
			margin-right: 100px;
		}
	</style>
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp" %>
    <div class="container mt-5">
        <h4 class="mb-4"><b>신규 사원 등록</b></h4>
        <c:if test="${!empty errorMessage }">
        	<p style="color: red;">${errorMessage}</p>
        </c:if>
        <form action="/auth/register" method="POST" class="needs-validation" novalidate>
            <div class="form-group">
                <label for="name">이름:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
			<div class="row container">
				<div class="row-item">
		            <div class="form-group">
					    <label for="role">권한:</label>
					    <div>
					        <input type="radio" id="employee" name="role" value="USER" required>
					        <label for="employee">사원</label>
					    </div>
					    <div>
					        <input type="radio" id="team_leader" name="role" value="MANAGER">
					        <label for="team_leader">팀장</label>
					    </div>
					    <div>
					        <input type="radio" id="manager" name="role" value="ADMIN">
					        <label for="manager">관리자</label>
					    </div>
					</div>
				</div>
				<div class="row-item">
					<div class="form-group">
					    <label for="gender">성별:</label>
					    <div>
					        <input type="radio" id="male" name="gender" value="MALE" required>
					        <label for="male">남자</label>
					    </div>
					    <div>
					        <input type="radio" id="female" name="gender" value="FEMALE">
					        <label for="female">여자</label>
					    </div>
					</div>
				</div>
			</div>

            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="birth">생년월일:</label>
                <input type="date" class="form-control" id="birth" name="birth" required>
            </div>
            <div class="form-group">
                <label for="tel">전화번호:</label>
                <input type="text" class="form-control" id="tel" name="tel" pattern="[0-9]{3}-[0-9]{3,4}-[0-9]{4}" required>
            </div>
            <div class="form-group">
                <label for="location">주소:</label>
                <input type="text" class="form-control" id="location" name="location" required>
            </div>
            <div class="form-group">
                <label for="salary">연봉:</label>
                <input type="number" class="form-control" id="salary" name="salary" required>
            </div>
            <div class="form-group">
                <label for="hiredate">입사일:</label>
                <input type="date" class="form-control" id="hiredate" name="hiredate" required>
            </div>
            <button type="submit" class="btn btn-primary float-right mb-3">사원 등록</button>
        </form>
    </div>
</body>
</html>
