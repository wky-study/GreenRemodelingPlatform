<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마이페이지</title>

</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>
	<!--  Header End -->
	<!-- Layout wrapper -->

	<!-- Content wrapper -->
	<div class="container-fluid">
		<!-- Content -->
		<div class="container-xxl flex-grow-1 container-p-y">
			<h4 class="fw-bold py-3 mb-4">
				<span class="text-muted fw-light">설정 /</span> 회원정보
			</h4>
			<div class="row">
				<div class="col-md-12">
					<ul class="nav nav-pills flex-column flex-md-row mb-3">
						<li class="nav-item"><a class="nav-link active"
							href="javascript:void(0);"><i class="bx bx-user me-1"></i>
								회원정보</a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages-account-settings-notifications.html"><i
								class="bx bx-bell me-1"></i> 마이 프로젝트</a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages-account-settings-connections.html"><i
								class="bx bx-link-alt me-1"></i> 주문 내역</a></li>
					</ul>
					<div class="card mb-4">
						<h5 class="card-header">프로필 이미지</h5>
						<!-- Account -->
						<div class="card-body">
							<div class="d-flex align-items-start align-items-sm-center gap-4">
								<img src="../assets/img/avatars/1.png" alt="user-avatar"
									class="d-block rounded" height="100" width="100"
									id="uploadedAvatar" />
								<div class="button-wrapper">
									<label for="upload" class="btn btn-primary me-2 mb-4"
										tabindex="0"> <span class="d-none d-sm-block">업로드</span> <i class="bx bx-upload d-block d-sm-none"></i> <input
										type="file" id="upload" class="account-file-input" hidden
										accept="image/png, image/jpeg" />
									</label>
									<button type="button"
										class="btn btn-outline-secondary account-image-reset mb-4">
										<i class="bx bx-reset d-block d-sm-none"></i> <span
											class="d-none d-sm-block">초기화</span>
									</button>

									<p class="text-muted mb-0">800KB 이하의 JPG, GIF 또는 PNG 파일만 가능합니다</p>
								</div>
							</div>
						</div>
						<hr class="my-0" />
						<div class="card-body">
							<form id="formAccountSettings" action = "" method="POST"
								onsubmit="return false">
								<div class="row">
									<div class="mb-3 col-md-6">
										<label for="firstName" class="form-label">비밀번호</label> <input
											class="form-control" type="password" id="firstName"
											name="firstName" value="John" autofocus />
									</div>
									<div class="mb-3 col-md-6">
										<label for="lastName" class="form-label">비밀번호 확인</label> <input
											class="form-control" type="password" name="lastName"
											id="lastName" value="Doe" />
									</div>
									<div class="mb-3 col-md-6">
										<label for="email" class="form-label">이메일</label> <input
											class="form-control" type="text" id="email" name="email"
											value="john.doe@example.com"
											placeholder="john.doe@example.com" />
									</div>
									<div class="mb-3 col-md-6">
										<label for="organization" class="form-label">닉네임</label>
										<input type="text" class="form-control" id="organization"
											name="organization" value="ThemeSelection" />
									</div>
									<div class="mb-3 col-md-6">
										<label class="form-label" for="phoneNumber">전화번호</label>
										<div class="input-group input-group-merge">
											<span class="input-group-text">US (+1)</span> <input
												type="text" id="phoneNumber" name="phoneNumber"
												class="form-control" placeholder="202 555 0111" />
										</div>
									</div>
									<div class="mb-3 col-md-6">
										<label for="address" class="form-label">주소</label> <input
											type="text" class="form-control" id="address" name="address"
											placeholder="Address" />
									</div>
									<div class="mb-3 col-md-6">
										<label for="state" class="form-label">State</label> <input
											class="form-control" type="text" id="state" name="state"
											placeholder="California" />
									</div>
									<div class="mb-3 col-md-6">
										<label for="zipCode" class="form-label">Zip Code</label> <input
											type="text" class="form-control" id="zipCode" name="zipCode"
											placeholder="231465" maxlength="6" />
									</div>
									<div class="mb-3 col-md-6">
										<label class="form-label" for="country">Country</label> <select
											id="country" class="select2 form-select">
											<option value="">Select</option>
											<option value="Australia">Australia</option>
											<option value="Bangladesh">Bangladesh</option>
										</select>
									</div>
									<div class="mb-3 col-md-6">
										<label for="language" class="form-label">Language</label> <select
											id="language" class="select2 form-select">
											<option value="">Select Language</option>
											<option value="en">English</option>
										</select>
									</div>
									<div class="mb-3 col-md-6">
										<label for="timeZones" class="form-label">Timezone</label> <select
											id="timeZones" class="select2 form-select">
											<option value="">Select Timezone</option>
										</select>
									</div>
									<div class="mb-3 col-md-6">
										<label for="currency" class="form-label">Currency</label> <select
											id="currency" class="select2 form-select">
											<option value="">Select Currency</option>
											<option value="usd">USD</option>
										</select>
									</div>
								</div>
								<div class="mt-2">
									<button type="submit" class="btn btn-primary me-2">회원정보 수정</button>
									<button type="reset" class="btn btn-outline-secondary">취소</button>
								</div>
							</form>
						</div>
						<!-- /Account -->
					</div>
					<div class="card">
						<h5 class="card-header">회원 탈퇴</h5>
						<div class="card-body">
							<div class="mb-3 col-12 mb-0">
								<div class="alert alert-warning">
									<h6 class="alert-heading fw-bold mb-1">정말 탈퇴하시겠습니까?</h6>
									<p class="mb-0">탈퇴시 정보가 복구되지 않습니다</p>
								</div>
							</div>
							<form id="formAccountDeactivation" action = "" method = "POST" onsubmit="return false">
								<div class="form-check mb-3">
									<input class="form-check-input" type="checkbox"
										name="accountActivation" id="accountActivation" /> <label
										class="form-check-label" for="accountActivation">회원 탈퇴에 동의합니다</label>
								</div>
								<button type="submit" class="btn btn-danger deactivate-account">회원 탈퇴</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Content wrapper -->



	<%@ include file="/WEB-INF/inc/footer.jsp"%>
	<!-- Core JS -->
	<!-- build:js assets/vendor/js/core.js -->
	<script src="../assets/vendor/libs/jquery/jquery.js"></script>
	<script src="../assets/vendor/libs/popper/popper.js"></script>
	<script src="../assets/vendor/js/bootstrap.js"></script>
	<script
		src="../assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

	<script src="../assets/vendor/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->

	<!-- Main JS -->
	<script src="../assets/js/main.js"></script>

	<!-- Page JS -->
	<script src="../assets/js/pages-account-settings-account.js"></script>

	<!-- Place this tag in your head or just before your close body tag. -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>

</html>
