<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="nav col-12 col-md-auto mb-2 justify-content-left mb-md-0 mt-5">
	<li><a href="/studybite/course/${courseInfo.courseId}" class="courseBar nav-link px-2 link-secondary"><img id="image" src="/studybite/resources/img/courseIcon/ibook.png" class="img me-2" width="15" height="15">강의 정보</a></li>
	<li><a href="/studybite/course/${courseInfo.courseId}/news" class="courseBar nav-link px-2 link-secondary"><img id="image" src="/studybite/resources/img/courseIcon/ibell.png" class="img me-2" width="15" height="15">강의 공지</a></li>
	<li><a href="/studybite/course/${courseInfo.courseId}/contents" class="courseBar nav-link px-2 link-secondary"><img id="image" src="/studybite/resources/img/courseIcon/ibook.png" class="img me-2" width="15" height="15">강의 목차</a></li>
	<li><a href="/studybite/course/${courseInfo.courseId}/qna" class="courseBar nav-link px-2 link-secondary"><img id="image" src="/studybite/resources/img/courseIcon/inote.png" class="img me-2" width="15" height="15">질의 응답</a></li>
	<c:if test="${user.role eq 3}">
		<li><a href="/studybite/course/${courseInfo.courseId}/attendance" class="courseBar nav-link px-2 link-secondary"><img id="image" src="/studybite/resources/img/courseIcon/iattendance.png" class="img me-2" width="15" height="15">출결 현황</a></li>
	</c:if>
</ul>