<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<link href="${resPath}/css/courseTitle.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<title id="title">질문 수정</title>
</head>

<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 min-vh-100 w-50">
		<%@ include file="../common/courseTitle.jsp"%>
		<%@ include file="../common/courseBar.jsp"%>
		<div class="my-3 text-left">
			<h3 class="blue600" id="bigTitle">
				<button class="btn border-0" type="submit" onclick="history.back()" style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="30" height="30">
				</button>
				질의 응답 목록
			</h3>
		</div>
		<h4 style="color: #2563EB" class="mt-4" id="smallTitle">질문 수정</h4>
		<div class="contatiner">

			<form:form modelAttribute="select" action="${context}course/${courseId}/qna/${qnaId}" method="post" enctype="multipart/form-data" id="editForm">
				<div class="row">
					<label class="col-1 mt-2">제목</label>
					<form:input path="title" class="form-control mt-1 mb-2 col" value="${title}" required="true" />
				</div>
				<div class="form-group row">
					<label class="col-1">내용</label>
					<form:textarea class="form-control col" rows="10" path="description" required="true" value="${description}" />
				</div>

				<input type="file" name="file" id="file">

				<hr class="row mt-5">
				<div class="d-flex justify-content-end mt-1">
					<button type="submit" class="update btn btn-primary me-1">수정하기</button>
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
	<script type="text/javascript">
		var title = document.getElementById("title");
		var bigTitle = document.getElementById("bigTitle");
		var smallTitle = document.getElementById("smallTitle");

		console.log("자바스크립트 실행 됨 ");

		// 조건에 따라 텍스트 변경
		if ('${requestURI}' == "${context}course/${courseId}/qna/${qnaId}/editForm") {
			title.innerHTML = "질문 수정";
			bigTitle.innerHTML = "질의 응답 목록";
			smallTitle.innerHTML = "질문 수정";

			$(".update").click(
					function() {
						$('#editForm').attr('action',
								'${context}course/${courseId}/qna/${qnaId}')
								.submit();
						console.log('submit 버튼 클릭함');
					});
		} else {
			title.innerHTML = "강의 공지 수정";
			bigTitle.innerHTML = "강의 공지 목록";
			smallTitle.innerHTML = "강의 공지 수정";

			$('#editForm').attr('modelAttribute', 'news');

			$(".update").click(
					function() {
						$('#editForm').attr('action',
								'${context}course/${courseId}/news/${newsId}')
								.submit();
						console.log('submit 버튼 클릭함');
					});
		}
	</script>

</body>

</html>