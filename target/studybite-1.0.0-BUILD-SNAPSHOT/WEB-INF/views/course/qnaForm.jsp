<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/config.jsp"%>
<link href="${resPath}/css/courseTitle.css" rel="stylesheet">
<title>수강과목-질의 응답 등록</title>
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
				<button class="btn border-0" type="submit" onclick="location.href='${context}course/${courseInfo.courseId}/qna'" style="background-color: white">
					<img src="${resPath}/img/back.png" width="30" height="30">
				</button>
				질의 응답 목록
			</h3>
		</div>
		<h4 class="mt-4 blue600">질문 작성</h4>
		<div class="contatiner">
			<form action="/studybite/course/${courseId}/qna/add" method="post" enctype="multipart/form-data" id="qnaForm">
				<div class="row">
					<label class="col-1 mt-2">제목</label> <input type="text" id="title" name="title" class="form-control mt-1 mb-2 col" 
						placeholder="제목을 입력해주세요.(100자 이내)" required>
					<div id="titleCnt" class="col-2 mt-2">(0/100)</div>
				</div>
				<div class="form-group row">
					<label class="col-1">내용</label>
					<textarea id="description" name="description" class="description form-control col" rows="10" maxlength="1000" 
						placeholder="내용을 입력해주세요.(1000자 이내)" required></textarea>
					<div id="descCnt" class="col-2">(0/1000)</div>
				</div>
				<div class="input-group my-3">
				  <input type="file" name="file" id="file" class="form-control" accept=".pdf, .png, .jpg, .jpeg">
				</div>
				<hr class="row mt-5">
				<div class="d-flex justify-content-end mt-1">
					<button type="submit" class="btn btn-primary me-1" onclick="validateAndSubmit()">작성하기</button>
					<button type="button" onclick="location.href='${context}course/${courseInfo.courseId}/qna'" class="btn btn-primary">취소</button>
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
			$('#title').on('keyup', function() {
				$('#titleCnt').html("(" + $(this).val().length + " / 100)");

				if ($(this).val().length > 100) {
					$(this).val($(this).val().substring(0, 100));
					$('#titleCnt').html("(100 / 100)");
					alert('제목은 최대 100자 까지 입력 가능합니다.');
				}
			});
		});
		$(document).ready(function() {
			$('#description').on('keyup', function() {
				$('#descCnt').html("(" + $(this).val().length + " / 1000)");

				if ($(this).val().length > 1000) {
					$(this).val($(this).val().substring(0, 1000));
					$('#descCnt').html("(1000 / 1000)");
				}
			});
		});
		
	    function validateAndSubmit() {
	        var fileInput = document.getElementById('file');
	        var file = fileInput.files[0];

	        if (file) {
	            var allowedExtensions = ['pdf', 'png', 'jpg', 'jpeg'];
	            var fileExtension = file.name.split('.').pop().toLowerCase();

	            if (!allowedExtensions.includes(fileExtension)) {
	                alert('허용된 파일 형식이 아닙니다. (pdf, png, jpg, jpeg만 가능)');
	                return;
	            }
	        }
	    }
	</script>
</body>
</html>