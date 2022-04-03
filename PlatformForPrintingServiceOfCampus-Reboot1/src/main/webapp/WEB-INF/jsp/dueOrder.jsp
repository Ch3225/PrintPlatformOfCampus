<%@page import="pfpsc.constant.EntityPropertyConstant"%>
<%@page import="org.apache.tomcat.util.bcel.classfile.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
			<%@include file="./assets/pageRef/sidebar_shop_owner.jsp"%>
			<!-- Main Content -->
			<div class="main-content">
				<section class="section">
					<div class="section-header">
						<h1>您现在需要处理的订单</h1>
					</div>
					<div class="row">
						<div class="col-12 col-md-12">
							<div class="card">
								<div class="card-header">
									<h4>您现在需要处理的订单</h4>
									<div class="card-header-action">
										<a href="javascript:requestTrade()" class="btn btn-primary">
											View All </a>
									</div>
								</div>
								<div class="card-body">
									<table class="table">
										<thead>
											<tr>
												<th scope="col">ID</th>
												<th scope="col">文档</th>
												<th scope="col">打印方式</th>
												<th scope="col">打印份数</th>
												<th scope="col">操作</th>
											</tr>
										</thead>
										<tbody id="tbody">

										</tbody>
									</table>

								</div>

								<form action="document" id="fileForm" method="post"
									style="display: none;">
									<input id="documentMd5" name="documentMd5" type="text">
								</form>
							</div>
						</div>
					</div>
					<div class="section-body"></div>
				</section>
			</div>

			<%@include file="./assets/pageRef/footer_common.jsp"%>
		</div>
	</div>


	<script>
		function refill(data) {
			var tbody = document.getElementById('tbody');
			tbody.innerHTML="";
			for (var i = 0; i < data.length; i++) { //遍历一下json数据 
				var trow = getDataRow(data[i]); //定义一个方法,返回tr数据 
				tbody.appendChild(trow);
			}
		}
		function getDataRow(datarow) {
			var row = document.createElement('tr'); //创建行 

			var idCell = document.createElement('th'); //创建第一列id 
			idCell.scope = "col";
			idCell.innerHTML = datarow.id; //填充数据 
			row.appendChild(idCell); //加入行

			var fileCell = document.createElement('td'); //创建第一列id 
			var downloader = getButtonDownloaderByMd5(datarow.documentMd5);
			row.appendChild(downloader);

			var methodCell = document.createElement('td');
			methodCell.innerHTML = datarow.methodString; //填充数据 
			row.appendChild(methodCell); //加入行

			var countCell = document.createElement('td');
			countCell.innerHTML = datarow.count; //填充数据 
			row.appendChild(countCell); //加入行

			var buttonCell = document.createElement('td');
			var finisher = getButtonFinisherByTradeId(datarow.id);
			row.appendChild(finisher); //加入行

			return row;
		}

		function getButtonDownloaderByMd5(documentMd5) {
			var buttonCell = document.createElement('a');
			buttonCell.href = "javascript:getDocumentByMd5(\"" + documentMd5
					+ "\")";
			buttonCell.innerHTML = documentMd5; //填充数据 
			return buttonCell;
		}
		function getButtonFinisherByTradeId(tradeId) {
			var buttonCell = document.createElement('a');
			buttonCell.href = "javascript:dueAPendingTrade(\"" + tradeId
					+ "\")";
			buttonCell.innerHTML = "完成该订单"; //填充数据 
			return buttonCell;
		}

		function requestTrade() {
			$.ajax({
				url : "allPendingTrades",
				type : "POST",
				success : function(data) {
					refill(data);
				}
			});
		}
		function getDocumentByMd5(stringMD5) {
			$("#documentMd5").attr('value', stringMD5);
			$("#fileForm").submit();
		}
		function dueAPendingTrade(orderId) {
			$.ajax({
				url : "dueAPendingTrade",
				type : "POST",
				data : {
					tradeId : orderId
				},
				success : function(data) {
					requestTrade();
				}
			});
		}
	</script>
	<script>
		requestTrade();
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
