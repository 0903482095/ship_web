<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Home Shop</title>
        <link rel="stylesheet" href="../css/boostrap.min.css">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/datatable.min.css">
        <script src="../js/boostrap.min.js"></script>
        <script src="../js/jquery.min.js"></script>
        <script src="../js/datatable.min.js"></script>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

        .mian table {
            margin-left: 50px;
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
    </style>
    <body>
        <div class="wrapper">
            <%@ include file="left-menu.jsp"%>
            <div class="mian">

                <table class="table">
                    <button type="button" id="insert" class="btn"
                            onclick="forwardToInsert()">Đăng tin</button>
                    <button type="button" id="pdf" class="btn" onclick="viewPDF()">PDF</button>
                    <thead>
                        <tr>
                            <th>Mã vận đơn</th>
                            <th>Nội dung</th>
                            <th>Điểm nhận hàng</th>
                            <th>Điểm giao hàng</th>
                            <th>Cước phí</th>
                            <th>Ngày đăng</th>
                            <th>Trạng thái</th>
                            <th>Công cụ</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${orders}" var="order">
                            <tr>
                                <td><c:out value="${order.id}" /></td>
                                <td><c:out value="${order.content}" /></td>
                                <td><c:out value="${order.lat1}" /></td>
                                <td><c:out value="${order.lat2}" /></td>
                                <td><c:out value="${order.fee}" /></td>
                                <td><c:out value="${order.createdDate}" /></td>
                                <td><c:if test="${order.status == 1}">
                                        <c:out value="thành công" />
                                    </c:if> <c:if test="${order.status == 2}">
                                        <c:out value="đang xử lý" />
                                    </c:if></td>
                                <td><a
                                        href="<c:url value="/home-shop/edit?id=${order.id}"/>"><i
                                            class="fa fa-edit"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script type="text/javascript">
            function forwardToInsert() {
                location.href = "http://localhost:8080/WebApp-Ship/home-shop/insert";
            }

            function viewPDF() {
                location.href = "http://localhost:8080/WebApp-Ship/home-shop/pdf";
            }
        </script>
    </body>
</html>