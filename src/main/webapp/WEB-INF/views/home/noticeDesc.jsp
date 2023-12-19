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
				<button class="btn border-0" type="submit" onclick="location.href='/studybite/home/notice'" style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="50" height="50">
				</button>
				공지 사항
			</h1>
		</div>
		<hr class="my-5">

		<!-- 게시글 -->
		<div>
			<h3>공지 제목</h3>
			<div>번호 : 작성자 : 작성일 : 조회수 :</div>
		</div>
		<hr>
		<div>
			<div>공지 내용</div>
		</div>


		<hr class="my-5">

		<div class="list-group">
			<a href="/" class="list-group-item list-group-item-action <c:if test="${empty board.next_board}">disabled</c:if>"> <span style="font-weight: bold;">다음글</span> │ <c:choose>
					<c:when test="${empty board.next_board}">
                다음글이 없습니다.
            </c:when>
					<c:otherwise>
						<span style="color: blue"></span>
					</c:otherwise>
				</c:choose>
			</a> <a href="/" class="list-group-item list-group-item-action <c:if test="${empty board.prev_board}">disabled</c:if>"> <span style="font-weight: bold;">이전글</span> │ <c:choose>
					<c:when test="${empty board.prev_board}">
                이전글이 없습니다.
            </c:when>
					<c:otherwise>
						<span style="color: blue;"></span>
					</c:otherwise>
				</c:choose>
			</a>
		</div>

	</div>
	<div>
		<%@ include file="../common/rightbar.jsp"%>
	</div>

</body>
</html>
