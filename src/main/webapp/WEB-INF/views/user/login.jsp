<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

    <%@include file="/WEB-INF/views/include/header.jsp" %>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="mb-4">로그인</h2>
                <form action="/auth/login" method="post">
                    <div class="form-group">
                        <label for="ename">ID</label>
                        <input type="text" class="form-control" id="ename" name="ename" placeholder="아이디 입력">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호 입력">
                    </div>
                    <button type="submit" class="btn btn-primary">로그인</button>
                </form>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger mt-3" role="alert">
                        ${error}
                    </div>
                </c:if>
            </div>
        </div>
    </div>

</body>
</html>
