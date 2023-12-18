<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>공지 사항 상세</title>
</head>
<body>
	<div id="container" class="container mt-5" style="width: 1000px; min-height: 500px">
		<div class="my-1 text-left">
			<h1 style="color: #2563EB">
				<button class="btn border-0" type="submit" onclick="location.href='/studybite/notices'" style="background-color: white"><img src="../resources/img/back.png" class="rounded-circle me-3" width="32" height="32"></button>공지 사항
			</h1>
		</div>
		<hr class="my-5">

		<hr class="my-5">

		<div class="list-group">
			<a href="/" class="list-group-item list-group-item-action <c:if></c:if>"> <span style="font-weight: bold;">다음글</span> │ <c:choose>
					<c:when>
                다음글이 없습니다.
            </c:when>
					<c:otherwise>
						<span style="color: blue"></span>
					</c:otherwise>
				</c:choose>
			</a> <a href="/" class="list-group-item list-group-item-action <c:if></c:if>"> <span style="font-weight: bold;">이전글</span> │ <c:choose>
					<c:when>
                이전글이 없습니다.
            </c:when>
					<c:otherwise>
						<span style="color: blue;"></span>
					</c:otherwise>
				</c:choose>
			</a>
		</div>

	</div>

</body>
</html>
