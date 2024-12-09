<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>리뷰 게시판</title>


<!-- 네이버 스마트 에디터 js파일 불러오기 -->
<script
	src="${pageContext.request.contextPath }/nse/js/HuskyEZCreator.js"></script>

<!-- jquery (AJAX 통신) -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>


</head>


<style>
.my-profile-img {
	height: 30px;
	width: auto;
	border-radius: 50%;
	overflow: hidden;
}
</style>


<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">

			<div class="card-body">

				<!-- 바디 부분 -->
				<div class="d-block">
					<div class="d-flex justify-content-between">
						<h3>${keyReview.reviewTitle }</h3>
						<span>${keyReview.reviewDate }</span>
					</div>
					<div class="d-flex justify-content-end">
						<c:if
							test="${ sessionScope.memInfo.memId == keyReview.memId && sessionScope.memInfo.memId != null}">
							<form action="${pageContext.request.contextPath }/reviewEditView"
								method="POST">
								<input type="hidden" value="${keyReview.reviewNo}" name="no">
								<button class="btn btn-warning" type="submit">수정</button>
							</form>
						</c:if>

						<c:if
							test="${ sessionScope.memInfo.memId == keyReview.memId && sessionScope.memInfo.memId != null}">
							<form id="delForm"
								action="${pageContext.request.contextPath }/reviewDeleteDo"
								method="POST">
								<input type="hidden" value="${keyReview.reviewNo}" name="no">
								<button id="delBtn" class="btn btn-danger ms-2" type="button">삭제</button>
							</form>

						</c:if>
					</div>

					<div
						class="d-flex justify-content-between align-items-center mb-3 mt-3">
						<h4 class="my-h4">
							<img class="my-profile-img"
								src="${pageContext.request.contextPath }/resources/images/profileImg.jpg">
							${keyReview.memName}
						</h4>
					</div>

					<!-- 내용 부분 -->
					<div class="mt-5 mb-5">${keyReview.reviewContent}</div>

					<!-- 내용 끝  -->
					<div class="mb-5">
						<div class="d-flex justify-content-between mt-3">
							<div>
								<span class="my-span">조회수
									: ${keyReview.reviewCount} </span>
							</div>
						</div>
					</div>

					<!-- 댓글 창 -->
					<div>
						<div>
							<h2>댓글 : ${keyReplyCount}</h2>
						</div>

						<!-- 댓글 작성하는곳 -->
						<div class="mt-5 mb-5">
							<form id="replyForm" class="row"
								action="${pageContext.request.contextPath }/replyWriteDo"
								method="POST">
								<input type="hidden" name="memId" value="${sessionScope.memInfo.memId }">
								<input type="hidden" name="reviewNo" value="${keyReview.reviewNo }">
								<div class="col-10">
									<input id="replyInput" class="form-control" type="text" name="replyContent">
								</div>
								<button id="replyBtn" class="btn btn-primary col-2" style="padding: 0px" type="button" >등록</button>
								<input type="hidden" name="tableName" id="tableName" >
							</form>
						</div>


						<div id="replyBox" class="reply-box mb-5">
							<!-- 밑에 참고 -->
							<c:forEach items="${keyReplyList }" var="replyDTO">
								<div class="row pt-2 pb-2">
									<input type="hidden" value="${replyDTO.replyNo }">
									<div class="col-1">
										<img class="my-profile-img"
											src="${pageContext.request.contextPath }/resources/images/profileImg.jpg">
									</div>
									<div class="col-9">
										<div>
											<h4>${replyDTO.memNick }</h4>
										</div>
										<div>
											<span>${replyDTO.replyContent }</span>
										</div>

										<div class="d-flex ">
											<div>
												<span class="my-span">${replyDTO.replyDate }</span>
											</div>
										</div>
									</div>

									<div class="col-1"></div>

									<c:if
										test="${sessionScope.memInfo.memId == replyDTO.memId && sessionScope.memInfo.memId != null}">
										<div class="col-1">
											<span class="my-span btn btn-danger " onclick="f_delete()" style="cursor: pointer">삭제</span>
										</div>
									</c:if>
								</div>


							</c:forEach>
						</div>

					</div>

				</div>



			</div>

		</div>





	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>


	<script type="text/javascript">

	let v_name = '${sessionScope.memInfo.memId}';
		
		/* 댓글 입력 창 클릭 이벤트 */
		document.getElementById("replyInput").addEventListener("click", ()=>{
			
			if(!v_name){
				alert("로그인 후 이용하세요.")
				location.href = "${pageContext.request.contextPath}/loginView";
			} 
			
			
		})
		
		let v_replyBox = document.getElementById("replyBox");
		
		/* 등록버튼 클릭 이벤트 */
		document.getElementById("replyBtn").addEventListener("click", ()=>{
			
        // 현재 URL에서 JSP 파일 이름 추출
        const path = window.location.pathname;
        const fileName = path.substring(path.lastIndexOf('/') + 1);
        
        console.log(fileName);
        // tableName에 파일 이름 설정
        document.getElementById("tableName").value = fileName;
			
		let v_replyInput =  document.getElementById("replyInput").value;
		
		if(v_replyInput == "" || v_replyInput == null){
			alert("내용을 입력해주세요");
		} 

		/* form 태그 가져오기 */
		let v_formData = $('#replyForm').serialize(); // replyContent = asdsa
		let v_url = $('#replyForm').attr('action');
		
		// memId, boardNo, replyContent 데이터
		console.log(v_formData);
		
		
		$.ajax({
			type : "POST",
			url : v_url,
			data : v_formData,
			success : function(resp){
				console.log(resp);	  //JSON 객체 (jQuery에서 자동으로 parse 해줌)
				
				/* 댓글창 비워주기 */
				document.getElementById("replyInput").value = "";	
				
				// 댓글 한줄에 대한 html코드 생성
				let v_reply = '<div class="row pt-2 pb-2">';
				v_reply += '<input type="hidden" value="' + resp['replyNo'] + '">';
				v_reply += '<div class="col-1"><img class="my-profile-img" src="${pageContext.request.contextPath }/resources/images/profileImg.jpg"> </div>';
				v_reply += ' <div class="col-9">';
				v_reply += " <div><h4> " + resp['memNick'] + "</h4></div>" ;
				v_reply += "<div><span>" + resp['replyContent'] + "</span></div>";
				v_reply += '<div class="d-flex ">';
				v_reply += ' <div>'; 
				v_reply += '<span class="my-span">' + resp["replyDate"] + '</span>'; 
				v_reply += '</div>'; 
				v_reply += '</div>'; 
				v_reply += '</div>'; 
				v_reply += '<div class="col-1"></div>'; 
				
				console.log("${sessionScope.memInfo.memId}");
				
				let v_memId = "${sessionScope.memInfo.memId}";
				
				if(v_memId){
					v_reply += '<div class="col-1">';
					v_reply += '<span class="my-span" onclick="f_delete()">삭제</span>';
					v_reply += '</div>';
				}
				
				v_reply += '</div>';
				
				v_replyBox.innerHTML += v_reply; 
			}
		});
		
		if(!v_replyInput){
			return;
		}
		

			
			
		});

		function f_delete(){
			if(!confirm("정말로 삭제하시겠습니까?")){
				return;
			}
			
			console.log(event.target.parentElement);
			console.log(event.target.parentElement.parentElement.children[0].value);
			let v_parent = event.target.parentElement.parentElement;
			
			let v_replyNo = event.target.parentElement.parentElement.children[0].value;
			console.log('번호 '+ v_replyNo);
			
			// AJAX 통신으로 해당 replyNo에 대한 UPDATE문 실행
			let v_ajax = new XMLHttpRequest();
			
			v_ajax.open('POST', '${pageContext.request.contextPath}/delReplyDo');
			
			// 데이터를 보내기 위해 데이터 형식을 만들어 주기 (form의 serialize 형태) 
			let v_data = "replyNo=" + v_replyNo;
			
			// form의 serialize 형태로 데이터를 보내기 위한 헤더 설정
			v_ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			
			// AJAX 통신이 끝나고 나면 실행되는 함수 (콜백함수)
			v_ajax.onload = ()=>{
				// 응답은 success 아니면 fail 문자열이 옴
				console.log(v_ajax.response);
				
				if(v_ajax.response == 'success'){
					v_parent.remove();
				}
				
			}
			console.log(v_data);
			// send 시 데이터를 보낸다.
			v_ajax.send(v_data);
			//event.target.parentElement.parentElement.remove();
			
		}	
		
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
