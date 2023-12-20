<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ include file="../common/url.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강과목-강의 목차</title>
<link href="${resPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${resPath}/css/courseTitle.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;600&display=swap');
   .mainview {
  	left: 279.9px;
  	max-width:1100px
  }
  .contentsListLi {
  	background-color: #eff4ff;
  	border-radius: 18px;
  }
</style>
</head>
<body>
	<%@ include file="../common/leftbar.jsp"%>
	<div class="mainview container mt-5 ms-5 me-5 position-absolute min-vh-100">
		<%@ include file="../common/courseTitle.jsp" %>
		<div>
			<h2 class="info">강의 목차</h2>
		</div>
		<div>
			 <div>
	          <ul class="list-unstyled">
				<c:forEach var="content" items="${contents}">
		            <li class="contentsListLi mb-2">
		              <a class="ms-3 d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top" 
		              		href="${context}course/${courseInfo.courseId }/contents/${content.contentId}">
		                <img alt="강의목차 컨텐츠 썸네일" src="/studybite/resources/img/reactLogo.jpeg" width="450" height="200">
		                <div class="col-lg-8">
		                	<input class="btn bg-primary text-white " type="button" value="${courseInfo.sort}" style="border-radius: 12px" >
		               	  <h3 class="my-3">${content.contentName} </h3>
		                  <!-- <small class="text-body-secondary">January 15, 2023</small> -->
		                </div>
		              </a>
		            </li>
	            </c:forEach>
	          </ul>
	        </div>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
	<%@ include file="../common/rightbar.jsp"%>
</body>
</html>