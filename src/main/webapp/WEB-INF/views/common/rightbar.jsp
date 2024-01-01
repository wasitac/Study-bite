<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="${resPath}/css/rightbar.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

<div class="d-flex flex-column flex-shrink-0 p-3 position-fixed top-0 end-0 vh-100 border-start w-25" style="max-width: 330px;">
	<div class="dropdown d-flex align-items-center" style="height: 60px;">
		<div>
			<img src="/studybite/resources/img/bellIcon.png" alt="" width="32" height="32" class="rounded-circle ms-3 me-auto "> <span class="badge bg-blue600">${notifications.size()}</span>
		</div>
		<a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle ms-auto me-3" data-bs-toggle="dropdown" aria-expanded="false"> <img src="/studybite/resources/img/userIcon.png" alt="" width="32" height="32" class="rounded-circle me-2"> <strong>${user.userName}</strong>
		</a>
		<ul class="dropdown-menu text-small shadow">
			<li><a class="dropdown-item" href="${context}logout">로그아웃</a></li>
		</ul>
	</div>
	<hr class="mt-3 mx-0">
	<div class="mt-1">
		<p class="blue600">Notification</p>
	</div>
	<div class="scroll">
		<form action="#" class="notification" method="post">
			<c:forEach var="notification" items="${notifications}">
				<button type="submit" class="read text-start w-100 mb-2 p-2 bg-blue50 border border-0 rounded" 
					id="${notification.notificationId}">
					<div>
						<h5>${notification.title}</h5>
						<p>
							<small class="white600"> <c:choose>
									<c:when test="${notification.category == 3}">
										QnA
									</c:when>
									<c:when test="${notification.category == 2}">
										강의 공지
									</c:when>
									<c:otherwise>
										전체 공지
									</c:otherwise>
								</c:choose>
							</small>
						</p>
					</div>
				</button>
			</c:forEach>
			<div class="container text-center mt-5 white600">알림이 없습니다</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(".read").click(
			function() {
				var notificationId = $(this).attr("id");
				$('.notification').attr('action',
						'/studybite/notification/' + notificationId).submit();
			});
</script>