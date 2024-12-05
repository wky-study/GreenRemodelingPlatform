<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="shortcut icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/images/logos/seodashlogo.png" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/styles.min.css" />





<!--  Body Wrapper -->
<div class="page-wrapper" id="main-wrapper" data-layout="vertical"
	data-navbarbg="skin6" data-sidebartype="full"
	data-sidebar-position="fixed" data-header-position="fixed">
	<!-- Sidebar Start -->
	<aside class="left-sidebar">
		<!-- Sidebar scroll-->
		<div>
			<div
				class="brand-logo d-flex align-items-center justify-content-between">
				<a href="${pageContext.request.contextPath}/"
					class="text-nowrap logo-img"> <img
					src="${pageContext.request.contextPath}/assets/images/logos/mainlogo.png"
					alt="" style="width: 200px; height: auto; padding-top: 10%;"/>
				</a>
				<div
					class="close-btn d-xl-none d-block sidebartoggler cursor-pointer"
					id="sidebarCollapse">
					<i class="ti ti-x fs-8"></i>
				</div>
			</div>
			<!-- Sidebar navigation-->
			<nav class="sidebar-nav scroll-sidebar" data-simplebar="">
				<ul id="sidebarnav">

					<li class="nav-small-cap"><i
						class="ti ti-dots nav-small-cap-icon fs-6"></i> <span
						class="hide-menu">Eco-Builders</span></li>

					<!-- 우리메뉴 시작 -->

					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/" aria-expanded="false">
							<span> <iconify-icon icon="solar:home-smile-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">홈</span>
					</a></li>
					
					<li class="nav-small-cap"><i
						class="ti ti-dots nav-small-cap-icon fs-6"></i> <span
						class="hide-menu">견적서 바로가기</span></li>
						
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/estListView"
						aria-expanded="false">
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><g fill="none" stroke="currentColor" stroke-width="1.8"><path d="m18.18 8.04l.463-.464a1.966 1.966 0 1 1 2.781 2.78l-.463.464M18.18 8.04s.058.984.927 1.853s1.854.927 1.854.927M18.18 8.04l-4.26 4.26c-.29.288-.434.433-.558.592q-.22.282-.374.606c-.087.182-.151.375-.28.762l-.413 1.24l-.134.401m8.8-5.081l-4.26 4.26c-.29.29-.434.434-.593.558q-.282.22-.606.374c-.182.087-.375.151-.762.28l-1.24.413l-.401.134m0 0l-.401.134a.53.53 0 0 1-.67-.67l.133-.402m.938.938l-.938-.938"/><path stroke-linecap="round" d="M8 13h2.5M8 9h6.5M8 17h1.5M19.828 3.172C18.657 2 16.771 2 13 2h-2C7.229 2 5.343 2 4.172 3.172S3 6.229 3 10v4c0 3.771 0 5.657 1.172 6.828S7.229 22 11 22h2c3.771 0 5.657 0 6.828-1.172c.944-.943 1.127-2.348 1.163-4.828"/></g></svg>
						</span> 
						<span class="hide-menu">견적 의뢰하기</span>
					</a>
					</li>
					
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/estSubmitList"
						aria-expanded="false">
						<span>
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
						  <path d="M8 6h13M8 12h13M8 18h13M3 6h.01M3 12h.01M3 18h.01"/>
						</svg>
						</span> 
						<span class="hide-menu">견적서 목록</span>
					</a>
					</li>
					
					<li class="nav-small-cap"><i
						class="ti ti-dots nav-small-cap-icon fs-6"></i> <span
						class="hide-menu">MENU</span></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/noticeView"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><path fill="none" stroke="currentColor" stroke-width="2" d="M9.153 5.408C10.42 3.136 11.053 2 12 2s1.58 1.136 2.847 3.408l.328.588c.36.646.54.969.82 1.182s.63.292 1.33.45l.636.144c2.46.557 3.689.835 3.982 1.776c.292.94-.546 1.921-2.223 3.882l-.434.507c-.476.557-.715.836-.822 1.18c-.107.345-.071.717.001 1.46l.066.677c.253 2.617.38 3.925-.386 4.506s-1.918.051-4.22-1.009l-.597-.274c-.654-.302-.981-.452-1.328-.452s-.674.15-1.328.452l-.596.274c-2.303 1.06-3.455 1.59-4.22 1.01c-.767-.582-.64-1.89-.387-4.507l.066-.676c.072-.744.108-1.116 0-1.46c-.106-.345-.345-.624-.821-1.18l-.434-.508c-1.677-1.96-2.515-2.941-2.223-3.882S3.58 8.328 6.04 7.772l.636-.144c.699-.158 1.048-.237 1.329-.45s.46-.536.82-1.182z"/></svg>
						</span> 
						<span class="hide-menu">공지사항</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/compageView"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><g fill="none" stroke="currentColor" stroke-width="1.8"><path stroke-linecap="round" d="M22 22H2"/><path d="M21 22V6c0-1.886 0-2.828-.586-3.414S18.886 2 17 2h-2c-1.886 0-2.828 0-3.414.586c-.472.471-.564 1.174-.582 2.414"/><path d="M15 22V9c0-1.886 0-2.828-.586-3.414S12.886 5 11 5H7c-1.886 0-2.828 0-3.414.586S3 7.114 3 9v13"/><path stroke-linecap="round" d="M9 22v-3M6 8h6m-6 3h6m-6 3h6"/></g></svg>
						</span> 
						<span class="hide-menu">기업목록</span>
					</a></li>
					
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/materialView"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><g fill="none" stroke="currentColor" stroke-width="1.8"><path d="M4.979 9.685C2.993 8.891 2 8.494 2 8s.993-.89 2.979-1.685l2.808-1.123C9.773 4.397 10.767 4 12 4s2.227.397 4.213 1.192l2.808 1.123C21.007 7.109 22 7.506 22 8s-.993.89-2.979 1.685l-2.808 1.124C14.227 11.603 13.233 12 12 12s-2.227-.397-4.213-1.191z"/><path d="m5.766 10l-.787.315C2.993 11.109 2 11.507 2 12s.993.89 2.979 1.685l2.808 1.124C9.773 15.603 10.767 16 12 16s2.227-.397 4.213-1.191l2.808-1.124C21.007 12.891 22 12.493 22 12s-.993-.89-2.979-1.685L18.234 10"/><path d="m5.766 14l-.787.315C2.993 15.109 2 15.507 2 16s.993.89 2.979 1.685l2.808 1.124C9.773 19.603 10.767 20 12 20s2.227-.397 4.213-1.192l2.808-1.123C21.007 16.891 22 16.494 22 16c0-.493-.993-.89-2.979-1.685L18.234 14"/></g></svg>
						</span> 
						<span class="hide-menu">자재목록</span>
					</a></li>
					
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/productView"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><g fill="none" stroke="currentColor" stroke-width="1.8"><path d="M4 10c0-3.771 0-5.657 1.172-6.828S8.229 2 12 2s5.657 0 6.828 1.172S20 6.229 20 10v3c0 3.771 0 5.657-1.172 6.828S15.771 21 12 21s-5.657 0-6.828-1.172S4 16.771 4 13z"/><path stroke-linejoin="round" d="M17 21v1h-1v-1m-8 0v1H7v-1"/><path d="M20 11.5H4"/><path stroke-linecap="round" d="M17 7v2m0 5v2"/></g></svg>
						</span> 
						<span class="hide-menu">제품목록</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/reviewView"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" ><path fill="currentColor" d="m20.975 12.185l-.739-.128zm-.705 4.08l-.74-.128zM6.938 20.477l-.747.065zm-.812-9.393l.747-.064zm7.869-5.863l.74.122zm-.663 4.045l.74.121zm-6.634.411l-.49-.568zm1.439-1.24l.49.569zm2.381-3.653l-.726-.189zm.476-1.834l.726.188zm1.674-.886l-.23.714zm.145.047l.229-.714zM9.862 6.463l.662.353zm4.043-3.215l-.726.188zm-2.23-1.116l-.326-.675zM3.971 21.471l-.748.064zM3 10.234l.747-.064a.75.75 0 0 0-1.497.064zm17.236 1.823l-.705 4.08l1.478.256l.705-4.08zm-6.991 9.193H8.596v1.5h4.649zm-5.56-.837l-.812-9.393l-1.495.129l.813 9.393zm11.846-4.276c-.507 2.93-3.15 5.113-6.286 5.113v1.5c3.826 0 7.126-2.669 7.764-6.357zM13.255 5.1l-.663 4.045l1.48.242l.663-4.044zm-6.067 5.146l1.438-1.24l-.979-1.136L6.21 9.11zm4.056-5.274l.476-1.834l-1.452-.376l-.476 1.833zm1.194-2.194l.145.047l.459-1.428l-.145-.047zm-1.915 4.038a8.4 8.4 0 0 0 .721-1.844l-1.452-.377A7 7 0 0 1 9.2 6.11zm2.06-3.991a.89.89 0 0 1 .596.61l1.452-.376a2.38 2.38 0 0 0-1.589-1.662zm-.863.313a.52.52 0 0 1 .28-.33l-.651-1.351c-.532.256-.932.73-1.081 1.305zm.28-.33a.6.6 0 0 1 .438-.03l.459-1.428a2.1 2.1 0 0 0-1.548.107zm2.154 8.176h5.18v-1.5h-5.18zM4.719 21.406L3.747 10.17l-1.494.129l.971 11.236zm-.969.107V10.234h-1.5v11.279zm-.526.022a.263.263 0 0 1 .263-.285v1.5c.726 0 1.294-.622 1.232-1.344zM14.735 5.343a5.5 5.5 0 0 0-.104-2.284l-1.452.377a4 4 0 0 1 .076 1.664zM8.596 21.25a.916.916 0 0 1-.911-.837l-1.494.129a2.416 2.416 0 0 0 2.405 2.208zm.03-12.244c.68-.586 1.413-1.283 1.898-2.19L9.2 6.109c-.346.649-.897 1.196-1.553 1.76zm13.088 3.307a2.416 2.416 0 0 0-2.38-2.829v1.5c.567 0 1 .512.902 1.073zM3.487 21.25c.146 0 .263.118.263.263h-1.5c0 .682.553 1.237 1.237 1.237zm9.105-12.105a1.583 1.583 0 0 0 1.562 1.84v-1.5a.083.083 0 0 1-.082-.098zm-5.72 1.875a.92.92 0 0 1 .316-.774l-.98-1.137a2.42 2.42 0 0 0-.83 2.04z"/></svg>
						</span> 
						<span class="hide-menu">리뷰</span>
					</a></li>
					<li class="nav-small-cap"><i
						class="ti ti-dots nav-small-cap-icon fs-6"></i> <span
						class="hide-menu">MY PAGE</span></li>
						
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/settingView"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"  ><g fill="currentColor" fill-rule="evenodd" clip-rule="evenodd"><path d="M8.25 9a3.75 3.75 0 1 1 7.5 0a3.75 3.75 0 0 1-7.5 0M12 6.75a2.25 2.25 0 1 0 0 4.5a2.25 2.25 0 0 0 0-4.5"/><path d="M1.25 12C1.25 6.063 6.063 1.25 12 1.25S22.75 6.063 22.75 12S17.937 22.75 12 22.75S1.25 17.937 1.25 12M12 2.75a9.25 9.25 0 0 0-6.558 15.773c.18-.973.535-1.89 1.246-2.628C7.753 14.791 9.454 14.25 12 14.25s4.247.541 5.311 1.645c.712.738 1.066 1.656 1.247 2.629A9.25 9.25 0 0 0 12 2.75m5.194 16.905c-.102-1.212-.365-2.1-.962-2.719c-.65-.673-1.853-1.186-4.232-1.186s-3.582.513-4.232 1.186c-.597.62-.86 1.507-.962 2.72A9.2 9.2 0 0 0 12 21.25a9.2 9.2 0 0 0 5.194-1.595"/></g></svg>
						</span> 
						<span class="hide-menu">프로필</span>
					</a></li>
					
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/cartView"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><g fill="none" stroke="currentColor" stroke-width="1.5"><path stroke-linecap="round" d="m2 3l.265.088c1.32.44 1.98.66 2.357 1.184S5 5.492 5 6.883V9.5c0 2.828 0 4.243.879 5.121c.878.879 2.293.879 5.121.879h8"/><path d="M7.5 18a1.5 1.5 0 1 1 0 3a1.5 1.5 0 0 1 0-3Zm9 0a1.5 1.5 0 1 1 0 3a1.5 1.5 0 0 1 0-3ZM5 6h11.45c2.055 0 3.083 0 3.528.674c.444.675.04 1.619-.77 3.508l-.429 1c-.378.882-.567 1.322-.942 1.57c-.376.248-.856.248-1.815.248H5"/></g></svg>
						</span> 
						<span class="hide-menu">장바구니</span>
					</a></li>
					
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/orderSummary"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"   fill="none"><path fill="currentColor" fill-rule="evenodd" d="M7.099 1.25H16.9c1.017 0 1.717 0 2.306.204a3.8 3.8 0 0 1 2.348 2.412l-.713.234l.713-.234c.196.597.195 1.307.195 2.36v14.148c0 1.466-1.727 2.338-2.864 1.297a.196.196 0 0 0-.271 0l-.484.442c-.928.85-2.334.85-3.262 0a.907.907 0 0 0-1.238 0c-.928.85-2.334.85-3.262 0a.907.907 0 0 0-1.238 0c-.928.85-2.334.85-3.262 0l-.483-.442a.196.196 0 0 0-.272 0c-1.137 1.04-2.864.169-2.864-1.297V6.227c0-1.054 0-1.764.195-2.361a3.8 3.8 0 0 1 2.348-2.412c.59-.205 1.289-.204 2.306-.204m.146 1.5c-1.221 0-1.642.01-1.96.121A2.3 2.3 0 0 0 3.87 4.334c-.111.338-.12.784-.12 2.036v14.004c0 .12.059.192.134.227a.2.2 0 0 0 .11.018a.2.2 0 0 0 .107-.055a1.695 1.695 0 0 1 2.296 0l.483.442a.907.907 0 0 0 1.238 0a2.407 2.407 0 0 1 3.262 0a.907.907 0 0 0 1.238 0a2.407 2.407 0 0 1 3.262 0a.907.907 0 0 0 1.238 0l.483-.442a1.695 1.695 0 0 1 2.296 0c.043.04.08.052.108.055a.2.2 0 0 0 .109-.018c.075-.035.135-.108.135-.227V6.37c0-1.252-.01-1.698-.12-2.037a2.3 2.3 0 0 0-1.416-1.462c-.317-.11-.738-.12-1.959-.12zM15 7.44a.75.75 0 0 1 .06 1.06l-3.572 4a.75.75 0 0 1-1.119 0l-1.428-1.6a.75.75 0 0 1 1.118-1l.87.974l3.012-3.373A.75.75 0 0 1 15 7.44M6.75 15.5a.75.75 0 0 1 .75-.75h9a.75.75 0 0 1 0 1.5h-9a.75.75 0 0 1-.75-.75" clip-rule="evenodd"/></svg>
							
						</span> 
						<span class="hide-menu">주문내역</span>
					</a></li>
					
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/chatListView"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"  ><path fill="currentColor" fill-rule="evenodd" d="M12 2.75A9.25 9.25 0 0 0 2.75 12c0 1.481.348 2.879.965 4.118c.248.498.343 1.092.187 1.677l-.596 2.225a.55.55 0 0 0 .673.674l2.227-.596a2.38 2.38 0 0 1 1.676.187A9.2 9.2 0 0 0 12 21.25a9.25 9.25 0 0 0 0-18.5M1.25 12C1.25 6.063 6.063 1.25 12 1.25S22.75 6.063 22.75 12S17.937 22.75 12 22.75c-1.718 0-3.344-.404-4.787-1.122a.9.9 0 0 0-.62-.08l-2.226.595c-1.524.408-2.918-.986-2.51-2.51l.596-2.226a.9.9 0 0 0-.08-.62A10.7 10.7 0 0 1 1.25 12m6-1.5A.75.75 0 0 1 8 9.75h8a.75.75 0 0 1 0 1.5H8a.75.75 0 0 1-.75-.75m0 3.5a.75.75 0 0 1 .75-.75h5.5a.75.75 0 0 1 0 1.5H8a.75.75 0 0 1-.75-.75" clip-rule="evenodd"/></svg>
						</span> 
						<span class="hide-menu">채팅</span>
					</a></li>
					
					<c:if test="${sessionScope.memInfo != null && sessionScope.memInfo.memType == 5}">
						<li class="sidebar-item"><a class="sidebar-link"
							href="${pageContext.request.contextPath}/planView"
							aria-expanded="false"> 
							<span>
								<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"><g fill="none"><path stroke="currentColor" stroke-width="2" d="M2 12c0-3.771 0-5.657 1.172-6.828S6.229 4 10 4h4c3.771 0 5.657 0 6.828 1.172S22 8.229 22 12v2c0 3.771 0 5.657-1.172 6.828S17.771 22 14 22h-4c-3.771 0-5.657 0-6.828-1.172S2 17.771 2 14z"/><path stroke="currentColor" stroke-linecap="round" stroke-width="2" d="M7 4V2.5M17 4V2.5M2.5 9h19"/><path fill="currentColor" d="M18 17a1 1 0 1 1-2 0a1 1 0 0 1 2 0m0-4a1 1 0 1 1-2 0a1 1 0 0 1 2 0m-5 4a1 1 0 1 1-2 0a1 1 0 0 1 2 0m0-4a1 1 0 1 1-2 0a1 1 0 0 1 2 0m-5 4a1 1 0 1 1-2 0a1 1 0 0 1 2 0m0-4a1 1 0 1 1-2 0a1 1 0 0 1 2 0"/></g></svg>
							</span>
							<span class="hide-menu">시공 일정</span>
						</a></li>

					</c:if>
					
					<c:if test="${sessionScope.memInfo == null}">
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/loginView"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24"   ><g fill="currentColor" fill-rule="evenodd" clip-rule="evenodd" ><path d="M9.25 16a2.75 2.75 0 1 1 5.5 0a2.75 2.75 0 0 1-5.5 0M12 14.75a1.25 1.25 0 1 0 0 2.5a1.25 1.25 0 0 0 0-2.5"/><path d="M5.25 9.303V8a6.75 6.75 0 0 1 13.5 0v1.303q.34.023.642.064c.9.12 1.658.38 2.26.981c.602.602.86 1.36.982 2.26c.116.867.116 1.97.116 3.337v.11c0 1.367 0 2.47-.116 3.337c-.122.9-.38 1.658-.982 2.26s-1.36.86-2.26.982c-.867.116-1.97.116-3.337.116h-8.11c-1.367 0-2.47 0-3.337-.116c-.9-.122-1.658-.38-2.26-.982s-.86-1.36-.981-2.26c-.117-.867-.117-1.97-.117-3.337v-.11c0-1.367 0-2.47.117-3.337c.12-.9.38-1.658.981-2.26c.602-.602 1.36-.86 2.26-.981q.301-.041.642-.064M6.75 8a5.25 5.25 0 0 1 10.5 0v1.253q-.56-.004-1.195-.003h-8.11q-.634 0-1.195.003zm-1.942 2.853c-.734.099-1.122.28-1.399.556c-.277.277-.457.665-.556 1.4c-.101.755-.103 1.756-.103 3.191s.002 2.436.103 3.192c.099.734.28 1.122.556 1.399c.277.277.665.457 1.4.556c.754.101 1.756.103 3.191.103h8c1.435 0 2.436-.002 3.192-.103c.734-.099 1.122-.28 1.399-.556c.277-.277.457-.665.556-1.4c.101-.755.103-1.756.103-3.191s-.002-2.437-.103-3.192c-.099-.734-.28-1.122-.556-1.399c-.277-.277-.665-.457-1.4-.556c-.755-.101-1.756-.103-3.191-.103H8c-1.435 0-2.437.002-3.192.103"/></g></svg>						</span> 
						<span class="hide-menu">로그인</span>
					</a></li>
					</c:if>
					
					<c:if test="${sessionScope.memInfo != null}">
					
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/logoutDo"
						aria-expanded="false"> 
						<span>
							<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" stroke="currentColor" stroke-width="0.8"><g fill="currentColor" fill-rule="evenodd" clip-rule="evenodd"><path d="M9.25 16a2.75 2.75 0 1 1 5.5 0a2.75 2.75 0 0 1-5.5 0M12 14.75a1.25 1.25 0 1 0 0 2.5a1.25 1.25 0 0 0 0-2.5"/><path d="M6.75 8a5.25 5.25 0 0 1 10.335-1.313a.75.75 0 0 0 1.452-.374A6.75 6.75 0 0 0 5.25 8v1.303q-.34.023-.642.064c-.9.12-1.658.38-2.26.981c-.602.602-.86 1.36-.981 2.26c-.117.867-.117 1.97-.117 3.337v.11c0 1.367 0 2.47.117 3.337c.12.9.38 1.658.981 2.26c.602.602 1.36.86 2.26.982c.867.116 1.97.116 3.337.116h8.11c1.367 0 2.47 0 3.337-.116c.9-.122 1.658-.38 2.26-.982s.86-1.36.982-2.26c.116-.867.116-1.97.116-3.337v-.11c0-1.367 0-2.47-.116-3.337c-.122-.9-.38-1.658-.982-2.26s-1.36-.86-2.26-.981c-.867-.117-1.97-.117-3.337-.117h-8.11q-.634 0-1.195.003zm-1.942 2.853c-.734.099-1.122.28-1.399.556c-.277.277-.457.665-.556 1.4c-.101.755-.103 1.756-.103 3.191s.002 2.436.103 3.192c.099.734.28 1.122.556 1.399c.277.277.665.457 1.4.556c.754.101 1.756.103 3.191.103h8c1.435 0 2.436-.002 3.192-.103c.734-.099 1.122-.28 1.399-.556c.277-.277.457-.665.556-1.4c.101-.755.103-1.756.103-3.191s-.002-2.437-.103-3.192c-.099-.734-.28-1.122-.556-1.399c-.277-.277-.665-.457-1.4-.556c-.755-.101-1.756-.103-3.191-.103H8c-1.435 0-2.437.002-3.192.103"/></g></svg>
						</span> 
						<span class="hide-menu">로그아웃</span>
					</a></li>
					</c:if>
				</ul>
				
			</nav>
			<!-- End Sidebar navigation -->
		</div>
		<!-- End Sidebar scroll-->
	</aside>
	<!--  Sidebar End -->
	<!--  Main wrapper -->
	<div class="body-wrapper">
		<!--  Header Start -->
		<header class="app-header">
			<nav class="navbar navbar-expand-lg navbar-light">
				<ul class="navbar-nav">
					<li class="nav-item d-block d-xl-none"><a
						class="nav-link sidebartoggler nav-icon-hover" id="headerCollapse"
						href="javascript:void(0)"> <i class="ti ti-menu-2"></i>
					</a></li>

				</ul>
				<div class="navbar-collapse justify-content-end px-0" id="navbarNav">
					<ul
						class="navbar-nav flex-row ms-auto align-items-center justify-content-end">

						<c:if test="${sessionScope.memInfo == null}">
						<li class="nav-item dropdown">
							<a class="nav-link nav-icon-hover" href="javascript:void(0)" id="drop2" data-bs-toggle="dropdown" aria-expanded="false">
						 <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" 
						  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-user">
		                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
		                    <path d="M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0"></path>
		                    <path d="M6 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2"></path>
		                  </svg>
						</a>
							<div class="dropdown-menu content-ff dropdown-menu-end dropdown-menu-animate-up "aria-labelledby="drop2">
							<div class="message-body">
								<a href="${pageContext.request.contextPath}/loginView"
										class="d-flex align-items-center gap-2 dropdown-item">
										<i class="ti ti-user fs-6"></i>
										<p class="mb-0 fs-3">로그인</p>
									</a> 
									<a href="${pageContext.request.contextPath}/registView" class="d-flex align-items-center gap-2 dropdown-item"> 
									<i>
										<svg xmlns="http://www.w3.org/2000/svg" width="20.2" height="22" viewBox="0 0 24 24"><g fill="none" stroke="currentColor" stroke-width="2"><circle cx="12" cy="6" r="4"/><circle cx="18" cy="16" r="4"/><path stroke-linecap="round" stroke-linejoin="round" d="m16.667 16l.833 1l1.833-1.889"/><path d="M15 13.327A13.6 13.6 0 0 0 12 13c-4.418 0-8 2.015-8 4.5S4 22 12 22c5.687 0 7.331-1.018 7.807-2.5"/></g></svg>
									</i>
										<p class="mb-0 fs-3">회원 가입</p>
									</a>
							
							</div>
							</div>
						</li>
						</c:if>
						
						<c:if test="${sessionScope.memInfo != null}">
						<li class="nav-item dropdown">
						<a class="nav-link nav-icon-hover" href="javascript:void(0)" id="drop2" data-bs-toggle="dropdown" aria-expanded="false">
						 <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" 
						  stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icons-tabler-outline icon-tabler-user">
		                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
		                    <path d="M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0"></path>
		                    <path d="M6 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2"></path>
		                  </svg>
						</a>
							<div class="dropdown-menu content-ff dropdown-menu-end dropdown-menu-animate-up "aria-labelledby="drop2">
								<div class="message-body">
									<a href="${pageContext.request.contextPath }/settingView"
										class="d-flex align-items-center gap-2 dropdown-item">
										<i class="ti ti-user fs-6"></i>
										<p class="mb-0 fs-3">마이 페이지</p>
									</a> 
									<a href="${pageContext.request.contextPath}/cartView" class="d-flex align-items-center gap-2 dropdown-item"> 
									<i>
										<svg xmlns="http://www.w3.org/2000/svg" width="20.2" height="22" viewBox="0 0 24 24"><g fill="none" stroke="currentColor" stroke-width="2"><path stroke-linecap="round" d="m2 3l.265.088c1.32.44 1.98.66 2.357 1.184S5 5.492 5 6.883V9.5c0 2.828 0 4.243.879 5.121c.878.879 2.293.879 5.121.879h8"/><path d="M7.5 18a1.5 1.5 0 1 1 0 3a1.5 1.5 0 0 1 0-3Zm9 0a1.5 1.5 0 1 1 0 3a1.5 1.5 0 0 1 0-3ZM5 6h11.45c2.055 0 3.083 0 3.528.674c.444.675.04 1.619-.77 3.508l-.429 1c-.378.882-.567 1.322-.942 1.57c-.376.248-.856.248-1.815.248H5"/></g></svg>
									</i>
										<p class="mb-0 fs-3">장 바구니</p>
									</a> <a href="${pageContext.request.contextPath}/orderSummary"
										class="d-flex align-items-center gap-2 dropdown-item"> 
										<i>
											<svg xmlns="http://www.w3.org/2000/svg" width="20.2" height="22" viewBox="0 0 24 24" stroke="currentColor" stroke-width="0.8" fill="none"><path fill="currentColor" fill-rule="evenodd" d="M7.099 1.25H16.9c1.017 0 1.717 0 2.306.204a3.8 3.8 0 0 1 2.348 2.412l-.713.234l.713-.234c.196.597.195 1.307.195 2.36v14.148c0 1.466-1.727 2.338-2.864 1.297a.196.196 0 0 0-.271 0l-.484.442c-.928.85-2.334.85-3.262 0a.907.907 0 0 0-1.238 0c-.928.85-2.334.85-3.262 0a.907.907 0 0 0-1.238 0c-.928.85-2.334.85-3.262 0l-.483-.442a.196.196 0 0 0-.272 0c-1.137 1.04-2.864.169-2.864-1.297V6.227c0-1.054 0-1.764.195-2.361a3.8 3.8 0 0 1 2.348-2.412c.59-.205 1.289-.204 2.306-.204m.146 1.5c-1.221 0-1.642.01-1.96.121A2.3 2.3 0 0 0 3.87 4.334c-.111.338-.12.784-.12 2.036v14.004c0 .12.059.192.134.227a.2.2 0 0 0 .11.018a.2.2 0 0 0 .107-.055a1.695 1.695 0 0 1 2.296 0l.483.442a.907.907 0 0 0 1.238 0a2.407 2.407 0 0 1 3.262 0a.907.907 0 0 0 1.238 0a2.407 2.407 0 0 1 3.262 0a.907.907 0 0 0 1.238 0l.483-.442a1.695 1.695 0 0 1 2.296 0c.043.04.08.052.108.055a.2.2 0 0 0 .109-.018c.075-.035.135-.108.135-.227V6.37c0-1.252-.01-1.698-.12-2.037a2.3 2.3 0 0 0-1.416-1.462c-.317-.11-.738-.12-1.959-.12zM15 7.44a.75.75 0 0 1 .06 1.06l-3.572 4a.75.75 0 0 1-1.119 0l-1.428-1.6a.75.75 0 0 1 1.118-1l.87.974l3.012-3.373A.75.75 0 0 1 15 7.44M6.75 15.5a.75.75 0 0 1 .75-.75h9a.75.75 0 0 1 0 1.5h-9a.75.75 0 0 1-.75-.75" clip-rule="evenodd"/></svg>
										</i>
										<p class="mb-0 fs-3">구매 내역</p>
									</a>  <a href="${pageContext.request.contextPath}/logoutDo"
										class="btn btn-outline-primary mx-3 mt-2 d-block">로그 아웃</a>
								</div>
							</div>
						</li>
						</c:if>
					</ul>
				</div>
			</nav>
		</header>