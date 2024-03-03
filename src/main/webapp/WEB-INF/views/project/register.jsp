<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Project</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@include file="/WEB-INF/views/include/header.jsp"%>
    
    <div class="container mt-5">
        <h2>프로젝트 생성</h2>
        <form action="/project/register" method="POST">
            <div class="form-group">
                <label for="pname">프로젝트명</label>
                <input type="text" class="form-control" id="pname" name="pname">
            </div>
            <div class="form-group">
                <label for="description">프로젝트 설명</label>
                <input type="text" class="form-control" id="description" name="description">
            </div>
            <div class="form-group">
                <label for="client">발주처</label>
                <input type="text" class="form-control" id="client" name="client">
            </div>
            <div class="form-group">
                <label for="budget">예산</label>
                <input type="number" class="form-control" id="budget" name="budget">
            </div>
            <div class="form-group">
                <label for="startDate">시작일</label>
                <input type="date" class="form-control" id="startDate" name="startDate">
            </div>
            <div class="form-group">
                <label for="deadline">마감일</label>
                <input type="date" class="form-control" id="deadline" name="deadline">
            </div>
            <button type="submit" class="btn btn-primary">프로젝트 생성</button>
        </form>
    </div>
</body>
</html>
