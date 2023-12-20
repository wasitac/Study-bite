<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../common/url.jsp"%>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/leftbar.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
	<script>
		function confirm() {
			const p1 = document.getElementById('newPassword');
			const p2 = document.getElementById('confirmPassword');
			const button = document.getElementById('confirmButton');

			if(p1.value != p2.value){
				button.disabled = true;
				button.innerText = "비밀번호가 일치하지 않습니다";
			}
			else{				
				button.disabled = false;
				button.innerText = "비밀번호 변경"
			}
		}
	</script>
	<%-- 		<form:form id=userLogin> --%>
	<!-- 			<label>현재 비밀번호</label> -->
	<%-- 			<form:input path="password" placeholder="Password"/> --%>
	<!-- 			<label>새로운 비밀번호</label> -->
	<%-- 			<form:input path="newPassword" placeholder="new Password"/> --%>
	<!-- 			<label>비밀번호 확인</label> -->
	<%-- 			<form:input path="confirmPassword" placeholder="Confirm new Password"/> --%>
	<%-- 			<form:input type="submit"> --%>
	<%-- 		</form:form> --%>
	<h2>비밀번호 변경</h2>
	<form action="${context}mypage/update" method="post">
		<div>
			<label>현재 비밀번호</label> <input type="password" name="password" placeholder="Password" />
		</div>
		<div>
			<label>새로운 비밀번호</label> <input type="password" name="newPassword" id="newPassword" onkeyup="confirm()" placeholder="new Password" />
		</div>
		<div>
			<label>비밀번호 확인</label> <input type="password" name="confirmPassword" id="confirmPassword" onkeyup="confirm()" placeholder="Confirm new Password"/>
		</div>
		<button type="submit" id="confirmButton" >비밀번호 변경</button>
	</form>

</body>
</html>