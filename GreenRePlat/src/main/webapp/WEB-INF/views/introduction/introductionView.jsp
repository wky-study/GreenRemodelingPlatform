<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>그린리모델링소개</title>

<style>
.container-fluid {
	overflow: hidden; /* 컨테이너 바깥으로 나가는 요소 숨김 */
}

.container-fluid div {
	width: 100%; /* 컨테이너에 맞춤 */
	overflow: hidden; /* 초과된 부분 숨김 */
	position: relative;
}

.container-fluid img {
	width: 100%; /* 가로 너비를 컨테이너에 맞춤 */
	height: auto; /* 비율을 유지하면서 높이를 조정 */
	object-fit: cover; /* 컨테이너에 꽉 차도록 자름 */
}

.image-row {
	display: flex; /* 플렉스 박스를 사용하여 나란히 배치 */
	justify-content: space-between; /* 이미지 사이 간격 조정 */
	gap: 10px; /* 이미지 사이 간격 추가 */
}

.container-foot {
	padding: 2%;
	display: flex; /* 플렉스 박스를 사용하여 나란히 배치 */
}
</style>


</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<!--  Header End -->
	<div class="container-fluid">


		<div>
			<img
				src="${pageContext.request.contextPath}/assets/images/homeImg/home10.png">
		</div>

		<br>

		<div>
			<img
				src="${pageContext.request.contextPath}/assets/images/homeImg/home03.png">
		</div>

		<br>

		<div class="image-row">
			<div>
				<img
					src="${pageContext.request.contextPath}/assets/images/homeImg/home02.jpg">
			</div>
			<div>
				<img
					src="${pageContext.request.contextPath}/assets/images/homeImg/home07.png">
			</div>
		</div>

		<br>

		<div>
			<img
				src="${pageContext.request.contextPath}/assets/images/homeImg/home09.jpg">
		</div>

		<div class="container-foot">
			<div>
				<h4>(주)에코빌더스</h4>
				<p>
					사업자등록번호: 786-99-00923<br> 대전시 서구 계룡로 491번길 86 (둔산동 1221번지) ∣
					전화번호: 042-471-9222 ∣ <br>팩스: 042-471-9223 ∣ 이메일:
					ecobuilders@gmail.com
				</p>

				<p>
					Hosting by CODExTyle<br> © Copyright by Mirae Convergence
					Euducation Academy. All rights reserved.
				</p>
			</div>

			<div
				onclick='window.location.href = "${pageContext.request.contextPath}/"'
				style="scale: 70%; cursor: pointer; padding: 3%; left: 8%;">
				<img
					src="${pageContext.request.contextPath}/assets/images/logos/mainlogo.png">
			</div>
		</div>
	</div>




	<%@ include file="/WEB-INF/inc/footer.jsp"%>

</body>

</html>
