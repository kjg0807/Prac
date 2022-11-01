<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../temp/boot.jsp"></c:import>

<body>
	<section class="container-fluid col-lg-6">
		<h1 style="text-align: center;">Qna Detail Page</h1>
		<div class="mb-3">
			<table class="table table-hover">
				<tr>
					<td>Num</td>
					<td>Title</td>
					<td>Writer</td>
					<td>Contents</td>
					<td>Date</td>
					<td>Hit</td>
					<td>Picture</td>
				</tr>
				<tr>
					<td>${boardVO.num}</td>
					<td>${boardVO.title}</td>
					<td>${boardVO.writer}</td>
					<td>${boardVO.contents}</td>
					<td>${boardVO.regDate}</td>
					<td>${boardVO.hit}</td>
					<c:forEach items="${boardVO.boardFileVOs }" var="file">
						<c:choose>
							<c:when test="${file.fileName == null }">
								<td>파일이 존재하지 않음</td>
							</c:when>
						</c:choose>
						<c:otherwise>
							<td>
								<img style="width: 250px; height: 200px;" src="/file/qna/${file.fileName}">
							</td>
						</c:otherwise>
					</c:forEach>
				</tr>
			</table>
		</div>
	</section>
</body>

</html>