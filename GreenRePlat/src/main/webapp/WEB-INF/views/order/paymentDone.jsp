<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>주문 완료</title>



</head>


<style>
	
	
</style>


<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">
			
			<div class="w-100 mb-5">
				<div class="d-flex justify-content-center">
					<h1 class="mt-5">결제 완료</h1>				
				</div>
				<div class="d-flex justify-content-center">
					<h3 class="mt-3">결제가 완료 되었습니다.</h3>
				</div>
				<div class="d-flex justify-content-center">
					<button onclick="home()" class="mt-5 btn btn-outline-dark me-3">홈 화면</button>
					<button onclick="openPopup()" class="mt-5 btn btn-outline-dark ms-3">영수증 출력</button>
				</div>
			</div>

			

		</div>

	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>
	
	<script type="text/javascript">
		
		function home(){
			location.href ='${pageContext.request.contextPath}/';
		}
		
        function openCenteredWindow(url, name, width, height) {
            // 화면의 가로, 세로 크기 구하기
            var screenWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
            var screenHeight = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
            
            // 창을 열기 위한 좌표 계산 (화면의 가운데 위치)
            var left = (screenWidth - width) / 2;
            var top = (screenHeight - height) / 2;
            
            // 새 창 열기
            var newWindow = window.open(url, name, 
                `width=${width}, height=${height}, left=${left}, top=${top}, resizable=yes, scrollbars=yes`
            );
            
            // 새 창이 열리지 않거나 다른 설정을 추가하고 싶다면, 적절히 처리
            if (!newWindow) {
                alert("새 창을 열 수 없습니다. 팝업 차단을 확인해 주세요.");
            }
        }
	
        
        function openPopup() {
            // 새 창을 여는 함수
            var url = "${pageContext.request.contextPath}/receiptView";  // 새 창에서 열 URL
            var windowName = "popupWindow";       // 창의 이름
            var windowSize = "width=600,height=500"; // 창 크기 설정

            // window.open()을 사용하여 새 창 열기
          /*   window.open(url, windowName, windowSize); */
            
            openCenteredWindow( url, 'ReceiptWindow', 600, 500);

        }
        
	</script>
	
	

</body>

</html>
