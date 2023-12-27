<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<%@ include file="../common/config.jsp" %>
			<title>수강과목-강의 공지 목록</title>
	</head>

	<body>
		<div class="w-25">
			<%@ include file="../common/leftbar.jsp" %>
		</div>
		<div id="container" class="mainview container mt-5 ms-5 me-5 position-absolute min-vh-100 w-50">
			<%@ include file="../common/courseTitle.jsp" %>
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
										<td><a href="/studybite/course/${news.courseId}/news/${news.newsId}"
												style="text-decoration: none">${news.title}</a></td>
										<td>${news.userName}</td>
										<td>${news.date}</td>
										<td>${news.views}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<hr class="my-5">
					<div>
						<%@ include file="../common/pagination.jsp" %>
					</div>
					<%@ include file="../common/footer.jsp" %>
		</div>
		<div class="w-25">
			<%@ include file="../common/rightbar.jsp" %>
		</div>
		<script src="${resPath}/js/courseBar.js"></script>
	</body>

	</html>