<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>대시보드</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div>
		<h1>home.jsp(대시보드)</h1>
		<h2>수강 과목</h2>
	</div>
	<div class="container justify-content-center">
		<div class="d-flex mb-3">
			<h3 class="me-auto">공지 사항</h3>
			<a href="">view all</a>
		</div>
		<div class="card mb-3 border-0" style="background-color: #eff4ff;">
			<div class="card-body">
				<h5 class="card-title">공지사항 제목</h5>
				<p class="card-text">
					<small class="text-body-secondary">자료구조</small>
				</p>
			</div>
		</div>
		<div class="card mb-3 border-0" style="background-color: #eff4ff;">
			<div class="card-body">
				<h5 class="card-title">공지사항 제목</h5>
				<p class="card-text">
					<small class="text-body-secondary">자료구조</small>
				</p>
			</div>
		</div>
		<div class="card mb-3 border-0" style="background-color: #eff4ff;">
			<div class="card-body">
				<h5 class="card-title">공지사항 제목</h5>
				<p class="card-text">
					<small class="text-body-secondary">자료구조</small>
				</p>
			</div>
		</div>
		<%@include file="rightbar.jsp"%>
	</div>
</body>
</html>