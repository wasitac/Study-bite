<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../common/url.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/leftbar.css" rel="stylesheet">
<title>비밀번호 변경</title>
<script>
	function confirm() {
		const p1 = document.getElementById('newPassword');
		const p2 = document.getElementById('confirmPassword');
		const button = document.getElementById('confirmButton');

		if (p1.value != p2.value) {
			button.disabled = true;
			button.innerText = "비밀번호가 일치하지 않습니다";
		} else {
			button.disabled = false;
			button.innerText = "비밀번호 변경"
		}
	}
</script>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div class="container justify-content-center mt-3 w-50">
		<h2>비밀번호 변경</h2>
		<form action="${context}mypage/update" method="post">
			<div>
				<label>현재 비밀번호</label> <input type="password" name="password" placeholder="Password" />
			</div>
			<div>
				<label>새로운 비밀번호</label> <input type="password" name="newPassword" id="newPassword" onkeyup="confirm()"
					placeholder="new Password"
				/>
			</div>
			<div>
				<label>비밀번호 확인</label> <input type="password" name="confirmPassword" id="confirmPassword" onkeyup="confirm()"
					placeholder="Confirm new Password"
				/>
			</div>
			<button type="submit" id="confirmButton">비밀번호 변경</button>
		</form>
	</div>
	<div class="w-25">
		<%@include file="../common/rightbar.jsp"%>
	</div>
</body>
</html>