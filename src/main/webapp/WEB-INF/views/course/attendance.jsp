<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>출결 현황</title>
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
					<tr class="bg-white500">
						<th>주차</th>
						<th>1</th>
						<th>2</th>
						<th>3</th>
						<th>4</th>
						<th>5</th>
						<th>6</th>
						<th>7</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<tr>
						<td>출석</td>
						<c:forEach var="userCourse" items="${userCourses}">
							<td><c:choose>
									<c:when test="${not empty userCourse.date}"> O </c:when>
									<c:otherwise> - </c:otherwise>
								</c:choose></td>
						</c:forEach>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="my-1 text-end">
				<h4 class="blue600 info">출석률 : ${attPercentage}%</h4>
			</div>
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