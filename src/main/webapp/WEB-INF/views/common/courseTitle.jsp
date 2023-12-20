<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="p-5 rounded " style="background-color: #EFF4FF;">
	<input class="btn " type="button" value="${courseInfo.sort}" style="border-radius: 12px" >
	<div class="d-flex">
		<h1 class="me-auto">${courseInfo.courseName}</h1>
		<h2>
			<img alt="" src="/studybite/resources/img/bluePerson.png" width="50" height="50">
			${courseInfo.instructor}
		</h2>
	</div>
</div>
