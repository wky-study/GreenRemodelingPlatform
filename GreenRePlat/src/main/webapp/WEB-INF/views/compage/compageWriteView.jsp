<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>기업포트폴리오 작성</title>


<!-- 네이버 스마트 에디터 js파일 불러오기 -->
<script
	src="${pageContext.request.contextPath }/nse/js/HuskyEZCreator.js"></script>

<!-- jquery (AJAX 통신) -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>


</head>


<style>
.my-card-box {
	flex-wrap: wrap;
}

.my-card {
	width: calc(100%/ 5 + 2px);
	cursor: pointer;
}

.img-fluid {
	width: 100%;
}

.img-border {
	height: 100%;
	min-height: 400px;
}
</style>


<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">

			<div class="container-xxl py-5">
				<div class="container">

					<div class="card-body">

						<form id="compageWriteForm"
							action="${pageContext.request.contextPath }/compageWriteDo"
							method="POST" enctype="multipart/form-data">

							<div class="mb-3">
								<label>포트폴리오 링크주소</label><input class="form-control" id="inputId"
									type="text" name="cpPath" placeholder="포트폴리오링크를 넣어주세요." />
							</div>

							<div class="d-flex justify-content-end">
								<a class="btn btn-secondary me-2"
									href="${pageContext.request.contextPath }/compageView">취소</a>

								<!-- form 태그의 submit 역할을 함 -> type=submit 넣어주기 -->
								<button id="writeBtn" class="btn btn-primary" type="submit">등록</button>
							</div>
							
						</form>


					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script type="text/javascript">
	
	</script>




</body>

</html>
