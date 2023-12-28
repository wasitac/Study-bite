<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<title>수강과목</title>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div class="container w-50 my-5 w-50">
		<h3>수강과목</h3>
		<p class="blue600">Overview</p>
		<div class="d-flex">
			<div class="card mb-3 border-0 me-3 bg-blue50" style="width: 215px; height: 135px">
				<div class="card-body">
					<p class="card-text">
						<small class="text-body-secondary"> <c:choose>
								<c:when test="${user.role == 3}">
									수강중인 강의
								</c:when>
								<c:when test="${user.role == 2}">
									담당 강의
								</c:when>
							</c:choose>
						</small>
					</p>
					<h1 class="card-title fw-bold blue600">${courseCount}</h1>
				</div>
			</div>
			<div class="card mb-3 border-0 bg-blue50" style="width: 215px; height: 135px">
				<div class="card-body">
					<p class="card-text">
						<small class="text-body-secondary">수료한 강의</small>
					</p>
					<h1 class="card-title fw-bold blue600">${finishedCount}</h1>
				</div>
			</div>
		</div>
		<p class="my-3 blue600">수강중인 강의</p>
		<div class="row mb-2">
			<c:forEach var="course" items="${courses}">
				<div class="col-md-6">
					<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative bg-blue50" onclick="location.href='/studybite/course/${course.courseId}'" style="cursor: pointer;">
						<div class="col p-2 d-flex flex-column position-static">
							<div class="d-flex">
								<button class="btn bg-primary text-white me-auto p-2" type="button" style="border-radius: 12px">${course.sort}</button>
								<c:if test="${user.role == 2}">
									<button class="btn bg-primary p-2" type="button" onclick="goToNews(event, ${course.courseId})">
										<img src="${resPath}/img/homeIcon/ibellc.png" style="width: 20px;">
									</button>
									<button class="btn bg-primary p-2" type="button" onclick="goToQna(event, ${course.courseId})">
										<img src="${resPath}/img/homeIcon/ibookc.png" style="width: 20px;">
									</button>
								</c:if>
							</div>
						</div>
						<div class="d-flex flex-row mb-2">
							<div class="w-50 p-2">
								<img src="${course.thumbnail}" class="img-fluid rounded" alt="...">
							</div>
							<div class="p-2">
								<h5 class="mb-0">${course.courseName}</h5>
								<div class="mb-1 text-body-secondary">${course.instructor}</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>


		<c:if test="${user.role == 3}">
			<p class="my-3 blue600">수료한 강의</p>
			<div class="row row-cols-2 g-3">
				<c:forEach var="course" items="${finishedCourse}">
					<div class="card mb-3 col" style="max-width: 540px; cursor: pointer;" onclick="location.href='/studybite/course/${course.courseId}'">
						<div class="row g-0">
							<div class="col-md-4 d-flex align-items-center">
								<img src="${course.thumbnail}" class="img-fluid rounded w-100" alt="...">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<input class="btn bg-primary text-white mb-2" type="button" value="${course.sort}" style="border-radius: 12px">
									<h5 class="card-title">${course.courseName}</h5>
									<p class="card-text">
										<small class="text-body-secondary">${course.instructor}</small>
									</p>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>
	<div class="w-25">
		<%@include file="../common/rightbar.jsp"%>
		<script type="text/javascript" src="/studybite/resources/js/course.js"></script>
	</div>
</body>
</html>