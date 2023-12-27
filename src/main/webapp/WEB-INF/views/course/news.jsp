<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>수강과목-강의 공지 목록</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 ms-5 me-5 position-absolute min-vh-100 w-50">
		<%@ include file="../common/courseTitle.jsp"%>
		<%@ include file="../common/courseBar.jsp" %>
		<div class="my-1 text-left">
			<h3 class="blue600 info">강의 공지</h3>
		</div>
		<div>
			<table class="table table-hover">
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
					<c:forEach var="news" items="${news}">
					<tr class="table">
						<td>${news.newsId}</td>
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
			<c:if test="${user.role eq 2}">
				<button type="button" class="btn btn-primary position-absolute end-0 mt-0" onclick="location.href='/studybite/course/${courseInfo.courseId}/qna/add'">작성하기</button>
			</c:if>
		</nav>
			<%@ include file="../common/footer.jsp" %>
	</div>
	<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>
	<script src="${resPath}/js/courseBar.js"></script>
</body>
</html>