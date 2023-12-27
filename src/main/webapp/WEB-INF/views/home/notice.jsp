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
			<form action="/studybite/notice/search" method="get" id="search" class="d-flex mb-2" style="width: 40%; float: right">
				<input name="search" class="form-control me-2" type="text" placeholder="제목으로 검색">
				<button type="submit" class="btn btn-outline-primary">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
</svg>
				</button>
			</form>
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
							<td><a href="/studybite/notice/${notice.noticeId}" style="text-decoration: none">${notice.title}</a></td>
							<td>관리자</td>
							<td>${notice.date}</td>
							<td>${notice.views}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr class="my-5">

		<div>
			<%@ include file="../common/pagination.jsp"%>
		</div>
		
		<div>
			<%@ include file="../common/footer.jsp"%>
		</div>
	</div>
		<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>

</body>
</html>