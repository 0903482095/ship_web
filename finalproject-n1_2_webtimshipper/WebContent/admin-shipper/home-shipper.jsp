<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="css/boostrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.min.js"></script>
        <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD8mVhoPgUukaq-KTYnjA2_Noh_jPMt_bU&libraries=geometry"></script>
        <title>Home Shipper</title>
        <link rel="stylesheet" href="../css/boostrap.min.css">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/datatable.min.css">
        <script src="../js/boostrap.min.js"></script>
        <script src="../js/jquery.min.js"></script>
        <script src="../js/datatable.min.js"></script>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                width: 330px;
                transition: all 300ms cubic-bezier(0.65, 0.05, 0.36, 1);
                will-change: left, width;
                box-shadow: inset -1px 0 10px rgba(0, 0, 0, 0.4);
                background: #293749;
            }

            .mian {
                width: 1580px;
                float: right;
                height: 100%;
            }

            .mian table {
                margin-left: 200px;
            }

            .mian #insert {
                margin-left: 50px;
                margin-top: 200px;
            }

            .mian #pdf {
                margin-left: 30px;
                margin-top: 200px;
            }

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

            .panel {
                background-color: #fcfcfc;
            }

            .panel .btn-group {
                margin: 15px 0 30px;
            }

            .panel .btn-group .btn {
                transition: background-color .3s ease;
            }

            .table-filter {
                background-color: #fff;
                border-bottom: 1px solid #eee;
            }

            .table-filter tbody tr:hover {
                cursor: pointer;
                background-color: #eee;
            }

            .table-filter tbody tr td {
                padding: 10px;
                vertical-align: middle;
                border-top-color: #eee;
            }

            .table-filter tbody tr.selected td {
                background-color: #eee;
            }

            .table-filter tr td:first-child {
                width: 38px;
            }

            .table-filter tr td:nth-child(2) {
                width: 35px;
            }

            .table-filter .star {
                color: #ccc;
                text-align: center;
                display: block;
            }

            .table-filter .star.star-checked {
                color: #F0AD4E;
            }

            .table-filter .star:hover {
                color: #ccc;
            }

            .table-filter .star.star-checked:hover {
                color: #F0AD4E;
            }

            .table-filter .media-photo {
                width: 35px;
            }

            .table-filter .media-body {
                display: block;
                /* Had to use this style to force the div to expand (wasn't necessary with my bootstrap version 3.3.6) */
            }

            .table-filter .media-meta {
                font-size: 11px;
                color: #999;
            }

            .table-filter .media .title {
                color: #2BBCDE;
                font-size: 20px;
                font-weight: bold;
                line-height: normal;
                margin: 0;
            }

            .table-filter .media .title span {
                font-size: .8em;
                margin-right: 20px;
            }

            .table-filter .media .title span.pagado {
                color: #5cb85c;
            }

            .table-filter .media .title span.pendiente {
                color: #f0ad4e;
            }

            .table-filter .media .title span.cancelado {
                color: #d9534f;
            }

            .table-filter .media .summary {
                font-size: 18px;
            }

            .panel-body {
                width: 100%;
                height: 100%;
            }
        </style>
    </head>
    <body>
        <%@ include file="left-menu.jsp"%>
        <div class="mian">
            <section class="content">
                <div class="col-md-8 col-md-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="table-container1">
                                <table class="table table-filter">
                                    <tbody>
                                        <c:forEach items="${orders}" var="order">
                                            <tr data-status="pagado">
                                                <td><a href="javascript:;" class="star"> <i
                                                            class="glyphicon glyphicon-star"></i>
                                                    </a></td>
                                                <td>
                                                    <form action="home-shipper/pick-up" method="post">
                                                        <div class="media" id="test'${order.id}'"></div>
                                                    </form> <script type="text/javascript">

                                                        var lat =<%=session.getAttribute("lat")%>
                                                        var lng =<%=session.getAttribute("lng")%>

                                                        var point_a = new google.maps.LatLng(
                                                                lat, lng);
                                                        var point_b = new google.maps.LatLng(
                                                        ${order.lat1}, ${order.lng1});

                                                        var distance_miles = getDistanceInMiles(
                                                                point_a, point_b);

                                                        if (distance_miles < 10000) {
                                                            var html = '';
                                                            var createdDate = '<div class="media-body"><input type="hidden" name="id" value="${order.id}"/><span class="media-meta pull-right"><c:out value="${order.createdDate}"/></span><h4 class="title">Nội Dung<span class="pull-right pagado"><c:out value="${order.fee}"/>VND</span></h4><p class="summary"><c:out value="${order.content}"/></p><input type="submit" class="btn" value="Nhận đơn"/></div>';
                                                            html += createdDate;
                                                            var res = document.getElementById("test'" +${order.id} + "'");
                                                            res.innerHTML = html;
                                                        }
                                                        function getDistanceInMiles(point_a, point_b) {
                                                            var distance_in_meters = google.maps.geometry.spherical
                                                                    .computeDistanceBetween(
                                                                            point_a,
                                                                            point_b);
                                                            return distance_in_meters * 0.000621371; // convert meters to miles
                                                        }
                                                    </script>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
    </body>
</html>