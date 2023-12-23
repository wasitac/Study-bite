<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>비밀번호 변경</title>
<script>
	function inputCheck() {
		const p = document.getElementById('password');
		const p1 = document.getElementById('newPassword');
		const p2 = document.getElementById('confirmPassword');
		const button = document.getElementById('confirmButton');
		console.log(p2.value==="");
		if (p.value === "" || p1.value === "" || p2.value === ""){
			button.disabled = true;
			button.innerText = "입력하지 않은 항목이 있습니다";
		}
		else if (p1.value != p2.value) {
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
	<div class="container justify-content-center w-50">
		<h4 class="blue600 py-3">내 정보</h4>
		<hr class="my-4">
			<form action="${context}mypage/update" style="max-width: 500px;" method="post" onsubmit="return confirm('비밀번호를 변경하시겠습니까?');">
				<h3 class="white600 py-5">비밀번호 변경</h3>
				<div>
					<label class="form-label white600">현재 비밀번호</label> <input type="password" class="form-control" name="password" id="password" placeholder="Password" />
				</div>
				<div>
					<label class="form-label white600">새로운 비밀번호</label> <input type="password" class="form-control" name="newPassword" id="newPassword" onkeyup="inputCheck()"
						placeholder="new Password"
					/>
				</div>
				<div>
					<label class="form-label white600">비밀번호 확인</label> <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" onkeyup="inputCheck()"
						placeholder="Confirm new Password"
					/>
				</div>
				 <hr class="my-4">
				<button class="w-75 btn btn-primary btn-lg" type="submit" id="confirmButton">비밀번호 변경</button>
			</form>
<%-- 			<form action="${context}mypage/update" style="max-width: 500px;" method="post" onsubmit="return confirm('비밀번호를 변경하시겠습니까?');"> --%>
<!-- 				<h3 class="white600 py-5">비밀번호 변경</h3> -->
<!-- 				<div> -->
<!-- 					<label class="form-label white600">현재 비밀번호</label> <input type="password" class="form-control" name="password" id="password" placeholder="Password" /> -->
<!-- 				</div> -->
<!-- 				<div> -->
<!-- 					<label class="form-label white600">새로운 비밀번호</label> <input type="password" class="form-control" name="newPassword" id="newPassword" onkeyup="inputCheck()" -->
<!-- 						placeholder="new Password" -->
<!-- 					/> -->
<!-- 				</div> -->
<!-- 				<div> -->
<!-- 					<label class="form-label white600">비밀번호 확인</label> <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" onkeyup="inputCheck()" -->
<!-- 						placeholder="Confirm new Password" -->
<!-- 					/> -->
<!-- 				</div> -->
<!-- 				 <hr class="my-4"> -->
<!-- 				<button class="w-75 btn btn-primary btn-lg" type="submit" id="confirmButton">비밀번호 변경</button> -->
<%-- 			</form> --%>
	</div>
	<div class="w-25">
		<%@include file="../common/rightbar.jsp"%>
	</div>
</body>
</html>