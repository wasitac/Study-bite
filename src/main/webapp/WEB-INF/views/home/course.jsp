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
						<small class="text-body-secondary">수강중인 강의</small>
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
		<div class="row row-cols-2 g-3">
			<c:forEach var="course" items="${courses}">
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
	</div>
	<div class="w-25">
		<%@include file="../common/rightbar.jsp"%>
	</div>
</body>
</html>