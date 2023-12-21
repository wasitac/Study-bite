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
   .contentList {
   	border-bottom: 1px solid #ccc;
   }
   .mainview {
  	left: 279.9px;
  	width:100%
  }
</style>
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
			<iframe width="960" height="540" src="http://www.kocw.net/5c254111-522f-4bca-8eab-778cff6eacd5" title="kocw" 
				frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		</p>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>