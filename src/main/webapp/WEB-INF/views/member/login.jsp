<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
<body>
	<form action="./login" method="post">
		<br>
		<h1 style="text-align: center;">로그인</h1>
		<section class="col-lg-6 container-fluid mt-4">
			<div class="row">
				<div class="mb-3">
					<label>아이디</label>
					<input type="text" id="id" class="form-control" name="id"
						placeholder="ID Input" onfocus="this.placeholder=''"
						onblur="this.placeholder='ID Input'" autocomplete="off">
				</div>
				<div class="mb-3">
					<label>비밀번호</label>
					<input type="password" id="pwd" class="form-control" name="pwd"
						placeholder="Password Input" onfocus="this.placeholder=''"
						onblur="this.placeholder='Password Input'" autocomplete="off">
					<div></div>
				</div>
				<div class="mb-3" style="text-align: center;">
					<a href="../" class="btn btn-outline-dark log">home</a>
					<button type="submit" class="btn btn-outline-dark log">로그인</button>
				</div>
			</div>
		</section>
	</form>
</body>
</html>