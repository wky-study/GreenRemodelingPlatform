<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html lang="ko">

<style>
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
<title>자재상세페이지</title>

<!-- Libraries Stylesheet -->
<link
	href="${pageContext.request.contextPath}/assets/libs/animate/animate.min.css"
	rel="stylesheet" />

</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<!-- 자재상세페이지 자재사진 -->
	<div class="container-fluid mb-5">
		<div class="container-xxl py-5">
			<div class="container">
				<div class="row g-5">
					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<div class="img-border">
							<img class="img-fluid" src="${MaterialDTO.itemImg}" alt="" />
						</div>
					</div>

					<!-- 자재 상세 정보 -->
					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>자재이름 :
							${MaterialDTO.itemName}
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>모델명 :
							${MaterialDTO.itemModel}
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>제조사 :
							${MaterialDTO.itemBrand}
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>자재크기 :
							${MaterialDTO.itemSize}
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>에너지효율등급 :
							${MaterialDTO.itemEffiLevel}
						</h5>

						<!-- 수량 선택 및 가격 표시 -->
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>수량 <input
								type="number" id="quantity" value="1" min="1"
								onchange="updateTotalPrice(10000)"
								style="width: 60px; margin-left: 10px;"> <a
								class="badge text-bg-light text-dark">수량을선택해주세요</a>
						</h5>

						<!-- 견적버튼 -->
						<a class="btn btn-primary py-3 px-5 mt-3" href="">견적서 담기</a>
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

</body>

</html>

