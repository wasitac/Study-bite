<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>course.jsp</title>
</head>
<body>
	<div class="container justify-content-center mt-3">
		<h3>수강과목</h3>
		<p style="color: #2563eb">Overview</p>
		<div class="d-flex">
			<div class="card mb-3 border-0 me-3" style="background-color: #eff4ff; width: 215px; height: 135px">
				<div class="card-body">
					<p class="card-text">
						<small class="text-body-secondary">수강중인 강의</small>
					</p>
					<h1 class="card-title fw-bold" style="color: #2563eb;">4</h1>
				</div>
			</div>
			<div class="card mb-3 border-0" style="background-color: #eff4ff; width: 215px; height: 135px">
				<div class="card-body">
					<p class="card-text">
						<small class="text-body-secondary">수료한 강의</small>
					</p>
					<h1 class="card-title fw-bold" style="color: #2563eb;">12</h1>
				</div>
			</div>
		</div>
		<div class="row g-3">
			<div class="card mb-3 col" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="..." class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">Web Development</h5>
							<p class="card-text">Swift Course</p>
							<p class="card-text">
								<small class="text-body-secondary">Esther Howard</small>
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="card mb-3 col" style="max-width: 540px;">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="..." class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">Card title</h5>
							<p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
							<p class="card-text">
								<small class="text-body-secondary">Last updated 3 mins ago</small>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>