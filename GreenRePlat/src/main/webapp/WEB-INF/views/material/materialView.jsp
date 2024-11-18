<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html lang="ko">

<style>
.badge-ma {
	position: absolute;
	width: 90%;
	height: 30px;
	magin-bottom: 50%;
	text-align: right;
}

.img-border {
	position: relative;
	height: 100%;
	min-height: 400px;
}

.img-border::before {
	position: absolute;
	content: "";
	top: 3rem;
	left: 0;
	right: 3rem;
	bottom: 0;
	border: 5px solid #2952ff;
}

.img-border img {
	position: absolute;
	top: 0;
	left: 3rem;
	width: calc(100% - 3rem);
	height: calc(100% - 3rem);
	object-fit: cover;
}
</style>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>자재목록페이지</title>

<!-- Libraries Stylesheet -->
<link
	href="${pageContext.request.contextPath}/assets/libs/animate/animate.min.css"
	rel="stylesheet" />

</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<!-- 자재목록페이지  -->
	<div class="container-fluid mb-5">

		<!-- 자재 목록데이터 불러오기 -->
		<div class="container-xxl py-5">
			<div class="container">
				<div class="row g-5">
					<c:forEach items="${keymaterial}" var="MaterialDTO">
						<div class="col-lg-4 wow fadeInUp" data-wow-delay="0.5s">
							<a href="${pageContext.request.contextPath}/materialDetailView">
								<div class="img-border">
									<img class="img-fluid" src="${MaterialDTO.itemImg}" />
									<h4 class="badge-ma text-bg-light text-dark bottom-0 end-0">
										${MaterialDTO.itemName}</h4>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>

				<!-- 페이징 시작 -->
				<div class="d-flex justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">


							<!-- 검색중이면 검색옵션과 검색어를 유지하면서 페이징 처리 -->
							<!-- 검색중이지 않으면 검색 옵션과 검색어가 주소창에 나타나지 않게 하기 -->
							<!-- searchWord가 null이면 a태그의 href에서 searchOption 과 searchWord 떼어내기 -->

							<!-- 이전 페이지 -->
							<li class="page-item ${keySearch.firstPage == 1 ? 'disabled' : '' }">
								
								<c:if test="${keySearch.searchWord != null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/materialView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a>
								</c:if> <c:if test="${keySearch.searchWord == null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/materialView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a>
								</c:if>


							</li>

							<!-- 중간 페이지 번호 부분 -->
							<!-- model에 keySearch 이름으로 searchM를 담음 -->
							<!-- searchM 내 pageNo, firstPage, lastPage 채워져있음 -->

							<c:forEach begin="${keySearch.firstPage }"
								end="${keySearch.lastPage }" var="num">
								<li
									class="page-item ${keySearch.pageNo == num ? 'active' : '' } ">
									<c:if test="${keySearch.searchWord != null}">
										<a class="page-link"
											href="${pageContext.request.contextPath }/materialView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}">${num }</a>
									</c:if> <c:if test="${keySearch.searchWord == null}">
										<a class="page-link"
											href="${pageContext.request.contextPath }/materialView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}">${num }</a>
									</c:if>
								</li>
							</c:forEach>

							<!-- 다음 페이지 -->
							<!-- 마지막 페이지 도달 시 disabled 추가 -->
							<li
								class="page-item ${keySearch.pageNo == keySearch.finalPage ? 'disabled' : ''  }">
								<c:if test="${keySearch.searchWord == null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/materialView?pageNo=${keySearch.lastPage + 1 }&rowSizePerPage=${keySearch.rowSizePerPage}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a>
								</c:if> <c:if test="${keySearch.searchWord != null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/materialView?pageNo=${keySearch.lastPage + 1 }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a>
								</c:if>
							</li>
						</ul>
					</nav>
				</div>

				<!-- 자재검색기능 -->
				<div class="d-flex justify-content-center">
					<form class="d-flex"
						action="${pageContext.request.contextPath }/materialView"
						method="GET">
						<select class="form-select me-1" name="searchOption">
							<option value="name" selected>자재이름</option>
							<option value="brand">제조사</option>
							<option value="type">자재타입</option>
						</select> <input class="form-control me-1" type="text" name="searchWord">
						<button class="btn btn-outline-primary" type="submit">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-seach" viewBox="0 0 16 16">
				<path
									d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
				</svg>
						</button>
					</form>
				</div>

			</div>
		</div>


	</div>









	<%@ include file="/WEB-INF/inc/footer.jsp"%>


	<!-- 스크립트들 -->
	<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
		class="bi bi-arrow-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/libs/wow/wow.min.js"></script>

	<!-- Template Javascript -->
	<script src="${pageContext.request.contextPath}/assets/js/material.js"></script>

</body>

</html>