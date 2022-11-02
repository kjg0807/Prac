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
	<section class="container-fluid col-lg-10" style="text-align: center;">
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
					<c:forEach items="${boVO.boardFileVOs }" var="file">
						<c:choose>
							<c:when test="${file.fileName == null }">
								<c:forEach items="${ar.qnaFileVOs }" var="file">
								</c:forEach>
							</c:when>
							<c:otherwise>
								<td>Picture Link</td>
							</c:otherwise>
						</c:choose>
					</c:forEach>
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
										No File
									</c:forEach>
								</c:when>
								<c:otherwise>
									<a href="/file/qna/${file.fileName}">
										<img style="width: 200px; height: 150px;" src="/file/qna/${file.fileName}">
									</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${file.fileName == null }">
									<c:forEach items="${boVO.boardFileVOs }" var="file">
									</c:forEach>
								</c:when>
								<c:otherwise>
									<a class="btn btn-outline-dark" href="/fileDown/qna?fileNum=${file.fileNum }">Picture Download</a>
								</c:otherwise>
							</c:choose>
						</td>
					</c:forEach>
				</tr>
			</table>
		</div>
		<a href="./list" class="btn btn-outline-dark">list Page</a>
	</section>
</body>

</html>