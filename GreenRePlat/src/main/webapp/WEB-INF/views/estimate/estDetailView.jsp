<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>견적서</title>


	<style>
	
	.my-img{
		height:30px;
		
	}
	
	/* 금액 항목 스타일 */
	.price-section {
		font-size: 16px; /* 글씨 크기 적당히 */
		font-weight: bold;
		color: #333; /* 어두운 회색으로 텍스트 강조 */
		text-align: right; /* 오른쪽 정렬 */
		margin-top: 15px; /* 항목 간 여백 */
		padding: 10px 20px; /* 패딩 추가 */
		border: 1px solid #ddd; /* 연한 회색 테두리 */
		border-radius: 8px; /* 둥근 테두리 */
		background-color: #f8f8f8; /* 연한 배경색 */
		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 부드러운 그림자 */
	}

	/* 마지막 항목에만 아래 여백 없애기 */
	.price-section:last-child {
		margin-bottom: 0;
	}

	/* 총 금액 스타일 */
	.total-amount {
		font-size: 28px; /* 글씨 크기 크게 */
		font-weight: bold;
		color: #D9534F; /* 빨간색 강조 */
		text-align: right; /* 우측 정렬 */
		margin-top: 20px; /* 상단 여백 */
		padding: 15px 30px; /* 여유 있는 패딩 */
		border: 2px solid #D9534F; /* 빨간색 테두리 */
		border-radius: 10px; /* 둥근 테두리 */
		background-color: #fff4f4; /* 연한 빨간색 배경 */
		box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 강조 */
	}

	/* 금액 앞에 '원' 추가 */
	.price-section span {
		margin-left: 10px;
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
				<span class="text-muted fw-light">견적서 /</span> 최종 견적서
			</h4>
			
			
            <div class="row">
                <!-- 고객 정보 섹션 -->
                <div class="col-md-12">
                    <div class="card mb-4">
                        <hr class="my-0" />
                        <div class="card-body">
                            <div class="w-100 d-flex justify-content-center mt-3 mb-3">
                                <h3>고객 정보</h3>
                            </div>
							<hr>
							<div class="row mb-3">
							    <div class="col">
	                                <h5><strong>고객명:</strong> ${keyMem.memName}</h5>
							    </div>
							    <div class="col">
	                                <h5><strong>연락처:</strong> ${keyMem.memPhone}</h5>
							    </div>
							</div>
							
							<div class="row mb-3">
							    <div class="col">
	                                <h5><strong>이메일:</strong> ${keyMem.memEmail}</h5>
							    </div>
							    <div class="col">
	                                <h5><strong>고객주소:</strong> ${keyMem.memAddress}</h5>
							    </div>
							</div>
							    
							<div class="row mb-3">
							    <div class="col">
	                                <h5><strong>리모델링 주소:</strong> ${sessionScope.keyEst.estAddress}</h5>
							    </div>
							    <div class="col">
	                                <h5><strong>평수(㎡):</strong> ${sessionScope.keyEst.estArea}</h5>
							    </div>
							</div>
							
							<div class="row">
							    <div class="col">
	                                <h5><strong>시공 시작 일:</strong> ${sessionScope.keyEst.estSdate}</h5>
							    </div>
							    <div class="col">
	                                <h5><strong>시공 종료 일:</strong> ${sessionScope.keyEst.estEdate}</h5>
							    </div>
							</div>


                        </div>
                    </div>
                </div>
            </div>			
			
			
			<div class="row">
				<div class="col-md-12">
				
					
					<div class="card mb-4">
						
						<hr class="my-0" />
						<div class="card-body">
						
							<div class="w-100 d-flex justify-content-center mt-3 mb-3">
								<h3>자재 리스트</h3>
							</div>
							
							<hr>
						
							<div class="col-md-4 my-card-box w-100 justify-content-between">
								
								<table class="table">
								  <thead>
								    <tr>
								      <th scope="col"></th>
								      <th scope="col" >상품이름</th>
								      <th scope="col" >모델명</th>
								      <th scope="col" >업체명</th>
								      <th scope="col" >수량</th>
								    </tr>
								  </thead>
								  
								  <tbody>
								  
										<c:forEach items="${materialList}" var="MaterialDTO">
										    <tr>
										      <td><img class="my-img" src="${MaterialDTO.itemImg}"></td>
										      <td>${MaterialDTO.itemName}</td>
										      <td>${MaterialDTO.itemModel}</td>
										      <td>${MaterialDTO.itemBrand}</td>
										      <td>${MaterialDTO.itemQuantity}</td>
										    </tr>
										</c:forEach>					    
								    
								  </tbody>
								  
								</table>	
	
								<!-- 자재비 총합 -->
								<div class="price-section">
									<span>자재비 : ${formattedTotalAmount}</span><span>원</span>
								</div>
								
								<!-- 시공비 -->
								<div class="price-section">
									<span>시공비 : ${formattedConstructionCost}</span><span>원</span>
								</div>
								
								<!-- 부가세 -->
								<div class="price-section">
									<span>부가세 : ${formattedVat}</span><span>원</span>
								</div>
								
								<!-- 총 금액 -->
								<div class="total-amount">
									<span>총 금액 : ${formattedFinalAmount}</span><span>원</span>
								</div>							
												
							</div>
							
							
										
						</div>
					</div>
				</div>
			</div>
			
			
			
		</div>
	</div>
	
	
	



	<%@ include file="/WEB-INF/inc/footer.jsp"%>
	
    <script>
    
    
    </script>
	
	
</body>

</html>
