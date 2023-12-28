/**
 * editForm.jsp에서 사용하는 js입니다. 요청 url를 확인 후, 보여주는 context를 설정했습니다.
 */
	var title = document.getElementById("title");
	var bigTitle = document.getElementById("bigTitle");
	var smallTitle = document.getElementById("smallTitle");

	console.log("자바스크립트 실행 됨 ");

	// 조건에 따라 텍스트 변경
	if ('${requestURI}' == "${context}course/${courseId}/qna/${qnaId}/editForm") {
		title.innerHTML = "질문 수정";
		bigTitle.innerHTML = "질의 응답 목록";
		smallTitle.innerHTML = "질문 수정";

		$(".update")
			.click(
				function () {
					$('#editForm')
						.attr('action',
							'${context}course/${courseId}/qna/${qnaId}')
						.submit();
					console.log('submit 버튼 클릭함');
				});
	} else {
		title.innerHTML = "강의 공지 수정";
		bigTitle.innerHTML = "강의 공지 목록";
		smallTitle.innerHTML = "강의 공지 수정";

		$('#editForm').attr('modelAttribute', 'news');

		$(".update")
			.click(
				function () {
					$('#editForm')
						.attr('action',
							'${context}course/${courseId}/news/${newsId}')
						.submit();
					console.log('submit 버튼 클릭함');
				});
	}
