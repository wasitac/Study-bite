<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>내 정보</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div class="container justify-content-center w-50">
		<div id="mypage body">
			<div>
				<h2 class="blue600 py-5">내 정보</h2>
			</div>
			<hr>
			<div class="my-5">
				<h3 class="white600">${user.userName}</h3>
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
		<div class="w-25">
			<%@include file="../common/rightbar.jsp"%>
		</div>
	</div>
</body>
</html>