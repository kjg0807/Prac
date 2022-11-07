console.log("memberAdd");

$("#all").click(function (e) {

    let ch = $(this).prop("checked");

    $(".check").prop("checked", ch);


})

$(".check").click(function () {

    //let flag=true;
    $("#all").prop("checked", true);

    $(".check").each(function (idx, item) {
        let ch = $(item).prop("checked")
        if (!ch) {
            //flag=false;
            $("#all").prop("checked", false);
            console.log(ch);
            return false;
        }
    });
});
//id, pw, pwEquals, name, email
let results = [false, false, false, false, false];

//// ID Check
$("#inputId").blur(function () {
    let id = $("#inputId").val();
    console.log("start")
    let result = nullCheck(id, $("#inputIdResult"), "ID는");
    results[0] = result;
    console.log("ID result: " + result)

    //아이디 중복 확인 중복시 1 리턴, 중복x 0 리턴
    // 강사님 코드
    // $.get("URL?param1=값&param2=값", callback function)
    if (result) {
        $.get("./getIdCheck?id=" + id, function (data) {
            console.log("rs? data: " + data);
            if (data == '0') {
                // if (data == '') {
                //     $("#id_feedback").html("빈칸은 사용할 수 없음");
                //     $("#id_feedback").attr("color", "#dc3545");
                // }
                $("#id_feedback").html("사용 가능한 ID");
                $("#id_feedback").attr("color", "#2fb380");
            }
            else {
                $("#id_feedback").html("이미 사용중인 ID");
                $("#id_feedback").attr("color", "#dc3545");
            }
        });
    }
    if (id == '') {
        $("#id_feedback").html("빈칸은 사용할 수 없음");
        $("#id_feedback").attr("color", "#dc3545");
    }
});

//// pw check
$("#inputPw").blur(function () {
    let result = nullCheck($("#inputPw").val(), $("#inputPwResult"), "PW는");
    results[1] = result;
    $("#inputPwCheck").val("");
    results[2] = false;
    $("#inputPwCheckResult").html("");
})

//// pw Equal Check
$("#inputPwCheck").blur(function () {
    let result = equals($("#inputPw").val(), $("#inputPwCheck").val());
    if (result) {
        $("#inputPwCheckResult").html("동일한 비밀번호");
        $("#inputPwCheckResult").attr("color", "#2fb380");
    } else {
        $("#inputPwCheckResult").html("비밀번호가 일치하지 않습니다.");
        $("#inputPwCheckResult").attr("color", "#dc3545");
    }
    results[2] = result;
})

//// name check
$("#inputName").blur(function () {
    let result = nullCheck($("#inputName").val(), $("#inputNameResult"), "Name은")
    results[3] = result;
})

//// email check
$("#inputEmail").blur(function () {
    let result = nullCheck($("#inputEmail").val(), $("#inputEmailResult"), "Email은")
    results[4] = result;
})

$("#joinButton").click(function () {

    if (results.includes(false)) {
        alert("필수 입력은 다 입력해");
    } else {
        // alert("전송");
        $("#joinForm").submit();
    }
});