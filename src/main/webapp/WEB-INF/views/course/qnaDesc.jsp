<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강과목-질의 응답 상세</title>
<%@ include file="../common/config.jsp"%>
</head>
<body>
	<div>
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 ms-5 me-5 position-absolute min-vh-100" style="">
		<%@ include file="../common/courseTitle.jsp"%>

		<ul class="nav col-12 col-md-auto mb-2 justify-content-left mb-md-0 mt-5">
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="me-2" width="15" height="15">강의 정보</a></li>
			<li><a href="/studybite/course/${course.courseId}/news" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibell.png" class="me-2" width="15" height="15">강의 공지</a></li>
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="me-2" width="15" height="15">강의 목차</a></li>
			<li><a href="/studybite/course/${course.courseId}/qna" class="nav-link px-2 border-bottom border-primary border-2"><img src="/studybite/resources/img/courseIcon/inotec.png" class="me-2" width="15"
					height="15">질의 응답</a></li>
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/iattendance.png" class="me-2" width="15" height="15">출결 현황</a></li>
		</ul>
		<hr class="mt-2">
		<div class="my-1 text-left">
			<h3 style="color: #2563EB">
				<button class="btn border-0" type="submit" onclick="location.href='/studybite/course/${course.courseId}/qna'" style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="30" height="30">
				</button>
				질의 응답 목록
			</h3>
		</div>

		<div class="card mb-2 border-0 p-3" style="background-color: rgba(239, 244, 255, 0.5)">
			<h3>${qna.title}</h3>
			<div>번호 : ${qna.qnaId} &emsp; 작성자 : ${qna.userName} &emsp; 작성일 : ${qna.date} &emsp; 조회수 : ${qna.views}</div>
		</div>
		<hr>
		<div>
			<div>${qna.description}</div>
		</div>
		<hr class="my-5">

		<%@ include file="../common/footer.jsp"%>
	</div>
	<div>
		<%@ include file="../common/rightbar.jsp"%>
	</div>
</body>
</html>