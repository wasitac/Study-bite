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
<link href="${resPath}/css/navbar-static.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
  @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;600&display=swap');
</style>
</head>
<body>
	<%@ include file="../common/sidebar.jsp"%>
	<div class="container mt-5 ms-5 ">
		<%@ include file="../common/courseTitle.jsp" %>
		<div>
			<h2 class="info">강의 목차</h2>
		</div>
		<%-- <c:forEach var="" items=""> --%>
		<div>
			 <div>
	          <h4 class="fst-italic">Recent posts</h4>
	          <ul class="list-unstyled">
	            <li>
	              <a class="d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top" href="#">
	                <svg class="bd-placeholder-img" width="100%" height="200" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>
	                <div class="col-lg-8">
	                  <h3 class="mb-0">강좌명강좌명강좌명</h3>
	                  <small class="text-body-secondary">January 15, 2023</small>
	                </div>
	              </a>
	            </li>
	            <li>
	              <a class="d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top" href="#">
	                <svg class="bd-placeholder-img" width="100%" height="200" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>
	                <div class="col-lg-8">
	                  <h3 class="mb-0">강좌명강좌명강좌명</h3>
	                  <small class="text-body-secondary">January 14, 2023</small>
	                </div>
	              </a>
	            </li>
	            <li>
	              <a class="d-flex flex-column flex-lg-row gap-3 align-items-start align-items-lg-center py-3 link-body-emphasis text-decoration-none border-top" href="#">
	                <svg class="bd-placeholder-img" width="100%" height="200" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>
	                <div class="col-lg-8">
	                  <h3 class="mb-0">강좌명강좌명강좌명</h3>
	                  <small class="text-body-secondary">January 13, 2023</small>
	                </div>
	              </a>
	            </li>
	          </ul>
	        </div>
		</div>
		<%-- </c:forEach> --%>
		<div class="row mb-2">
		    <div class="col-12">
		      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
		        <div class="col-auto d-none d-lg-block">
		          <svg class="bd-placeholder-img" width="300" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
		        </div>
		        <div class="col p-4 d-flex flex-column position-static">
		          <strong class="d-inline-block mb-2 text-success-emphasis">Design</strong>
		          <h3 class="mb-0">강좌명강좌명강좌명</h3>
		          <div class="mb-1 text-body-secondary">Nov 11</div>
		        </div>
		      </div>
		    </div>
		    <div class="col-12">
		      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
		        <div class="col-auto d-none d-lg-block">
		          <svg class="bd-placeholder-img" width="300" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
		        </div>
		        <div class="col p-4 d-flex flex-column position-static">
		          <strong class="d-inline-block mb-2 text-success-emphasis">Design</strong>
		          <h3 class="mb-0">Post title</h3>
		          <div class="mb-1 text-body-secondary">Nov 11</div>
		        </div>
		      </div>
		    </div>
		    <div class="col-12">
		      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
		        <div class="col-auto d-none d-lg-block">
		          <svg class="bd-placeholder-img" width="300" height="200" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
		        </div>
		        <div class="col p-4 d-flex flex-column position-static">
		          <strong class="d-inline-block mb-2 text-success-emphasis">Design</strong>
		          <h3 class="mb-0">Post title</h3>
		          <div class="mb-1 text-body-secondary">Nov 11</div>
		        </div>
		      </div>
		    </div>
	  	</div>
	</div>
</body>
</html>