<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>공지 사항 상세</title>
</head>
<body>
	<div>
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="container mt-5" style="width: 1000px; min-height: 500px">
		<div class="my-1 text-left">
			<!-- 공지사항 목록으로 돌아가는 버튼 -->
			<h1 style="color: #2563EB">
				<button class="btn border-0" type="submit" onclick="location.href='/studybite/notice'" style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="50" height="50">
				</button>
				공지 사항
			</h1>
		</div>
		<hr class="mt-3">

		<!-- 게시글 -->
		<div class="card mb-2 border-0 p-3" style="background-color: rgba(239, 244, 255, 0.5)">
			<h3>${notice.title}</h3>
			<div>번호 : ${notice.noticeId} 작성자 : 작성일 : 조회수 : ${notice.views}</div>
		</div>
		<hr>
		<div>
			<div>${notice.description}</div>
		</div>


		<hr class="my-5">

		<div class="list-group">
			<a href="/studybite/notice/${next.noticeId}" class="list-group-item list-group-item-action"> <span style="font-weight: bold;">다음글</span> │ <c:choose>
					<c:when test="${empty next}">
                다음글이 없습니다.
            </c:when>
					<c:otherwise>
						<span style="color: blue;">${next.title}</span>
					</c:otherwise>
				</c:choose>
			</a> <a href="/studybite/notice/${prev.noticeId}" class="list-group-item list-group-item-action"> <span style="font-weight: bold;">이전글</span> │ <c:choose>
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
	<div>
		<%@ include file="../common/rightbar.jsp"%>
	</div>

</body>
</html>
