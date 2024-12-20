<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>장바구니</title>

</head>


<style>
.my-card-box {
	flex-wrap: wrap;
}

.my-card {
	width: calc(100%/ 5 + 2px);
	cursor: pointer;
}

.my-img {
	height: 30px;
}
</style>


<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">


			<div class="container-xxl flex-grow-1 container-p-y">
				<h4 class="fw-bold py-3 mb-4">
					<span class="text-muted fw-light">Mypage /</span> 장바구니
				</h4>
				<div class="row">
					<div class="col-md-12">
						<ul class="nav nav-pills flex-column flex-md-row mb-3">
							<li class="nav-item"><a class="nav-link "
								href="${pageContext.request.contextPath}/settingView"><i
									class="bx bx-user me-1"></i> 회원정보</a></li>
							<li class="nav-item"><a class="nav-link active"
								href="${pageContext.request.contextPath}/cartView"><i
									class="bx bx-bell me-1"></i>장바구니</a></li>
							<li class="nav-item"><a class="nav-link "
								href="${pageContext.request.contextPath}/orderSummary"><i
									class="bx bx-link-alt me-1"></i> 주문 내역</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/chatListView"><i

									class="bx bx-link-alt me-1"></i>채팅 목록</a></li>	
<%-- 							<c:if test="${sessionScope.memInfo != null && sessionScope.memInfo.memType == 5}">
								<li class="nav-item"><a class="nav-link"
									href="${pageContext.request.contextPath}/planView"><i
										class="bx bx-link-alt me-1"></i>시공 일정</a></li>
							</c:if>	 --%>								
																	
						</ul>
					</div>
				</div>
			</div>

			<div class="card-body">



				<div
					class="col-md-4 d-flex my-card-box w-100 justify-content-between">

					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col"></th>
								<th scope="col" class="item-name">상품이름</th>
								<th scope="col" class="item-cnt">수량</th>
								<th scope="col" class="item-price">상품금액</th>
							</tr>
						</thead>

						<tbody>

							<c:forEach items="${keyProd}" var="ProductDTO">
								<tr>
									<th scope="row">
										<div class="form-check">
											<input class="form-check-input" type="checkbox"
												onclick="f_check(this, '${ProductDTO.cartId}', '${ProductDTO.prodName}', '${ProductDTO.prodPrice}', '${ProductDTO.prodImageSrc}', '${ProductDTO.prodNo}')">
										</div>
									</th>
									<td><img class="my-img" src="${ProductDTO.prodImageSrc}"></td>
									<td>${ProductDTO.prodName}</td>
									<td><input type="number" value="1"
										id="${ProductDTO.prodNo}Count"
										oninput="f_check('True', '${ProductDTO.cartId}', '${ProductDTO.prodName}', '${ProductDTO.prodPrice}', '${ProductDTO.prodImageSrc}', '${ProductDTO.prodNo}')"></td>
									<td>${ProductDTO.prodPrice}</td>
								</tr>
							</c:forEach>

						</tbody>

					</table>
				</div>

				<div class="d-flex justify-content-end align-items-center mt-3 mb-3">
					<div class="me-5">
						<span id="totalSummary">총 0 개의 상품금액 0 원</span>
					</div>
				</div>


				<div class="d-flex justify-content-end align-items-center mt-3 mb-3">
					<button class="btn btn-outline-danger me-3" id="delBtn"
						type="button">삭제</button>
					<button class="btn btn-outline-info me-3" id="orderBtn"
						type="button">상품 주문</button>
				</div>

			</div>


		</div>





	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script type="text/javascript">
		
    let v_memId = "${sessionScope.memInfo.memId}";

    let v_nema = '';

    let selectedItems = []; // 선택된 항목의 객체를 담을 배열

    let totalPrice = 0;
    let v_count = 0;

    // 선택된 체크박스의 값 가져오기
    function f_check(checkbox, cartId, prodName, prodPrice, prodImageSrc, prodNo) {
    	console.log("chk: ", checkbox);
      if (checkbox.checked || checkbox == "True") {
        console.log(cartId);
        console.log(prodPrice);
        console.log(prodImageSrc);
        // 체크된 항목의 정보를 객체로 저장
        let v_quantity = parseInt(document.getElementById(prodNo+"Count").value);
        console.log(v_quantity);
        let flag = true;
        if(checkbox == "True"){
        	let len = selectedItems.length;
        	selectedItems = selectedItems.filter(item => item.cartId !== cartId);
        	if(len == selectedItems.length){
        		flag = false;
        	}
        }
        if(flag){
        selectedItems.push({ cartId, prodName, prodPrice, quantity: v_quantity, prodImageSrc, prodNo }); // 수량은 기본 1로 설정
        }
      } else if(!checkbox.checked){
        // 체크 해제된 항목은 배열에서 제거
        selectedItems = selectedItems.filter(item => item.cartId !== cartId);
      }
      // 총합 업데이트
      updateTotal();
    }

    // 총합 업데이트 함수
    function updateTotal() {
      let totalAmount = 0;
      let totalItems = 0;

      selectedItems.forEach(item => {
        totalItems += item.quantity;

        // 쉼표 제거하고 숫자로 변환
        let priceWithoutComma = item.prodPrice.replace(/,/g, '');  // 쉼표 제거
        let price = parseInt(priceWithoutComma, 10);  // 정수로 변환

        totalAmount += price * item.quantity;
      });

        // 총합 업데이트
        document.getElementById("totalSummary").innerText = '총 ' + totalItems + ' 개의 상품금액 ' + totalAmount + ' 원';
}
    // 삭제 버튼 클릭
    document.getElementById("delBtn").addEventListener('click', () => {
      if (selectedItems.length === 0) {
        alert("삭제할 상품을 선택해주세요.");
        return;
      }

      const cartData = {
        cartId: selectedItems.map(item => item.cartId), // 선택된 상품들의 cartId
        prodImageSrc: selectedItems.map(item => item.prodImageSrc), // 선택된 상품들의 prodImageSrc
        memId: v_memId // 로그인된 사용자 ID
      };

      // 서버로 삭제 요청 보내기
      let v_url = '${pageContext.request.contextPath}/removeFromCart'; // 삭제 요청 URL
      $.ajax({
        type: "POST",
        url: v_url,
        data: JSON.stringify(cartData), // 데이터를 JSON 형태로 전송
        contentType: "application/json",
        success: function (resp) {
          alert("삭제 되었습니다.");
          location.reload(); // 페이지 새로고침
        }
      });
    });

    // 상품주문 클릭시
    document.getElementById("orderBtn").addEventListener('click', () => {

      if (selectedItems.length === 0) {
        alert("주문할 상품을 선택해주세요.");
        return;
      }

      // 주문 항목 배열을 생성
      let orderCreateFormList = selectedItems.map((item, index) => {

        let priceWithoutComma = item.prodPrice.replace(/,/g, '');  // 쉼표 제거
        let price = parseInt(priceWithoutComma, 10);  // 정수로 변환

        return {
          name: item.prodName,   // 상품명
          totalPrice: price * item.quantity,  // 총 결제금액 (상품 가격 * 수량)
          memId: v_memId,        // 회원 아이디
          quantity: item.quantity,  // 수량
          cartId: item.cartId,		//  장바구니 고유번호
          prodImageSrc: item.prodImageSrc, // 이미지 src
          prod_no: item.prodNo,
          prod_count: item.quantity
        };
      });

      console.log("orderCreate: ", orderCreateFormList);  // 생성된 주문 데이터 확인
      let test = [{prod_no: "P020", prod_count : 3},{prod_no: "P019", prod_count : 2}];
      console.log(test);
      let v_url = '${pageContext.request.contextPath}/requestOrder'; // 주문 요청 URL
      $.ajax({
        type: "POST",
        url: v_url,
        data: JSON.stringify(orderCreateFormList), // 데이터를 JSON 형태로 전송
        contentType: "application/json",
        success: function (resp) {
        	console.log("fastapi: ",resp);
        	if(resp.success == true){
        		console.log(resp.success);
        	}
          if(resp.success == false){
        	  console.log(resp.detail);
          }
          
        },
        error: function (err) {
          console.error("주문 요청 실패한듯:", err);
          alert("주문 처리에 실패했다람쥐.");
        }
      });
      
      

      // 서버로 주문 데이터 요청 보내기
      v_url = '${pageContext.request.contextPath}/pay/ready'; // 주문 요청 URL
      $.ajax({
        type: "POST",
        url: v_url,
        data: JSON.stringify(orderCreateFormList), // 데이터를 JSON 형태로 전송
        contentType: "application/json",
        success: function (resp) {
          window.open(resp.next_redirect_pc_url, "_blank");  // 결제 페이지로 리디렉션
          
        },
        error: function (err) {
          console.error("주문 요청 실패:", err);
          alert("주문 처리에 실패했습니다.");
        }
      });
    });
    
    
	</script>



</body>

</html>
