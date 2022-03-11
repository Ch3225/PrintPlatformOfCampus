<%@page import="java.util.Map.Entry"%>
<%@page import="model.item.Order"%>
<%@page import="model.actor.ServiceProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%!
	ServiceProvider provider = ServiceProvider.allServiceProvider.get(0);
%>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="welcome">
			欢迎您，用户<%=provider.getId() %><br />
		</div>
		<div class="filelist">
<%
	for(Order order:Order.allOrder){
		if(provider.equals(order.getServiceProvider())){
%>
			<br />
			此
			<a href="./<%=order.getDocument().location %>" >
				文件
			</a>
			的打印方式是:<br />
<%
	for(Entry<String,String> entry:order.getPrintRule().ruleNameAndRuleValue.entrySet()){
%>
			<%=entry.getKey() %>:<%=entry.getValue() %><br />
<%	
	}
%>
<%
		}
	}
%>
		</div>
	</body>
</html>