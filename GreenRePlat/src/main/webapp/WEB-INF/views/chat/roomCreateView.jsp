<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>채팅방 생성</title>
	
	<!-- header 부분 -->
	<%@ include file="/WEB-INF/inc/header.jsp"%>
	
</head>
<body id="page-top">


	<!-- Contact Section-->
	<div class="container-fluid">
		<!-- 부트스트랩으로 padding-top 을 좀 주고자 한다. -->
		<div class="card">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">채팅방 생성</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Contact Section Form-->
			<div class="row justify-content-center">
		 		<div class="col-lg-8 col-xl-7">
		 		
					<form id="boardWriteForm" action="${pageContext.request.contextPath }/roomCreateDo" method="POST">
						<div class="mb-3">
							<input class="form-control" type="text" name="roomName" placeholder="방 제목"/>
						</div>
						
						<div class="d-flex justify-content-end">
							<a class="btn btn-secondary me-2" href="${pageContext.request.contextPath }/chatListView">취소</a>
							<!-- form 태그의 submit 역할을 함 -> type=submit 넣어주기 -->
							<button id="writeBtn" class="btn btn-primary" type="submit">생성</button>
						</div>
					</form>
					
				</div>
			</div>
		</div>
	</div>
	<!-- footer 부분 -->
	<%@ include file="/WEB-INF/inc/footer.jsp"%>

</body>
</html>






