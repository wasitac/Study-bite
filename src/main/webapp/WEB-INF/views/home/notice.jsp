<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>공지 사항 목록</title>
</head>
<body>
	<div id="container" class="container mt-5"
		style="width: 1000px; min-height: 500px">
		<div class="my-1 text-left">
			<h1 style="color: #2563EB">공지 사항</h1>
		</div>
		<hr class="my-5">

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
					<c:forEach>
						<tr class="table-primary">
							<td><a href="notices/noticeid">예시 1</a></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="table-primary">
							<td><a href="notices/noticeid">예시 2</a></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr class="table-primary">
							<td><a href="notices/noticeid">예시 3</a></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr class="my-5">

		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item">
				<a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">...</a></li>
				<li class="page-item"><a class="page-link" href="#">10</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>

</body>
</html>