<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>수강과목-강의 개요</title>
</head>
<body>
	<%@ include file="../common/leftbar.jsp"%>
	<div id="container" class="mainview container mt-5 min-vh-100 w-50">
		<%@ include file="../common/courseTitle.jsp" %>
		<%@ include file="../common/courseBar.jsp" %>
		<div>
			<h3 class="blue600 info">강의 개요</h3>
		</div>
		<div class="infoImage">
			<img alt="강의 개요" src="${courseInfo.outline}">
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
	<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>
	<script src="${resPath}/js/courseBar.js"></script>
</body>
</html>