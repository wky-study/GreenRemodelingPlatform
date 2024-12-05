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

								<h2 class="text-center">회원가입</h2>
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
									<br>
									<!-- 일반/기업 나누기 -->
									<div class="mb-3">
										<select class="form-control" name="inputType" id="memType">
											<option value="select">[회원유형선택]</option>
											<option value="1">일반회원</option>
											<option value="5">시공사</option>
											<option value="6">판매사</option>
											<option value="7">설계사</option>
										</select>
									</div>

									<div class="mb-3">
										<label for="inputtext1" class="form-label">아이디</label> <input
											type="text" class="form-control" id="inputtext1"
											name="inputId" aria-describedby="textHelp"
											value="">
										<button type="button" class="btn btn-secondary"
											id="idCheckBtn" onclick="checkId()">아이디 중복 확인</button>
										<span id="idCheckResult" style="color: red;"></span>
									</div>
									<div class="mb-4">
										<label for="inputPassword1" class="form-label">비밀번호</label> <input
											type="password" class="form-control" name="inputPw"
											id="inputPassword1"
											value=""
											required />
									</div>
									<div class="mb-4">
										<label for="inputPassword1" class="form-label">비밀번호확인</label>
										<input type="password" class="form-control"
											id="inputPassword2"
											value=""
											required />
										<div class="alert alert-success" id="alert-success">비밀번호가
											일치합니다.</div>
										<div class="alert alert-danger" id="alert-danger">비밀번호가
											일치하지 않습니다.</div>
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">이름</label> <input
											type="text" class="form-control" id="inputName"
											name="inputName" aria-describedby="textHelp"
											value="">
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">주민등록번호</label> <input
											type="text" class="form-control" id="inputRn" name="inputRn"
											aria-describedby="textHelp"
											value="">
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">주소</label>
										<input type="button"
											class="btn btn-primary w-100 py-8 fs-4 mb-4"
											onclick="execDaumPostcode()" value="우편번호" ><br>
											<input placeholder="우편번호클릭" type="text" class="form-control" id="fullAddress"
											name="inputAddress" aria-describedby="textHelp" readonly />
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">전화번호</label> <input
											type="text" class="form-control" id="inputPhone"
											name="inputPhone" aria-describedby="textHelp"
											value="">
									</div>
									<div class="mb-3">
										<label for="inputtext1" class="form-label">닉네임</label> <input
											type="text" class="form-control" id="inputNick"
											name="inputNick" aria-describedby="textHelp"
											value="">
										<button type="button" class="btn btn-secondary"
											id="nickCheckBtn" onclick="checkNickname()">닉네임 중복
											확인</button>
										<span id="nickCheckResult" style="color: red;"></span>
									</div>

									<div class="mb-3">
										<label for="inputEmail1" class="form-label">이메일</label> <input
											type="email" class="form-control" id="inputEmail"
											aria-describedby="emailHelp" name="inputEmail"
											value="">
									</div>

									<button class="btn btn-primary w-100 py-8 fs-4 mb-4" id="do"
										type="submit" disabled>회원가입</button>
									<div class="d-flex align-items-center justify-content-center">
										<p class="fs-4 mb-0 fw-bold">이미 회원이십니까?</p>
										<a class="text-primary fw-bold ms-2"
											href="${pageContext.request.contextPath}/loginView">로그인</a>
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
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 각 주소 정보를 변수로 저장
	            var roadAddr = data.roadAddress;  // 도로명 주소
	            var jibunAddr = data.autoJibunAddress ? data.autoJibunAddress : data.jibunAddress;  // 지번 주소
	            var extraRoadAddr = '';  // 추가 도로명 주소
	            var postcode = data.zonecode;  // 우편번호

	            // 추가 도로명 주소 처리
	            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
	                extraRoadAddr += data.bname;
	            }
	            if (data.buildingName !== '' && data.apartment === 'Y') {
	                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }

	            // 하나의 필드에 우편번호, 도로명 주소, 지번 주소, 추가 주소를 합쳐서 넣기
	            var fullAddress = postcode + ' ' + roadAddr + ' ' + jibunAddr + ' ' + extraRoadAddr;

	            // 지번 주소 필드에 모든 주소 정보 입력
	            $('#fullAddress').val(fullAddress);  // 지번 주소 필드에 모든 데이터 넣기
	        }
	    }).open();
	}
	</script>

	<script>
    // 아이디 중복 확인
    function checkId() {
        const inputId = document.getElementById("inputtext1").value; // 사용자가 입력한 ID값

        // 아이디가 입력되지 않은 경우 처리
        if (!inputId) {
            document.getElementById("idCheckResult").textContent = "아이디를 입력해 주세요.";
            document.getElementById("idCheckResult").style.color = "red";
            return;
        }

        // 서버에 중복 체크를 요청하는 Ajax 요청
        fetch('${pageContext.request.contextPath}/checkIdDuplication', {  // 서버의 /checkIdDuplication URL로 요청
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ memId: inputId })  // 서버로 입력한 ID값 전송
        })
        .then(response => response.json())  // 서버 응답을 JSON 형태로 받기
        .then(data => {
            if (data.isDuplicate) {  // 서버에서 중복 여부 확인 (isDuplicate가 true이면 중복)
                document.getElementById("idCheckResult").textContent = "이미 사용 중인 아이디입니다.";
                document.getElementById("idCheckResult").style.color = "red";
            } else {
                document.getElementById("idCheckResult").textContent = "사용 가능한 아이디입니다.";
                document.getElementById("idCheckResult").style.color = "green";
            }
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById("idCheckResult").textContent = "서버와의 통신에 오류가 발생했습니다.";
            document.getElementById("idCheckResult").style.color = "red";
        });
    }
	</script>

	<script>
		// 닉네임 중복 확인
			    function checkNickname() {
			        const inputNick = document.getElementById("inputNick").value; // 사용자가 입력한 닉네임값

			        // 닉네임이 입력되지 않은 경우 처리
			        if (!inputNick) {
			            document.getElementById("nickCheckResult").textContent = "닉네임을 입력해 주세요.";
			            document.getElementById("nickCheckResult").style.color = "red";
			            return;
			        }

			        // 서버에 중복 체크를 요청하는 Ajax 요청
			        fetch('${pageContext.request.contextPath}/checkNickDuplication', {  // 서버의 /checkNickDuplication URL로 요청
			            method: 'POST',
			            headers: {
			                'Content-Type': 'application/json',
			            },
			            body: JSON.stringify({ memNick: inputNick })  // 서버로 입력한 닉네임값 전송
			        })
			        .then(response => response.json())  // 서버 응답을 JSON 형태로 받기
			        .then(data => {
			            if (data.isDuplicate) {  // 서버에서 중복 여부 확인 (isDuplicate가 true이면 중복)
			                document.getElementById("nickCheckResult").textContent = "이미 사용 중인 닉네임입니다.";
			                document.getElementById("nickCheckResult").style.color = "red";
			            } else {
			                document.getElementById("nickCheckResult").textContent = "사용 가능한 닉네임입니다.";
			                document.getElementById("nickCheckResult").style.color = "green";
			            }
			        })
			        .catch(error => {
			            console.error('Error:', error);
			            document.getElementById("nickCheckResult").textContent = "서버와의 통신에 오류가 발생했습니다.";
			            document.getElementById("nickCheckResult").style.color = "red";
			        });
			    }
		
	</script>

	<script>
	// 비밀번호 확인
	$(function(){
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("#inputPassword1, #inputPassword2").keyup(function(){
			var inputPassword1 = $("#inputPassword1").val();
			var inputPassword2 = $("#inputPassword2").val();
			if(inputPassword1 != "" || inputPassword2 != ""){
				if(inputPassword1 == inputPassword2){
					$("#alert-success").show();	// 비밀번호 일치 시 성공 메시지 표시
					$("#alert-danger").hide();	// 실패 메시지 숨기기
				}else{
					$("#alert-success").hide();	// 비밀번호 불일치 시 성공 메시지 숨기기
					$("#alert-danger").show();	// 실패 메시지 표시
				}
			}
		});
	});
	</script>
	
	<script>
	// 회원가입 불가능하게 만들기
	$(function(){
		// 필수 입력 필드를 선택
		$("#inputtext1, #inputName, #inputRn, #fullAddress, #inputPhone, #inputNick, #inputEmail").keyup(function(){
			// 모든 필수 입력 필드 값 가져오기
			var inputId = $("#inputtext1").val();
			var inputName = $("#inputName").val();
			var inputRn = $("#inputRn").val();
			var fullAddress = $("#fullAddress").val();
			var inputPhone = $("#inputPhone").val();
			var inputNick = $("#inputNick").val();
			var inputEmail = $("#inputEmail").val();
			var password1 = $("#inputPassword1").val();
			var password2 = $("#inputPassword2").val();
			var checkboxChecked = $("#flexCheckDefault").prop("checked");
			
			// 모든 필드가 입력되었고, 비밀번호가 일치하고, 약관 체크박스가 체크되었는지 확인
			if(inputId !== "" && inputName !== "" && inputRn !== "" && fullAddress !== "" && inputPhone !== "" && inputNick !== "" && inputEmail !== "" && password1 === password2 && checkboxChecked){
				$("#do").removeAttr("disabled");	// 버튼 활성화
			}else{
				$("#do").attr("disabled", "disabled");	// 버튼 비활성화
			}
		});
	});
	</script>


</body>

</html>
