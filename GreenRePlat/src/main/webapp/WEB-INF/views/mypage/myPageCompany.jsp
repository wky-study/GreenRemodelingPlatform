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
				<span class="text-muted fw-light">Mypage /</span> 회원정보
			</h4>
			<div class="row">
				<div class="col-md-12">
					<ul class="nav nav-pills flex-column flex-md-row mb-3">
						<li class="nav-item"><a class="nav-link active"
							href="${pageContext.request.contextPath}/settingView"><i class="bx bx-user me-1"></i>
								회원정보</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/cartView"><i
								class="bx bx-bell me-1"></i>장바구니</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/orderSummary"><i
								class="bx bx-link-alt me-1"></i> 주문 내역</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/chatListView"><i
								class="bx bx-link-alt me-1"></i>채팅 목록</a></li>
					</ul>
					<div class="card mb-4">
						<hr class="my-0" />
						<div class="card-body">
							<form id="formAccountSettings"
								action="${pageContext.request.contextPath}/updateAccount"
								method="POST">
								<div class="row">
									<input name="memId" value="${sessionScope.memInfo.memId}" type="hidden">
									<input name="memName" value="${sessionScope.memInfo.memName}" type="hidden">
									<input name="memRn" value="${sessionScope.memInfo.memRn}" type="hidden">
									<input name="memType" value="${sessionScope.memInfo.memType}" type="hidden">
									<input name="comCeo" value="${sessionScope.memInfo.comCeo}" type="hidden">
									<input name="comBrc" value="${sessionScope.memInfo.comBrc}" type="hidden">
									<input name="comMaNm" value="${sessionScope.memInfo.comMaNm}" type="hidden">
									<input name="comMaPn" value="${sessionScope.memInfo.comMaPn}" type="hidden">
									<div class="mb-3 col-md-6">
										<label for="firstName" class="form-label">아이디</label> <input
											class="form-control" value="${sessionScope.memInfo.memId}"  readonly />
									</div>
									<div class="mb-3 col-md-6">
										<label for="firstName" class="form-label">이름</label> <input
											class="form-control" value="${sessionScope.memInfo.memName}"  readonly />
									</div>
									<div class="mb-3 col-md-6">
										<label for="firstName" class="form-label">비밀번호</label> <input
											class="form-control" type="password" id="password"
											name="memPw"  autofocus oninput="validatePasswords()" />
									</div>
									<div class="mb-3 col-md-6">
										<label for="lastName" class="form-label">비밀번호 확인</label> <input
											class="form-control" type="password" name="lastName"
											id="passwordConfirm"  oninput="validatePasswords()"/>
									</div>
									<div class="mb-3 col-md-6">
										<label for="email" class="form-label">이메일</label> <input
											class="form-control" type="text" id="email" name="memEmail"
											value="${sessionScope.memInfo.memEmail}"
											 />
									</div>
									<div class="mb-3 col-md-6">
										<label for="organization" class="form-label">닉네임</label> <input
											type="text" class="form-control" id="organization"
											name="memNick" value="${sessionScope.memInfo.memNick}" />
									</div>
									<div class="mb-3 col-md-6">
										<label class="form-label" for="phoneNumber">전화번호</label>
										<div class="input-group input-group-merge">
											 <input type="text" id="phoneNumber" name="memPhone"
												class="form-control"  value="${sessionScope.memInfo.memPhone}"/>
										</div>
									</div>
									<div class="mb-3 col-md-6">
										<label for="address" class="form-label">주소</label> 
										<input type="text" class="form-control" id="address" name="memAddress" value="${sessionScope.memInfo.memAddress}"/>
									</div>
								</div>
								<div class="mt-2 d-flex justify-content-end">
									<button type="submit" class="btn btn-primary me-2" id="submitButton">회원정보 수정</button>
									<button type="reset" class="btn me-2 btn-outline-secondary">초기화</button>
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
							<form id="formAccountDeactivation" action="" method="POST"
								onsubmit="return false">
								<div class="form-check mb-3">
									<input class="form-check-input" type="checkbox" name="accountActivation" id="accountActivation" onchange="validatePasswords()"/> 
									<label class="form-check-label" for="accountActivation">회원 탈퇴에 동의합니다</label> 	
								</div>
								<button type="submit" class="btn btn-danger deactivate-account" id="deactivateButton">회원 탈퇴</button>
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
	
	<script>
    // 비밀번호와 확인 비밀번호를 비교하고 버튼 활성화/비활성화
    function validatePasswords() {
        const password = document.getElementById('password').value;
        const passwordConfirm = document.getElementById('passwordConfirm').value;
        const submitButton = document.getElementById('submitButton');
        const deactivateButton = document.getElementById('deactivateButton');
        const agreementChecked = document.getElementById('accountActivation').checked;

        // 조건: 비밀번호와 확인 비밀번호가 같아야 수정 버튼 활성화
        if (password === passwordConfirm && password.length > 0) {
            submitButton.disabled = false;
        } else {
            submitButton.disabled = true;
        }

        // 조건: 비밀번호와 확인 비밀번호가 같고 탈퇴 동의가 체크되었을 때 탈퇴 버튼 활성화
        if (password === passwordConfirm && password.length > 0 && agreementChecked) {
            deactivateButton.disabled = false;
        } else {
            deactivateButton.disabled = true;
        }
    }
</script>
	
</body>

</html>
