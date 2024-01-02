/**
 * 
 */
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
			fileNameInput.value = ""
			fileInputImage.remove();
		}
	});
});

$(document).ready(function () {
	$('#title').on('keyup', function () {
		$('#titleCnt').html("(" + $(this).val().length + " / 100)");

		if ($(this).val().length > 100) {
			$(this).val($(this).val().substring(0, 100));
			$('#titleCnt').html("(100 / 100)");
			alert('제목은 최대 100자 까지 입력 가능합니다.');
		}
	});
});
$(document).ready(function () {
	$('#description').on('keyup', function () {
		$('#descCnt').html("(" + $(this).val().length + " / 1000)");

		if ($(this).val().length > 1000) {
			$(this).val($(this).val().substring(0, 1000));
			$('#descCnt').html("(1000 / 1000)");
		}
	});
});

$("#cancel").click(() => confirm("취소하시겠습니까?"))

$("#inputGroupFile04").on('change', function () {
	var filePath = $("#inputGroupFile04").val().split("\\");
	var fileName = filePath[2];
	$(".fileName").val(fileName);
});