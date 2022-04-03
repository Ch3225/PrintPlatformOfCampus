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
			<%@include file="./assets/pageRef/sidebar_customer.jsp"%>


			<!-- Main Content -->
			<div class="main-content">
				<section class="section">
					<div class="section-header">
						<h1>选择您要打印的文件</h1>
					</div>

					<div class="section-body">
						<div class="section-title">File Browser</div>
						<div class="row">
							<div class="col-9">
								<div class="custom-file col-12">
									<form enctype="multipart/form-data" id="fileform">
										<input type="file" class="custom-file-input" id="customFile"
											name="customFile" onchange="javascript:fileSelected();">
										<label class="custom-file-label" for="customFile"
											id="fileName">Choose file</label>
									</form>
								</div>
								<div class="progress mb-3">
									<div class="progress-bar" role="progressbar" data-width="0%"
										aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
										id="progress-bar">0%</div>
								</div>
							</div>
							<div class="col-3">
								<a href="javascript:uploadFile();"
									class="btn btn-primary btn-lg btn-block btn-icon-split col12">
									<i class="fas fa-rocket"></i> 上传！
								</a>
							</div>
						</div>
						<div class="row" name="next-button">
								<div class="col-10"></div>
								<div class="col-2">
									<a href="order_step2" class="btn btn-primary">下一步</a>
								</div>
							</div>
					</div>
				</section>
				<section class="section"></section>
			</div>
			<%@include file="./assets/pageRef/footer_common.jsp"%>

		</div>
	</div>

	<script>
		function fileSelected() {
			var t_files = document.getElementById('customFile').files;
			console.log(t_files);
			var str = '';
			str += t_files[0].name + ', ';
			unit = 'KB';
			var size = t_files[0].size;
			size /= 1024;
			if (size >= 1024) {
				size /= 1024;
				unit = 'MB';
			}
			size = size.toFixed(2);
			str += 'size:' + size + unit;
			document.getElementById('fileName').innerHTML = str;
		}

		function uploadFile() {
			$.ajax({
				url : "uploadFile",
				type : "POST",
				data : new FormData($("#fileform")[0]),
				processData : false,//告诉ajax不要处理和编码这些数据，直接提交
				contentType : false,//不使用默认的内容类型
				xhr : function() {
					var xhr = new XMLHttpRequest();
					//使用XMLHttpRequest.upload监听上传过程，注册progress事件，打印回调函数中的event事件
					xhr.upload.addEventListener('progress', function(e) {
						console.log(e);
						//loaded代表上传了多少
						//total代表总数为多少
						var progressRate = (e.loaded / e.total) * 100;

						//通过设置进度条的宽度达到效果
						updateProgress(progressRate);
					})

					return xhr;
				},
				success: function(){
					
				}
			});
		}

		function updateProgress(progressRate) {
			document.getElementById('progress-bar').setAttribute("data-width",
					'' + progressRate.toFixed(0) + '%');
			document.getElementById('progress-bar').setAttribute(
					"aria-valuenow", '' + progressRate.toFixed(0));
			document.getElementById('progress-bar').setAttribute("style",
					'width: ' + progressRate.toFixed(0) + '%');
			document.getElementById('progress-bar').innerHTML = progressRate
					.toFixed(2)
					+ '%';
			objPro.value = percentComplete.toString();

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
