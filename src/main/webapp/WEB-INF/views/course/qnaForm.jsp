<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<link href="${resPath}/css/courseTitle.css" rel="stylesheet">
<title>수강과목-질의 응답 상세</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 min-vh-100 w-50">
		<%@ include file="../common/courseTitle.jsp"%>
		<%@ include file="../common/courseBar.jsp"%>
		<div class="my-3 text-left">
			<h3 class="blue600" id="smallTitle">
				<button class="btn border-0" type="submit" onclick="location.href='/studybite/course/${courseInfo.courseId}/qna'" style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="30" height="30">
				</button>
				질의 응답 목록
			</h3>
		</div>
		<h4 class="mt-4 blue600">질문 작성</h4>
		<div class="contatiner">
			<form action="/studybite/course/${courseId}/qna/add" method="post" enctype="multipart/form-data">
				<div class="row">
					<label class="col-1 mt-2">제목</label> <input type="text" name="title" class="form-control mt-1 mb-2 col" value="" placeholder="제목을 입력해주세요." required>
				</div>
				<div class="form-group row">
					<label class="col-1">내용</label>
					<textarea class="form-control col" rows="10" name="description" placeholder="내용을 입력해주세요" required></textarea>
				</div>
				<input type="file" name="file" id="file" multiple="multiple">
				<hr class="row mt-5">
				<div class="d-flex justify-content-end mt-1">
					<button type="submit" class="btn btn-primary me-1">작성하기</button>
					<button type="button" class="btn btn-primary">취소</button>
				</div>
			</form>
			<div class="row mt-5">
				<%@ include file="../common/footer.jsp"%>
			</div>
		</div>
	</div>
	<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>
	<script src="${resPath}/js/courseBar.js"></script>
</body>
</html>