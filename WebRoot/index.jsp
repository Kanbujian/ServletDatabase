<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body{font-family:"微软雅黑"}；
	</style>
  </head>
  
  <body>
    
<br>
		<div align="center">
		<h2>添加图书信息</h2>
		<form action="AddBook.jsp" method="post" >
		    名      称：<input type="text" name="name"/><br><br>
		    价      格：<input type="text" name="price"/><br><br>
		    数      量：<input type="text" name="bookCount"/><br><br>
		    作      者：  <input type="text" name="author"/><br><br>
		  <input type="submit" value="添加" >
		  </form>
		  <a href="servlet/FindServlet">查看所有图书</a>
		</div>
  </body>
</html>
