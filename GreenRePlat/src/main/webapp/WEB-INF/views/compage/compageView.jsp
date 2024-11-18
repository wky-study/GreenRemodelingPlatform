<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>리뷰 게시판</title>

<!-- Libraries Stylesheet -->
<link
	href="${pageContext.request.contextPath }/assets/libs/animate/animate.min.css" />
<link
	href="${pageContext.request.contextPath }/assets/libs/lightbox/css/lightbox.min.css" />
<link
	href="${pageContext.request.contextPath }/assets/libs/owlcarousel/assets/owl.carousel.min.css" />

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
	
		<!-- 시공사진 슬라이드 -->
		<div class="col-lg-8">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title d-flex align-items-center gap-2 mb-4">
						시공사례</h5>
					<div id="carouselExampleControls"
						class="carousel slide carousel-dark" data-bs-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item">
								<img
									src="${pageContext.request.contextPath}/assets/images/material/오늘의집01.png"
									class="d-block w-100" alt="seodash-img">
							</div>
							<div class="carousel-item active">
								<img
									src="${pageContext.request.contextPath}/assets/images/material/오늘의집02.png"
									class="d-block w-100" alt="seodash-img">
							</div>
							<div class="carousel-item">
								<img
									src="${pageContext.request.contextPath}/assets/images/material/오늘의집03.png"
									class="d-block w-100" alt="seodash-img">
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleControls"
							role="button" data-bs-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="visually-hidden">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleControls"
							role="button" data-bs-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="visually-hidden">Next</span>
						</a>
					</div>
				</div>
			</div>
		</div>

		<div class="card">

			<div class="card-body">
				<div
					class="col-md-4 d-flex my-card-box w-100 justify-content-between">
					<!-- 카드 그리기 -->

					<c:forEach items="${keyCp}" var="ReviewDTO">
						<div class="card my-card shadow-sm"
							onclick='window.location.href = "${pageContext.request.contextPath }/compageDetailView?no=${ReviewDTO.cpNo}"'>
							<img
								src="${pageContext.request.contextPath }/displayImage?fileName=${ReviewDTO.cpPath}"
								class="card-img-top">
							<div class="card-body">
								<h5 class="card-title">${ReviewDTO.cpTitle}</h5>
								<p class="card-text">${ReviewDTO.memName}</p>
								<span class="fw-bold">${ReviewDTO.cpDate}</span>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<!-- 페이징 시작 -->
			<div class="d-flex justify-content-center">
				<nav aria-label="Page navigation example">
					<ul class="pagination">

						<!-- 검색중이면 검색옵션과 검색어를 유지하면서 페이징 처리 -->
						<!-- 검색중이지 않으면 검색 옵션과 검색어가 주소창에 나타나지 않게 하기 -->
						<!-- searchWord가 null이면 a태그의 href에서 searchOption 과 searchWord 떼어내기 -->

						<!-- 이전 페이지 -->
						<li
							class="page-item ${keySearch.firstPage == 1 ? 'disabled' : '' }">

							<c:if test="${keySearch.searchWord != null}">
								<a class="page-link"
									href="${pageContext.request.contextPath }/compageView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a>
							</c:if> <c:if test="${keySearch.searchWord == null}">
								<a class="page-link"
									href="${pageContext.request.contextPath }/compageView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a>
							</c:if>

						</li>

						<!-- 중간 페이지 번호 부분 -->
						<!-- model에 keySearch 이름으로 searchVO를 담음 -->
						<!-- searchVO 내 pageNo, firstPage, lastPage 채워져있음 -->

						<c:forEach begin="${keySearch.firstPage }"
							end="${keySearch.lastPage }" var="num">
							<li
								class="page-item ${keySearch.pageNo == num ? 'active' : '' } ">
								<c:if test="${keySearch.searchWord != null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/compageView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}">${num }</a>
								</c:if> <c:if test="${keySearch.searchWord == null}">
									<a class="page-link"
										href="${pageContext.request.contextPath }/compageView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}">${num }</a>
								</c:if>
							</li>
						</c:forEach>

						<!-- 다음 페이지 -->
						<!-- 마지막 페이지 도달 시 disabled 추가 -->
						<li
							class="page-item ${keySearch.pageNo == keySearch.finalPage ? 'disabled' : ''  }">
							<c:if test="${keySearch.searchWord == null}">
								<a class="page-link"
									href="${pageContext.request.contextPath }/compageView?pageNo=${keySearch.lastPage + 1 }&rowSizePerPage=${keySearch.rowSizePerPage}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a>
							</c:if> <c:if test="${keySearch.searchWord != null}">
								<a class="page-link"
									href="${pageContext.request.contextPath }/compageView?pageNo=${keySearch.lastPage + 1 }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a>
							</c:if>
						</li>

					</ul>
				</nav>
			</div>

			<!-- 글쓰기 버튼 -->
			<div class="d-flex justify-content-end me-5 my-write-btn">
				<button id="writeBtn" class="btn btn-outline-secondary">글쓰기</button>
			</div>


			<!-- 검색기능 -->
			<div class="d-flex justify-content-center mb-3">
				<form class="d-flex"
					action="${pageContext.request.contextPath }/compageView"
					method="GET">
					<select class="form-select me-1" name="searchOption">
						<option value="title" selected>제목</option>
						<option value="content">내용</option>
						<option value="name">작성자</option>
					</select> <input class="form-control me-1" type="text" name="searchWord">
					<button class="btn btn-outline-primary" type="submit">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
						  <path
								d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
						</svg>
					</button>
				</form>
			</div>

		</div>





	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script type="text/javascript">
	    window.onload = function() {
	        const baseUrl = "${pageContext.request.contextPath}/compageView";
	        // 주소창의 URL을 기본 URL로 설정
	        window.history.replaceState({}, '', baseUrl);
	    };	
	</script>


	<script type="text/javascript">
	
	let v_search = '${keySearch.searchWord}';
	
	function f_change() {
		console.log(event.target);
		console.log(event.target.value);
		
		let v_url = "${pageContext.request.contextPath}/compageView";
		let v_query = "?rowSizePerPage=" + event.target.value;
			v_query += "&pageNo=${keySearch.pageNo}";
		
		if(v_search){
			v_query += "&searchOption=${keySearch.searchOption}";
			v_query += "&searchWord=${keySearch.searchWord}";
		}
			
		
		location.href = v_url + v_query;
	}	
	
	/* 끝으로 이동 */
	let v_aTagBtn = document.getElementById("aTagBtn");
	v_aTagBtn.addEventListener("click", ()=>{
		
	     let v_searchWord = '${keySearch.searchWord}';
	     let v_lastPage = '${keySearch.lastPage}';
	     let v_rowSizePerPage = '${keySearch.rowSizePerPage}';
	     console.log(v_searchWord);
	     console.log(v_lastPage);
	     console.log(v_rowSizePerPage);
	     
	     if(v_searchWord == "" ){
	    	 if(v_lastPage % 10 != 0){
	    		 v_aTagBtn.href = "${pageContext.request.contextPath }/compageView?pageNo=${keySearch.lastPage}";
	    	 }else if(v_lastPage % 10 == 0){
	    		 v_aTagBtn.href = "${pageContext.request.contextPath }/compageView?pageNo=${keySearch.lastPage + 1}";
	    	 }
	     }else if(v_searchWord != ""){
	    	 if(v_lastPage % 10 != 0){
	    		 v_aTagBtn.href = "${pageContext.request.contextPath }/compageView?pageNo=${keySearch.lastPage}&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}";
	    	 }else if(v_lastPage % 10 == 0){
	    		 v_aTagBtn.href = "${pageContext.request.contextPath }/compageView?pageNo=${keySearch.lastPage + 1}&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}";
	    	 }
	     }
		
	})	
	
	
		/* 인풋태그 엔터 입력시 반응 */
		let v_searchButton = document.getElementById("searchButton");
		
		document.addEventListener("keydown", ()=>{
			if (event.key === "Enter"){
				v_searchButton.click();
			}
			
		})
		
		let v_searchForm = document.getElementById("searchForm");
			
		/* 검색 버튼 클릭 */
		v_searchButton.addEventListener("click", ()=>{
			
			v_searchForm.submit();
		
	})	
	
	document.getElementById("writeBtn").addEventListener("click", ()=>{
		
		document.getElementById("writeBtn").submit();
		
	});
	
	
	
	</script>

	<!-- 글 작성 script -->
	<script type="text/javascript">
	
		let v_id = '${sessionScope.memInfo.memId}';
		
		document.getElementById("writeBtn").addEventListener("click", ()=>{
			
			location.href = '${pageContext.request.contextPath }/compageWriteView';
			
			if(v_id){
				location.href = '${pageContext.request.contextPath }/compageWriteView';
			}
			else{
				alert("로그인 후 글쓰기가 가능합니다.");
				location.href = '${pageContext.request.contextPath}/loginView';
			} 
			
		})
	</script>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/libs/wow/wow.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/libs/owlcarousel/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/libs/js/lightbox.min.js"></script>
		
</body>

</html>
