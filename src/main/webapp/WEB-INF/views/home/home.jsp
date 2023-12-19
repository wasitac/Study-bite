<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>대시보드</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div>
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div class="container w-50 justify-content-center my-5">
		<h3 class="mb-3" style="color: #2563eb">수강과목</h3>
		<c:forEach var="course" items="${courses}">
			<div class="px-4 py-3 rounded mb-3" style="background-color: #EFF4FF;">
				<input class="btn" type="button" value="${course.sort}" style="background-color: #dbe6fe">
				<div class="d-flex">
					<h2 class="me-auto">${course.course_name}</h2>
					<input class="btn btn-primary" type="button" value="Start Learning" onclick="location.href='/studybite/course/1'">
				</div>
				<h5>Minsu Kim</h5>
			</div>
		</c:forEach>
	</div>
	<div class="container w-50 justify-content-center">
		<div class="d-flex mb-3">
			<h3 class="me-auto" style="color: #2563eb">공지사항</h3>
			<a href="">view all</a>
		</div>
		<c:forEach var="news" items="${newses}">
			<div class="card mb-3 border-0 px-1" style="background-color: #eff4ff;">
				<div class="card-body">
					<h5 class="card-title">${news.title}</h5>
					<p class="card-text">
						<small class="text-body-secondary">자료구조</small>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
	<div>
		<%@include file="../common/rightbar.jsp"%>
	</div>
</body>
</html>