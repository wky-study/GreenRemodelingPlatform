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
		<div class="col-lg-8">
			<div class="card">
				<div class="card-body">
					<!-- 제목과 글쓰기 버튼 -->
					<div class="header-row">
						<h5 class="card-title">공지 사항</h5>
						<button class="btn btn-primary"
							onclick="location.href='${pageContext.request.contextPath}/writeView'">글쓰기</button>
					</div>

					<div class="table-responsive">
						<table class="table text-nowrap align-middle mb-0">
							<thead>
								<tr class="border-2 border-bottom border-primary border-0">
									<th scope="col" class="ps-0">글 번 호</th>
									<th scope="col">제 목</th>
									<th scope="col" class="text-center">작 성 자</th>
									<th scope="col" class="text-center">조 회 수</th>
								</tr>
							</thead>
							<tbody class="table-group-divider">
								<c:forEach items="${noticeList}" var="notice">
									<tr>
										<th scope="row" class="ps-0 fw-medium"><span
											class="table-link1 text-truncate d-block">${notice.noticeNo}</span>
										</th>
										<td><a href="javascript:void(0)"
											class="link-primary text-dark fw-medium d-block">${notice.noticeTitle}</a>
										</td>
										<td class="text-center fw-medium">${notice.memNick}</td>
										<td class="text-center fw-medium">${notice.noticeCount}</td>
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


							<!-- 검색중이면 검색옵션과 검색어를 유지하면서 페이징 처리 -->
							<!-- 검색중이지 않으면 검색 옵션과 검색어가 주소창에 나타나지 않게 하기 -->
							<!-- searchWord가 null이면 a태그의 href에서 searchOption 과 searchWord 떼어내기 -->

							<!-- 이전 페이지 -->
							<li
								class="page-item ${keySearch.firstPage == 1 ? 'disabled' : '' }">

								<c:if test="${keySearch.searchWord != null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/productView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a>
								</c:if> <c:if test="${keySearch.searchWord == null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/productView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a>
								</c:if>
							</li>
							<!-- 중간 페이지 번호 부분 -->
							<!-- model에 keySearch 이름으로 searchVO를 담음 -->
							<!-- searchVO 내 pageNo, firstPage, lastPage 채워져있음 -->

							<c:forEach begin="${keySearch.firstPage }"
								end="${keySearch.lastPage }" var="num">
								<li
									class="page-item ${keySearch.pageNo == num ? 'active' : '' } ">
									<c:if test="${keySearch.searchWord != null}">
										<a class="page-link"
											href="${pageContext.request.contextPath }/productView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}">${num }</a>
									</c:if> <c:if test="${keySearch.searchWord == null}">
										<a class="page-link"
											href="${pageContext.request.contextPath }/productView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}">${num }</a>
									</c:if>
								</li>
							</c:forEach>

							<!-- 다음 페이지 -->
							<!-- 마지막 페이지 도달 시 disabled 추가 -->
							<li
								class="page-item ${keySearch.pageNo == keySearch.finalPage ? 'disabled' : ''  }">
								<c:if test="${keySearch.searchWord == null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/productView?pageNo=${keySearch.lastPage + 1 }&rowSizePerPage=${keySearch.rowSizePerPage}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a>
								</c:if> <c:if test="${keySearch.searchWord != null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/productView?pageNo=${keySearch.lastPage + 1 }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a>
								</c:if>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/inc/footer.jsp"%>

</body>
</html>
