<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<link href="${resPath}/css/courseTitle.css" rel="stylesheet">
<title>강의 공지 등록</title>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="w-25">
		<%@ include file="../common/leftbar.jsp"%>
	</div>
	<div id="container" class="mainview container mt-5 min-vh-100 w-50">
		<%@ include file="../common/courseTitle.jsp"%>
		<%@ include file="../common/courseBar.jsp"%>
		<div class="my-3 text-left">
			<h3 class="blue600" id="smallTitle">
				<button class="btn border-0" type="submit" onclick="location.href='${context}course/${courseInfo.courseId}/news'" style="background-color: white">
					<img src="/studybite/resources/img/back.png" width="30" height="30">
				</button>
				강의 공지 목록
			</h3>
		</div>
		<h4 class="blue600" class="mt-4">강의 공지 작성</h4>
		<div class="contatiner">
			<form action="/studybite/course/${courseInfo.courseId}/news/add" method="post" enctype="multipart/form-data">
				<div class="row">
					<label class="col-1 mt-2">제목</label> <input type="text" name="title" class="title form-control mt-1 mb-2 col" placeholder="제목을 입력해주세요." required>
					<div id="titleCnt" class="col-2 mt-2">(0/100)</div>
				</div>
				<div class="form-group row">
					<label class="col-1">내용</label>
					<textarea class="description form-control col" rows="10" name="description" placeholder="내용을 입력해주세요" required></textarea>
					<div id="descCnt" class="col-2">(0/1000)</div>
				</div>
				<div class="input-group my-3">
					<input type="file" name="file" id="file" class="form-control" accept="image/*, .pdf">
				</div>
				<hr class="row mt-5">
				<div class="d-flex justify-content-end mt-1">
					<button type="submit" class="btn btn-primary">작성하기</button>
					<button type="button" class="btn btn-primary mx-1" 
						onclick="location.href='${context}course/${courseInfo.courseId}/news'">취소</button>
				</div>
			</form>
			<div class="row mt-5">
				<%@ include file="../common/footer.jsp"%>
			</div>
		</div>
	</div>
	<div class="w-25">
		<%@ include file="../common/rightbar.jsp"%>
	</div>
	<script src="${resPath}/js/courseBar.js"></script>
	<script>
		$(document).ready(function() {
			$('.title').on('keyup', function() {
				$('#titleCnt').html("(" + $(this).val().length + " / 100)");

				if ($(this).val().length > 100) {
					$(this).val($(this).val().substring(0, 100));
					$('#titleCnt').html("(100 / 100)");
					alert('제목은 최대 100자 까지 입력 가능합니다.');
				}
			});
		});
		$(document).ready(function() {
			$('.description').on('keyup', function() {
				$('#descCnt').html("(" + $(this).val().length + " / 1000)");

				if ($(this).val().length > 1000) {
					$(this).val($(this).val().substring(0, 1000));
					$('#descCnt').html("(1000 / 1000)");
				}
			});
		});
	</script>
</body>
</html>