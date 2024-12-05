<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SeoDash Free Bootstrap Admin Template by Adminmart</title>


<style>
.carousel-inner img {
    height: 100%; /* 고정 높이 설정 */
    object-fit: cover; /* 이미지 비율을 유지하며 컨테이너에 맞춤 */
}

.card-image-container {
    position: relative;
}

.card-title-overlay {
    position: absolute;
    bottom: 10px;
    left: 10px;
    color: white;
    font-weight: bold;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* 텍스트에 그림자 추가 */
}

</style>


</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">

		<div class="card">
			<div class="card-body">

				<div class="w-100 ">
					<h3>오늘의 PICK</h3>
				</div>

				<div class="col-md-4 d-flex w-100">
				    <div class="card w-75">
				        <div class="card-body" style="cursor:pointer;" onclick='window.location.href = "${pageContext.request.contextPath }/reviewDetailView?no=${reviewList[0].reviewNo}"'>
				            <div class="card-image-container">
				                <img class="card-img-top img-responsive mb-5" src="${pageContext.request.contextPath }/displayImage?fileName=${reviewList[0].reviewPath}" >
				                <h4 class="card-title card-title-overlay">${reviewList[0].reviewTitle}</h4>
				            </div>
				        </div>
				    </div>
				    <div class="card w-25">
			            <div style="height: 25px;"></div>
				        <div class="mb-3 h-50" style="cursor:pointer;" onclick='window.location.href = "${pageContext.request.contextPath }/reviewDetailView?no=${reviewList[1].reviewNo}"'>
				            <div class="card-image-container h-100">
				                <img class="card-img img-responsive h-100" src="${pageContext.request.contextPath }/displayImage?fileName=${reviewList[1].reviewPath}" >
				            </div>
				        </div>
				        <div class=" h-50" style="cursor:pointer;" onclick='window.location.href = "${pageContext.request.contextPath }/reviewDetailView?no=${reviewList[2].reviewNo}"'>
				            <div class="card-image-container h-100">
				                <img class="card-img img-responsive h-100" src="${pageContext.request.contextPath }/displayImage?fileName=${reviewList[2].reviewPath}" >
				            </div>
				        </div>
				    </div>
				</div>
				
				<!-- 중간부분 시작 -->
				<div class="col-md-4 d-flex w-100 ">

					<div class="card w-50">
						<div class="card-body">
							<h5 class="card-title d-flex align-items-center gap-2 mb-4"> 오늘의 추천</h5>
							<div id="carouselExampleControls"
								class="carousel slide carousel-dark" data-bs-ride="carousel">
								<div class="carousel-inner">
									<div class="carousel-item">
										<a target="_blank" href="https://blog.naver.com/PostView.naver?blogId=greenremodeling2&logNo=223339651078&categoryNo=10&parentCategoryNo=&from=thumbnailList&photoView=0">
											<img src="${pageContext.request.contextPath}/assets/images/blog/img1.jpg" class="d-block w-100" alt="seodash-img">
										</a> 
									</div>
									<div class="carousel-item active">
										<a target="_blank" href="https://blog.naver.com/PostView.naver?blogId=greenremodeling2&logNo=223229850360&categoryNo=10&parentCategoryNo=&from=thumbnailList">
											<img src="${pageContext.request.contextPath}/assets/images/blog/img3.jpg" class="d-block w-100" alt="seodash-img">
										</a> 
									</div>
									<div class="carousel-item">
										<a target="_blank" href="https://blog.naver.com/PostView.naver?blogId=greenremodeling2&logNo=223316170694&categoryNo=10&parentCategoryNo=&from=thumbnailList">
											<img src="${pageContext.request.contextPath}/assets/images/blog/img2.jpg" class="d-block w-100" alt="seodash-img">
										</a>
									</div>
								</div>
								<a class="carousel-control-prev" href="#carouselExampleControls"
									role="button" data-bs-slide="prev"> <span
									class="carousel-control-prev-icon" aria-hidden="true"></span> <span
									class="visually-hidden">Previous</span>
								</a> <a class="carousel-control-next"
									href="#carouselExampleControls" role="button"
									data-bs-slide="next"> <span
									class="carousel-control-next-icon" aria-hidden="true"></span> <span
									class="visually-hidden">Next</span>
								</a>
							</div>
						</div>
					</div>

					<div class="card w-50">
						<div class="card-body">
							<h5 class="card-title d-flex align-items-center gap-2 mb-4">그린 리모델링 소개</h5>
							<img class="card-img-top img-responsive mb-5" src="http://www.cenews.co.kr/news/photo/202010/10229_6425_024.png" alt="Card image cap">
							<h4 class="card-title mb-2">그린 리모델링으로 삶을 더 가치있게</h4>
							<p class="card-text mb-5">에코빌더스는 주거공간의 탄소중립을 지향합니다. 그린 리모델링으로 에너지비용을 절약하고, 더 깨끗한 지구를 만드세요. 에코빌더스가 함께합니다.</p>
							<a href="${pageContext.request.contextPath}/introductionView" class="btn btn-primary">그린 리모델링 소개</a>
						</div>
					</div>
				</div>
				<!-- 중간부분 끝 -->
				
				
				<div class="col-md-4 d-flex w-100 justify-content-between">
					<!-- 공지사항 시작 -->
					<div class="w-50">
						<div class="mb-4 d-flex justify-content-center">
							<h4 class="card-title mb-0">공지사항</h4>
						</div>

						<table class="table text-nowrap align-middle mb-0">
							<thead>
								<tr class="border-2 border-bottom border-primary border-0">
									<th scope="col" class="ps-0">글번호</th>
									<th scope="col">제목</th>
									<th scope="col" class="text-center">작성자</th>
									<th scope="col" class="text-center">조회수</th>
								</tr>
							</thead>
							<tbody class="table-group-divider">
								<c:forEach var="notice" items="${notices}">

									<tr>
										<th scope="row" class="ps-0 fw-medium"><span
											class="table-link1 text-truncate d-block">${notice.noticeNo}</span>
										</th>
										<td><a
											href="${pageContext.request.contextPath }/noticeDetailView?no=${notice.noticeNo}"
											class="link-primary text-dark fw-medium d-block">${notice.noticeTitle}</a>
										</td>
										<td class="text-center fw-medium">${notice.memId }</td>
										<td class="text-center fw-medium">${notice.noticeCount}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- 공지사항 끝 -->
					<!-- FAQ 시작 -->
					<div class="w-50">
						<div class="mb-4 d-flex justify-content-center">
							<h4 class="card-title mb-0">FAQ</h4>
						</div>

						<div class="accordion accordion-flush" id="accordionFlushExample">
							<div class="accordion-item">
								<h2 class="accordion-header" id="flush-headingOne">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
										aria-expanded="false" aria-controls="flush-collapseOne">
										Accordion Item #1</button>
								</h2>
								<div id="flush-collapseOne" class="accordion-collapse collapse"
									aria-labelledby="flush-headingOne"
									data-bs-parent="#accordionFlushExample" style="">
									<div class="accordion-body">Anim pariatur cliche
										reprehenderit, enim eiusmod high life accusamus terry
										richardson ad squid. 3 wolf moon officia aute, non cupidatat
										skateboard dolor brunch. Food truck quinoa nesciunt laborum
										eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on
										it squid single-origin coffee nulla assumenda shoreditch et.
										Nihil anim keffiyeh helvetica, craft beer labore wes anderson
										cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
										vice lomo. Leggings occaecat craft beer farm-to-table, raw
										denim aesthetic synth nesciunt you probably haven't heard of
										them accusamus labore sustainable VHS.</div>
								</div>
							</div>
							<div class="accordion-item">
								<h2 class="accordion-header" id="flush-headingTwo">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo"
										aria-expanded="false" aria-controls="flush-collapseTwo">
										Accordion Item #2</button>
								</h2>
								<div id="flush-collapseTwo" class="accordion-collapse collapse"
									aria-labelledby="flush-headingTwo"
									data-bs-parent="#accordionFlushExample" style="">
									<div class="accordion-body">Anim pariatur cliche
										reprehenderit, enim eiusmod high life accusamus terry
										richardson ad squid. 3 wolf moon officia aute, non cupidatat
										skateboard dolor brunch. Food truck quinoa nesciunt laborum
										eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on
										it squid single-origin coffee nulla assumenda shoreditch et.
										Nihil anim keffiyeh helvetica, craft beer labore wes anderson
										cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
										vice lomo. Leggings occaecat craft beer farm-to-table, raw
										denim aesthetic synth nesciunt you probably haven't heard of
										them accusamus labore sustainable VHS.</div>
								</div>
							</div>
							<div class="accordion-item">
								<h2 class="accordion-header" id="flush-headingThree">
									<button class="accordion-button collapsed" type="button"
										data-bs-toggle="collapse"
										data-bs-target="#flush-collapseThree" aria-expanded="false"
										aria-controls="flush-collapseThree">Accordion Item #3</button>
								</h2>
								<div id="flush-collapseThree"
									class="accordion-collapse collapse"
									aria-labelledby="flush-headingThree"
									data-bs-parent="#accordionFlushExample">
									<div class="accordion-body">Anim pariatur cliche
										reprehenderit, enim eiusmod high life accusamus terry
										richardson ad squid. 3 wolf moon officia aute, non cupidatat
										skateboard dolor brunch. Food truck quinoa nesciunt laborum
										eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on
										it squid single-origin coffee nulla assumenda shoreditch et.
										Nihil anim keffiyeh helvetica, craft beer labore wes anderson
										cred nesciunt sapiente ea proident. Ad vegan excepteur butcher
										vice lomo. Leggings occaecat craft beer farm-to-table, raw
										denim aesthetic synth nesciunt you probably haven't heard of
										them accusamus labore sustainable VHS.</div>
								</div>
							</div>
						</div>
					</div>
					<!-- FAQ 끝 -->
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/inc/footer.jsp"%>
</body>

</html>
