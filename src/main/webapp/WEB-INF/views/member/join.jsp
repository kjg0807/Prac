<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/util.js"></script>
<script defer src="/js/memberAdd.js"></script>
</head>
<body>
	<form:form modelAttribute="memberVO" method="post">

		<%-- <form action="./add" id="joinForm" method="post"> --%>
		<section class="col-lg-6 container-fluid mt-4" style="text-align: center;">
			<h1>회원 가입</h1>
			<br>
			<div class="row">
				<div class="mb-3">
					<label for="inputUserName" class="col-form-label">ID</label>
					<div>
						<form:input path="id" cssClass="form-control" id="inputId" placeholder="ID 입력" />
						<!-- <input type="text" name="id" class="form-control" id="inputId" placeholder="ID 입력"> -->
						<form:errors path="id"></form:errors>
						<div id="inputIdResult">
						</div>
						<div>
							<font id="id_feedback" size="3"></font>
						</div>
					</div>
				</div>
				<div class="mb-3">
					<label for="inputPassword" class="col-form-label">Password</label>
					<div>
						<form:password path="pwd" cssClass="form-control" id="inputPw" placeholder="Password 입력" />
						<!-- <input type="password" name="password" class="form-control" id="inputPw" placeholder="Password 입력"> -->
						<form:errors path="pwd"></form:errors>
						<div id="inputPwResult"></div>
					</div>
				</div>

				<div class="mb-3">
					<label for="inputPassword" class="col-form-label">Password Check</label>
					<div>
						<form:password path="pwCheck" cssClass="form-control" id="inputPwCheck" placeholder="Password 확인" />
						<!-- <input type="password" name="pw" class="form-control" id="inputPwCheck" placeholder="Password 입력"> -->
						<form:errors path="pwCheck"></form:errors>
						<div id="inputPwCheckResult"></div>
					</div>
				</div>

				<div class="mb-3">
					<label for="inputName" class="col-form-label">Name</label>
					<div>
						<form:input path="name" cssClass="form-control" id="inputName" placeholder="이름 입력" />
						<!-- <input type="text" name="name" class="form-control" id="inputName" placeholder="이름 입력"> -->
						<div id="inputNameResult">
							<form:errors path="name"></form:errors>
						</div>
					</div>
				</div>

				<div class="mb-3">
					<label for="inputEmail" class="col-form-label">Email</label>
					<div>
						<form:input path="email" cssClass="form-control" id="inputEmail" placeholder="Email 입력" />
						<!-- <input type="email" required name="email" class="form-control" id="inputEmail" placeholder="Email 입력"> -->
						<form:errors path="email"></form:errors>
						<div id="inputEmailResult"></div>
					</div>
				</div>
				<div class="mb-3">
					<label for="inputEmail" class="col-form-label">Age</label>
					<div>
						<form:input path="age" cssClass="form-control" id="inputEmail" placeholder="age 입력" value="24" />
						<!-- <input type="email" required name="email" class="form-control" id="inputEmail" placeholder="Email 입력"> -->
						<form:errors path="age"></form:errors>
						<div id="inputEmailResult"></div>
					</div>
				</div>

				<div class="mb-3">
					<label for="inputEmail" class="col-form-label">Birth</label>
					<div>
						<form:input path="birth" cssClass="form-control" id="inputEmail" placeholder="birth 입력"
							value="2000-11-11" />
						<!-- <input type="email" required name="email" class="form-control" id="inputEmail" placeholder="Email 입력"> -->
						<form:errors path="birth"></form:errors>
						<div id="inputEmailResult"></div>
					</div>
				</div>

				<div class="mb-3" style="text-align: center;">
					<a href="../" class="btn btn-outline-dark log">home</a>
					<button type="submit" id="joinButton" class="btn btn-outline-dark">Sign in</button>
				</div>
			</div>
		</section>
		<%-- </form> --%>
	</form:form>
	<!-- 약관 test-->
	<div style="text-align: center;">
		<div>
			ALL <input type="checkbox" id="all">
		</div>
		<br>
		<div>
			동의1 <input type="checkbox" class="check" name="" id="">
			<div>약관1</div>
		</div>
		<br>
		<div>
			동의2 <input type="checkbox" class="check" name="" id="">
			<div>약관2</div>
		</div>
		<br>
		<div>
			동의3 <input type="checkbox" class="check" name="" id="">
			<div>약관3</div>
		</div>
	</div>

</body>
</html>