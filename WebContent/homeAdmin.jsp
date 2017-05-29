<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/format.css" media="all" />
<link rel="icon" href="picture/favicon.ico" type="image/x-ico"/>

<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
body {
    background-image: url("picture/bg3.jpg");
}
.no-background {
    background-image: url("picture/bg3.jpg");
}
</style>
</head>
<body>
<div class="container">
            <strong><h1>Xin chào quản trị viên!</h1></strong><br>
            <strong><h1>HỆ THỐNG QUẢN LÝ BÁN HÀNG</h1></strong>
            <h2 style = "color: AliceBlue">Công ty TNHH Công nghệ Tin học Phi Long</h2>
            <html:image property="textTag" src="picture/home.jpg"></html:image>
            
			<nav id="bt-menu" class="bt-menu">
				<a href="#" class="bt-menu-trigger"><span>Menu</span></a>
				<ul>
					<li><a href="danh-sach.do" class="bt-icon icon-windows">Hàng hóa</a></li>
					<li><a href="danh-sach-hoa-don.do" class="bt-icon icon-speaker">Hóa đơn</a></li>
					<li><a href="danh-sach-nhan-vien.do" class="bt-icon icon-user-outline">Nhân viên</a></li>
					<li><a href="danh-sachNCC.do" class="bt-icon icon-sun">Đối tác</a></li>
					<li><a href="danh-sachKH.do" class="bt-icon icon-bubble">Khách hàng</a></li>
					<li><a href="thongke.do" class="bt-icon icon-bubble">Thống kê</a></li>
					
					
				</ul>
			</nav>
		</div><!-- /container -->
		<script src="js/classie.js"></script>
<script src="js/borderMenu.js"></script>
</body>
</html>