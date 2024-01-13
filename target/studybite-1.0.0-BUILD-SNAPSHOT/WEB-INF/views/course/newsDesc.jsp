<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>수강과목-강의 공지 상세</title>
<link rel="stylesheet" href="${resPath}/css/prevNext.css">
<link rel="stylesheet" href="${resPath}/css/footer.css">
</head>

<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
			<div id="container" class="mainview container mt-5 min-vh-100 w-50">
			<%@ include file="../common/courseTitle.jsp"%>
			<%@ include file="../common/courseBar.jsp"%>
			<div class="my-1 text-left">
				<h3 class="blue600 info">
					<button class="btn border-0" type="submit" onclick="location.href='${context}course/${news.courseId}/news'" style="background-color: white">
						<img src="${resPath}/img/back.png" width="30" height="30">
					</button>
					강의 공지 목록
				</h3>
			</div>
			<form:form modelAttribute="news" method="delete" id="deleteForm">
				<div class="card mb-2 border-0 p-4 " style="background-color: rgba(239, 244, 255, 0.5);">
					<h3 class="text-center my-4">${news.title}</h3>
					<div class="d-flex mt-2">
						<div>작성자 : ${news.userName}</div>
						<div class="ms-auto me-3">작성일 : ${news.date}</div>
						<div>조회수 : ${news.views}</div>
					</div>
				</div>
				<hr class="m-0">
				<div class="mt-3">
					<div>${news.description}</div>
				</div>
				<hr class="my-5">
				<c:choose>
					<c:when test="${fileBoard.filetype eq 'application/pdf'}">
						<div>${fileBoard.originName}</div>
						<a href="${context}course/news/${newsId}/filedown?fileName=${fileBoard.originName}">첨부파일 다운로드</a>
					</c:when>
					<c:when test="${not empty fileBoard}">
						<img alt="첨부파일" src="${resPath}/files/${fileBoard.filename}" class="w-50 h-50">
						<div>
							<a href="${context}course/news/${newsId}/filedown?fileName=${fileBoard.originName}">첨부파일 다운로드</a>
						</div>
					</c:when>
				</c:choose>
				<c:if test="${user.userName eq news.userName}">
					<div class="d-flex justify-content-end mt-1">
						<button type="button" onclick="location.href='${context}course/${courseId}/news/${newsId}/editForm'" class="btn btn-primary">수정</button>
						<form:button type="button" class="delete btn btn-primary mx-1" id="${newsId}">삭제</form:button>
					</div>
				</c:if>
			</form:form>
		<!-- 이전글 다음글 -->
		<div class="prevnext list-group">
			<a href="${context}course/${courseId}/news/${next.newsId}" class="list-group-item list-group-item-action"> <span style="font-weight: bold;">다음글</span> │ <c:choose>
					<c:when test="${empty next}">
                다음글이 없습니다.
            </c:when>
					<c:otherwise>
						<span style="color: blue;">${next.title}</span>
					</c:otherwise>
				</c:choose>
			</a> <a href="${context}course/${courseId}/news/${prev.newsId}" class="list-group-item list-group-item-action"> <span style="font-weight: bold;">이전글</span> │ <c:choose>
					<c:when test="${empty prev}">
                이전글이 없습니다.
            </c:when>
					<c:otherwise>
						<span style="color: blue;">${prev.title}</span>
					</c:otherwise>
				</c:choose>
			</a>
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
		$(".delete").click(
				function() {
					var id = $(this).attr('id');
					console.log(id);
					// 확인창
					var choice = confirm("강의 공지를 삭제하겠습니까?");
					console.log('choice  ' + choice);
					//확인창에서 확인을 클릭하면,
					if (choice) {
						$('#deleteForm')
								.attr(
										'action',
										'/studybite/course/' + courseId
												+ '/news/' + id).submit();
					}
				});
	</script>
</body>

</html>