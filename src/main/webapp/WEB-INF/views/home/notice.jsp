<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>공지 사항 목록</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="container mt-5 w-50">
		<div class="py-1 text-left">
			<h2 class="blue600">공지 사항</h2>
		</div>
		<hr class="my-5">

		<div>
			<table class="table table-hover" style="width: 100%;">
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
					<c:forEach var="notice" items="${notices}">
						<tr class="table">
							<td>${notice.noticeId}</td>
							<td>
								<a href="/studybite/notice/${notice.noticeId}" style="text-decoration: none">${notice.title}</a>
							</td>
							<td>관리자</td>
							<td>${notice.date}</td>
							<td>${notice.views}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr class="my-5">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="/studybite/notice?page=0" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
					<c:forEach var="cnt" begin="1" end="${num}" step="1">
						<li class="page-item"><a class="page-link" href="/studybite/notice?page=${(cnt-1) * 10}">${cnt}</a></li>
					</c:forEach>
				<li class="page-item"><a class="page-link" href="/studybite/notice?page=${(num-1) * 10}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
		<div>
			<%@ include file="../common/footer.jsp"%>
		</div>
	</div>
		<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>

</body>
</html>