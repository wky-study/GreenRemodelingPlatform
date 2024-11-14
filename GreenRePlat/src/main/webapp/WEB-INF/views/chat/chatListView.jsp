<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>채팅방 리스트</title>
<style>
.header-row {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 10px;
}
</style>
</head>
<body>
	<%@include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="col">
			<div class="card">
				<div class="card-body">
					<!-- 제목과 글쓰기 버튼 -->
					<div class="header-row">
						<h5 class="card-title">채팅방</h5>
						<button class="btn btn-primary"
							onclick="location.href='${pageContext.request.contextPath}/noticeWriteView'">방 만들기</button>
					</div>

					<div class="table-responsive">
						<table class="table text-nowrap align-middle mb-0">
							<thead>
								<tr class="border-2 border-bottom border-primary border-0">
									<th scope="col" class="ps-0">방번호</th>
									<th scope="col">방제목</th>
									<th scope="col" class="text-center">방장</th>
									<th scope="col" class="text-center">생성일</th>
								</tr>
							</thead>
							<tbody class="table-group-divider">
								<c:forEach items="${roomList}" var="room">
									<tr>
										<th scope="row" class="ps-0 fw-medium"><span
											class="table-link1 text-truncate d-block">${room.roomNo}</span>
										</th>
										<td><a
											href="${pageContext.request.contextPath }/roomView?no=${room.roomNo}"
											class="link-primary text-dark fw-medium d-block">${room.roomName}</a>
										</td>
										<td class="text-center fw-medium">${room.memNick}(방장)</td>
										<td class="text-center fw-medium">${room.regDate}</td>

										<!-- 로그인된 사용자 ID가 글 작성자 ID와 같을 때만 삭제 버튼 표시 -->
										<c:if test="${loggedInUserId == room.memId}">
										    <td>
										        <form action="${pageContext.request.contextPath}/roomDeleteDo" method="post">
										            <input type="hidden" name="roomNo" value="${room.roomNo}" />
										            <button type="submit" class="btn btn-danger btn-sm">삭제기능 아직</button>
										        </form>
										    </td>
										</c:if>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>
				</div>

				<!-- 페이징 시작 -->
				<div class="d-flex justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<!-- 이전 페이지 -->
							<li class="page-item ${keySearch.pageNo == 1 ? 'disabled' : ''}">
								<a class="page-link"
								href="${pageContext.request.contextPath}/noticeView?pageNo=${keySearch.pageNo - 1}&rowSizePerPage=${keySearch.rowSizePerPage}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a>
							</li>

							<!-- 중간 페이지 번호 부분 -->
							<c:forEach begin="${keySearch.firstPage}"
								end="${keySearch.lastPage}" var="num">
								<li class="page-item ${keySearch.pageNo == num ? 'active' : ''}">
									<a class="page-link"
									href="${pageContext.request.contextPath}/noticeView?pageNo=${num}&rowSizePerPage=${keySearch.rowSizePerPage}">${num}</a>
								</li>
							</c:forEach>

							<!-- 다음 페이지 -->
							<li
								class="page-item ${keySearch.pageNo == keySearch.finalPage ? 'disabled' : ''}">
								<a class="page-link"
								href="${pageContext.request.contextPath}/roomView?pageNo=${keySearch.pageNo + 1}&rowSizePerPage=${keySearch.rowSizePerPage}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a>
							</li>
						</ul>
					</nav>
				</div>
				<!-- 페이징 끝 -->
			</div>
		</div>
			
	</div>

	<%@include file="/WEB-INF/inc/footer.jsp"%>
</body>
</html>