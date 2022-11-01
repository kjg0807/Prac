<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
</head>
<script defer src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
.sss {
	display: flex;
	justify-content: center;
}
</style>
<script defer src="/js/write.js"></script>
<body>
	<form:form modelAttribute="boardVO" method="post" enctype="multipart/form-data" id="frm">
		<section class="container-fluid col-lg-6 mt-5">
			<h1>Qna Write Page</h1>
			<div class="mb-3">
				<label>제목</label>
				<form:input path="title" id="title" cssClass="form-control" placeholder="제목를 입력하세요." />
				<form:errors path="title"></form:errors>
				<div>
					<font id="titleText" size="3"></font>
				</div>
			</div>
			<div class="mb-3">
				<label>작성자</label>
				<form:input path="writer" id="writer" cssClass="form-control" placeholder="제목를 입력하세요." />
				<form:errors path="writer"></form:errors>
				<div>
					<font id="writerText" size="3"></font>
				</div>
			</div>
			<div class="mb-3">
				<label>내용</label>
				<form:textarea path="contents" id="contents" cssClass="form-control" placeholder="제목를 입력하세요." />
				<form:errors path="contents"></form:errors>
				<div>
					<font id="conText" size="3"></font>
				</div>
			</div>
			<div class="mb-3" id="File">
				<div class="mb-3">
					<button type="button" id="fileAdd" class="btn btn-outline-dark">File Add</button>
					<button type="button" id="fileDel" class="btn btn-outline-dark" style="display: none;">File
						Delete</button>
					<br>
				</div>
			</div>
			<div class="sss">
				<button type="button" id="writeBtn" class="btn btn-outline-dark">Write</button>
				<a href="./list" class="btn btn-outline-dark">list</a>
				<a href="/" class="btn btn-outline-dark">Home</a>
			</div>
		</section>
	</form:form>
	<br>
	<br>
	<br>
</body>
<script type="text/javascript">
	$("#contents").summernote({
		height : 300,
		minHeight : 150,
		maxHeight : 500
	});
</script>
</html>