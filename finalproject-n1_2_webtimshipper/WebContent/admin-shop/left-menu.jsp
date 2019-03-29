<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<aside class="main_sidebar">
	<div class="profile">
		<img src="../images/avt_youtube.jpg" /><br> <span><%=session.getAttribute("current_user")%></span>
	</div>
	<ul>
		<li class="active"><i class="fa fa-home"></i><a href="#">Trang
				chủ</a></li>
		<li><i class="fa fa-edit"></i><a
			href="<%=request.getContextPath()%>/home-shop/insert">Đăng tin</a></li>
		<li><i class="fa fa-search"></i><a href="<%=request.getContextPath()%>/home-shop/search-order">Tra cứu vận đơn</a></li>
		<li><i class="fa fa-file"></i></i><a href="#">Thống kê</a></li>
		<li><i class="fa fa-arrow-down"></i><a
			href="<%=request.getContextPath()%>/home-shop/excel">Báo cáo</a></li>
		<li><i class="fa fa-power-off"></i><a
			href="<%=request.getContextPath()%>/logout">Đăng xuất</a></li>
	</ul>
	</aside>
</body>
</html>