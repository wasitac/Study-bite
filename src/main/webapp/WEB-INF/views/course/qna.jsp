<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<%@ include file="../common/config.jsp" %>
			<title>수강과목-질의 응답 목록</title>
	</head>

	<body>
		<div class="w-25">
			<%@ include file="../common/leftbar.jsp" %>
		</div>
		<div id="container" class="mainview container mt-5 ms-5 me-5 position-absolute min-vh-100 w-50">
			<%@ include file="../common/courseTitle.jsp" %>
				<%@ include file="../common/courseBar.jsp" %>
					<div class="my-1 text-left">
						<h3 class="blue600 info">질의 응답</h3>
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
								<!-- 나중에 forEach로 돌리기 -->
								<c:forEach var="qna" items="${qna}">
									<tr class="table">
										<td>${qna.qnaId}</td>
										<td><a href="/studybite/course/${courseInfo.courseId}/qna/${qna.qnaId}">${qna.title}</a></td>
										<td>${qna.userName}</td>
										<td>${qna.date}</td>
										<td>${qna.views}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<hr class="my-5">
					<button type="button" class="btn btn-primary position-absolute end-0 mt-0"
						onclick="location.href='/studybite/course/${courseInfo.courseId}/qna/add'">작성하기</button>

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