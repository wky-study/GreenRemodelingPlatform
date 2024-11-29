<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>견적서 입력</title>
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
				<span class="text-muted fw-light">견적서 생성 /</span> 자재
			</h4>
			<div class="row">
				<div class="col-md-12">
					<div class="card mb-4">
					
						<!-- 검색기능 -->
						<div class="d-flex justify-content-end mt-3 mb-3 me-5">
							<form class="d-flex" id="estimateForm" action="${pageContext.request.contextPath }/est2" method="GET" >
								<select class="form-select me-1" name="itemType" id="itemTypeSelect">
							        <!-- 자재 타입에 맞는 옵션을 서버에서 전달한 keyMatList에 맞춰 동적으로 생성 -->
							        <c:forEach var="MaterialDTO" items="${keyTypeList}">
							            <option value="${MaterialDTO.itemType}" ${MaterialDTO.itemType == param.itemType ? 'selected' : ''}> ${MaterialDTO.itemType}</option>
							        </c:forEach>
								</select>
								<input type="hidden" name="estId" value="${sessionScope.keyEst.estId}">
								<input type="hidden" name="estAddress" value="${sessionScope.keyEst.estAddress}">
								<input type="hidden" name="dongNm" value="${sessionScope.keyEst.dongNm}">
								<input type="hidden" name="hoNm" value="${sessionScope.keyEst.hoNm}">
								<input type="hidden" name="estSdate" value="${sessionScope.keyEst.estSdate}">
							</form>
						</div>						
					
					
						<div class="card-body my-card">
							
							<table class="table table-hover">
							  <thead>
							    <tr>
							      <th scope="col"></th>
							      <th scope="col">이름</th>
							      <th scope="col">모델명</th>
							      <th scope="col" >제조사</th>
							      <th scope="col" >등급</th>
							      <th scope="col" >타입</th>
							    </tr>
							  </thead>
							  
							  <tbody >
								<c:forEach items="${keyMatList}" var="MaterialDTO">
								    <tr onclick="receipt(this)" class="my-cursor">
								      <th scope="row"><img class="my-img" src="${MaterialDTO.itemImg}"></th>
								      <td>${MaterialDTO.itemName}</td>
								      <td>${MaterialDTO.itemModel}</td>
								      <td>${MaterialDTO.itemBrand}</td>
								      <td>${MaterialDTO.itemEffiLevel}</td>
								      <td>${MaterialDTO.itemType}</td>
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
	
	// 저장 및 다음 버튼 클릭 시
	document.getElementById('nextBtn').addEventListener('click', () => {
        window.location.href = '${pageContext.request.contextPath}/est3'; 
        alert("임시 저장되었습니다."); // 성공 시 경고창
    });	
	
	
	// 뒤로가기 버튼 클릭 시
	document.getElementById('backBtn').addEventListener('click', () => {
        window.location.href = '${pageContext.request.contextPath}/est1?estId='+ "${sessionScope.keyEst.estId}"; // est1.jsp 페이지로 이동
    });
	
    // 'itemType' select 요소의 값이 변경될 때마다 폼을 제출하는 함수
    document.getElementById('itemTypeSelect').addEventListener('change', function() {
        // 폼을 제출
        document.getElementById('estimateForm').submit();
    });
	
	</script>
</body>

</html>
