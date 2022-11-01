<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<style>
a:hover {
	color: red;
}

a {
	text-decoration: none;
	color: black;
}

.dd {
	display: flex;
	justify-content: center;
}
</style>
<body>
	<form action="./list" class="col-lg-10 container-fluid">
		<section class="container-fluid col-lg-10 mt-5" style="text-align: center;">
			<h1 style="text-align: center;">Qna List Page</h1>
			<br>
			<div class="dd">
				<div class="col-6">
					<label for="inlineFormSelectPref">검색할 제목을 입력</label>
					<div class="input-group">
						<input type="text" name="search" value="${param.pager}" class="form-control"
							id="inlineFormInputGroupUsername" placeholder="Input Word">
						<button type="submit" class="btn btn-outline-dark">Search</button>
					</div>
				</div>
			</div>
			<br>
			<div>
				<table class="table table-hover">
					<tr>
						<td>Num</td>
						<td>Title</td>
						<td>Writer</td>
						<td>Contents</td>
						<td>Date</td>
					</tr>
					<c:forEach items="${ar}" var="ar">
						<tr>
							<td>${ar.num}</td>
							<td>
								<a href="./detail?num=${ar.num}">${ar.title}</a>
							</td>
							<td>${ar.writer}</td>
							<td>${ar.contents}</td>
							<td>${ar.regDate}</td>
						</tr>
					</c:forEach>
				</table>
				<a href="./write" class="btn btn-outline-dark">Write Page</a>
				<a href="/" class="btn btn-outline-dark">Home</a>
			</div>
			<br>
			<br>
			<!-- 페이징 처리 -->
			<section class="container-fluid col-lg-6">
				<!-- <form class="col-lg-6 container-fluid page"> -->
				<!-- --------------- page --------------- -->
				<nav aria-label="Page navigation example" class="col-lg-6 b">
					<ul class="pagination">
						<!-- page가 1번일때 이전 버튼을 없앰 -->
						<li class="page-item ${pager.pre?'':'disabled'}">
							<a class="page-link" href="./list?page=${pager.startNum - 1}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>

						<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
							<li class="page-item">
								<a class="page-link" href="./list?page=${i}&search=${pager.search}">${i} </a>
							</li>
						</c:forEach>

						<c:choose>
							<c:when test="${pager.next}">
								<li class="page-item">
									<a class="page-link" href="./list?page=${pager.lastNum + 1}&search=${pager.search}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item disabled">
									<a class="page-link" href="./list?page=${pager.lastNum + 1}&search=${pager.search}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
				<!-- </form> -->
			</section>
			<br>
			<br>
		</section>
	</form>
</body>
</html>