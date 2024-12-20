<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<link rel="shortcut icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/images/logos/seodashlogo.png" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/styles.min.css" />
</head>

<body>
	<!--  Body Wrapper -->
	<div class="page-wrapper" id="main-wrapper" data-layout="vertical"
		data-navbarbg="skin6" data-sidebartype="full"
		data-sidebar-position="fixed" data-header-position="fixed">
		<div
			class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
			<div class="d-flex align-items-center justify-content-center w-100">
				<div class="row justify-content-center w-100">
					<div class="col-md-8 col-lg-6 col-xxl-3">
						<div class="card mb-0">
							<div class="card-body">
								<a href="./index.html"
									class="text-nowrap logo-img text-center d-block py-3 w-100">
									<img src="../assets/images/logos/logo-light.svg" alt="">
								</a>
								<p class="text-center">회원가입</p>
								<form action = "${pageContext.request.contextPath}/registDo" method = "POST">
									<div class="mb-3">
										<label for="exampleInputtext1" class="form-label">아이디</label> <input
											type="text" class="form-control" id="exampleInputtext1" name = "inputId"
											aria-describedby="textHelp">
									</div>
									<div class="mb-4">
										<label for="exampleInputPassword1" class="form-label">비밀번호</label>
										<input type="password" class="form-control" name = "inputPw"
											id="exampleInputPassword1">
									</div>
									<div class="mb-4">
										<label for="exampleInputPassword1" class="form-label">비밀번호확인</label>
										<input type="password" class="form-control"
											id="exampleInputPassword1">
									</div>
									<div class="mb-3">
										<label for="exampleInputtext1" class="form-label">이름</label> <input
											type="text" class="form-control" id="exampleInputtext1" name = "inputName"
											aria-describedby="textHelp">
									</div>
									<div class="mb-3">
										<label for="exampleInputtext1" class="form-label">주민등록번호</label> <input
											type="text" class="form-control" id="exampleInputtext1" name = "inputRn"
											aria-describedby="textHelp">
									</div>
									<div class="mb-3">
										<label for="exampleInputtext1" class="form-label">주소</label> <input
											type="text" class="form-control" id="exampleInputtext1" name = "inputAddress"
											aria-describedby="textHelp">
									</div>
									<div class="mb-3">
										<label for="exampleInputtext1" class="form-label">전화번호</label> <input
											type="text" class="form-control" id="exampleInputtext1" name = "inputPhone"
											aria-describedby="textHelp">
									</div>
									<div class="mb-3">
										<label for="exampleInputtext1" class="form-label">닉네임</label> <input
											type="text" class="form-control" id="exampleInputtext1" name = "inputNick"
											aria-describedby="textHelp">
									</div>

									<div class="mb-3">
										<label for="exampleInputEmail1" class="form-label">이메일</label> <input type="email" class="form-control"
											id="exampleInputEmail1" aria-describedby="emailHelp">
									</div>
									<button 
										class="btn btn-primary w-100 py-8 fs-4 mb-4" type = "submit">회원가입</button>
									<div class="d-flex align-items-center justify-content-center">
										<p class="fs-4 mb-0 fw-bold">이미 회원이십니까?</p>
										<a class="text-primary fw-bold ms-2"
											href="./authentication-login.html">로그인</a>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/assets/libs/jquery/dist/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/libs/apexcharts/dist/apexcharts.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/libs/simplebar/dist/simplebar.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/sidebarmenu.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/dashboard.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/iconify-icon@1.0.8/dist/iconify-icon.min.js"></script>
</body>

</html>
