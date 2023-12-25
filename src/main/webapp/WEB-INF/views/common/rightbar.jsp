<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="${resPath}/css/rightbar.css" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="d-flex flex-column flex-shrink-0 p-3 position-fixed top-0 end-0 vh-100 border-start w-25" style="max-width: 400px;">
	<div class="dropdown d-flex align-items-center" style="height: 60px;">
		<div>
			<img src="/studybite/resources/img/bellIcon.png" alt="" width="32" height="32" class="rounded-circle ms-3 me-auto ">
			<span class="badge bg-blue600">${notifications.size()}</span>
		</div>
		 <a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle ms-auto me-3" data-bs-toggle="dropdown" aria-expanded="false"> <img src="/studybite/resources/img/userIcon.png" alt="" width="32" height="32" class="rounded-circle me-2"> <strong>${user.userName}</strong>
		</a>
		<ul class="dropdown-menu text-small shadow">
			<li><a class="dropdown-item" href="${context}logout">로그아웃</a></li>
		</ul>
	</div>
	<hr class="mt-0 mx-0">
	<div class="mt-3">
		<p class="blue600">Reminders</p>
	</div>
	<ul class="nav scroll">
		<!-- for문 돌리기  -->
		<c:forEach var="notification" items="${notifications}">
			<li class="card mb-3 border-0 bg-blue50 mb-3 w-100" onclick="path(${notification.category},${notification.courseId}, ${notification.id})" style="cursor:pointer;">
				<div class="card-body row g-0">
					<h5 class="card-title">${notification.title}</h5>
					<p class="card-text">
						<small class="text-body-secondary">${notification.category}</small>
					</p>
				</div>
			</li>
		</c:forEach>
		<li class="card mb-3 border-0 mb-3 w-100">
			<span class="container text-center">알림이 없습니다</span>
		</li>

	</ul>
</div>
<script src="${resPath}/js/basic.js"></script>
<script src="${resPath}/js/rightbar.js"></script>