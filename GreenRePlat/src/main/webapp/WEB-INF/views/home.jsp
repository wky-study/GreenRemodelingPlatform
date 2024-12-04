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

	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<!--  Header End -->
	<div class="container-fluid">

                </h5>
                <div id="carouselExampleControls" class="carousel slide carousel-dark" data-bs-ride="carousel">
                  <div class="carousel-inner">
                    <div class="carousel-item">
                      <img src="${pageContext.request.contextPath}/assets/images/blog/img1.jpg" class="d-block w-100" alt="seodash-img">
                    </div>
                    <div class="carousel-item active">
                      <img src="${pageContext.request.contextPath}/assets/images/blog/img3.jpg" class="d-block w-100" alt="seodash-img">
                    </div>
                    <div class="carousel-item">
                      <img src="${pageContext.request.contextPath}/assets/images/blog/img2.jpg" class="d-block w-100" alt="seodash-img">
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
          
          <div class="col-lg-4 col-md-6" style="padding-top: 150px; ">
              <!-- Card -->
              <div class="card">
                <img class="card-img-top img-responsive" src="http://www.cenews.co.kr/news/photo/202010/10229_6425_024.png" alt="Card image cap">
                <div class="card-body">
                  <h4 class="card-title">Card title</h4>
                  <p class="card-text">
                    Some quick example text to build on the card title and make up the bulk of the card's content.
                  </p>
                  <a href="javascript:void(0)" class="btn btn-primary">바로가기</a>
                </div>
              </div>
              <!-- Card -->
            </div>

          
            
          </div>
         


         

          <div class="container">
  			<div class="card row" style="display: flex; flex-direction: row;">
              <div class="card-body col-7">
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
              <div class="card-body col-3">

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
          </div>
          <div class="col-lg-4" style="padding: 30px;">
            
          </div>

        <div class="row" style="padding: 30px; margin: 0;">
          
         
          <div class="py-6 px-6 text-center">
            <p class="mb-0 fs-4">Design and Developed by <a href="https://adminmart.com/" target="_blank"
                class="pe-1 text-primary text-decoration-underline">AdminMart.com</a>Distributed by <a
                href="https://themewagon.com/" target="_blank"
                class="pe-1 text-primary text-decoration-underline">ThemeWagon</a></p>
          </div>
        </div>
      </div>
    </div>





	<%@ include file="/WEB-INF/inc/footer.jsp"%>

</body>

</html>
