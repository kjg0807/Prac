<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./temp/boot.jsp"></c:import>
</head>
<body>
	<div style="text-align: center; margin-top: 15%;">
		<h1>Home</h1>

		<a href="./board/list" class="btn btn-outline-dark">Board List</a>
		<sec:authorize access="isAuthenticated()">
		<br>
			<h3>
				<sec:authentication property="name" />
				님 환영합니다!
			</h3>
			<br>
			<a href="/member/logout" class="btn btn-outline-dark">Logout</a>
		</sec:authorize>
		<sec:authorize access="!isAuthenticated()">
			<a href="./member/login" class="btn btn-outline-dark">Login</a>
			<a href="./member/join" class="btn btn-outline-dark">Join</a>
		</sec:authorize>

	</div>
</body>
</html>