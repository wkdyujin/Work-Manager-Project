<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create project</title>
</head>
<body>
	프로젝트 생성
	<form action="/project/register" method="POST">
		프로젝트명 <input type="text" name="pname">
		프로젝트 설명<input type="text" name="description">
		발주처 <input type="text" name="client">
		예산 <input type="number" name="budget">
		시작일 <input type="date" name="startDate">
		마감일 <input type="date" name="deadline">
		<button type="submit">프로젝트 생성</button>
	</form>
</body>
</html>