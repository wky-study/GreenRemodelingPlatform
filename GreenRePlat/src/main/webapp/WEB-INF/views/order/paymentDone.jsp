<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>주문 완료</title>



</head>


<style>
	
	
</style>


<body>

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">
			
			<div class="w-100 mb-5">
				<div class="d-flex justify-content-center">
					<h1 class="mt-5">결제 완료</h1>				
				</div>
				<div class="d-flex justify-content-center">
					<h3 class="mt-3">결제가 완료 되었습니다.</h3>
				</div>
				<div class="d-flex justify-content-center">
					<button onclick="home()" class="mt-5 btn btn-outline-dark me-3">홈 화면</button>
				</div>
			</div>

			

		</div>

	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>
	
	<script type="text/javascript">
		
		function home(){
			location.href ='${pageContext.request.contextPath}/';
		}
		
        
        
	</script>
	
	

</body>

</html>
