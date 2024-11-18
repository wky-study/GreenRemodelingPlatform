<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		</div>
	</div>
		
		<!-- 사이드바 js -->
		<script
			src="${pageContext.request.contextPath}/assets/libs/jquery/dist/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/assets/libs/apexcharts/dist/apexcharts.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/assets/libs/simplebar/dist/simplebar.js"></script>
		<script
			src="${pageContext.request.contextPath}/assets/js/sidebarmenu.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/app.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/assets/js/dashboard.js"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/iconify-icon@1.0.8/dist/iconify-icon.min.js"></script>
			
		<script>
	      // 드롭다운 토글
	      $(document).ready(function () {
	        $('#drop3').on('click', function (e) {
	          e.preventDefault();
	          $('.content-dd').toggleClass('show'); // 드롭다운 보이기/숨기기 전환
	        });
	        


	        // 드롭다운 외부를 클릭했을 때 닫기
	        $(document).on('click', function (e) {
	          if (!$(e.target).closest('.nav-icon-hover-bg, .content-dd').length) {
	            $('.content-dd').removeClass('show');
	          }
	        });
	      });
		</script>