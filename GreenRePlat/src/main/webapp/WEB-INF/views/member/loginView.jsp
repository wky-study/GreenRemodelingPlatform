<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인</title>
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
							<c:if test="${not empty sessionScope.loginError}">
							    <div class="alert alert-danger">
							        ${sessionScope.loginError}
							    </div>
							</c:if>
								<a href="#"
									class="text-nowrap logo-img text-center d-block py-3 w-100">
									<img src="../assets/images/logos/logo-light.svg" alt="">
								</a>
								<p class="text-center">로그인 페이지</p>
								<form action="${pageContext.request.contextPath}/loginDo"
									method="POST">
									<div class="mb-3">
										<label for="exampleInputtext1" class="form-label">아이디</label> <input
											type="text" class="form-control" id="exampleInputtext1" name = "memId" value = "${cookie.rememberId.value}"
											aria-describedby="textHelp">
									</div>
									<div class="mb-4">
										<label for="exampleInputPassword1" class="form-label">비밀번호</label>
										<input type="password" class="form-control"
											id="exampleInputPassword1" name = "memPw">
									</div>
									<div
										class="d-flex align-items-center justify-content-between mb-4">
										<div class="form-check">
											<input class="form-check-input primary" type="checkbox"
												 id="flexCheckChecked" name = "rememberId" checked> <label
												class="form-check-label text-dark" for="flexCheckChecked">
												아이디 기억하기 </label>
										</div>
										<div class="form-check">
											<input class="form-check-input primary" type="checkbox"
												 id="flexCheckChecked" name = "rememberLogin"> <label
												class="form-check-label text-dark" for="flexCheckChecked">
												자동 로그인 </label>
										</div>

										<a class="text-primary fw-bold" href="./index.html">비밀번호
											찾기</a>
									</div>
									<button class="btn btn-primary w-100 py-8 fs-4 mb-4" id="do"
										type="submit" disabled>로그인</button>
									<div class="d-flex align-items-center justify-content-center">
										<p class="fs-4 mb-0 fw-bold">아이디가 없나요?</p>
										<a class="text-primary fw-bold ms-2"
											href="${pageContext.request.contextPath}/registView">회원가입</a>
									</div>
									
									
								</form>
								
								<div class="d-flex align-items-center justify-content-center">
								    <button onclick="openNaverLogin()" class="btn">
								        <img style="width: 45px;" src="${pageContext.request.contextPath}/resources/images/btnG_아이콘사각.png">
								    </button>
								</div>
								
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
		
	<script>
	function openNaverLogin() {
	    const naverLoginUrl = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=pq95RcUR8Axo8_g97G8i&state=STATE_STRING&redirect_uri=http://192.168.0.136/naverlogin";
	    const loginWindow = window.open(naverLoginUrl, "NaverLogin", "width=500,height=700");

	    // 로그인 창이 닫혔을 때 부모 창에서 리다이렉트
	    const timer = setInterval(() => {
	        if (loginWindow.closed) {
	            clearInterval(timer);
	            window.location.href = "/	";
	        }
	    }, 500); // 0.5초마다 확인
	}
	</script>	
	
		<script>
	// 비밀번호 확인
	$(function(){
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("#exampleInputtext1, #exampleInputPassword1").keyup(function(){
			var exampleInputtext1 = $("#exampleInputtext1").val();
			var exampleInputPassword1 = $("#exampleInputPassword1").val();
			if(exampleInputtext1 != "" || exampleInputPassword1 != ""){
				if(exampleInputtext1, exampleInputPassword1){
					$("#alert-success").show();	// 비밀번호 일치 시 성공 메시지 표시
					$("#alert-danger").hide();	// 실패 메시지 숨기기
					$("#do").removeAttr("disabled");	// 버튼 활성화
				}else{
					$("#alert-success").hide();	// 비밀번호 불일치 시 성공 메시지 숨기기
					$("#alert-danger").show();	// 실패 메시지 표시
					$("#do").attr("disabled", "disabled");	// 버튼 비활성화
				}
			}
		});
	});
	</script>	
		
</body>


</html>
