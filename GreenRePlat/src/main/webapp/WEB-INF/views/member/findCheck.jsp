<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>비밀번호찾기</title>
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

								<form action="${pageContext.request.contextPath}/findPw"
									method="POST">
									<label for="memId" class="form-label">아이디</label> <input
										class="form-control" type="text" id="memId" name="memId"
										required /> <br> <label for="memName" class="form-label">이름</label>
									<input class="form-control" type="text" id="memName"
										name="memName" required /> <br>
									<button type="submit" class="btn btn-primary w-100 py-8 fs-4 mb-4">비밀번호 찾기</button>
								</form>
									<a href="${pageContext.request.contextPath}/loginView" type="submit" class="btn btn-primary w-100 py-8 fs-4 mb-4">로그인화면이동</a>

								<!-- 이메일 전송 성공 메시지 출력 -->
								<c:if test="${not empty emailSuccess}">
									<div class="alert alert-success">${emailSuccess}</div>
								</c:if>

								<!-- 이메일 전송 실패 메시지 출력 -->
								<c:if test="${not empty emailError}">
									<div class="alert alert-danger">${emailError}</div>
								</c:if>
								
								<!--  아이디/이름 성공 메시지 출력 -->
								<c:if test="${not empty success}">
									<div class="alert alert-success">${success}</div>
								</c:if>

								<!-- 아이디/이름 실패 메시지 출력 -->
								<c:if test="${not empty error}">
									<div class="alert alert-danger">${error}</div>
								</c:if>

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
