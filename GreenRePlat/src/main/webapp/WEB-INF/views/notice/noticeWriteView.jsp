<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>공지 게시판</title>


<!-- 네이버 스마트 에디터 js파일 불러오기 -->
<script src="${pageContext.request.contextPath }/nse/js/HuskyEZCreator.js"></script>

<!-- jquery (AJAX 통신) -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	

</head>


<style>
	.my-card-box {
		flex-wrap: wrap;
	}
	
	.my-card {
		width: calc(100% / 5 + 2px);
		cursor:pointer;
	}
	
</style>


<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">
			
			<div class="card-body">

					<input type="file" id="inputImg" accept="image/*" hidden="true" onchange="f_sandImg()">
					
					<form id="noticeWriteForm" action="${pageContext.request.contextPath }/noticeWriteDo" method="POST" enctype="multipart/form-data">
					
						<div class="mb-3">
							<input class="form-control" id="inputId" type="text" name="noticeTitle" placeholder="제목을 입력해주세요."/>
						</div>
						
						<div class="mb-3">
							<label for="formFileMultiple" class="form-label">파일 첨부</label>
							<input class="form-control" name="noFile" type="file" id="formFileMultiple" multiple>
						</div>
						
						<div class="mb-3">
						
							<button class="d-none" onclick="f_imgWidth(this)" id="imgBtn">입력</button>
							
							<textarea id="smartEditor" class="form-control"  rows="10" name="noticeContent"></textarea>
						</div>		
						
						<div class="d-flex justify-content-end">
							<a class="btn btn-secondary me-2" href="${pageContext.request.contextPath }/noticeView">취소</a>
							
							<!-- form 태그의 submit 역할을 함 -> type=submit 넣어주기 -->
							<button id="writeBtn" class="btn btn-primary" type="button">등록</button>
						</div>
						
						<input type="text" id="imageFileName" name="imgFileName" hidden="true" >
						
					</form>
								
					
					
			</div>

		</div>





	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<!-- 네이버 스마트 에디터 -->
	<script type="text/javascript">
	
    // 페이지 벗어나기 직전에 스크롤을 최상단에 올리는 코드 넣기
	window.onload = function(){
    	setTimeout (function (){
    		scrollTo(0,0);
    	}, 100);
    };
	
		var oEditors = [];
		
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "smartEditor",  // textarea의 id
			sSkinURI : "${pageContext.request.contextPath }/nse/SmartEditor2Skin.html"

		});
		
		document.getElementById("writeBtn").addEventListener('click', ()=>{
			
			// 에디터에 작성된 내용(html태그 형태)을 숨겨진 textarea에 반영
			oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);
			
			document.getElementById("noticeWriteForm").submit();
		})
		
		// 이미지 첨부 받을 input 태그 객체 불러오기
		const v_inputImg = document.getElementById("inputImg");
		
		// 스마트에디터가 로드된 후 이미지 첨부 버튼에 클릭 이벤트 추가
		window.onload = function(){
			// 스마트 에디터가 그려진 iframe 가져오기
			const v_iframe = document.querySelector('#noticeWriteForm > div:nth-child(2) > iframe');
			console.log(v_iframe);
			// iframe 내 document 에 접근
			const v_iframeDocument = v_iframe.contentWindow.document;
			console.log(v_iframeDocument);
			// iframe의 document 안에 있는 이미지 첨부 버튼(id가 photoUploadBtn)에
			// 클릭 이벤트 부여
			v_iframeDocument.querySelector('#photoUploadBtn').addEventListener("click", ()=>{
				// 에디터 내 이미지 첨부 버튼 클릭 시 inputImg 태그 클릭
				v_inputImg.click();
			});
			
		}
		
		// 파일 첨부시 실행
		function f_sandImg(){
			let v_formData = new FormData();
			v_formData.append('file',event.target.files[0]);
			
			// 요청보낼 주소
			let v_url = '${pageContext.request.contextPath}/uploadImg';
			
			// AJAX 통신 요청
			$.ajax({
				type: 'POST',
				url: v_url,
				contentType: false,
				processData: false,
				enctype: 'multipart/form-data',
				data: v_formData,
				success: function(resp){
					// 이미지 태그 생성
					let imgTag = '<img onclick="window.parent.parent.f_sizeCtrl(this)" style="width: 800px; display: block; margin-left: auto; margin-right: auto;" src="';
						imgTag += '${pageContext.request.contextPath}/displayImage?fileName=' + resp;
						imgTag += '">'; 
						
					// 지금 시점에 resp 를 쏘기
					// 816c1e3e-a785-42da-97ba-462b058edf47
					console.log(resp);
					// 이미지 파일 이름을 숨겨진 input에 저장
					document.getElementById('imageFileName').value = resp; 
					
					// 에디터 내부에 이미지 태그 넣기
					oEditors.getById['smartEditor'].exec("PASTE_HTML", [imgTag]);
				}
			});
		}
		
		
		/* 사진 크기 조정 */
		let v_targetImg = null;
		let v_temp = null;
		let v_imgIn = document.getElementById("imgInput");
		
		function f_sizeCtrl(p_this){
			console.log(p_this);
			v_targetImg = p_this;
			
			console.log(p_this.parentElement);

			var test = prompt("사진 크기 입력(px)");
			console.log(test);
			
			v_targetImg.style.width = test + "px";
		}
		
		
	</script>
	
	
	

</body>

</html>
