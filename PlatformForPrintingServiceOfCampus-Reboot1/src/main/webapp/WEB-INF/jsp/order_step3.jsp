<%@page import="pfpsc.constant.RequestMapConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"
	name="viewport">
<title>空白页 &mdash; 快印平台</title>

<!-- General CSS Files -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<!-- CSS Libraries -->

<!-- Template CSS -->
<link rel="stylesheet" href="./assets/css/style.css">
<link rel="stylesheet" href="./assets/css/components.css">
</head>

<body>
	<div id="app">
		<div class="main-wrapper">

			<%@include file="./assets/pageRef/navbar.jsp"%>
			<%@include file="./assets/pageRef/sidebar_customer.jsp"%>


			<!-- Main Content -->
			<div class="main-content">
				<section class="section">
					<div class="section-header">
						<h1>选择您期望的商家</h1>
					</div>

					<div class="section-body">
						<form:form id="form" modelAttribute="order">
							<div class="row">
								<label>选择您的商家</label>
								<form:select class="form-control" id="selectShop"
									 data-height="100%" path="shopId"
									onchange="javascript:calculateFee()">
									<form:option value="-1" label="请选择..." />
									<form:options items="${shopMap}" itemValue="id"
										itemLabel="name" />
								</form:select>
							</div>
							<div class="row">
								<label>您将支付的的费用</label> <input type="text" class="form-control"
									readonly="" id="fee"></input>
							</div>
							<div class="row" name="next-button">
								<div class="col-10"></div>
								<div class="col-2">
									<a href="javascript:next()" class="btn btn-primary">下一步</a>
								</div>
							</div>
						</form:form>

					</div>
				</section>
			</div>
			<%@include file="./assets/pageRef/footer_common.jsp"%>
		</div>

	</div>
	<script>
		function next() {
			$.ajax({
				url : "<%= RequestMapConstant.transfer %>",
				type : "POST",
				data : $('#form').serialize(),
				success : function(data) {
					if(data=="100"){
						window.location.replace(<%= RequestMapConstant.order_step4 %>);
					}
					else{
						//TODO
					}
				}
			});
		}
		function calculateFee() {
			$.ajax({
				url : "<%= RequestMapConstant.calculateFee %>",
				type : "POST",
				data : $('#form').serialize(),
				success : function(data) {
					var fee=JSON.parse(data);
					var element = document.getElementById("fee");
					element.setAttribute("value",fee);
				}
			});
		}
	</script>

	<!-- General JS Scripts -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.nicescroll/3.7.6/jquery.nicescroll.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
	<script src="./assets/js/stisla.js"></script>

	<!-- JS Libraies -->

	<!-- Template JS File -->
	<script src="./assets/js/scripts.js"></script>
	<script src="./assets/js/custom.js"></script>

	<!-- Page Specific JS File -->
</body>
</html>
