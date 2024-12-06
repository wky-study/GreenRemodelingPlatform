<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>

</head>



<style>
.my-card-box {
	flex-wrap: wrap;
}

.my-card {
	width: calc(100%/ 5 + 2px);
	cursor: pointer;
}
</style>


<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">

			<div class="card-body">

				<div
					class="col-md-4 d-flex my-card-box w-100 justify-content-between"
					id="cardContainer">
					<!-- 카드 그리기 -->
				</div>
				<div id="pagination-container"
					class="d-flex justify-content-center mt-3">
					<ul class="pagination">
					</ul>
				</div>
			</div>

		</div>
		<!-- 검색기능 -->
	</div>





	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script type="text/javascript">
	    window.onload = function() {
	        const baseUrl = "${pageContext.request.contextPath}/productView";
	        // 주소창의 URL을 기본 URL로 설정
	        window.history.replaceState({}, '', baseUrl);
	    };	
	</script>


	<script type="text/javascript">

    function getProducts() {
    	
        fetch('${pageContext.request.contextPath}/getProducts', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ memId: null })
        })
        .then(response => response.json())
        .then(data => {
        	console.log(data);
        	setupPagination(data);
        })
        .catch(error => {
            console.error('Error:', error);
            document.getElementById("idCheckResult").textContent = "서버와의 통신에 오류가 발생했습니다.";
            document.getElementById("idCheckResult").style.color = "red";
        });
    }
    function makeView(productArray){
    	console.log("inMakeView: ",productArray);
    	cardCon = document.getElementById("cardContainer");
    	cardCon.innerHTML = '';
    	for(var i = 0; i<productArray.length; i++){
    		 var product = productArray[i];

             // div 요소 생성
             var cardDiv = document.createElement('div');
             cardDiv.classList.add('card', 'my-card', 'shadow-sm');
             cardDiv.onclick = function() {
                 // onclick 이벤트 핸들러
                 window.location.href = '${pageContext.request.contextPath}/productDetailView?no=' + product.prodNo;
             };

             // 이미지 요소 생성
             var imgElement = document.createElement('img');
             imgElement.src = product.prod_image_src;
             imgElement.classList.add('card-img-top');
             imgElement.style.height = '200.59px';

             // card body div 생성
             var cardBodyDiv = document.createElement('div');
             cardBodyDiv.classList.add('card-body');

             // 제목 (h5) 요소 생성
             var titleElement = document.createElement('h5');
             titleElement.classList.add('card-title');
             titleElement.textContent = product.prod_name;

             // 모델 (p) 요소 생성
             var modelElement = document.createElement('p');
             modelElement.classList.add('card-text');
             modelElement.textContent = product.prod_model;

             // 가격 (span) 요소 생성
             var priceElement = document.createElement('span');
             priceElement.classList.add('fw-bold');
             priceElement.textContent = product.prod_price + "원";

             // card body에 제목, 모델, 가격 추가
             cardBodyDiv.appendChild(titleElement);
             cardBodyDiv.appendChild(modelElement);
             cardBodyDiv.appendChild(priceElement);

             // card div에 이미지와 card body 추가
             cardDiv.appendChild(imgElement);
             cardDiv.appendChild(cardBodyDiv);

             // 생성된 cardDiv를 container에 추가
             cardCon.appendChild(cardDiv);
    	}
    }
    
    function setupPagination(products) {
        const itemsPerPage = 16;  // 한 페이지에 표시할 상품 수
        const totalPages = Math.ceil(products.length / itemsPerPage);  // 총 페이지 수
        const paginationContainer = document.getElementById('pagination-container');
        paginationContainer.innerHTML = ''; // 기존 페이지네이션 비우기

        // 페이지네이션에서 한 번에 보여줄 페이지 번호 개수
        const pageGroupSize = 10;

        // 페이지 범위 계산 (현재 페이지 그룹 시작과 끝)
        let currentPageGroupStart = 1;
        let currentPageGroupEnd = Math.min(pageGroupSize, totalPages);
        
        // 현재 페이지 추적
        let currentPage = 1;

        // 페이지 번호 생성
        function createPageLink(page) {
            const pageItem = document.createElement('li');
            pageItem.classList.add('page-item');
            
            const pageLink = document.createElement('a');
            pageLink.classList.add('page-link');
            pageLink.href = '#';
            pageLink.textContent = page;

            // 현재 페이지에 볼드체 스타일 적용
            if (page === currentPage) {
                pageLink.style.fontWeight = 'bold';
            }

            // 페이지 클릭 이벤트
            pageLink.onclick = function () {
                currentPage = page;  // 클릭한 페이지로 업데이트
                displayPage(products, page, itemsPerPage);
                updatePagination(page);
            };

            pageItem.appendChild(pageLink);
            paginationContainer.appendChild(pageItem);
        }

        // 페이지 그룹에 맞는 페이지 번호 생성
        function generatePageLinks(start, end) {
            paginationContainer.innerHTML = ''; // 기존 페이지네이션 비우기
            // 이전 그룹으로 이동
            if (currentPageGroupStart > 1) {
                const prevGroup = document.createElement('li');
                prevGroup.classList.add('page-item');
                const prevLink = document.createElement('a');
                prevLink.classList.add('page-link');
                prevLink.href = '#';
                prevLink.textContent = '<<';
                prevLink.onclick = function() {
                    currentPageGroupStart -= pageGroupSize;
                    currentPageGroupEnd -= pageGroupSize;
                    if (currentPageGroupEnd > totalPages) currentPageGroupEnd = totalPages;
                    updatePagination(currentPageGroupStart);
                };
                prevGroup.appendChild(prevLink);
                paginationContainer.appendChild(prevGroup);
            }

            // 페이지 링크 생성
            for (let page = start; page <= end; page++) {
                if (page <= totalPages) {
                    createPageLink(page);
                }
            }

            // 다음 그룹으로 이동
            if (currentPageGroupEnd < totalPages) {
                const nextGroup = document.createElement('li');
                nextGroup.classList.add('page-item');
                const nextLink = document.createElement('a');
                nextLink.classList.add('page-link');
                nextLink.href = '#';
                nextLink.textContent = '>>';
                nextLink.onclick = function() {
                    currentPageGroupStart += pageGroupSize;
                    currentPageGroupEnd += pageGroupSize;
                    if (currentPageGroupEnd > totalPages) currentPageGroupEnd = totalPages;
                    updatePagination(currentPageGroupStart);
                };
                nextGroup.appendChild(nextLink);
                paginationContainer.appendChild(nextGroup);
            }
        }

        // 페이지 변경 시 페이지네이션 업데이트
        function updatePagination(page) {
            currentPage = page;
            const totalPages = Math.ceil(products.length / itemsPerPage);
            currentPageGroupStart = Math.floor((currentPage - 1) / pageGroupSize) * pageGroupSize + 1;
            currentPageGroupEnd = Math.min(currentPageGroupStart + pageGroupSize - 1, totalPages);
            generatePageLinks(currentPageGroupStart, currentPageGroupEnd);
        }

        // 초기 페이지 설정
        displayPage(products, 1, itemsPerPage);
        updatePagination(1);
    }



    // 특정 페이지에 맞는 데이터 표시
    function displayPage(products, pageNumber, itemsPerPage) {
        const startIndex = (pageNumber - 1) * itemsPerPage;
        const endIndex = startIndex + itemsPerPage;
        const pageData = products.slice(startIndex, endIndex);

        makeView(pageData);  // 페이지에 맞는 상품 표시
    }
    
    
    window.onload = function() {
        getProducts(); // 페이지 로드 후 자동으로 호출
    };
	
	</script>

</body>

</html>
