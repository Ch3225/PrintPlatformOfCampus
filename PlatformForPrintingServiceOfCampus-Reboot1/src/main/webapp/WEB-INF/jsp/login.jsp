<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no"
	name="viewport">
<title>登录 &mdash; 快印平台</title>

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
<link rel="stylesheet"
	href="../node_modules/bootstrap-social/bootstrap-social.css">

<!-- Template CSS -->
<link rel="stylesheet" href="./assets/css/style.css">
<link rel="stylesheet" href="./assets/css/components.css">
</head>

<body>
	<div id="app">
		<section class="section">
			<div class="container mt-5">
				<div class="row">
					<div
						class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">

						<div class="card card-primary">
							<div class="card-header">
								<h4>登陆</h4>
							</div>

							<div class="card-body">
								<form id="form" method="POST" action="login"
									class="needs-validation" novalidate="">
									<div class="form-group">
										<label for="phone">手机号码</label> <input id="phone"
											type="text" class="form-control" name="phone" tabindex="1"
											required autofocus>
										<div class="invalid-feedback">请输入您的手机号码！</div>
									</div>

									<div class="form-group">
										<div class="d-block">
											<label for="password" class="control-label">密码</label>
											<div class="float-right">
												<a href="#" class="text-small">
													忘记密码了？ </a>
											</div>
										</div>
										<input id="password" type="password" class="form-control"
											name="password" tabindex="2" required>
										<div class="invalid-feedback">请输入密码！</div>
									</div>

									<div class="form-group">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" name="remember"
												class="custom-control-input" tabindex="3" id="remember-me">
											<label class="custom-control-label" for="remember-me">记住我</label>
										</div>
									</div>

									<div class="form-group">
										<div id='captcha'></div>
									</div>

									<div class="form-group">
										<button type="button" class="btn btn-primary btn-lg btn-block"
											tabindex="4" id="submit">登陆</button>
									</div>

									<div id="logininfo"class="alert alert-danger" hidden="true"></div>
								</form>
							</div>
						</div>
						<div class="mt-5 text-muted text-center">
							没有帐号？<a href="auth-register_customer.html">注册一个</a>。也可以先不注册<a
								href="#">快速创建订单</a>！
						</div>
						<div class="simple-footer">Copyright &copy; Ch3225, 2022</div>

					</div>
				</div>
			</div>
		</section>
	</div>

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

	<script
		src="https://cdn.dingxiang-inc.com/ctu-group/captcha-ui/index.js"
		crossorigin="anonymous"></script>
	<script>
		var myCaptcha = _dx.Captcha(document.getElementById('captcha'), {
			appId : '8cd26e4a245f1110902ced50d9efc53f', //appId，在控制台中“应用管理”或“应用配置”模块获取
			apiServer : 'https://example.com', // 请填写这个配置，按照下面“接入域名”所示!注意：末尾不要有斜杆！
			success : function(token) {
				// console.log('token:', token)
			}
		})
	</script>

	<script>
		$("#submit").click(function() {
			$.ajax({
				url : 'login',
				type : "POST",
				data : $('#form').serialize(),
				success : function(data) {
					var myArr = JSON.parse(data);
					if (data == "100") {
						window.location.replace("index");
					} else if(data == "101"){
						var element = document.getElementById("logininfo");
						element.innerHTML="您输入的用户名或密码有误";
						element.hidden=false;
					} else if(data == "0"){
						var element = document.getElementById("logininfo");
						element.innerHTML="未知错误";
						element.hidden=false;
					}
				}
			});
		});
	</script>
</body>
</html>