<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<meta charset="UTF-8">
<%@ include file="./common/config.jsp"%>
<title>로그인</title>
<link href="${resPath}/css/sign-in.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center justify-content-center bg-blue50">
	<form:form modelAttribute="userLogin">
		<img class="mb-4 cropping" src="${resPath}/img/logoSmall.png" alt="studybite" width="300">
		<div class="form-floating my-1">
			<form:input path="email" cssClass="form-control" placeholder="name@example.com" />
			<label for="floatingInput">Email address</label>
		</div>
		<div class="form-floating my-1">
			<form:input path="password" type="password" cssClass="form-control" placeholder="Password" />
			<label for="floatingPassword">Password</label>
		</div>
		<div class="text-center my-3">
			<form:button class="btn btn-primary w-50 py-2">로그인</form:button>
		</div>
		<div class="text-center">
			<a href="#">비밀번호를 찾기</a>
		</div>
	</form:form>
</body>
</html>
