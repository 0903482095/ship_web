<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tra cứu vận đơn</title>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/datatable.min.css">
<link rel="stylesheet" href="../css/boostrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	/* display: flex;
	flex-direction: column; */
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

#map {
	height: 400px;
}
</style>
<body>

	<div class="wrapper">
		<%@ include file="left-menu.jsp"%>
		<div class="mian">
			<form class="search-form"
				action="<%=request.getContextPath()%>/home-shop/search-order"
				method="post">
				<div class="form-group mx-sm-3 mb-2">
					<label for="fee">Mã vận đơn:</label> <input type="text"
						class="form-control" id="order_id" name="order_id">
				</div>
				<div class="form-group mx-sm-3 mb-2">
					<button type="submit" class="btn btn-primary mb-2"
						onclick="initMap()">Tra cứu vận đơn</button>
				</div>
			</form>
			<div id="map" class="mx-sm-3 mb-2"></div>
		</div>
	</div>

	<script>
		var map;
		var x1 = {lat : ${orders.lat1},lng : ${orders.lng1}};
		var x2 = {lat : ${orders.lat2},lng : ${orders.lng2}};
		var x3 = {lat : ${orders.lat3},lng : ${orders.lng3}};

		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 16,
				center : {
					lat : 20.97,
					lng : 105.7
				},
				mapTypeId : 'terrain'
			});

			var flightPathCoordinates = [ x1, x3];

			flightPath = new google.maps.Polyline({
				path : flightPathCoordinates,
				strokeColor : '#FF0000',
				strokeOpacity : 1.0,
				strokeWeight : 2
			});
			
			var marker = new google.maps.Marker({
		          position: x1,
		          map: map,
		          title: 'Điểm đi'
		        });
			
			var marker1 = new google.maps.Marker({
		          position: x2,
		          map: map,
		          title: 'Điểm đến'
		        });
			
			var marker2 = new google.maps.Marker({
		          position: x3,
		          map: map,
		          title: 'Vị trí đơn hàng hiện tại'
		        });
			addLine();
		}
		function addLine() {
			flightPath.setMap(map);
		}

		function removeLine() {
			flightPath.setMap(null);
		}
	</script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8mVhoPgUukaq-KTYnjA2_Noh_jPMt_bU&callback=initMap">
	</script>
</body>
</html>