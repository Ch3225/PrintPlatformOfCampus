<%@page import="pfpsc.constant.RequestMapConstant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="main-sidebar">
	<aside id="sidebar-wrapper">
		<div class="sidebar-brand">
			<a href="index">快印平台</a>
		</div>
		<div class="sidebar-brand sidebar-brand-sm">
			<a href="blank_customer">St</a>
		</div>
		<ul class="sidebar-menu">
			<li class="nav-item"><a href="#" class="nav-link"><i
					class="fas fa-fire"></i><span>简报</span></a></li>
			<li class="nav-item"><a href="getPaperDocument" class="nav-link"><i
					class="far fa-file-alt"></i> <span>取订单</span></a></li>
			<li class="nav-item"><a href="#" class="nav-link"><i
					class="fas fa-dollar-sign"></i><span>充值</span></a></li>
			<li class="nav-item"><a href="#" class="nav-link"><i
					class="fas fa-dollar-sign"></i><span>口令</span></a></li>
					
		</ul>
		<div class="mt-4 mb-4 p-3 hide-sidebar-mini">
			<a href="javascript:newOrder();"
				class="btn btn-primary btn-lg btn-block btn-icon-split"> <i
				class="fas fa-rocket"></i> 创建订单！
			</a>
		</div>
		<script>
			function newOrder() {
				$.ajax({
					url : "<%= RequestMapConstant.createOrder %>",
					type : "POST",
					success : function(data) {
						var myArr = JSON.parse(data);
						if (data != 0) {
							window.location.replace("<%= RequestMapConstant.order_step1 %>");
						}
					}
				});
			}
		</script>
	</aside>
</div>