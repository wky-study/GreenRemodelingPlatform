<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html lang="ko">

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

/*확대될 이미지*/
.target {
	display: block;
	width: 100%;
}

/*돋보기*/
.magnifier {
	z-index: 1000; /*높은 값 설정*/
	width: 200px;
	height: 200px;
	position: absolute;
	border-radius: 100%;
	box-shadow: 0 0 0 3px rgba(255, 255, 255, 0.85), 0 0 3px 3px
		rgba(0, 0, 0, 0.25);
	display: none;
}

.wrap {
	position: relative;
	width: 500px;
	height: 500px;
	margin: 0 auto;
}

.img-border {
	position: relative;
	height: 100%;
	min-height: 400px;
}

.img-border::before {
	position: absolute;
	content: "";
	top: 3rem;
	left: 0;
	right: 3rem;
	bottom: 0;
	border: 5px solid #2952ff;
}

.img-border img {
	position: absolute;
	top: 0;
	left: 3rem;
	width: calc(100% - 3rem);
	height: calc(100% - 3rem);
	object-fit: scale-down;
	background-color: white;
}
</style>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>자재상세페이지</title>

<!-- Libraries Stylesheet -->
<link
	href="${pageContext.request.contextPath}/assets/libs/animate/animate.min.css"
	rel="stylesheet" />

</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<!-- 자재상세페이지 자재사진 -->
	<div class="container-fluid mb-5">
		<div class="container-xxl py-5">
			<div class="container">
				<div class="row g-5">
					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
						<div class="img-border">
							<div class="wrap">
								<img class="target" src="${keyMaterial.itemImg}" data-zoom="2" />
							</div>
						</div>
					</div>

					<!-- 자재 상세 정보 -->
					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>자재이름 :
							${keyMaterial.itemName}
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>모델명 :
							${keyMaterial.itemModel}
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>제조사 :
							${keyMaterial.itemBrand}
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>자재크기 :
							${keyMaterial.itemSize}
						</h5>
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>에너지효율등급 :
							${keyMaterial.itemEffiLevel}등급
						</h5>

						<!-- 수량 선택 및 가격 표시 -->
						<h5 class="mb-3">
							<i class="far fa-check-circle text-primary me-3"></i>수량 <input
								type="number" id="quantity" value="1" min="1"
								onchange="updateTotalPrice(10000)"
								style="width: 60px; margin-left: 10px;"> <a
								class="badge text-bg-light text-dark">수량을선택해주세요</a>
						</h5>

						<!-- 견적버튼 -->
						<a class="btn btn-primary py-3 px-5 mt-3" href="">견적서 담기</a>
					</div>
				</div>

			</div>
		</div>

	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>


	<!-- 스크립트들 -->
	<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
		class="bi bi-arrow-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/libs/wow/wow.min.js"></script>

	<!-- Template Javascript -->
	<script src="${pageContext.request.contextPath}/assets/js/material.js"></script>

	<!-- 이미지 돋보기 스크립트 -->
	<script>
	
		var target = $('.target');
		
		var zoom = target.data('zoom');
	
		$('.wrap')
			.on('mousemove', magnify)
			.prepend("<div class='magnifier'></div>")
			.children('.magnifier').css({
				"background": "url('" + target.attr("src") + "') no-repeat",
				"background-size": target.width() * zoom + "px " + target.height() * zoom+ "px"
			});
		

		var magnifier = $('.magnifier');
		
		function magnify(e) {
			
			// 실제 마우스 좌표에서 컨테이너(div.wrap) 위치를 차감해 컨테이너 안쪽에서의 마우스 좌표를 얻음
			var mouseX = e.pageX - $(this).offset().left;
			var mouseY = e.pageY - $(this).offset().top;
			
			// 컨테이너 안에 마우스가 있으면 div.magnifier를 드러나게 하고, 벗어나면 감춤
			if (mouseX < $(this).width() && mouseY < $(this).height() && mouseX > 0 && mouseY > 0) {
				magnifier.fadeIn(100);
			} else {
				magnifier.fadeOut(100);
			}
			
			// div.magnifier가 드러나 있으면
			if (magnifier.is(":visible")) {
				
				// img.target 위에 위치한 마우스 위치를 기준으로 하여 본래 이미지 크기에 대한 마우스 좌표를 얻음
				var rx = -(mouseX * zoom - magnifier.width() / 2);
				var ry = -(mouseY * zoom - magnifier.height() / 2);
				
				// div.magnifier를 마우스 가운데 위치시키기 위해 width, height 절반을 차감
				var px = mouseX - magnifier.width() / 2;
				var py = mouseY - magnifier.height() / 2;
				
				// 적용
				magnifier.css({
					left: px,
					top: py,
					backgroundPosition: rx + "px " + ry + "px"
				});
			}
		}
	</script>

</body>

</html>

