<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lacg="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/inc/header.jsp" %>
		
					<div class="col-lg-8">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">게 시 글</h5>
						<div class="table-responsive">
							<table class="table text-nowrap align-middle mb-0">
								<thead>
									<tr class="border-2 border-bottom border-primary border-0">
										<th scope="col" class="ps-0">제 목</th>
										<th scope="col">Link</th>
										<th scope="col" class="text-center">조 회 수</th>
										<th scope="col" class="text-center">작 성 자</th>
									</tr>
								</thead>
								<tbody class="table-group-divider">
									<tr>
										<th scope="row" class="ps-0 fw-medium"><span
											class="table-link1 text-truncate d-block">Welcome to
												our website</span></th>
										<td><a href="javascript:void(0)"
											class="link-primary text-dark fw-medium d-block">/index.html</a>
										</td>
										<td class="text-center fw-medium">18,456</td>
										<td class="text-center fw-medium">$2.40</td>
									</tr>
									<tr>
										<th scope="row" class="ps-0 fw-medium"><span
											class="table-link1 text-truncate d-block">Modern Admin
												Dashboard Template</span></th>
										<td><a href="javascript:void(0)"
											class="link-primary text-dark fw-medium d-block">/dashboard</a>
										</td>
										<td class="text-center fw-medium">17,452</td>
										<td class="text-center fw-medium">$0.97</td>
									</tr>
									<tr>
										<th scope="row" class="ps-0 fw-medium"><span
											class="table-link1 text-truncate d-block">Explore our
												product catalog</span></th>
										<td><a href="javascript:void(0)"
											class="link-primary text-dark fw-medium d-block">/product-checkout</a>
										</td>
										<td class="text-center fw-medium">12,180</td>
										<td class="text-center fw-medium">$7,50</td>
									</tr>
									<tr>
										<th scope="row" class="ps-0 fw-medium"><span
											class="table-link1 text-truncate d-block">Comprehensive
												User Guide</span></th>
										<td><a href="javascript:void(0)"
											class="link-primary text-dark fw-medium d-block">/docs</a></td>
										<td class="text-center fw-medium">800</td>
										<td class="text-center fw-medium">$5,50</td>
									</tr>
									<tr>
										<th scope="row" class="ps-0 fw-medium border-0"><span
											class="table-link1 text-truncate d-block">Check out
												our services</span></th>
										<td class="border-0"><a href="javascript:void(0)"
											class="link-primary text-dark fw-medium d-block">/services</a>
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
			


				
	<%@include file="/WEB-INF/inc/footer.jsp" %>

</body>
</html>