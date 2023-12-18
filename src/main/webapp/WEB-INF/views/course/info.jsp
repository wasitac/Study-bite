<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../common/url.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강과목-강의 개요</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/navbar-static.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;600&display=swap');
</style>
</head>
<body>
	<%@ include file="../common/sidebar.jsp"%>
	<div class="container mt-5 ms-5 ">
		<%@ include file="../common/courseTitle.jsp" %>
		<div>
			<h2 class="info">강의 개요</h2>
		</div>
		<div class="infoImage">
			<img alt="강의 개요" src="${resPath}/img/강의개요1.png">
		</div>
	</div>

</body>
</html>
