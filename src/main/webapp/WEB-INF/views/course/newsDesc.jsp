<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>수강과목-강의 공지 상세</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 min-vh-100 w-50">
		<%@ include file="../common/courseTitle.jsp"%>
		<%@ include file="../common/courseBar.jsp"%>
		<div class="my-1 text-left">
			<h3 class="blue600 info">
				<button class="btn border-0" type="submit"
					onclick="location.href='/studybite/course/${news.courseId}/news'"
					style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="30" height="30">
				</button>
				강의 공지 목록
			</h3>
		</div>
		<form>
			<div class="card mb-2 border-0 p-4 "
				style="background-color: rgba(239, 244, 255, 0.5);">
				<h3 class="text-center my-4">${news.title}</h3>
				<div class="d-flex mt-2">
					<div class="me-3">번호 : ${news.newsId}</div>
					<div>작성자 : ${news.userName}</div>
					<div class="ms-auto me-3">작성일 : ${news.date}</div>
					<div>조회수 : ${news.views}</div>
				</div>
			</div>
			<hr class="m-0">
			<div class="mt-3">
				<div>${news.description}</div>
			</div>
		</form>
		<hr class="my-5">
		<img alt="첨부파일" src="/studybite/resources/files/${fileBoard.filename}"
			class="w-100">
		<%@ include file="../common/footer.jsp"%>
	</div>
	<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>
	<script src="${resPath}/js/courseBar.js"></script>
</body>
</html>