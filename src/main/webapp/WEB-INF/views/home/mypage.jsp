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
<link href="${resPath}/css/color.css" rel="stylesheet">
<link href="${resPath}/css/leftbar.css" rel="stylesheet">

<title>내 정보</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div class="container justify-content-center mt-3 w-50">
		<div id="mypage body">
			<h2 class="blue600 my-5">내 정보</h2>
			<hr>
			<div class="mb-3">
				<div class="my-5">
					<h3>${user.userName}</h3>
				</div>
				<div>
					<div>
						<h5><span class="badge bg-blue50 blue600 me-3">E-mail</span><span class="white600">${user.email}</span></h5>
					</div>
					<br>
					<div>
						<h5><span class="badge bg-blue50 blue600 me-3">연락처</span><span class="white600">${user.phone}</span></h5>
					</div>
					<br> <a href="${context}mypage/update">회원 정보 수정</a>
				</div>
			</div>
		</div>
		<div class="w-25">
			<%@include file="../common/rightbar.jsp"%>
		</div>
	</div>
</body>
</html>