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
				<a href="${pageContext.request.contextPath}"
					class="text-nowrap logo-img"> <img
					src="${pageContext.request.contextPath}/assets/images/logos/logo-light.svg"
					alt="" />
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
						class="hide-menu">우리쓰는것들</span></li>
						<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/" aria-expanded="false">
							<span> <iconify-icon icon="solar:home-smile-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">홈</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/registView" aria-expanded="false">
							<span> <iconify-icon icon="solar:home-smile-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">회원가입</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/loginView" aria-expanded="false">
							<span> <iconify-icon icon="solar:home-smile-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">로그인</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/productView" aria-expanded="false">
							<span> <iconify-icon icon="solar:home-smile-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">productView</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/noticeView" aria-expanded="false">
							<span> <iconify-icon icon="solar:home-smile-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">noticeView</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/reviewView" aria-expanded="false">
							<span> <iconify-icon icon="solar:home-smile-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">reviewView</span>
					</a></li>
					
					
					<li class="nav-small-cap"><i
						class="ti ti-dots nav-small-cap-icon fs-6"></i> <span
						class="hide-menu">Home</span></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="${pageContext.request.contextPath}/" aria-expanded="false">
							<span> <iconify-icon icon="solar:home-smile-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Dashboard</span>
					</a></li>
					<li class="nav-small-cap"><i
						class="ti ti-dots nav-small-cap-icon fs-6"></i> <span
						class="hide-menu">UI COMPONENTS</span></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="./ui-buttons.html" aria-expanded="false"> <span>
								<iconify-icon icon="solar:layers-minimalistic-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Buttons</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="./ui-alerts.html" aria-expanded="false"> <span> <iconify-icon
									icon="solar:danger-circle-bold-duotone" class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Alerts</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="./ui-card.html" aria-expanded="false"> <span> <iconify-icon
									icon="solar:bookmark-square-minimalistic-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Card</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="./ui-forms.html" aria-expanded="false"> <span> <iconify-icon
									icon="solar:file-text-bold-duotone" class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Forms</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="./ui-typography.html" aria-expanded="false"> <span>
								<iconify-icon icon="solar:text-field-focus-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Typography</span>
					</a></li>
					<li class="nav-small-cap"><iconify-icon
							icon="solar:menu-dots-linear" class="nav-small-cap-icon fs-6"
							class="fs-6"></iconify-icon> <span class="hide-menu">AUTH</span>
					</li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="./authentication-login.html" aria-expanded="false"> <span>
								<iconify-icon icon="solar:login-3-bold-duotone" class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Login</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="./authentication-register.html" aria-expanded="false"> <span>
								<iconify-icon icon="solar:user-plus-rounded-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Register</span>
					</a></li>
					<li class="nav-small-cap"><iconify-icon
							icon="solar:menu-dots-linear" class="nav-small-cap-icon fs-4"
							class="fs-6"></iconify-icon> <span class="hide-menu">EXTRA</span>
					</li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="./icon-tabler.html" aria-expanded="false"> <span>
								<iconify-icon icon="solar:sticker-smile-circle-2-bold-duotone"
									class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Icons</span>
					</a></li>
					<li class="sidebar-item"><a class="sidebar-link"
						href="./sample-page.html" aria-expanded="false"> <span>
								<iconify-icon icon="solar:planet-3-bold-duotone" class="fs-6"></iconify-icon>
						</span> <span class="hide-menu">Sample Page</span>
					</a></li>
				</ul>
				<div
					class="unlimited-access hide-menu bg-primary-subtle position-relative mb-7 mt-7 rounded-3">
					<div class="d-flex">
						<div class="unlimited-access-title me-3">
							<h6 class="fw-semibold fs-4 mb-6 text-dark w-75">Upgrade to
								pro</h6>
							<a href="#" target="_blank"
								class="btn btn-primary fs-2 fw-semibold lh-sm">Buy Pro</a>
						</div>
						<div class="unlimited-access-img">
							<img
								src="${pageContext.request.contextPath}/assets/images/backgrounds/rocket.png"
								alt="" class="img-fluid">
						</div>
					</div>
				</div>
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
						
						<li class="nav-item dropdown nav-icon-hover-bg rounded-circle">
                <a class="nav-link position-relative" href="javascript:void(0)" id="drop3" aria-expanded="false">
                  <iconify-icon icon="solar:widget-add-bold-duotone" class="fs-6"></iconify-icon>
                </a>
                <div class="dropdown-menu content-dd dropdown-menu-end dropdown-menu-animate-up pb-0"
                  aria-labelledby="drop3">
                  <!--  Shortcuts -->
                  <div class="d-flex align-items-center py-3 px-7 gap-6">
                    <h3 class="mb-0 fs-5">Shortcuts</h3>
                  </div>

                  <div class="row gx-0">
                    <div class="col-6">
                      <a href="${pageContext.request.contextPath}/main/app-calendar.html"
                        class="dropdown-item px-7 py-6 d-flex flex-column gap-2 border-top border-end justify-content-center text-center">
                        <div
                          class="bg-success-subtle rounded-3 m-auto round d-flex align-items-center justify-content-center">
                          <iconify-icon icon="solar:calendar-mark-bold-duotone"
                            class="fs-7 text-success"></iconify-icon>
                        </div>
                        <h6 class="mb-0">Calendar</h6>
                        <span class="d-block text-body-color fs-11">Get dates</span>
                      </a>
                    </div>
                    <div class="col-6">
                      <a href="${pageContext.request.contextPath}/main/app-invoice.html"
                        class="dropdown-item px-7 border-top py-6 d-flex flex-column gap-2 justify-content-center text-center">
                        <div
                          class="bg-secondary-subtle rounded-3 m-auto round d-flex align-items-center justify-content-center">
                          <iconify-icon icon="solar:checklist-minimalistic-bold-duotone"
                            class="fs-7 text-secondary"></iconify-icon>
                        </div>

                        <h6 class="mb-0">Invoice</h6>
                        <span class="d-block text-body-color fs-11">Get latest invoice</span>
                      </a>
                    </div>
                    <div class="col-6">
                      <a href="${pageContext.request.contextPath}/main/app-kanban.html"
                        class="dropdown-item px-7 border-top border-bottom border-end py-6 d-flex flex-column gap-2 justify-content-center text-center">
                        <div
                          class="bg-primary-subtle rounded-3 m-auto round d-flex align-items-center justify-content-center">
                          <iconify-icon icon="solar:chat-square-call-bold-duotone"
                            class="fs-7 text-primary"></iconify-icon>
                        </div>
                        <h6 class="mb-0">To-Do</h6>
                        <span class="d-block text-body-color fs-11">New Tasks</span>
                      </a>
                    </div>
                    <div class="col-6">
                      <a href="${pageContext.request.contextPath}/main/app-chat.html"
                        class="dropdown-item px-7 border-top border-bottom py-6 d-flex flex-column gap-2 justify-content-center text-center">
                        <div
                          class="bg-danger-subtle rounded-3 m-auto round d-flex align-items-center justify-content-center">
                          <iconify-icon icon="solar:chat-square-call-bold-duotone"
                            class="fs-7 text-danger"></iconify-icon>
                        </div>
                        <h6 class="mb-0">Chat</h6>
                        <span class="d-block text-body-color fs-11">New messages</span>
                      </a>
                    </div>
                    <div class="col-6">
                      <a href="${pageContext.request.contextPath}/main/app-notes.html"
                        class="dropdown-item px-7 border-end py-6 d-flex flex-column gap-2 justify-content-center text-center">
                        <div
                          class="bg-info-subtle rounded-3 m-auto round d-flex align-items-center justify-content-center">
                          <iconify-icon icon="solar:phone-calling-rounded-bold-duotone"
                            class="fs-7 text-info"></iconify-icon>
                        </div>
                        <h6 class="mb-0">Notes</h6>
                        <span class="d-block text-body-color fs-11">2 New Notes</span>
                      </a>
                    </div>
                    <div class="col-6">
                      <a href="${pageContext.request.contextPath}/main/blog-posts.html"
                        class="dropdown-item px-7 py-6 d-flex flex-column gap-2 justify-content-center text-center">
                        <div
                          class="bg-warning-subtle rounded-3 m-auto round d-flex align-items-center justify-content-center">
                          <iconify-icon icon="solar:shield-user-bold-duotone" class="fs-7 text-warning"></iconify-icon>
                        </div>
                        <h6 class="mb-0">Blog</h6>
                        <span class="d-block text-body-color fs-11">More information</span>
                      </a>
                    </div>

                  </div>
                </div>
              </li>

              <li class="nav-item dropdown">
                <a class="nav-link nav-icon-hover" href="javascript:void(0)" id="drop2" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                    stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
                    class="icon icon-tabler icons-tabler-outline icon-tabler-user">
                    <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                    <path d="M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0"></path>
                    <path d="M6 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2"></path>
                  </svg> </a>
                <div class="dropdown-menu dropdown-menu-end dropdown-menu-animate-up" aria-labelledby="drop2">
                  <div class="message-body">
                    <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                      <i class="ti ti-user fs-6"></i>
                      <p class="mb-0 fs-3">My Profile</p>
                    </a>
                    <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                      <i class="ti ti-mail fs-6"></i>
                      <p class="mb-0 fs-3">My Account</p>
                    </a>
                    <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                      <i class="ti ti-list-check fs-6"></i>
                      <p class="mb-0 fs-3">My Task</p>
                    </a>
                    <a href="./authentication-login.html" class="btn btn-outline-primary mx-3 mt-2 d-block">Logout</a>
                  </div>
                </div>
              </li>
					</ul>
				</div>
			</nav>
		</header>