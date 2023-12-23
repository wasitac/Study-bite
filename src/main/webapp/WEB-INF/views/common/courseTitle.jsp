<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="p-5 rounded bg-blue50">
	<input class="btn sort" type="button" value="${courseInfo.sort}">
	<div class="d-flex">
		<h1 class="me-auto">${courseInfo.courseName}</h1>
		<h2>
			<img alt="" src="/studybite/resources/img/bluePerson.png" width="50" height="50"> ${courseInfo.instructor}
		</h2>
	</div>
</div>
