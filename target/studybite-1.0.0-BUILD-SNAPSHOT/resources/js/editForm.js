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


$("#cancel").click(() => confirm("취소하시겠습니까?"))

$("#inputGroupFile04").on('change', function () {
	var filePath = $("#inputGroupFile04").val().split("\\");
	var fileName = filePath[2];
	$(".fileName").val(fileName);
});