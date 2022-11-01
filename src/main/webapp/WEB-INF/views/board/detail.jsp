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
	<section class="container-fluid col-lg-10">
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
					<td>${boVO.num}</td>
					<td>${boVO.title}</td>
					<td>${boVO.writer}</td>
					<td>${boVO.contents}</td>
					<td>${boVO.regDate}</td>
					<td>${boVO.hit}</td>
					<c:forEach items="${boVO.boardFileVOs }" var="file">
						<td>
							<c:choose>
								<c:when test="${file.fileName == null }">
									<c:forEach items="${boVO.boardFileVOs }" var="VO">
										파일이 존재하지 않음
									</c:forEach>
								</c:when>
								<c:otherwise>
									<img style="width: 200px; height: 150px;" src="/file/${file.fileName}">
								</c:otherwise>
							</c:choose>
						</td>
					</c:forEach>
				</tr>
			</table>
		</div>
	</section>
</body>

</html>