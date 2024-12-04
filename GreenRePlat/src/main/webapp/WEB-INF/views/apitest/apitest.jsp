<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>

</head>

<body>
	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<div class="container-fluid">
		<div class="card">
			<div class="d-flex justify-content-end align-items-center mt-3 mb-3">
			<form action="${pageContext.request.contextPath}/getProducts" method = "post">
			 <input	type="text" class="form-control" id="memid" value="user1"
											name="memId">
				<button class="btn btn-outline-info me-3" id="orderBtn"
					type="submit">api호출</button>
					</form>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/inc/footer.jsp"%>

</body>

</html>
