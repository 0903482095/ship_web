<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Đăng tin</title>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/datatable.min.css">
<link rel="stylesheet" href="../css/boostrap.min.css">
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8mVhoPgUukaq-KTYnjA2_Noh_jPMt_bU&libraries=places"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.geocomplete.js"></script>


</head>
<style>
body {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
	background: #ffffff;
}

.main_sidebar {
	min-height: 100vh;
	position: fixed;
	top: 0;
	left: 0;
	width: 350px;
	transition: all 300ms cubic-bezier(0.65, 0.05, 0.36, 1);
	will-change: left, width;
	box-shadow: inset -1px 0 10px rgba(0, 0, 0, 0.4);
	background: #293749;
}

.mian {
	width: 1570px;
	float: right;
	height: 100%;
}

.mian form {
	margin-left: 50px;
	margin-top: 200px;
}

.main_sidebar:after {
	content: '';
	background-color: #253238;
	position: absolute;
	top: 0;
	z-index: -1;
	height: 100%;
	width: 58px;
}

.main_sidebar ul {
	list-style: none;
	padding-left: 58px;
}

.main_sidebar ul li {
	padding: 10px;
}

.main_sidebar ul li a {
	color: #fff;
	display: block;
}

.main_sidebar ul li i {
	float: left;
	color: grey;
	margin-left: -58px;
	font-size: 24px;
	padding-left: 7px;
}

.main_sidebar ul li:hover {
	background: #167696;
}

.main_sidebar ul li a:hover {
	color: #fff;
	text-decoration: none;
}

.main_sidebar ul li:hover i {
	color: #fff;
}

.main_sidebar ul li.active {
	background: #0f4698;
}

.main_sidebar ul li.active i {
	color: #fff;
}

.main_sidebar ul li.active:hover {
	background: #167696;
}

.main_sidebar ul li.active:hover i {
	color: #fff;
}

.main {
	float: right;
	color: #fff;
	display: block;
	width: 100%;
	background: red;
	min-height: 100vh;
}

.profile {
	height: 250px;
}

.profile img {
	width: 150px;
	height: 150px;
	border-radius: 100%;
	align-items: center;
	margin-left: 120px;
	margin-top: 50px;
}

.profile span {
	color: #ffffff;
	margin-left: 170px;
	font-size: 30px;
}
</style>
<body>
	<div class="wrapper">
		<%@ include file="left-menu.jsp"%>
		<div class="mian">
			<form action="<%=request.getContextPath()%>/home-shop/insert"
				method="post">
				<div class="form-group mx-sm-3 mb-2">
					<label for="content">Content:</label>
					<textarea class="form-control" rows="5" id="content" name="content"></textarea>
				</div>
				<div class="form-group mx-sm-3 mb-2">
					<label for="from-add">Điểm nhận hàng:</label> <input type="text"
						class="form-control" id="from-add" name="fromAdd">
				</div>
				<div class="from-add">
					<div class="form-group">
						<input type="hidden" data-start="lat" class="form-control"
							id="lat1" name="lat1">
					</div>
					<div class="form-group">
						<input type="hidden" data-start="lng" class="form-control"
							id="lng1" name="lng1">
					</div>
				</div>
				<div class="form-group mx-sm-3 mb-2">
					<label for="to-add">Điểm giao hàng:</label> <input type="text"
						class="form-control" id="to-add" name="toAdd">
				</div>
				<div class="to-add">
					<div class="form-group">
						<input type="hidden" date-end="lat" class="form-control" id="lat2"
							name="lat2">
					</div>
					<div class="form-group">
						<input type="hidden" date-end="lng" class="form-control" id="lng2"
							name="lng2">
					</div>
				</div>
				<div class="form-group mx-sm-3 mb-2">
					<label for="fee">Cước phí:</label> <input type="text"
						class="form-control" id="fee" name="fee">
				</div>
				<div class="form-group mx-sm-3 mb-2">
					<button type="submit" class="btn btn-primary mb-2">Đăng
						tin</button>
				</div>

			</form>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("#from-add").geocomplete({
				details : ".from-add",
				detailsAttribute : "data-start"
			});

			$("#to-add").geocomplete({
				details : ".to-add",
				detailsAttribute : "data-end"
			});
		});
	</script>
</body>
</html>