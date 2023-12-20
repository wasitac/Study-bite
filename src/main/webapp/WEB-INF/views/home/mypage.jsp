<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../common/url.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/leftbar.css" rel="stylesheet">

<title>내 정보</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div class="container justify-content-center mt-3 w-50">
		<div id="mypage body">
			<h2>내 정보</h2>
			<hr>
			<div>
				<h3>${user.userName}</h3>
				<div>
					<label>E-mail</label> <span>${user.email}</span>
				</div>
				<br>
				<div>
					<label>연락처</label> <span>${user.phone}</span>
				</div>
				<br> <a href="${context}mypage/update">회원 정보 수정</a>
			</div>
		</div>
		<div class="w-25">
			<%@include file="../common/rightbar.jsp"%>
		</div>
	</div>
</body>
</html>