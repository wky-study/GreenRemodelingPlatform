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
							<img class="img-fluid"
								src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg"
								alt="" />
						</div>
					</div>

					<!-- 자재 상세 정보 -->
					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>자재타입
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>모델명
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>제조사
						</h5>

						<!-- 수량 선택 및 가격 표시 -->
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>수량 <input
								type="number" id="quantity" value="1" min="1"
								onchange="updateTotalPrice(10000)"
								style="width: 60px; margin-left: 10px;"> <a
								class="badge text-bg-light text-dark">수량을선택해주세요</a>
						</h5>

						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>가격 <span
								id="totalPrice">10,000</span>원
						</h5>

						<!-- 견적버튼 -->
						<a class="btn btn-primary py-3 px-5 mt-3" href="">견적서 담기</a>
					</div>
				</div>

			</div>
		</div>

	</div>


	<!-- 자재상페이지 자재크기 -->
	<div class="container-xxl bg-primary facts my-5 py-5 wow fadeInUp"
		data-wow-delay="0.1s">
		<div class="container py-5">
			<div class="row g-4">
				<div class="col-lg-8">
					<div class="card">
						<div class="card-body">
							<h1 style="text-align: center;">자재크기</h1>
							<div class="table-responsive">
								<table class="table text-nowrap align-middle mb-0">
									<thead>
										<tr class="border-2 border-bottom border-primary border-0">
											<th scope="col" class="ps-0">가로</th>
											<th scope="col">세로</th>
											<th scope="col" class="text-center">높이</th>
											<th scope="col" class="text-center">넓이</th>
										</tr>
									</thead>
									<tbody class="table-group-divider">
										<tr>
											<th scope="row" class="ps-0 fw-medium"><span
												class="table-link1 text-truncate d-block"></span></th>
											<td><a href="javascript:void(0)"
												class="link-primary text-dark fw-medium d-block"></a></td>
											<td class="text-center fw-medium"></td>
											<td class="text-center fw-medium"></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card overflow-hidden hover-img">
						<div class="position-relative">
							<a href="javascript:void(0)"> <img
								src="${pageContext.request.contextPath}/assets/images/material/에너지효율등급.jpg"
								class="card-img-top" alt="">
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="card-body" style="text-align: center;">

		<!-- 자재상세페이지 자재상세설명 -->
		<div class="container">
			<div class="card-body">
				<h1>상품 상세설명</h1>

				<h5>소송건조 다루끼(A급)</h5>
				<br>
				<h5>30x30x3600</h5>
				<br> <img
					src="${pageContext.request.contextPath}/assets/images/material/자재사진01.jpg">
				<br>
				<h5>각목, 각재, 다루끼 등 다양하게 불리고 있으며 현장에서는 다루끼라고 많이 부르고 있습니다.</h5>
				<br>
				<h5>다루끼는 두꺼운 제재목을 두께 방향으로 분할하여 만든 제재목입니다</h5>
				<br>
				<h5>​현재 국내에서 유통되는 다루끼는 미송, 소송, 뉴송, 유럽산 스프러스 크게 4가지로 분류되며</h5>
				<br>
				<h5>가장 널리 이용되고 있는 각재는 소송각재 입니다.</h5>
				<br> <img
					src="${pageContext.request.contextPath}/assets/images/material/자재사진02.jpg"
					class="card-img-top"> <br> <img
					src="${pageContext.request.contextPath}/assets/images/material/자재사진03.jpg"
					class="card-img-top"> <br>
				<h1>특징 및 장점</h1>
				<br>
				<h5>소송은 러시아산 소나무로 미송보다 색상이 밝고 옹이가 적어 강도저하가 적습니다.</h5>
				<br>
				<h5>​소송다루끼의 용도는 목질이 연하고 부드러워 인테리어재, 펄프재, 선박재로 자주 사용되며 바닥과 내벽의
					합판이나 마루를 시공할 때 또는 천정 공사를 할 때 프레임용으로 많이 사용됩니다</h5>
				<br>
				<h1>목재 전국 유통</h1>
				<br>
				<h5>전국에 위치한 창고에서 당일 출고 가능합니다</h5>
				<br> <img
					src="${pageContext.request.contextPath}/assets/images/material/유통사진01.jpg">
				<br>
				<h1>구매안내</h1>
				<br> <img
					src="${pageContext.request.contextPath}/assets/images/material/구매안내.jpg">
				<br>
				<h1>운임표</h1>
				<br> <img
					src="${pageContext.request.contextPath}/assets/images/material/운임표.jpg">
				<br>



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

	<script>
		// 수량 변경 시 총 가격을 업데이트하는 함수
		function updateTotalPrice(unitPrice) {
			// 수량 값을 가져와 숫자로 변환
			const quantity = parseInt(document.getElementById("quantity").value);

			// 총 가격 계산
			const totalPrice = unitPrice * quantity;

			// 총 가격을 화면에 표시
			document.getElementById("totalPrice").innerText = totalPrice
					.toLocaleString();
		}
	</script>
</body>

</html>

