<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./url.jsp"%>
<div class="d-flex flex-column flex-shrink-0 position-fixed top-0 start-0 vh-100 w-25 bg-blue50" style="max-width: 280px;" id="leftbarContainer">
	<a href="/studybite/home" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none"> <img class="w-100 px-5 py-3" src="${resPath}/img/logoSmall.png" alt="studybite">
	</a>
	<ul class="nav nav-pills flex-column mb-auto">
		<c:choose>
			<c:when test="${user.role == 3}">
				<li class="nav-item"><a href="/studybite/home" class="nav-link link-body-emphasis"> <img id="image" src="/studybite/resources/img/homeIcon/ihome.png" class="img ms-2 me-2" width="24" height="24"> 대시보드
				</a></li>
				<li><a href="/studybite/course" class="nav-link link-body-emphasis"> <img id="image" src="/studybite/resources/img/homeIcon/ibook.png" class="img ms-2 me-2" width="24" height="24"> 수강과목
				</a></li>
			</c:when>
			<c:when test="${user.role == 2}">
				<li><a href="/studybite/course" class="nav-link link-body-emphasis"> <img id="image" src="/studybite/resources/img/homeIcon/ibook.png" class="img ms-2 me-2" width="24" height="24"> 담당과목
				</a></li>
			</c:when>
		</c:choose>
		<li><a href="/studybite/mypage" class="nav-link link-body-emphasis"> <img id="image" src="/studybite/resources/img/homeIcon/imypage.png" class="img ms-2 me-2" width="24" height="24"> 내 정보
		</a></li>
		<li><a href="/studybite/notice" class="nav-link link-body-emphasis"> <img id="image" src="/studybite/resources/img/homeIcon/ibell.png" class="img ms-2 me-2" width="24" height="24"> 공지사항
		</a></li>
	</ul>
</div>
<script type="text/javascript" src="/studybite/resources/js/basic.js"></script>