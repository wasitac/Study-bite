<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>수강과목-질의 응답 상세</title>
</head>

<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 min-vh-100 w-50">
		<%@ include file="../common/courseTitle.jsp"%>
		<%@ include file="../common/courseBar.jsp"%>
		<div class="my-1 text-left">
			<h4 class="blue600 info">
				<button class="btn border-0" type="submit" onclick="location.href='/studybite/course/${courseInfo.courseId}/qna'" style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="30" height="30">
				</button>
				질의 응답 목록
			</h4>
		</div>

		<form:form modelAttribute="qna" id="qnaDesc" method="delete" >
			<div class="card mb-2 border-0 p-4 " style="background-color: rgba(239, 244, 255, 0.5);">
				<h3 class="text-center my-4">${qna.title}</h3>
				<div class="d-flex mt-2">
					<div class="me-3">번호 : ${qna.qnaId}</div>
					<div>작성자 : ${qna.userName}</div>
					<div class="ms-auto me-3">작성일 : ${qna.date}</div>
					<div>조회수 : ${qna.views}</div>
				</div>
			</div>
			<hr class="m-0">
			<div class="mt-3">
				<div>${qna.description}</div>
			</div>
			<hr class="my-5">
			<c:if test="${user.userName eq qna.userName}">
				<div class="position-absolute end-0 mt-1">
					<button type="button" onclick="location.href='${context}course/${courseId}/qna/${qnaId}/editForm'" class="btn btn-primary">수정</button>
					<form:button type="button" class="delete btn btn-primary" id="${qna.qnaId}">삭제</form:button>
				</div>
			</c:if>
		</form:form>
		<img alt="첨부파일" src="/studybite/resources/files/${fileBoard.filename}" class="w-50 h-50">
		<div>
			<a href="/studybite/resources/files/${fileBoard.filename}">첨부파일 다운받기</a>
		</div>
		<%@ include file="../common/footer.jsp"%>
	</div>
	<div>
		<c:choose>
			<c:when test="${user.role == 3 and not empty qna.answer}">
				<h4 class="blue600 info">답변</h4>
				<div class="card mb-2 border-0 p-3" style="background-color: rgba(239, 244, 255, 0.5)">
					<div>${qna.answer}</div>
				</div>
			</c:when>

			<c:when test="${user.role == 3 and empty qna.answer}">
				<h4 class="blue600 info">답변</h4>
				<div class="card mb-2 border-0 p-3" style="background-color: rgba(239, 244, 255, 0.5)">
					<div>등록된 답변이 없습니다</div>
				</div>
			</c:when>

			<c:when test="${user.role == 2 and not empty qna.answer}">
				<h4 class="blue600 info">답변</h4>
				<div class="card mb-2 border-0 p-3" style="background-color: rgba(239, 244, 255, 0.5)">
					<div>${qna.answer}</div>
				</div>
			</c:when>

			<c:when test="${user.role == 2 and empty qna.answer}">
				<form action="/studybite/course/${courseInfo.courseId}/qna/answer" method="post" enctype="multipart/form-data">
					<div class="my-3">
						<label for="answer" class="form-label">답변 입력</label>
						<textarea name="answer" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
						<input type="hidden" id="qnaId" name="qnaId" value="${qna.qnaId}">
						<button type="submit" class="btn btn-primary mt-2" style="float: right">답변하기</button>
					</div>
				</form>
			</c:when>
		</c:choose>
		<c:if test="${user.userName}='${qna.userName}'">
			<div class="position-absolute end-0 mt-1">
				<button type="submit" class="btn btn-primary">작성하기</button>
				<button type="button" class="btn btn-primary">취소</button>
			</div>
		</c:if>
	</div>

	<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>
	<script src="${resPath}/js/courseBar.js"></script>
	<script type="text/javascript">
		var courseId = '${courseInfo.courseId}';
		console.log("courseId = " + courseId);
		$(".delete").click(function() {
			var id = $(this).attr('id');

			// 확인창
			var choice = confirm("질문을 삭제하겠습니까?");
			console.log('choice  ' + choice);

			//확인창에서 확인을 클릭하면,
			 if (choice) {
				$('#qnaDesc').attr('action', '/studybite/course/' + courseId + '/qna/' + id).submit();
			} 
		});
	</script>
</body>
</html>