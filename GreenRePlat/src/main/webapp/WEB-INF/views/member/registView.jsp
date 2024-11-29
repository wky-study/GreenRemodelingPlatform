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
								<form action="${pageContext.request.contextPath}/registDo"
									method="POST">

									<!-- 약관체크 -->
									<div class="form-check"
										style="display: flex; justify-content: center; align-items: center;">
										<input class="form-check-input" type="checkbox" value=""
											id="flexCheckDefault"> <label
											class="form-check-label" for="flexCheckDefault">
											(필수)약관에 동의하십니까? </label> <a
											href="${pageContext.request.contextPath}/tacView">보기</a>
									</div>

									<!-- 일반/기업 나누기 -->
									<div class="mb-3">
										<select class="form-control" name="memType" id="memType">
											<option value="select">[회원유형선택]</option>
											<option value="1"
												${sessionScope.userType == '1' ? 'selected' : ''}>일반회원</option>
											<option value="5"
												${sessionScope.userType == '5' ? 'selected' : ''}>시공사</option>
											<option value="6"
												${sessionScope.userType == '6' ? 'selected' : ''}>판매사</option>
											<option value="7"
												${sessionScope.userType == '7' ? 'selected' : ''}>설계사</option>
										</select>
									</div>

									<div class="mb-3">
										<label for="inputtext1" class="form-label">아이디</label> <input
											type="text" class="form-control" id="inputtext1"
											name="inputId" aria-describedby="textHelp"
											value="${sessionScope.inputId != null ? sessionScope.inputId : ''}">
										<button type="button" class="btn btn-secondary"
											id="idCheckBtn" onclick="checkId()">아이디 중복 확인</button>
										<span id="idCheckResult" style="color: red;"></span>
									</div>
									<div class="mb-4">
										<label for="inputPassword1" class="form-label">비밀번호</label> <input
											type="password" class="form-control" name="inputPw"
											id="inputPassword1"
											value="${sessionScope.inputPw != null ? sessionScope.inputPw : ''}">
									</div>
									<div class="mb-4">
										<label for="inputPassword1" class="form-label">비밀번호확인</label>
										<input type="password" class="form-control"
											id="inputPassword2"
											value="${sessionScope.inputPassword2 != null ? sessionScope.inputPassword2 : ''}">
										<span id="passwordMatch" style="color: red;"></span>
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">이름</label> <input
											type="text" class="form-control" id="inputName"
											name="inputName" aria-describedby="textHelp"
											value="${sessionScope.inputName != null ? sessionScope.inputName : ''}">
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">주민등록번호</label> <input
											type="text" class="form-control" id="inputRn" name="inputRn"
											aria-describedby="textHelp"
											value="${sessionScope.inputRn != null ? sessionScope.inputRn : ''}">
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">주소</label> <input
											type="text" class="form-control" id="postcode"
											placeholder="우편번호"
											value="${sessionScope.postcode != null ? sessionScope.postcode : ''}">
										<input type="button"
											class="btn btn-primary w-100 py-8 fs-4 mb-4"
											onclick="execDaumPostcode()" value="우편번호 찾기"><br>
										<input type="text" id="roadAddress" placeholder="도로명주소"
											value="${sessionScope.roadAddress != null ? sessionScope.roadAddress : ''}">
										<input type="text" id="jibunAddress" placeholder="지번주소"
											value="${sessionScope.jibunAddress != null ? sessionScope.jibunAddress : ''}">
										<span id="guide" style="color: #999; display: none"></span> <input
											type="text" id="detailAddress" placeholder="상세주소"
											oninput="inputFullAddress()"
											value="${sessionScope.detailAddress != null ? sessionScope.detailAddress : ''}">
										<input type="text" id="extraAddress" placeholder="참고항목"
											value="${sessionScope.extraAddress != null ? sessionScope.extraAddress : ''}"><input
											type="text" class="form-control" id="fullAddress"
											name="inputAddress" aria-describedby="textHelp" hidden>
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">전화번호</label> <input
											type="text" class="form-control" id="inputPhone"
											name="inputPhone" aria-describedby="textHelp"
											value="${sessionScope.inputPhone != null ? sessionScope.inputPhone : ''}">
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">닉네임</label> <input
											type="text" class="form-control" id="inputNick"
											name="inputNick" aria-describedby="textHelp"
											value="${sessionScope.inputNick != null ? sessionScope.inputNick : ''}">
										<button type="button" class="btn btn-secondary"
											id="nickCheckBtn" onclick="checkNickname()">닉네임 중복
											확인</button>
										<span id="nickCheckResult" style="color: red;"></span>
									</div>

									<div class="mb-3">
										<label for="inputEmail1" class="form-label">이메일</label> <input
											type="email" class="form-control" id="inputEmail"
											aria-describedby="emailHelp" name="inputEmail"
											value="${sessionScope.inputEmail != null ? sessionScope.inputEmail : ''}">

									</div>

									<button class="btn btn-primary w-100 py-8 fs-4 mb-4" id="do"
										type="submit" disabled>회원가입</button>
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



	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							var roadAddr = data.roadAddress; // 도로명 주소 변수
							var extraRoadAddr = ''; // 참고 항목 변수

							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraRoadAddr += data.bname;
							}

							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraRoadAddr += (extraRoadAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}

							if (extraRoadAddr !== '') {
								extraRoadAddr = ' (' + extraRoadAddr + ')';
							}

							document.getElementById('postcode').value = data.zonecode;
							document.getElementById("roadAddress").value = roadAddr;
							document.getElementById("jibunAddress").value = data.jibunAddress;

							if (roadAddr !== '') {
								document.getElementById("extraAddress").value = extraRoadAddr;
							} else {
								document.getElementById("extraAddress").value = '';
							}

							var guideTextBox = document.getElementById("guide");

							if (data.autoRoadAddress) {
								var expRoadAddr = data.autoRoadAddress
										+ extraRoadAddr;
								guideTextBox.innerHTML = '(예상 도로명 주소 : '
										+ expRoadAddr + ')';
								guideTextBox.style.display = 'block';

							} else if (data.autoJibunAddress) {
								var expJibunAddr = data.autoJibunAddress;
								guideTextBox.innerHTML = '(예상 지번 주소 : '
										+ expJibunAddr + ')';
								guideTextBox.style.display = 'block';
							} else {
								guideTextBox.innerHTML = '';
								guideTextBox.style.display = 'none';
							}
							inputFullAddress();
						}
					}).open();

		}
		function inputFullAddress() {
			var fullAddress = document.getElementById("fullAddress").value;
			fullAddress = document.getElementById("roadAddress").value + " "
					+ document.getElementById("detailAddress").value;
		}
	</script>


	<!-- 체크박스 상태에 따라 회원가입 버튼 활성화/비활성화 -->
	<script>
		const checkbox = document.getElementById("flexCheckDefault");
		const submitBtn = document.getElementById("do");

		checkbox.addEventListener("change", function() {
			if (checkbox.checked) {
				submitBtn.disabled = false; // 체크되면 버튼 활성화
			} else {
				submitBtn.disabled = true; // 체크 해제되면 버튼 비활성화
			}
		});
		
		// 아이디 중복 확인
		function checkId() {
			const inputId = document.getElementById("inputId").value;
			if (inputId) {
				// 실제로 서버에 아이디 중복을 체크하는 로직을 넣어야 합니다.
				// 임시로 중복되지 않는다고 처리
				document.getElementById("idCheckResult").textContent = "사용 가능한 아이디입니다.";
				document.getElementById("idCheckResult").style.color = "green";
			} else {
				document.getElementById("idCheckResult").textContent = "아이디를 입력해 주세요.";
				document.getElementById("idCheckResult").style.color = "red";
			}
		}

		// 닉네임 중복 확인
		function checkNickname() {
			const inputNick = document.getElementById("inputNick").value;
			if (inputNick) {
				// 서버에서 닉네임 중복을 체크하는 로직을 넣어야 합니다.
				// 임시로 중복되지 않는다고 처리
				document.getElementById("nickCheckResult").textContent = "사용 가능한 닉네임입니다.";
				document.getElementById("nickCheckResult").style.color = "green";
			} else {
				document.getElementById("nickCheckResult").textContent = "닉네임을 입력해 주세요.";
				document.getElementById("nickCheckResult").style.color = "red";
		
	</script>

</body>

</html>
