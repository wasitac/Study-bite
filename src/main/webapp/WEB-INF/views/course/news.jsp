<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강과목-강의 공지 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;600&display=swap')
	;

.mainview {
	left: 279.9px;
	max-width: 1100px
}
</style>
</head>

<body>
	<div>
		<%@ include file="../common/leftbar.jsp"%>
	</div>

	<div id="container" class="mainview container mt-5 ms-5 me-5 position-absolute min-vh-100" style="">
		<%@ include file="../common/courseTitle.jsp"%>
		
		<ul class="nav col-12 col-md-auto mb-2 justify-content-left mb-md-0 mt-5">
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="me-2" width="15" height="15">강의 정보</a></li>
			<li><a href="#" class="nav-link px-2 border-bottom border-primary border-2"><img src="/studybite/resources/img/courseIcon/ibellc.png" class="me-2" width="15" height="15">강의 공지</a></li>
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="me-2" width="15" height="15">강의 목차</a></li>
			<li><a href="/studybite/course/qna" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/inote.png" class="me-2" width="15" height="15">질의 응답</a></li>
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/iattendance.png" class="me-2" width="15" height="15">출결 현황</a></li>
		</ul>
		<hr class="mt-2">
		<div class="my-1 text-left">
			<h3 style="color: #2563EB">강의 공지</h3>
		</div>

		<div>
			<table class="table table-hover" style="width: 1000px">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<!-- 나중에 forEach로 돌리기 -->
					<c:forEach var="news" items="${news}">
					<tr class="table">
						<td><a href="/studybite/course/${news.courseId}/news/${news.newsId}" style="text-decoration: none">${news.newsId}</a></td>
						<td><a href="/studybite/course/${news.courseId}/news/${news.newsId}" style="text-decoration: none">${news.title}</a></td>
						<td>${news.userName}</td>
						<td>${news.date}</td>
						<td>${news.views}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr class="my-5">

		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">...</a></li>
				<li class="page-item"><a class="page-link" href="#">10</a></li>
				<li class="page-item"><a class="page-link" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
			<%@ include file="../common/footer.jsp" %>
	</div>
	<div>
		<%@ include file="../common/rightbar.jsp"%>
	</div>
</body>
</html>