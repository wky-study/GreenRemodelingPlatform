<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>제품 목록</title>

</head>


<style>
	.my-card-box {
		flex-wrap: wrap;
	}
	
	.my-card {
		width: calc(100% / 5 + 2px);
		cursor:pointer;
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
					<div class="d-flex">

						<div class="col-lg-6 wow fadeInUp border-end" data-wow-delay="0.5s"
							style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
							<div class="img-border">
								<img class="img-fluid" src="${keyProduct.prodImageSrc}">
							</div>
						</div>
	
						<div class="d-flex flex-column justify-content-between ms-3" data-wow-delay="0.1s"
							style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
							<div>
								<h2 class="mb-4">
									${keyProduct.prodName}
								</h2>
								<span>${keyProduct.prodModel}</span>
							</div>
							<div>
								<h5>업체명 : ${keyProduct.prodName}</h5>
							</div>
							<div>
								<h5>제조원 : ${keyProduct.prodManufacturer}</h5>
							</div>
							<div>
								<h5>에너지효율 : ${keyProduct.prodEfficiency}</h5>
							</div>
							<div>
								<h4>가격 : ${keyProduct.prodPrice}</h4>
							</div>
							<div class="d-flex">
								<button class="btn btn-outline-dark py-3 px-5 mt-3 me-3" id="cartBtn" >장바구니</button>
								<button class="btn btn-dark py-3 px-5 mt-3" id="payBtn" >구매하기</button>
							</div>
						</div>

					</div>
				</div>
			</div>




		</div>
	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>


	<script type="text/javascript">
	
	let v_name = "${keyProduct.prodName}";
	let v_price = "${keyProduct.prodPrice}";
	let v_memId = "${sessionScope.memInfo.memId}";
	v_price = parseInt(v_price.replace(/,/g, ''));
	
	console.log(v_price);
	

	
     // 카카오페이 결제 팝업창 연결
    $(function() {
        $("#payBtn").click(function(e) {
        	
        	let v_orderNo = 'ORD' + new Date().getTime(); // 예: 'ORD' + 현재 시간(ms)
            // 아래 데이터 외에도 필요한 데이터를 원하는 대로 담고, Controller에서 @RequestBody로 받으면 됨
            let data = [{
                name: v_name,    // 카카오페이에 보낼 대표 상품명
                totalPrice: v_price,  // 총 결제금액
                memId: v_memId,
                partnerOrderId: v_orderNo
            }];
          
        	if(!v_memId){
        		alert("로그인 후 이용해주세요.");
        		location.href = '${pageContext.request.contextPath}/loginView'
        	}
        	
        	console.log(data);
            
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath}/pay/ready',
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function(response) {
                	
                	window.open(response.next_redirect_pc_url, "_blank");
                }
            });
        });
    }); 
	
    
     
    // 장바구니 버튼 클릭시 
    document.getElementById("cartBtn").addEventListener("click", ()=>{
    	
    	if(!v_memId){
    		alert("로그인 후 이용해주세요.");
    		location.href = '${pageContext.request.contextPath}/loginView'
    	}else{
    		alert("장바구니에 담겼습니다.");
    		
    		let v_prodNo = "${keyProduct.prodNo}";
    		
    		let v_quantity = 1; 
    		
            // 장바구니 정보 설정
            const cartData = {
                memId: v_memId, // 사용자 아이디 (로그인된 사용자 ID)
                prodNo: v_prodNo, // 상품 번호
                quantity: v_quantity // 상품 수량
            };
    		
            let v_url = '${pageContext.request.contextPath}/addToCart';
            
    		$.ajax({
    			type : "POST",
    			url : v_url,
    			data : cartData,
    			success : function(resp){
    				console.log(resp);	  //JSON 객체 (jQuery에서 자동으로 parse 해줌)
    			}
    		});
    		
    		
    	}
    	
    	
    	
    	
    	
    	
    })
     
	
	</script>
	
	
	
	

</body>

</html>
