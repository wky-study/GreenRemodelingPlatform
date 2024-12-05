<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>견적서 입력</title>


    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>



</head>

<body>
	<%@ include file="/WEB-INF/inc/header.jsp"%>
	<!--  Header End -->

	<!-- Content wrapper -->
	<div class="container-fluid">
		<!-- Content -->
		<div class="container-xxl flex-grow-1 container-p-y">
			<h4 class="fw-bold py-3 mb-4">
				<span class="text-muted fw-light">견적서 생성 /</span> 기본정보 입력
			</h4>
			<div class="row">
				<div class="col-md-12">
				
					<div class="card mb-4">
						
						<hr class="my-0" />
						<div class="card-body">
							<form id="formAccountSettings" action="${pageContext.request.contextPath}/est2" method="POST">
								<input class="form-control" type="hidden" id="firstName" name="memId"  />
								<input class="form-control" type="hidden" id="firstName" name="itemType" value="공기조화설비공사" />
								<input type="hidden" id="sigunguCd" name="sigunguCd">
								<input type="hidden" id="bjdongCd" name="bjdongCd">
								
								<div class="alert alert-primary text-center">
								<span class="mb-3">리모델링을 받을 주소를 입력해주세요.</span>
								</div>
								<div class="mb-3 col-md-6 w-100">
							        <label class="form-label" for="address">주소:</label>
							        <input class="form-control" type="text" id="address" name="estAddress" placeholder="주소를 검색하세요" readonly required>
								</div>
								
								<div class="row">
								<div class="mb-3 col-md-6 ">
							        <label class="form-label" for="detailAddress">동: </label>
							        <input class="form-control" type="text" id="dongNm" name="dongNm"  placeholder="숫자만 입력하세요.">
								</div>
								<div class="mb-3 col-md-6 ">
							        <label class="form-label" for="detailAddress">호: </label>
							        <input class="form-control" type="text" id="hoNm" name="hoNm"  placeholder="숫자만 입력하세요.">
								</div>
								</div>
								<div class="mb-3 col-md-6 w-100">
									<label class="form-label" for="start-date">시공 시작일:</label>
									<input class="form-control" type="date" id="start-date" name="estSdate" required>
								</div>
							</form>
								<div class="mt-2 mb-3 d-flex justify-content-end">
									<button id="backBtn" type="button" class="btn btn-primary me-2">목록으로</button>
									<button id="saveBtn" type="button" class="btn btn-primary me-2">임시저장 및 다음</button>
								</div>
								
						</div>
						<!-- /Account -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Content wrapper -->



	<%@ include file="/WEB-INF/inc/footer.jsp"%>
	
    <script>
    
	    // 유효성 검사 함수
	    function validateForm() {
	        const fields = [
	            { id: 'address', name: '주소' },
	            { id: 'start-date', name: '시공 시작일' }
	        ];
	
	        for (const field of fields) {
	            const input = document.getElementById(field.id);
	            if (!input.value.trim()) {
	                alert(field.name + ' 항목을 입력해 주세요.'); // 필드 이름 표시
	                input.focus(); // 포커스 이동
	                return false; // 유효성 검사 실패
	            }
	        }
	        return true; // 유효성 검사 통과
	    }
	    
    
    

		// 주소 입력란 클릭 시 Daum 주소 API 열기
		document.getElementById('address').addEventListener('click', function() {
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 우편번호와 주소 정보를 자동으로 입력
		            document.getElementById('address').value = data.address; // 주소 입력란에 주소 설정
		
		            // 시군구 코드와 법정동 코드를 숨겨진 입력 필드에 설정
		            document.getElementById('sigunguCd').value = data.sigunguCode; // 시군구 코드 설정
		            // 법정동 코드에서 앞의 5자리를 삭제한 나머지를 설정
		            const bjdongCode = data.bcode ? data.bcode.substring(5) : ''; // 'bcode' 사용
		            document.getElementById('bjdongCd').value = bjdongCode; // 법정동 코드 설정
		        }
		    }).open();
		});
    
	    // 다음 버튼 클릭 이벤트
	    document.getElementById('saveBtn').addEventListener('click', () => {
	        // 유효성 검사 통과 시 폼 제출
	        if (validateForm()) {
	            alert("임시 저장되었습니다."); // 성공 시 알림창
	            document.getElementById('formAccountSettings').submit(); // 폼 제출
	        }
	    });
	    
	    
    	// 이전버튼
	    document.getElementById('backBtn').addEventListener('click',()=>{
			
	        window.location.href = '${pageContext.request.contextPath}/estListView'; 
	    	
	    })
	    
    </script>
	
	
</body>

</html>
