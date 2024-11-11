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
								<button class="btn btn-outline-dark py-3 px-5 mt-3 me-3" >장바구니</button>
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
	v_price = parseInt(v_price.replace(/,/g, ''));
	
	console.log(v_price);
	
     // 카카오페이 결제 팝업창 연결
    $(function() {
        $("#payBtn").click(function(e) {
            // 아래 데이터 외에도 필요한 데이터를 원하는 대로 담고, Controller에서 @RequestBody로 받으면 됨
            let data = {
                name: v_name,    // 카카오페이에 보낼 대표 상품명
                totalPrice: v_price // 총 결제금액
            };
          
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
	
    function onPaymentComplete() {
        alert("결제가 완료되었습니다.");
        
        location.href = '${pageContext.request.contextPath}/paymentDone';
    }
    
     
     
	
	</script>
	
	
	
	

</body>

</html>
