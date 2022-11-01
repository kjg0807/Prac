let count = 0;

$("#fileAdd").click(function() { // 파일 추가하는 input 태그 생성
	let zz = parseInt(count) + 1;
	let label = ' <label for="formGroupExampleInput" class="form-label">파일' + zz + '</label> ';
	let input = ' <input type="file" class="form-control" name="files" id="files"> ';
	$("#File").append(label);
	$("#File").append(input);
	count++;

	if (count > 0) { // 파일 추가 생기면 삭제 버튼 보이기
		$("#fileDel").show();
	}

	if (count > 5) { // 파일을 5개 이상 추가시
		$("#File label:last").remove();
		$("#File input:last").remove();
		swal("파일은 최대 5개까지 가능합니다.", "You clicked the button!", "info");
		count = 5;
		return;
	}
	console.log("add count: " + count);
})

$("#fileDel").click(function() { // 파일 추가하는 input 태그 삭제
	$("#File label:last").remove();
	$("#File input:last").remove();
	count--;
	if (count < 1) { // 파일 추가하는 input 태그 없을시 삭제 버튼 안보이기
		$("#fileDel").hide();
		count = 0;
	}
	console.log("delete count: " + count);
})

// --------------------------------------------------------

titleCheck = true;
writerCheck = true;
contentCheck = true;

$("#title").blur(function() {
	console.log("제목 탈출");
	if ($("#title").val() == "") {
		$("#titleText").html("빈칸은 사용할 수 없습니다.");
		$("#titleText").attr("color", "#dc3545");
		titleCheck = false;
	}
	else {
		$("#titleText").html("입력 완료");
		$("#titleText").attr("color", "#2fb380");
		titleCheck = true;
	}
	// let title = $("#title").val();
	// $.ajax({
	// 	type: "post",
	// 	url: "write",
	// 	data: { title: title },
	// 	success: function(rs) {
	// 		console.log(rs);
	// 	},
	// 	error: function(status, error) {
	// 		console.log("status: ", status);
	// 		console.log("error: ", error);
	// 	}
	// })
})
// 초 : true
// $("").attr("color", "#2fb380");
// 빨 : false
// $("").attr("color", "#dc3545");
$("#writer").blur(function() {
	console.log("이름 탈출");
	if ($("#writer").val() == "") {
		$("#writerText").html("빈칸은 사용할 수 없습니다.");
		$("#writerText").attr("color", "#dc3545");
		writerCheck = false;
	}
	else {
		$("#writerText").html("입력 완료");
		$("#writerText").attr("color", "#2fb380");
		writerCheck = true;
	}
})

$("#writeBtn").click(function() {
	let title = $("#title").val();
	let writer = $("#writer").val();
	let contents = $("#contents").val();

	if ($("#contents").val() == "") {
		swal("내용을 작성하지 않았습니다.", "You clicked the button!", "error");
	}
	if ($("#writer").val() == "") {
		swal("작성자를 작성하지 않았습니다.", "You clicked the button!", "error");
	}
	if ($("#title").val() == "") {
		swal("제목을 작성하지 않았습니다.", "You clicked the button!", "error");
	}
	//if (($("#title").val() && $("#writer").val() && $("#contents").val()) == "") {
	//	swal("작성에 실패했습니다!", "빈칸이 존재합니다.", "error");
	//}


	if (($("#title").val() && $("#writer").val() && $("#contents").val()) != "") {
		//swal("작성 성공!", "리스트 페이지로 넘어갑니다.", "success");
		swal({
			title: "작성 성공!",
			text: '글 추가를 성공하였습니다.',
			icon: "success",
			closeOnClickOutside: false
		}).then(function() {
			$("#frm").submit();
		});
	}
});