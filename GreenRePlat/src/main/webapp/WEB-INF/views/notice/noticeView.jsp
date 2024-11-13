<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글</title>
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
						<h5 class="card-title">공지 사항</h5>
						<button class="btn btn-primary"
							onclick="location.href='${pageContext.request.contextPath}/noticeWriteView'">글쓰기</button>
					</div>

					<div class="table-responsive">
						<table class="table text-nowrap align-middle mb-0">
							<thead>
								<tr class="border-2 border-bottom border-primary border-0">
									<th scope="col" class="ps-0">글 번호</th>
									<th scope="col">제목</th>
									<th scope="col" class="text-center">작성자</th>
									<th scope="col" class="text-center">조회수</th>
								</tr>
							</thead>
							<tbody class="table-group-divider">
								<c:forEach items="${keyNotice}" var="notice">
									<tr>
										<th scope="row" class="ps-0 fw-medium"><span
											class="table-link1 text-truncate d-block">${notice.noticeNo}</span>
										</th>
										<td><a
											href="${pageContext.request.contextPath }/noticeDetailView?no=${notice.noticeNo}"
											class="link-primary text-dark fw-medium d-block">${notice.noticeTitle}</a>
										</td>
										<td class="text-center fw-medium">${notice.memId}(관리자)</td>
										<td class="text-center fw-medium">${notice.noticeCount}</td>

										<!-- 로그인된 사용자 ID가 글 작성자 ID와 같을 때만 삭제 버튼 표시 -->
										<c:if test="${loggedInUserId == notice.memId}">
										    <td>
										        <form action="${pageContext.request.contextPath}/noticeDeleteDo" method="post">
										            <input type="hidden" name="noticeNo" value="${notice.noticeNo}" />
										            <button type="submit" class="btn btn-danger btn-sm">삭제</button>
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
								href="${pageContext.request.contextPath}/noticeView?pageNo=${keySearch.pageNo + 1}&rowSizePerPage=${keySearch.rowSizePerPage}"
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