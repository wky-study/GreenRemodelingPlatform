<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 약관</title>

</head>
<body>



	<div class="d-flex align-items-center justify-content-center w-100">
		<h2 class="col-md-8 col-lg-6 col-xxl-3">회원가입 약관</h2>

		<!-- 약관 내용 -->
		<div class="card">
			<div class="card-header">
				<h5>회원가입 약관</h5>
			</div>
			<div class="card-body">
				<h6>1. 개인정보 보호</h6>
				<p>우리는 사용자의 개인정보를 안전하게 보호하며, 제3자에게 제공하지 않습니다.</p>
				<h6>2. 서비스 이용</h6>
				<p>본 서비스를 이용하기 전에 약관을 반드시 읽고 동의해야 합니다.</p>
				<h6>3. 책임의 한계</h6>
				<p>서비스 사용 시 발생하는 문제에 대해 당사는 책임을 지지 않습니다.</p>
				<!-- 추가적인 약관 항목을 여기에 추가할 수 있습니다. -->
			</div>
		</div>
	</div>

	<!-- 이전페이지 저장된 정보들 -->
	<form action="${pageContext.request.contextPath}/registView"
		method="POST">
		<input type="hidden" name="inputId" value="${sessionScope.inputId}">
		<input type="hidden" name="inputPw" value="${sessionScope.inputPw}">
		<input type="hidden" id="inputPassword2"
			value="${sessionScope.inputPassword2}"> <input type="hidden"
			name="inputName" value="${sessionScope.inputName}"> <input
			type="hidden" name="inputName" value="${sessionScope.inputName}">
		<input type="hidden" name="inputRn" value="${sessionScope.inputRn}">
		<input type="hidden" id="postcode" value="${sessionScope.postcode}">
		<input type="hidden" id="roadAddress"
			value="${sessionScope.roadAddress}"> <input type="hidden"
			id="jibunAddress" value="${sessionScope.jibunAddress}"> <input
			type="hidden" id="detailAddress"
			value="${sessionScope.detailAddress}"> <input type="hidden"
			id="extraAddress" value="${sessionScope.extraAddress}"> <input
			type="hidden" name="inputPhone" value="${sessionScope.inputPhone}">
		<input type="hidden" name="inputNick"
			value="${sessionScope.inputNick}"> <input type="hidden"
			name="inputNick" value="${sessionScope.inputNick}"> <input
			type="hidden" name="inputEmail" value="${sessionScope.inputEmail}">
		<input type="hidden" name="memType" value="${sessionScope.memType}">
		<button class="btn btn-primary" type="submit">돌아가기</button>
	</form>
</body>
</html>
