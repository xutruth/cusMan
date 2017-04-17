<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XXX客户关系管理系统</title>
</head>
<body style="text-align: center;">
    <h2>XXX客户关系管理系统</h2>
    <br/>

                                                                     <!-- target="main"意思是结果显示到name为main的frame中  -->
    <a href="${pageContext.request.contextPath }/AddCustomerServlet" target="main">添加客户</a>
    <a href="${pageContext.request.contextPath }/ListCustomerServlet" target="main">查看客户</a>
</body>
</html>