<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>수강과목-질의 응답 상세</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
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
				<button class="btn border-0" type="submit"
					onclick="location.href='/studybite/course/${courseInfo.courseId}/qna'"
					style="background-color: white">
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