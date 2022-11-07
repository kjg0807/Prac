function nullCheck(data, dest, kind) {
    // console.log(dest);
    if (data == null || data == '') {
        $(dest).html(kind + " 빈칸으로 사용할 수 없음");
        // $(dest).attr("color", "#dc3545");
        return false;
    } else {
        $(dest).html("정상");
        // $(dest).attr("color", "#2fb380");
        return true;
    }
}

function equals(data, checkData) {
    if (data == checkData) {
        return true;
    } else {
        return false;
    }
}