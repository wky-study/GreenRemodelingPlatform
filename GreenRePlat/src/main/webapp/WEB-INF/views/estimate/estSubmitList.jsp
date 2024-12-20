<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>견적서 입력</title>


	<style>
	  /* 클릭 가능한 행에 대해 스타일 추가 */
	  .clickable-row {
	    cursor: pointer; /* 커서를 포인터로 변경 */
	    transition: background-color 0.3s; /* 부드러운 배경색 전환 */
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
			<h4 class="fw-bold py-3 mb-4">
				<span class="text-muted fw-light">견적서 /</span> (제출완료)
			</h4>
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
								      <th scope="col" class="item-name">면적(㎡)</th>
								      <th scope="col" class="item-name">요청 시공일</th>
								    </tr>
								  </thead>
								  
								  <tbody>
										<c:forEach items="${keyEstList}" var="EstimateDTO"  varStatus="status">
											<c:if test="${EstimateDTO.estArea != '알 수 없음'}">
											    <tr class="clickable-row" onclick="goToEstDetail(${EstimateDTO.estId})">
											      <th scope="row">${status.index + 1}</th>
											      <td>${EstimateDTO.estAddress}</td>
											      <td>${EstimateDTO.dongNm}</td>
											      <td>${EstimateDTO.hoNm}</td>
											      <td>${EstimateDTO.estArea}</td>
											      <td>${EstimateDTO.estSdate}</td>
											    </tr>
											</c:if>
											
											<c:if test="${EstimateDTO.estArea == '알 수 없음'}">
											    <tr class="clickable-row" onclick="errClick(${EstimateDTO.estId})">
											      <th scope="row">${status.index + 1}</th>
											      <td>${EstimateDTO.estAddress}</td>
											      <td>${EstimateDTO.dongNm}</td>
											      <td>${EstimateDTO.hoNm}</td>
											      <td>${EstimateDTO.estArea}</td>
											      <td>${EstimateDTO.estSdate}</td>
											    </tr>
											</c:if>
										</c:forEach>					    
								  </tbody>
								  
								</table>					
							</div>
							
							<c:if test="${empty keyEstList}">
							  	<div class="alert alert-danger text-center">
							  		제출된 견적서가 없습니다.
							  	</div>
							</c:if>	
										
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
    
    function goToEstDetail(estId) {
        // estId를 URL 파라미터로 전달하여 /est1 경로로 이동
        window.location.href = '${pageContext.request.contextPath}/estDetailView?estId=' + estId;
      }
    
    function errClick(estId){
    	alert("유효하지 않은 견적서 입니다. 다시 견적서를 작성해주세요.");
    	 window.location.href = '${pageContext.request.contextPath}/estErr?estId=' + estId;
    }
    
    </script>
	
	
</body>

</html>
