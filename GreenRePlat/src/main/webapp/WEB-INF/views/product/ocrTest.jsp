<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>OCR Test</title>

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

<script src='https://cdn.jsdelivr.net/npm/tesseract.js@4/dist/tesseract.min.js'></script>
<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">
		
		
			<div class="container-xxl py-5">
				<div class="container">
				
					<div class="card-body">

                        <input type="file" id="file_input" accept="image/*">
                        <button onclick="handleClick()" style="margin-top: 20px;">OCR 실행</button>
  					
					</div>
				</div>
			</div>




		</div>
	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>


	<script type="text/javascript">
	
	const handleClick = () => {
	    const fileInput = document.querySelector('#file_input');
	    const file = fileInput.files[0];

	    if (!file) {
	        alert("이미지를 업로드해주세요.");
	        return;
	    }

	    const reader = new FileReader();
	    reader.onload = () => {
	        Tesseract.recognize(
	            reader.result, // 업로드된 이미지의 Data URL
	            'kor', // 한국어 텍스트 인식
	            /* { logger: m => { console.log(m) } }  // 인식 진행 상태 관련 로그 */
	        )
	        .then(({ data: { text } }) => { 
	            console.log(text);  // 이미지에서 추출된 텍스트

	            // 줄바꿈을 기준으로 텍스트 분할
	            const lines = text.split('\n');

	            // 줄별로 배열로 담기
	            console.log("Lines array:", lines);

	            // 3번, 4번, 5번 줄 추출
	            const extractKeyValue = (line) => {
	                const [key, value] = line.split(':').map(item => item.trim().replace(/\s+/g, '')); // 공백 제거
	                return { [key]: value }; // 키-값 쌍으로 객체 생성
	            };

	            const v_no = extractKeyValue(lines[3] || '');
	            const v_comName = extractKeyValue(lines[4] || '');
	            const v_name = extractKeyValue(lines[5] || '');

	            // 최종 JSON 객체로 병합
	            const jsonData = { 
	                ...v_no,
	                ...v_comName,
	                ...v_name
	            };

	            // JSON 객체 출력
	            console.log("JSON 데이터:", jsonData);
	        })
	        .catch(err => { 
	            console.error(err); 
	        });
	    };

	    // 파일을 Data URL로 읽음
	    reader.readAsDataURL(file);
	};
	
	</script>
	
	
	
	

</body>

</html>
