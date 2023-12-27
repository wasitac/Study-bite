<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<link href="${resPath}/css/courseTitle.css" rel="stylesheet">
<title>질문 수정</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 ms-5 me-5 position-absolute min-vh-100 w-50">
		<%@ include file="../common/courseTitle.jsp"%>
		<%@ include file="../common/courseBar.jsp"%>
		<div class="my-3 text-left">
			<h3 style="color: #2563EB">
				<button class="btn border-0" type="submit" onclick="history.back()" style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="30" height="30">
				</button>
				질의 응답 목록
			</h3>
		</div>
		<h4 style="color: #2563EB" class="mt-4">질문 수정</h4>
		<div class="contatiner">
			<form:form modelAttribute="qna" action="/studybite/course/${courseInfo.courseId}/qna/${qna.qnaId}" method="post" enctype="multipart/form-data">
				<div class="row">
					<label class="col-1 mt-2">제목</label>
					<form:input path="title" class="form-control mt-1 mb-2 col" value="${qna.title}" required="true" />
				</div>
				<div class="form-group row">
					<label class="col-1">내용</label>
					<form:textarea class="form-control col" rows="10" path="description" required="true" value="${qna.description}" />
				</div>

				<input type="file" name="file" id="file">

				<hr class="row mt-5">
				<div class="position-absolute end-0 mt-1">
					<button type="submit" class="btn btn-primary">수정하기</button>
					<button type="button" class="btn btn-primary" onclick="history.back()">취소</button>
				</div>
			</form:form>
			<div class="row mt-5">
				<%@ include file="../common/footer.jsp"%>
			</div>
		</div>
	</div>
	<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>
	<script src="${resPath}/js/courseBar.js"></script>
</html>