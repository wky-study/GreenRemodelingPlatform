<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SeoDash Free Bootstrap Admin Template by Adminmart</title>



</head>

<body>

	<%@ include file="/WEB-INF/inc/header.jsp" %>

	<!--  Header End -->
<div class="container-fluid">
        <div class="row">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title d-flex align-items-center gap-2 mb-4">
                  오늘의 추천

                </h5>
                <div id="carouselExampleControls" class="carousel slide carousel-dark" data-bs-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item">
                      <img src="${pageContext.request.contextPath}/assets/images/blog/blog-img2.jpg" class="d-block w-100" alt="seodash-img">
                    </div>
                    <div class="carousel-item active">
                      <img src="${pageContext.request.contextPath}/assets/images/blog/blog-img3.jpg" class="d-block w-100" alt="seodash-img">
                    </div>
                    <div class="carousel-item">
                      <img src="${pageContext.request.contextPath}/assets/images/blog/blog-img2.jpg" class="d-block w-100" alt="seodash-img">
                    </div>
                  </div>
                  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                  </a>
                  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                  </a>
                </div>
              </div>
            </div>
          </div>

          <!-- card -->
          <div class="col-lg-4" style="padding-top: 30.5px;">
            <div class="card">
              <h5 class="card-title d-flex align-items-center gap-2 mb-4">
                Eco-Builders

              </h5>
              <div class="row gx-3">
                <div class="col-6">
                  
                  <div class="card text-white bg-primary rounded">
                    <div class="card-body p-4">
                      <span>
                        <i class="ti ti-layout-grid fs-8"></i>
                      </span>
                      <h3 class="card-title mt-3 mb-0 text-white">450</h3>
                      <p class="card-text text-white-50 fs-3 fw-normal">
                        고효율 가전제품
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-6">
                  <div class="card text-white text-bg-success">
                    <div class="card-body p-4">
                      <span>
                        <i class="ti ti-archive fs-8"></i>
                      </span>
                      <h3 class="card-title mt-3 mb-0 text-white">50</h3>
                      <p class="card-text text-white-50 fs-3 fw-normal">
                        친환경 자재
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-6">
                  <div class="card text-white text-bg-warning">
                    <div class="card-body p-4">
                      <span>
                        <i class="ti ti-users fs-8"></i>
                      </span>
                      <h3 class="card-title mt-3 mb-0 text-white">80</h3>
                      <p class="card-text text-white-50 fs-3 fw-normal">
                        리모델링 후기
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-6">
                  <div class="card text-white text-bg-danger">
                    <div class="card-body p-4">
                      <span>
                        <i class="ti ti-gift fs-8"></i>
                      </span>
                      <h3 class="card-title mt-3 mb-0 text-white">15</h3>
                      <p class="card-text text-white-50 fs-3 fw-normal">
                        데이터 분석
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-12 mt-3">
              <div class="card w-100">
                <div class="card-header text-bg-primary">
                  <h4 class="mb-0 text-white card-title">프로젝트 소개</h4>
                </div>
                <div class="card-body">
                  <h3 class="card-title">Special title treatment</h3>
                  <p class="card-text">
                    With supporting text below as a natural lead-in to additional content.
                  </p>
                  <a href="javascript:void(0)" class="btn btn-primary">Go somewhere</a>
                </div>
              </div>
            </div>
          </div>
          <!-- card end -->


          <div class="card">
            <div class="card-body">

              <h4 class="card-title">그린 리모델링 소개</h4>

              <p class="mb-3 card-subtitle">
                If you need responsive nav variations, consider using a
                series of flexbox utilities.
              </p>
              <!-- Nav tabs -->
              <ul class="nav nav-pills flex-column flex-sm-row mt-4" role="tablist">
                <li class="nav-item flex-sm-fill text-sm-center" role="presentation">
                  <a class="nav-link active" data-bs-toggle="tab" href="#navpill-11" role="tab" aria-selected="true">
                    <span>Tab 1</span>
                  </a>
                </li>
                <li class="nav-item flex-sm-fill text-sm-center" role="presentation">
                  <a class="nav-link" data-bs-toggle="tab" href="#navpill-22" role="tab" aria-selected="false"
                    tabindex="-1">
                    <span>Tab 2</span>
                  </a>
                </li>
                <li class="nav-item flex-sm-fill text-sm-center" role="presentation">
                  <a class="nav-link" data-bs-toggle="tab" href="#navpill-33" role="tab" aria-selected="false"
                    tabindex="-1">
                    <span>Tab 3</span>
                  </a>
                </li>
              </ul>
              <!-- Tab panes -->
              <div class="tab-content border mt-2">
                <div class="tab-pane p-3 active show" id="navpill-11" role="tabpanel">
                  <div class="row">
                    <div class="col-md-4">
                      <img src="${pageContext.request.contextPath}/assets/images/blog/blog-img2.jpg" alt="seodash-img" class="img-fluid">
                    </div>
                    <div class="col-md-8">
                      <p>
                        Raw denim you probably haven't heard of them jean
                        shorts Austin. Nesciunt tofu stumptown aliqua,
                        retro synth master cleanse. Mustache cliche
                        tempor, williamsburg carles vegan helvetica.
                      </p>
                    </div>
                  </div>
                </div>
                <div class="tab-pane p-3" id="navpill-22" role="tabpanel">
                  <div class="row">
                    <div class="col-md-8">
                      <p>
                        Raw denim you probably haven't heard of them jean
                        shorts Austin. Nesciunt tofu stumptown aliqua,
                        retro synth master cleanse. Mustache cliche
                        tempor, williamsburg carles vegan helvetica.
                      </p>
                    </div>
                    <div class="col-md-4">
                      <img src="${pageContext.request.contextPath}/assets/images/blog/blog-img1.jpg" alt="seodash-img" class="img-fluid">
                    </div>
                  </div>
                </div>
                <div class="tab-pane p-3" id="navpill-33" role="tabpanel">
                  <div class="row">
                    <div class="col-md-4">
                      <img src="${pageContext.request.contextPath}/assets/images/blog/blog-img3.jpg" alt="seodash-img" class="img-fluid">
                    </div>
                    <div class="col-md-8">
                      <p>
                        Raw denim you probably haven't heard of them jean
                        shorts Austin. Nesciunt tofu stumptown aliqua,
                        retro synth master cleanse. Mustache cliche
                        tempor, williamsburg carles vegan helvetica.
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Notice</h5>
                <div class="table-responsive">
                  <table class="table text-nowrap align-middle mb-0">
                    <thead>
                      <tr class="border-2 border-bottom border-primary border-0">
                        <th scope="col" class="ps-0">Page Title</th>
                        <th scope="col">Link</th>
                        <th scope="col" class="text-center">Pageviews</th>
                        <th scope="col" class="text-center">Page Value</th>
                      </tr>
                    </thead>
                    <tbody class="table-group-divider">
                      <tr>
                        <th scope="row" class="ps-0 fw-medium">
                          <span class="table-link1 text-truncate d-block">Welcome to our
                            website</span>
                        </th>
                        <td>
                          <a href="javascript:void(0)" class="link-primary text-dark fw-medium d-block">/index.html</a>
                        </td>
                        <td class="text-center fw-medium">18,456</td>
                        <td class="text-center fw-medium">$2.40</td>
                      </tr>
                      <tr>
                        <th scope="row" class="ps-0 fw-medium">
                          <span class="table-link1 text-truncate d-block">Modern Admin
                            Dashboard Template</span>
                        </th>
                        <td>
                          <a href="javascript:void(0)" class="link-primary text-dark fw-medium d-block">/dashboard</a>
                        </td>
                        <td class="text-center fw-medium">17,452</td>
                        <td class="text-center fw-medium">$0.97</td>
                      </tr>
                      <tr>
                        <th scope="row" class="ps-0 fw-medium">
                          <span class="table-link1 text-truncate d-block">Explore our
                            product catalog</span>
                        </th>
                        <td>
                          <a href="javascript:void(0)"
                            class="link-primary text-dark fw-medium d-block">/product-checkout</a>
                        </td>
                        <td class="text-center fw-medium">12,180</td>
                        <td class="text-center fw-medium">$7,50</td>
                      </tr>
                      <tr>
                        <th scope="row" class="ps-0 fw-medium">
                          <span class="table-link1 text-truncate d-block">Comprehensive
                            User Guide</span>
                        </th>
                        <td>
                          <a href="javascript:void(0)" class="link-primary text-dark fw-medium d-block">/docs</a>
                        </td>
                        <td class="text-center fw-medium">800</td>
                        <td class="text-center fw-medium">$5,50</td>
                      </tr>
                      <tr>
                        <th scope="row" class="ps-0 fw-medium border-0">
                          <span class="table-link1 text-truncate d-block">Check out our
                            services</span>
                        </th>
                        <td class="border-0">
                          <a href="javascript:void(0)" class="link-primary text-dark fw-medium d-block">/services</a>
                        </td>
                        <td class="text-center fw-medium border-0">1300</td>
                        <td class="text-center fw-medium border-0">$2,15</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4" style="padding: 30px;">
            <div class="card-body">

              <div class="mb-4">
                <h4 class="card-title mb-0">FAQ</h4>
              </div>
              <div class="accordion accordion-flush" id="accordionFlushExample">
                <div class="accordion-item">
                  <h2 class="accordion-header" id="flush-headingOne">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                      data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                      Accordion Item #1
                    </button>
                  </h2>
                  <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne"
                    data-bs-parent="#accordionFlushExample" style="">
                    <div class="accordion-body">
                      Anim pariatur cliche reprehenderit, enim eiusmod
                      high life accusamus terry richardson ad squid. 3
                      wolf moon officia aute, non cupidatat skateboard
                      dolor brunch. Food truck quinoa nesciunt laborum
                      eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put
                      a bird on it squid single-origin coffee nulla
                      assumenda shoreditch et. Nihil anim keffiyeh
                      helvetica, craft beer labore wes anderson cred
                      nesciunt sapiente ea proident. Ad vegan excepteur
                      butcher vice lomo. Leggings occaecat craft beer
                      farm-to-table, raw denim aesthetic synth nesciunt
                      you probably haven't heard of them accusamus labore
                      sustainable VHS.
                    </div>
                  </div>
                </div>
                <div class="accordion-item">
                  <h2 class="accordion-header" id="flush-headingTwo">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                      data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                      Accordion Item #2
                    </button>
                  </h2>
                  <div id="flush-collapseTwo" class="accordion-collapse collapse" aria-labelledby="flush-headingTwo"
                    data-bs-parent="#accordionFlushExample" style="">
                    <div class="accordion-body">
                      Anim pariatur cliche reprehenderit, enim eiusmod
                      high life accusamus terry richardson ad squid. 3
                      wolf moon officia aute, non cupidatat skateboard
                      dolor brunch. Food truck quinoa nesciunt laborum
                      eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put
                      a bird on it squid single-origin coffee nulla
                      assumenda shoreditch et. Nihil anim keffiyeh
                      helvetica, craft beer labore wes anderson cred
                      nesciunt sapiente ea proident. Ad vegan excepteur
                      butcher vice lomo. Leggings occaecat craft beer
                      farm-to-table, raw denim aesthetic synth nesciunt
                      you probably haven't heard of them accusamus labore
                      sustainable VHS.
                    </div>
                  </div>
                </div>
                <div class="accordion-item">
                  <h2 class="accordion-header" id="flush-headingThree">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                      data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                      Accordion Item #3
                    </button>
                  </h2>
                  <div id="flush-collapseThree" class="accordion-collapse collapse" aria-labelledby="flush-headingThree"
                    data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">
                      Anim pariatur cliche reprehenderit, enim eiusmod
                      high life accusamus terry richardson ad squid. 3
                      wolf moon officia aute, non cupidatat skateboard
                      dolor brunch. Food truck quinoa nesciunt laborum
                      eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put
                      a bird on it squid single-origin coffee nulla
                      assumenda shoreditch et. Nihil anim keffiyeh
                      helvetica, craft beer labore wes anderson cred
                      nesciunt sapiente ea proident. Ad vegan excepteur
                      butcher vice lomo. Leggings occaecat craft beer
                      farm-to-table, raw denim aesthetic synth nesciunt
                      you probably haven't heard of them accusamus labore
                      sustainable VHS.
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

        <div class="row" style="padding: 30px; margin: 0;">
          <h4 class="card-title" style="padding: 15px; color: #3a4752;">Review</h4>

          <div class="col-lg-4">
            <div class="card overflow-hidden hover-img">
              <div class="position-relative">
                <a href="javascript:void(0)">
                  <img src="${pageContext.request.contextPath}/assets/images/blog/blog-img1.jpg" class="card-img-top" alt="matdash-img">
                </a>
                <span
                  class="badge text-bg-light text-dark fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                  min Read</span>
                <img src="${pageContext.request.contextPath}/assets/images/profile/user-3.jpg" alt="matdash-img"
                  class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40"
                  data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Georgeanna Ramero">
              </div>
              <div class="card-body p-4">
                <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Social</span>
                <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="">As yen tumbles, gadget-loving
                  Japan goes
                  for secondhand iPhones</a>
                <div class="d-flex align-items-center gap-4">
                  <div class="d-flex align-items-center gap-2">
                    <i class="ti ti-eye text-dark fs-5"></i>9,125
                  </div>
                  <div class="d-flex align-items-center gap-2">
                    <i class="ti ti-message-2 text-dark fs-5"></i>3
                  </div>
                  <div class="d-flex align-items-center fs-2 ms-auto">
                    <i class="ti ti-point text-dark"></i>Mon, Dec 19
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="card overflow-hidden hover-img">
              <div class="position-relative">
                <a href="javascript:void(0)">
                  <img src="${pageContext.request.contextPath}/assets/images/blog/blog-img2.jpg" class="card-img-top" alt="matdash-img">
                </a>
                <span
                  class="badge text-bg-light text-dark fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                  min Read</span>
                <img src="${pageContext.request.contextPath}/assets/images/profile/user-2.jpg" alt="matdash-img"
                  class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40"
                  data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Georgeanna Ramero">
              </div>
              <div class="card-body p-4">
                <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Gadget</span>
                <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="">Intel loses bid to revive
                  antitrust case
                  against patent foe Fortress</a>
                <div class="d-flex align-items-center gap-4">
                  <div class="d-flex align-items-center gap-2">
                    <i class="ti ti-eye text-dark fs-5"></i>4,150
                  </div>
                  <div class="d-flex align-items-center gap-2">
                    <i class="ti ti-message-2 text-dark fs-5"></i>38
                  </div>
                  <div class="d-flex align-items-center fs-2 ms-auto">
                    <i class="ti ti-point text-dark"></i>Sun, Dec 18
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4">
            <div class="card overflow-hidden hover-img">
              <div class="position-relative">
                <a href="javascript:void(0)">
                  <img src="${pageContext.request.contextPath}/assets/images/blog/blog-img3.jpg" class="card-img-top" alt="matdash-img">
                </a>
                <span
                  class="badge text-bg-light text-dark fs-2 lh-sm mb-9 me-9 py-1 px-2 fw-semibold position-absolute bottom-0 end-0">2
                  min Read</span>
                <img src="${pageContext.request.contextPath}/assets/images/profile/user-3.jpg" alt="matdash-img"
                  class="img-fluid rounded-circle position-absolute bottom-0 start-0 mb-n9 ms-9" width="40" height="40"
                  data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Georgeanna Ramero">
              </div>
              <div class="card-body p-4">
                <span class="badge text-bg-light fs-2 py-1 px-2 lh-sm  mt-3">Health</span>
                <a class="d-block my-4 fs-5 text-dark fw-semibold link-primary" href="">COVID outbreak deepens as more
                  lockdowns
                  loom in China</a>
                <div class="d-flex align-items-center gap-4">
                  <div class="d-flex align-items-center gap-2">
                    <i class="ti ti-eye text-dark fs-5"></i>9,480
                  </div>
                  <div class="d-flex align-items-center gap-2">
                    <i class="ti ti-message-2 text-dark fs-5"></i>12
                  </div>
                  <div class="d-flex align-items-center fs-2 ms-auto">
                    <i class="ti ti-point text-dark"></i>Sat, Dec 17
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
          <div class="py-6 px-6 text-center">
            <p class="mb-0 fs-4">Design and Developed by <a href="https://adminmart.com/" target="_blank"
                class="pe-1 text-primary text-decoration-underline">AdminMart.com</a>Distributed by <a
                href="https://themewagon.com/" target="_blank"
                class="pe-1 text-primary text-decoration-underline">ThemeWagon</a></p>
          </div>
        </div>
      </div>
    </div>

<%@ include file="/WEB-INF/inc/footer.jsp" %>

</body>

</html>
