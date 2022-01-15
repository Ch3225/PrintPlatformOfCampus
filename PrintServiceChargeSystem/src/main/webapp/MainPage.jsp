<%@page import="java.util.Set"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="model.item.PrintRule"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>快速打印</title>
</head>
<body>
	<form action="OrderGenerateServlet" name="ServiceForm" method="post">
<%
	for(Entry<String,Set<String>> entry: PrintRule.keyWordList.entrySet() ){
%>
		<%= entry.getKey() %>:
<%
		for(String item:entry.getValue()){
%>
			<input type="radio" name=<%=entry.getKey() %> value=<%=item %>><%=item %>
<%
		}
%>
		<br />
<%		
	}
%>
		<input type="submit" name="submit" />
	</form>
</body>
</html>