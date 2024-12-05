<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>견적서 입력</title>

    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">


</head>

<body>
	<%@ include file="/WEB-INF/inc/header.jsp"%>
	<!--  Header End -->

	<!-- Content wrapper -->
	<div class="container-fluid">
		<!-- Content -->
		<div class="container-xxl flex-grow-1 container-p-y">
			<h4 class="fw-bold py-3 mb-4">
				<span class="text-muted fw-light">견적서 생성 /</span> 도면 및 설명
			</h4>
			<div class="row">
				<div class="col-md-12">
					<div class="card mb-4">
					
						<div class="card-body my-card">
							
							<form id="estimateForm" enctype="multipart/form-data">
							
								
								<div class="mb-3 col-md-6 w-100">
							        <label class="form-label" >인테리어 요구사항 </label><span>(선택)</span>
							        <input class="form-control" type="text"  name="estInteriorDesc" value="${sessionScope.keyEst.estInteriorDesc}">
								</div>							
								<div class="mb-3 col-md-6 w-100">
							        <label class="form-label" >이미지 및 도면 업로드</label>
							        <input class="form-control" type="file"  name="estFile" value="" multiple accept="image/*,.pdf" >
							        <small class="form-text text-muted">이미지 파일(.jpg, .png) 또는 PDF 형식의 파일만 업로드 가능합니다.</small>
							        
								</div>		
								
							    <!-- 파일 리스트 표시 부분 -->
							    <div class="mb-3 col-md-12">
							        <label class="form-label">현재 업로드된 파일들:</label>
							        <ul>
							            <!-- 파일 리스트가 비어있지 않은 경우에만 출력 -->
										<c:if test="${not empty atchList}">
										    <c:forEach items="${atchList}" var="AttachDTO">
										        <li>
										            <!-- 파일명 표시 -->
										            <span>${AttachDTO.atchOriginalName}</span> 
										
										            <!-- 이미지 파일의 경우 미리보기 표시 -->
										            <c:if test="${AttachDTO.atchContentType.startsWith('image')}">
										                <img src="${pageContext.request.contextPath}/filedownload?fileName=${AttachDTO.atchFileName}&fileOriName=${AttachDTO.atchOriginalName}"
										                     alt="${AttachDTO.atchOriginalName}" style="max-width: 50px; max-height: 50px; margin-right: 10px;">
										            </c:if>
										
										            <!-- 파일 다운로드 링크 -->
										            <a href="${pageContext.request.contextPath}/filedownload?fileName=${AttachDTO.atchFileName}&fileOriName=${AttachDTO.atchOriginalName}">
										                다운로드
										            </a>
										
													<!-- 삭제 버튼 -->
													<button type="button" class="btn btn-danger" onclick="estFileDel('${AttachDTO.atchFileName}')"
													        style="background: none; border: none; font-size: 24px; color: #dc3545; cursor: pointer;">
													    <i class="fas fa-times"></i> <!-- X 아이콘 -->
													</button>
										        </li>
										    </c:forEach>
										</c:if>
							
							            <!-- 파일 리스트가 비어있을 때 -->
							            <c:if test="${empty atchList}">
							                <p>현재 업로드된 파일이 없습니다.</p>
							            </c:if>
							        </ul>
							    </div>								
													
							</form>
						</div>
						
						<div class="mt-2 mb-3 d-flex justify-content-end">
							<button id="backBtn" type="button" class="btn btn-primary me-2">이전으로</button>
							<button id="saveBtn" type="button" class="btn btn-primary me-2">임시저장</button>
							<button id="editBtn" type="button" class="btn btn-primary me-2">제출하기</button>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>

	<form id="boardWriteForm" action="${pageContext.request.contextPath }/roomCreateDo" method="POST">
			<input class="form-control" type="hidden" name="roomName" placeholder="방 제목" value="${sessionScope.keyEst.estAddress}"/>
			<input class="form-control" type="hidden" name="partMem" placeholder="시공사 아이디" value="${sessionScope.keyEst.comId}"/>
	</form>



	<%@ include file="/WEB-INF/inc/footer.jsp"%>


<script type="text/javascript">

	//뒤로가기 버튼 클릭 시
	document.getElementById('backBtn').addEventListener('click', () => {
	    // POST 요청 대신, GET 요청으로 단순히 이동만 시킴
	    window.location.href = '${pageContext.request.contextPath}/est2?itemType=공기조화설비공사'; 
	});

    // 임시저장 버튼
	document.getElementById('saveBtn').addEventListener('click', () => {
	    const formData = new FormData(document.getElementById('estimateForm'));
	
	    fetch('${pageContext.request.contextPath}/saveEstimate', {
	        method: 'POST',
	        body: formData,
	    })
	    .then(response => {
	        if (!response.ok) {
	            // 응답 상태가 200이 아닌 경우 오류 발생
	            throw new Error(`HTTP error! status: ${response.status}`);
	        }
	        return response.text(); // 응답 본문을 문자열로 처리
	    })
	    .then(data => {
	        // 서버에서 반환한 문자열 ("임시 저장 완료")을 출력
	        alert(data);
	        location.reload();
	    })
	    .catch(error => {
	        console.error('Error:', error);
	        alert('임시 저장 중 오류가 발생했습니다.');
	    });
	});
    
	document.getElementById('editBtn').addEventListener('click', () => {
	    const formData = new FormData(document.getElementById('estimateForm'));
	    
	    // 먼저 임시 저장 요청
	    fetch('${pageContext.request.contextPath}/saveEstimate', {
	        method: 'POST',
	        body: formData,
	    })
	    .then(response => {
	        if (!response.ok) {
	            throw new Error(`HTTP error! status: ${response.status}`);
	        }
	        return response.text(); // 응답 본문을 텍스트로 처리
	    })
	    .then(data => {

	        if (data.includes("요청 완료")) {
	            // 2단계: 서버에 estAddress를 보내기 전에, 채팅방 생성을 위한 fetch 진행
	            const estAddress = document.querySelector('input[name="roomName"]').value;

	            // Flask 서버에 요청 보내기
	            return fetch('${pageContext.request.contextPath}/fetchAndSave?estAddress=' + encodeURIComponent(estAddress), {
	                method: 'GET'
	            });
	        } else {
	            throw new Error("요청에 실패했습니다.");
	        }
	    })
	    .then(fetchResponse => {
	        // 서버에서 받은 응답을 확인 (필요시 추가 처리 가능)
	        return fetchResponse.text(); // 응답 본문을 텍스트로 처리
	    })
	    .then(fetchData => {

	        // 3단계: 채팅방 생성 요청
	        const roomName = document.querySelector('input[name="roomName"]').value;
	        const partMem = document.querySelector('input[name="partMem"]').value;

	        return fetch('${pageContext.request.contextPath}/roomCreateDo2', {
	            method: 'POST',
	            headers: {
	                'Content-Type': 'application/json',
	            },
	            body: JSON.stringify({ roomName, partMem }),
	        });
	    })
	    .then(roomResponse => {
	        if (roomResponse.ok) {
	            return roomResponse.json(); // 채팅방 생성 응답 받기
	        } else {
	            throw new Error("채팅방 생성 실패");
	        }
	    })
	    .then(roomData => {
	        alert(roomData.message); // 예: "방 생성 완료"

	        // 4단계: 페이지 이동
	        window.location.href = '${pageContext.request.contextPath}/est4?estId=${sessionScope.keyEst.estId}';
	    })
	    .catch(error => {
	        console.error('Error:', error);
	        alert('제출 중 오류가 발생했습니다.');
	    });
	});
	
    // 파일 삭제
	function estFileDel(atchFileName) {
	    if (confirm("정말로 이 파일을 삭제하시겠습니까?")) {
	        // 서버로 삭제 요청을 보냄
	        fetch('${pageContext.request.contextPath}/estFileDel', {
	            method: 'POST',
	            headers: {
	                'Content-Type': 'application/json'
	            },
	            body: JSON.stringify({
	            	atchFileName: atchFileName
	            })
	        })
	        .then(response => response.json())
	        .then(data => {
	            if (data.success) {
	                alert("파일이 삭제되었습니다.");
	                location.reload(); // 페이지 새로 고침 (파일 목록 갱신)
	            } else {
	                alert("파일 삭제에 실패했습니다.");
	            }
	        })
	        .catch(error => {
	            console.error('Error:', error);
	            alert('파일 삭제 중 오류가 발생했습니다.');
	        });
	    }
	}    
    

</script>

</body>

</html>
