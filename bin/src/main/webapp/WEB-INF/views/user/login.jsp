<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login</title>
</head>
<body>
	<form action="/auth/login" method="post">
        <label for="ename">id: </label>
        <input type="text" id="ename" name="ename">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="Log in">
    </form>
    <c:if test="${not empty error}">
        <p>${error}</p>
    </c:if>
</body>
</html>