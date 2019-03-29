<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/boostrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8mVhoPgUukaq-KTYnjA2_Noh_jPMt_bU&libraries=places"></script>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.geocomplete.js"></script>
<title>Đăng ký</title>
<style type="text/css">
body {
	color: #999;
	background: #f5f5f5;
	font-family: 'Roboto', sans-serif;
}

.form-control, .form-control:focus, .input-group-addon {
	border-color: #e1e1e1;
	border-radius: 0;
}

.signup-form {
	width: 390px;
	margin: 0 auto;
	padding: 30px 0;
}

.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	text-align: center;
}

.signup-form .lead {
	font-size: 14px;
	margin-bottom: 30px;
	text-align: center;
}

.signup-form form {
	border-radius: 1px;
	margin-bottom: 15px;
	background: #fff;
	border: 1px solid #f3f3f3;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.signup-form label {
	font-weight: normal;
	font-size: 13px;
}

.signup-form .form-control {
	min-height: 38px;
	box-shadow: none !important;
	border-width: 0 0 1px 0;
}

.signup-form .input-group-addon {
	max-width: 42px;
	text-align: center;
	background: none;
	border-width: 0 0 1px 0;
	padding-left: 5px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	background: #19aa8d;
	border-radius: 3px;
	border: none;
	min-width: 140px;
	outline: none !important;
}

.signup-form .btn:hover, .signup-form .btn:focus {
	background: #179b81;
}

.signup-form a {
	color: #19aa8d;
	text-decoration: none;
}

.signup-form a:hover {
	text-decoration: underline;
}

.signup-form .fa {
	font-size: 21px;
}

.signup-form .fa-paper-plane {
	font-size: 17px;
}

.signup-form .fa-check {
	color: #fff;
	left: 9px;
	top: 18px;
	font-size: 7px;
	position: absolute;
}

.role-options {
	margin-left: 80px;
}
</style>
</head>
<body>
	<div class="signup-form">
		<form action="<%=request.getContextPath()%>/register" method="post"
			enctype="multipart/form-data">
			<h2>Đăng ký</h2>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
						type="text" class="form-control" name="username"
						placeholder="tên đăng nhập" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-paper-plane"></i></span>
					<input type="password" class="form-control" name="password"
						placeholder="mật khẩu" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
						type="text" class="form-control" id="address" name="address"
						placeholder="địa chỉ" required="required">
				</div>
				<div class="add">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="hidden" class="form-control" id="lat" name="lat"
							data-geo="lat" required="required">
					</div>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-lock"></i></span>
						<input type="hidden" class="form-control" id="lng" name="lng"
							data-geo="lng" required="required">
					</div>
				</div>
			</div>
			<div class="role-options">
				<div class="form-check form-check-inline">
					<input class="form-check-input " type="radio" name="role" id="shop"
						value="1" checked> <label class="form-check-label">
						Chủ Shop </label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input " type="radio" name="role"
						id="shipper" value="2"> <label class="form-check-label">
						Shipper </label>
				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block btn-lg">Đăng
					ký</button>
			</div>
		</form>
		<div class="text-center">
			Already have an account? <a href="login.jsp">Login here</a>.
		</div>
	</div>
	<script type="text/javascript">
		function initMap() {
			var input = document.getElementById('address');
			var autocomplete = new google.maps.places.Autocomplete(input);
		}

		$(function() {
			$("#address").geocomplete({
				details : ".add",
				detailsAttribute : "data-geo"
			});
		});
	</script>
	</script>

</body>
</html>