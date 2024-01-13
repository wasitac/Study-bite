<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/config.jsp"%>
<link href="${resPath}/css/courseTitle.css" rel="stylesheet">
<meta charset="UTF-8">
<title>수강과목-강의 개요</title>

</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 min-vh-100 w-50">
		<div class="contentList">
			<h2 class="info" >
				<button class="btn border-0" type="submit" onclick="location.href='${context}course/${courseInfo.courseId}/contents'" style="background-color: white">
               		<img src="${resPath}/img/back.png" width="50" height="50" alt="뒤로가기">
           		</button>
				강의 목록
			</h2>
		</div>
		<h3 class="mt-4 mb-5">${content.contentName}</h3>
		<p align="middle">
			<iframe width="960" height="540" src="${contentData.contentUrl}" title="kocw" 
				frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		</p>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>