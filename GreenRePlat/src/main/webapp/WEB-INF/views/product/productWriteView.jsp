<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>제품 등록(관리자)</title>

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
				
					<div class="card-body">
					
						<form action="${pageContext.request.contextPath }/addExcel" method="POST" enctype="multipart/form-data" id="excelForm">
							<div class="mb-3">
								<label for="exampleInputtext1" class="form-label">Excel로 추가하기</label> 
								<input type="file" class="form-control"  name = "file" accept=".xlsx" >
							</div>					
							<div class="mb-3 d-flex justify-content-end">
								<button id="downloadBtn" class="btn btn-outline-success me-3" type="button">Excel 양식</button>
								<button class="btn btn-outline-success" id="excelBtn" type="button" onclick="validateAndSubmit()">Excel로 등록</button>
							</div>					
						</form>
						
						<form id="reviewWriteForm" action="${pageContext.request.contextPath }/productWriteDo" method="POST" enctype="multipart/form-data">
							<div class="mb-3">
								<label for="exampleInputtext1" class="form-label">제품명</label> 
								<input type="text" class="form-control"  name = "prodName" aria-describedby="textHelp">
							</div>
							<div class="mb-3">
								<label for="exampleInputtext1" class="form-label">모델명</label> 
								<input type="text" class="form-control" name = "prodModel" aria-describedby="textHelp">
							</div>
							<div class="mb-3">
								<label for="exampleInputtext1" class="form-label">업체명</label> 
								<input type="text" class="form-control" name = "prodCompany" aria-describedby="textHelp">
							</div>
							<div class="mb-3">
								<label for="exampleInputtext1" class="form-label">제조원</label> 
								<input type="text" class="form-control" name = "prodManufacturer" aria-describedby="textHelp">
							</div>
							<div class="mb-3">
								<label for="exampleInputtext1" class="form-label">에너지효율</label> 
								<input type="text" class="form-control" name = "prodEfficiency" aria-describedby="textHelp">
							</div>
							<div class="mb-3">
								<label for="exampleInputtext1" class="form-label">상품가격</label> 
								<input type="text" class="form-control" name = "prodPrice" aria-describedby="textHelp">
							</div>
							<div class="mb-3">
								<label for="exampleInputtext1" class="form-label">상품 분류</label> 
							</div>
							<div class="mb-3">
								<select class="form-select me-1" name="prodType">
									<option value="가정용가스보일러" selected>가정용가스보일러</option>
									<option value="김치냉장고">김치냉장고</option>
									<option value="공기청정기">공기청정기</option>
									<option value="냉온수기">냉온수기</option>
									<option value="냉온수기(순간)">냉온수기(순간)</option>
									<option value="냉장고">냉장고</option>
									<option value="드럼세탁기">드럼세탁기</option>
									<option value="상업용냉장고">상업용냉장고</option>
									<option value="의류건조기">의류건조기</option>
									<option value="일반세탁기">일반세탁기</option>
									<option value="전깁밥솥">전기밥솥</option>
									<option value="진공청소기">진공청소기</option>
								</select>
							</div>
							
							<div class="mb-3">
							    <label class="form-label" for="imageUpload">이미지 업로드 (500 * 500 권장)</label>
							    <input class="form-control" type="file" id="imageUpload" name="imgFile" accept="image/*" required multiple>							
							</div>
							
							<div class="d-flex justify-content-end">
								<a class="btn btn-secondary me-2" href="${pageContext.request.contextPath }/productView">취소</a>
								
								<!-- form 태그의 submit 역할을 함 -> type=submit 넣어주기 -->
								<button id="writeBtn" class="btn btn-primary" type="submit">등록</button>
							</div>
							
						</form>				
					</div>
				</div>
			</div>




		</div>
	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>


	<script type="text/javascript">
	
	
	/* 엑셀 양식 다운로드 */
	   document.getElementById('downloadBtn').addEventListener('click', function() {
		   
	        var xhr = new XMLHttpRequest();
	        xhr.open('GET', '${pageContext.request.contextPath}/downloadProdExcel', true);
	        xhr.responseType = 'blob'; // 응답을 blob(파일) 형태로 받음
	        xhr.onload = function() {
	            if (xhr.status === 200) {
	                var blob = xhr.response;
	                var link = document.createElement('a');
	                link.href = URL.createObjectURL(blob);
	                link.download = '제품등록_양식.xlsx';  // 다운로드할 파일명 설정
	                link.click(); // 파일 다운로드 트리거
	            }
	        };
	        xhr.send();
	    });		
	
	
	   function validateAndSubmit() {
		    var fileInput = document.querySelector('input[name="file"]');
		    var file = fileInput.files[0];  // 선택한 파일

		    // 파일이 선택되지 않은 경우
		    if (!file) {
		        alert("엑셀 파일을 선택해주세요.");
		        return;  // 폼 제출을 중단
		    }

		    // 파일 확장자가 .xlsx가 아닌 경우
		    var fileName = file.name;
		    if (!fileName.endsWith(".xlsx")) {
		        alert("엑셀 파일(.xlsx)만 업로드 가능합니다.");
		        return;  // 폼 제출을 중단
		    }

		    // 파일이 유효하면 폼 제출
		    document.getElementById("excelForm").submit(); // 폼 제출
		}
	
	</script>
	
	
	
	

</body>

</html>
