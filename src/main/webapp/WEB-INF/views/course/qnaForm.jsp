<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강과목-질의 응답 상세</title>
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
	<div class="mainview container mt-5 ms-5 me-5 position-absolute min-vh-100">
		<%@ include file="../common/courseTitle.jsp"%>
	</div>

	<div id="container" class="container mt-5" style="width: 1000px; min-height: 500px;">
		<ul class="nav col-12 col-md-auto mb-2 justify-content-left mb-md-0">
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="me-2" width="15" height="15">강의 정보</a></li>
			<li><a href="/studybite/course/news" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibell.png" class="me-2" width="15" height="15">강의 공지</a></li>
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="me-2" width="15" height="15">강의 목차</a></li>
			<li><a href="/studybite/course/qna" class="nav-link px-2 border-bottom border-primary border-2"><img src="/studybite/resources/img/courseIcon/inotec.png" class="me-2" width="15"
					height="15">질의 응답</a></li>
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/iattendance.png" class="me-2" width="15" height="15">출결 현황</a></li>
		</ul>
		<hr class="mt-2">
		<div class="my-1 text-left">
			<h3 style="color: #2563EB">
				<button class="btn border-0" type="submit" onclick="location.href='/studybite/course/qna'" style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="30" height="30">
				</button>
				질의 응답 목록
			</h3>
		</div>

		<h4 style="color: #2563EB" class="mt-4" >질문 작성</h4>
		<div class="contatiner">
			<form action="writerAction" method="post">
				<div class="row">
					<label class="col-1 mt-2">제목</label> 
					<input type="text" name="bdTitle" class="form-control mt-1 mb-2 col" placeholder="제목을 입력해주세요." required>
				</div>
				<div class="form-group row">
					<label class="col-1">내용</label>
					<textarea class="form-control col" rows="10" name="bdContent" placeholder="내용을 입력해주세요" required></textarea>
				</div>
		<hr class="my-5">
		<div class="position-absolute end-0">
				<button type="submit" class="btn btn-primary">작성하기</button>
				<button type="button" class="btn btn-primary">취소</button>
		</div>
			</form>

		</div>



	</div>
	<div>
		<%@ include file="../common/rightbar.jsp"%>
	</div>
</body>
</html>