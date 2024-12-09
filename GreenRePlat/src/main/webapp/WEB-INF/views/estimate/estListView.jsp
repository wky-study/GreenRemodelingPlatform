<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>견적서 입력</title>


    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	<style>
	  /* 클릭 가능한 행에 대해 스타일 추가 */
	.clickable-row {
	   cursor: pointer; /* 커서를 포인터로 변경 */
	   transition: background-color 0.3s; /* 부드러운 배경색 전환 */
	 }
	.icon-button {
	   border: none; /* 네모난 테두리 제거 */
	   background-color: transparent; /* 배경색 제거 */
	   padding: 0; /* 내부 여백 없애기 */
	   cursor: pointer; /* 커서 모양 변경 */
	   display: inline-block;
	 }
	
	 /* 클릭 시 발생하는 테두리 효과 제거 */
	.icon-button:focus {
	   outline: none; /* 포커스 시 테두리 제거 */
	 }
	.icon-button:hover {
	     background-color: #f0f0f0; 
	   }
	
	</style>



</head>

<body>
	<%@ include file="/WEB-INF/inc/header.jsp"%>
	<!--  Header End -->

	<!-- Content wrapper -->
	<div class="container-fluid">
		<!-- Content -->
		<div class="container-xxl flex-grow-1 container-p-y">
			<h4 class="fw-bold py-3 mb-4" style="display: inline-block;">
				임시 저장된 견적서
			</h4>
			<button id="reopenModal" class="icon-button" style=" padding-bottom: 7px; vertical-align: middle;" aria-label="다시 열기">
			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path fill="currentColor" d="M22 12c0 5.523-4.477 10-10 10S2 17.523 2 12S6.477 2 12 2s10 4.477 10 10" opacity="0.5"/><path fill="currentColor" d="M12 7.75c-.621 0-1.125.504-1.125 1.125a.75.75 0 0 1-1.5 0a2.625 2.625 0 1 1 4.508 1.829q-.138.142-.264.267a7 7 0 0 0-.571.617c-.22.282-.298.489-.298.662V13a.75.75 0 0 1-1.5 0v-.75c0-.655.305-1.186.614-1.583c.229-.294.516-.58.75-.814q.106-.105.193-.194A1.125 1.125 0 0 0 12 7.75M12 17a1 1 0 1 0 0-2a1 1 0 0 0 0 2"/></svg>
			</button>
			<div class="row">
				<div class="col-md-12">
				
					
					<div class="card mb-4">
						
						<hr class="my-0" />
						<div class="card-body">
						
							<div class="col-md-4 d-flex my-card-box w-100 justify-content-between">
								
								<table class="table table-hover">
								  <thead>
								    <tr>
								      <th scope="col">#</th>
								      <th scope="col">주소</th>
								      <th scope="col" class="item-name">동</th>
								      <th scope="col" class="item-name">호</th>
								    </tr>
								  </thead>
								  
								  
								  
								  <tbody>
										<c:forEach items="${keyEstList}" var="EstimateDTO"  varStatus="status">
										    <tr class="clickable-row" onclick="goToEstDetail(${EstimateDTO.estId})">
										      <th scope="row">${status.index + 1}</th>
										      <td>${EstimateDTO.estAddress}</td>
										      <td>${EstimateDTO.dongNm}</td>
										      <td>${EstimateDTO.hoNm}</td>
										    </tr>
										</c:forEach>					    
								  </tbody>
								</table>
							</div>

							<c:if test="${empty keyEstList}">
							  	<div class="alert alert-danger text-center">
							  		임시 저장된 견적서가 없습니다.
							  	</div>
							</c:if>							
							<div class="mt-2 mb-3 d-flex justify-content-end">
								<button id="writeBtn" type="button" class="btn btn-primary me-2">새로운 견적서 생성하기</button>
							</div>										
						
						</div>
						<!-- /Account -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Content wrapper -->
	
	<!-- 설명 모달 -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">견적 의뢰하기</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
		    <p class="lh-base h6">입력하신 데이터를 바탕으로 AI가 자동으로 고객님의 집에 적용 가능한 그린 리모델링 견적을 계산해 줍니다.</p>
		    <p class="lh-base h6">이는 실제와 다를 수 있으며, 시공사와의 정확한 협의가 필요합니다.</p>

	        
	      </div>
	      <div class="modal-footer">
	        <div class="form-check">
	          <input class="form-check-input" type="checkbox" id="dontShowAgain">
	          <label class="form-check-label" for="dontShowAgain">
	            다시 보지 않기
	          </label>
	        </div>
	        <button type="button" class="btn btn-sm btn-danger "data-bs-dismiss="modal">닫기</button>
	      </div>
	    </div>
	  </div>
	</div>


	<%@ include file="/WEB-INF/inc/footer.jsp"%>
	
    <script>
    
    function goToEstDetail(estId) {
        // estId를 URL 파라미터로 전달하여 /est1 경로로 이동
        window.location.href = '${pageContext.request.contextPath}/est1?estId=' + estId;
      }
    
	// 새 임시견적서 작성 시
    document.getElementById('writeBtn').addEventListener('click',()=>{
		
        window.location.href = '${pageContext.request.contextPath}/estWrite';
    	
    })
    
    </script>
    
	<script>

	document.addEventListener('DOMContentLoaded', function () {
	    const modal = new bootstrap.Modal(document.getElementById('exampleModal'));
	    const reopenModalButton = document.getElementById('reopenModal');
	    
	    // 페이지 로드 시 모달 자동 표시
	    const dontShowAgain = localStorage.getItem('dontShowModal');
	    if (!dontShowAgain) {
	      modal.show();
	    }

	    // "다시 보지 않기" 체크박스 이벤트
	    document.getElementById('dontShowAgain').addEventListener('change', function () {
	      if (this.checked) {
	        localStorage.setItem('dontShowModal', 'true');
	      } else {
	        localStorage.removeItem('dontShowModal');
	      }
	    });

	    // "다시 열기" 버튼 클릭 이벤트
	    reopenModalButton.addEventListener('click', function () {
	      localStorage.removeItem('dontShowModal'); // 다시 보지 않기 설정 초기화
	      modal.show(); // 모달 다시 표시
	    });
	  });
	</script>
	
	
</body>

</html>
