<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원가입 약관</title>
<!-- Bootstrap 5 CSS 연결 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center mb-4">회원가입 약관</h2>

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

		<!-- 회원가입 -->
		<div class="mt-4">
			<button
				onclick='window.location.href = "${pageContext.request.contextPath}/registView"'>돌아가기</button>
		</div>
	</div>

	<!-- Bootstrap 5 JS 및 Popper.js 연결 -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>

</body>
</html>
