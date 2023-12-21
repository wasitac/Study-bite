<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../common/url.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강과목-강의 개요</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/courseTitle.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;600&display=swap');
  .mainview {
  	left: 279.9px;
  	max-width:1100px
  }
  .nav {
  	border-bottom: 1px solid #ccc;
  }
</style>
</head>
<body>
	<%@ include file="../common/leftbar.jsp"%>
	<div class="mainview container mt-5 ms-5 me-5 position-absolute min-vh-100">
		<%@ include file="../common/courseTitle.jsp" %>
		<ul class="nav col-12 col-md-auto mb-2 justify-content-left mb-md-0 mt-5">
			<li><a href="${context}course/${courseInfo.courseId}" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="me-2" width="15" height="15">강의 정보</a></li>
			<li><a href="/studybite/course/news" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibell.png" class="me-2" width="15" height="15">강의 공지</a></li>
			<li><a href="${context}course/${courseInfo.courseId}/contents" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="me-2" width="15" height="15">강의 목차</a></li>
			<li><a href="/studybite/course/qna" class="nav-link px-2 border-bottom border-primary border-2"><img src="/studybite/resources/img/courseIcon/inotec.png" class="me-2" width="15"
					height="15">질의 응답</a></li>
			<li><a href="#" class="nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/iattendance.png" class="me-2" width="15" height="15">출결 현황</a></li>
		</ul>
		<div>
			<h2 class="info ms-3">강의 개요</h2>
		</div>
		<div class="infoImage">
			<img alt="강의 개요" src="/studybite/resources/img/outline.png">
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
	<%@ include file="../common/rightbar.jsp"%>
</body>
</html>
