<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>project detail</title>
</head>
<body>
	프로젝트 상세보기
	프로젝트명 ${project.pname}
	프로젝트 설명 ${project.description}
	발주처 ${client}
	예산 ${budget}
	시작일 ${startDate}
	마감일 ${deadline}
</body>
</html>