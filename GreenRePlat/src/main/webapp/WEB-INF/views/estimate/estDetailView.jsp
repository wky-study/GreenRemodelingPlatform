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
							    
							<div class="row">
							    <div class="col">
	                                <h5><strong>리모델링 주소:</strong> ${sessionScope.keyEst.estAddress}</h5>
							    </div>
							    <div class="col">
	                                <h5><strong>평수(㎡):</strong> ${sessionScope.keyEst.estArea}</h5>
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
						
							<div class="col-md-4 d-flex my-card-box w-100 justify-content-between">
								
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
