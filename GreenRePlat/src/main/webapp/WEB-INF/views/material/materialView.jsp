<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html lang="ko">

<style>
.badge-ma {
	position: absolute;
	width: 80%;
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

		<!-- 자재종류버튼 시작 -->
		<div>
			<a href="#" target="_blank"
				class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a> <a href="#"
				target="_blank" class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a>
			<a href="#" target="_blank"
				class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a> <a href="#"
				target="_blank" class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a>
			<a href="#" target="_blank"
				class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a> <a href="#"
				target="_blank" class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a>
			<a href="#" target="_blank"
				class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a> <a href="#"
				target="_blank" class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a>
			<a href="#" target="_blank"
				class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a> <a href="#"
				target="_blank" class="btn btn-primary fs-2 fw-semibold lh-sm">자재종류</a>
		</div>
		<!-- 자재종류버튼 끝 -->

		<!-- 자재사진과 모델명 시작 -->
		<div class="container-xxl py-5">
			<div class="container">
				<div class="row g-5">
					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<a href="${pageContext.request.contextPath}/materialDetailView">
							<div class="img-border">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg"
									alt="" />
								<h4 class="badge-ma text-bg-light text-dark bottom-0 end-0">소송건조
									다루끼(A급) 30x30x3600</h4>
							</div>
						</a>
					</div>

					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<a href="${pageContext.request.contextPath}/materialDetailView">
							<div class="img-border">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg"
									alt="" />
								<h4 class="badge-ma text-bg-light text-dark bottom-0 end-0">소송건조
									다루끼(A급) 30x30x3600</h4>
							</div>
						</a>
					</div>

					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<a href="${pageContext.request.contextPath}/materialDetailView">
							<div class="img-border">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg"
									alt="" />
								<h4 class="badge-ma text-bg-light text-dark bottom-0 end-0">소송건조
									다루끼(A급) 30x30x3600</h4>
							</div>
						</a>
					</div>

					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<a href="${pageContext.request.contextPath}/materialDetailView">
							<div class="img-border">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg"
									alt="" />
								<h4 class="badge-ma text-bg-light text-dark bottom-0 end-0">소송건조
									다루끼(A급) 30x30x3600</h4>
							</div>
						</a>
					</div>

					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<a href="${pageContext.request.contextPath}/materialDetailView">
							<div class="img-border">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg"
									alt="" />
								<h4 class="badge-ma text-bg-light text-dark bottom-0 end-0">소송건조
									다루끼(A급) 30x30x3600</h4>
							</div>
						</a>
					</div>

					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<a href="${pageContext.request.contextPath}/materialDetailView">
							<div class="img-border">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg"
									alt="" />
								<h4 class="badge-ma text-bg-light text-dark bottom-0 end-0">소송건조
									다루끼(A급) 30x30x3600</h4>
							</div>
						</a>
					</div>

					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<a href="${pageContext.request.contextPath}/materialDetailView">
							<div class="img-border">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg"
									alt="" />
								<h4 class="badge-ma text-bg-light text-dark bottom-0 end-0">소송건조
									다루끼(A급) 30x30x3600</h4>
							</div>
						</a>
					</div>

					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<a href="${pageContext.request.contextPath}/materialDetailView">
							<div class="img-border">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg"
									alt="" />
								<h4 class="badge-ma text-bg-light text-dark bottom-0 end-0">소송건조
									다루끼(A급) 30x30x3600</h4>
							</div>
						</a>
					</div>



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



	</script>
</body>

</html>