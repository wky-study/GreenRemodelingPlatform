<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>공지 게시판</title>
    
    <script src="${pageContext.request.contextPath }/nse/js/HuskyEZCreator.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js" crossorigin="anonymous"></script>

<style>
.my-profile-img {
	height: 30px;
	width: auto;
	border-radius: 50%;
	overflow: hidden;
}
</style>    

</head>

<body>
<%@include file="/WEB-INF/inc/header.jsp" %>
	<div class="container-fluid">
		<div class="card">

			<div class="card-body">

				<!-- 바디 부분 -->
				<div class="d-block">
					<div class="d-flex justify-content-between">
						<h1>${keyNotice.noticeTitle }</h1>
						<span>${keyNotice.noticeDate }</span>
					</div>
					
					<div class="d-flex justify-content-end">
						<c:if test="${loggedInUserId == keyNotice.memId}">

							<form action="${pageContext.request.contextPath }/noticeEditView"
								method="POST">
								<input type="hidden" value="${keyNotice.noticeNo}" name="no">
								<button class="btn btn-warning" type="submit">수정</button>
							</form>
					
							<form id="delForm" action="${pageContext.request.contextPath }/noticeDeleteDo" method="POST">
								<input type="hidden" value="${keyNotice.noticeNo}" name="no">
								<button id="delBtn" class="btn btn-danger ms-2" type="button">삭제</button>
							</form>
						</c:if>
					
					</div>

					<div
						class="d-flex justify-content-between align-items-center mb-3 mt-3">
						<h4 class="my-h4">
							<img class="my-profile-img"
								src="${pageContext.request.contextPath }/resources/images/profileImg.jpg">
							${keyNotice.memId}
						</h4>
					</div>
					<div class="mb-3 d-flex">
						<c:forEach items="${attachList }" var="attach">
							<div>
								<a href="<c:url value="/filedownload?fileName=${attach.atchFileName }&fileOriName=${attach.atchOriginalName }" />">
								${attach.atchOriginalName } (${attach.atchFancySize })
								</a>
							</div>
						</c:forEach>
					</div>

					<!-- 내용 부분 -->
					<div class="mt-5 mb-5">${keyNotice.noticeContent}</div>

					<!-- 내용 끝  -->
					<div class="mb-5">
						<div class="d-flex justify-content-between mt-3">
							<div>
								<span class="my-span">좋아요 : 0</span> <span class="my-span">조회수
									: ${keyNotice.noticeCount} </span>
							</div>
						</div>
					</div>

					

				</div>



			</div>

		</div>





	</div>
<%@include file="/WEB-INF/inc/footer.jsp" %>
    <script type="text/javascript">
		// 페이지 벗어나기 직전에 스크롤을 최상단에 올리는 코드 넣기
		window.onload = function() {
			setTimeout(function() {
				scrollTo(0, 0);
			}, 100);
		};
		
		let v_name = '${sessionScope.memInfo.memId}';
		
		
		/* 게시글 삭제 경고 창 */
		let v_delForm = document.getElementById("delForm");
		
		if(document.getElementById("delBtn")){
			document.getElementById("delBtn").addEventListener("click", ()=>{
				/*  삭제 확인 메시지를 띄움 */
				if(confirm("정말로 삭제하시겠습니까?")){
					v_delForm.submit();  // submit 버튼을 누른것과 동일
				};
			})
		}	    
	    
	    
	</script>
</body>
</html>
