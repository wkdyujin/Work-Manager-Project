<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Internal Evaluation</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .form-radio {
            display: flex;
            align-items: center;
        }
        .form-radio input {
            margin-right: 5px;
        }
        .form-radio label {
            margin-right: 10px;
        }
        .form-group #comment {
            height: 100px; /* 높이 조정 */
        }
        .container {
            display: flex;
        }
        .employees, .evaluation {
            flex: 1; /* 컨테이너 내에서 공간 동등하게 차지 */
            margin-right: 20px; /* 마진 추가로 공간 구분 */
        }
        .evaluation {
		    display: none; /* 처음에는 숨김 */
		}
    </style>
    <script src="/js/evaluate.js"></script>
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>
    
   	<div class="container mt-4">
   		<h4 class="title mb-4"><b>${peDtoList[0].pname}</b></h4>
   	</div>
    <div class="container mt-3">
        <div class="employees">
            <h5><b>참여 사원 목록</b></h5>
            <p style="color: gray;">사원명을 선택하여 평가를 입력할 수 있습니다.</p>
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
            <h5 class="subtitle mb-4"><b>사원 평가</b></h5>
            
	        <!-- 선택된 사원의 정보를 표시할 div -->
	        <div class="employee-info mb-3"></div>
	        
            <form action="" method="POST"> <!-- action: JavaScript에서 설정 -->
			    <div class="form-group form-radio">
			        <input type="hidden" id="selectedEmployeeId" name="employeeId" value="">
			        <input type="hidden" id="selectedEmployeeName" name="employeeName" value="">
			
                    
                    <label for="score">평가 점수: </label>
                    <div>
                        <input type="radio" id="score1" name="score" value="1" required>
                        <label for="score1">1</label>
                    </div>
                    <div>
                        <input type="radio" id="score2" name="score" value="2" required>
                        <label for="score2">2</label>
                    </div>
                    <div>
                        <input type="radio" id="score3" name="score" value="3" required>
                        <label for="score3">3</label>
                    </div>
                    <div>
                        <input type="radio" id="score4" name="score" value="4" required>
                        <label for="score4">4</label>
                    </div>
                    <div>
                        <input type="radio" id="score5" name="score" value="5" required>
                        <label for="score5">5</label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="comment">피드백</label>
                    <textarea class="form-control" id="comment" name="comment" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary">제출</button>
            </form>
        </div>
    </div>
</body>
</html>
