<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html lang="en">

<style>

/*** Img Border ***/
.img-border {
	position: relative;
	height: 100%;
	min-height: 400px;
}

.img-border::before {
	position: absolute;
	content: "";
	top: 0;
	left: 0;
	right: 3rem;
	bottom: 3rem;
	border: 5px solid #2952ff;
}

.img-border img {
	position: absolute;
	top: 3rem;
	left: 3rem;
	width: calc(100% - 3rem);
	height: calc(100% - 3rem);
	object-fit: cover;
}
</style>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>자재페이지</title>

<!-- Libraries Stylesheet -->
<link
	href="${pageContext.request.contextPath}/assets/libs/animate/animate.min.css"
	rel="stylesheet" />

</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<!-- About Start -->
	<div class="container-fluid mb-5">

		<div class="container-xxl py-5">
			<div class="container">

				<div class="row g-5">

					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<div class="img-border">
							<img class="img-fluid" src="" alt="" />
						</div>
					</div>

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
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>수량
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>가격
						</h5>
						<a class="btn btn-primary py-3 px-5 mt-3" href="">바로 구매하기</a> <a
							class="btn btn-primary py-3 px-5 mt-3" href="">견적서 담기</a> <a
							class="btn btn-primary py-3 px-5 mt-3" href="">장바구니담기</a>
					</div>
				</div>



			</div>
		</div>

	</div>
	<!-- About End -->

	<!-- Facts Start -->
	<div class="container-xxl bg-primary facts my-5 py-5 wow fadeInUp"
		data-wow-delay="0.1s">
		<div class="container py-5">
			<div class="row g-4">

				<div class="col-lg-8">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">자재크기</h5>
							<div class="table-responsive">
								<table class="table text-nowrap align-middle mb-0">
									<thead>
										<tr class="border-2 border-bottom border-primary border-0">
											<th scope="col" class="ps-0">Page Title</th>
											<th scope="col">Link</th>
											<th scope="col" class="text-center">Pageviews</th>
											<th scope="col" class="text-center">Page Value</th>
										</tr>
									</thead>
									<tbody class="table-group-divider">
										<tr>
											<th scope="row" class="ps-0 fw-medium"><span
												class="table-link1 text-truncate d-block">Welcome to
													our website</span></th>
											<td><a href="javascript:void(0)"
												class="link-primary text-dark fw-medium d-block">/index.html</a>
											</td>
											<td class="text-center fw-medium">18,456</td>
											<td class="text-center fw-medium">$2.40</td>
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
								src="${pageContext.request.contextPath}/assets/images/blog/blog-img1.jpg"
								class="card-img-top" alt="matdash-img">
							</a> <span
								class="badge text-bg-light text-dark fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">
								#에너지효율등급</span>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- Facts End -->

	<!-- Back to Top -->
	<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
		class="bi bi-arrow-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/libs/wow/wow.min.js"></script>

	<!-- Template Javascript -->
	<script src="${pageContext.request.contextPath}/assets/js/material.js"></script>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

</body>

</html>

