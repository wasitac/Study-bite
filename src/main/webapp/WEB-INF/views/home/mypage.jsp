<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../common/url.jsp"%>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/leftbar.css" rel="stylesheet">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
</head>
<body>
	<div class="row">
		<div>
<%-- 			<%@ include file="../common/leftbar.jsp"%> --%>
		</div>
		<div id="mypage body" >
			<h2>내 정보</h2>
			<hr>
			<div>
				<h3>${user.userName}</h3>
				<div>
					<label>E-mail</label>
					<span>${user.email}</span>
				</div>
				<br>
				<div>
					<label>연락처</label>
					<span>${user.phone}</span>
				</div>
				<br>
				<a href="${context}mypage/update">회원 정보 수정</a>
			</div>
		</div>
		<div>
<%-- 			<%@ include file="../common/rightbar.jsp"%> --%>
		</div>
	</div>
</body>
</html>