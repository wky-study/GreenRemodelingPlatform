<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html lang="ko">

<style>
.img-fluid {
	max-width: 100%;
	height: auto;
}

.img-border {
	position: relative;
	height: 100%;
	min-height: 400px;
}

.img-border::before {
	position: absolute;
	content: "";
	top: 0px;
	left: 0px;
	right: 3rem;
	bottom: 3rem;
	border: 5px solid var(- -primary);
}

.img-border img {
	position: absolute;
	top: 3rem;
	left: 3rem;
	width: calc(100% - 3rem);
	height: calc(100% - 3rem);
	object-fit: cover;
}
</style>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SeoDash Free Bootstrap Admin Template by Adminmart</title>
<link rel="shortcut icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/images/logos/seodashlogo.png" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/styles.min.css" />
</head>

<body>
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
							class="hide-menu">Home</span></li>
						<li class="sidebar-item"><a class="sidebar-link"
							href="${pageContext.request.contextPath}" aria-expanded="false">
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
							href="./ui-alerts.html" aria-expanded="false"> <span>
									<iconify-icon icon="solar:danger-circle-bold-duotone"
										class="fs-6"></iconify-icon>
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
							href="./authentication-register.html" aria-expanded="false">
								<span> <iconify-icon
										icon="solar:user-plus-rounded-bold-duotone" class="fs-6"></iconify-icon>
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
							class="nav-link sidebartoggler nav-icon-hover"
							id="headerCollapse" href="javascript:void(0)"> <i
								class="ti ti-menu-2"></i>
						</a></li>
						<li class="nav-item"><a class="nav-link nav-icon-hover"
							href="javascript:void(0)"> <i class="ti ti-bell-ringing"></i>
								<div class="notification bg-primary rounded-circle"></div>
						</a></li>
					</ul>
					<div class="navbar-collapse justify-content-end px-0"
						id="navbarNav">
						<ul
							class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
							<a href="#" target="_blank" class="btn btn-primary me-2"><span
								class="d-none d-md-block">Check Pro Version</span> <span
								class="d-block d-md-none">Pro</span></a>
							<a href="#" target="_blank" class="btn btn-success"><span
								class="d-none d-md-block">Download Free </span> <span
								class="d-block d-md-none">Free</span></a>
							<li class="nav-item dropdown"><a
								class="nav-link nav-icon-hover" href="javascript:void(0)"
								id="drop2" data-bs-toggle="dropdown" aria-expanded="false">
									<img
									src="${pageContext.request.contextPath}/assets/images/profile/user-1.jpg"
									alt="" width="35" height="35" class="rounded-circle">
							</a>
								<div
									class="dropdown-menu dropdown-menu-end dropdown-menu-animate-up"
									aria-labelledby="drop2">
									<div class="message-body">
										<a href="javascript:void(0)"
											class="d-flex align-items-center gap-2 dropdown-item"> <i
											class="ti ti-user fs-6"></i>
											<p class="mb-0 fs-3">My Profile</p>
										</a> <a href="javascript:void(0)"
											class="d-flex align-items-center gap-2 dropdown-item"> <i
											class="ti ti-mail fs-6"></i>
											<p class="mb-0 fs-3">My Account</p>
										</a> <a href="javascript:void(0)"
											class="d-flex align-items-center gap-2 dropdown-item"> <i
											class="ti ti-list-check fs-6"></i>
											<p class="mb-0 fs-3">My Task</p>
										</a> <a href="./authentication-login.html"
											class="btn btn-outline-primary mx-3 mt-2 d-block">Logout</a>
									</div>
								</div></li>
						</ul>
					</div>
				</nav>
			</header>
			<!--  Header End -->
			<div class="container-fluid">
				<div class="row">


					<!-- Header Start -->
					<div class="container-fluid bg-dark p-0 mb-5">
						<div class="row g-0 flex-column-reverse flex-lg-row">
							<div class="col-lg-6 p-0 wow fadeIn" data-wow-delay="0.1s"
								style="visibility: visible; animation-delay: 0.1s; animation-name: fadeIn;">
							</div>
							<div class="col-lg-6 wow fadeIn" data-wow-delay="0.5s"
								style="visibility: visible; animation-delay: 0.5s; animation-name: fadeIn;">
								<div class="owl-carousel header-carousel owl-loaded owl-drag">

									<div class="owl-nav">
										<div class="owl-prev">
											<i class="bi bi-chevron-left"></i>
										</div>
										<div class="owl-next">
											<i class="bi bi-chevron-right"></i>
										</div>
									</div>
									<div class="owl-dots">
										<div class="owl-dot active">
											<span></span>
										</div>
										<div class="owl-dot">
											<span></span>
										</div>
										<div class="owl-dot">
											<span></span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Header End -->

					<!-- Video Modal Start -->
					<div class="modal modal-video fade" id="videoModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content rounded-0">
								<div class="modal-header">
									<h3 class="modal-title" id="exampleModalLabel">Youtube
										Video</h3>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<!-- 16:9 aspect ratio -->
									<div class="ratio ratio-16x9">
										<iframe class="embed-responsive-item" src="" id="video"
											allowfullscreen="" allowscriptaccess="always"
											allow="autoplay"></iframe>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Video Modal End -->

					<!-- About Start -->
					<div class="container-xxl py-5">
						<div class="container">
							<div class="row g-5">

								<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s"
									style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
									<div class="img-border">
										<img class="img-fluid"
											src="${pageContext.request.contextPath}/assets/images/metarial/건축자재이미지.png"
											alt="">
									</div>
								</div>

								<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s"
									style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
									<p>
										<span class="text-primary me-2">#</span>Welcome To Zoofari
									</p>
									<h1 class="display-5 mb-4">
										Why You Should Visit <span class="text-primary">Zoofari</span>
										Park!
									</h1>
									<p class="mb-4">Stet no et lorem dolor et diam, amet duo ut
										dolore vero eos. No stet est diam rebum amet diam ipsum. Clita
										clita labore, dolor duo nonumy clita sit at, sed sit sanctus
										dolor eos.</p>
									<h5 class="mb-3">
										<i class="far fa-check-circle text-primary me-3"></i>Free Car
										Parking
									</h5>
									<h5 class="mb-3">
										<i class="far fa-check-circle text-primary me-3"></i>Natural
										Environment
									</h5>
									<h5 class="mb-3">
										<i class="far fa-check-circle text-primary me-3"></i>Professional
										Guide &amp; Security
									</h5>
									<h5 class="mb-3">
										<i class="far fa-check-circle text-primary me-3"></i>World
										Best Animals
									</h5>
									<a class="btn btn-primary py-3 px-5 mt-3" href="">Read More</a>
								</div>

							</div>
						</div>
					</div>
					<!-- About End -->

					<!-- Facts Start -->
					<div class="container-xxl bg-primary facts my-5 py-5 wow fadeInUp"
						data-wow-delay="0.1s"
						style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
						<div class="container py-5">
							<div class="row g-4">
								<div class="col-md-6 col-lg-3 text-center wow fadeIn"
									data-wow-delay="0.1s"
									style="visibility: visible; animation-delay: 0.1s; animation-name: fadeIn;">
									<i class="fa fa-paw fa-3x text-primary mb-3"></i>
									<h1 class="text-white mb-2" data-toggle="counter-up">12345</h1>
									<p class="text-white mb-0">Total Animal</p>
								</div>
								<div class="col-md-6 col-lg-3 text-center wow fadeIn"
									data-wow-delay="0.3s"
									style="visibility: visible; animation-delay: 0.3s; animation-name: fadeIn;">
									<i class="fa fa-users fa-3x text-primary mb-3"></i>
									<h1 class="text-white mb-2" data-toggle="counter-up">12345</h1>
									<p class="text-white mb-0">Daily Vigitors</p>
								</div>
								<div class="col-md-6 col-lg-3 text-center wow fadeIn"
									data-wow-delay="0.5s"
									style="visibility: visible; animation-delay: 0.5s; animation-name: fadeIn;">
									<i class="fa fa-certificate fa-3x text-primary mb-3"></i>
									<h1 class="text-white mb-2" data-toggle="counter-up">12345</h1>
									<p class="text-white mb-0">Total Membership</p>
								</div>
								<div class="col-md-6 col-lg-3 text-center wow fadeIn"
									data-wow-delay="0.7s"
									style="visibility: visible; animation-delay: 0.7s; animation-name: fadeIn;">
									<i class="fa fa-shield-alt fa-3x text-primary mb-3"></i>
									<h1 class="text-white mb-2" data-toggle="counter-up">12345</h1>
									<p class="text-white mb-0">Save Wild Life</p>
								</div>
							</div>
						</div>
					</div>
					<!-- Facts End -->

					<!-- Service Start -->
					<div class="container-xxl py-5">
						<div class="container">
							<div class="row g-5 mb-5 wow fadeInUp" data-wow-delay="0.1s"
								style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
								<div class="col-lg-6">
									<p>
										<span class="text-primary me-2">#</span>Our Services
									</p>
									<h1 class="display-5 mb-0">
										Special Services For <span class="text-primary">Zoofari</span>
										Visitors
									</h1>
								</div>
								<div class="col-lg-6">
									<div
										class="bg-primary h-100 d-flex align-items-center py-4 px-4 px-sm-5">
										<i class="fa fa-3x fa-mobile-alt text-white"></i>
										<div class="ms-4">
											<p class="text-white mb-0">Call for more info</p>
											<h2 class="text-white mb-0">+012 345 6789</h2>
										</div>
									</div>
								</div>
							</div>
							<div class="row gy-5 gx-4">
								<div class="col-lg-3 col-md-4 col-sm-6 wow fadeInUp"
									data-wow-delay="0.1s"
									style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
									<img class="img-fluid mb-3" src="img/icon/icon-2.png"
										alt="Icon">
									<h5 class="mb-3">Car Parking</h5>
									<span>Erat ipsum justo amet duo et elitr dolor, est duo
										duo eos lorem sed diam stet diam sed stet.</span>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 wow fadeInUp"
									data-wow-delay="0.3s"
									style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInUp;">
									<img class="img-fluid mb-3" src="img/icon/icon-3.png"
										alt="Icon">
									<h5 class="mb-3">Animal Photos</h5>
									<span>Erat ipsum justo amet duo et elitr dolor, est duo
										duo eos lorem sed diam stet diam sed stet.</span>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 wow fadeInUp"
									data-wow-delay="0.5s"
									style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInUp;">
									<img class="img-fluid mb-3" src="img/icon/icon-4.png"
										alt="Icon">
									<h5 class="mb-3">Guide Services</h5>
									<span>Erat ipsum justo amet duo et elitr dolor, est duo
										duo eos lorem sed diam stet diam sed stet.</span>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 wow fadeInUp"
									data-wow-delay="0.7s"
									style="visibility: visible; animation-delay: 0.7s; animation-name: fadeInUp;">
									<img class="img-fluid mb-3" src="img/icon/icon-5.png"
										alt="Icon">
									<h5 class="mb-3">Food &amp; Beverages</h5>
									<span>Erat ipsum justo amet duo et elitr dolor, est duo
										duo eos lorem sed diam stet diam sed stet.</span>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 wow fadeInUp"
									data-wow-delay="0.1s"
									style="visibility: visible; animation-delay: 0.1s; animation-name: fadeInUp;">
									<img class="img-fluid mb-3" src="img/icon/icon-6.png"
										alt="Icon">
									<h5 class="mb-3">Zoo Shopping</h5>
									<span>Erat ipsum justo amet duo et elitr dolor, est duo
										duo eos lorem sed diam stet diam sed stet.</span>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 wow fadeInUp"
									data-wow-delay="0.3s"
									style="visibility: visible; animation-delay: 0.3s; animation-name: fadeInUp;">
									<img class="img-fluid mb-3" src="img/icon/icon-7.png"
										alt="Icon">
									<h5 class="mb-3">Free Hi Speed Wi-Fi</h5>
									<span>Erat ipsum justo amet duo et elitr dolor, est duo
										duo eos lorem sed diam stet diam sed stet.</span>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 wow fadeInUp"
									data-wow-delay="0.5s"
									style="visibility: hidden; animation-delay: 0.5s; animation-name: none;">
									<img class="img-fluid mb-3" src="img/icon/icon-8.png"
										alt="Icon">
									<h5 class="mb-3">Play Ground</h5>
									<span>Erat ipsum justo amet duo et elitr dolor, est duo
										duo eos lorem sed diam stet diam sed stet.</span>
								</div>
								<div class="col-lg-3 col-md-4 col-sm-6 wow fadeInUp"
									data-wow-delay="0.7s"
									style="visibility: hidden; animation-delay: 0.7s; animation-name: none;">
									<img class="img-fluid mb-3" src="img/icon/icon-9.png"
										alt="Icon">
									<h5 class="mb-3">Rest House</h5>
									<span>Erat ipsum justo amet duo et elitr dolor, est duo
										duo eos lorem sed diam stet diam sed stet.</span>
								</div>
							</div>
						</div>
					</div>
					<!-- Service End -->

					<!-- Animal Start -->
					<div class="container-xxl py-5">
						<div class="container">
							<div class="row g-5 mb-5 align-items-end wow fadeInUp"
								data-wow-delay="0.1s"
								style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
								<div class="col-lg-6">
									<p>
										<span class="text-primary me-2">#</span>Our Animals
									</p>
									<h1 class="display-5 mb-0">
										Let`s See Our <span class="text-primary">Zoofari</span> Awsome
										Animals
									</h1>
								</div>
								<div class="col-lg-6 text-lg-end">
									<a class="btn btn-primary py-3 px-5" href="">Explore More
										Animals</a>
								</div>
							</div>
							<div class="row g-4">
								<div class="col-lg-4 col-md-6 wow fadeInUp"
									data-wow-delay="0.1s"
									style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
									<div class="row g-4">
										<div class="col-12">
											<a class="animal-item" href="img/animal-md-1.jpg"
												data-lightbox="animal">
												<div class="position-relative">
													<img class="img-fluid" src="img/animal-md-1.jpg" alt="">
													<div class="animal-text p-4">
														<p class="text-white small text-uppercase mb-0">Animal</p>
														<h5 class="text-white mb-0">Elephant</h5>
													</div>
												</div>
											</a>
										</div>
										<div class="col-12">
											<a class="animal-item" href="img/animal-lg-1.jpg"
												data-lightbox="animal">
												<div class="position-relative">
													<img class="img-fluid" src="img/animal-lg-1.jpg" alt="">
													<div class="animal-text p-4">
														<p class="text-white small text-uppercase mb-0">Animal</p>
														<h5 class="text-white mb-0">Elephant</h5>
													</div>
												</div>
											</a>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-md-6 wow fadeInUp"
									data-wow-delay="0.3s"
									style="visibility: hidden; animation-delay: 0.3s; animation-name: none;">
									<div class="row g-4">
										<div class="col-12">
											<a class="animal-item" href="img/animal-lg-2.jpg"
												data-lightbox="animal">
												<div class="position-relative">
													<img class="img-fluid" src="img/animal-lg-2.jpg" alt="">
													<div class="animal-text p-4">
														<p class="text-white small text-uppercase mb-0">Animal</p>
														<h5 class="text-white mb-0">Elephant</h5>
													</div>
												</div>
											</a>
										</div>
										<div class="col-12">
											<a class="animal-item" href="img/animal-md-2.jpg"
												data-lightbox="animal">
												<div class="position-relative">
													<img class="img-fluid" src="img/animal-md-2.jpg" alt="">
													<div class="animal-text p-4">
														<p class="text-white small text-uppercase mb-0">Animal</p>
														<h5 class="text-white mb-0">Elephant</h5>
													</div>
												</div>
											</a>
										</div>
									</div>
								</div>
								<div class="col-lg-4 col-md-6 wow fadeInUp"
									data-wow-delay="0.5s"
									style="visibility: hidden; animation-delay: 0.5s; animation-name: none;">
									<div class="row g-4">
										<div class="col-12">
											<a class="animal-item" href="img/animal-md-3.jpg"
												data-lightbox="animal">
												<div class="position-relative">
													<img class="img-fluid" src="img/animal-md-3.jpg" alt="">
													<div class="animal-text p-4">
														<p class="text-white small text-uppercase mb-0">Animal</p>
														<h5 class="text-white mb-0">Elephant</h5>
													</div>
												</div>
											</a>
										</div>
										<div class="col-12">
											<a class="animal-item" href="img/animal-lg-3.jpg"
												data-lightbox="animal">
												<div class="position-relative">
													<img class="img-fluid" src="img/animal-lg-3.jpg" alt="">
													<div class="animal-text p-4">
														<p class="text-white small text-uppercase mb-0">Animal</p>
														<h5 class="text-white mb-0">Elephant</h5>
													</div>
												</div>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Animal End -->

					<!-- Visiting Hours Start -->
					<div
						class="container-xxl bg-primary visiting-hours my-5 py-5 wow fadeInUp"
						data-wow-delay="0.1s"
						style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
						<div class="container py-5">
							<div class="row g-5">
								<div class="col-md-6 wow fadeIn" data-wow-delay="0.3s"
									style="visibility: hidden; animation-delay: 0.3s; animation-name: none;">
									<h1 class="display-6 text-white mb-5">Visiting Hours</h1>
									<ul class="list-group list-group-flush">
										<li class="list-group-item"><span>Monday</span> <span>9:00AM
												- 6:00PM</span></li>
										<li class="list-group-item"><span>Tuesday</span> <span>9:00AM
												- 6:00PM</span></li>
										<li class="list-group-item"><span>Wednesday</span> <span>9:00AM
												- 6:00PM</span></li>
										<li class="list-group-item"><span>Thursday</span> <span>9:00AM
												- 6:00PM</span></li>
										<li class="list-group-item"><span>Friday</span> <span>9:00AM
												- 6:00PM</span></li>
										<li class="list-group-item"><span>Saturday</span> <span>9:00AM
												- 6:00PM</span></li>
										<li class="list-group-item"><span>Sunday</span> <span>Closed</span>
										</li>
									</ul>
								</div>
								<div class="col-md-6 text-light wow fadeIn"
									data-wow-delay="0.5s"
									style="visibility: hidden; animation-delay: 0.5s; animation-name: none;">
									<h1 class="display-6 text-white mb-5">Contact Info</h1>
									<table class="table">
										<tbody>
											<tr>
												<td>Office</td>
												<td>123 Street, New York, USA</td>
											</tr>
											<tr>
												<td>Zoo</td>
												<td>123 Street, New York, USA</td>
											</tr>
											<tr>
												<td>Ticket</td>
												<td>
													<p class="mb-2">+012 345 6789</p>
													<p class="mb-0">ticket@example.com</p>
												</td>
											</tr>
											<tr>
												<td>Support</td>
												<td>
													<p class="mb-2">+012 345 6789</p>
													<p class="mb-0">support@example.com</p>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- Visiting Hours End -->

					<!-- Membership Start -->
					<div class="container-xxl py-5">
						<div class="container">
							<div class="row g-5 mb-5 align-items-end wow fadeInUp"
								data-wow-delay="0.1s"
								style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
								<div class="col-lg-6">
									<p>
										<span class="text-primary me-2">#</span>Membership
									</p>
									<h1 class="display-5 mb-0">
										You Can Be A Proud Member Of <span class="text-primary">Zoofari</span>
									</h1>
								</div>
								<div class="col-lg-6 text-lg-end">
									<a class="btn btn-primary py-3 px-5" href="">Special
										Pricing</a>
								</div>
							</div>
							<div class="row g-4">
								<div class="col-lg-4 col-md-6 wow fadeInUp"
									data-wow-delay="0.1s"
									style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
									<div class="membership-item position-relative">
										<img class="img-fluid" src="img/animal-lg-1.jpg" alt="">
										<h1 class="display-1">01</h1>
										<h4 class="text-white mb-3">Popular</h4>
										<h3 class="text-primary mb-4">$99.00</h3>
										<p>
											<i class="fa fa-check text-primary me-3"></i>10% discount
										</p>
										<p>
											<i class="fa fa-check text-primary me-3"></i>2 adult and 2
											child
										</p>
										<p>
											<i class="fa fa-check text-primary me-3"></i>Free animal
											exhibition
										</p>
										<a class="btn btn-outline-light px-4 mt-3" href="">Get
											Started</a>
									</div>
								</div>
								<div class="col-lg-4 col-md-6 wow fadeInUp"
									data-wow-delay="0.3s"
									style="visibility: hidden; animation-delay: 0.3s; animation-name: none;">
									<div class="membership-item position-relative">
										<img class="img-fluid" src="img/animal-lg-2.jpg" alt="">
										<h1 class="display-1">02</h1>
										<h4 class="text-white mb-3">Standard</h4>
										<h3 class="text-primary mb-4">$149.00</h3>
										<p>
											<i class="fa fa-check text-primary me-3"></i>15% discount
										</p>
										<p>
											<i class="fa fa-check text-primary me-3"></i>4 adult and 4
											child
										</p>
										<p>
											<i class="fa fa-check text-primary me-3"></i>Free animal
											exhibition
										</p>
										<a class="btn btn-outline-light px-4 mt-3" href="">Get
											Started</a>
									</div>
								</div>
								<div class="col-lg-4 col-md-6 wow fadeInUp"
									data-wow-delay="0.5s"
									style="visibility: hidden; animation-delay: 0.5s; animation-name: none;">
									<div class="membership-item position-relative">
										<img class="img-fluid" src="img/animal-lg-3.jpg" alt="">
										<h1 class="display-1">03</h1>
										<h4 class="text-white mb-3">Premium</h4>
										<h3 class="text-primary mb-4">$199.00</h3>
										<p>
											<i class="fa fa-check text-primary me-3"></i>20% discount
										</p>
										<p>
											<i class="fa fa-check text-primary me-3"></i>6 adult and 6
											child
										</p>
										<p>
											<i class="fa fa-check text-primary me-3"></i>Free animal
											exhibition
										</p>
										<a class="btn btn-outline-light px-4 mt-3" href="">Get
											Started</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Membership End -->

					<!-- Testimonial Start -->
					<div class="container-xxl py-5">
						<div class="container">
							<h1 class="display-5 text-center mb-5 wow fadeInUp"
								data-wow-delay="0.1s"
								style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
								Our Clients Say!</h1>
							<div
								class="owl-carousel testimonial-carousel wow fadeInUp owl-loaded owl-drag"
								data-wow-delay="0.1s"
								style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">



								<div class="owl-stage-outer">
									<div class="owl-stage"
										style="transition: all; width: 4452px; transform: translate3d(-954px, 0px, 0px);">
										<div class="owl-item cloned" style="width: 636px;">
											<div class="testimonial-item text-center">
												<img
													class="img-fluid rounded-circle border border-2 p-2 mx-auto mb-4"
													src="img/testimonial-2.jpg"
													style="width: 100px; height: 100px">
												<div class="testimonial-text rounded text-center p-4">
													<p>Clita clita tempor justo dolor ipsum amet kasd amet
														duo justo duo duo labore sed sed. Magna ut diam sit et
														amet stet eos sed clita erat magna elitr erat sit sit erat
														at rebum justo sea clita.</p>
													<h5 class="mb-1">Patient Name</h5>
													<span class="fst-italic">Profession</span>
												</div>
											</div>
										</div>
										<div class="owl-item cloned" style="width: 636px;">
											<div class="testimonial-item text-center">
												<img
													class="img-fluid rounded-circle border border-2 p-2 mx-auto mb-4"
													src="img/testimonial-3.jpg"
													style="width: 100px; height: 100px">
												<div class="testimonial-text rounded text-center p-4">
													<p>Clita clita tempor justo dolor ipsum amet kasd amet
														duo justo duo duo labore sed sed. Magna ut diam sit et
														amet stet eos sed clita erat magna elitr erat sit sit erat
														at rebum justo sea clita.</p>
													<h5 class="mb-1">Patient Name</h5>
													<span class="fst-italic">Profession</span>
												</div>
											</div>
										</div>
										<div class="owl-item active center" style="width: 636px;">
											<div class="testimonial-item text-center">
												<img
													class="img-fluid rounded-circle border border-2 p-2 mx-auto mb-4"
													src="img/testimonial-1.jpg"
													style="width: 100px; height: 100px">
												<div class="testimonial-text rounded text-center p-4">
													<p>Clita clita tempor justo dolor ipsum amet kasd amet
														duo justo duo duo labore sed sed. Magna ut diam sit et
														amet stet eos sed clita erat magna elitr erat sit sit erat
														at rebum justo sea clita.</p>
													<h5 class="mb-1">Patient Name</h5>
													<span class="fst-italic">Profession</span>
												</div>
											</div>
										</div>
										<div class="owl-item active" style="width: 636px;">
											<div class="testimonial-item text-center">
												<img
													class="img-fluid rounded-circle border border-2 p-2 mx-auto mb-4"
													src="img/testimonial-2.jpg"
													style="width: 100px; height: 100px">
												<div class="testimonial-text rounded text-center p-4">
													<p>Clita clita tempor justo dolor ipsum amet kasd amet
														duo justo duo duo labore sed sed. Magna ut diam sit et
														amet stet eos sed clita erat magna elitr erat sit sit erat
														at rebum justo sea clita.</p>
													<h5 class="mb-1">Patient Name</h5>
													<span class="fst-italic">Profession</span>
												</div>
											</div>
										</div>
										<div class="owl-item" style="width: 636px;">
											<div class="testimonial-item text-center">
												<img
													class="img-fluid rounded-circle border border-2 p-2 mx-auto mb-4"
													src="img/testimonial-3.jpg"
													style="width: 100px; height: 100px">
												<div class="testimonial-text rounded text-center p-4">
													<p>Clita clita tempor justo dolor ipsum amet kasd amet
														duo justo duo duo labore sed sed. Magna ut diam sit et
														amet stet eos sed clita erat magna elitr erat sit sit erat
														at rebum justo sea clita.</p>
													<h5 class="mb-1">Patient Name</h5>
													<span class="fst-italic">Profession</span>
												</div>
											</div>
										</div>
										<div class="owl-item cloned" style="width: 636px;">
											<div class="testimonial-item text-center">
												<img
													class="img-fluid rounded-circle border border-2 p-2 mx-auto mb-4"
													src="img/testimonial-1.jpg"
													style="width: 100px; height: 100px">
												<div class="testimonial-text rounded text-center p-4">
													<p>Clita clita tempor justo dolor ipsum amet kasd amet
														duo justo duo duo labore sed sed. Magna ut diam sit et
														amet stet eos sed clita erat magna elitr erat sit sit erat
														at rebum justo sea clita.</p>
													<h5 class="mb-1">Patient Name</h5>
													<span class="fst-italic">Profession</span>
												</div>
											</div>
										</div>
										<div class="owl-item cloned" style="width: 636px;">
											<div class="testimonial-item text-center">
												<img
													class="img-fluid rounded-circle border border-2 p-2 mx-auto mb-4"
													src="img/testimonial-2.jpg"
													style="width: 100px; height: 100px">
												<div class="testimonial-text rounded text-center p-4">
													<p>Clita clita tempor justo dolor ipsum amet kasd amet
														duo justo duo duo labore sed sed. Magna ut diam sit et
														amet stet eos sed clita erat magna elitr erat sit sit erat
														at rebum justo sea clita.</p>
													<h5 class="mb-1">Patient Name</h5>
													<span class="fst-italic">Profession</span>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="owl-nav">
									<div class="owl-prev">
										<i class="bi bi-arrow-left"></i>
									</div>
									<div class="owl-next">
										<i class="bi bi-arrow-right"></i>
									</div>
								</div>
								<div class="owl-dots disabled"></div>
							</div>
						</div>
					</div>
					<!-- Testimonial End -->

					<!-- Footer Start -->
					<div
						class="container-fluid footer bg-dark text-light footer mt-5 pt-5 wow fadeIn"
						data-wow-delay="0.1s"
						style="visibility: hidden; animation-delay: 0.1s; animation-name: none;">
						<div class="container py-5">
							<div class="row g-5">
								<div class="col-lg-3 col-md-6">
									<h5 class="text-light mb-4">Address</h5>
									<p class="mb-2">
										<i class="fa fa-map-marker-alt me-3"></i>123 Street, New York,
										USA
									</p>
									<p class="mb-2">
										<i class="fa fa-phone-alt me-3"></i>+012 345 67890
									</p>
									<p class="mb-2">
										<i class="fa fa-envelope me-3"></i>info@example.com
									</p>
									<div class="d-flex pt-2">
										<a class="btn btn-outline-light btn-social" href=""><i
											class="fab fa-twitter"></i></a> <a
											class="btn btn-outline-light btn-social" href=""><i
											class="fab fa-facebook-f"></i></a> <a
											class="btn btn-outline-light btn-social" href=""><i
											class="fab fa-youtube"></i></a> <a
											class="btn btn-outline-light btn-social" href=""><i
											class="fab fa-linkedin-in"></i></a>
									</div>
								</div>
								<div class="col-lg-3 col-md-6">
									<h5 class="text-light mb-4">Quick Links</h5>
									<a class="btn btn-link" href="">About Us</a> <a
										class="btn btn-link" href="">Contact Us</a> <a
										class="btn btn-link" href="">Our Services</a> <a
										class="btn btn-link" href="">Terms &amp; Condition</a> <a
										class="btn btn-link" href="">Support</a>
								</div>
								<div class="col-lg-3 col-md-6">
									<h5 class="text-light mb-4">Popular Links</h5>
									<a class="btn btn-link" href="">About Us</a> <a
										class="btn btn-link" href="">Contact Us</a> <a
										class="btn btn-link" href="">Our Services</a> <a
										class="btn btn-link" href="">Terms &amp; Condition</a> <a
										class="btn btn-link" href="">Support</a>
								</div>
								<div class="col-lg-3 col-md-6">
									<h5 class="text-light mb-4">Newsletter</h5>
									<p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
									<div class="position-relative mx-auto" style="max-width: 400px">
										<input class="form-control border-0 w-100 py-3 ps-4 pe-5"
											type="text" placeholder="Your email">
										<button type="button"
											class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">
											SignUp</button>
									</div>
								</div>
							</div>
						</div>
						<div class="container">
							<div class="copyright">
								<div class="row">
									<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
										© <a class="border-bottom" href="#">Your Site Name</a>, All
										Right Reserved.
									</div>
									<div class="col-md-6 text-center text-md-end">
										<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
										Designed By <a class="border-bottom"
											href="https://htmlcodex.com">HTML Codex</a> <br>Distributed
										By: <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Footer End -->

					<!-- Back to Top -->
					<a href="#"
						class="btn btn-lg btn-primary btn-lg-square back-to-top" style=""><i
						class="bi bi-arrow-up"></i></a>

					<!-- JavaScript Libraries -->
					<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
					<script
						src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
					<script src="lib/wow/wow.min.js"></script>
					<script src="lib/easing/easing.min.js"></script>
					<script src="lib/waypoints/waypoints.min.js"></script>
					<script src="lib/counterup/counterup.min.js"></script>
					<script src="lib/owlcarousel/owl.carousel.min.js"></script>
					<script src="lib/lightbox/js/lightbox.min.js"></script>

					<!-- Template Javascript -->
					<script src="js/main.js"></script>


					<div id="lightboxOverlay" class="lightboxOverlay"
						style="display: none;"></div>
					<div id="lightbox" class="lightbox" style="display: none;">
						<div class="lb-outerContainer">
							<div class="lb-container">
								<img class="lb-image"
									src="data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==">
								<div class="lb-nav">
									<a class="lb-prev" href=""></a><a class="lb-next" href=""></a>
								</div>
								<div class="lb-loader">
									<a class="lb-cancel"></a>
								</div>
							</div>
						</div>
						<div class="lb-dataContainer">
							<div class="lb-data">
								<div class="lb-details">
									<span class="lb-caption"></span><span class="lb-number"></span>
								</div>
								<div class="lb-closeContainer">
									<a class="lb-close"></a>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
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
</body>

</html>