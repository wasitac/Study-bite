<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>수강과목-질의 응답 목록</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 min-vh-100 w-50">
		<%@ include file="../common/courseTitle.jsp"%>
		<%@ include file="../common/courseBar.jsp"%>
		<div class="my-1 text-left">
			<h3 class="blue600 info">질의 응답</h3>
			<div>
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
							<c:forEach var="qna" items="${qna}" varStatus="status">
								<tr class="table">
									<td>${qnaCnt - pageNum - status.index}</td>
									<td><a href="${context}course/${courseInfo.courseId}/qna/${qna.qnaId}">${qna.title}</a></td>
									<td>${qna.userName}</td>
									<td>${qna.date}</td>
									<td>${qna.views}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<hr class="my-5">
				<div>
					<%@ include file="../common/pagination.jsp"%>
				</div>
				<c:if test="${user.role == 3}">
					<div class="d-flex justify-content-end mt-1">
						<button type="button" class="btn btn-primary" onclick="location.href='${context}course/${courseInfo.courseId}/qna/add'">작성하기</button>
					</div>
				</c:if>
			</div>
			<%@ include file="../common/footer.jsp"%>
		</div>
	</div>
	<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>
	<script src="${resPath}/js/courseBar.js"></script>
</body>
</html>