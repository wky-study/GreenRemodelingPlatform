<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>주문 내역</title>
</head>

<style>
	.my-card-box {
		flex-wrap: wrap;
	}
	
	.my-card {
		width: calc(100% / 5 + 2px);
		cursor:pointer;
	}
	.my-img{
		height:30px;
		
	}
	
	.my-cursor{
		cursor:pointer;
	}
	
</style>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">
			
			<div class="card-body">
			
				<div class="d-flex justify-content-center mb-5">
					<h2>주문내역</h2>
				</div>
				<div class="d-flex justify-content-end mb-5">
					<button class="btn btn-outline-success" id="downloadBtn" type="button">Excele 다운로드</button>
				</div>
				
				<div class="col-md-4 d-flex my-card-box w-100 justify-content-between">
					
					<table class="table table-hover">
					  <thead>
					    <tr>
					      <th scope="col"></th>
					      <th scope="col">대표 주문번호</th>
					      <th scope="col">주문번호</th>
					      <th scope="col" >상품명</th>
					      <th scope="col" >상품금액</th>
					      <th scope="col" >총 가격</th>
					      <th scope="col" >거래일시</th>
					    </tr>
					  </thead>
					  
					  <tbody>
						<c:forEach items="${keyPaymentList}" var="PaymentDTO">
						    <tr onclick="receipt(this)" class="my-cursor">
						      <th scope="row"><img class="my-img" src="${PaymentDTO.prodImageSrc}"></th>
						      <td>${PaymentDTO.representativeOrderId}</td>
						      <td>${PaymentDTO.partnerOrderId}</td>
						      <td>${PaymentDTO.prodName}</td>
						      <td>${PaymentDTO.prodPrice}</td>
						      <td>${PaymentDTO.totalPrice}</td>
						      <td>${PaymentDTO.paymentDate}</td>
						    </tr>
					    </c:forEach>	
					    
					  </tbody>
					  
					</table>					
				</div>
				
			</div>



			

		</div>

	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>
	
	<script type="text/javascript">
	
		
	  function receipt(row) {
		    // 클릭한 <tr> 안에서 partnerOrderId가 위치한 <td>를 선택
		    var partnerOrderId = row.cells[2].textContent;  // 3번째 td (0부터 시작)
		    
		    // partnerOrderId를 출력하거나 다른 작업을 할 수 있습니다
		    console.log("Partner Order ID: " + partnerOrderId);
		    
		    var url = "${pageContext.request.contextPath}/receiptView?partnerOrderId=" + partnerOrderId;
	        var windowName = "popupWindow";       // 창의 이름
	        var windowSize = "width=600,height=650"; // 창 크기 설정

	        // window.open()을 사용하여 새 창 열기
	        window.open(url, windowName,windowSize);

		  }
	    
	  
	   document.getElementById('downloadBtn').addEventListener('click', function() {
	        var xhr = new XMLHttpRequest();
	        xhr.open('GET', '${pageContext.request.contextPath}/downloadExcel', true);
	        xhr.responseType = 'blob'; // 응답을 blob(파일) 형태로 받음
	        xhr.onload = function() {
	            if (xhr.status === 200) {
	                var blob = xhr.response;
	                var link = document.createElement('a');
	                link.href = URL.createObjectURL(blob);
	                link.download = 'boardlist.xlsx';  // 다운로드할 파일명 설정
	                link.click(); // 파일 다운로드 트리거
	            }
	        };
	        xhr.send();
	    });		
	
	</script>
	

</body>

</html>
