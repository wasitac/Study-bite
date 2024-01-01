<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
			<link href="${resPath}/css/courseTitle.css" rel="stylesheet">
			<script src="https://code.jquery.com/jquery-3.7.1.min.js"
				integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
			<%@ include file="../common/config.jsp" %>
			<title id="title">질문 수정</title>
	</head>
	<body>
		<div class="w-25">
			<%@ include file="../common/leftbar.jsp" %>
		</div>
		<div id="container" class="mainview container mt-5 min-vh-100 w-50">
			<%@ include file="../common/courseTitle.jsp" %>
				<%@ include file="../common/courseBar.jsp" %>
					<div class="my-3 text-left">
						<h3 class="blue600" id="bigTitle">
							<button class="btn border-0" type="submit" onclick="history.back()" style="background-color: white">
								<img src="/studybite/resources/img/back.png" width="30" height="30">
							</button>
							질의 응답 목록
						</h3>
					</div>
					<h4 style="color: #2563EB" class="mt-4" id="smallTitle">질문 수정</h4>
					<div class="contatiner">
						<form:form modelAttribute="select" action="${context}course/${courseId}/qna/${qnaId}" method="post"
							enctype="multipart/form-data" id="editForm">
							<div class="row">
								<label class="col-1 mt-2">제목</label>
								<form:input path="title" class="form-control mt-1 mb-2 col" value="${title}" required="true" />
							</div>
							<div class="form-group row">
								<label class="col-1">내용</label>
								<form:textarea class="form-control col" rows="10" path="description" required="true"
									value="${description}" />
							</div>
							<c:if test="${not empty fileBoard and not fileBoard.filetype=='application/pdf'}">
								<img alt="첨부파일" src="/studybite/resources/files/${fileBoard.filename}" id="file-input" class="w-50 h-50"
								style="margin: 10px 0 0 78px;">
							</c:if>
							<div class="filebox input-group w-75" style="margin: 10px 0 0 78px">
								<button type="button" class="btn btn-primary"><label for="inputGroupFile04">첨부파일</label></button>
								<input class="fileName" id="fileNameInput" value="${fileBoard.originName}" placeholder="선택된 파일 없음" readonly="readonly">
								<input type="file" name="file" class="form-control" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04"
									aria-label="Upload" style="display: none">
								<button class="btn btn-outline-secondary" type="button" id="deleteFileButton">기존파일 삭제</button>
								 <input type="hidden" id="confirmResult" name="confirmResult" value="">
							</div>
							<hr class="row mt-5">
							<div class="d-flex justify-content-end mt-1">
								<button type="submit" class="update btn btn-primary me-1">수정하기</button>
								<button type="button" class="btn btn-primary" onclick="history.back()" id="cancel">취소</button>
							</div>
						</form:form>
						<div class="row mt-5">
							<%@ include file="../common/footer.jsp" %>
						</div>
					</div>
		</div>
		<div class="w-25">
			<%@ include file="../common/rightbar.jsp" %>
		</div>
		<script src="${resPath}/js/courseBar.js"></script>
		<script type="text/javascript">
			//기존 파일 삭제 누르면 이미지 안 보이게
			document.addEventListener('DOMContentLoaded', function () {

				var deleteFileButton = document.getElementById('deleteFileButton');
				var fileInputImage = document.getElementById('file-input');
				var fileNameInput = document.getElementById('fileNameInput');
					
				deleteFileButton.addEventListener('click', function () {
					
					if (fileNameInput.value.trim() == "") {
			            alert("기존 파일이 없습니다.");
			        } else {
			            var result = confirm("기존 파일을 삭제하시겠습니까?");
			            
			            // 확인창에서 선택한 값 넣기
			           document.getElementById("confirmResult").value = result;
			            
			            console.log(result);
			            
						fileInputImage.remove();
			        }
				});
			});

			$("#cancel").click(() => confirm("취소하시겠습니까?"))

			var title = document.getElementById("title");
			var bigTitle = document.getElementById("bigTitle");
			var smallTitle = document.getElementById("smallTitle");

			// 조건에 따라 텍스트 변경
			if ('${requestURI}' == "${context}course/${courseId}/qna/${qnaId}/editForm") {
				title.innerHTML = "질문 수정";
				bigTitle.innerHTML = "질의 응답 목록";
				smallTitle.innerHTML = "질문 수정";

				$(".update").click(
					function () {
						$('#editForm').attr('action',
							'${context}course/${courseId}/qna/${qnaId}')
							.submit();
						console.log('submit 버튼 클릭함');
					});
			} else if ('${requestURI}' == "${context}course/${courseId}/news/${newsId}/editForm"){
				title.innerHTML = "강의 공지 수정";
				bigTitle.innerHTML = "강의 공지 목록";
				smallTitle.innerHTML = "강의 공지 수정";

				$(".update").click(
					function () {
						$('#editForm').attr('action',
							'${context}course/${courseId}/news/${newsId}')
							.submit();
						console.log('submit 버튼 클릭함');
					});
			}
			$("#inputGroupFile04").on('change', function () {
				var filePath = $("#inputGroupFile04").val().split("\\");
				var fileName = filePath[2];
				$(".fileName").val(fileName);
			});
		</script>
	</body>

	</html>