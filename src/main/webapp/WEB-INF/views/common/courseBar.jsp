<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<ul class="nav col-12 col-md-auto mb-2 justify-content-left mb-md-0 mt-5">
			<li><a href="/studybite/course" class="courseBar nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="img me-2" width="15" height="15">강의 정보</a></li>
			<li><a href="/studybite/course/${course.courseId}/news" class="courseBar nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibell.png" class="img me-2" width="15" height="15">강의 공지</a></li>
			<li><a href="/studybite/course" class="courseBar nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/ibook.png" class="img me-2" width="15" height="15">강의 목차</a></li>
			<li><a href="/studybite/course/${course.courseId}/qna" class="courseBar nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/inote.png" class="me-2" width="15" height="15">질의 응답</a></li>
			<li><a href="/studybite/course" class="courseBar nav-link px-2 link-secondary"><img src="/studybite/resources/img/courseIcon/iattendance.png" class="img me-2" width="15" height="15">출결 현황</a></li>
		</ul>
				
		1. class="" 안에 link-secondary 지우고 border-bottom border-primary border-2
		2. img src="" 변환

		
		