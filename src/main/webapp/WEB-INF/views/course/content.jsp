<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/config.jsp"%>
<meta charset="UTF-8">
<title>수강과목-강의 개요</title>
<link  rel="shortcut icon"  href="<c:url value='/resources/img/favicon/favicon.ico'/>" type="image/x-icon">
</head>
<body>
	<%@ include file="../common/leftbar.jsp"%>
	<div class="mainview container ms-5 me-5 position-absolute min-vh-100">
		<div class="contentList">
			<h1 class="info" >
				<button class="btn border-0" type="submit" onclick="history.back()" style="background-color: white">
               		<img src="/studybite/resources/img/back.png" width="50" height="50" alt="뒤로가기">
           		</button>
				강의 목록
			</h2>
		</div>
		<h3 class="mt-4 mb-5">${content.contentName}</h3>
		<p align="middle">
			<%-- <iframe width="960" height="540" src="${contentData.contentUrl}" title="kocw"  --%>
			<iframe width="960" height="540" src="${contentData.contentUrl }" title="kocw" 
				frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		</p>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>