<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>견적서 입력</title>

<!-- jquery (AJAX 통신) -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

</head>

<style>
	.my-card-box {
		flex-wrap: wrap;
	}
	
	.my-card {
		width: 100%;
		height: 500px;
		overflow-y: auto;
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
	<!--  Header End -->

	<!-- Content wrapper -->
	<div class="container-fluid">
		<!-- Content -->
		<div class="container-xxl flex-grow-1 container-p-y">
			<h4 class="fw-bold py-3 mb-4">
				<span class="text-muted fw-light">견적서 생성 /</span> 시공사 선택
			</h4>
			<div class="row">
				<div class="col-md-12">
					<div class="card mb-4">
					
					
					
						<div class="card-body my-card">
							
							<table class="table table-hover">
							  <thead>
							    <tr>
							      <th scope="col"></th>
							      <th scope="col"></th>
							      <th scope="col"></th>
							      <th scope="col" ></th>
							      <th scope="col" >시공사명</th>
							      <th scope="col" >선택</th>
							    </tr>
							  </thead>
							  
							  <tbody >
<%-- 								<c:forEach items="${keyMatList}" var="MaterialDTO">
								    <tr onclick="receipt(this)" class="my-cursor">
								      <th scope="row"><img class="my-img" src="${MaterialDTO.itemImg}"></th>
								      <td>${MaterialDTO.itemName}</td>
								      <td>${MaterialDTO.itemModel}</td>
								      <td>${MaterialDTO.itemBrand}</td>
								      <td>${MaterialDTO.itemEffiLevel}</td>
								      <td>${MaterialDTO.itemType}</td>
								    </tr>
							    </c:forEach> --%>	
								<c:forEach items="${keyComList}" var="MemberDTO">
								    <tr  class="my-cursor">
								      <th scope="row"><img class="my-img" src="${MemberDTO.memImg}"></th>
								      <td></td>
								      <td></td>
								      <td></td>
								      <td>${MemberDTO.memName}</td>
								      <td><input type="radio" name="selectedCompany" value="${MemberDTO.memName}"></td>
								    </tr>
							    </c:forEach>	
							    
							  </tbody>
							  
							</table>							
							

						</div>
						<div class="mt-2 mb-3 d-flex justify-content-end">
							<button id="backBtn" type="button" class="btn btn-primary me-2">이전으로</button>
							<button id="nextBtn" type="button" class="btn btn-primary me-2">임시저장 및 다음</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<%@ include file="/WEB-INF/inc/footer.jsp"%>
	
	<script type="text/javascript">
	
	document.getElementById('nextBtn').addEventListener('click', () => {
	    // 선택된 라디오 버튼을 가져오기
	    const selectedRadio = document.querySelector('input[name="selectedCompany"]:checked');
	    if (!selectedRadio) {
	        alert("시공사를 선택해주세요.");
	        return;
	    }

	    const memName = selectedRadio.value; // 선택된 시공사명

	    alert("시공사가 저장되었습니다.");
	    window.location.href = '${pageContext.request.contextPath}/est3?memName=' + memName;
	});
	
	
	// 뒤로가기 버튼 클릭 시
	document.getElementById('backBtn').addEventListener('click', () => {
        window.location.href = '${pageContext.request.contextPath}/est1?estId='+ "${sessionScope.keyEst.estId}"; // est1.jsp 페이지로 이동
    });
	
	
	</script>
</body>

</html>
