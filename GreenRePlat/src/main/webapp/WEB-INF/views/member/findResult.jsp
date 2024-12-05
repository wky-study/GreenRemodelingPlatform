<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>비밀번호찾기결과</title>
<link rel="shortcut icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/images/logos/seodashlogo.png" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/styles.min.css" />
</head>

<body>

	<div class="result-box">
		<c:choose>
			<c:when test="${empty findPw}">
				<p class="inquiry">조회결과가 없습니다.</p>
			</c:when>
			<c:otherwise>
				<p>${findPw.pw}</p>
			</c:otherwise>
		</c:choose>
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
