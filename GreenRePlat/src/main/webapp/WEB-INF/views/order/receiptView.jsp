<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>영수증</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

</head>



<body>

	<div class="container" id="print-content">
		<div class="w-100 ">
			<div class="d-flex justify-content-center mt-5 mb-5 border-bottom">
				<h2>구매 영수증</h2>
			</div>
			<div class="d-flex justify-content-between mt-5">
				<div>
					<span class="fw-bold">대표 주문번호</span>
				</div>
				<div>
					<span>${keyPayment.representativeOrderId}</span>
				</div>
			</div>
			<div class="d-flex justify-content-between mt-5">
				<div>
					<span class="fw-bold">주문번호</span>
				</div>
				<div>
					<span>${keyPayment.partnerOrderId}</span>
				</div>
			</div>
			<div class="d-flex justify-content-between mt-5">
				<div>
					<span class="fw-bold">거래일시</span>
				</div>
				<div>
					<span>${keyPayment.paymentDate}</span>
				</div>
			</div>
			<div class="d-flex justify-content-between mt-5">
				<div>
					<span class="fw-bold">상품명</span>
				</div>
				<div>
					<span>${keyPayment.prodName}</span>
				</div>
			</div>
			<div class="d-flex justify-content-between mt-5">
				<div>
					<span class="fw-bold">가격</span>
				</div>
				<div>
					<span>${keyPayment.prodPrice} 원</span>
				</div>
			</div>
			<div class="d-flex justify-content-between mt-5">
				<div>
					<span class="fw-bold">구매자</span>
				</div>
				<div>
					<span>${keyPayment.memId}</span>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="w-100">
			<div class="d-flex justify-content-between mt-5">
				<div>
					<button type="button" class="btn btn-link"  onclick="showPrint()">PDF 미리보기</button>
				</div>
				<div>
					<button type="button" class="btn btn-link" onclick="showPrint2()">PDF로 다운로드</button>
				</div>
			</div>
		</div>
	</div>

	
	<!--  html2canvas CDN 링크 -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
	<!-- jspdf CDN 링크 -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>

    <!-- JavaScript function for PDF generation -->
    <script>
    
	    window.onload = function() {
	        const baseUrl = "${pageContext.request.contextPath}/receiptView";
	        // 주소창의 URL을 기본 URL로 설정
	        window.history.replaceState({}, '', baseUrl);
	    };	
	
    
        function showPrint() {
            const { jsPDF } = window.jspdf;
            
            html2canvas(document.querySelector('#print-content'), {
                scale: 2 // 해상도 조정
            }).then(function (canvas) {
                let imgData = canvas.toDataURL('image/png');
                let imgWidth = 120;
                let pageHeight = imgWidth * 1.414;
                let imgHeight = canvas.height * imgWidth / canvas.width;
                let heightLeft = imgHeight;
                let margin = 45;
                let doc = new jsPDF('p', 'mm');
                let position = 10;

                window.scrollTo(0, 0);

                // 첫 페이지 출력
                doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
                heightLeft -= pageHeight;

                // 한 페이지 이상일 경우 루프 돌면서 출력
                while (heightLeft >= 20) {
                    position = heightLeft - imgHeight - 20;
                    doc.addPage();
                    doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
                    heightLeft -= pageHeight;
                }

                // PDF를 새탭으로 열기
                window.open(doc.output('bloburl'));
                
                // PDF를 바로 다운로드
                // doc.save('sample.pdf');
            });
        }
        
        function showPrint2() {
            const { jsPDF } = window.jspdf;
            
            html2canvas(document.querySelector('#print-content'), {
                scale: 2 // 해상도 조정
            }).then(function (canvas) {
                let imgData = canvas.toDataURL('image/png');
                let imgWidth = 120;
                let pageHeight = imgWidth * 1.414;
                let imgHeight = canvas.height * imgWidth / canvas.width;
                let heightLeft = imgHeight;
                let margin = 45;
                let doc = new jsPDF('p', 'mm');
                let position = 10;

                window.scrollTo(0, 0);

                // 첫 페이지 출력
                doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
                heightLeft -= pageHeight;

                // 한 페이지 이상일 경우 루프 돌면서 출력
                while (heightLeft >= 20) {
                    position = heightLeft - imgHeight - 20;
                    doc.addPage();
                    doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
                    heightLeft -= pageHeight;
                }
				
                let v_name = "${keyPayment.prodName}";
                
                // PDF를 바로 다운로드
                doc.save( v_name +'_영수증.pdf');
            });
        }
    </script>




</body>

</html>
