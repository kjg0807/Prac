<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<a href="./member/login" class="btn btn-outline-dark">Login</a>


		<a href="./board/list" class="btn btn-outline-dark">Board List</a>
	</div>
</body>
</html>